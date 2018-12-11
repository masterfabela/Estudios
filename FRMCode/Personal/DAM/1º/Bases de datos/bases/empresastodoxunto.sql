alter session set nls_date_format = 'dd.mm.yyyy hh24:mi:ss';

drop table rexeita cascade constraints;
drop table entrevista cascade constraints ;
drop table postos cascade constraints;
drop table xestores  cascade constraints;
drop table empresas cascade constraints;
drop table persoas  cascade constraints;
drop table perfil cascade constraints;



CREATE TABLE perfil (
    cod_perfil VARCHAR(6) NOT NULL,
    des_perfil VARCHAR(40),
    PRIMARY KEY (cod_perfil));


CREATE TABLE persoas (
    num_persoa number(5) NOT NULL,
    dni VARCHAR(10),
    nom_persoa VARCHAR(20),
    ap1_persoa VARCHAR(20),
    ap2_persoa VARCHAR(20),
    tel_persoa VARCHAR(9),
    cod_perfil VARCHAR(6) NOT NULL,
   PRIMARY KEY (num_persoa),
   FOREIGN KEY (cod_perfil) REFERENCES perfil (cod_perfil));


CREATE TABLE empresas (
    cod_empresa VARCHAR(5) NOT NULL,
    nom_empresa VARCHAR(40),
    dir_empresa VARCHAR(40),
    tel_empresa VARCHAR(9),
 PRIMARY KEY (cod_empresa));

 CREATE TABLE xestores (
    cod_xestor VARCHAR(3) NOT NULL,
    dni_xestor varchar(9),
    nom_xestor VARCHAR(20),
    ap1_xestor VARCHAR(20),
    ap2_xestor VARCHAR(20),
    tel_xestor VARCHAR(9),
    tipo_xestor VARCHAR(1) CHECK (tipo_xestor ='c' or tipo_xestor ='p'),
    PRIMARY KEY (cod_xestor));


CREATE TABLE postos (
    cod_posto VARCHAR(7) NOT NULL,
    des_posto VARCHAR(24),
    soldo number(6),
    dur_posto number(3),
    cod_perfil VARCHAR(6) NOT NULL,
    cod_empresa VARCHAR(5) NOT NULL,
    cod_xestor VARCHAR(3) NOT NULL,
    PRIMARY KEY (cod_posto),
FOREIGN KEY (cod_perfil) REFERENCES perfil (cod_perfil),
FOREIGN KEY (cod_empresa) REFERENCES empresas (cod_empresa),
FOREIGN KEY (cod_xestor) REFERENCES xestores (cod_xestor));


CREATE TABLE entrevista (
    cod_posto VARCHAR(9) NOT NULL,
    num_persoa number(5) NOT NULL,
    seleccionado varchar(1) CHECK (seleccionado='t' or seleccionado ='f'),
    selecfinal varchar(1) CHECK (selecfinal='t' or selecfinal ='f'),
    PRIMARY KEY (cod_posto, num_persoa),
FOREIGN KEY (num_persoa) REFERENCES persoas (num_persoa),
FOREIGN KEY (cod_posto) REFERENCES postos (cod_posto));

CREATE TABLE rexeita (
    cod_empresa VARCHAR(5) NOT NULL,
    num_persoa number(5) NOT NULL,
    PRIMARY KEY (cod_empresa,num_persoa),
FOREIGN KEY (num_persoa) REFERENCES persoas (num_persoa),
FOREIGN KEY (cod_empresa) REFERENCES empresas(cod_empresa));

insert into perfil values('pe1','administrativo');
insert into perfil values('pe2','informatico');
insert into perfil values('pe3','electronico');
insert into perfil values('pe4','electricista');
insert into perfil values('pe5','tecnico redes');
insert into perfil values('pe6','arquivador biblioteca');
insert into perfil values('pe7','barrendeiro');
insert into perfil values('pe8','limpadora');
insert into perfil values('pe9','comercial');
insert into perfil values('pe10','pozero');
insert into perfil values('pe11','xefe electricista');
insert into perfil values('pe12','xefe oficinas');
insert into perfil values('pe13','xardineiro');
insert into perfil values('pe14','director proxectos informaticos');

insert into persoas values(1,'36111111','ana','pereira','leiro','986111111','pe3');
insert into persoas values(2,'36222222','eva','pereira','pereira','986222222','pe13');
insert into persoas values(3,'36333333','juan','leiro','pereira','986333333','pe6');
insert into persoas values(4,'36444444','luis','martinez','bieitez','986444444','pe14');
insert into persoas values(12009,'3612009','pedro','solino','pereira','98612009','pe6');
insert into persoas values(11456,'3611456','luis','soriano','diaz','98611456','pe6');
insert into persoas values(5,'36555555','elisa','bermudez','bastos','986555555','pe14');
insert into persoas values(6,'36666666','veronica','alonso','bastos','986666666','pe14');
insert into  persoas values(7,'36777777','maria','vazquez','barallobre','986777777','pe7');
insert into persoas values(8,'36888888','xulia','pereira','bastos','986888888','pe8');
insert into persoas values(9,'36999999','eva','bastos','sobreira','986999999','pe2');
insert into persoas values(10,'36101010','bieito','pereira','suarez','986101010','pe10');
insert into persoas values(11,'36000000','ariadna','gil','gil','986000000','pe7');
insert into persoas values(12,'36121212','xosefa','barreiro','bieitez','986121212','pe12');
insert into  persoas values(13,'36131313','xose','valverde','valcarcel','986131313','pe10');
insert into persoas values(14,'36141414','sabela','leiro','prieto','986141414','pe14');
insert into  persoas values(15,'36151515','natalia','suarez','figueiro','986151515','pe9');
insert into persoas values(16,'36161616','ainoa','cambados','solino','986161616','pe13');
insert into persoas values(17,'36171717','breixo','leiro','arguindey','986171717','pe9');
insert into  persoas values(18,'36181818','antonio','leiro','barrantes','986181818','pe8');
insert into persoas values(19,'36191919','manuel','barrantes','leiro','986191919','pe2');
insert into  persoas values(20,'36202020','xurxo','barreiro','barrantes','986202020','pe1');
insert into persoas values(21,'36212121','felix','gil','cambados','986212121','pe7');
insert into persoas values(22,'36222223','ana','gil','sol','986222223','pe2');
insert into persoas values(23,'36232323','julia','alonso','martinez','986232323','pe5');

insert into empresas values('e1','valtasa','r/voltio s/n','886111111');
insert into empresas values('e2','aguasa','r/agua s/n','886222222');
insert into empresas values('e3','el corte ingles','r/sol  s/n','886333333');
insert into empresas values('e4','tremosa','r/tremor  s/n','886444444');
insert into empresas values('e5','alquasa','r/agua s/n','886555555');
insert into empresas values('e6','petrasa','r/pedra s/n','886666666');
insert into empresas values('e7','marmorasa','r/marmore s/n','886777777');
insert into empresas values('e8','solucions innovativas','r/ordenador s/n','886888888');
insert into empresas values('e9','boticasa','r/botica s/n','886999999');
insert into empresas values('e10','arbolasa','r/arbol s/n','886000000');

insert into xestores values ('x1','37111111','ricardo','leiro','suarez','986111119','p');
insert into xestores values ('x2','37222222','ana','pereira','bieitez','986222229','p');
insert into xestores values ('x3','37333333','pedro','marquez','leiro','986333339','p');
insert into xestores values ('x4','37444444','luis','boullosa','bastos','986444449','p');
insert into xestores values ('x5','37555555','eva','bastos','boullosa','986555559','p');
insert into xestores values ('x6','37666666','juan','sobrino','marquez','986666669','p');
insert into xestores values ('x7','37777777','marina','marquez','sobrino','986777779','c');
insert into xestores values ('x8','37888888','amalia','sobrino','pereira','986888889','c');
insert into xestores values ('x9','37999999','juana','pereira','bastos','986999991','c');
insert into xestores values ('x10','37101010','jesus','bastos','sobrino','986101019','c');

insert into postos values('p1','direc. dep. informatica',3000,365,'pe14','e8','x1');
insert into postos values('p2','barrendeiro',800,365,'pe7','e10','x2');
insert into postos values('p3','limpador colexios',900,200,'pe8','e5','x3');
insert into postos values('p4','instalador ordenadores',1200,150,'pe5','e8','x4');
insert into postos values('p342','empregado biblioteca',1500,365,'pe6','e4','x5');
insert into postos values('p5','limpador instalaciones',1000,365,'pe8','e5','x6');
insert into postos values('p6','perforador pozos',1300,365,'pe10','e2','x3');
insert into postos values('p7','xefe iluminacion',2000,300,'pe3','e1','x2');
insert into postos values('p8','vendedor senora',1100,365,'pe9','e3','x1');
insert into postos values('p9','xefe xardineiros',1300,300,'pe13','e10','x2');
insert into postos values('p10','instalador software',1800,365,'pe2','e8','x2');
insert into postos values('p11','disenador aplicacions',2200,365,'pe2','e8','x1');
insert into postos values('p12','revisor ascensores',1500,365,'pe4','e4','x2');
insert into postos values('p13','coidador parques',1000,365,'pe13','e10','x3');
insert into postos values('p14','vendedor caballero',1100,365,'pe9','e3','x1');
insert into postos values('p15','vendedor neno',1100,365,'pe9','e3','x1');
insert into postos values('p16','vendedor viaxes',1100,365,'pe9','e3','x1');
insert into postos values('p17','vendedor plantas',1100,365,'pe9','e3','x1');
insert into postos values('p18','vendedor plantas',1150,365,'pe13','e2','x9');

insert into entrevista values('p342',12009,'f','f');
insert into entrevista values('p1',4,'t','f');
insert into entrevista values('p2',11,'f','f');
insert into entrevista values('p2',21,'t','t');
insert into entrevista values('p8',17,'f','f');
insert into entrevista values('p8',15,'t','t');
insert into entrevista values('p10',19,'f','f');
insert into entrevista values('p10',22,'t','t');
insert into entrevista values('p1',5,'f','f');
insert into entrevista values('p342',3,'t','f');
insert into entrevista values('p342',5,'t','f');
insert into entrevista values('p11',9,'t','t');
insert into entrevista values('p1',6,'f','f');
insert into entrevista values('p3',8,'t','t');
insert into entrevista values('p4',23,'t','t');
insert into entrevista values('p5',18,'t','t');
insert into entrevista values('p6',13,'t','t');
insert into entrevista values('p342',11456,'t','t');
insert into entrevista values('p7',1,'f','f');
insert into entrevista values('p9',2,'f','f');
insert into entrevista values('p13',16,'t','t');
insert into entrevista values('p14',5,'f','f');

insert into rexeita values('e10',7);
insert into rexeita values('e3',20);
insert into rexeita values('e8',14);
insert into rexeita values('e10',20);
