set serveroutput on
create or replace trigger insireV before insert on vulcanos for each row 
declare
contah number(1);
contak number(1);

begin
select count(*) into contah from humanos where codper=:new.codper;
select count(*) into contak from klingon where codper=:new.codper;
if contah=1 or contak=1 then
	raise_application_error(-20001,'Este personaxe xa pertence a outra raza.');
	else
	dbms_output.put_line('Insercion correcta');
end if;

end;
/
show errors;


