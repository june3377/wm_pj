var express = require('express');
var router = express.Router();
var pool = require('../models/mydb');


/* GET home page. */
router.get('/', function (req, res, next) {
    sess = req.session;

    pool.getConnection(function (err, connection) {
        // Use the connection
        var sqlForSelectList = "SELECT res_no, wh_no, user_id, res_at FROM reservation";
        connection.query(sqlForSelectList, function (err, rows) {
            if (err) console.error("err : " + err);
            res.render('index', {});
            connection.release();
        });
    });
});


module.exports = router;
