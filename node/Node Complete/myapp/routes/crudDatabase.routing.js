var express = require('express');
var router = express.Router();

const { index, getStudent, getStudentById,
     addStudent,deleteStudentById } = require('../service/crudDatabase.action');

router.all('/*',(req,res,next)=>{
     console.log("IN CRUD DATABASE FILTER");
     next();
});
router.get('/', index);
router.get('/getstudents', getStudent);
router.get('/getstudent/:studentId', getStudentById);
router.delete('/delete/:studentId', deleteStudentById);
router.post('/addstudent', addStudent);

module.exports = router
