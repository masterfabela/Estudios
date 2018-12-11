set serveroutput on
create or replace trigger tadestraestadio before insert on adestra for each row
declare

contar number(3);

begin
select count(*) into contar from adestra where ano=:new.ano and codest=:new.codest;
if contar>0 then
	raise_application_error(-20001,'Xa existe un equipo entrenando nese estadio nese ano.');
else
	dbms_output.put_line('Inserción correcta.');
end if;
end;
/
show errors;

