#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>
#include <unistd.h>
int main(int argc, char **argv)
{
char buf[1024];
int num;

//mientras reciba cadena de caracteres, obtengo un número aleatorio comprendido entre 1 y 10
while(fgets(buf, 1024, stdin) != NULL) {
       randomize();           
       num = 1+(int) (10.0*rand()/(RAND_MAX+1.0));
       fprintf(stdout,"%d\n",num);
        fflush(stdout); // IMP: para asegurar que se reciben los datos
    }
exit(0);
}
