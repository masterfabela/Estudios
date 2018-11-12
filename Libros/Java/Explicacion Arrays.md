# Arrays en Java

## Creacion dun array vacio

Para crear un novo array en Java como con calquera outro tipo de dato hay 2 cousas que debemos definir:

- **Nome** do array
- **Tipo do array** define o tipo dos datos que pode conter

Un exemplo practico de creacion de un array seria:

<pre>Int [] numeros;</pre>

Isto seria exactamente igual que facer

<pre>Int [] numeros = null;</pre>

No segundo caso simplemente dariamoslle o valor de dato vacio pero ainda que non llo poñamos e o que fai java por defecto

O array que acabamos de crear levaria os seguintes parametros

- **Nome do array:** Numeros
- **Tipo dos datos que conten:** Int

Se separamos a sua definicion por partes seria:

### Indicamos o tipo de dato:

<pre>Int []</pre>

Isto por suposto e perfectamente aplicable a calquera tipo de dato, tanto datos fisicos como referenciales alguns posibles exemplos poderian ser:

- `Float []`
- `Double []`
- `String []`

### Damoslle nome:

<pre>numeros</pre>

## Asignacion de valor a un array

<pre>int [] numeros;</pre>

Un array pode ter como valor un **array do tipo de dato que lle prometemos** ou **`null`** poñamos esto en practica

O valor asignado ao array creado anteriormente poderia ser

<pre>numeros = {0, 0, 0, 0, 0};</pre>

O que acabamos de facer e crear un array de ceros que son numeros enteiros, e igualar o noso array a iso

O que seria igual a facer

<pre>numeros = new Int [5];</pre>

O que lle estamos asignado e un **novo** `new` **array de ints** `Int []` de **tamaño** `5`, por defecto o valor dos ints e 0.

Ademais como menciomanos anteriormente tamen admite o valor de `null` do mesmo xeito que calquera obxeto neste caso se intentamos acceder a el daranos un error `NullPointerException` , pero esto veremolo mais adiante

<pre>numeros = null;</pre>

## Leer os valores do array

<pre>Int [] anosDende2000 = {2001, 2002, 2003, 2004, 2005};</pre>

Aceder aos valores do array e bastante simple solo necesitamos o nome do array e o indice da posicion de este que queiramos leer e facer algo con el como con calquera outro valor, **e importante saber que o numero de posicion nos arrays empeza en 0**.

Escribindo o valor da posicion 2 do array numeros, esto imprimira por pantalla `2003`

<pre>System.out.println(numeros[2]);</pre>

Gardando nunha variable de tipo Int o valor da posicion 2 do array numeros esto gardaranos `2003` na variable numero.

<pre>
int numero = numeros[2];
</pre>

## Modificar os valores dentro do array

<pre>String [] gruposMusicais;
gruposMusicais = {
  "Beatles",
  "La oreja de BanGoh",
  "Muse",
  "Foster the People"
};
</pre>

Podemos modificar os valores dentro de un array simplemente igualandos a outra cousa que sexa se un tipo compatible a continuacion amosarei alguns exemplos

Imaxinamos que queremos modificar o valor de `"La oreja de BanGoh"` para separar a palabra `BanGoh`.

<pre>
gruposMusicais[1] = "La oreja de Ban Goh";
</pre>

Pois o que facemos e modificar o valor que se garda nesa posicion neste caso a posicion seria `1` e o valor que conteria antes de que o cambiaramos era `"La oreja de BanGoh"`.

Isto tamen se pode facer obviamente pasandolle unha variable como posicion

<pre>
int indice = 1;
gruposMusicais[indice] = "La oreja de Ban Goh"</pre>
