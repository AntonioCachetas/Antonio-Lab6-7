CREATE TABLE customers (
    customer_id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    phone VARCHAR(20),
    postal_code VARCHAR(10) NOT NULL,
    country VARCHAR(255) NOT NULL
);
