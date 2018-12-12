declare
iva number (4,1);
base number (3,1);
c number (5,2);
begin
iva:=&dame_la_base.;
base:=&introduce_el_iva.;
c:=iva+iva*base/100;
dbms_output.put_line('El_total_es:'||c);
end;
/
