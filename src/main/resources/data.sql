INSERT INTO users (firstname, lastname, version) VALUES
('Anu','Mihkelson', 0),
('Tarmo','Tamm', 0),
('Anastassia','Anatoljevna', 0),
('Vahur','Mihailovich', 0),
('Aleksander','Petrov', 0),
('Tatjana','Peterson', 0),
('Kalev','Salumets', 0),
('Alex','Thebest', 0);

INSERT INTO roles (name, version) VALUES
('user', 0),
('teacher', 0),
('admin', 0);

INSERT INTO user_role (user_id, role_id, version, created) VALUES
(8, 1, 0, {ts '2012-09-17 18:47:52.69'}),
(8, 2, 0, {ts '2012-08-18 18:47:52.69'}),
(8, 3, 0, {ts '2012-07-19 18:47:52.69'});

INSERT INTO courses (name, description, version) VALUES
('course math', '6+3+9+8+5+5', 0),
('fizzzikaa', NULL,  0),
('path and go', '', 0);

INSERT INTO user_course (user_id, course_id, version, created) VALUES
(1, 1, 0, {ts '2012-09-17 18:47:52.69'}),
(1, 2, 0, {ts '2012-08-18 18:47:52.69'}),
(1, 3, 0, {ts '2012-07-19 18:47:52.69'}),
(2, 2, 0, {ts '2012-08-18 18:47:52.69'}),
(3, 3, 0, {ts '2012-07-19 18:47:52.69'}),
(4, 2, 0, {ts '2012-08-18 18:47:52.69'}),
(5, 3, 0, {ts '2012-07-19 18:47:52.69'}),
(6, 2, 0, {ts '2012-08-18 18:47:52.69'}),
(7, 3, 0, {ts '2012-07-19 18:47:52.69'}),
(8, 2, 0, {ts '2012-08-18 18:47:52.69'}),
(8, 3, 0, {ts '2012-07-19 18:47:52.69'});