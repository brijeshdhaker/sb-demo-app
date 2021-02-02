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
    UPD_TS      TIMESTAMP,
    primary key(ID)
);

create sequence ACCOUNT_SEQUENCE start with 1 increment by 1;

insert into ACCOUNT (ID, ACC_NUMBER, ACC_TYPE, CC_NUMBER, ADD_TS, UPD_TS ) values
(ACCOUNT_SEQUENCE.nextval, '1001', 'SAVING', '1111-2222-3333-4444', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
