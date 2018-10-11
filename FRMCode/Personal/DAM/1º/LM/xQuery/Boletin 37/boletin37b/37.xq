(:
Apartado 1

for $y in doc("E:/Godsave´sthecode/Estudios/FRMCode/xQuery/boletin37b/Boletin371.xml") //libros/libro

return $y/titulo/text()

Segundo apartado

for $y in doc("E:/Godsave´sthecode/Estudios/FRMCode/xQuery/boletin37b/Boletin371.xml") //libros/libro
  where $y/precio<20
return $y/titulo/text()

Tercerio apartado

for $y in doc("E:/Godsave´sthecode/Estudios/FRMCode/xQuery/boletin37b/Boletin371.xml") //libros/libro
  where $y/precio<20
  order by $y/titulo
return $y/titulo/text()

Cuarto apartado

for $y in doc("E:/Godsave´sthecode/Estudios/FRMCode/xQuery/boletin37b/Boletin371.xml") //libros/libro
  where $y/precio<20
  order by $y/titulo
return <etiqueta>{$y/titulo/text()} de {$y/autor/text()}</etiqueta>

Quinto apartado
:)
for $y in doc("E:/Godsave´sthecode/Estudios/FRMCode/xQuery/boletin37b/Boletin371.xml") //libros/libro
 
return
if($y/@tema="Humanidades"or $y/@tema="Literatura")
then <etiqueta>Libro interesante: {$y/titulo/text()} de {$y/autor/text()}</etiqueta>
else <etiqueta>Libro aburrido: {$y/titulo/text()} de {$y/autor/text()}</etiqueta>