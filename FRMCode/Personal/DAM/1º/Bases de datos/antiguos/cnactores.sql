set serveroutput on
create or replace procedure pcnactores as
vnoma varchar(25);
vcoda interpretesser.coda%type;
vtitulo series.titulo%type;
vcods visitas.cods%type;
cursor cactores is select coda, noma from actores;
cursor cseries is select cods from interpretesser where coda=vcoda;
cursor cpla is select codpla from visitas where cods=vcods;
begin
for fa in cactores loop
	dbms_output.put_line(fa.noma||','||fa.coda);
	vcoda:=fa.coda;
	for fs in cseries loop
		select titulo into vtitulo from series where cods=fs.cods;
		dbms_output.put_line(chr(9)||fs.cods||','||vtitulo);
		vcods:=fs.cods;
		for fp in cpla loop
			dbms_output.put_line(chr(9)||chr(9)||fp.codpla);
		end loop;
	end loop;
end loop;

end;
/
show errors;


