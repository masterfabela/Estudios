set serveroutput on
create or replace trigger tinxirex before insert on equipo for each row 
declare
conta number(3):=0;
begin
select count (*) into conta from equipo;
dbms_output.put_line('Agora hai '||conta||' equipos.');

end;
/
show errors;


