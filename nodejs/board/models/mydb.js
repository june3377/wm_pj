var mysql = require('mysql');

var pool = mysql.createPool({
    connectionLimit: 10,
    user: 'root',
    password: '1234',
    database: 'washer'
});


module.exports = pool;