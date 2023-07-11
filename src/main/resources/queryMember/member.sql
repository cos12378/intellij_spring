show databases ;
use test;
create table members(
                        id int auto_increment primary key ,
                        name varchar(255),
                        age int
);
create table hobbies(
                        id int auto_increment primary key ,
                        name varchar(255),
                        m_id int,
                        foreign key (m_id) references members(id)
);

insert into members(name,age)
values ('김태경', 24);
insert into members(name,age)
values ('이태열', 24);

insert into hobbies(name, m_id)
values ('이론 공부', 2);
insert into hobbies(name, m_id)
values ('그림', 2);
insert into hobbies(name, m_id)
values ('이론 공부', 1);


SELECT
    m.id,
    m.name,
    m.age,
    JSON_ARRAYAGG(JSON_OBJECT('name', h.name)) AS hobbies
FROM
    members m
        LEFT JOIN
    hobbies h ON m.id = h.m_id
GROUP BY m.id;
-- gpt 코드


SELECT
    m.name, m.age, concat('[',GROUP_CONCAT(concat('{"name":"',h.name,'"}')),']') AS hobbies
FROM
    members m
        LEFT JOIN
    hobbies h ON m.id = h.m_id
GROUP BY m.id;

-- 강사님 코드
