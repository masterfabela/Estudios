set serveroutput on
create or replace trigger tdistserie before insert on series for each row
declare

trepp number(1);
treps number(1);

begin
select count(*) into trepp from peliculas where titulo=:new.titulo;
select count(*) into treps from series where titulo=:new.titulo;
if trepp>0 or treps>0 then
	raise_application_error(-20001,'Ese titulo xa existe.');
else
	dbms_output.put_line('Insercion correcta.');
end if;
end;
/
show errors;

