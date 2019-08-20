module.exports = (sequelize, type) => {
    return sequelize.define('address', {
        id: {
            type: type.INTEGER,
            primaryKey: true,
            autoIncrement: true
        },
        area: {
            type: type.STRING,
            allowNull: false
        },
        state: {
            type: type.STRING,
            allowNull: false,
            defaultValue: 'Male'
        },
    });
}