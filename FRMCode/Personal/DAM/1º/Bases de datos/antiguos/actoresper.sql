set serveroutput on
create or replace procedure pactoresper as
vcoda interpretesser.coda%type;
vcodper interpretesser.codper%type;
cursor cactores is select coda, noma from actores;
cursor cperso is select codper from interpretesser where coda=vcoda;
cursor cnome is select codper, nomper from personaxes where codper=vcodper;
begin
for fa in cactores loop
	dbms_output.put_line(fa.noma||','||fa.coda);
	vcoda:=fa.coda;
	for fp in cperso loop
		vcodper:=fp.codper;
		for fc in cnome loop
			dbms_output.put_line(chr(9)||fc.nomper||','||fc.codper);
		end loop;
	end loop;
end loop;
end;
/
show errors;


