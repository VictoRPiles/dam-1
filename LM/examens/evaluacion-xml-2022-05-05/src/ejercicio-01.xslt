<?xml version="1.0" encoding="UTF-8" ?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:template match="partidos">
		<html>
			<h1>Partidos y siglas</h1>
			<xsl:apply-templates/>
		</html>
	</xsl:template>

	<xsl:template match="partido">
		<p><strong>"<xsl:value-of select="@nombre"/>"</strong>son las siglas de<strong><xsl:value-of select="text()"/></strong>.</p>
	</xsl:template>
</xsl:stylesheet>