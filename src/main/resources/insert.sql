INSERT INTO `hrms`.`user`
(`ID`,
`PASSWORD`,
`USERNAME`,
`ENABLED`)
VALUES
(1,
'test',
'test',
1);
SELECT * FROM hrms.role;

INSERT INTO `hrms`.`role`
(`ID`,
`NAME`)
VALUES
(1,
'ROLE_ADMIN');
SELECT * FROM hrms.user;

INSERT INTO `hrms`.`user_role`
(`USER_ID`,
`roles_ID`)
VALUES
(1,
1);
