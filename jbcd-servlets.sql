select version();
create database bd_cidades;
use bd_cidades;

create table estado(
	estid int auto_increment primary key,
    estnome varchar(50) not null,
    estsigla char(2) not null
);


create table cidade(
	cidid int auto_increment primary key,
    cidnome varchar(80) not null,
    cidestcid int not null,
    foreign key (cidestcid) references estado(estid)
);

insert into estado (estnome, estsigla)
values ('Amazonas', 'AM');

insert into estado (estnome, estsigla)
values ('Pará', 'PA');

insert into cidade (cidnome, cidestcid) 
values ('Manaus', 1), ('Manacapuru', 1), ('Parintins', 1),
		('Belém', 2), ('Santarém', 2);
        
select * from estado;
select * from cidade;