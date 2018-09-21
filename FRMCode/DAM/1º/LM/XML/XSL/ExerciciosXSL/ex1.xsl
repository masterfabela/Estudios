<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/">
        <html>
            <body>
                Primeiro apartado:
                <br/>
                <xsl:for-each select="libros/libro[1]">
                    <xsl:value-of select="autor"/>
                </xsl:for-each>
                <br/>
                Segundo apartado:
                <br/>
                <xsl:for-each select="libros/libro">
                    <xsl:sort select="titulo"/>
                    <xsl:value-of select="titulo"/>
                    <br/>
                </xsl:for-each>
                Terceiro apartado:
                <br/>
                <xsl:for-each select="libros/libro">
                    <xsl:sort select="autor"/>
                    <xsl:value-of select="autor"/>:<xsl:value-of select="titulo"/>
                    <br/>
                </xsl:for-each>
                Cuarto apartado:
                <ul>
                <xsl:for-each select="libros/libro">
                    <li><xsl:value-of select="titulo"/></li>
                    <br/>
                </xsl:for-each>
                </ul>
                Quinto apartado:
                <br/>
                <xsl:for-each select="libros/libro[1]">
                    <table border="1">
                        <tr><td colspan="1" rowspan="1"><xsl:value-of select="titulo"/></td><td colspan="1" rowspan="1"><xsl:value-of select="autor"/></td></tr>
                    </table>
                </xsl:for-each>
                Sexto apartado:
                <xsl:for-each select="libros/libro">
                    <table border="1">
                        <tr><td colspan="1" rowspan="1"><xsl:value-of select="titulo"/></td><td colspan="1" rowspan="1"><xsl:value-of select="isbn"/></td></tr>
                    </table>
                </xsl:for-each>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>