const express = require('express');
const bodyParser = require('body-parser');
var cors = require('cors')
const passport = require('passport');
const session = require('express-session');
const pgSession = require('connect-pg-simple')(session);
const Pool = require('pg').Pool


global.app = express();
app.use(bodyParser.json())
app.use(bodyParser.urlencoded({
    extended: true
}));

// create table session

/*
    CREATE TABLE "session" (
        "sid" varchar NOT NULL COLLATE "default",
        "sess" json NOT NULL,
        "expire" timestamp(6) NOT NULL
    )
    WITH (OIDS=FALSE);
    ALTER TABLE "session" ADD CONSTRAINT "session_pkey" PRIMARY KEY ("sid") NOT DEFERRABLE INITIALLY IMMEDIATE;
*/

app.use(session({
    secret: "secret",
    resave: true,
    saveUninitialized: false,
    store: new pgSession({
        pool: new Pool({
            user: 'postgres',
            host: 'localhost',
            database: 'node',
            password: 'root',
            port: 5432,
        })
    })
}));

app.use(cors());
app.use(passport.initialize());
app.use(passport.session());
require('./passport.router');
require('./router');

  //  Simple database login
require('./middlewares/passport').initialize();


app.listen(3100);
