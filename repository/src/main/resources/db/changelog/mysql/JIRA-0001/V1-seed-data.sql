/**
 * Author:  brijeshdhaker
 * Created: Jan 12, 2021
 */
insert into AUDIT_TYPE (AUDIT_TYPE , DESCRIPTION , ADD_TS, UPDATE_TS ) values
('USER', 'Application Audit Logs',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());

insert into AUDIT_TYPE (AUDIT_TYPE , DESCRIPTION , ADD_TS, UPDATE_TS ) values
('SYSTEM', 'System Audit Logs',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());

insert into AUDIT_TYPE (AUDIT_TYPE , DESCRIPTION , ADD_TS, UPDATE_TS ) values
('BATCH', 'System Audit Logs',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());

--

insert into AUDITLOG (AUDIT_TYPE, EVENT_ACTION, DESCRIPTION, REF_ID, REF_TYPE, USERID, ADD_TS,UPDATE_TS ) values
('USER', 'LOGIN', 'Successfully login into application.', 'i100121', 'N/A', 'i100121', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
