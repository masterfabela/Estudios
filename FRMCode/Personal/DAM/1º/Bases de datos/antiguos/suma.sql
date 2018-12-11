set serveroutput on
create or replace procedure psuma(n1 number,n2 number)as
total number (3,1);
begin
total:=n1+n2;
dbms_output.put_line('O_total_e:'||total);
end;
/
show errors;
