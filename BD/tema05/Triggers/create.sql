USE nba;

CREATE TABLE numeropartidos
(
	CodigoNumeroPartido INT NOT NULL,
	PRIMARY KEY (CodigoNumeroPartido)
);

-- ====================
-- Por cada partido que se inserta, se incrementa CodigoNumeroPartido
-- ==================== 
DELIMITER $$
CREATE TRIGGER SumadorDePartidos
	AFTER INSERT
	ON nba.partidos
	FOR EACH ROW
BEGIN
	UPDATE nba.numeropartidos
	SET CodigoNumeroPartido = CodigoNumeroPartido + 1;
END$$

-- ====================
-- TABLA COPIA DE EQUIPOS (ara esta modificada)
-- ====================
CREATE TABLE equiposBK
(
	Nombre       VARCHAR(20) NOT NULL ,
	Ciudad1      VARCHAR(20) NULL,
	Conferencia1 VARCHAR(4)  NULL,
	Division1    VARCHAR(9)  NULL,
	Ciudad2      VARCHAR(20) NULL,
	Conferencia2 VARCHAR(4)  NULL,
	Division2    VARCHAR(9)  NULL
);

-- ====================
-- QUANT SE FA UN UPDATE EN nba.equipos, SE COPIEN ELS DATOS QUE HAVIEN ANTES DEL UPDATE A nba.equiposBK
-- ====================
DELIMITER $$
CREATE TRIGGER nba.backup
	AFTER UPDATE
	ON nba.equipos
	FOR EACH ROW
BEGIN
	INSERT INTO nba.equiposBK(Nombre, Ciudad1, Conferencia1, Division1, Ciudad2, Conferencia2, Division2)
	VALUES (NEW.Nombre, OLD.Ciudad, OLD.Conferencia, OLD.Division, NEW.Ciudad, NEW.Conferencia, NEW.Division);
END $$