const express = require('express');
const bodyParser = require('body-parser');

const app = express();
var array = ['abc', 'xyz', 'pqr','pqr','abc'];

var sortstring = function (a, b) {
    a = a.toLowerCase();
    b = b.toLowerCase();
    if (a > b) return 1;
    if (a < b) return -1;
    return 0;
}

function sort(array){
for (let i = 0; i < array.length; i++) {
    for (let j = i; j < array.length; j++) {
        if (sortstring(array[i], array[j]) == 1) {
            temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }
}
}

app.get('/', (req, res) => {
    array.sort(sortstring);
    res.send(array)
});
app.listen(3000);
