set serveroutput on
create or replace procedure pprofesion(codprof varchar2) as
cc number(3);
cp Profesion.profesion%type;
cursor clits is select * from cliente where codp=codprof;

begin
select count(*) into cc from cliente where codp=codprof;
select profesion into cp from Profesion where codp=codprof;
dbms_output.put_line(cc);
if cc>0 then
	for c1 in clits loop
		dbms_output.put_line(c1.nome);
	end loop;
else 
	dbms_output.put_line('Non existen clientes con esa profesión.');
end if;
exception
when no_data_found then
dbms_output.put_line('Non existe esa profesion.');

end;
/
show errors;

