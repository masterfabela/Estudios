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

Un array pode ter como valor un **array do tipo de dato que lle prometemos** ou **`null`** poñamos esto en practica

O valor asignado ao array creado anteriormente poderia ser

<pre>numeros = {0, 0, 0, 0, 0};</pre>

O que acabamos de facer e crear un array de ceros que son numeros enteiros, e igualar o noso array a iso

O que seria igual a facer

<pre>numeros = new Int [5];</pre>

O que lle estamos asignado e un **novo** `new` **array de ints** `Int []` de **tamaño** `5`, por defecto o valor dos ints e 0.

Ademais como menciomanos anteriormente tamen admite o valor de `null` do mesmo xeito que calquera obxeto neste caso se intentamos acceder a el daranos un error `NullPointerException` , pero esto veremolo mais adiante

<pre>numeros = null;</pre>
