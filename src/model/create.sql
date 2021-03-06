CREATE TABLE IF NOT EXISTS USERS
(
    NAME        TEXT    PRIMARY KEY NOT NULL,
    PASSWORD    CHAR(32)
);

CREATE TABLE IF NOT EXISTS ACCOUNTS
(
    ID          SERIAL PRIMARY KEY ,
    DESCRIPTION TEXT                NOT NULL,
    MONEY_TYPE  TEXT                NOT NULL,
    USER_NAME   TEXT                NOT NULL
);

CREATE TABLE IF NOT EXISTS CATEGORIES
(
    ID          SERIAL          PRIMARY KEY,
    NAME        TEXT                NOT NULL
);