CREATE TABLE IF NOT EXISTS products (
    id INT AUTO_INCREMENT PRIMARY KEY,
    product_name VARCHAR(255) NOT NULL,
    quantity INT,
    price DOUBLE,
    amount DOUBLE,
    description VARCHAR(300);

