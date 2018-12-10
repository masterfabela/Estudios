set serveroutput on
create or replace procedure preves(a varchar) as
l number (5);
begin
l:=length(a);
for x in 1 .. l loop
dbms_output.put_line(substr(a,(l+1)-x,1));
end loop;
end;
/
show errors;
