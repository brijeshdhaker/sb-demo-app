/**
 * Author:  brijeshdhaker
 * Created: Jan 12, 2021
 */
CREATE TABLE `ROLE` (
  `ID`          bigint AUTO_INCREMENT,
  `NAME`            varchar(50),
  `STATUS`          varchar(20),
  `ADD_TS`          TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `UPD_TS`          TIMESTAMP,
  PRIMARY KEY (`ID`)
);
create sequence ROLE_SEQUENCE start with 1 increment by 1;
---

---
insert into `ROLE` (`ID`, `NAME`, `STATUS`, `ADD_TS`, `UPD_TS`) values
(ROLE_SEQUENCE.nextval, 'Admin', 'Active', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
insert into `ROLE` (`ID`, `NAME`, `STATUS`, `ADD_TS`, `UPD_TS`) values
(ROLE_SEQUENCE.nextval, 'Developer', 'Active', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
insert into `ROLE` (`ID`, `NAME`, `STATUS`, `ADD_TS`, `UPD_TS`) values
(ROLE_SEQUENCE.nextval, 'Risk', 'Active', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
insert into `ROLE` (`ID`, `NAME`, `STATUS`, `ADD_TS`, `UPD_TS`) values
(ROLE_SEQUENCE.nextval, 'Audit', 'Active', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
insert into `ROLE` (`ID`, `NAME`, `STATUS`, `ADD_TS`, `UPD_TS`) values
(ROLE_SEQUENCE.nextval, 'Technology', 'Active', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
