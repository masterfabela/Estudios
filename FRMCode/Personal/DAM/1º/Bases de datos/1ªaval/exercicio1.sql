drop table persoas;
drop table cidades;
create table cidades(
codc integer,
nomc varchar2(15),
primary key (codc)
);
create table persoas(
numero integer,
dni varchar2(9) unique,
nome varchar2(15),
codc integer,
primary key (numero),
foreign key (codc) references cidades (codc)
);
insert into cidades values(1,'vigo');
insert into cidades values(2,'lugo');
insert into cidades values(3,'ourense');
insert into cidades values(4,'vigo');
insert into persoas values(1,'361a','luis',2);
insert into persoas values(2,'362b','ana',2);
insert into persoas values(3,'363c','eva',1);
insert into persoas values(4,'364d',null,null);
insert into persoas values(5,'365e','Eva',null);
insert into persoas values(6,'366','pepita',3);
commit;

