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
    UPD_TS   TIMESTAMP,
    primary key(USERID)
);
create sequence USERS_SEQUENCE start with 1 increment by 1;

insert into USERS (USERID, USERNAME, EMAIL, STATUS, ADD_TS, UPD_TS ) values
(USERS_SEQUENCE.nextval, 'Brijesh Dhaker', 'brijeshdhaker@gmail.com', 'Active', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
