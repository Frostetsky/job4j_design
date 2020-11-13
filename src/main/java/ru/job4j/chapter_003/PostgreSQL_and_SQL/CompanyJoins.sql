create database joins;

create table departments(
    id serial primary key,
    name varchar(255)
);

create table employees(
    id serial primary key,
    name varchar(255),
    departments_id int references departments(id)
);

select * from departments;

insert into departments(name) values ('Development department');
insert into departments(name) values ('HR department');
insert into departments(name) values ('Marketing department');

insert into employees(name, departments_id) values ('Mira Romanchuk', 3);
insert into employees(name, departments_id) values ('Nikita Nesterenko', 1);
insert into employees(name, departments_id) values ('Other User 1', null);
insert into employees(name, departments_id) values ('Polina Zverskaya', 2);
insert into employees(name, departments_id) values ('Petr Arsentev', 1);
insert into employees(name, departments_id) values ('Other User 2', null);

select d.name, e.name from employees d left join departments e on d.departments_id = e.id;
select d.name, e.name from employees d right join departments e on d.departments_id = e.id;
select * from employees cross join departments;
select * from employees d full join departments e on d.departments_id = e.id;

-- Используя left join найти работников, которые не относятся ни к одну из департаментов
select d.name from employees d left join departments e on d.departments_id = e.id where e.name IS NULL;
-- Используя left и right join написать запросы, которые давали бы одинаковый результат.
select d.name, e.name from employees d left join departments e on d.departments_id = e.id;
select d.name, e.name from departments d right join employees e on d.id = e.departments_id;