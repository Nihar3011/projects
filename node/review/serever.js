var http = require('http');
var url = require('url');

function startServer(route, handle) {
    function onRequest(req, res) {
        var reviewData = "";
        var pathname = url.parse(req.url).pathname;
        if (req.method === 'POST') {
            req.setEncoding('utf8');
            // console.log(req);
            req.on('data', (chunk) => {
                reviewData += chunk;
                console.log("%%%%%%%%%" + reviewData);
            });
            req.on("end", () => {

                console.log("**************" + reviewData);
                route(handle, pathname, res, reviewData);
            });
        }
        route(handle, pathname, res, reviewData);
    }
    http.createServer(onRequest).listen(8000);
}
exports.startServer = startServer;