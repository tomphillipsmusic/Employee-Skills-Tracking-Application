INSERT INTO employee(first_name, last_name, position) VALUES('Tom', 'Phillips', 'Associate Developer');
INSERT INTO employee(first_name, last_name, position) VALUES('Al', 'Gilson', 'Software Developer');
INSERT INTO employee(first_name, last_name, position) VALUES('John', 'Livecchi', 'Senior Developer');

INSERT INTO skill(description, name, rating, employee_id) VALUES ('Able to communicate ideas efficiently', 'Communication', 5, 1);
INSERT INTO skill(description, name, rating, employee_id) VALUES ('Confident with speaking to large groups', 'Public Speaking', 3, 1);
INSERT INTO skill(description, name, rating, employee_id) VALUES ('Ability to teach others', 'Mentoring', 2, 1);


commit;