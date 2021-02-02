/**
 * Author:  brijeshdhaker
 * Created: Jan 12, 2021
 */
CREATE TABLE `USER_ROLES` (
  `ID`              bigint(8) AUTO_INCREMENT,
  `USER_ID`         bigint(8) NOT NULL,
  `ROLE_ID`         bigint(8) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

/**
*
*/

insert into USER_ROLES (USER_ID, ROLE_ID) values (1, 1);
insert into USER_ROLES (USER_ID, ROLE_ID) values (1, 2);
insert into USER_ROLES (USER_ID, ROLE_ID) values (1, 4);