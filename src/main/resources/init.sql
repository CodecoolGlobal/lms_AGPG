DROP TABLE IF EXISTS assignments CASCADE;
DROP TABLE IF EXISTS users CASCADE;
DROP TABLE IF EXISTS answers CASCADE;
DROP TABLE IF EXISTS textpage CASCADE;
DROP TABLE IF EXISTS attendance CASCADE;

CREATE TABLE assignments (
    assignment_id SERIAL PRIMARY KEY,
    published boolean NOT NULL,
    assignment_date date ,
	question varchar NOT NULL,
	max_point INTEGER NOT NULL,
    mentor_id INTEGER NOT NULL
);

CREATE TABLE attendance (
    user_id INTEGER,
    date_att date
);

CREATE TABLE users (
    user_id SERIAL PRIMARY KEY,
    user_name TEXT NOT NULL,
    email varchar NOT null,
    user_password varchar NOT null,
	ismentor boolean NOT NULL
);

CREATE TABLE answers (
    assignment_id INTEGER NOT NULL,
    student_id INTEGER NOT null,
    answer TEXT NOT NULL,
    grade INTEGER NOT NULL
);

CREATE TABLE textpage (
    textpage_id SERIAL NOT NULL,
    textpage_title varchar,
    textpage_value text,
    date_created date,
    ispublished boolean NOT NULL
);



INSERT INTO users (user_name, email, user_password, isMentor) VALUES
	('Balogh Joli','user1@user1', 'user1', true), -- 1
	('Kovács Pilu','user2@user2', 'user2', false), -- 2
	('Kalács Ede', 'user3@user3', 'user3', false),
    ('Zombori Gizi', 'user4@user4', 'user4', false),
    ('Puma Ottó', 'user5@user5', 'user5', true),
    ('Ali Baba', 'user6@user6', 'user6', false),
    ('Kanalas Etelka', 'user7@user7', 'user7', false); -- 3

INSERT INTO assignments (published, assignment_date, question, max_point, mentor_id) VALUES
	(true, null, 'Hogy vagy?', 5, 1),
    (true, null, 'Éhes vagy?', 5, 5),
    (false, null, 'Szőrős vagy?', 5, 1),
    (true, null, 'Fáradt vagy?', 5, 1); -- 1

INSERT INTO answers (assignment_id, student_id, answer, grade) VALUES
	(1, 4, 'Nem jól vagyok mert látom ezt a szöveget', 2),
	(2, 2, 'Nagyon', 1),
    (1, 7, 'Ez egy másik gyönyörűséges válasz', 2),
	(3, 6,'Mindig', 1);

INSERT INTO textpage (textpage_title, textpage_value, date_created, ispublished) VALUES
	('asd', 'asdasdd', NULL, true);


INSERT INTO attendance (user_id, date_att) VALUES
    (1,'2019-04-09'),
    (2,'2019-04-09'),
    (3,'2019-04-09');

ALTER TABLE assignments
    ADD CONSTRAINT mentor_id FOREIGN KEY (mentor_id) REFERENCES users;
ALTER TABLE answers
    ADD CONSTRAINT assignment_id FOREIGN KEY (assignment_id) REFERENCES assignments;
ALTER TABLE answers
    ADD CONSTRAINT student_id FOREIGN KEY (student_id) REFERENCES users;
ALTER TABLE attendance
    ADD CONSTRAINT user_id FOREIGN KEY (user_id) REFERENCES users;
