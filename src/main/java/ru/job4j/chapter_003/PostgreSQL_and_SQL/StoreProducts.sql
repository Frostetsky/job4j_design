create database score;

create table product(
    id serial primary key,
    name varchar(255),
    type_id int references type(id),
    expired_date date,
    price int
);

create table type(
    id serial primary key,
    name varchar(255)
);

insert into type(name) values ('Хлеб');
insert into type(name) values ('Сыр');
insert into type(name) values ('Молоко');
insert into type(name) values ('Макароны');
insert into type(name) values ('Замороженные продукты');

insert into product(name, type_id, expired_date, price) VALUES ('Пармезан', 2, '2020-11-05', 999);
insert into product(name, type_id, expired_date, price) VALUES ('Честер', 2, '2020-11-05', 949);
insert into product(name, type_id, expired_date, price) values ('Спагетти', 4, '2021-12-01', 86);
insert into product(name, type_id, expired_date, price) values ('Вермишель', 4, '2021-12-15', 79);
insert into product(name, type_id, expired_date, price) values ('Простоквашино', 3, '2020-11-03', 114);
insert into product(name, type_id, expired_date, price) values ('Домик в деревне', 3, '2020-11-12', 112);
insert into product(name, type_id, expired_date, price) values ('Белый Хлеб', 1, '2020-10-15', 37);
insert into product(name, type_id, expired_date, price) values ('Черный Хлеб', 1, '2020-10-15', 39);
insert into product(name, type_id, expired_date, price) values ('Мороженное Эскимо', 5, '2020-10-30', 23);
insert into product(name, type_id, expired_date, price) values ('Пельмени', 5, '2021-06-15', 341);
insert into product(name, type_id, expired_date, price) values ('Креветки', 5, '2021-11-26', 1465);
insert into product(name, type_id, expired_date, price) values ('Нагетсы', 5, '2020-10-27', 129);
insert into product(name, type_id, expired_date, price) values ('Блины замороженные', 5, '2020-10-27', 241);
insert into product(name, type_id, expired_date, price) values ('Картофель фри замороженный', 5, '2021-02-15', 352);

select * from type;
select * from product;

-- 1. Написать запрос получение всех продуктов с типом "СЫР"
select * from type where name = 'Сыр';
-- 2. Написать запрос получения всех продуктов, у кого в имени есть слово "мороженное".
select * from product where name like '%Мороженное%';
-- 3. Написать запрос, который выводит все продукты, срок годности которых заканчивается в следующем месяце.
select * from product where date(expired_date) between '2020-11-01' and '2020-11-30';
-- 4. Написать запрос, который выводит самый дорогой продукт.
select * from product where price = (select max(price) from product);
-- 5. Написать запрос, который выводит количество всех продуктов определенного типа.
select count(type_id) from product where type_id = 5; -- 1/2/3/4/5
-- 6. Написать запрос получение всех продуктов с типом "Сыр" и "Молоко"
select * from product where (type_id = 2 or type_id = 3);
-- 7. Написать запрос, который выводит тип продуктов, которых осталось меньше 10 штук.
select name from type where (select count(p.id) from product as p where p.type_id = type.id) < 10;
-- 8. Вывести все продукты и их тип.
select p.name, t.name from product as p left join type as t on t.id = p.type_id;
