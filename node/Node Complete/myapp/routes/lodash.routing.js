var express = require('express');
var router = express.Router();

const { index } = require('../service/lodash.action');

router.get('/', index);

module.exports = router
