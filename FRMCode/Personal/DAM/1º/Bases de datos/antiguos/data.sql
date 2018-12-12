set serveroutput on
create or replace function fdata(dat date) return varchar2 as
vdni socio.dniu%type;
x varchar2(100):=null;
cursor cdata is select * from prestamo where dat<=ddev and dat>=dini;
begin
for c1 in cdata loop
	 select dniu into vdni from socio where nsocio=c1.nsocio;
	
	x:= x||vdni||','||c1.clibro||','||c1.numeroe||chr(10);
end loop;

 if  x is null then 
	x:='Sen prestamos vixentes nesa data';
 end if ;

return x;

end;
/
show errors;

