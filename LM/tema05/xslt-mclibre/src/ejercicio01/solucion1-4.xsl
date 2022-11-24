<?xml version="1.0" encoding="UTF-8" ?>
<!-- Tabla -->
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">
	<xsl:template match="ciclos">
		<html>
			<table>
				<xsl:apply-templates/>
			</table>
		</html>
	</xsl:template>

	<xsl:template match="ciclo">
		<tr>
			<td>
				<xsl:value-of select="nombre"/>
			</td>
		</tr>
	</xsl:template>
</xsl:stylesheet>