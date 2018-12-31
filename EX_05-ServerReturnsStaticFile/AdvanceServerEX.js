const express = require('express');
const app = express();
const fs = require('fs');

app.get('/files/:fileName', function(req, res) {
    let file_name = req.params['fileName']; 

    if (fs.existsSync(`./files/${file_name}`)) { // returns boolean true if a file exists in the folder.
        const StreamReader = fs.createReadStream(`./files/${file_name}`); // creates a readstream.
        StreamReader.pipe(res); // pipes the file to result.
       
    } else {
     res.end(`file "${file_name}" does not exist :(`); // writes a string to localhost:8080.
     
    }
});

app.listen(8080, () => {
    console.log("Listening to localhost:8080");
})