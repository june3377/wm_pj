var express = require('express');
var pool = require('../models/mydb');
var session = require('express-session');

var router = express.Router();


router.post('/', function (req, res, next) {
    pool.getConnection(function (err, connection) {
        var sess = req.session;
        var id = req.body.user_id;
        var pw = req.body.user_pass;

        var sqlForSelectList = 'SELECT * FROM user where user_id = ? and user_pw = ?';
        var sql = "SELECT wh_no,user_id,wh_code,wh_time FROM washer";

        connection.query(sqlForSelectList, [id, pw], function (err, rows) {

            console.log("rows : " + rows);
            if (err || rows == '') console.error("err : " + err);

            if (rows != '') {
                sess.user_id = rows[0].user_id;
                sess.user_name = rows[0].user_name;
                sess.user_room = rows[0].user_room;
                console.log('세션값' + sess.user_id + sess.user_name + sess.user_room);
            } else {
                res.send('<script>alert("아이디나 비밀번호가 일치하지 않습니다.");location.href="/";</script>');
            }
                connection.query(sql, function (err, rows) {
                    if (err) console.error("err : " + err);

                    res.render('index', {title: 'Express', sess: sess, rows: rows});
                });
            connection.release();
            // Don't use the connection here, it has been returned to the pool.
        });
    });
});


module.exports = router;
