/*
 @author Victor Piles
 @date 11-05-2022
 */

/*
 Desarrolla un Trigger llamado TrigPais  para que no se permita modificar la columna BillingCountry de la tabla invoice.
 En el caso que se pretenda modificar esa columna debe saltar un excepción indicando "Modificación del país no permitida"
 y no se modificará el registro (tampoco el resto de columnas). El resto de columnas se pueden modificar con normalidad
 siempre y cuando no se pretenda modificar BillingCountry al mismo tiempo. (3 puntos)
 */
CREATE TRIGGER TrigPais
	BEFORE UPDATE
	ON invoice
	FOR EACH ROW
	IF NOT (OLD.BillingCountry = NEW.BillingCountry) THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Modificación del país no permitida';
	END IF;

/*
 Desarrolla una función llamado Facturacion que dado el código de un cliente (CustomerID) devuelva la suma Total
 facturada a dicho cliente de la tabla invoice . (2 puntos)
 */
CREATE FUNCTION Facturacion(p_CustomerID INT) RETURNS FLOAT
	DETERMINISTIC
BEGIN
	RETURN (SELECT SUM(Total)
			FROM invoice
			WHERE CustomerId = p_CustomerID);
END;

/*
 Desarrolla un procedimiento llamado FillTracks que cree la columna NumTracks en la tabla artist y la cumplimente con el
 número de Tracks total de toda la discografía del artista que hay en la tabla Track. Deberás utilizar cursores. (5 puntos)
 */
CREATE PROCEDURE FillTracks()
BEGIN
	DECLARE terminar BOOLEAN;
	DECLARE thisNumTracks INT;
	DECLARE thisArtist INT;

	/* Extraer los datos */
	DECLARE v_NumTracks CURSOR FOR SELECT COUNT(*), album.ArtistId
								   FROM track,
										album,
										artist
								   WHERE album.AlbumId = track.AlbumId
									 AND album.ArtistId = artist.ArtistId
								   GROUP BY artist.ArtistId;

	DECLARE EXIT HANDLER FOR NOT FOUND SET terminar = TRUE;

	/*
	 Handler para el error ER_DUP_FIELDNAME (42S21), al crear una columna ya existente.
	 El SIGNAL SQLSTATE '01060' no es un mensaje de error, es un WARNING.
	 */
	DECLARE CONTINUE HANDLER FOR SQLSTATE '42S21' BEGIN
		SIGNAL SQLSTATE '01060' SET MESSAGE_TEXT = 'La columna NumTracks ya existe, no se crea de nuevo.', MYSQL_ERRNO = 1060;
		SHOW WARNINGS;
	END;

	/* Da un error si ya existe la columna */
	ALTER TABLE artist
		ADD NumTracks INT;

	OPEN v_NumTracks;

	/* Por cada artista */
	bucle:
	LOOP
		FETCH v_NumTracks INTO thisNumTracks, thisArtist;

		IF terminar THEN
			LEAVE bucle;
		END IF;

		UPDATE artist SET NumTracks = thisNumTracks WHERE ArtistId = thisArtist;
	END LOOP;
END;