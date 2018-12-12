set serveroutput on
create or replace trigger tmaxvulcano before insert on interpretesser for each row
declare
nh number(3);
nv number(3);
conta number(1);

begin

select count (codper) into conta from humanos where codper:=new.codper;

if conta=1 then
	select count(codper) into  nh from interpretesser where cods=:new.cods and codper in 			(select codper from humanos);
	select count(codper) into  nv from interpretesser where cods=:new.cods and codper in 			(select codper from vulcanos);
	if nh=nv or nh>nv then
	raise_application_error(-20001,'Non se permite, por superar o número 			de vulcanos');
	end if;
end if;
end;
/
show errors;

