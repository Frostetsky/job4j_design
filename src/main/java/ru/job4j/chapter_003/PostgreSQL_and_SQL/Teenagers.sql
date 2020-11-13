create database teenagers;

create table teenagers(
    name varchar(255),
    gender varchar(5)
);

insert into teenagers(name, gender) values ('Дима', 'М');
insert into teenagers(name, gender) values ('Полина', 'Ж');
insert into teenagers(name, gender) values ('Александра', 'Ж');
insert into teenagers(name, gender) values ('Влад', 'М');
insert into teenagers(name, gender) values ('Никита', 'М');


-- Создать таблицу teens с атрибутами name, gender и заполнить ее.
-- Используя cross join составить все возможные разнополые пары.
SELECT * FROM teenagers A CROSS JOIN teenagers B where A.gender != B.gender;