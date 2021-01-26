/**
 * Author:  brijeshdhaker
 * Created: Jan 12, 2021
 */
CREATE TABLE  USERS (
    USERID      bigint,
    USERNAME    varchar(256),
    EMAIL       varchar(50),
    STATUS      varchar(24),
    ADD_TS      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UPDATE_TS   TIMESTAMP,
    primary key(USERID)
);

create sequence USERS_SEQUENCE start with 1 increment by 1;