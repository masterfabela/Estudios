#!/bin/bash

if [ "$1" == "1" ]
then
# Copia a la red
	cp -R /var/www/html/* /media/TEIS/a14damianld/DIW
elif [ "$1" == "2" ]
then
# Copia al pendrive
	cp -R /var/www/html/* /media/a14damianld/DAW_DAMIAN/DWCC
else
# Falta destino
	echo Indica tipo de copia
fi
