create table if not exists persistent_logins (
  username varchar(100) NOT NULL,
  series varchar(64),
  token varchar(64) NOT NULL,
  last_used timestamp NOT NULL,
  PRIMARY KEY (series)
  );

INSERT INTO Role VALUES (1, 'ADMIN');
INSERT INTO Role VALUES (2, 'DBA');
INSERT INTO Role VALUES (3, 'DEVELOPER');
INSERT INTO Role VALUES (4, 'USER');

insert into USER(user_id, email, password, first_name, last_name, active) values (1, 'user@mum.edu', '123456', 'Tina', 'Xing', 1);
insert into USER(user_id, email, password, first_name, last_name, active) values (2, 'admin@mum.edu', '123456', 'Miss', 'Xing', 1);
insert into USER(user_id, email, password, first_name, last_name, active) values (3, 'dba@mum.edu', '123456', 'Tina2', 'Xing', 1);

insert into user_role(user_id, role_id) values (1, 4);
insert into user_role(user_id, role_id) values (2, 1);
insert into user_role(user_id, role_id) values (3, 2);
