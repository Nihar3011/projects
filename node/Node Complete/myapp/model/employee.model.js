var async = require('async')


const { EmployeeModel, AddressModel,
    MobileModel, ProjectModel } = require('../sequelizeModel/db');

const add = async (EmployeeData) => {
    console.log(EmployeeData);
    let employee = {};

    await EmployeeModel.create({
        name: EmployeeData.name,
        gender: EmployeeData.gender,
        mobiles: EmployeeData.mobiles
    }, {
            include: [MobileModel]
        }).then(createdEmployee => {
            employee = createdEmployee;
            return AddressModel.create({
                area: EmployeeData.address.area,
                state: EmployeeData.address.state
            });
        }).then(address => {
            employee.setAddress(address)
        });
    return employee;
}

const addEmployees = async (employeeProjectData) => {
    let emp = [];
    let employees = [];

    employeeProjectData.employees.forEach((employee,index) => {
        EmployeeModel.create({
            name: employee.name,
            gender: employee.gender,
            mobiles: employee.mobiles
        }, {
                include: [MobileModel]
            }).then(createdEmployee => {
                emp[index] = createdEmployee;

                return AddressModel.create({
                    area: employee.address.area,
                    state: employee.address.state
                });
            }).then(address => {
                emp[index].setAddress(address);
                employees.push(emp[index]);
            });
    });

    return await employees;

}

const getAllWithProject = async () => {
    return await EmployeeModel.findAll({
        include: [{
            model: MobileModel,
            attributes: ['id', 'number']
        },
        {
            model: AddressModel,
            attributes: ['area', 'state']
        },
        {
            model: ProjectModel,
            attributes: ['name', 'duration'],
            through: {
                attributes: ['projectId', 'employeeId'],
            }
        }],
        attributes: ['id', 'name', 'gender']
    });
}
const addprojectemployees = async (projectEmployeeData) => {
    let project = {}
    await ProjectModel.create({
        name: projectEmployeeData.project.name,
        duration: projectEmployeeData.project.duration,
    }).then(createdProjects => {
        project = createdProjects;
        console.log(projectEmployeeData.emps);
        createdProjects.setEmployees(projectEmployeeData.emps);

    });
    return project;
}

const getById = async (id) => {
    return await EmployeeModel.findAll({
         where: { 'id': id } ,
        include: [{
            model: MobileModel,
            attributes: ['id', 'number']
        },
        {
            model: AddressModel,
            attributes: ['area', 'state']
        }
        ],
        attributes: ['id', 'name', 'gender']
    });
}


module.exports = {
    add, getById, addEmployees, getAllWithProject, addprojectemployees
}