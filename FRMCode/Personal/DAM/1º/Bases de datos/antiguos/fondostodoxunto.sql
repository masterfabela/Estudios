/*
@/home/oracle/Desktop/fondosoracle/fondosbdoracle/fondostodoxunto.sql
*/
set serveroutput on
set linesize 254
set pagesize 50
alter session set nls_date_format = 'dd.mm.yyyy hh24:mi:ss';
-- traballa (1:n)
drop table prestamo cascade constraints;
drop table dirixe cascade constraints;
drop table profesor cascade constraints;
drop table exemplar cascade constraints;
drop table area cascade constraints;
drop table departamento cascade constraints;
drop table socio cascade constraints;
drop table libro cascade constraints;
drop table autor cascade constraints;
purge recyclebin;
--
--
create table autor (
codautor varchar(6),
nomea varchar(20) ,
primary key(codautor)
);
--
--
create table libro (
clibro varchar(6),
titulo varchar(30) ,
editorial varchar(20) ,
dedicion date,
nexemplares integer,
codautor varchar(6),
primary key (clibro),
foreign key (codautor) references autor(codautor)
);
--
--
create table socio (
nsocio integer,
dniu integer,
nomeu varchar(20) ,
tipo varchar(1) ,
primary key (nsocio)
);
--
--
create table departamento (
nomed varchar(20),
primary key (nomed)
);
--
--
create table area (
nomea varchar(20),
nomed varchar(20) ,
primary key (nomea),
foreign key (nomed) references departamento(nomed)
);
--
--
create table exemplar (
clibro varchar(6),
numeroe integer,
prestable varchar(1),
nomea varchar(20),
primary key (clibro, numeroe),
foreign key (nomea) references area(nomea)
);
--
--
create table profesor (
nsocio integer,
nomea varchar(20),
primary key (nsocio),
foreign key (nsocio) references socio(nsocio),
foreign key (nomea) references area(nomea)
);
--
--
create table dirixe (
nomed varchar(20),
nsociodirector integer ,
primary key (nomed,nsociodirector),
foreign key (nomed) references departamento(nomed),
foreign key (nsociodirector) references profesor(nsocio)
);
--
--
create table prestamo (
nsocio integer,
clibro varchar(6),
numeroe integer,
dini date,
ddev date ,
devolto varchar(1) ,
primary key (nsocio, clibro, numeroe, dini),
foreign key (nsocio) references socio(nsocio),
foreign key (clibro, numeroe) references exemplar(clibro, numeroe)
);
--autor
--codautor | nomea
insert into autor values('a1','cervantes');
insert into autor values('a2','carpentier');
insert into autor values('a3','brook');
insert into autor values('a4','malinowski');
insert into autor values('a5','bunhuel');
insert into autor values('a6','aristoteles');
insert into autor values('a7','einstein');
insert into autor values('a8','lorca');
insert into autor values('a9','rosalia');
insert into autor values('a10','leonardo');
insert into autor values('a11','pitagoras');
insert into autor values('a12','arquimedes');
insert into autor values('a13','leonardo');
insert into autor values('a14','apuleyo');
insert into autor values('a15','vian');
insert into autor values('a16','puskinov');

--libro
--clibro | titulo | editorial | dedicion | nexemplares | autor
insert into libro values('c1','o asno de oro','catedra','10/1/2004',4,'a14' );
insert into libro values('c2','apoloxia','catedra','30/1/2004',2,'a14' );
insert into libro values('c3','o arrincacorazons','alianza','20/1/2004',3,'a15' );
insert into libro values('c4','a espuma dos dias','alianza','20/6/2004',3,'a15' );
insert into libro values('c5','matematica1','planeta','1/2/2004',1,'a13' );
insert into libro values('c6','yerma','alianza','10/2/2004',2,'a8' );
insert into libro values('c7','la casa de bernarda alba','anagrama','1/2/2004',2,'a8' );
insert into libro values('c8','teorema','anaya','11/2/2004',1,'a11' );
insert into libro values('c9','os papuyos','alianza','10/2/2004',1,'a4' );
insert into libro values('c10','don quijote de la mancha','catedra','10/2/2004',2,'a1' );
insert into libro values('c11','o espacio valeiro','alianza','10/2/2004',1,'a3' );
insert into libro values('c12','mc2','catedra','1/2/2004',1,'a7' );
insert into libro values('c13','o princinho','alianza','10/2/2004',1,'a12' );
insert into libro values('c14','fisica cuantica','alianza','10/2/2004',1,'a7' );
insert into libro values('c15','transformadas de fourier','anaya','10/2/2004',1,'a16' );
insert into libro values('c16','matematica2','planeta','10/2/2004',2,'a13' );
insert into libro values('c17','simbolismo','tusquets','10/2/2009',1,'a10' );
insert into libro values('c18','dadaismo','tusquets','10/3/2009',1,'a10' );

--socio
--nsocio | dniu | nomeu | tipo

insert into socio values(1,36000000,'luis','a' );
insert into socio values(2,36222222,'ana','a' );
insert into socio values(3,36333333,'pedro','p' );
insert into socio values(4,36444444,'eva','a' );
insert into socio values(5,36444444,'juan','a' );
insert into socio values(6,36555555,'maria','p' );
insert into socio values(7,36666666,'luisa','a' );
insert into socio values(8,36777777,'isabel','a' );
insert into socio values(9,36888888,'brais','a' );
insert into socio values(10,36999999,'ariadna','p' );
insert into socio values(11,36101010,'natalia','a' );
insert into socio values(12,36121212,'nicolas','p' );
insert into socio values(13,36131313,'camilo','a' );
insert into socio values(14,36141414,'santi','a' );
insert into socio values(15,36151515,'fernando','a' );
insert into socio values(16,36161616,'luis','a' );
insert into socio values(17,36171717,'gerardo','a' );
insert into socio values(18,36181818,'eduardo','p' );
insert into socio values(19,36191919,'jesus','a' );
insert into socio values(20,36202020,'daniel','a' );


--departamento
-- nomed
insert into departamento values('literatura');
insert into departamento values('matematicas');
insert into departamento values('fisica');
insert into departamento values('sociales');
insert into departamento values('filosofia');
insert into departamento values('aeronautica');

--area
-- nomea | nomed
insert into area values('teatro','literatura');
insert into area values('poesia','literatura');
insert into area values('novela','literatura');
insert into area values('matematica basica','matematicas');
insert into area values('antropoloxia','sociales');
insert into area values('fisica elemental','fisica');
insert into area values('fisica avanzada','fisica');
insert into area values('matematica avanzada','matematicas');



--exemplar
--clibro | numeroe | prestable | area
insert into exemplar values('c1',1,'t','novela');
insert into exemplar values('c1',2,'f','novela');
insert into exemplar values('c1',3,'t','novela');
insert into exemplar values('c1',4,'t','novela');
insert into exemplar values('c2',1,'t','novela');
insert into exemplar values('c2',2,'t','novela');
insert into exemplar values('c3',1,'t','novela');
insert into exemplar values('c3',2,'t','novela');
insert into exemplar values('c3',3,'t','novela');
insert into exemplar values('c4',1,'f','novela');
insert into exemplar values('c4',2,'t','novela');
insert into exemplar values('c4',3,'t','novela');
insert into exemplar values('c5',1,'t','matematica basica');
insert into exemplar values('c5',2,'t','matematica basica');
insert into exemplar values('c6',1,'t','poesia');
insert into exemplar values('c6',2,'f','poesia');
insert into exemplar values('c7',1,'t','teatro');
insert into exemplar values('c7',2,'t','teatro');
insert into exemplar values('c8',1,'f','matematica basica');
insert into exemplar values('c9',1,'t','antropoloxia');
insert into exemplar values('c9',2,'t','antropoloxia');
insert into exemplar values('c10',1,'t','novela');
insert into exemplar values('c10',2,'t','novela');
insert into exemplar values('c11',1,'t','teatro');
insert into exemplar values('c11',2,'t','teatro');
insert into exemplar values('c12',1,'t','fisica avanzada');
insert into exemplar values('c13',1,'t','novela');
insert into exemplar values('c14',1,'f','fisica avanzada');
insert into exemplar values('c15',1,'t','matematica avanzada');
insert into exemplar values('c16',1,'t','matematica basica');
insert into exemplar values('c16',2,'f','matematica basica');
insert into exemplar values('c17',1,'t','matematica basica');

--profesor
--socio | nomea
insert into profesor values(3,'novela');
insert into profesor values(6,'matematica basica');
insert into profesor values(10,'teatro');
insert into profesor values(12,'novela');
insert into profesor values(18,'matematica basica');

--dirixe
--nomed | nsociodirector
insert into dirixe values('literatura',3);
insert into dirixe values('matematicas',6);

--prestamo
--nsocio | clibro | numeroe | dini | ddev | devolto

insert into prestamo values(2,'c1',1,'10/1/2005','20/1/2005','t' );
insert into prestamo values(2,'c4',2,'21/1/2005','21/2/2005','t' );
insert into prestamo values(7,'c5',1,'10/1/2005','20/1/2005','t' );
insert into prestamo values(3,'c10',1,'12/1/2005','22/1/2005','f' );
insert into prestamo values(6,'c6',1,'1/3/2005','30/3/2005','f' );
insert into prestamo values(15,'c9',1,'2/2/2005','20/2/2005','t' );
insert into prestamo values(17,'c16',1,'10/1/2005','20/1/2005','t' );
insert into prestamo values(3,'c16',1,'10/1/2007','20/1/2007','t' );
insert into prestamo values(1,'c7',1,'3/1/2007','20/1/2007','f' );
insert into prestamo values(1,'c7',2,'3/2/2007','20/2/2007','f' );
insert into prestamo values(1,'c10',2,'3/3/2007','20/3/2007','f' );
insert into prestamo values(3,'c17',1,'12/7/2010','22/7/2010','f' );






