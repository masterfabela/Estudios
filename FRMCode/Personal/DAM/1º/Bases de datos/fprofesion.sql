set serveroutput on
create or replace function fprofesion(codprof varchar2) return cliente.nome%type as
cc number(3);
nomes varchar2(99);
cp Profesion.profesion%type;
cursor clits is select * from cliente where codp=codprof;

begin
select count(*) into cc from cliente where codp=codprof;
select profesion into cp from Profesion where codp=codprof;

if cc>0 then
	for c1 in clits loop
		nomes:=nomes||c1.nome||chr(10);
	end loop;
	return nomes;
else 
	return 'Non existen clientes con esa profesión.';
end if;
exception
when no_data_found then
return 'Non existe esa profesion.';

end;
/
show errors;

