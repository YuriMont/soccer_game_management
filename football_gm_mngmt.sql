create schema sgm;

use sgm;

create table Time(
	id int primary key AUTO_INCREMENT,
    nome varchar(20),
    acro varchar(3),
    nivel int,
    estado varchar(2),
    pontos_liga int,
    gols_marcados int,
    gols_sofridos int,
    saldo int
    
    );