drop database if exists aula11;

create database aula11;

use aula11;

create table funcionario(
	idfuncionario integer auto_increment primary key,
	nome varchar(40) not null,
	email varchar(40) not null,
	admissao date not null
) Engine=InnoDB;

create table endereco(
	idendereco integer auto_increment primary key,
	cep varchar(40) not null,
	rua varchar(40) not null,
	cidade varchar(40) not null,
	idfuncionario integer,
	FOREIGN KEY (idfuncionario) REFERENCES funcionario(idfuncionario)
	  ON DELETE CASCADE
	  ON UPDATE CASCADE
	  
)Engine=InnoDB;

show tables;



