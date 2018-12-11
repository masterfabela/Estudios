alter session set nls_date_format = 'dd.mm.yyyy hh24:mi:ss';


drop table tratado cascade constraints;
drop table compon cascade constraints;
drop table ten cascade constraints;
drop table ataca cascade constraints;
drop table sulfato cascade constraints;
drop table fungicida cascade constraints;
drop table fungo cascade constraints;
drop table operario cascade constraints;
drop table cepa cascade constraints;
drop table vinhedo cascade constraints;
drop table viticultor cascade constraints;



purge recyclebin;

create table viticultor(
codpv varchar(3),
nompv varchar(17),
primary key (codpv));


create table vinhedo(
codv varchar(3),
ext integer,
dir varchar2(30),
codpv varchar(3),
primary key (codv),
foreign key (codpv) references viticultor(codpv));


create table cepa (
codc varchar(3),
nomc varchar(15),
aut varchar(1),
primary key (codc));


create table operario (
dniop varchar(9),
nomeop varchar(15),
soldo integer,
primary key (dniop));


create table fungo(
codf varchar(3),
nomf varchar(15),
primary key (codf));

create table sulfato(
cods varchar(3),
noms varchar(15),
primary key (cods));



create table fungicida (
codfg varchar(3),
nomfg varchar(20),
codf varchar(3),
primary key (codfg),
foreign key (codf) references fungo(codf));

create table ten(
codv varchar(3),
codc varchar(3),
cantc integer,
primary key (codv,codc),
foreign key (codv) references vinhedo(codv),
foreign key (codc) references cepa(codc));

create table ataca (
codc varchar(3),
codf varchar(3),
inten  integer,
primary key (codc,codf),
foreign key (codc) references cepa(codc),
foreign key (codf) references fungo(codf));

create table compon (
cods varchar(3),
codfg varchar(3),
cantf  integer,
primary key (cods,codfg),
foreign key (cods) references sulfato(cods),
foreign key (codfg) references fungicida(codfg));

create table tratado (
codv varchar(3),
cods varchar(3),
dniop  varchar(3),
datat date,
primary key (codv,cods,dniop,datat),
foreign key (codv) references vinhedo(codv),
foreign key (cods) references sulfato(cods),
foreign key (dniop) references operario(dniop));





insert into viticultor values('p1','ana');
insert into viticultor values('p2','luis');
insert into viticultor values('p3','juan');
insert into viticultor values('p4','pedro');

insert into vinhedo values('v1',1000,'ribeira-sacra','p1');
insert into vinhedo values('v2',2000,'rosal','p2');
insert into vinhedo values('v3',3000,'condado','p1');
insert into vinhedo values('v4',2500,'ribeiro','p3');
insert into vinhedo values('v5',1500,'monterrei','p2');
insert into vinhedo values('v6',1000,'cambados','p2');

insert into cepa values('c1','alvarinho','s');
insert into cepa values('c2','godello','s');
insert into cepa values('c3','treixadura','s');
insert into cepa values('c4','mencia','s');
insert into cepa values('c5','pingadelo','');
insert into cepa values('c6','gran-negro','s');
insert into cepa values('c7','xaque','');
insert into cepa values('c8','moranga','s');
insert into cepa values('c9','paxareira','s');
insert into cepa values('c10','xerez','n');
insert into cepa values('c11','pedral','');
insert into cepa values('c12','cavernet','n');

insert into operario values('o1','juana',1000);
insert into operario values('o2','luisa',1200);
insert into operario values('o3','eva',1500);
insert into operario values('o4','pedro',2000);
insert into operario values('o5','gemma',1500);
insert into operario values('o6','marisol',1300);

insert into fungo values('f1','oidio');
insert into fungo values('f2','mildiu');
insert into fungo values('f3','black-root');
insert into fungo values('f4','snegen');
insert into fungo values('f5','sirnut');
insert into fungo values('f6','dengen');
insert into fungo values('f7','zosmo');

insert into sulfato values('s1','zz-cobre');
insert into sulfato values('s2','electis');
insert into sulfato values('s3','ridomil');
insert into sulfato values('s4','foxmax');
insert into sulfato values('s5','drudox');
insert into sulfato values('s6','armetil');
insert into sulfato values('s7','sulfamax');
insert into sulfato values('s8','curetor');

insert into fungicida values('fg1','difenil','f1');
insert into fungicida values('fg2','folpet','f1');
insert into fungicida values('fg3','bumil','f2');
insert into fungicida values('fg4','alumil','f3');
insert into fungicida values('fg5','disenol','f3');
insert into fungicida values('fg6','cromal','f4');
insert into fungicida values('fg7','diclofecil','f5');
insert into fungicida values('fg8','triclomil','f6');
 
insert into ten values('v1','c1',500);
insert into ten values('v1','c2',200);
insert into ten values('v1','c3',100);
insert into ten values('v1','c4',300);
insert into ten values('v2','c2',200);
insert into ten values('v2','c4',400);
insert into ten values('v3','c3',500);
insert into ten values('v3','c5',250);
insert into ten values('v4','c7',300);
insert into ten values('v4','c8',100);
insert into ten values('v4','c9',150);
insert into ten values('v5','c2',300);
insert into ten values('v5','c11',400);
insert into ten values('v5','c12',500);

insert into ataca values('c1','f1',1);
insert into ataca values('c1','f2',2);
insert into ataca values('c2','f2',1);
insert into ataca values('c2','f3',2);
insert into ataca values('c3','f4',3);
insert into ataca values('c4','f1',2);
insert into ataca values('c4','f2',3);
insert into ataca values('c4','f4',2);
insert into ataca values('c5','f2',2);
insert into ataca values('c6','f3',3);
insert into ataca values('c7','f4',4);
insert into ataca values('c8','f5',2);
insert into ataca values('c8','f7',2);

insert into compon values('s1','fg1',20);
insert into compon values('s1','fg2',30);
insert into compon values('s1','fg3',10);
insert into compon values('s1','fg4',10);
insert into compon values('s2','fg1',20);
insert into compon values('s2','fg4',30);
insert into compon values('s3','fg6',40);
insert into compon values('s3','fg8',20);
insert into compon values('s4','fg7',30);
insert into compon values('s4','fg8',10);
insert into compon values('s5','fg5',20);
insert into compon values('s6','fg4',30);
insert into compon values('s6','fg5',40);
insert into compon values('s6','fg6',50);

insert into tratado values('v1','s1','o1','1/4/2010');
insert into tratado values('v1','s1','o2','15/4/2010');
insert into tratado values('v1','s1','o3','30/4/2010');
insert into tratado values('v1','s2','o1','30/4/2010');
insert into tratado values('v1','s2','o2','15/5/2011');
insert into tratado values('v2','s2','o1','1/4/2010');
insert into tratado values('v2','s2','o3','14/4/2010');
insert into tratado values('v2','s3','o2','14/4/2010');
insert into tratado values('v2','s3','o1','30/4/2010');
insert into tratado values('v3','s4','o2','2/4/2010');
insert into tratado values('v3','s4','o3','16/4/2010');
insert into tratado values('v3','s5','o2','30/4/2010');
insert into tratado values('v4','s1','o2','1/4/2010');

commit;
