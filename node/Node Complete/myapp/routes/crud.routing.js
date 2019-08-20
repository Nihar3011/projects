var express = require('express');
var router = express.Router();

const { getStudents, studentById, addStudent } = require('../service/crud.action');

router.get('/', getStudents);
router.get('/:studentId', studentById);
router.post('/add', addStudent)

module.exports = router;