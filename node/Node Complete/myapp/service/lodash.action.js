const _ = require("lodash");

words = ['sky', 'wood', 'forest', 'falcon',
    'pear', 'ocean', 'universe'];




var index = async (req, res, next) => {
    // console.log(_.chunk(words, 2));
    // console.log(_.first(words));
    // console.log(_.slice(words, 2, 6));
    
    
    // var foo = { a: "a property" };
    // var bar = { b: 4, c: "an other property" }

    // var result = _.assign({ a: "an old property" }, foo, bar);
    // console.log(result);
    var result = _.times(5, ()=>{
        return Math.round(Math.random() * 100);
    });
    res.send(result);
}

module.exports = {
    index
}