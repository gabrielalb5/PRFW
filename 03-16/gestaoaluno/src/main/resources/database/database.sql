drop database if exists atrasos;
create database atrasos;
use atrasos;

create table ocorrencias(
	id int not null  auto_increment primary key,
    nome_aluno varchar(255),
    horario datetime,
    justificativa varchar(500)
);

select * from ocorrencias;