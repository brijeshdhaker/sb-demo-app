/**
 * Author:  brijeshdhaker
 * Created: Jan 12, 2021
 */
CREATE TABLE `USER_ROLES` (
  `ID`              bigint AUTO_INCREMENT,
  `USER_ID`         bigint NOT NULL,
  `ROLE_ID`         bigint NOT NULL,
  PRIMARY KEY (`ID`)
);

create sequence USER_ROLES_SEQUENCE start with 1 increment by 1;
/**

*/
insert into USER_ROLES (ID, USER_ID, ROLE_ID) values (USER_ROLES_SEQUENCE.nextval, 1, 1);
insert into USER_ROLES (ID, USER_ID, ROLE_ID) values (USER_ROLES_SEQUENCE.nextval, 1, 2);
insert into USER_ROLES (ID, USER_ID, ROLE_ID) values (USER_ROLES_SEQUENCE.nextval, 1, 4);