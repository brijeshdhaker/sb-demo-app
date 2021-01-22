/**
 * Author:  brijeshdhaker
 * Created: Jan 12, 2021
 */
CREATE TABLE  ACCOUNT (
    ID          bigint,
    ACC_NUMBER  varchar(50),
    ACC_TYPE    varchar(10),
    CC_NUMBER   varchar(24),
    ADD_TS      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UPDATE_TS   TIMESTAMP,
    primary key(ID)
);

create sequence ACCOUNT_SEQUENCE start with 1 increment by 1;