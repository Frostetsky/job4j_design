create database cars;

create table body(
    id serial primary key,
    body varchar(255)
);

create table engine(
    id serial primary key,
    engine varchar(255)
);

create table gearbox(
    id serial primary key,
    gearbox varchar(255)
);

create table car(
    id serial primary key,
    name varchar(255),
    body_id int references body(id),
    engine_id int references engine(id),
    gearbox_id int references gearbox(id)
);

insert into gearbox(gearbox) values ('Автомат');
insert into gearbox(gearbox) values ('Механика');
insert into gearbox(gearbox) values ('Автопилот');

insert into body(body) values ('Седан');
insert into body(body) values ('Универсал');
insert into body(body) values ('Хэтчбек');
insert into body(body) values ('Внедорожник');
insert into body(body) values ('Грузовик');

insert into engine(engine) values ('Бензиновый');
insert into engine(engine) values ('Дизельный');
insert into engine(engine) values ('Газовый');
insert into engine(engine) values ('Роторно-Поршневой');

select * from gearbox;
select * from body;
select * from engine;

insert into car(name, body_id, engine_id, gearbox_id) values ('Тойота', 1, 1, 1);
insert into car(name, body_id, engine_id, gearbox_id) values ('Кио', 3, 1, 1);
insert into car(name, body_id, engine_id, gearbox_id) values ('УАЗ', 4, 2, 2);
insert into car(name, body_id, engine_id, gearbox_id) values ('Автоваз', 5, 2, 2);

-- Создать SQL запросы:
-- ==================================================================================================
-- 1. Вывести список всех машин и все привязанные к ним детали.
select name, body, engine, gearbox from car c
    inner join body b on c.body_id = b.id
    inner join engine e on c.engine_id = e.id
    inner join gearbox g on c.gearbox_id = g.id;
-- ==================================================================================================
-- 2. Вывести отдельно детали, которые не используются в машине, кузова, двигатели, коробки передач.
select body from car c right join body b on b.id = c.body_id where name is null;
select engine from car c right join engine e on e.id = c.engine_id where name is null;
select gearbox from car c right join gearbox g on g.id = c.gearbox_id where name is null;