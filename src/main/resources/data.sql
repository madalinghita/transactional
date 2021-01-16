DROP TABLE IF EXISTS users;

CREATE TABLE users (
  id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  career VARCHAR(250) DEFAULT NULL
);

INSERT INTO users (id, first_name, last_name, career) VALUES
  (-1, 'Aliko', 'Dangote', 'Industrialist'),
  (-2, 'Bill', 'Gates', 'Tech Entrepreneur'),
  (-3, 'Folrunsho', 'Alakija', 'Oil Magnate');
