<exercicio>
Exercicio 1.
{for $x in doc("E:/Godsave´sthecode/Estudios/FRMCode/xQuery/Boletin 40/Boletin 40.xml")//quiniela/partido
return <etiqueta>{$x/local/text()} - {$x/visitante/text()}</etiqueta>}

Exercicio 2.
{for $x at $s in doc("E:/Godsave´sthecode/Estudios/FRMCode/xQuery/Boletin 40/Boletin 40.xml")//quiniela/partido
return <etiqueta>{$s}.{$x/local/text()} </etiqueta>}

Exercicio 3.
{
for $x in doc("E:/Godsave´sthecode/Estudios/FRMCode/xQuery/Boletin 40/Boletin 40.xml")//partido[@id=15]
return <etiqueta>{$x/local/text()}.{$x/visitante/text()}</etiqueta>}

Exercicio 4.
{
for $x in doc("E:/Godsave´sthecode/Estudios/FRMCode/xQuery/Boletin 40/Boletin 40.xml")//partido
  where($x/local="Celta" or $x/visitante="Celta")
return<etiqueta>{$x/local/text()}-{$x/visitante/text()}</etiqueta>}

Exercicio 5.
{
for $x in doc("E:/Godsave´sthecode/Estudios/FRMCode/xQuery/Boletin 40/Boletin 40.xml")//partido
  where($x/@valor="1")
return<etiqueta>{$x/local/text()}</etiqueta>}
</exercicio>