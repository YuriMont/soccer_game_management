create schema sgm;

use sgm;

create table Conf(
    id int primary key AUTO_INCREMENT,
    pais varchar(20)
);

create table Time(
	id int primary key AUTO_INCREMENT,
    nome varchar(20),
    acro varchar(3),
    nivel int,
    estado varchar(2)
);