/**
 * Author:  brijeshdhaker
 * Created: Jan 12, 2021
 */
insert into AUDIT_TYPE (ID, AUDIT_TYPE , DESCRIPTION , ADD_TS, UPDATE_TS ) values
(AUDIT_TYPE_SEQUENCE.nextval,'USER', 'Application Audit Logs',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());

insert into AUDIT_TYPE (ID, AUDIT_TYPE , DESCRIPTION , ADD_TS, UPDATE_TS ) values
(AUDIT_TYPE_SEQUENCE.nextval,'SYSTEM', 'System Audit Logs',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());

insert into AUDIT_TYPE (ID, AUDIT_TYPE , DESCRIPTION , ADD_TS, UPDATE_TS ) values
(AUDIT_TYPE_SEQUENCE.nextval,'BATCH', 'System Audit Logs',CURRENT_TIMESTAMP(),CURRENT_TIMESTAMP());

--

insert into AUDITLOG (ID, AUDIT_TYPE, EVENT_ACTION, DESCRIPTION, REF_ID, REF_TYPE, USERID, ADD_TS,UPDATE_TS ) values
(AUDITLOG_SEQUENCE.nextval, 'USER', 'LOGIN', 'Successfully login into application.', 'i100121', 'N/A', 'i100121', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
