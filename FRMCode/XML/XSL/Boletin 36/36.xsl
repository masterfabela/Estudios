<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/">
        <html>
            <body>
            Exercicio 1<br/>
                <h1>Mi Biblioteca</h1>
                <xsl:for-each select="libros/libro">
                <b>Titulo: </b><xsl:value-of select="titulo"/>
                <br/>
                <b>Autor: </b><xsl:value-of select="autor"/>
                <br/>
                <br/>
                </xsl:for-each>

            Exercicio 2<br/>
            <xsl:for-each select="libros/libro">
                <xsl:sort select="titulo"/>
                <xsl:value-of select="titulo"/>,<xsl:value-of select="autor"/>
                <br/>
            </xsl:for-each><br/>

            Exercicio 3<br/>
            <h1>Mi Biblioteca</h1>
                <xsl:for-each select="libros/libro[precio>30]">
                <b>Titulo: </b><xsl:value-of select="titulo"/>
                <br/>
                <b>Autor: </b><xsl:value-of select="autor"/>
                <br/>
                <b>Autor: </b><xsl:value-of select="precio"/>
                <br/>
                <br/>
                </xsl:for-each>

            Exercicio 4<br/>
            <select name="titulos">
            <xsl:for-each select="libros/libro">
                <option>
                    <xsl:value-of select="titulo"/>
                </option>
            </xsl:for-each>
            </select>
            <br/><br/>

            Exercicio 5<br/>
            <xsl:for-each select="libros/libro">
                <xsl:if test="@leng='español'">
                <xsl:value-of select="titulo"/>,<xsl:value-of select="autor"/><br/>
                </xsl:if>
            </xsl:for-each><br/>

            Exercicio 6<br/>
            <h1>Mi Biblioteca</h1>
            <table border="2" style="border-color:grey;text-align:center">
                <tr style="background-color:lightblue"><td>Titulo</td><td>ISBN</td></tr>
                <xsl:for-each select="libros/libro">
                    <tr><td><xsl:value-of select="titulo"/></td><td><xsl:value-of select="isbn"/></td></tr>
                </xsl:for-each>
            </table>
            Exercicio 7<br/>
            <h1>Mi Biblioteca</h1>
            <table border="2" style="border-color:grey;text-align:center">
                <tr style="background-color:lightblue"><td>Titulo</td><td>Autor</td><td>ISBN</td><td>Precio</td></tr>
                <xsl:for-each select="libros/libro">
                    <tr><td><xsl:value-of select="titulo"/></td><td><xsl:value-of select="autor"/></td><td><xsl:value-of select="isbn"/></td><td><xsl:value-of select="precio"/></td></tr>
                </xsl:for-each>
            </table>
            <b>El numero de libros es de </b> = <xsl:value-of select="count(libros/libro)"/> <br/>
            Exercicio 8<br/>
            

            </body>    
        </html>
    </xsl:template>
</xsl:stylesheet>