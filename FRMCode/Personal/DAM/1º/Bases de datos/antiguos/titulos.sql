set serveroutput on
create or replace procedure ptitulos (ti varchar2)as
vcl libro.clibro%type;
vne libro.nexemplares%type;
vn number(2):=0;
cursor clibros is select * from exemplar where clibro=vcl;

begin
select clibro into vcl from libro where titulo=ti;
select nexemplares into vne from libro where titulo=ti;
for c1 in clibros loop
	dbms_output.put_line('Codigos do libro:'||c1.clibro||','||c1.numeroe);
	vn:=vn+1;
end loop;
if vn=0 then
	dbms_output.put_line('Non se dispon de exemplares deste libro:');
else
dbms_output.put_line('Total:'||vn);
end if;
exception
	when no_data_found then
	dbms_output.put_line('Libro inexistente.');
end;
/
show errors;
