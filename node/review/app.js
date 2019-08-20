var server=require("./serever");
var router=require("./router");
var handler=require("./handler");

var handle={};
handle["/home"]=handler.home;
handle["/review"]=handler.review;
handle["/"]=handler.home;
server.startServer(router.route,handle);