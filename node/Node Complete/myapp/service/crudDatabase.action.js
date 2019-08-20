const Pool = require('pg').Pool

const pool = new Pool({
    user: 'postgres',
    host: 'localhost',
    database: 'postgres',
    password: 'root',
    port: 5432,
})

var index =  (req, res, next) => {
    res.send("in crudDabase");
}

var getStudent =  (req, res, next) => {

    pool.query('SELECT * FROM students ORDER BY id ASC', (error, results) => {
        if (error) {

            next(error);
        }
        res.locals.data=results.rows;
        next();
    })
}

var getStudentById =  (req, res, next) => {

    pool.query(`SELECT * FROM students where id=$1 ORDER BY id ASC`, [req.params.studentId], (error, results) => {
        if (error) {
            throw error;
        }
        res.status(200).json(results.rows)
    })
}

var addStudent =  (req, res, next) => {

    const { firstname, lastname, mobile, email, password } = req.body

    pool.query(`INSERT into students (firstname,lastname,mobile,email,password
        ) values ($1,$2,$3,$4,$5)`, [firstname, lastname, mobile, email, password], (error, results) => {
            if (error) {
                throw error;
            }
            res.status(200).json(results);
        })
}

var deleteStudentById =  (req, res, next) => {

    pool.query(`DELETE FROM students where id=$1 `, [req.params.studentId], (error, results) => {
        if (error) {
            throw error;
        }
        res.status(200).json(results.rows)
    })
}

module.exports = {
    index,
    getStudent,
    getStudentById,
    addStudent,
    deleteStudentById
}