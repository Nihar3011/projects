module.exports = (sequelize, type) => {
    return sequelize.define('project', {
        id: {
            type: type.INTEGER,
            primaryKey: true,
            autoIncrement: true
        },
        name: {
            type: type.STRING,
            allowNull: false
        },
        duration:{
            type:type.INTEGER,
            allowNull:true
        }
    });
}