const http = require('http');
const port = 3000;

const mexp = require('math-expression-evaluator');

let exp = "2+2/2"
let value = mexp.eval(exp);

const app = http.createServer(
    (req, res) => {
        res.setHeader('Content-Type', 'text/html');
        res.write(`<h1>${exp} = ${value}</h1>`);
        res.end();
        console.log(`server started at http://localhost:${port}`);
    }
);

app.listen(port);
