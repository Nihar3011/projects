

function calculate(x) {
    return new Promise(resolve => {
        setTimeout(() => {
            resolve(x * 2);
        }, 1000);
    });
}


var index = async (req, res, next) => {
    var sum = await calculate(2) + await calculate(6) + await calculate(8);
    res.status(200).json(sum);

}

module.exports = {
    index
}