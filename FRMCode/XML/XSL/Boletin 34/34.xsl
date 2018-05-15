<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/">
        <html>
            <body>
                Ex.1 <br/>
                <h1>Mis libros</h1>
                    <xsl:for-each select="/libros/libro">
                        <b>Título:</b><xsl:value-of select="titulo"/>
                        <br/>
                        <b>Autor:</b><xsl:value-of select="autor"/>
                        <br/>
                        <br/>
                    </xsl:for-each>
                Ex.2<br/>
                <h1>Mis libros</h1>
                El numero de libros es <xsl:value-of select="count(/libros/libro)"/>.
                Ex.3<br/>
                <ul>
                <xsl:for-each select="libros/libro">
                    <xsl:sort select="titulo"/>
                    <li><xsl:value-of select="titulo"/>,<xsl:value-of select="autor"/></li>
                </xsl:for-each>
                </ul>
                Ex.4<br/>
                <table border="1">
                <xsl:for-each select="libros/libro">
                    <tr>
                        <td colspan="1" rowspan="1"><xsl:value-of select="titulo"/></td>
                        <td colspan="1" rowspan="1"><xsl:value-of select="autor"/></td>
                        <td colspan="1" rowspan="1"><xsl:value-of select="isbn"/></td>
                        <td colspan="1" rowspan="1"><xsl:value-of select="precio"/></td>
                    </tr>
                </xsl:for-each>
                </table>
                Ex.5<br/>
                <xsl:for-each select="libros/libro">
                    <xsl:if test="precio>30">
                        <xsl:value-of select="titulo"/><br/>
                    </xsl:if>
                </xsl:for-each>
                Ex.6<br/>
                <select name="titulos" >
                <xsl:for-each select="libros/libro">
                    <option><xsl:value-of select="titulo"/></option>
                </xsl:for-each>
                </select>
            </body>    
        </html>
    </xsl:template>
</xsl:stylesheet>