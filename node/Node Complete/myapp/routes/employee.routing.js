var express = require('express');
var router = express.Router();

const { index, addEmployee, getEmployee 
    ,addEmps ,addprojectemployee,getEmployeeById } = require('../service/employee.action');

router.get('/', index);
router.post('/employee', addEmployee);
router.get('/employee/:employeeId', getEmployeeById);
router.post('/employees', addEmps);
router.get('/employees',getEmployee);
router.post('/projectemployee',addprojectemployee);

module.exports = router
