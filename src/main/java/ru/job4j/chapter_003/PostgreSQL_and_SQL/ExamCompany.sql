create database exCompany;

-- 1) Retrieve in a single query.
-- - names of all persons that are NOT in the company with id = 5.
-- - company name for each person.
-- 2) Select the name of the company with the maximum number of persons and number of persons in this company.

CREATE TABLE company (
    id integer NOT NULL,
    name character varying,
    CONSTRAINT company_pkey PRIMARY KEY (id)
);


CREATE TABLE person (
    id integer NOT NULL,
    name character varying,
    company_id integer references company(id),
    CONSTRAINT person_pkey PRIMARY KEY (id)
);

insert into company(id, name) values (1, 'Тинькофф');
insert into company(id, name) values (2, 'Сбербанк');
insert into company(id, name) values (5, 'Альфа-Банк');
insert into company(id, name) values (7, 'ВТБ');
insert into company(id, name) values (8, 'Почта Банк');

insert into person(id, name, company_id) values (1, 'Java Developer Nikita', 5);
insert into person(id, name, company_id) values (2, 'Java Developer Andrey', 5);
insert into person(id, name, company_id) values (3, 'JavaScript Developer Vlad', 2);
insert into person(id, name, company_id) values (4, 'JavaScript Developer Sergey', 2);
insert into person(id, name, company_id) values (5, 'PHP Developer Dmitriy', 7);
insert into person(id, name, company_id) values (6, 'PHP Developer Aleksandr', 7);
insert into person(id, name, company_id) values (7, 'C++ Developer Edgar', 1);
insert into person(id, name, company_id) values (8, 'Scala Developer Ksenia', 8);
insert into person(id, name, company_id) values (9, 'Android Developer Petr', null);
insert into person(id, name, company_id) values (10, 'IOS Developer Vladimir', null);
insert into person(id, name, company_id) values (11, 'Java Developer Kirill', 5);


-- Names of all persons that are NOT in the company with id = 5.
-- Company name for each person.
select person.name, c.name
from person
full outer join company c on person.company_id = c.id
where company_id != 5;

-- Select the name of the company with the maximum number of persons and number of persons in this company.
select count(c.name), c.name as name
from person
right join company c on person.company_id = c.id
group by c.name
order by c.name limit 1;