var mongoose = require('mongoose');
var db = require('../models/db');
var autoIncrement = require('mongoose-auto-increment');
autoIncrement.initialize(db);

var CommentSchema = new mongoose.Schema({ // 스키마정의
    "id" : String,
    "content" : String,
    "regdate" : {
    "type" : Date,
    "default" : Date.now
},
"passwd" : String
});

CommentSchema.plugin(autoIncrement.plugin, //auto increment 사용, filed를 num으로 정의, 시작값, 증분값 설정
    { "model" : 'Comment' , "field" : 'no', "startAt" : 1, "incrementBy" : 1});

var Comment = mongoose.model('Comment', CommentSchema); //모델화

module.exports = Comment;
