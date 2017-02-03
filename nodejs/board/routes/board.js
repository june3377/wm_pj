var express = require('express');
var router = express.Router();
var db = require('../models/db');
require('../models/boardmodel');
var CommentModel = db.model('Comment');

router.get('/',function (req,res,next){
    res.render('index',{title:'Board start'});
});

router.get('/comment',function (req,res,next){
    res.render('writeform');
});

router.get('/list', function (req, res, next) {
    res.redirect('/board/list/1');
});

router.get('/list/:page', function (req, res, next) {
    sess = req.session;
    var page = req.params.page;

    page = parseInt(page, 10);

    CommentModel.count(function (err, cnt) {
        var size = 10; // 한 페이지에 보여줄 개수
        var begin = (page - 1) * size; // 시작 글
        var totalPage = Math.ceil(cnt / size); // 전체 페이지의 수 (75 / 10 = 7.5(X) -> 8(O))
        var pageSize = 10; // 페이지 링크의 개수

// 1~10페이지는 1로, 11~20페이지는 11로 시작되어야하기 때문에 숫자 첫째자리의 수를 고정시키기 위한 계산법
        var startPage = Math.floor((page-1) / pageSize) * pageSize + 1;
        var endPage = startPage + (pageSize - 1);

        if(endPage > totalPage) {
            endPage = totalPage;
        }

// 전체 글이 존재하는 개수
        var max = cnt - ((page-1) * size);
        CommentModel.find({}).sort({regdate:-1}).skip(begin).limit(size).exec(function (err, docs) {
            if (err) console.error('err', err);
            /*console.log('docs', docs);*/
            for(i in docs){
                if(docs[i].content.length>200){
                    docs[i].content = docs[i].content.substr(0,200)+"...";
                }
            }
//res.json({"result" : docs});

//console.log(B);

            var data = {
                "sess":sess,
                "title" : "게시판 리스트",
                "data" : docs,
                "page" : page,
                "pageSize" : pageSize,
                "startPage" : startPage,
                "endPage" : endPage,
                "totalPage" : totalPage,
                "max" : max
            };
            /*console.log(data);*/
            res.render("list", data);
    });
});
});

router.post('/comment', function (req, res, next) {
    var id = req.body.id;
    var content = req.body.content;
    var passwd = req.body.pwd;
    var Comment = new CommentModel({
        "id" : id,
        "content" : content,
        "passwd" : passwd
    });

    Comment.save(function (err, doc) {
        if (err) console.error('err', err);
        /*console.log("doc", doc);*/
        /*res.json(doc);*/
        res.redirect('/board/list');
    });

});


module.exports = router;
