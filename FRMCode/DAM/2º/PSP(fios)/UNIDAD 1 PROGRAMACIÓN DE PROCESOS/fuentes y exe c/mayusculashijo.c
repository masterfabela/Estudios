#include <stdio.h>
#include <string.h>
#include <ctype.h>
int main(int argc, char **argv)
{
    char buf[1024];
    int longitud;
    int i;

     char fin[2];
     fin[0]='f';
     fin[1]='f';
     // cadena para terminar proceso, cuando se reciba "ff" se termina proceso hijo
     fgets(buf, 1024, stdin);
    
           while( buf[0]!='f' && buf[1]!='f' ) {
            longitud = strlen(buf);
            for(i = 0; i < longitud; i++) {
                    buf[i] = toupper(buf[i]);
            }
            fputs(buf, stdout);// envio cadena tratada al proceso padre
            fflush(stdout); // IMP: para asegurar que se reciben los datos
            fgets(buf, 1024, stdin); //sigo leyendo            
         } // fin while hemos recibido "ff"

fputs("kk", stdout); // Envio al proceso padre señal "kk"

return 0; //termine correcto

}
