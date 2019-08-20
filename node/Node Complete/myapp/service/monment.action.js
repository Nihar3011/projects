var moment = require('moment')

var index = async (req, res, next) => {

    //    console.log(moment().format());
    //    console.log(moment(undefined));
    //    console.log(moment([2010, 1, 14, 15, 25, 50, 125]));
    //    console.log(moment.utc([2010, 1, 14, 15, 25, 50, 125]));
    //    console.log(moment.duration('7.23:59:59.999'));
    var a = moment("1997-11-30", "YYYY-MM-DD");
    var b = moment().format("YYYY-MM-DD");
    console.log(a.diff(b, 'days') + 1);
    console.log(moment.duration(a.diff(b)).asYears());



    res.send("IN MOMENT");
}


module.exports = {
    index
}