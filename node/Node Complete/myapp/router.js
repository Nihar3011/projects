var homeRouter = require('./routes/home.routing');
var arrayRouter = require('./routes/arrays.routing');
var crudRouter = require('./routes/crud.routing');
var lodash = require('./routes/lodash.routing');
var moment = require('./routes/moment.routing');
var data = require('./routes/crudDatabase.routing');
var sequelize = require('./routes/sequelize.routing');
var employee = require('./routes/employee.routing')

app.use('/', homeRouter);
app.use('/crud', crudRouter);
app.use('/array', arrayRouter);
app.use('/lodash', lodash);
app.use('/moment', moment);
app.use('/data', data);
app.use('/seq', sequelize);
app.use('/employee', employee);



app.use((req, res, next) => {
    res.status(200).json(res.locals.data);
});
app.use((error, req, res, next) => {
    res.status(400).json(error.code);
});