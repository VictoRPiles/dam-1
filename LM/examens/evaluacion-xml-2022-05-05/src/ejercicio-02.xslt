<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:template match="paises">
		<html>
			<h1>Paises de Europa</h1>
			<ul>
				<xsl:apply-templates/>
			</ul>
		</html>
	</xsl:template>

	<xsl:template match="//paises/pais">
		<li>
			<xsl:value-of select="nombre"/> es una <xsl:value-of select="@tipo"/> con capital en <xsl:value-of select="capital"/>
		</li>
	</xsl:template>
</xsl:stylesheet>