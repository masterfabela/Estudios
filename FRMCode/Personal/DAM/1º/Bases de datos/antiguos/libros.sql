set serveroutput on
create or replace procedure plibros as
vcodautor autor.codautor%type;
nl number(2):=0;
cursor cautores is select * from autor;
cursor clibros is select * from libro where codautor=vcodautor; 
begin
for c1 in cautores loop
	vcodautor:=c1.codautor;
	dbms_output.put_line('Autor: '||c1.nomea);
	for c2 in clibros loop
		nl:=nl+1;
		dbms_output.put_line(chr(9)||'Titulo libro:'||c2.titulo);
		dbms_output.put_line(chr(9)||'Editorial:'||c2.editorial);
	end loop;
	if nl=0 then
	dbms_output.put_line('Este autor non ten libros publicados');
	else
	dbms_output.put_line('Este autor ten en total '||nl||' libros');
	end if;
	nl:=0;
end loop;

end;
/
show errors;
