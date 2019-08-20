var Student=require('./Student');
var User=require('./User');
var Employee=require('./Employee');
var Address=require('./Address');
var Mobile=require('./Mobile');
var Project=require('./Project');

const Sequelize = require('sequelize');
const sequelize = new Sequelize('node', 'postgres', 'root', {
  host: 'localhost',
  dialect: 'postgres',
  logging:false,
    pool: {
        max: 5,
        min: 0,
        acquire: 30000,
        idle: 10000
      }
});

const StudentModel = Student(sequelize, Sequelize);
const UserModel = User(sequelize, Sequelize);
const EmployeeModel = Employee(sequelize, Sequelize);
const AddressModel = Address(sequelize, Sequelize);
const MobileModel = Mobile(sequelize, Sequelize);
const ProjectModel = Project(sequelize, Sequelize);

// AddressModel.hasOne(EmployeeModel)
// EmployeeModel.belongsTo(AddressModel);
AddressModel.belongsTo(EmployeeModel);
EmployeeModel.hasOne(AddressModel);

EmployeeModel.hasMany(MobileModel);
MobileModel.belongsTo(EmployeeModel);

EmployeeModel.belongsToMany(ProjectModel, {through: 'EmployeeProject',unique:false});
ProjectModel.belongsToMany(EmployeeModel, {through: 'EmployeeProject',unique:false});


sequelize.sync({ force: false })
  .then(() => {
    console.log(`Database & tables created!`)
  })


module.exports = {
  StudentModel, UserModel,sequelize,EmployeeModel,
  AddressModel,MobileModel ,ProjectModel
}