var express = require('express');
var pool = require('../models/mydb');
var router = express.Router();

router.get('/', function (req, res, next) {
    res.render('signup2');
});

router.post('/', function (req, res, next) {
    var sqlquery = 'select count(*)as cnt from user where user_id = ?';
    var sqlForSelectList = 'insert into user (user_id,user_pw,user_name,user_room,user_hp) values(?,?,?,?,?)';
    var id = req.body.user_id;
    var pw = req.body.user_pw;
    var name = req.body.user_name;
    var room = req.body.user_room;
    var hp = req.body.user_hp;

    pool.getConnection(function (err, connection) {
        // Use the connection
        connection.query(sqlquery, id, function (err, rows) {
            if (rows[0].cnt != 1 && !err) {
                connection.query(sqlForSelectList, [id, pw, name, room, hp], function (err, rows) {
                    if (err) console.error("err : " + err);
                    console.log("rows : " + rows);
                    res.send('<script>alert("회원가입 되었습니다.");location.href="/"</script>');
                    // Don't use the connection here, it has been returned to the pool.
                });
            } else {
                res.send('<script>alert("중복 회원입니다.");location.href="/signup"</script>');
            }
            connection.release();
        });
    });
});

module.exports = router;
