set serveroutput on
create or replace procedure pdesembarco(n varchar2) as
nec number(2);
cap number(3);
nlanz number(2);

begin
dbms_output.put_line('Podese evacuar a toda a tripulacion da nave indicada coas lanzadeiras propias?');
select count(codn)into nlanz from lanzaderas where codn=n;
if nlanz=0 then
dbms_output.put_line('A nave seleccionada non posue lanzadeiras');
else

select tripul into nec from naves where codn=n;
select sum(capacidade) into cap from lanzaderas where codn=n;

if cap>=nec then
	dbms_output.put_line('Si');
else
	dbms_output.put_line('Non');
end if;
end if;

exception
when no_data_found then
dbms_output.put_line('No existe esa nave');
end;
/
show errors;


