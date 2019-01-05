const KEY = '818UHWO1AT4CI0LS'; // key for alpha vantage.
const alpha = require('alphavantage')({ key: KEY });

// @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
// setInterval(() => {
//     alpha.data.batch(['AAPL']).then(data => {
//       console.log(`AAPL -> ${data['Stock Quotes'][0]['2. price']}`);
//     //console.log(data);
//      })
//     .catch(err => {
//         console.error("Error: " + err);
//     });
// }, 2000);


const express = require('express');
const app = express();
const server = require('http').createServer(app);
const io = require('socket.io')(server);



io.on('connection', socket => {
    // when the client emits 'Share Company' this executses.
    socket.on('Share Company', company => {
        // Interval set to 15 sec.
        setInterval(() => {
            alpha.data.batch(`${company}`).then(priceValue => { // AAPL- apple share company. @@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
                let sharePriceValue = `${company} -> ${priceValue['Stock Quotes'][0]['2. price']}`;
                console.log(sharePriceValue);

              // sends the company share value to the client.
		        socket.broadcast.emit('Share Company', {
                    // Company name : `${company}`,
                    // Share Price Value : socket. sharePriceValue
                });
            })
            .catch(err => {
                console.error("Error: " + err);
            });
        }, 15000);
	});
  });

server.listen(3000);





