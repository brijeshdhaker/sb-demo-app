/**
 * Author:  brijeshdhaker
 * Created: Jan 12, 2021
 */
CREATE TABLE  AUDIT_TYPE (
    ID          bigint,
    AUDIT_TYPE  varchar(50),
    DESCRIPTION varchar(200),
    ADD_TS      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UPD_TS      TIMESTAMP,
    primary key(ID)
);

create sequence AUDIT_TYPE_SEQUENCE start with 1 increment by 1;

insert into AUDIT_TYPE (ID, AUDIT_TYPE , DESCRIPTION , ADD_TS, UPD_TS ) values
(AUDIT_TYPE_SEQUENCE.nextval,'USER', 'Application Audit Logs',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());

insert into AUDIT_TYPE (ID, AUDIT_TYPE , DESCRIPTION , ADD_TS, UPD_TS ) values
(AUDIT_TYPE_SEQUENCE.nextval,'SYSTEM', 'System Audit Logs',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());

insert into AUDIT_TYPE (ID, AUDIT_TYPE , DESCRIPTION , ADD_TS, UPD_TS ) values
(AUDIT_TYPE_SEQUENCE.nextval,'BATCH', 'System Audit Logs',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());