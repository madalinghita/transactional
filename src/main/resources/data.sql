DROP ALL OBJECTS;

--users
CREATE TABLE USERS (
  id INT AUTO_INCREMENT PRIMARY KEY,
  first_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  career VARCHAR(250) DEFAULT NULL
);

INSERT INTO USERS (id, first_name, last_name, career) VALUES
  (-1, 'Aliko', 'Dangote', 'Industrialist'),
  (-2, 'Bill', 'Gates', 'Tech Entrepreneur'),
  (-3, 'Folrunsho', 'Alakija', 'Oil Magnate');



--products
CREATE TABLE PRODUCTS (
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(250) NOT NULL,
  price double NOT NULL DEFAULT 0
);

--orders
CREATE TABLE ORDERS (
  id INT AUTO_INCREMENT PRIMARY KEY,
  customer_Id INT NOT NULL
);


--order_items
CREATE TABLE ORDER_ITEMS (
  id INT AUTO_INCREMENT PRIMARY KEY,
  order_id INT NOT NULL,
  product_id INT NOT NULL,
  quantity INT NOT NULL DEFAULT 0,
  CONSTRAINT `order_fk` FOREIGN KEY (`order_id`) REFERENCES `orders` (`id`),
  CONSTRAINT `product_fk` FOREIGN KEY (`product_id`) REFERENCES `products` (`id`)
);
