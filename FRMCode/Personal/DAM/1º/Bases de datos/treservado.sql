set setveroutput on
create or replace trigger treservado before insert on reserva for each row
declare
cd number(2);
begin
select count(*) into cd from reserva where codco=:new.codco and fr=:new.fr;
if cd>0 then
	raise_application_error(-20001,'Ese coche xa esta reservado para esa data.');
else
	dbms_output.put_line('Reserva rexistrada.');
end if;
end;
/
show errors;

