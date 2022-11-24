/*
 Crear un trigger en la tabla jugadores que no permita introducir ningún jugador que mida más de 250cm.
 Reutiliza la función de conversión del ejemplo anterior.
 */
CREATE TRIGGER nba.checkAltura
	BEFORE INSERT
	ON jugadores
	FOR EACH ROW
	IF alturaCm(NEW.Altura) > 250 THEN
		SIGNAL SQLSTATE '45000' SET MESSAGE_TEXT = 'Un jugador no puede medir más de 250cm';
	END IF;