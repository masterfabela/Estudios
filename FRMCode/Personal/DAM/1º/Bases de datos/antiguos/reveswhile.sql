set serveroutput on
create or replace procedure preveswhile (a varchar) as
l number (5);
begin
l:=length(a);
while l > 0  loop
dbms_output.put_line(substr(a,l,1));
l:=l-1;
end loop;
end;
/
show errors;
