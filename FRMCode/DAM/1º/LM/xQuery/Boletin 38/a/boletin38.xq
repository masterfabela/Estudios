(:
Primeiro apartado

for $x in doc("E:/Godsave´sthecode/Estudios/FRMCode/xQuery/Boletin 38/a/boletin38.xml") //bib/libro
order by $x/titulo 
return $x/titulo/text()

Segundo apartado

for $x in doc("E:/Godsave´sthecode/Estudios/FRMCode/xQuery/Boletin 38/a/boletin38.xml") //bib/libro
where $x/@año=2000
return $x/titulo/text()

Tercerio apartado

for $x in doc("E:/Godsave´sthecode/Estudios/FRMCode/xQuery/Boletin 38/a/boletin38.xml") //bib/libro
  order by $x/titulo
  where count($x/autor)>2
return $x/titulo/text()

Cuarto apartado

for $x in doc("E:/Godsave´sthecode/Estudios/FRMCode/xQuery/Boletin 38/a/boletin38.xml") //bib/libro
return<etiqueta>{$x/titulo/text()} con {count($x/autor)} autor(es).</etiqueta> 

:)
