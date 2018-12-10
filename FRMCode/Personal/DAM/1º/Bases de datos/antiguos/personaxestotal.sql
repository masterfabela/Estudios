set serveroutput on
create or replace procedure ppt as
cursor cper is select codper,nomper from personaxes;
ck klingon.codper%type;
vcodpla klingon.codpla%type;
vnompla planetas.nompla%type;
vnomper personaxes.nomper%type;
n number(1):=0;
begin
for cf in cper loop
select codper into ck from personaxes where codper=cf.codper;
select nomper into vnomper from personaxes where codper=cf.codper;
select count(codper)into n from klingon where codper=ck;
if n>0 then
dbms_output.put_line(vnomper||', codigo '||ck||' e un klingon');

select codpla into vcodpla from klingon where codper=ck;
if vcodpla is null then
dbms_output.put_line(chr(9)||'Ignorase o seu planeta de procedencia');
else
select nompla into vnompla from planetas where codpla=vcodpla; 
dbms_output.put_line(chr(9)||'Planeta: '||vnompla);
end if;

else
dbms_output.put_line(vnomper||', codigo '||ck);
end if;
end loop;
end;

/
show errors;


