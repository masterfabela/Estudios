alter session set nls_date_format = 'dd.mm.yyyy hh24:mi:ss';
drop table escalas cascade constraint;
drop table conecta cascade constraint;
drop table internacional cascade constraint;
drop table nacional cascade constraint;
drop table reservas cascade constraint;
drop table axencias cascade constraint;
drop table pasaxeiros cascade constraint;
drop table  voos cascade constraint;
drop table  aterran cascade constraint;
drop table  modelos cascade constraint;
drop table aeroportos cascade constraint;
drop table paises cascade constraint; 
purge recyclebin;
create table paises(
codigop varchar2(3),
nomep varchar2(15) unique,
primary key (codigop)
);
insert into paises values ('p1','portugal');
insert into paises values ('p2','reinounido ');
insert into paises values ('p3','italia ');
insert into paises values ('p4','alemania ');
insert into paises values ('p5','estadosunidos');
insert into paises values ('p6','francia');
insert into paises values ('p7','polonia');
insert into paises values ('p8','espanha');

create table aeroportos(
codigoa varchar2(3),
nomea varchar2(15) unique,
cidadea varchar2(15),
codigop varchar2(3),
primary key (codigoa),
foreign key(codigop) references paises(codigop)
);
insert into aeroportos values ('a1','opo','oporto','p1');
insert into aeroportos values ('a2','lis','lisboa','p1');
insert into aeroportos values ('a3','lhr','londres','p2');
insert into aeroportos values ('a4','lgw','londres','p2');
insert into aeroportos values ('a5','ltn','londres','p2');
insert into aeroportos values ('a6','trn','turin','p3');
insert into aeroportos values ('a7','fco','roma','p3');
insert into aeroportos values ('a8','muc','munich','p4');
insert into aeroportos values ('a9','fra','frankfurt','p4');
insert into aeroportos values ('a10','jfk','novayork','p5');
insert into aeroportos values ('a11','ter','teruel','p8');
insert into aeroportos values ('a12','mur','murcia','p8');



create table  modelos(
codigom varchar2(10),
capacidadem integer,
primary key (codigom)
);
insert into modelos values ('airbusa380',853);
insert into modelos values ('boeing777',550);
insert into modelos values ('boeing747',524);
insert into modelos values ('airbusa340',295);
insert into modelos values ('airbusa330',440);
insert into modelos values ('ilyushin96',436);


create table aterran (
codigoa varchar2(3),
codigom varchar2(10),
primary key (codigoa,codigom),
foreign key (codigoa) references aeroportos(codigoa),
foreign key (codigom) references modelos(codigom)
);

insert into aterran values ('a1','boeing777');
insert into aterran values ('a1','airbusa340');
insert into aterran values ('a1','ilyushin96');
insert into aterran values ('a2','boeing777');
insert into aterran values ('a2','airbusa330');
insert into aterran values ('a3','ilyushin96');
insert into aterran values ('a3','boeing777');
insert into aterran values ('a4','airbusa330');
insert into aterran values ('a5','boeing777');
insert into aterran values ('a5','airbusa340');
insert into aterran values ('a9','airbusa340');
insert into aterran values ('a7','airbusa340');

create table voos(
codigov varchar2(10),
datav date,
horav integer,
libres integer,
linhaaerea varchar2(15),
codigoao varchar2(3),
codigoad varchar2(3),
codigom  varchar2(10),
primary key( codigov),
foreign key (codigoao) references aeroportos(codigoa),
foreign key (codigoad) references aeroportos(codigoa),
foreign key (codigom) references modelos(codigom)
);
insert into voos values ('v1','12/4/2016',16,200,'tap','a1','a3','boeing777');
insert into voos values ('v2','15/5/2016',18,1,'airfrance','a2','a4','airbusa330');
insert into voos values ('v3','17/6/2016',8,3,'ryanair','a1','a3','ilyushin96');
insert into voos values ('v4','19/7/2016',10,2,'tam','a5','a1','airbusa340');
insert into voos values ('v5','21/8/2016',10,2,'delta','a9','a7','airbusa340');

create table pasaxeiros(
dni varchar2(9),
nome varchar2(15),
telf integer, 
codigop varchar2(3),
primary key (dni),
foreign key (codigop) references paises(codigop)
);
insert into pasaxeiros values ('361','antia',111,'p1');
insert into pasaxeiros values ('362','xiana',null,'p2');
insert into pasaxeiros values ('363','pedro',333,'p2');
insert into pasaxeiros values ('364','ana',444,'p3');
insert into pasaxeiros values ('365','carlos',555,'p4');
insert into pasaxeiros values ('366','bieito',null,'p4');
insert into pasaxeiros values ('367','ainoa',777,'p4');
insert into pasaxeiros values ('368','xiana',888,'p1');

create table axencias(
cif varchar2(9),
nomeax  varchar2(15),
primary key (cif)
);
insert into axencias values ('c1','lira');
insert into axencias values ('c2','viaxes');
insert into axencias values ('c3','idea');
insert into axencias values ('c4','sonhos');



create table reservas(
dni varchar2(9),
codigov varchar2(10),
cif varchar2(9),
datar date,
nr integer,
primary key (dni,codigov,cif),
foreign key (dni) references pasaxeiros(dni),
foreign key (codigov) references voos(codigov),
foreign key (cif) references axencias(cif)
);

insert into reservas values ('363','v1','c2','1/3/16',345);
insert into reservas values ('361','v1','c1','4/3/16',765);
insert into reservas values ('364','v2','c4','3/3/16',234);
insert into reservas values ('363','v3','c1','5/3/16',765);
insert into reservas values ('362','v3','c2','3/3/16',345);
insert into reservas values ('361','v3','c2','4/3/16',123);


create table nacional(
codigoa varchar2(3),
capacidade integer,
extension integer,
primary key (codigoa),
foreign key (codigoa) references aeroportos(codigoa)
);
insert into nacional values ('a11',12,10000);
insert into nacional values ('a12',20,12000);

create table internacional(
codigoa varchar2(3),
categoria integer,
primary key (codigoa),
foreign key (codigoa) references aeroportos(codigoa)
);
insert into internacional values ('a2',1);
insert into internacional values ('a3',1);
insert into internacional values ('a1',2);
insert into internacional values ('a4',2);
insert into internacional values ('a5',1);
insert into internacional values ('a6',1);
insert into internacional values ('a9',1);

create table conecta(
codigoa varchar2(3),
codigop varchar2(3),
foreign key (codigoa) references internacional(codigoa),
foreign key (codigop) references paises(codigop)
);
 
insert into conecta values ('a1','p2');
insert into conecta values ('a2','p2');
insert into conecta values ('a9','p3');

create table escalas(
codigov varchar2(10),
codigoa varchar2(3),
primary key(codigov,codigoa),
foreign key (codigov) references voos(codigov),
foreign key (codigoa) references aeroportos(codigoa)
);

insert into escalas values ('v1','a4');
insert into escalas values ('v1','a6');
insert into escalas values ('v2','a5');
insert into escalas values ('v2','a7');
commit;


