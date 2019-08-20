
module.exports = (sequelize, type) => {
    return sequelize.define('employee', {
        id: {
            type: type.INTEGER,
            primaryKey: true,
            autoIncrement: true
        },
        name: {
            type: type.STRING,
            allowNull: false
        },
        gender: {
            type: type.STRING,
            allowNull: false,
            defaultValue: 'Male'
        },
    });
}
