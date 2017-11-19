
use hrms;

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";

INSERT INTO `role` (`ID`, `NAME`) VALUES (1, 'ROLE_ADMIN');

INSERT INTO `user` (`ID`, `ENABLED`, `PASSWORD`, `USERNAME`) VALUES (1, 1, 'test', 'test');
INSERT INTO `hrms`.`user_role` (`USER_ID`,`roles_ID`) VALUES (1,1);
commit;