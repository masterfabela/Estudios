(:
Primer apartadp
for $y in doc("E:/Godsave´sthecode/Estudios/FRMCode/xQuery/boletin 37/Boletin37.xml") //alumnos/alumno
  where $y/nota>=5
return $y/nombre

Segundo apartado
for $x in doc("E:/Godsave´sthecode/Estudios/FRMCode/xQuery/boletin 37/Boletin37.xml") //alumnos/alumno
  where $x/nota>=5
return <elemento>nota={$x/nota/text()} persoa={$x/@dni/text()}</elemento>

Tercer apartado
for $x in doc("E:/Godsave´sthecode/Estudios/FRMCode/xQuery/boletin 37/Boletin37.xml") //alumnos/alumno
  where $x/nota>=6 and $x/nota<=8
return $x/nombre/text()

Cuarto apartado
for $y in doc("E:/Godsave´sthecode/Estudios/FRMCode/xQuery/boletin 37/Boletin37.xml") //alumnos/alumno
 order by $y/@apellidos
return $y/nombre/text()

Quinto apartado
for $y in doc("E:/Godsave´sthecode/Estudios/FRMCode/xQuery/boletin 37/Boletin37.xml") //alumnos/alumno
 order by $y/@dni
return $y/nombre/text()

Sexto apartado
:)
for $x at $y in doc("E:/Godsave´sthecode/Estudios/FRMCode/xQuery/boletin 37/Boletin37.xml") //alumnos/alumno
return <elemento>{$y}.Nombre={$x/nombre/text()}</elemento>