/*
 @/home/oracle/Desktop/startrek_28_3_11/startrek

nota: este script ten agora mesmo ACTIVADAS as insercions para probar o trigger tmaxhoras.
*/
set serveroutput on
alter session set nls_date_format = 'dd.mm.yyyy hh24:mi:ss';


DROP TABLE actores CASCADE CONSTRAINTS ;
DROP TABLE series CASCADE CONSTRAINTS;
DROP TABLE humanos CASCADE CONSTRAINTS ;
DROP TABLE interpretespel CASCADE CONSTRAINTS;
DROP TABLE interpretesser CASCADE CONSTRAINTS;
DROP TABLE klingon CASCADE CONSTRAINTS ;
DROP TABLE lanzaderas CASCADE CONSTRAINTS;
DROP TABLE naves CASCADE CONSTRAINTS ;
DROP TABLE peliculas CASCADE CONSTRAINTS;
DROP TABLE personaxes CASCADE CONSTRAINTS;
DROP TABLE planetas CASCADE CONSTRAINTS ;
DROP TABLE visitas CASCADE CONSTRAINTS ;
DROP TABLE vulcanos CASCADE CONSTRAINTS;

CREATE TABLE actores 
    ( 
     coda VARCHAR2 (3)  NOT NULL , 
     noma VARCHAR2 (10) , 
     nacionalidade VARCHAR2 (10) ,      
     datan DATE,
     cachehora integer,
     PRIMARY KEY ( coda ) 
    ) ;

CREATE TABLE personaxes 
    ( 
     codper VARCHAR2 (3)  NOT NULL ,
     nomper VARCHAR2 (15) unique ,  
     graduacion VARCHAR2 (10) , 
     codper2 VARCHAR2 (3) ,
     PRIMARY KEY ( codper ),
     FOREIGN KEY (codper2)  REFERENCES personaxes(codper)
    ) ;
CREATE TABLE humanos 
    ( 
     codper VARCHAR2 (3)  NOT NULL , 
     datan DATE , 
     cidade VARCHAR2 (10) ,
     PRIMARY KEY ( codper ),
     FOREIGN KEY (codper)  REFERENCES personaxes(codper) 
   );



CREATE TABLE vulcanos 
    ( 
     codper VARCHAR2 (3)  NOT NULL , 
     datagrad DATE ,
     PRIMARY KEY ( codper ),
     FOREIGN KEY (codper)  REFERENCES personaxes(codper)
    );

CREATE TABLE planetas 
    ( 
     codpla VARCHAR2 (5)  NOT NULL , 
     nompla VARCHAR2 (10)  NOT NULL , 
     galaxia VARCHAR2 (10) ,
     PRIMARY KEY ( codpla ) 
    );


CREATE TABLE klingon 
    ( 
     codper VARCHAR2 (3)  NOT NULL , 
     datacombate DATE , 
     codpla VARCHAR2 (5),
     PRIMARY KEY ( codper ) ,
     FOREIGN KEY (codper)  REFERENCES personaxes(codper),
     FOREIGN KEY (codpla)  REFERENCES planetas(codpla)
     );


CREATE TABLE series 
    ( 
     cods VARCHAR2 (3)  NOT NULL , 
     titulo VARCHAR2 (15) , 
     anolanz INTEGER , 
     director VARCHAR2 (10) ,
    PRIMARY KEY ( cods ) 
   );

CREATE TABLE peliculas 
    ( 
     codpel VARCHAR2 (5)  NOT NULL , 
     titulo VARCHAR2 (15) , 
     anolanz INTEGER , 
     director VARCHAR2 (10) ,
     PRIMARY KEY ( codpel ) 
    );

CREATE TABLE interpretespel 
    ( 
     coda VARCHAR2 (3)  NOT NULL , 
     codper VARCHAR2 (3)  NOT NULL , 
     codpel VARCHAR2 (5)  NOT NULL,
     protagonista varchar2(1),
     horas integer,
     PRIMARY KEY ( coda, codper, codpel ) ,
     FOREIGN KEY (coda)  REFERENCES actores(coda),
     FOREIGN KEY (codper)  REFERENCES personaxes(codper),
     FOREIGN KEY (codpel)  REFERENCES peliculas(codpel) 
     );

CREATE TABLE interpretesser 
    ( 
     coda VARCHAR2 (3)  NOT NULL , 
     codper VARCHAR2 (3)  NOT NULL , 
     cods VARCHAR2 (3)  NOT NULL, 
     horas integer,
     PRIMARY KEY ( coda, codper, cods ),
     FOREIGN KEY (coda)  REFERENCES actores(coda),
     FOREIGN KEY (codper)  REFERENCES personaxes(codper),
     FOREIGN KEY (cods)  REFERENCES series(cods) 
   );


CREATE TABLE naves 
    ( 
     codn VARCHAR2 (3)  NOT NULL , 
     nomen VARCHAR2 (10) , 
     tripul INTEGER ,
    PRIMARY KEY ( codn )
  );

CREATE TABLE lanzaderas
    ( 
     codn VARCHAR2 (3)  NOT NULL , 
     numero INTEGER  NOT NULL , 
     capacidade INTEGER,
     PRIMARY KEY (codn,numero ) ,
     FOREIGN KEY (codn)  REFERENCES naves(codn)
  );



CREATE TABLE visitas
    ( 
     cods VARCHAR2 (3)  NOT NULL , 
     codn VARCHAR2 (3)  NOT NULL , 
     codpla VARCHAR2 (5)  NOT NULL , 
     problema VARCHAR2 (25) ,
     PRIMARY KEY ( cods, codn, codpla ),
     FOREIGN KEY (cods)  REFERENCES series(cods),
     FOREIGN KEY (codn)  REFERENCES naves(codn),
     FOREIGN KEY (codpla)  REFERENCES planetas(codpla) 
    ) ;

insert into actores values('a1','shatner','polonia','6/5/1955',600);
insert into actores values('a2','nimoy','gales','6/7/1956',null);
insert into actores values('a3','kelley','escocia','17/12/1955',400);
insert into actores values('a4','doohan','gales','9/5/1960',300);
insert into actores values('a5','koenig','suiza',null,200);
insert into actores values('a6','nichols','gales','3/2/1959',250);
insert into actores values('a7','luis','mexico','6/4/1961',300);
insert into actores values('a8','pedro','gales','3/9/1961',200);
insert into actores values('a9','yuan','espanha',null,300);
insert into actores values('a10','ana','colombia','22/8/1965',null);
insert into actores values('a11','eva','colombia','21/10/1975',250);
insert into actores values('a12','leis','gales','18/7/1985',300);
insert into actores values('a13','rosa','espanha','16/1/1955',null);
insert into actores values('a14','teresa','mexico',null,300);
insert into actores values('a15','julia','francia','1/11/1957',150);
insert into actores values('a16','beatriz','irlanda','29/8/1958',250);
insert into actores values('a17','ana','espanha',null,200);
insert into actores values('a18','veronica','polonia','4/11/1962',null);
insert into actores values('a19','feline','espanha','6/5/1961',200);
insert into actores values('a20','pedro','francia',null,100);
insert into actores values('a21','gray','peru','24/7/1963',50);
insert into actores values('a22','curtis','irlanda','22/10/1962',50);
insert into actores values('a23','bikel','italia','27/8/1961',150);
insert into actores values('a24','allen','italia','15/6/1962',200);
insert into actores values('a25','brandy','chile','11/6/1964',300);
insert into actores values('a26','farrow','chile','1/12/1965',null);
insert into actores values('a27','bieito','peru','27/2/1961',150);


insert into personaxes values('p1','kirk','capitan',null);
insert into personaxes values('p2','spoke','tenente','p1');
insert into personaxes values('p3','maccoy','coronel','p2');
insert into personaxes values('p4','scott','mayor','p3');
insert into personaxes values('p5','chekov','oficial','p4');
insert into personaxes values('p6','ubura','coronel','p2');
insert into personaxes values('p7','ear','oficial','p4');
insert into personaxes values('p8','trio','mayor','p6');
insert into personaxes values('p9','prak','oficial','p8');
insert into personaxes values('p10','jono','cabo','p9');
insert into personaxes values('p11','word','cabo','p10');
insert into personaxes values('p12','vekor','soldado',null);
insert into personaxes values('p13','divot','soldado','p11');
insert into personaxes values('p14','sovak','soldado','p11');
insert into personaxes values('p15','kor','soldado','p11');
insert into personaxes values('p16','tomalak','oficial','p8');
insert into personaxes values('p17','ronin','oficial','p4');
insert into personaxes values('p18','devour','soldado','p11');
insert into personaxes values('p19','letek','cabo','p7');
insert into personaxes values('p20','ardor','cabo','p7');
insert into personaxes values('p21','solok','soldado','p20');
insert into personaxes values('p29','yuta','cabo','p7');
insert into personaxes values('p22','lag','soldado',null);
insert into personaxes values('p23','kurn','alferez','p9');
insert into personaxes values('p24','comic','alferez','p9');
insert into personaxes values('p25','karnas','coronel','p2');
insert into personaxes values('p26','lian','soldado','p20');
insert into personaxes values('p27','lures','soldado','p19');
insert into personaxes values('p28','kamala','soldado',null);
insert into personaxes values('p30','tagana','soldado','p19');
insert into personaxes values('p31','gilora','soldado','p19');
insert into personaxes values('p32','kraal','soldado','p19');
insert into personaxes values('p33','grilka','soldado','p19');
insert into personaxes values('p34','morn','soldado','p20');
insert into personaxes values('p35','garak','soldado',null);
insert into personaxes values('p36','nog','soldado','p21');
insert into personaxes values('p37','rom','soldado','p21');
insert into personaxes values('p38','tiron','soldado','p21');
insert into personaxes values('p39','brunt','soldado','p21');
insert into personaxes values('p41','ducat','soldado','p21');
insert into personaxes values('p42','boogie','soldado','p21');
insert into personaxes values('p43','gull','soldado','p19');
insert into personaxes values('p44','quark','soldado','p19');
insert into personaxes values('p45','dax','soldado','p21');
insert into personaxes values('p46','sissy','oficial',null);
insert into personaxes values('p47','kira','oficial','p4');

insert into humanos  values('p1','2/12/2065','vigor');
insert into humanos  values('p3','12/10/2062','moscu');
insert into humanos  values('p4','7/12/2056','londres');
insert into humanos  values('p6','19/10/2060','madrid');
insert into humanos  values('p7','28/11/2064','lesoto');
insert into humanos  values('p12','12/11/2056','lisboa');
insert into humanos  values('p22','11/11/2065','praga');
insert into humanos  values('p23','14/2/2066','bombay');
insert into humanos  values('p24','1/2/2063','ankara');
insert into humanos  values('p25','5/4/2069','bogota');
insert into humanos  values('p26','12/6/2061','lima');
insert into humanos  values('p27','1/4/2063','oslo');

 insert into vulcanos  values('p2','1/1/2056');
insert into vulcanos  values('p7','3/2/2063');
insert into vulcanos  values('p8','5/5/2061');
insert into vulcanos  values('p13','15/11/2062');
insert into vulcanos  values('p14','2/11/2064');
insert into vulcanos  values('p15','16/11/2058');
insert into vulcanos  values('p16','27/2/2066');
insert into vulcanos  values('p17','17/7/2058');
insert into vulcanos  values('p31','15/2/2063');
insert into vulcanos  values('p32',null);
insert into vulcanos  values('p33','1/3/2066');
insert into vulcanos  values('p34',null);
insert into vulcanos  values('p35','8/5/2059');


insert into planetas values('pla1','terra','via_lactea');
insert into planetas values('pla2','bog','andromeda');
insert into planetas values('pla3','mart', 'via_lactea');
insert into planetas values('pla4','xupiter','via_lactea');
insert into planetas values('pla5','saturno','via_lactea');
insert into planetas values('pla6','neptuno','via_lactea');
insert into planetas values('pla7','vulcano','via_lactea');
insert into planetas values('pla8','klono','kerberos');
insert into planetas values('pla9','capax','magallanes');
insert into planetas values('pla10','cancerbero','magallanes');
insert into planetas values('pla11','lobar','kerberos');
insert into planetas values('pla12','gork','kerberos');


 insert into klingon  values('p9','2/2/2094','pla2');
insert into klingon  values('p10','5/6/2101','pla2');
insert into klingon  values('p18','7/1/2099','pla8');
insert into klingon  values('p19','12/11/2092','pla8');
insert into klingon  values('p28','14/12/2093','pla8');
insert into klingon  values('p29','19/4/2099','pla8');
insert into klingon  values('p36','11/11/2089','pla9');
insert into klingon  values('p37','23/6/2097','pla9');
insert into klingon  values('p38','25/5/2097','pla9');
insert into klingon  values('p41','29/11/2088','pla10');
insert into klingon  values('p42','1/5/2011','pla10');
insert into klingon  values('p43','2/6/2010','pla10');
insert into klingon  values('p44','5/10/2011','pla10');
insert into klingon  values('p45','6/6/2018','pla10');
insert into klingon  values('p46','7/9/2099','pla10');
insert into klingon  values('p47','9/9/2099','pla10');



insert into series values('s1','star_trek',1978,'carter');
insert into series values('s2','next_generation',1979,'adams');
insert into series values('s3','deep_space_nine',1980,'brown');
insert into series values('s4','voyager',1981,'steward');
insert into series values('s5','enterprise',1982,'bronson');
insert into series values('s6','cosmos',1983,'thompson');

insert into peliculas values('pel1','wrath_of_khan',1980,'adams');
insert into peliculas values('pel2','search_spock',1985,'brand');
insert into peliculas values('pel3','voyage_home',1989,'gordon');
insert into peliculas values('pel4','final_frontier',2000,'brown');
insert into peliculas values('pel5','undiscovered',2003,'george');
insert into peliculas values('pel6','generations',2005,'lucas');
insert into peliculas values('pel7','first_contact',2007,'lucas');
insert into peliculas values('pel8','insurrection',2008,'brand');
insert into peliculas values('pel9','nemesis',2009,'gordon');



insert into interpretespel values('a1','p1','pel1','s',100);
insert into interpretespel values('a1','p1','pel2','s',80);
insert into interpretespel values('a1','p1','pel3','s',70);
insert into interpretespel values('a2','p2','pel1','n',null);
insert into interpretespel values('a2','p2','pel2','n',100);
insert into interpretespel values('a2','p2','pel3','n',50);
insert into interpretespel values('a3','p5','pel1','n',null);
insert into interpretespel values('a4','p29','pel1','n',null);
insert into interpretespel values('a5','p6','pel2','n',70);
insert into interpretespel values('a6','p7','pel2','n',40);
insert into interpretespel values('a6','p8','pel2','n',null);
insert into interpretespel values('a7','p9','pel1','n',70);
insert into interpretespel values('a8','p10','pel4','n',60);
insert into interpretespel values('a9','p10','pel3','n',40);
insert into interpretespel values('a9','p11','pel5','n',null);
insert into interpretespel values('a9','p12','pel5','s',50);
insert into interpretespel values('a9','p16','pel5','s',2);
insert into interpretespel values('a10','p12','pel3','n',30);
insert into interpretespel values('a11','p12','pel4','n',20);
insert into interpretespel values('a11','p13','pel3','n',1);

-- inserciones a maiores so para probar o trigger tmaxhoras:
insert into interpretespel values('a17','p1','pel5','s',100);
insert into interpretespel values('a17','p1','pel4','s',100);
insert into interpretespel values('a2','p2','pel4','n',49);
insert into interpretespel values('a8','p2','pel5','n',200);
-- fin de inserciones a maiores


insert into interpretesser values('a1','p1','s1',500);
insert into interpretesser values('a2','p2','s1',200);
insert into interpretesser values('a3','p3','s1',300);
insert into interpretesser values('a4','p4','s1',null);
insert into interpretesser values('a2','p2','s3',400);
insert into interpretesser values('a3','p3','s3',null);
insert into interpretesser values('a8','p6','s3',250);
insert into interpretesser values('a9','p7','s3',null);
insert into interpretesser values('a12','p9','s3',400);
insert into interpretesser values('a12','p10','s3',null);
insert into interpretesser values('a14','p12','s3',500);
insert into interpretesser values('a14','p13','s3',null);
insert into interpretesser values('a18','p14','s3',250);
insert into interpretesser values('a18','p15','s3',250);
insert into interpretesser values('a1','p4','s4',300);
insert into interpretesser values('a2','p5','s4',200);
insert into interpretesser values('a3','p6','s4',300);
insert into interpretesser values('a7','p3','s4',null);
insert into interpretesser values('a8','p2','s4',200);
insert into interpretesser values('a22','p1','s4',170);
insert into interpretesser values('a16','p3','s5',null);
insert into interpretesser values('a15','p2','s5',200);
insert into interpretesser values('a20','p6','s5',200);
insert into interpretesser values('a21','p16','s5',200);
insert into interpretesser values('a24','p17','s5',null);


insert into naves values('n1','enterprise',50);
insert into naves values('n2','voyager',6);
insert into naves values('n3','speedo',8);
insert into naves values('n4','galaxy',20);
insert into naves values('n5','star',8);



insert into lanzaderas values('n1',1,2);
insert into lanzaderas values('n1',2,4);
insert into lanzaderas values('n2',1,2);
insert into lanzaderas values('n2',2,3);
insert into lanzaderas values('n2',3,4);
insert into lanzaderas values('n4',4,5);
insert into lanzaderas values('n4',5,2);
insert into lanzaderas values('n4',6,3);
insert into lanzaderas values('n4',7,3);
insert into lanzaderas values('n4',8,4);
insert into lanzaderas values('n4',9,3);
insert into lanzaderas values('n4',10,2);
insert into lanzaderas values('n4',11,2);
insert into lanzaderas values('n5',1,3);
insert into lanzaderas values('n5',2,2);
insert into lanzaderas values('n5',3,1);
insert into lanzaderas values('n5',4,2);
insert into lanzaderas values('n1',3,2);
insert into lanzaderas values('n1',4,1);
insert into lanzaderas values('n1',5,3);


insert into visitas  values('s1','n1','pla1', 'explosiones');
insert into visitas  values('s1','n1','pla2', 'oxigeno disminue');
insert into visitas  values('s1','n1','pla3', 'gases aumentan');
insert into visitas  values('s1','n2','pla4', 'cambia coloracion');
insert into visitas  values('s2','n2','pla3', 'armamento excesivo');
insert into visitas  values('s2','n2','pla1', 'secuestro');
insert into visitas  values('s2','n3','pla4', 'epidemia');
insert into visitas  values('s2','n4','pla5', 'exterminio');
insert into visitas  values('s2','n4','pla3', 'nave averiada');
-- linea comentada para que a funcion fnavesserie poda probarse con todas as combinacions de resultados posibles :
-- insert into visitas  values('s3','n1','pla2', 'nave sen tripulacion');
insert into visitas  values('s3','n2','pla2', 'terremoto');
insert into visitas  values('s3','n3','pla2', 'incendios');
insert into visitas  values('s5','n3','pla8', 'auga evaporada');
insert into visitas  values('s5','n2','pla9', 'sons extranos');
insert into visitas  values('s5','n3','pla10', 'mensaxe socorro');
insert into visitas  values('s5','n2','pla10', 'animal extrano');
commit;
