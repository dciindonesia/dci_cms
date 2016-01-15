insert into USER (USER_ID, USERNAME, PASSWORD, NAME, EMAIL, LOCKED) values (1,  'admin', 'admin', 'Administrator', 'admin@email.com', true)
insert into USER (USER_ID, USERNAME, PASSWORD, NAME, EMAIL, LOCKED) values (2,  'spv', 'spv', 'Supervisor', 'spv@email.com', true)
insert into USER (USER_ID, USERNAME, PASSWORD, NAME, EMAIL, LOCKED) values (3,  'guest', 'guest', 'User Guest', 'guest@email.com', false)

insert into Role (ROLE_ID, USERNAME, ROLE) values (1, 'admin', 'ROLE_ADMIN')
insert into Role (ROLE_ID, USERNAME, ROLE) values (2, 'admin', 'ROLE_SUPERVISOR')
insert into Role (ROLE_ID, USERNAME, ROLE) values (3, 'admin', 'ROLE_USER')
insert into Role (ROLE_ID, USERNAME, ROLE) values (4, 'spv', 'ROLE_SUPERVISOR')
insert into Role (ROLE_ID, USERNAME, ROLE) values (5, 'spv', 'ROLE_USER')
insert into Role (ROLE_ID, USERNAME, ROLE) values (6, 'guest', 'ROLE_USER')

