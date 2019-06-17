INSERT INTO iist.roles(role_id, role_name, role_description) VALUES (1, "ADMIN", "admin");
INSERT INTO iist.roles(role_id, role_name, role_description) VALUES (2, "MOD", "mod");
INSERT INTO iist.roles(role_id, role_name, role_description) VALUES (3, "USER", "end user");

INSERT INTO iist.positions(position_id, position_name, position_description) VALUES(1, "DEV1", "Developer 1");
INSERT INTO iist.positions(position_id, position_name, position_description) VALUES(2, "TL", "Team lead");

INSERT INTO iist.ACCOUNT(account_id, username, PASSWORD, STATUS) VALUES(1, 'admin', '$2a$10$9/gbzc8eF4okGThOUYLHmu9pfeNh87XY6h6skrjFR77SfmUYIntoW', 1);

INSERT INTO iist.account_role(account_id, role_id) VALUES(1,1);
