create database AppSystems;

create table users(
    id serial primary key,
    name varchar(255)
);
-- Many to One
create table role(
    id serial primary key,
    name varchar(255),
    users_id int references users(id)
);

--------------------------------------------------------

create table rules(
    id serial primary key,
    rule varchar(2000)
);
-- Many to Many
create table rules_role(
    id serial primary key,
    role_id int references role(id),
    rules_id int references rules(id)
);

--------------------------------------------------------

-- Many to One
create table item(
    id serial primary key,
    item varchar(255),
    user_id int references users(id),
    commentary_id int references commentary(id),
    attaches_id int references attaches(id)
);
-- One to Many
create table commentary(
    id serial primary key,
    comments varchar(2000)
);

-- One to Many
create table attaches(
    id serial primary key,
    attaches varchar(255)
);

-- Many to one
create table category(
    id serial primary key,
    category varchar(255),
    item_id int references item(id)
);

-- Many to one
create table state(
    id serial primary key,
    state varchar(255),
    item_id int references item(id)
);

insert into users(name) values ('Никита');
insert into users(name) values ('Андрей');
insert into role(name) values ('Разработчик');
insert into role(name) values ('Тестировщик');
insert into rules(rule) values ('Правила написания хорошего кода');
insert into rules(rule) values ('Тестирование всех элементов');
insert into item(item) values ('Заявка на повышение');
insert into item(item) values ('Заявка на увелечиние зарплаты');
insert into commentary(comments) values ('Хорошо себя проявил');
insert into commentary(comments) values ('Тестировал вовремя');
insert into attaches(attaches) values ('Сертификат');
insert into attaches(attaches) values ('Диплом о повышении квалификации');
insert into category(category) values ('Ожидание');
insert into category(category) values ('Принято');
insert into state(state) values ('3481');
insert into state(state) values ('5943');

