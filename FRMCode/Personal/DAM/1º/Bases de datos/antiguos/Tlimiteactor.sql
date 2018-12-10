set serveroutput on
create or replace trigger tlimiteactor before insert on interpretesser for each row
declare

horast number(6);

begin
select sum(horas) into horast from interpretesser where coda=:new.coda and cods=:new.cods;
if horast+:new.horas>500 then
	raise_application_error(-20001,'Horas excedidas');
end if;
end;
/
show errors;

