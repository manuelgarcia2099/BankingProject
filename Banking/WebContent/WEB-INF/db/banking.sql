create database db_banking;
-- drop database db_banking;

use db_banking;

-- ESTADO
create table tb_estado
(
code_est int auto_increment primary key not null, 
desc_est varchar(50)
);

insert into tb_estado values (1, "Empregado");
insert into tb_estado values (2, "Não Empregado");

-- ESTADO
create table tb_tipo
(
code_tip int auto_increment primary key not null, 
desc_tip varchar(50)
);

insert into tb_tipo values (1, "Especial");
insert into tb_tipo values (2, "Potencial");
insert into tb_tipo values (3, "Comum");

-- ESTADO
create table tb_risco
(
code_ris int auto_increment primary key not null, 
desc_ris varchar(50),
juro_ris decimal(3,1)
);

insert into tb_risco values (1, "A",1.9);
insert into tb_risco values (2, "B",5.0);
insert into tb_risco values (3, "C",10.0);

-- CLIENTE
create table tb_cliente
(
code_cli int auto_increment primary key not null,
name_cli varchar(50),
sobr_cli varchar(50),
rmes_cli decimal(10,2),
end1_cli varchar(100),
end2_cli varchar(100),
patr_cli decimal(10,2),
divi_cli decimal(10,2),
code_est int,
code_tip int,
code_ris int
);
alter table tb_cliente add foreign key(code_est) references tb_estado(code_est);
alter table tb_cliente add foreign key(code_ris) references tb_risco(code_ris);

insert into tb_cliente values (1, 'Lucia','Andrade',9000.00,'rua 1','rua 10',15000.00,null, null,1,1);
insert into tb_cliente values (2, 'Felipe','Cardoso',2500.00,'rua 2','rua 20',null,4000.00,null,2,2);
insert into tb_cliente values (3, 'Luan','Oliveira',1000.00,'rua 2','rua 30',null,null,1,3,3);


-- USUARIO
create table tb_usuario
(
code_use int auto_increment primary key not null,
name_use varchar(50),
sobr_use varchar(50),
emai_use varchar(50),
pass_use varchar(20)
);

insert into tb_usuario values (1, 'Manuel','Garcia','mgarcia@gmp.com','admin');


select * from tb_estado;
select * from tb_risco;
select * from tb_cliente;
select * from tb_usuario;