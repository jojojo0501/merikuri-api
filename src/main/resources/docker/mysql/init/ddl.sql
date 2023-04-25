SET CHARSET UTF8;
SET FOREIGN_KEY_CHECKS = 0;
DROP TABLE if EXISTS users CASCADE;
CREATE TABLE users (
    user_id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    zip INT NOT NULL,
    address VARCHAR(255),
    birthday DATE,
    tel VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    image VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    delete_flag BOOLEAN NOT NULL DEFAULT 0
);

DROP TABLE if EXISTS categories CASCADE;
CREATE TABLE categories (
    category_id BIGINT NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    delete_flag BOOLEAN NOT NULL DEFAULT 0
);

DROP TABLE if EXISTS products CASCADE;
CREATE TABLE products (
    product_id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    category_id BIGINT NOT NULL,
    sale_user_id BIGINT NOT NULL,
    buy_user_id BIGINT,
    name VARCHAR(255) NOT NULL,
    price INT NOT NULL,
    detail VARCHAR(1000),
    image_1 VARCHAR(255),
    image_2 VARCHAR(255),
    image_3 VARCHAR(255),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    delete_flag BOOLEAN NOT NULL DEFAULT 0,
    FOREIGN KEY (category_id) REFERENCES categories (category_id),
    FOREIGN KEY (sale_user_id) REFERENCES users (user_id),
    FOREIGN KEY (buy_user_id) REFERENCES users (user_id)
);

DROP TABLE if EXISTS comments_boards CASCADE;
CREATE TABLE comments_boards (
    comment_board_id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    product_id BIGINT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    delete_flag BOOLEAN NOT NULL DEFAULT 0,
    FOREIGN KEY (product_id) REFERENCES products (product_id)
);

DROP TABLE if EXISTS comments CASCADE;
CREATE TABLE comments (
    comment_id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    comment_board_id BIGINT NOT NULL,
    send_user_id BIGINT NOT NULL,
    content VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    delete_flag BOOLEAN NOT NULL DEFAULT 0,
    FOREIGN KEY (comment_board_id) REFERENCES comments_boards (comment_board_id),
    FOREIGN KEY (send_user_id) REFERENCES users (user_id)
);

DROP TABLE if EXISTS favorites CASCADE;
CREATE TABLE favorites (
    favorite_id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    product_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    delete_flag BOOLEAN NOT NULL DEFAULT 0,
    FOREIGN KEY (product_id) REFERENCES products (product_id),
    FOREIGN KEY (user_id) REFERENCES users (user_id)
);

DROP TABLE if EXISTS messages_boards CASCADE;
CREATE TABLE messages_boards (
    message_board_id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    sale_user_id BIGINT NOT NULL,
    buy_user_id BIGINT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    delete_flag BOOLEAN NOT NULL DEFAULT 0,
    FOREIGN KEY (sale_user_id) REFERENCES users (user_id),
    FOREIGN KEY (buy_user_id) REFERENCES users (user_id)
);

DROP TABLE if EXISTS messages CASCADE;
CREATE TABLE messages (
    message_id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    message_board_id BIGINT NOT NULL,
    to_user_id BIGINT,
    from_user_id BIGINT,
    content VARCHAR(255) NOT NULL,
    send_date TIMESTAMP NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    delete_flag BOOLEAN NOT NULL DEFAULT 0,
    FOREIGN KEY (message_board_id) REFERENCES messages_boards (message_board_id),
    FOREIGN KEY (to_user_id) REFERENCES users (user_id),
    FOREIGN KEY (from_user_id) REFERENCES users (user_id)
);

DROP TABLE if EXISTS notice_titles CASCADE;
CREATE TABLE notice_titles (
    notice_title_id BIGINT NOT NULL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    delete_flag BOOLEAN NOT NULL DEFAULT 0
);

DROP TABLE if EXISTS notice_contents CASCADE;
CREATE TABLE notice_contents (
    notice_content_id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    notice_title_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    content VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    delete_flag BOOLEAN NOT NULL DEFAULT 0,
    FOREIGN KEY (notice_title_id) REFERENCES notice_titles (notice_title_id)
);
SET FOREIGN_KEY_CHECKS = 1;
