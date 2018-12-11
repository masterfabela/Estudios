set serveroutput on
create or replace procedure pinter as
hs number(9);
hp number(9);
cs number(12):=0;
cp number(12):=0;
cnt number(9):=0;
cursor cis is select * from interpretesser;
cursor cip is select * from interpretespel;
begin

select sum(horas) into hs from interpretesser;
dbms_output.put_line('As series levan '||hs||' horas totais');
select sum(horas) into hp from interpretespel;
dbms_output.put_line('As peliculas levan '||hp||' horas totais');
if hs>hp then
dbms_output.put_line('As series levan mais horas totais:'||hs);
else
dbms_output.put_line('As peliculas levan mais horas totais:'||hp);
end if;

for c1 in cis loop
select cachehora into cnt from actores where coda=c1.coda;

cs:=cs+nvl(cnt,0)*nvl(c1.horas,0);
end loop;
dbms_output.put_line('Custo das series: '||cs);


for c2 in cip loop
select cachehora into cnt from actores where coda=c2.coda;
cp:=cp+nvl(cnt,0)*nvl(c2.horas,0);
end loop;
dbms_output.put_line('Custo das peliculas: '||cp);

end;
/
show errors;


