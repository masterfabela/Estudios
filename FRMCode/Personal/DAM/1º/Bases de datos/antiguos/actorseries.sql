set serveroutput on
create or replace procedure pactorseries (vcoda varchar2) as
vnoma actores.noma%type;
vtitulo series.titulo%type;
m number(1):=0;
cursor cseries is select cods from interpretesser where coda=vcoda;
begin
select noma into vnoma from actores where coda=vcoda;
dbms_output.put_line(vcoda);
for fs in cseries loop
	select titulo into vtitulo from series where cods=fs.cods;
	dbms_output.put_line(fs.cods||', na serie '||vtitulo);
	m:=m+1;
end loop;
if m=0 then
	dbms_output.put_line('Este actor non actuou en series.');
else
	dbms_output.put_line('Total de series :'||m||'.');
end if;
exception
	when no_data_found then
	dbms_output.put_line('O codigo non existe.');
end;
/

