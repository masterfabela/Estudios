set serveroutput on
create or replace procedure paxenciacoche as
vcoda axencia.coda%type;
cc number(3):=0;
cursor dir is select * from axencia;
cursor mar is select * from coche where codco in(select codco from reserva where coda=vcoda);

begin

for c1 in dir loop
	dbms_output.put_line(c1.direcion);
	vcoda:=c1.coda;
	select count(codco) into cc from reserva where coda=c1.coda;
	if cc>0 then
		dbms_output.put_line(chr(9)||'Numero de coches: '||cc);
		for c2 in mar loop
			dbms_output.put_line(chr(9)||c2.marca);
		end loop;
	else
		dbms_output.put_line('Esta axencia non ten coches asignados.');
	end if;
end loop;

end;
/
show errors;

