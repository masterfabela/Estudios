set serveroutput on
create or replace procedure psplanetas as
vcods series.cods%type;
np1 planetas.nompla%type;
v1 number(2):=0;
cx number(1):=0;
cursor cseries is select cods,titulo from series;
--cursor cvisit is select distinct codpla from visitas where cods=vcods;
cursor cvisit is select codpla, count(codpla) conta from visitas where cods=vcods group by codpla;
--count(codpla) conta: eso e un alias.
begin
for c1 in cseries loop
	dbms_output.put_line('Serie: '||c1.titulo);
	vcods:=c1.cods;
	for c2 in cvisit loop
		cx:=cx+1;
		v1:=0;
		select count(*) into v1 from visitas where cods=vcods and codpla=c2.codpla;
		select nompla into np1 from planetas where c2.codpla=codpla;
		
		--dbms_output.put_line(chr(9)||np1||' visitouse '||v1||' veces.');
		dbms_output.put_line(chr(9)||np1||' visitouse '||c2.conta||' veces.');	

	end loop;
	if cx=0 then
		dbms_output.put_line(chr(9)||'Nesta serie non se visitaron planetas.');
	end if;
	cx:=0;
end loop;

end;
/
show errors;


