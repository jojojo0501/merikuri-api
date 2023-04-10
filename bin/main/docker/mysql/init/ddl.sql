SET CHARSET UTF8;
drop table if exists users cascade;
CREATE TABLE users (
    user_id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    age INT(3),
    tel VARCHAR(255),
    address VARCHAR(255),
    email VARCHAR(255) NOT NULL,
    password VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    delete_flg BOOLEAN NOT NULL DEFAULT 0
);

drop table if exists categories cascade;
CREATE TABLE categories (
    category_id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    delete_flg BOOLEAN NOT NULL DEFAULT 0
);

drop table if exists products cascade;
CREATE TABLE products (
    product_id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    category_id BIGINT NOT NULL,
    sale_user_id BIGINT NOT NULL,
    buy_user_id BIGINT,
    name VARCHAR(255) NOT NULL,
    price INTEGER NOT NULL,
    detail VARCHAR(1000),
    image_1 VARCHAR(255),
    image_2 VARCHAR(255),
    image_3 VARCHAR(255),
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    delete_flg BOOLEAN NOT NULL DEFAULT 0,
    FOREIGN KEY (category_id) REFERENCES categories (category_id),
    FOREIGN KEY (sale_user_id) REFERENCES users (user_id),
    FOREIGN KEY (buy_user_id) REFERENCES users (user_id)
);

drop table if exists comments_boards cascade;
CREATE TABLE comments_boards (
    comment_board_id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    product_id BIGINT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    delete_flg BOOLEAN NOT NULL DEFAULT 0,
    FOREIGN KEY (product_id) REFERENCES products (product_id)
);

drop table if exists comments cascade;
CREATE TABLE comments (
    comment_id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    comment_board_id BIGINT NOT NULL,
    send_user_id BIGINT NOT NULL,
    content VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    delete_flg BOOLEAN NOT NULL DEFAULT 0,
    FOREIGN KEY (comment_board_id) REFERENCES comments_boards (comment_board_id)
);

drop table if exists favorites cascade;
CREATE TABLE favorites (
    favorite_id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    product_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    delete_flg BOOLEAN NOT NULL DEFAULT 0,
    FOREIGN KEY (product_id) REFERENCES products (product_id),
    FOREIGN KEY (user_id) REFERENCES users (user_id)
);

drop table if exists messages_boards cascade;
CREATE TABLE messages_boards (
    message_board_id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    sale_user_id BIGINT NOT NULL,
    buy_user_id BIGINT NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    delete_flg BOOLEAN NOT NULL DEFAULT 0,
    FOREIGN KEY (sale_user_id) REFERENCES users (user_id),
    FOREIGN KEY (buy_user_id) REFERENCES users (user_id)
);

drop table if exists messages cascade;
CREATE TABLE messages (
    message_id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    message_board_id BIGINT NOT NULL,
    to_user_id BIGINT,
    from_user_id BIGINT,
    content VARCHAR(255) NOT NULL,
    send_date TIMESTAMP NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    delete_flg BOOLEAN NOT NULL DEFAULT 0,
    FOREIGN KEY (message_board_id) REFERENCES messages_boards (message_board_id),
    FOREIGN KEY (to_user_id) REFERENCES users (user_id),
    FOREIGN KEY (from_user_id) REFERENCES users (user_id)
);

drop table if exists notice_titles cascade;
CREATE TABLE notice_titles (
    notice_title_id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    delete_flg BOOLEAN NOT NULL DEFAULT 0
);

drop table if exists notice_contents cascade;
CREATE TABLE notice_contents (
    notice_content_id BIGINT NOT NULL PRIMARY KEY AUTO_INCREMENT,
    notice_title_id BIGINT NOT NULL,
    user_id BIGINT NOT NULL,
    content VARCHAR(255) NOT NULL,
    created_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
    delete_flg BOOLEAN NOT NULL DEFAULT 0,
    FOREIGN KEY (notice_title_id) REFERENCES notice_titles (notice_title_id)
);