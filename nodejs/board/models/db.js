var mongoose = require('mongoose');
var uri = 'mongodb://localhost/test';
var options = {
    "server" :{
        "poolSize" : 100
    }
};
var db = mongoose.createConnection(uri, options);

db.on('error', function (err) {
    if(err) console.error('db conn err', err);
});

db.once('open', function callback() {
    console.info('Mongo conn successfully');
});

module.exports = db;