set serveroutput on
create or replace procedure pmaior(a number,b number)as
begin
if a>b then
dbms_output.put_line('maior');
elsif a<b then
dbms_output.put_line('menor');
else
dbms_output.put_line('igual');
end if;
end;
/
show errors;

