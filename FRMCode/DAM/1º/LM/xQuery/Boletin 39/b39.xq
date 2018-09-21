<html>
<body>
Exercicio 1.
<ul>
{for $x in doc("E:/Godsave´sthecode/Estudios/FRMCode/xQuery/Boletin 39/Boletin 39.xml") //bookstore/book
return<li>{$x/title/text()}</li>}
</ul>

Exercicio 2.
<table border="2" style="background-color:red;">
{for $x in doc("E:/Godsave´sthecode/Estudios/FRMCode/xQuery/Boletin 39/Boletin 39.xml") //bookstore/book
return<tr><td>{$x/title/text()}</td></tr>}
</table>

Exercicio 3.
{
for $x in doc("E:/Godsave´sthecode/Estudios/FRMCode/xQuery/Boletin 39/Boletin 39.xml") //bookstore/book
  order by $x/title
return<etiqueta>Titulo: {$x/title/text()}. Precio:{$x/price/text()}. Descontado:{$x/price/text()*0.9}.
</etiqueta>}

Exercicio 4.
<table border="2" style="background-color:red;">
{for $x in doc("E:/Godsave´sthecode/Estudios/FRMCode/xQuery/Boletin 39/Boletin 39.xml") //bookstore/book
return<tr><td>{$x/title/text()}</td><td>{$x/price/text()}</td></tr>}
</table>
</body>
</html>