var http = require('http');
const axios = require('axios');

var options = {
    host: 'localhost',
    port: 3000,
    path: '/student',
    headers: { 'Content-Type': 'text/json' }
};

const getStudents =
    async (req, res, next) => {
        let body = '';
        await http.get(options, (resp) => {
            resp.on('data', (chunk) => {
                body += chunk;
            });
            resp.on("end", () => {
                res.write(body);
                res.end();
            });
        }).on("error", function (e) {
            console.log("Got error: " + e.message);
        });
    };

const studentById = async (request, response, next) => {
    try {
        const result = await axios.get(`http://localhost:3000/student/${request.params.studentId}`);
        response.status(200).json(result.data);
    } catch (error) {
        response.status(401).json({ message: error.error });
    }
}

const addStudent = async (request, response, next) => {
    try {
        const student = request.body;        
        const result = await axios.post(`http://localhost:3000/student`,student);
        response.status(200).json(result.data);
    } catch (error) {
        response.status(401).json({ message: error.error });
    }
}

module.exports = {
    getStudents,
    studentById,
    addStudent
}