module.exports = (sequelize, type) => {
    return sequelize.define('mobile', {
        id: {
            type: type.INTEGER,
            primaryKey: true,
            autoIncrement: true
        },
        number: {
            type: type.BIGINT,
            allowNull: false
        }
    });
}