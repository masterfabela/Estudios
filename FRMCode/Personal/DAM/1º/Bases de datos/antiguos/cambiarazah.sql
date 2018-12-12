set serveroutput on
create or replace trigger insireH before insert on humanos for each row 
declare
contav number(1);
contak number(1);

begin
select count(*) into contav from vulcanos where codper=:new.codper;
select count(*) into contak from klingon where codper=:new.codper;
if contav=1 or contak=1 then
	raise_application_error(-20001,'Este personaxe xa pertence a outra raza.');
	else
	dbms_output.put_line('Insercion correcta');
end if;

end;
/
show errors;


