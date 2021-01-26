/**
 * Author:  brijeshdhaker
 * Created: Jan 12, 2021
 */
CREATE TABLE  ACCOUNT (
    ID          bigint(8) AUTO_INCREMENT,
    ACC_NUMBER  varchar(50),
    ACC_TYPE    varchar(10),
    CC_NUMBER   varchar(24),
    ADD_TS      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UPDATE_TS   TIMESTAMP,
    primary key(ID)
);