alter session set nls_date_format = 'dd.mm.yyyy hh24:mi:ss';
drop table xoga cascade constraints;
drop table interven cascade constraints;
drop table partido cascade constraints;
drop table xogador cascade constraints;
drop table adestra cascade constraints;
drop table estadio cascade constraints;
drop table equipo cascade constraints;
drop table colexiado cascade constraints;
purge recyclebin;

create table equipo(
codequ varchar(3),
nomequ varchar(17),
numx integer,
primary key (codequ));


create table estadio(
codest varchar(3),
nomest varchar(11),
primary key (codest));


create table xogador (
codx varchar(3),
nomx varchar(11),
codequ varchar(3),
salario integer,
datan date,
primary key (codx),
foreign key (codequ) references equipo(codequ));


create table adestra (
codequ varchar(3),
ano integer,
codest varchar(3),
primary key (codequ,ano),
foreign key (codequ) references equipo(codequ),
foreign key (codest) references estadio(codest));


create table partido(
codpar varchar(3),
nompar varchar(21),
data date,
codest varchar(3),
primary key (codpar),
foreign key (codest) references estadio(codest));

create table xoga (
codx varchar(3),
codpar varchar(3),
posto integer,
primary key (codx,codpar),
foreign key (codx) references xogador(codx),
foreign key (codpar) references partido(codpar));

create table colexiado(
codc varchar(3),
nomc varchar(11),
primary key (codc));

create table interven (
codc varchar(3),
codpar varchar(3),
funcion integer,
primary key (codc,codpar),
foreign key (codc) references colexiado(codc),
foreign key (codpar) references partido(codpar));




insert into equipo values('e1','cuspedrinos',null);
insert into equipo values('e2','gambusinos',null);
insert into equipo values('e3','croques',null);
insert into equipo values('e4','reboludos',null);
insert into equipo values('e5','novo',null);

insert into estadio values('es1','playero');
insert into estadio values('es2','montana');
insert into estadio values('es3','plano');
insert into estadio values('es4','aereo');

insert into xogador values('x1','luis','e1',2000,'3/1/1990');
insert into xogador values('x2','juan','e3',1500,'13/4/1991');
insert into xogador values('x3','pedro','e4',1000,'12/11/1990');
insert into xogador values('x4','alberto','e2',1000,'1/7/1990');
insert into xogador values('x5','juan','e1',1200,'23/8/1990');
insert into xogador values('x6','luis','e1',800,'12/9/1990');
insert into xogador values('x7','carlos','e3',null,'8/10/1990');
insert into xogador values('x8','pedro','e4',3000,'7/6/1990');
insert into xogador values('x9','bent','e4',1500,'23/4/1990');
insert into xogador values('x10','manuel','e4',null,'25/12/1990');
insert into xogador values('x11','antonio','e3',2000,'16/6/1990');
insert into xogador values('x12','eliseo','e4',1350,'14/5/1990');
insert into xogador values('x13','juan','e2',2000,'7/4/1990');
insert into xogador values('x14','federico','e1',1000,'5/1/1990');
insert into xogador values('x15','leon','e1',null,'27/11/1990');

insert into adestra values('e1',2000,'es1');
insert into adestra values('e1',2001,'es1');
insert into adestra values('e2',2000,'es3');
insert into adestra values('e3',2000,'es2');
insert into adestra values('e2',2002,'es1');
insert into adestra values('e2',2003,'es1');
insert into adestra values('e3',2002,'es2');

insert into partido values('p1','cuspedrinoscroques','02/03/2010','es1');
insert into partido values('p2','croquesreboludos','2/6/2010','es1');
insert into partido values('p3','gambusinoscuspedrinos','12/6/2010','es3');
insert into partido values('p4','croquesreboludos','17/7/2010','es4');
insert into partido values('p5','gambusinoscuspedrinos','7/7/2010','es3');
insert into partido values('p6','croquesreboludos','7/9/2010','es1');
insert into partido values('p7','cuspedrinoscroques','7/10/2010','es4');

insert into xoga values('x1','p1',1);
insert into xoga values('x3','p1',5);
insert into xoga values('x6','p1',3);
insert into xoga values('x8','p1',6);
insert into xoga values('x15','p1',2);
insert into xoga values('x5','p2',1);
insert into xoga values('x6','p2',2);
insert into xoga values('x9','p2',3);
insert into xoga values('x10','p2',4);
insert into xoga values('x11','p2',6);
insert into xoga values('x10','p3',1);

insert into colexiado values('c1','cfelipe');
insert into colexiado values('c2','cjuan');
insert into colexiado values('c3','cpedro');
insert into colexiado values('c4','cluis');
insert into colexiado values('c5','cana');

insert into interven values('c3','p2',1);
insert into interven values('c2','p2',2);
insert into interven values('c3','p1',2);
insert into interven values('c1','p1',3);
insert into interven values('c1','p2',3);
insert into interven values('c5','p3',2);
insert into interven values('c1','p3',3);
commit;
