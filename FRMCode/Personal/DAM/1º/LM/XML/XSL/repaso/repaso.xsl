<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/">
        <html>
            <body>
               Exercicio 1
               <table border="1">
               <tr><td text-align="center">Nombre</td><td text-align="center">Mercado</td><td text-align="center">Precio0</td></tr>
                <xsl:for-each select="fichero/cotizacion">
                    <tr><td><xsl:value-of select="nombre"/></td><td><xsl:value-of select="mercado"/></td><td><xsl:value-of select="precio"/></td></tr>
                </xsl:for-each>
                </table>
                El precio total es:<xsl:value-of select="sum(//precio)"/>
                <br/>
               Exercicio 2
            <table border="1">
               <tr><td>Nombre</td><td>Mercado</td><td>Precio0</td><td>Fecha</td></tr>
                <xsl:for-each select="fichero/cotizacion">
                    <tr><td><xsl:value-of select="nombre"/></td>
                    <xsl:choose>
                        <xsl:when test="precio>(sum(//precio)div(count(//cotizacion)))">
                        <td style="color:red"><xsl:value-of select="mercado"/></td>
                    </xsl:when>
                    <xsl:otherwise>
                        <td><xsl:value-of select="mercado"/></td>
                    </xsl:otherwise>
                    </xsl:choose>
                    <td><xsl:value-of select="precio"/></td>
                    <td><xsl:value-of select="fecha/dia"/>/<xsl:value-of select="fecha/mes"/>/<xsl:value-of select="fecha/anio"/></td></tr>
                </xsl:for-each>
            </table>
                El precio medio es de = <xsl:value-of select="sum(//precio)div(count(//cotizacion))"/> <br/>
                <br/>
               Exercicio 3
                <table border="1" >
               <tr style="background-color:grey"><td><b>Nombre</b></td><td><b>Código</b></td></tr>
                <xsl:for-each select="fichero/cotizacion">
                    <tr style="background-color:grey"><td><xsl:value-of select="nombre"/></td><td><xsl:value-of select="@cnae"/></td></tr>
                </xsl:for-each>
                </table>
                
                <br/>
               Exercicio 4<br/>
               <b style="text-decoration:underline">LISTADO EMPRESAS</b>
               <ul>
               <xsl:for-each select="fichero/cotizacion">
                    <li><xsl:value-of select="nombre"/></li>
                    <li><xsl:value-of select="mercado"/></li>
                    <li><xsl:value-of select="precio"/></li>
                    <li>Fecha
                        <ul style="list-style-type:disc">
                        <li><xsl:value-of select="fecha/dia"/></li>
                        <li><xsl:value-of select="fecha/mes"/></li>
                        <li><xsl:value-of select="fecha/anio"/></li>
                        </ul>
                    </li>
            </xsl:for-each>
                
               </ul>

            </body>    
        </html>
    </xsl:template>
</xsl:stylesheet>