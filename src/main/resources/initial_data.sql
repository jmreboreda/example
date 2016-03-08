insert into Role (id, name, description) values (0, 'admin', 'Administrator');
insert into Role (id, name, description) values (1, 'user', 'User');

insert into UserApp (id, username, password, salt) values (nextval('userIdSequence'), 'admin', '$2a$10$hyzdVNN5axYivX1HWPkXweFsy8fsNQM/HZeGxu9y1kq93YnrFIxRe', '$2a$10$hyzdVNN5axYivX1HWPkXwe]');

insert into UserRole (userId, roleId) values (1, 0);
insert into UserRole (userId, roleId) values (1, 1);