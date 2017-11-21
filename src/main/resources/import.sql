
use hrms;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

INSERT INTO `role` (`ID`, `NAME`) VALUES (1, 'ROLE_ADMIN');
INSERT INTO `role` (`ID`, `NAME`) VALUES (2, 'ROLE_USER');

INSERT INTO `user` (`ID`, `ENABLED`, `PASSWORD`, `USERNAME`) VALUES (1, 1, 'test', 'test');
INSERT INTO `hrms`.`user_role` (`USER_ID`,`roles_ID`) VALUES (1,1);

INSERT INTO `department` (`ID`, `DESCRIPTION`, `NAME`) VALUES ('1', 'Information Technology', 'IT');
INSERT INTO `project` (`ID`, `DESCRIPTION`, `END_DATE`, `NAME`, `START_DATE`, `department_ID`) VALUES ('1', 'test project', '2018-02-01 00:00:00', 'WAA Project', '2017-11-09 00:00:00','1');
INSERT INTO `department_project` (`DEPARTMENT_ID`, `projects_ID`) VALUES ('1', '1');

commit;