set serveroutput on
create or replace view vxogador as select * from xogador;
create or replace trigger tborraxog instead of delete on vxogador
declare
cantxog number(5);
vcodequ varchar2(4);

begin

select count(codx) into cantxog from xogador where codequ =:old.codequ;

delete from xogador where codx=:old.codx;
dbms_output.put_line('Borrado');
vcodequ:=:old.codequ;

dbms_output.put_line(cantxog);
dbms_output.put_line(vcodequ);
if cantxog=0 then
	vcodequ:=:old.codequ;
	delete from equipo where codequ=vcodequ;
end if;
end;
/
show errors;

