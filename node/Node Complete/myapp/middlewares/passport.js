const passport = require('passport');
const LocalStrategy = require('passport-local').Strategy;

var { getOne } = require('../model/user.model')

class Passport {
    static async initialize() {
        passport.use(new LocalStrategy({
            usernameField: 'username',
            passwordField: 'password',
            passReqToCallback: true
        }, async (req, username, password, next) => {

            const user = await getOne(username);
            if (user) {
                console.log(user);

                if (user.password === password) {
                    user.password = undefined;
                    return next(null, user);
                } else {
                    next("Invalid username and password");
                };
            } else {
                next("Invalid username and password")
            };

        }));

        passport.serializeUser(function (user, done) {
            done(null, user);
        });

        passport.deserializeUser(function (user, done) {
            done(null, user);
        });
    }


}
module.exports = Passport