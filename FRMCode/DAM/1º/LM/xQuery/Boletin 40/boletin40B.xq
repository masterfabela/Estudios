for $x in doc("E:/Godsave´sthecode/Estudios/FRMCode/xQuery/Boletin 40/Boletin 40.xml")//quiniela/partido
  for$y in doc("E:/Godsave´sthecode/Estudios/FRMCode/xQuery/Boletin 40/segundo.xml")//equipos/puntos

 return  if($y/@equipo=$x/local/text() or $y/@equipo=$x/visitante/text())
 then <etiqueta>{$y/@equipo}-{$y/text()}</etiqueta>
 else()