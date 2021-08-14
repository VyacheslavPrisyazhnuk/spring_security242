INSERT INTO mydpc.users (age, email, name, password) VALUES (22, 'admin', 'admin', 'admin');
INSERT INTO mydpc.roles (id, role) VALUES (1, 'ROLE_ADMIN');
INSERT INTO mydpc.user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO mydpc.users (age, email, name, password) VALUES (33, 'user', 'user', 'user');
INSERT INTO mydpc.roles (id, role) VALUES (2, 'ROLE_USER');
INSERT INTO mydpc.user_role (user_id, role_id) VALUES (2, 2)