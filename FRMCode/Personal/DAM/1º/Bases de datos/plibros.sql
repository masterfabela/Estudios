set serveroutput on
create or replace procedure libros as
vcodautor autor.codautor%type;
conta number(2):=0;
cursor cautores is select * from autor;
cursor clibro is select * from libro where codautor=vcodautor;

begin
for c1 in cautores loop
dbms_output.put_line('Autor: '||c1.nomea);
vcodautor:=c1.codautor;
    for c2 in clibro loop
        dbms_output.put_line(chr(9)||'Titulo:'||c2.titulo||' Editorial:'||c2.editorial);
        conta:=conta+1;
    end loop;
    if conta>0 then 
            dbms_output.put_line(chr(9)||chr(9)||'Este autor posue '||conta||' libros.');
        else
            dbms_output.put_line(chr(9)||chr(9)||'Non dispomos libres deste autor.');
        end if;
        conta:=0;
end loop;


end;
/
show errors;
