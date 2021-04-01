const http = require('http');
const port = 3000;
const app = http.createServer(
    (req, res) => {
        res.setHeader('Content-Type', 'text/html');
        res.write('<h1>Hello World!</h1>');
        res.end();
        console.log(`server started at http://localhost:${port}`);
    }
);

app.listen(port);