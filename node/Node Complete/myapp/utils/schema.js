const Joi = require('joi');


const StudentSchema = Joi.object().keys({
    rollno: Joi.number().integer().required(),
    name: Joi.string().max(15).required(),
    name1: Joi.string().max(15).required(),
    gender:Joi.string().max(5).required(),
    mobile: Joi.number().min(1000000000).max(9999999999)
});

// name: Joi.string().max(15).required(),
// name1: Joi.string().max(15).required(),
// gender:Joi.string().max(5).required(),
// mobile: Joi.number().max(11).min(10).required()
async function validate(data, schema, callback) {
    console.log(data);
    
    await Joi.validate(data, schema, function (error, value) {
        if (error) {
            error.code = "JOIFALSE";
            return callback(error);
        } else {
            return callback(null, value);
        }
    });
}

module.exports={
    StudentSchema,validate
}