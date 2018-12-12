set serveroutput on
create or replace procedure ptutiple(n1 number,n2 number)as
begin
psuma(n1,n2);
pmultiplica(n1,n2);
end;
/
show errors;
