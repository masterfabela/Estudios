for $x in doc("E:/Godsave´sthecode/Estudios/FRMCode/xQuery/Boletin 38/b/boletin38.xml") //comentarios/entrada
return <etiqueta>{$x/titulo/text()}. Comentario:{$x/comentario/text()}</etiqueta>