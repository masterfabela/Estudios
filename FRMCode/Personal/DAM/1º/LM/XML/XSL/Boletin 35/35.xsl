<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
    <xsl:template match="/">
        <html>
            <body>
                Ex1<br/>
                <xsl:for-each select="horario/dia">
                    <xsl:value-of select="numdia"/><br/>
                </xsl:for-each>
                Ex2<br/>
                <xsl:for-each select="horario/dia">
                    <xsl:if test="numdia>2">
                        <xsl:value-of select="tarea/nombre"/><br/>
                    </xsl:if>
                </xsl:for-each>
                Ex3<br/>
                <xsl:for-each select="horario/dia">
                    Dia <xsl:value-of select="numdia"/>:
                    <xsl:for-each select="tarea">
                        <xsl:value-of select="@prioridad"/>, <xsl:value-of select="hora-ini"/>,<xsl:value-of select="hora-fin"/>,<xsl:value-of select="nombre"/><br/>
                    </xsl:for-each>
                </xsl:for-each>
                Ex4<br/>
                <xsl:for-each select="horario/dia">
                    <xsl:sort select="numdia" data-type="number"/>
                    Dia <xsl:value-of select="numdia"/><br/>
                </xsl:for-each>
                Ex5<br/>
                <xsl:for-each select="horario/dia/tarea">
                    <xsl:choose>
                        <xsl:when test="count(@prioridad)>0">
                            <xsl:value-of select="@prioridad"/>, <xsl:value-of select="hora-ini"/>,<xsl:value-of select="hora-fin"/>,<xsl:value-of select="nombre"/><br/>
                        </xsl:when>
                        <xsl:otherwise>
                            <xsl:value-of select="hora-ini"/>,<xsl:value-of select="hora-fin"/>,<xsl:value-of select="nombre"/><br/>
                         </xsl:otherwise>
                    </xsl:choose>
                </xsl:for-each>
                Ex6<br/>
                <xsl:for-each select="horario/dia">
                    Dia <xsl:value-of select="numdia"/>:
                    <xsl:for-each select="tarea">
                        <xsl:value-of select="@prioridad"/>, <xsl:value-of select="hora-ini"/>,<xsl:value-of select="hora-fin"/>,<xsl:value-of select="nombre"/>
                            <xsl:choose>
                                <xsl:when test="hora-ini &gt; 12">Mañá<br/></xsl:when>
                                <xsl:when test="hora-ini &lt; 14">Tarde<br/></xsl:when>
                                <xsl:otherwise>Mediodia<br/></xsl:otherwise>
                            </xsl:choose>

                    </xsl:for-each>
                </xsl:for-each>
            </body>    
        </html>
    </xsl:template>
</xsl:stylesheet>