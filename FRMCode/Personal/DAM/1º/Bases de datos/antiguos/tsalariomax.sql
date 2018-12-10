set serveroutput on
create or replace trigger tsalariomax before insert on xogador for each row
declare

salme number(6);

begin
select avg(salario) into salme from xogador where codequ=:new.codequ;
if :new.salario>salme then
	raise_application_error(-20001,'O novo xogador non pode cobrar mais que a media do equipo.');
else
	dbms_output.put_line('Inserción correcta.');
end if;
end;
/
show errors;

