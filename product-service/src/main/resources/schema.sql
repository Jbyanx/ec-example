create table if not exists products(
    id SERIAL primary key ,
    name VARCHAR(100) NOT NULL,
    stock int not null,
    price float not null
);