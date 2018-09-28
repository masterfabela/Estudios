#include <stdio.h>
#include <string.h>
#include <ctype.h>
int main(int argc, char **argv)
{
    char buf[1024];
    int longitud;
    int i;


    while(fgets(buf, 1024, stdin) != NULL) {
           longitud = strlen(buf);
            for(i = 0; i < longitud; i++) {
                    buf[i] = toupper(buf[i]);
            }
            fputs(buf, stdout);
            fflush(stdout); // IMP: para asegurar que se reciben los datos
}
return 0;
}