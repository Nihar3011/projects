const { create, getAll, getOne, deleteOne, update } = require('../model/student.model')
const { validate, StudentSchema } = require('../utils/schema');

var index = async (req, res, next) => {
    res.send("IN seq");
}

const addStudent = async (req, res, next) => {
    validate(req.body, StudentSchema, async (error, value) => {
        if (error) {
            next(error);
        } else {
            let {
                rollno,
                name,
                name1,
                gender,
                mobile
            } = req.body;

            let result = await create({
                rollno: rollno,
                name: name,
                name1: name1,
                gender: gender,
                mobile: mobile
            })

            if (result) {
                res.status(200).json('data added');
            } else {
                let error = new Error();
                error.code = 'Error !!!';
                next(error);
            }
        }

    })


}

const getStudents = async (req, res, next) => {

    let result = await getAll();

    if (result) {
        res.status(200).json(result);
    } else {
        let error = new Error();
        error.code = 'Error !!!';
        next(error);
    }

}
const getStudent = async (req, res, next) => {

    let result = await getOne(req.params.studentId);

    if (result) {
        res.status(200).json(result);
    } else {
        let error = new Error();
        error.code = 'Error !!!';
        next(error);
    }

}

const deleteStudent = async (req, res, next) => {

    let result = await deleteOne(req.params.studentId);

    if (result) {
        res.status(200).json("Deleted" + result);
    } else {
        let error = new Error();
        error.code = 'Error !!!';
        next(error);
    }

}

const updateStudent = async (req, res, next) => {
    validate(req.body, StudentSchema, async (error, value) => {
        if (error) {
            next(error);
        } else {

            let {
                rollno,
                name,
                name1,
                gender,
                mobile
            } = req.body;

            let result = await update({
                rollno: rollno,
                name: name,
                name1: name1,
                gender: gender,
                mobile: mobile
            }, req.params.studentId)

            if (result) {
                res.status(200).json("update" + result);
            } else {
                let error = new Error();
                error.code = 'Error !!!';
                next(error);
            }
        }
    
    })
}

module.exports = {
            index,
            addStudent,
            getStudents,
            getStudent,
            deleteStudent,
            updateStudent
        }