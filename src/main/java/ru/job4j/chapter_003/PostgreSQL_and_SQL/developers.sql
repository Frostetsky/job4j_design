create database developers;

create table developers(
    id serial primary key,
    name varchar(255),
    level text
);

insert into developers(name, level) values ('Nikita Nesterenko', 'Junior');
insert into developers(name, level) values ('Petr Arsentev', 'Senior');

select * from developers;

update developers set level = 'Team Leader';

delete from developers;