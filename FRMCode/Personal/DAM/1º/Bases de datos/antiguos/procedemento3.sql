set serveroutput on
create or replace procedure calciva(base number,iva number)as
total number (7,2);
begin
total:=base+base*iva/100;
dbms_output.put_line('El_total_es:'||total);
end;
/
show errors;
