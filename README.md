```sql
create user 'test1'@'%' identified by 'bitc5600';
GRANT ALL PRIVILEGES ON *.* TO 'test1'@'%';
create database test1;
use test1;

CREATE TABLE user(
	id int auto_increment primary key,
    username varchar(300),
    password  varchar(1500),
    email  varchar(1500),
    name   varchar(200),
    gender  varchar(100),
    phone varchar(1500),
    address varchar(2000),
    detail_address varchar(1500),
    birthday timestamp,
    total_amount int,
    role varchar(150),
    cancel varchar(1000),
    profile varchar(4500),
createDate timestamp
) engine=InnoDB default charset=utf8;
```
