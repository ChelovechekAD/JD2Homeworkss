DROP TABLE IF EXISTS homework6.people;
CREATE TABLE homework6.people
                    (id    integer generated always as identity
                        constraint people_pk primary key,
                    age              integer      not null,
                    salary           float4       not null,
                    passport         varchar(10)  not null,
                    address          varchar(200) not null,
                    "dateOfBirthday" date       not null,
                    "dateTimeCreate" timestamp  not null,
                    "timeToLunch"    time       not null);