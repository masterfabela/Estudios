set serveroutput on
create or replace procedure pnumx as
cursor xe is select codequ,count(*) ce from xogador where codequ is not null group by codequ;
begin
for c1 in xe loop

update equipo set numx=c1.ce where codequ=c1.codequ;
end loop;

end;
/
show errors;
