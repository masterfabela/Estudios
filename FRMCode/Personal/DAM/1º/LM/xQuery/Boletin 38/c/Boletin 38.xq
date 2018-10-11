(:

Primeiro apartado
for $x in doc("E:/Godsave´sthecode/Estudios/FRMCode/xQuery/Boletin 38/c/Boletin 38.xml") //libros/libro
  order by $x/titulo
return $x/titulo/text()

Segundo apartado

for $x in doc("E:/Godsave´sthecode/Estudios/FRMCode/xQuery/Boletin 38/c/Boletin 38.xml") //libros/libro
  order by $x/autores/autor[1]/nombre
return $x/titulo/text()

Terceiro apartado

for $x in doc("E:/Godsave´sthecode/Estudios/FRMCode/xQuery/Boletin 38/c/Boletin 38.xml") //libros/libro
return <etiqueta>{$x/autores/autor[1]/nombre/text()}.  {$x/autores/autor[1]/apellido/text()}</etiqueta>

Cuarto apartado

for $x in doc("E:/Godsave´sthecode/Estudios/FRMCode/xQuery/Boletin 38/c/Boletin 38.xml") //libros/libro
return <etiqueta>{$x/titulo/text()} con  {$x/count($x/autores/autor)} autor(es).</etiqueta>

Quinto apartado

for $x in doc("E:/Godsave´sthecode/Estudios/FRMCode/xQuery/Boletin 38/c/Boletin 38.xml") //libros/libro
return
  if(count(autores/autor)>1)
  then <etiqueta>{$x/titulo/text()} ten autores multiples.</etiqueta>
  else <etiqueta>{$x/titulo/text()} tenun unico autor.</etiqueta>

Sexto apartado

for $x in doc("E:/Godsave´sthecode/Estudios/FRMCode/xQuery/Boletin 38/c/Boletin 38.xml") //libros/libro
where $x/autores/autor/nombre="Axel"
return $x/titulo/text()

:)
