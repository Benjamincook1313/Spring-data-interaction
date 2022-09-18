CREATE TABLE person (
id SERIAL PRIMARY KEY,
name VARCHAR(255) NOT NULL,
location varchar(255),
birth_date DATE
);

INSERT INTO person(name, location, birth_date)
VALUES('Benjamin', 'Murray', '1992-08-06'),
('Melissa',	'Murray', '1993-06-27'),
('Loyal', 'Vineyard', '1991-06-14');
