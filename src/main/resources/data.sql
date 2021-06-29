DROP TABLE IF EXISTS internalusers;
 
CREATE TABLE internalusers (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  username VARCHAR(250) NOT NULL,
  mail VARCHAR(250) NOT NULL,
  password VARCHAR(250) NOT NULL,
  role_id INT NOT NULL
);
 
INSERT INTO internalusers (username, mail, password, role_id) VALUES
  ('bob', 'bob@mail.com', 'bob', 1),
  ('james', 'james@mail.com', 'james', 2);
  

DROP TABLE IF EXISTS roles;
 
CREATE TABLE roles (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  name VARCHAR(250) NOT NULL
);
 
INSERT INTO roles (name) VALUES
  ('USER'),
  ('ADMIN');