var express = require('express');
var router = express.Router();

const { sortArray } = require('../service/arrays.action')


router.get('/', sortArray);
module.exports = router
