const Sequelize = require('sequelize');
const { UserModel } = require('../sequelizeModel/db');


const getOne = async (username) => {
    let result = await UserModel.findOne({username:username});
    if(result) {
        return result.dataValues;
    } else {
        return null;
    }
}

module.exports =
    {
        getOne
    };
