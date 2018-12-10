set serveroutput on
create or replace procedure pfor(a number,b number)as
begin
for x in a .. b loop
dbms_output.put_line('hola'||x);
end loop;
end;
/
show errors;

