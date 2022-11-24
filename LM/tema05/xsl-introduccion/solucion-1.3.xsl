<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
	<xsl:template match="ciclo">
		<html>
			<ul>
				<xsl:apply-templates/>
			</ul>
		</html>
	</xsl:template>

	<xsl:template match="ciclo">
		<li>
			<xsl:value-of select="nombre"/>
		</li>
	</xsl:template>
</xsl:stylesheet>