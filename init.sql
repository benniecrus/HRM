INSERT INTO iist.roles(role_id, role_name, role_description) VALUES (1, "ADMIN", "admin");
INSERT INTO iist.roles(role_id, role_name, role_description) VALUES (2, "MOD", "mod");
INSERT INTO iist.roles(role_id, role_name, role_description) VALUES (3, "USER", "end user");

INSERT INTO iist.positions(position_id, position_name, position_description) VALUES(1, "DEV1", "Developer 1");
INSERT INTO iist.positions(position_id, position_name, position_description) VALUES(2, "TL", "Team lead");

INSERT INTO iist.ACCOUNT(account_id, username, PASSWORD, STATUS) VALUES(1, 'admin', '$2a$10$9/gbzc8eF4okGThOUYLHmu9pfeNh87XY6h6skrjFR77SfmUYIntoW', 1);

INSERT INTO iist.account_role(account_id, role_id) VALUES(1,1);

insert into iist.CATEGORY(CATEGORY_ID,CATEGORY_NAME) values (1,'Account Management');
insert into iist.CATEGORY(CATEGORY_ID,CATEGORY_NAME) values (2,'HR Management');

insert into iist.CATEGORY(CATEGORY_ID,CATEGORY_NAME) values (3,'Category Management');
insert into iist.CATEGORY(CATEGORY_ID,PARENT_ID,CATEGORY_NAME) values (4,3,'Position');
insert into iist.CATEGORY(CATEGORY_ID,PARENT_ID,CATEGORY_NAME) values (5,3,'Salary');
insert into iist.CATEGORY(CATEGORY_ID,PARENT_ID,CATEGORY_NAME) values (6,3,'Department');

insert into iist.CATEGORY(CATEGORY_ID,CATEGORY_NAME) values (7,'Roles Management');


insert into iist.ROLE_CATEGORY(ID,ROLE_ID,CATEGORY_ID) values(1,1,1);
insert into iist.ROLE_CATEGORY(ID,ROLE_ID,CATEGORY_ID) values(2,1,2);
insert into iist.ROLE_CATEGORY(ID,ROLE_ID,CATEGORY_ID) values(3,1,3);
insert into iist.ROLE_CATEGORY(ID,ROLE_ID,CATEGORY_ID) values(4,1,4);
insert into iist.ROLE_CATEGORY(ID,ROLE_ID,CATEGORY_ID) values(5,1,5);
insert into iist.ROLE_CATEGORY(ID,ROLE_ID,CATEGORY_ID) values(6,1,6);
insert into iist.ROLE_CATEGORY(ID,ROLE_ID,CATEGORY_ID) values(7,1,7);