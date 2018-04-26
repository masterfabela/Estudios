<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
  <xsl:template match="/">
  <!-- Pode meterse as condicions dentro dun html para cambiar o estilo-->
    <html>
      <body>
        <xsl:for-each select="colegio/modulos/modulo[curso=2]">
            <p>
            Nombre Modulo:<xsl:value-of select="nombre"/>
            <br/>
            Ciclo:<xsl:value-of select="ciclo"/>
            <br/>
            </p>
        </xsl:for-each>
        <!--Ordenación ascencente e descendente-->
        <xsl:for-each select="colegio/modulos/modulo">
        <xsl:sort select="horasSemanales" data-type="number"/>
          <xsl:value-of select="nombre"/>:<xsl:value-of select="horasSemanales"/>
        </xsl:for-each>
        <xsl:for-each select="colegio/modulos/modulo">
        <xsl:sort select="horasSemanales" order="descending" data-type="number"/>
          <xsl:value-of select="nombre"/>:<xsl:value-of select="horasSemanales"/><br/>
        </xsl:for-each>
        <!--Condicion if-->
        <xsl:for-each select="colegio/modulos/modulo">
        <xsl:if test="colegio/modulos/modulo[horasSemanales>=4]">
        <!--Aqui vai a instruccion se a condicion se cumple-->
          <xsl:value-of select="nombre"/>:<xsl:value-of select="horasSemanales"/><br/>
        </xsl:for-each>
      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
