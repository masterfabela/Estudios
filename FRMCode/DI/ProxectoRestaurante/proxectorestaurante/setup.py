# módulo que permite instalar un script de Python. Ojo con la sintaxis que es un fichero Python
from distutils.core import setup
setup(name = ‘RestaurAID’,
#nombre del programa
versión =’1.0’,
#versión del programa
description = ‘Programa de xestión das funcións dun restaurante’
author = ‘Francisco Romay Méndez’,
author_email = ‘chiscazo.paco@gmail.com’,
url = ‘https://github.com/masterfabela/Estudios/tree/master/FRMCode/DI/ProxectoRestaurante.git’,
license = ‘GPLv3’
scripts = [‘BDProvinciasLocalidades’, ‘informes’,‘proxectorestaurante’,‘servicios’,‘Xestiondatos’ ] #los módulos .py. Si falla scripts usa py_module
data_files = =[(‘BDRestaurante’, provinciaslocalidades, [‘Restaurante.glade’]),
(‘share/applications’, [‘restaurante.desktop’]),
(‘Imaxes’),(‘Informes’) )