const Sequelize = require('sequelize');
const { StudentModel } = require('../sequelizeModel/db');

const create = async (studentData) => {
    let result = await StudentModel.create(studentData);
    return result;
}

const getAll = async () => {
    return await StudentModel.findAll();
}


const getOne = async (studentId) => {
    return await StudentModel.findByPk(studentId);
}

const deleteOne = async (studentId) => {
    return await StudentModel.destroy({ where: { 'id':studentId } });
}

const update= async (updateData,id)=>{
    return await StudentModel.update(updateData,{where:{'id':id}});
}

module.exports =
    {
        create, getAll, getOne, deleteOne,update
    };