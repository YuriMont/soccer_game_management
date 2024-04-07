create schema sgm;

use sgm;

create table Conf(
    id int primary AUTO_INCREMENT,
    pais varchar(20);
    liga varchar(25);
    copa varchar(25);
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
    liga foreign key,
    copa foreign key,
    foreign key id_conf references Conf(id)
    foreign key liga references Conf(liga),
    foreign key copa references Conf(Copa)
);

create table Liga(
    id int primary key AUTO_INCREMENT,
    
);

create table Copa();