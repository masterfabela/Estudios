set serveroutput on
create or replace function data(fecha date) return varchar2 as
dnib socio.dniu%type;
numer prestamo.numeroe%type;
conta number(2):=0;
retorno varchar2(100);
cursor csocios is select * from prestamo where fecha>=dini and fecha<=ddev;

begin
for c1 in csocios loop
conta:=conta+1;
    select dniu into dnib from socio where c1.nsocio=nsocio;
    retorno:=retorno||dnib||','||c1.clibro||c1.numeroe||','||conta||chr(10);
end loop;
if conta>0 then
    return retorno;
    else
    return 'Non hai prestamos nesa data';
end if;
end;
/
show errors;
