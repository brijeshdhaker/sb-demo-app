/**
 * Author:  brijeshdhaker
 * Created: Jan 12, 2021
 */
CREATE TABLE  AUDIT_TYPE (
    ID          bigint,
    AUDIT_TYPE  varchar(50),
    DESCRIPTION varchar(200),
    ADD_TS      TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UPDATE_TS   TIMESTAMP,
    primary key(ID)
);

create sequence AUDIT_TYPE_SEQUENCE start with 1 increment by 1;

CREATE TABLE  AUDITLOG (
    ID              bigint,
    AUDIT_TYPE      varchar(50),
    EVENT_ACTION    varchar(50),
    DESCRIPTION     varchar(512),
    REF_ID          varchar(50),
    REF_TYPE        varchar(50),
    USERID          varchar(100),
    ADD_TS          TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    UPDATE_TS       TIMESTAMP,
    primary key(ID)
);

create sequence AUDITLOG_SEQUENCE start with 1 increment by 1;