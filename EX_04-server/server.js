const http = require('http');

let server = http.createServer(function(request, response) {
     response.writeHead(200);
     
     let url = request.url;
     let host = request.headers.host;
     
     response.write("http://" + host + url);
     response.end();
});
server.listen(8080);
console.log("server is in process, please check your browser and listen to localhost:8080");