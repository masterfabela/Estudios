set pagesize 80
set linesize 255
alter session set nls_date_format = 'dd.mm.yyyy hh24:mi:ss';
drop table prescriben cascade constraints;
drop table asignan cascade constraints;
drop table cat2 cascade constraints;
drop table cat1 cascade constraints;
drop table ten cascade constraints;
drop table balnearios cascade constraints;
drop table medicos cascade constraints;
drop table agudos cascade constraints;
drop table cronicos cascade constraints;
drop table aloxan cascade constraints;
drop table habitacions cascade constraints;
drop table hoteis cascade constraints;
drop table padecen cascade constraints;
drop table pacientes cascade constraints;
drop table poboacions cascade constraints;
drop table indicadas cascade constraints;
drop table zonas_corporais cascade constraints;
drop table compon cascade constraints;
drop table augas cascade constraints;
drop table minerais cascade constraints;
purge recyclebin ;


create table   minerais (
codm varchar2(3),
nomm varchar2(15),
primary key (codm )
);

insert into minerais values ('m1','sodio');
insert into minerais values ('m2','magnesio');
insert into minerais values ('m3','calcio');
insert into minerais values ('m4','cloro');
insert into minerais values ('m5','ferro');
insert into minerais values ('m6','arsenico');
insert into minerais values ('m7','azufre');



create table   augas (
coda varchar2(3),
tipo varchar2(20),
primary key ( coda)
);

insert into augas values ('a1','bicarbonatadas');
insert into augas values ('a2','cloradas');
insert into augas values ('a3','sulfuradas');
insert into augas values ('a4','ferruginosas');
insert into augas values ('a5','radiactivas');
insert into augas values ('a6','oligometalicas');
insert into augas values ('a7','sulfatadas');

create table   compon (
coda varchar2(3),
codm varchar(2),
mg integer,
primary key ( coda,codm),
foreign key (coda) references   augas(coda )  ,
foreign key (codm ) references  minerais(codm ) 
);

insert into compon values('a1','m1',3);
insert into compon values('a1','m3',2);
insert into compon values('a2','m4',4);
insert into compon values('a3','m1',4);
insert into compon values('a3','m3',6);
insert into compon values('a3','m4',7);
insert into compon values('a4','m5',9);
insert into compon values('a7','m1',10);
insert into Compon values('a3','m2',10);

create table   zonas_corporais (
codz varchar2(3),
nomz varchar2(15),
primary key (codz )
);

insert into zonas_corporais values('z1','pulmon');
insert into zonas_corporais values('z2','corazon');
insert into zonas_corporais values('z3','ril');
insert into zonas_corporais values('z4','articulacions');
insert into zonas_corporais values('z5','nervios');
insert into zonas_corporais values('z6','estomago');
insert into zonas_corporais values('z7','intestino');
insert into zonas_corporais values('z8','figado');
insert into zonas_corporais values('z9','sangre');
insert into zonas_corporais values('z10','musculos');


create table indicadas   (
coda varchar2(3),
codz varchar2(3),
primary key ( coda,codz),
foreign key (coda) references augas(coda ) ,
foreign key (codz ) references zonas_corporais(codz )  
);

insert into indicadas values ('a1','z3');
insert into indicadas values ('a1','z6');
insert into indicadas values ('a1','z7');
insert into indicadas values ('a1','z8');
insert into indicadas values ('a2','z6');
insert into indicadas values ('a3','z1');
insert into indicadas values ('a4','z9');
insert into indicadas values ('a5','z4');
insert into indicadas values ('a5','z5');
insert into indicadas values ('a5','z10');
insert into indicadas values ('a6','z3');
insert into indicadas values ('a7','z3');
insert into indicadas values ('a7','z6');


create table poboacions(
codp varchar2(3),
nomp varchar2(15),
primary key(codp)
);

insert into poboacions values ('p1','toxa');
insert into poboacions values ('p2','arteixo');
insert into poboacions values ('p3','tuy');
insert into poboacions values ('p4','mondariz');
insert into poboacions values ('p5','lugo');
insert into poboacions values ('p6','arnoia');
insert into poboacions values ('p7','brea');
insert into poboacions values ('p8','davila');
insert into poboacions values ('p9','carballo');
insert into poboacions values ('p10','carballino');
insert into poboacions values ('p11','partovia');
insert into poboacions values ('p12','cuntis');
insert into poboacions values ('p13','guitiriz');
insert into poboacions values ('p14','molgas');
insert into poboacions values ('p15','vigo');
insert into poboacions values ('p16','ourense');
insert into poboacions values ('p17','coruna');
insert into poboacions values ('p18','santiago');
insert into poboacions values ('p19','cangas');
insert into poboacions values ('p20','bueu');
insert into poboacions values ('p21','moimenta');


create table pacientes   (
nif varchar2(9),
nomp varchar2(15),
ingm integer,
codp varchar2(3),
primary key (nif),
foreign key(codp) references poboacions(codp)
);

insert into pacientes values ('361','luis',1000,'p21');
insert into pacientes values ('362','ana',1200,'p2');
insert into pacientes values ('363','carlos',1300,'p4');
insert into pacientes values ('364','pedro',900,'p7');
insert into pacientes values ('365','bea',850,'p8');
insert into pacientes values ('366','eva',1400,'p9');
insert into pacientes values ('367','bea',1600,null);
insert into pacientes values ('368','carlos',1250,'p9');
insert into pacientes values ('369','xoan',1100,'p8');
insert into pacientes values ('3610','bieito',950,'p7');
insert into pacientes values ('3611','carmen',800,null);
insert into pacientes values ('3612','elisa',1300,'p4');
insert into pacientes values ('3613','mario',1000,'p7');
insert into pacientes values ('3614','palmira',1150,'p9');
insert into pacientes values ('3615','lucia',1200,'p10');
insert into pacientes values ('3616','xose',1300,'p10');
insert into pacientes values ('3617','antia',1250,'p9');
insert into pacientes values ('3618','iria',1450,'p5');


create table padecen(
nif varchar2(9),
codz varchar2(3),
primary key(nif,codz),
foreign key (nif)  references pacientes (nif),
foreign key (codz)  references zonas_corporais(codz)
);

insert into padecen values ('361','z1');
insert into padecen values ('361','z2');
insert into padecen values ('362','z1');
insert into padecen values ('362','z3');
insert into padecen values ('363','z4');
insert into padecen values ('364','z5');
insert into padecen values ('365','z6');
insert into padecen values ('366','z7');
insert into padecen values ('367','z6');
insert into padecen values ('368','z1');
insert into padecen values ('369','z2');
insert into padecen values ('3610','z2');
insert into padecen values ('3611','z2');
insert into padecen values ('3612','z2');
insert into padecen values ('3612','z3');
insert into padecen values ('3613','z4');
insert into padecen values ('3614','z5');
insert into padecen values ('3616','z4');
insert into padecen values ('3617','z5');
insert into padecen values ('3618','z2');
insert into padecen values ('3615','z2');
insert into padecen values ('3615','z3');
insert into padecen values ('3615','z4');
insert into padecen values ('3618','z6');



create table  hoteis  (
codh varchar2(3),
nomh varchar2(15),
primary key ( codh)
);

insert into hoteis values ('h1','mexico');
insert into hoteis values ('h2','andurina');
insert into hoteis values ('h3','solpor');
insert into hoteis values ('h4','melia');
insert into hoteis values ('h5','ibis');
insert into hoteis values ('h6','carballo');
insert into hoteis values ('h7','cairo');
insert into hoteis values ('h8','paris');



create table  habitacions  (
codh varchar2(3),
n integer,
interede varchar2(1),
primary key (codh,n ),
foreign key ( codh) references   hoteis (codh )  
);

insert into habitacions values('h1',1,'s');
insert into habitacions values('h1',2,'n');
insert into habitacions values('h2',1,'s');
insert into habitacions values('h2',2,'n');
insert into habitacions values('h2',3,'n');
insert into habitacions values('h3',1,'s');
insert into habitacions values('h4',1,'s');
insert into habitacions values('h4',2,'s');
insert into habitacions values('h4',3,'n');
insert into habitacions values('h5',1,'n');
insert into habitacions values('h5',2,'n');

create table  aloxan  (
nif varchar2(9),
codh varchar2(3),
n integer,
de date,
ds date,
primary key ( nif,codh,n,de),
foreign key (nif  ) references   pacientes(nif),
foreign key (codh,n  ) references   habitacions(codh,n)
);


insert into aloxan values ('361','h1',1,'7/5/2012','17/5/2012');
insert into aloxan values ('362','h4',2,'9/6/2012','15/6/2012');
insert into aloxan values ('364','h5',1,'13/8/2012','23/8/2012');
insert into aloxan values ('361','h1',2,'6/6/2013','17/6/2013');
insert into aloxan values ('364','h3',1,'10/9/2012','20/9/2012');
insert into aloxan values ('365','h3',1,'21/4/2012','30/4/2012');
insert into aloxan values ('366','h4',2,'12/11/2012','22/11/2012');
insert into aloxan values ('362','h4',3,'10/7/2013','19/7/2013');

insert into aloxan values ('3612','h4',1,'15/7/2013','25/7/2013');
insert into aloxan values ('3612','h1',1,'2/7/2013','12/7/2013');
insert into aloxan values ('3613','h3',1,'13/7/2013','23/7/2013');
insert into aloxan values ('3614','h4',3,'10/9/2013','20/9/2013');
insert into aloxan values ('3615','h2',1,'1/7/2013','10/7/2013');
insert into aloxan values ('3615','h4',3,'12/11/2013','22/11/2013');






create table   cronicos (
nif varchar2(9),
primary key (nif ),
foreign key (nif ) references  pacientes (nif)  
);

insert into cronicos values('361');
insert into cronicos values('362');
insert into cronicos values('363');
insert into cronicos values('364');
insert into cronicos values('365');
insert into cronicos values('366');
insert into cronicos values('367');
insert into cronicos values('368');
insert into cronicos values('369');

create table   agudos (
nif varchar2(9),
primary key (nif ),
foreign key (nif ) references  pacientes (nif)  
);

insert into agudos values('3610');
insert into agudos values('3611');
insert into agudos values('3612');
insert into agudos values('3613');
insert into agudos values('3614');
insert into agudos values('3615');
insert into agudos values('3616');
insert into agudos values('3617');
insert into agudos values('3618');

create table   medicos (
codme varchar2(3),
nomme varchar2(15),
xef varchar2(15),
primary key (codme),
foreign key (xef) references medicos(codme)
);

insert into medicos values ('m1','federico', null);
insert into medicos values ('m2','anabel',null);
insert into medicos values ('m3','rosa','m1');
insert into medicos values ('m4','francisco','m1');
insert into medicos values ('m5','elena','m2');
insert into medicos values ('m6','mario','m5');
insert into medicos values ('m7','manuel','m2');


create table  balnearios   (
codb varchar2(3),
nomb varchar2(18),
telf integer,
costed integer,
codp varchar2(3),
primary key (codb),
foreign key (codp) references poboacions(codp)
);

insert into balnearios values ('b1','banos_de_molgas',988654321,50,'p14');
insert into balnearios values ('b2','banos_de_brea',981232154,40,'p7');
insert into balnearios values ('b3','termas_de_cuntis',986458765,45,'p12');
insert into balnearios values ('b4','caldas_de_partovia',988545432,40,'p11');
insert into balnearios values ('b5','mondariz',986589767,55,'p4');
insert into balnearios values ('b6','arnoia',988765412,40,'p6');
insert into balnearios values ('b7','acuna',982769889,40,'p8');
insert into balnearios values ('b8','toxa',986564322,55,'p1');
insert into balnearios values ('b9','arteixo',981232123,40,'p2');
insert into balnearios values ('b10','caldelas de tuy',986512121,35,'p3');



create table  ten  (
codb varchar2(3),
coda varchar2(3),
primary key (codb,coda),
foreign key (codb) references  balnearios(codb )  ,
foreign key (coda) references   augas( coda)  
);

insert into ten values('b1','a1');
insert into ten values('b1','a2');
insert into ten values('b2','a2');
insert into ten values('b3','a3');
insert into ten values('b4','a1');
insert into ten values('b5','a2');
insert into ten values('b5','a3');
insert into ten values('b6','a3');
insert into ten values('b6','a4');
insert into ten values('b6','a5');
insert into ten values('b7','a5');
insert into ten values('b7','a4');
insert into ten values('b8','a4');

create table cat1   (
codb varchar2(3),
fisioterapeuta varchar2(1),
primary key ( codb),
foreign key (codb ) references  balnearios (codb )  
);
insert into cat1 values ('b1','s');
insert into cat1 values ('b2','n');
insert into cat1 values ('b3','s');
insert into cat1 values ('b4','s');
insert into cat1 values ('b5','n');


create table  cat2  (
codb varchar2(3),
primary key ( codb),
foreign key (codb ) references  balnearios (codb )  
);

insert into cat2 values ('b6');
insert into cat2 values ('b7');
insert into cat2 values ('b8');
insert into cat2 values ('b9');
insert into cat2 values ('b10');


create table  asignan  (
nif varchar2(9),
codb varchar2(3),
codme varchar2(3),
dec date,
dsc date,
primary key (nif,codb,codme,dec ),
foreign key ( nif) references     cronicos   ( nif)  ,
foreign key ( codb) references    balnearios    (codb ),
foreign key ( codme) references   medicos     ( codme)  
);

insert into asignan values ('361','b1','m1','8/5/2012','17/5/2012');
insert into asignan values ('362','b2','m1','10/6/2012','15/6/2012');
insert into asignan values ('364','b3','m2','14/8/2012','23/8/2012');
insert into asignan values ('361','b4','m2','7/6/2013','17/6/13');
insert into asignan values ('364','b4','m2','11/9/2012','20/9/2012');
insert into asignan values ('365','b4','m4','22/4/2012','30/4/2012');
insert into asignan values ('366','b5','m4','13/11/2012','22/11/2012');
insert into asignan values ('362','b4','m5','11/7/2013','20/7/2013');



create table  prescriben  (
nif varchar2(9),
codb varchar2(3),
codme varchar2(3),
dea date,
dsa date,
primary key (nif,codb,codme,dea ),
foreign key ( nif) references     agudos   ( nif)  ,
foreign key ( codb) references    cat2    (codb ) , 
foreign key ( codme) references   medicos     ( codme)  
);


insert into prescriben values ('3612','b6','m1','16/7/2013','25/7/2013');
insert into prescriben values ('3612','b6','m3','3/7/2013','12/7/2013');
insert into prescriben values ('3613','b7','m4','14/7/2013','23/7/2013');
insert into prescriben values ('3614','b7','m4','11/9/2013','20/9/2013');
insert into prescriben values ('3615','b9','m5','2/7/2013','10/7/2013');
insert into prescriben values ('3615','b6','m5','13/11/2013','22/11/2013');



commit;



