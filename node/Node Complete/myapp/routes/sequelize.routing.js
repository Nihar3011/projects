var express = require('express');
var router = express.Router();

const { index,
    addStudent,
    getStudents,
    getStudent,
    deleteStudent,
    updateStudent } = require('../service/sequelize.action');

router.get('/', index);
router.post('/students', addStudent);
router.get('/students', getStudents);
router.get('/students/:studentId', getStudent);
router.delete('/students/:studentId', deleteStudent);
router.put('/students/:studentId', updateStudent);
module.exports = router
