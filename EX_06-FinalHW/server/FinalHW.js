const KEY = '818UHWO1AT4CI0LS'; // key for alpha vantage.
const alpha = require('alphavantage')({ key: KEY });


const express = require('express');
const app = express();
const server = require('http').createServer(app);
const io = require('socket.io')(server);


io.on('connection', socket => {// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

    console.log("user connected to server!!!"); // test1
    
    // when connecting, the client will get a notification. 
    //io.emit('userConnected', console.log("enter a share company in the text box please"));

    // when the client emits 'Share Company' this executses.
    socket.on('ShareCompany', company => {
        // Interval set to 15 sec.
        setInterval(() => {
            alpha.data.batch(`${company}`).then(priceValue => { // AAPL- apple share company. @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                let sharePriceValue = `${company} -> ${priceValue['Stock Quotes'][0]['2. price']}`;
                console.log(sharePriceValue); // test2

              // sends the company share value to everyone listening to this port including the client.
		        io.emit('userSharedACompany', {
                     Company : `${company}`,
                     Value : sharePriceValue
                }); 
            })
            .catch(err => {
                console.error("Error: " + err);
            });
        }, 15000);
	});
  }); // @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

server.listen(3000);
console.log("listening on port 3000");

