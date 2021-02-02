/**
 * Author:  brijeshdhaker
 * Created: Jan 12, 2021
 */
CREATE TABLE  USERS (
    USERID      bigint(8) AUTO_INCREMENT,
    USERNAME    varchar(256),
    EMAIL       varchar(50),
    STATUS      varchar(24),
    ADD_TS      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UPD_TS      TIMESTAMP,
    primary key(USERID)
);

insert into USERS (USERNAME, EMAIL, STATUS, ADD_TS, UPD_TS ) values
('Brijesh Dhaker', 'brijeshdhaker@gmail.com', 'Active', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
