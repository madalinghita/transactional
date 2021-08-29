DROP ALL OBJECTS;

CREATE TABLE USERS
(
    id         INT AUTO_INCREMENT PRIMARY KEY,
    first_name VARCHAR(250) NOT NULL,
    last_name  VARCHAR(250) NOT NULL,
    career     VARCHAR(250) DEFAULT NULL
);
INSERT INTO USERS (id, first_name, last_name, career)
VALUES (-1, 'Aliko', 'Dangote', 'Industrialist'),
       (-2, 'Bill', 'Gates', 'Tech Entrepreneur'),
       (-3, 'Folrunsho', 'Alakija', 'Oil Magnate');


CREATE TABLE LIBRARIES
(
    library_id INT AUTO_INCREMENT PRIMARY KEY,
    name       VARCHAR(250) NOT NULL
);
CREATE TABLE BOOKS
(
    book_id      INT AUTO_INCREMENT PRIMARY KEY,
    title        VARCHAR(250) NOT NULL,
    ISBN         VARCHAR(20)  NOT NULL,
    publish_year INT,
    library_id   INT,
    CONSTRAINT `library_fk` FOREIGN KEY (`library_id`) REFERENCES `LIBRARIES` (`library_id`)
);
