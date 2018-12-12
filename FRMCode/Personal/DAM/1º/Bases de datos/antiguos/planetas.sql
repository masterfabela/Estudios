set serveroutput on
create or replace procedure pplanetas as
cursor cvis is select * from visitas;
begin
for c1 in cvis loop
dbms_output.put_line('Serie: ');
end loop;

end;
/
show errors;


