create schema sgm;

use sgm;

create table Conf(
    id int primary key AUTO_INCREMENT,
    pais varchar(20);
    id_Liga foreign key,
    id_Copa foreign key,
    foreign key id_Liga references Liga(id),
    foreign key id_Copa references Copa(id)
);

create table Time(
	id int primary key AUTO_INCREMENT,
    nome varchar(20),
    acro varchar(3),
    nivel int,
    estado varchar(2),
    pontos_liga int,
    gols_marcados int,
    gols_sofridos int,
    vitorias int,
    empates int,
    derrotas int,
    saldo int,
    id_conf foreign key,
    id_liga foreign key,
    id_copa foreign key,
    foreign key id_conf references Conf(id)
    foreign key liga references Liga(id),
    foreign key copa references Copa(id)
);

create table Liga(
    id int primary key AUTO_INCREMENT,
    
    
);

create table Copa(
    id int primary key AUTO_INCREMENT,
);