set serveroutput on
create or replace trigger txogmax before insert on xogador for each row
declare

nxog number(6);

begin
select count(*) into nxog from xogador where codequ=:new.codequ;
if nxog>6 then
	raise_application_error(-20001,'Este equipo xa ten 6 xogadores.');
else
	dbms_output.put_line('Insercion correcta.');
end if;
end;
/
show errors;

