INSERT INTO employee(first_name, last_name, position) VALUES('Tom', 'Phillips', 'Associate Developer');
INSERT INTO employee(first_name, last_name, position) VALUES('Al', 'Gilson', 'Software Developer');
INSERT INTO employee(first_name, last_name, position) VALUES('John', 'Livecchi', 'Senior Developer');

INSERT INTO skill(description, name, rating) VALUES ('Able to communicate ideas efficiently', 'Communication', 5);
INSERT INTO skill(description, name, rating) VALUES ('Confident with speaking to large groups', 'Public Speaking', 3);
INSERT INTO skill(description, name, rating) VALUES ('Ability to teach others', 'Mentoring', 2);

INSERT into employee_skill(employee_id, skill_id) VALUES (1, 1);
commit;