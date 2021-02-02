/**
 * Author:  brijeshdhaker
 * Created: Jan 12, 2021
 */

CREATE TABLE  AUDITLOG (
    ID              bigint(8) AUTO_INCREMENT,
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

insert into AUDITLOG (AUDIT_TYPE, EVENT_ACTION, DESCRIPTION, REF_ID, REF_TYPE, USERID, ADD_TS, UPD_TS ) values
('USER', 'LOGIN', 'Successfully login into application.', 'i100121', 'N/A', 'i100121', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
insert into AUDITLOG (AUDIT_TYPE, EVENT_ACTION, DESCRIPTION, REF_ID, REF_TYPE, USERID, ADD_TS, UPD_TS ) values
('USER', 'LOGIN', 'Successfully login into application.', 'i100121', 'N/A', 'i100121', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
insert into AUDITLOG (AUDIT_TYPE, EVENT_ACTION, DESCRIPTION, REF_ID, REF_TYPE, USERID, ADD_TS, UPD_TS ) values
('SYSTEM', 'LOAD', 'Data Successfully loaded.', 'SYSTEM', 'N/A', 'SYSTEM', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
