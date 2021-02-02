/**
 * Author:  brijeshdhaker
 * Created: Jan 12, 2021
 */
CREATE TABLE `ROLE` (
  `ID`              bigint(8) AUTO_INCREMENT,
  `NAME`            varchar(50),
  `STATUS`          varchar(20),
  `ADD_TS`          TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
  `UPD_TS`          TIMESTAMP,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;


/**
* Author:  brijeshdhaker
* Created: Jan 12, 2021
*/
insert into `ROLE` (`NAME`, `STATUS`, `ADD_TS`, `UPD_TS`) values
('admin', 'Active', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
insert into `ROLE` (`NAME`, `STATUS`, `ADD_TS`, `UPD_TS`) values
('developer', 'Active', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
insert into `ROLE` (`NAME`, `STATUS`, `ADD_TS`, `UPD_TS`) values
('audit', 'Active', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
insert into `ROLE` (`NAME`, `STATUS`, `ADD_TS`, `UPD_TS`) values
('technology', 'Active', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
