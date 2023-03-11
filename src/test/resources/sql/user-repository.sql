INSERT INTO merikuri.users
(id, first_name, last_name, age, tel, address, email, password, created_at, updated_at, delete_flg) VALUES

--findByEmail
(100, 'FIRST_NAME', 'LAST_NAME', 10, '090-1234-5678', 'ADDRESS', 'test1@gmail.com', 'PASSWORD1', '2023-02-19 10:47:19', '2023-02-19 10:47:19', 0),
--ダミーデータ
(101, 'FIRST_NAME', 'LAST_NAME', 10, '090-1234-5678', 'ADDRESS', 'test1@gmail.com', 'PASSWORD1', '2023-02-19 10:47:19', '2023-02-19 10:47:19', 1),

--findByEmailAndPassword
(102, 'FIRST_NAME', 'LAST_NAME', 10, '090-1234-5678', 'ADDRESS', 'test2@gmail.com', 'PASSWORD2', '2023-02-19 10:47:19', '2023-02-19 10:47:19', 0),
--ダミーデータ
(103, 'FIRST_NAME', 'LAST_NAME', 10, '090-1234-5678', 'ADDRESS', 'test2@gmail.com', 'PASSWORD1', '2023-02-19 10:47:19', '2023-02-19 10:47:19', 0),
(104, 'FIRST_NAME', 'LAST_NAME', 10, '090-1234-5678', 'ADDRESS', 'test2@gmail.com', 'PASSWORD2', '2023-02-19 10:47:19', '2023-02-19 10:47:19', 1)
;
