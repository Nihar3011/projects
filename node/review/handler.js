var querystring=require('querystring');

function home(res) {
    var htmlFile=`<!DOCTYPE html>
    <html>
    <head>
        <meta charset='utf-8'>
        <meta http-equiv='X-UA-Compatible' content='IE=edge'>
        <title>Page Title</title>
        <meta name='viewport' content='width=device-width, initial-scale=1'>
    </head>
    <body>
        <form action="/review" method="post">
            Name:<input type="text">
            Stars:<input type="number">
            <input type="submit">
        </form>
    </body>
    </html>`;
    res.writeHead(200,{"contentType":"text/html"});
    res.write(htmlFile);
    res.end();
}

function review(res,reviewData) {
   
    console.log("review"+reviewData);
    res.writeHead(200,{"contentType":"text/plain"});
    res.write("your review is"+ querystring.parse(reviewData).text);
    res.end();
}

exports.home=home;
exports.review=review;