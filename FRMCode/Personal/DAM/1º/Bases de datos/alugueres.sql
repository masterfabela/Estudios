alter session set nls_date_format = 'dd.mm.yyyy hh24:mi:ss';

drop table reserva cascade constraints;
drop table coche cascade constraints;
drop table cliente cascade constraints;
drop table profesion cascade constraints;
drop table axencia cascade constraints;
drop table garaxe cascade constraints;
purge recyclebin ;

create table profesion(
codp varchar2(3),
profesion varchar2(15),
primary key (codp));

create table cliente(
codc varchar2(3),
nome varchar2(10),
direcion varchar2(15),
provincia varchar2(15),
edade number(2),
codp varchar2(3),
primary key (codc),
foreign key (codp) references profesion(codp) );

create table axencia(
coda varchar2(3),
direcion varchar2(15),
primary key (coda));

create table garaxe(
codg varchar2(4),
direcion varchar2(15),
primary key (codg));

create table coche(
codco varchar2(4),
marca varchar2(10),
codg varchar2(3),
primary key (codco),
foreign key (codg) references garaxe(codg));

create table reserva(
codc varchar2(3),
codco varchar2(4),
fr date,
coda varchar2(3),
primary key (codc,codco,fr),
foreign key (coda) references axencia(coda),
foreign key (codc) references cliente(codc),
foreign key (codco) references coche(codco));


--datos profesion
insert into profesion values('p1','informatico');
insert into profesion values('p2','eletricista');
insert into profesion values('p3','carpinteiro');
insert into profesion values('p4','mestre');
insert into profesion values('p5','gandeiro');
insert into profesion values('p6','administrativo');

--datos cliente
insert into cliente values('c1','luis','r/peixe','pontevedra',35,'p5');
insert into cliente values('c2','ana','r/lua','lugo',30,'p1');
insert into cliente values('c3','pedro','r/sol','pontevedra',19,'p3');
insert into cliente values('c4','juan','r/pedra','corunha',20,'p2');
insert into cliente values('c5','maria','r/arbore','ourense',40,'p1');
insert into cliente values('c6','leon','r/dente','ourense',50,'p1');
insert into cliente values('c7','borja','r/roxa','pontevedra',26,'p2');

--datos axencia
insert into axencia values('a4','r/ave');
insert into axencia values('a1','r/pez');
insert into axencia values('a2','r/luna');
insert into axencia values('a3','r/sol');

--datos garaxe
insert into garaxe values('g4','r/klimt');
insert into garaxe values('g1','r/velazquez');
insert into garaxe values('g2','r/murillo');
insert into garaxe values('g3','r/virxilio');

--datos coche
insert into coche values('co1','opel','g1');
insert into coche values('co2','opel','g2');
insert into coche values('co3','citroen','g1');
insert into coche values('co4','renault','g3');
insert into coche values('co5','mercedes','g2');
insert into coche values('co6','seat','g3');
insert into coche values('co7','opel','g1');
insert into coche values('co8','opel','g1');
insert into coche values('co9','citroen','g2');

--datos reserva
insert into reserva values('c1','co1','3/6/2009','a1');
insert into reserva values('c2','co1','1/6/2009','a2');
insert into reserva values('c1','co6','2/7/2009','a1');
insert into reserva values('c3','co2','1/6/2009','a3');
insert into reserva values('c4','co5','2/8/2009','a1');
insert into reserva values('c1','co3','1/6/2009','a2');
insert into reserva values('c2','co2','3/6/2009','a1');
commit;
set serveroutput on

