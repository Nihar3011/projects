const { add, getById,addprojectemployees,addEmployees ,getAllWithProject } = require('../model/employee.model');

const index = async (req, res, next) => {
    res.send("IN employee");
}

const addEmployee = async (req, res, next) => {

    let {
        name,
        gender,
        mobiles,
        address,
    } = req.body;

    let result = await add({
        name: name,
        gender: gender,
        mobiles:mobiles,
        address: address
    })

    if (result) {
        res.status(200).json('data added');
    } else {
        let error = new Error();
        error.code = 'Error !!!';
        next(error);
    }

}

const getEmployee = async (req, res, next) => {

    let result = await getAllWithProject();

    if (result) {
        res.status(200).json(result);
    } else {
        let error = new Error();
        error.code = 'Error !!!';
        next(error);
    }

}

const addEmps =async (req, res, next) => {

    let {
       employees,
    } = req.body;

    let result = await addEmployees({
        employees:employees,
    })

    if (result) {
        res.status(200).json('data added');
    } else {
        let error = new Error();
        error.code = 'Error !!!';
        next(error);
    }

}

const addprojectemployee =async (req, res, next) => {
    
    let {
        emps,
        project
     } = req.body;
 
    let result = await addprojectemployees({
        emps:emps,
        project:project
    });

    if (result) {
        res.status(200).json('data added');
    } else {
        let error = new Error();
        error.code = 'Error !!!';
        next(error);
    }
}

const getEmployeeById = async (req, res, next) => {

    let result = await getById(req.params.employeeId);

    if (result) {
        res.status(200).json(result);
    } else {
        let error = new Error();
        error.code = 'Error !!!';
        next(error);
    }

}


module.exports = {
    index, addEmployee, getEmployee,addEmps,addprojectemployee,getEmployeeById
}