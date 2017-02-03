var express = require('express');
var path = require('path');
var favicon = require('serve-favicon');
var logger = require('morgan');
var cookieParser = require('cookie-parser');
var bodyParser = require('body-parser');
var mongoose = require('mongoose');
var session = require('express-session');
var MongoStore = require('connect-mongo')(session);
var mongoUrl = 'mongodb://localhost/test';

var routes = require('./routes/index');
var users = require('./routes/users');
var board = require('./routes/board');
var signup = require('./routes/signup');
var res = require('./routes/reservation');

var app = express();
var http = require('http');
var server = http.createServer(app);

app.set('port',4000);
server.listen(app.get('port'));
console.log('서버가 '+app.get('port')+'번 포트에서 실행중');
module.exports = app;


// view engine setup
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'ejs');

// uncomment after placing your favicon in /public
//app.use(favicon(path.join(__dirname, 'public', 'favicon.ico')));
app.use(logger('dev'));
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
app.use(cookieParser());
app.use(express.static(path.join(__dirname, 'public')));


app.use(session({
    secret: '@#@$MYSIGN#@$#$',
    store: new MongoStore({
        url:mongoUrl,
        ttl:60*60*24*7
    })
}));


app.use('/', routes);
app.use('/users', users);
app.use('/board', board);
app.use('/write', board);
app.use('/signup', signup);
app.use('/res', res);


// catch 404 and forward to error handler
app.use(function(req, res, next) {
  var err = new Error('Not Found');
  err.status = 404;
  next(err);
});

// error handlers

// development error handler
// will print stacktrace
if (app.get('env') === 'development') {
  app.use(function(err, req, res, next) {
    res.status(err.status || 500);
    res.render('error', {
      message: err.message,
      error: err
    });
  });
}

// production error handler
// no stacktraces leaked to user
app.use(function(err, req, res, next) {
  res.status(err.status || 500);
  res.render('error', {
    message: err.message,
    error: {}
  });
});


module.exports = app;
