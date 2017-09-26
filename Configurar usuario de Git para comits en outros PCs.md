

# Configurando usuario en maquinas externas
https://help.github.com/articles/setting-your-commit-email-address-in-git/

1 - Con visual studio code pulsamos F1 e buscamos o comando "Select default shell" 

2 - Selecionamos Git Bash para abrir o terminal de git, para isto deberiamos de ter instalado o plugin de
    git extension pack e Git no equipo

3 - No terminal aberto en vscode escribiremos o siguiente comando:
    
    git config --global user.email "email@example.com"
    
Con este comando diremoslle ao repositorio git global do equipo que todolos cambios se suban 
coa direcion mail descrita, debe ser unha asociada a nosa cuenta de gitHub para que os cambios sean asociados
    
4 - Para comprobar o mail que tenemos asociado escribimos o comando:
    
    git config --global user.email

Se queredes cambiar o mail de subida por defecto tan so no directorio onde tedes
o repositorio tan so tedes que omitir o parametro --global do comando tal que asi:

    git config user.email "email@deExemplo"