/**
 * Author:  brijeshdhaker
 * Created: Jan 12, 2021
 */


--
CREATE TABLE  AUDITLOG (
    ID              bigint,
    AUDIT_TYPE      varchar(50),
    EVENT_ACTION    varchar(50),
    DESCRIPTION     varchar(512),
    REF_ID          varchar(50),
    REF_TYPE        varchar(50),
    USERID          varchar(100),
    ADD_TS          TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UPD_TS          TIMESTAMP,
    primary key(ID)
);

create sequence AUDITLOG_SEQUENCE start with 1 increment by 1;

insert into AUDITLOG (ID, AUDIT_TYPE, EVENT_ACTION, DESCRIPTION, REF_ID, REF_TYPE, USERID, ADD_TS, UPD_TS ) values
(AUDITLOG_SEQUENCE.nextval, 'USER', 'LOGIN', 'Successfully login into application.', 'i100121', 'N/A', 'i100121', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
