function route(handle,pathname,res,reviewData){
    if(typeof handle[pathname]=== 'function' ){
        handle[pathname](res,reviewData);
    }else{
        res.writeHead(404,{"contentType":"text/pain"});
        res.write("ERROR")
        res.end();
    }
}

exports.route=route;