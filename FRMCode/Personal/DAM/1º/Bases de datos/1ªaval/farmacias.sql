
alter session set nls_date_format = 'dd.mm.yyyy hh24:mi:ss';
drop table traballan cascade constraints;
DROP TABLE persoas CASCADE CONSTRAINTS;
DROP TABLE stock CASCADE CONSTRAINTS;
DROP TABLE componen CASCADE CONSTRAINTS;
DROP TABLE medicamentos CASCADE CONSTRAINTS;
DROP TABLE laboratorios CASCADE CONSTRAINTS;
DROP TABLE accions CASCADE CONSTRAINTS;
DROP TABLE componentes CASCADE CONSTRAINTS;
DROP TABLE presentacions CASCADE CONSTRAINTS;
DROP TABLE propios CASCADE CONSTRAINTS;
DROP TABLE farmaceuticos CASCADE CONSTRAINTS;
DROP TABLE farmacias CASCADE CONSTRAINTS;
DROP TABLE cidades CASCADE CONSTRAINTS;
purge recyclebin;

CREATE TABLE cidades(
codc integer,
nomc varchar2(15), 
primary key(codc));

CREATE TABLE farmacias (
    codf INTEGER NOT NULL,
    nomf VARCHAR(15),
    codc INTEGER NOT NULL,
    PRIMARY KEY (codf)
);

CREATE TABLE persoas (
    dnip VARCHAR(10) NOT NULL,
    nomp VARCHAR(10),
    PRIMARY KEY (dnip)
);

CREATE TABLE farmaceuticos (
    dnip VARCHAR(10) NOT NULL,
    codc INTEGER NOT NULL,
    ncolexiado integer,
    PRIMARY KEY (dnip)
);

CREATE TABLE propios (
    dnip VARCHAR(10) NOT NULL,
    PRIMARY KEY (dnip)
);

ALTER TABLE farmaceuticos
    ADD FOREIGN KEY (codc) REFERENCES cidades (codc);

ALTER TABLE farmaceuticos
    ADD FOREIGN KEY (dnip) REFERENCES persoas (dnip);

ALTER TABLE propios
    ADD FOREIGN KEY (dnip) REFERENCES persoas (dnip);

CREATE TABLE presentacions (
    codpre INTEGER NOT NULL,
    nompre VARCHAR(15),
    PRIMARY KEY (codpre)
);

CREATE TABLE componentes (
    codc INTEGER NOT NULL,
    nomc VARCHAR(20),
    PRIMARY KEY (codc)
);

CREATE TABLE accions (
    coda INTEGER NOT NULL,
    noma VARCHAR(15),
    PRIMARY KEY (coda)
);

CREATE TABLE laboratorios (
    cif VARCHAR(10) NOT NULL,
    noml VARCHAR(15),
    PRIMARY KEY (cif)
);

CREATE TABLE medicamentos (
    codm INTEGER NOT NULL,
    nomm VARCHAR(15),
    cif VARCHAR(10),
    coda integer,
    PRIMARY KEY (codm),
    foreign key (coda) references accions(coda)
);

CREATE TABLE componen (
    codm INTEGER NOT NULL,
    codc INTEGER NOT NULL,
    cantidadc INTEGER,
    PRIMARY KEY (codm, codc)
);



CREATE TABLE stock (
    codf INTEGER NOT NULL,
    codm INTEGER NOT NULL,
    codpre INTEGER NOT NULL,
    cantidads integer,
    PRIMARY KEY (codf, codm, codpre));

CREATE TABLE traballan(
    codf INTEGER ,
    dnip varchar(10),
    primary key (codf,dnip),
    foreign key (codf) references farmacias(codf),
    foreign key (dnip) references persoas(dnip));



/*==========================================================================*/
/*  Foreign Keys                                                            */
/*==========================================================================*/

ALTER TABLE farmacias
    ADD FOREIGN KEY (codc) REFERENCES cidades(codc);


ALTER TABLE medicamentos
    ADD FOREIGN KEY (cif) REFERENCES laboratorios(cif);

ALTER TABLE componen
    ADD FOREIGN KEY (codc) REFERENCES componentes(codc);

ALTER TABLE componen
    ADD FOREIGN KEY (codm) REFERENCES medicamentos(codm);

ALTER TABLE stock
    ADD FOREIGN KEY (codf) REFERENCES farmacias(codf);

ALTER TABLE stock
    ADD FOREIGN KEY (codm) REFERENCES medicamentos(codm);

ALTER TABLE stock
    ADD FOREIGN KEY (codpre) REFERENCES presentacions(codpre);



insert into cidades values(1,'vigo');
insert into cidades values(2,'lugo');
insert into cidades values(3,'ourense');
insert into cidades values(4,'corunha');
insert into cidades values(5,'pontevedra');
insert into cidades values(6,'ferrol');

insert into farmacias values(1,'cacharro1',1);
insert into farmacias values(2,'cacharro2',1);
insert into farmacias values(3,'cacharro3',1);
insert into farmacias values(4,'cacharro4',2);
insert into farmacias values(5,'cacharro5',3);
insert into farmacias values(6,'cacharro6',4);
insert into farmacias values(7,'cacharro7',5);
insert into farmacias values(8,'cacharro8',6);
insert into farmacias values(9,'cacharro9',6);
insert into farmacias values(10,'cacharro10',4);

insert into persoas values('3610','luis');
insert into persoas values('3611','ana');
insert into persoas values('3612','pedro');
insert into persoas values('3613','juan');
insert into persoas values('3620','alberto');
insert into persoas values('3621','roberto');
insert into persoas values('3630','susana');
insert into persoas values('3631','vicente');
insert into persoas values('3640','roberto');
insert into persoas values('3641','antia');
insert into persoas values('3650','soledad');
insert into persoas values('3651','rosa');
insert into persoas values('3660','javier');
insert into persoas values('3661','tomas');
insert into persoas values('3670','federico');
insert into persoas values('3671','antonio');
insert into persoas values('3680','rebeca');
insert into persoas values('3681','azucena');
insert into persoas values('3690','alberto');
insert into persoas values('3691','beatriz');
insert into persoas values('3692','javier');
insert into persoas values('3693','carlos');
insert into persoas values('36100','sofia');
insert into persoas values('36101','alba');



insert into farmaceuticos values('3610',1,123);
insert into farmaceuticos values('3620',2,124);
insert into farmaceuticos values('3630',3,125);
insert into farmaceuticos values('3640',4,126);
insert into farmaceuticos values('3650',5,127);
insert into farmaceuticos values('3660',6,128);
insert into farmaceuticos values('3670',6,129);
insert into farmaceuticos values('3680',4,130);
insert into farmaceuticos values('3690',6,131);
insert into farmaceuticos values('36100',6,132);
insert into farmaceuticos values('3681',5,134);


insert into propios values('3611');
insert into propios values('3612');
insert into propios values('3613');
insert into propios values('3621');
insert into propios values('3631');
insert into propios values('3641');
insert into propios values('3651');
insert into propios values('3661');
insert into propios values('3671');
insert into propios values('3681');
insert into propios values('3691');
insert into propios values('3692');
insert into propios values('3693');


insert into traballan values(1,'3610');
insert into traballan values(2,'3610');
insert into traballan values(3,'3610');
insert into traballan values(4,'3620');
insert into traballan values(5,'3630');
insert into traballan values(6,'3640');
insert into traballan values(7,'3650');
insert into traballan values(1,'3611');
insert into traballan values(2,'3612');
insert into traballan values(3,'3613');
insert into traballan values(4,'3621');
insert into traballan values(5,'3631');
insert into traballan values(6,'3641');
insert into traballan values(7,'3651');
insert into traballan values(10,'36100');
insert into traballan values(8,'36101');
insert into traballan values(7,'3681');




insert into presentacions values(1,'1g');
insert into presentacions values(2,'20mg');
insert into presentacions values(3,'50gr');
insert into presentacions values(4,'200mg');
insert into presentacions values(5,'400mg');
insert into presentacions values(6,'500mg');
insert into presentacions values(7,'600mg');
insert into presentacions values(8,'10ml');

insert into componentes values(1,'norfloxacino');
insert into componentes values(2,'ibuprofeno');
insert into componentes values(3,'escina');
insert into componentes values(4,'esomeprazol');
insert into componentes values(5,'paracetamol');
insert into componentes values(6,'acetilcisteina');
insert into componentes values(7,'omeprazol');
insert into componentes values(8,'piroxicam');
insert into componentes values(9,'boldoxina');
insert into componentes values(10,'nortoc');
insert into componentes values(11,'aciadamida');
insert into componentes values(12,'borxina');
insert into componentes values(13,'zotpec');
insert into componentes values(14,'anaxina');

insert into accions values(1,'antihistaminica');
insert into accions values(2,'vermifuga');
insert into accions values(3,'antiespasmodica');
insert into accions values(4,'febrifuga');
insert into accions values(5,'espectorante');
insert into accions values(6,'antimucolitica');
insert into accions values(7,'antiacida');
insert into accions values(8,'antipiretica');
insert into accions values(9,'antibiotica');
insert into accions values(10,'antiinflama');

insert into laboratorios values('b361','madaus');
insert into laboratorios values('b362','ur');
insert into laboratorios values('b363','beta');
insert into laboratorios values('b364','sandoz');
insert into laboratorios values('b365','upsamedica');
insert into laboratorios values('b366','esteve');
insert into laboratorios values('b367','pharmazan');
insert into laboratorios values('b368','labesfal');

insert into medicamentos values(1,'feparil','b361',1);
insert into medicamentos values(2,'ibuprofenour','b362',8);
insert into medicamentos values(3,'axiago','b363',2);
insert into medicamentos values(4,'norflox','b364',3);
insert into medicamentos values(5,'eferalgan','b365',4);
insert into medicamentos values(6,'flumil','b367',5);
insert into medicamentos values(7,'omeprazollab','b368',7);
insert into medicamentos values(8,'omeprazolmerc','b366',7);
insert into medicamentos values(9,'ibuprofenoest','b368',8);
insert into medicamentos values(10,'feldegel','b363',3);
insert into medicamentos values(11,'eyexmax','b365',9);
insert into medicamentos values(12,'ortil','b365',7);
insert into medicamentos values(13,'romuol','b363',7);


insert into componen values(1,1,10);
insert into componen values(1,2,10);
insert into componen values(2,12,5);
insert into componen values(2,3,5);
insert into componen values(3,11,15);
insert into componen values(4,3,5);
insert into componen values(4,4,10);
insert into componen values(4,5,1);
insert into componen values(5,5,10);
insert into componen values(6,7,5);
insert into componen values(7,2,5);
insert into componen values(7,3,10);
insert into componen values(7,1,20);
insert into componen values(8,13,15);
insert into componen values(8,5,5);
insert into componen values(9,6,10);
insert into componen values(10,14,20);
insert into componen values(10,9,25);
insert into componen values(10,5,20);
insert into componen values(11,14,10);
insert into componen values(11,3,10);
insert into componen values(12,2,5);



insert into stock values(1,1,2,2);
insert into stock values(1,1,3,2);
insert into stock values(1,2,2,3);
insert into stock values(1,4,2,4);
insert into stock values(1,5,3,5);
insert into stock values(2,4,2,2);
insert into stock values(2,5,2,3);
insert into stock values(2,6,2,1);
insert into stock values(2,7,3,2);
insert into stock values(2,7,4,1);
insert into stock values(2,8,5,1);
insert into stock values(2,8,6,2);
insert into stock values(3,1,2,2);
insert into stock values(3,2,3,3);
insert into stock values(3,3,3,1);
insert into stock values(4,3,4,1);
insert into stock values(4,3,5,1);
insert into stock values(4,4,6,1);
insert into stock values(5,5,2,1);
insert into stock values(5,6,2,1);
insert into stock values(6,6,3,1);
insert into stock values(6,6,4,2);
insert into stock values(6,7,3,3);
insert into stock values(6,8,3,2);
insert into stock values(7,9,4,2);
insert into stock values(7,9,5,2);
insert into stock values(8,10,2,1);
insert into stock values(4,10,3,1);
--insert into stock values(6,12,3,4);

commit;