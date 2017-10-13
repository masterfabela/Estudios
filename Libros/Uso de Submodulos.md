#Uso de submodulos

#Que e un submodulo?
Os submodulos son a maneira mais eficiente de engadir repositorios dentro de outros ainda que para compartir codigo e menos eficiente e comodo que a maneira
na que o facemos habitualmente polo tanto debemos evitar o seu abuso na medida do posible, Os submodulos son basicamente unha referencia de un repositorio dentro de outro repositorio, e permitennos ter varios proxectos dentro do mesmo ao clonar un repositorio algo extremadamente util se temos que usar outros repositorios ou temos proxectos demasiado enfocados ou grandes como para gardar aqui por si mesmo, asi que a maneira mais eficiente de compartilos e enlazalos
en forma de submodulo, esto permitenos acceder a todos os proxectos dende un simple clone e axudarnos mutuamente no que necesitemos

#Como podo engadir eu un submodulo dun repositorio propio meu?
O proceso e relativamente moi sinxelo e so necesitaremos un par de comandos

1. Clonar o Repositorio propio dentro do que queremos que sexa o que o gardara como submodulo 
Esto so o faremos a cando o engadamos ao repositorio, despois non teremos que volver a facelo bastaranos con clonar o repositorio no que se engloba para telo

    git submodule add <direccion_de_repositorio_a_engadir> <Ruta_do_noso_repositorio_onde_o_gardaremos>

Un exemplo poderia ser:

    git submodule add https://github.com/masterfabela/Homepanion.git 'Jose Ramón/Proxecto Homepanion'

E asi de sinxelo xa o teriamos engadido, pero para poderen ver os seus arquivos e modificalo teremos que inicialo e updatealo, xa que agora tan so teremos a sua referencia 

2. Iniciar e updatear o submodulo
Ainda que xa temos a referencia en local temoslle que decir a git que queremos editalo e nos interesa telo enteiro cos seus arquivos, esto non se fai automaticamente porque poderia haber centos de submodulos nun proxecto ocupar unha bestialidade ao baixarse todos se so pretendemos traballar sobre un

    git submodule init

    git submodule update


# Como traballo nos meus submodulos?
Como os submodulos son repositorios de git individuais deberas usalo como un proxecto de git en si mesmo, ainda que se pode ver o que hai dentro dende o repositorio que o alberga non podes comitear os seus arquivos dende ahi, teras que facelo dende a subcarpeta, esto permitiranos poder ter proxectos grandes que se garden nos dous lugares de forma totalmente eficiente.




Estas instruccion foron creadas a partir desta guia http://huntingbears.com.ve/trabajando-con-submodulos-en-git.html non dubides en pasarte por ahi se non tes claras as ideas, ahi explica moito mais en detalle o funcionamento dos submodulos

Moita sorte e a picar!!!  :)