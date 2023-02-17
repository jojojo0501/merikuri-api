SET CHARACTER_SET_CLIENT = utf8;
SET CHARACTER_SET_CONNECTION = utf8;

DELETE FROM users;
INSERT INTO merikuri.`users`(first_name, last_name, age, tel, address, email, password, created_at, updated_at, delete_flg)
VALUES('田中', '太郎', 30, '090-1234-5678', '東京都港区芝公園４丁目２−８東京タワー', 'test@gmail.com', 'password', CURRENT_TIMESTAMP,CURRENT_TIMESTAMP, 0);
INSERT INTO merikuri.`users`(first_name, last_name, age, tel, address, email, password, created_at, updated_at, delete_flg)
VALUES('山田', '花子', 15, '080-1234-5678', '東京都港区芝公園４丁目２−８東京タワー', 'sample@gmail.com', 'password', CURRENT_TIMESTAMP,CURRENT_TIMESTAMP, 0);