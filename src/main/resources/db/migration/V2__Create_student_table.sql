create table student(
    idnp varchar(13) primary key ,
    first_name varchar(30) not null,
    last_name varchar(30) not null ,
    email varchar(50) unique not null,
    media float(2),
    university_id int,
    constraint fk_university_id foreign key (university_id) references university(id)
);