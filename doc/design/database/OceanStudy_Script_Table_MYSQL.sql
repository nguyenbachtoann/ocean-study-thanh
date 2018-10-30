use oceanstudy;
drop table if exists os_fish;
create table os_fish (
	id int auto_increment not null,
    name varchar(50),
    weight int,
    length int,
    height int,
    deep int,
    age int,
    img varchar(250),
    video varchar(250),
    primary key (id)
);





