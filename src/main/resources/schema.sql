CREATE TABLE application_user (
    id INT NOT NULL AUTO_INCREMENT,
    username VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE restaurant (
    id INT NOT NULL AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    address VARCHAR(255) NOT NULL,
    PRIMARY KEY(id)
);

CREATE TABLE restaurant_reservation (
    id INT NOT NULL AUTO_INCREMENT,
    restaurant_id INT NOT NULL,
    name VARCHAR(255) NOT NULL,
    guests INT NOT NULL,
    phone VARCHAR(255) NOT NULL,
    reservation_date DATE NOT NULL,
    PRIMARY KEY(id),
    FOREIGN KEY (restaurant_id) REFERENCES restaurant(id) ON DELETE CASCADE
);