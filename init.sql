INSERT INTO iist.role(role_id, role_name) VALUES (1, "ADMIN");
INSERT INTO iist.role(role_id, role_name) VALUES (2, "MOD");
INSERT INTO iist.role(role_id, role_name) VALUES (3, "USER");

INSERT INTO iist.position(position_id, position_name) VALUES(1, "Developer");
INSERT INTO iist.position(position_id, position_name) VALUES(2, "Team Lead");

INSERT INTO iist.ACCOUNT(account_id, username, PASSWORD) VALUES(1, 'admin', '$2a$10$9/gbzc8eF4okGThOUYLHmu9pfeNh87XY6h6skrjFR77SfmUYIntoW');

INSERT INTO iist.account_role(account_id, role_id) VALUES(1,1);
