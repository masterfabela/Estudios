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
          </xsl:if>
        </xsl:for-each>
        <!--Condición multiple-->
        <ul> <lh>Lista de Módulos</lh>
        <xsl:for-each select="colegio/modulos/modulo">
        <li>
          <xsl:choose>
            <xsl:when test="horasSemanales>=4">
              <xsl:value-of select="nombre"/>  Horas:
              <xsl:value-of select="horasSemanales"/>
            </xsl:when>
            <xsl:otherwise>
              <xsl:value-of select="horasSemanales"/>
            </xsl:otherwise>
          </xsl:choose>
        </li>
        </xsl:for-each>
        </ul>

        <xsl:for-each select="colegio/modulos/modulo[curso=2]">
            <ul>
            <lh>Lista ciclos:</lh>
            </ul><li>
            Nombre Modulo:<xsl:value-of select="nombre"/>
            <br/>
              <ul style="list-style-type:square"><lh>Ciclo:</lh>
              <li>
              <xsl:value-of select="ciclo"/>
              </li>
              </ul>
            </li>
        </xsl:for-each>

        <table>
        <caption>Taboa de modulos</caption>
        <th>Nombre</th><th>curso</th><th>H.Sem</th>
        <xsl:for-each select="colegio/modulos/modulo">
        <tr><td><xsl:value-of select="nombre"/></td>
            <td><xsl:value-of select="curso"/></td>
            <td><xsl:value-of select="horasSemanales"/></td></tr>
        </xsl:for-each>
            </table>

      </body>
    </html>
  </xsl:template>
</xsl:stylesheet>
