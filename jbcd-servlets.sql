select version();
create table bd_cidades;

use bd_cidades;

create table estado (
id int auto_increment primary key,
nome varchar(50) not null,
sigla char(2) not null
);
create table cidade (
id int auto_increment primary key,
nome varchar(80) not null,
id_estado int not null,
foreign key (id_estado) references estado(id)
);

insert into estado (nome, sigla) 
values ('Amazonas', 'AM'), ('Pará', 'PA');

insert into cidade (nome, id_estado) 
values ('Manaus', 1), ('Manacapuru', 1), ('Parintins', 1),
		('Belém', 2), ('Santarém', 2);