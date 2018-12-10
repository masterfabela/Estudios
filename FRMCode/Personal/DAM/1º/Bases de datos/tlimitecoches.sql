set setveroutput on
create or replace trigger tlimitecoches before insert on coche for each row
declare
cmc number(2);
begin
select count(*) into cmc from coche where marca=:new.marca and codg=:new.codg;
if cmc>2 then 
	raise_application_error(-20001,'Sobrepasada a cantidade de coches desa marca nese garaxe.');
else
	dbms_output.put_line('Rexistro correcto.');
end if;

end;
/
show errors;

