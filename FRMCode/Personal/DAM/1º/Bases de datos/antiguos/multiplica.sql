set serveroutput on
create or replace procedure pmultiplica(n1 number,n2 number)as
total number (7,2);
begin
total:=n1*n2;
dbms_output.put_line('O_total_e:'||total);
end;
/
show errors;