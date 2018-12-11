set serveroutput on
update klingon set codpla=null where codper='p47';
update klingon set codpla=null where codper='p42'; 
commit;
create or replace procedure pko(codigo varchar2) as
vcodpla klingon.codpla%type;
vcodper klingon.codper%type;
vnomper personaxes.nomper%type;
vnompla planetas.nompla%type;
m number(1):=0;
begin
--busca do nome;
select nomper into vnomper from personaxes where codper=codigo;
dbms_output.put_line(chr(9)||'Nome do personaxe '||vnomper);
m:=1;
--busca do planeta
select codpla into vcodpla from klingon where codper=codigo;
select codper into vcodper from klingon where codper=codigo;
if vcodpla is null then
dbms_output.put_line('Este personaxe non ten planeta de orixe');
else
select nompla into vnompla from planetas where codpla=vcodpla; 
dbms_output.put_line(chr(9)||chr(9)||'Planeta: '||vnompla);
end if;
update klingon set codpla='pla10' where codper='p47';
update klingon set codpla='pla10' where codper='p42';
commit;
exception
when no_data_found then
if m=0 then
dbms_output.put_line('Non e un personaxe');
else
dbms_output.put_line('Non e un klingon');
end if;

end;


/
show errors;


