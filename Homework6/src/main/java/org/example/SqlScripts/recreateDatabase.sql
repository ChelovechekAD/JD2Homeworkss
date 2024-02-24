DROP TABLE IF EXISTS jd2lessons.people;
CREATE TABLE jd2lessons.people
(
    id               integer auto_increment,
        constraint people_pk
            primary key(id),
    age              integer      not null,
    salary           float4       not null,
    passport         varchar(10)  not null,
    address          varchar(200) not null,
    dateOfBirthday date         not null,
    dateTimeCreate timestamp    not null,
    timeToLunch    time         not null
);