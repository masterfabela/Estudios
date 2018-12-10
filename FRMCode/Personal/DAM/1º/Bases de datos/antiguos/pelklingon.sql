set serveroutput on
create or replace procedure ppelklingon as
compper personaxes.codper%type;
ck number(1):=0;
vcodpel peliculas.codpel%type;
vnomper personaxes.nomper%type;
vcodpla klingon.codpla%type;
vnompla planetas.nompla%type;
cursor cpelis is select * from peliculas;
cursor cper is select codper from interpretespel where codpel=vcodpel;
cursor cklin is select * from klingon where codper=compper;
begin
for c1 in cpelis loop
ck:=0;
dbms_output.put_line('Titulo: '||c1.titulo);
vcodpel:=c1.codpel;
for c2 in cper loop
compper:=c2.codper;
for c3 in cklin loop
select nomper into vnomper from personaxes where codper=compper;
ck:=ck+1;
vcodpla:=c3.codpla;
select nompla into vnompla from planetas where codpla =vcodpla;
dbms_output.put_line(chr(9)||'Personaxe: '||vnomper||', Planeta: '||vnompla);
end loop;
end loop;
if ck=0 then
dbms_output.put_line(chr(9)||'Nesta pelicula non participan Klingons');
else
dbms_output.put_line(chr(9)||chr(9)||'Nesta pelicula participan '||ck||' Klingons');
end if;
end loop;
end;

/
show errors;


