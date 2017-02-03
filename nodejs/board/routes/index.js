var express = require('express');
var router = express.Router();
var pool = require('../models/mydb');


/* GET home page. */
router.get('/', function (req, res, next) {
    sess = req.session;

    pool.getConnection(function (err, connection) {
        // Use the connection
        var sqlForSelectList = "SELECT wh_no,user_id,wh_code,wh_time FROM washer";
        connection.query(sqlForSelectList, function (err, rows) {
            if (err) console.error("err : " + err);
            res.render('index', {washer: ' 세탁기 목록', rows: rows, sess: sess});
            connection.release();
        });
    });
});

router.get('/logout', function (req, res, next) {
    sess = req.session;
    if (sess.user_id) {
        req.session.destroy(function (err) {
            if (err) {
                console.log(err);
            } else {
                res.send('<script>alert("로그아웃 되었습니다.");location.href="/"</script>');
            }
        })
    } else {
        res.redirect('/');
    }
});

module.exports = router;
