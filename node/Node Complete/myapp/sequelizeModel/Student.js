
module.exports = (sequelize, type) => {
    return sequelize.define('student', {
        id: {
            type: type.INTEGER,
            primaryKey: true,
            autoIncrement: true
        },
        rollno: {
            type: type.INTEGER,
            allowNull: false
        },
        name: {
            type: type.STRING,
            allowNull: false
        },
        name1: {
            type: type.STRING,
            allowNull: false
        },
        gender: {
            type: type.STRING,
            allowNull: false,
            defaultValue: 'Male'
        },
        mobile: type.BIGINT,
    });
}
