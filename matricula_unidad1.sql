-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Versión del servidor:         10.4.24-MariaDB - mariadb.org binary distribution
-- SO del servidor:              Win64
-- HeidiSQL Versión:             12.1.0.6537
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Volcando estructura de base de datos para matricula
CREATE DATABASE IF NOT EXISTS `matricula` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `matricula`;

-- Volcando estructura para tabla matricula.beca
CREATE TABLE IF NOT EXISTS `beca` (
  `IdBeca` int(11) NOT NULL,
  `Descripcion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`IdBeca`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla matricula.beca: ~4 rows (aproximadamente)
INSERT INTO `beca` (`IdBeca`, `Descripcion`) VALUES
	(1, 'Ninguna'),
	(2, 'Hermanos'),
	(3, 'Merito'),
	(4, 'Orfandad');

-- Volcando estructura para tabla matricula.curso
CREATE TABLE IF NOT EXISTS `curso` (
  `IdCurso` int(11) NOT NULL,
  `Descripcion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`IdCurso`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla matricula.curso: ~6 rows (aproximadamente)
INSERT INTO `curso` (`IdCurso`, `Descripcion`) VALUES
	(1, 'Base de datos II'),
	(2, 'Programacion III'),
	(3, 'Gestion de Proyectos de TI'),
	(4, 'Problemas y Desafios'),
	(5, 'Calidad y Pruebas de Software'),
	(6, 'Sistemas Operativos II');

-- Volcando estructura para tabla matricula.detalle
CREATE TABLE IF NOT EXISTS `detalle` (
  `IdDetalle` int(11) NOT NULL AUTO_INCREMENT,
  `fkIdMatricula` int(11) DEFAULT NULL,
  `fkIdCurso` int(11) DEFAULT NULL,
  `SubTotal` decimal(20,6) DEFAULT NULL,
  PRIMARY KEY (`IdDetalle`),
  KEY `FK_detalle_curso` (`fkIdCurso`),
  KEY `FK_detalle_matricula` (`fkIdMatricula`),
  CONSTRAINT `FK_detalle_curso` FOREIGN KEY (`fkIdCurso`) REFERENCES `curso` (`IdCurso`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_detalle_matricula` FOREIGN KEY (`fkIdMatricula`) REFERENCES `matricula` (`IdMatricula`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla matricula.detalle: ~1 rows (aproximadamente)
INSERT INTO `detalle` (`IdDetalle`, `fkIdMatricula`, `fkIdCurso`, `SubTotal`) VALUES
	(3, 5, 1, 300.000000);

-- Volcando estructura para tabla matricula.estado
CREATE TABLE IF NOT EXISTS `estado` (
  `IdEstado` int(11) NOT NULL,
  `Descripcion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`IdEstado`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla matricula.estado: ~4 rows (aproximadamente)
INSERT INTO `estado` (`IdEstado`, `Descripcion`) VALUES
	(1, 'Pendiente'),
	(2, 'Cancelada'),
	(3, 'Aprobada'),
	(4, 'Espera de Pago');

-- Volcando estructura para tabla matricula.matricula
CREATE TABLE IF NOT EXISTS `matricula` (
  `IdMatricula` int(11) NOT NULL AUTO_INCREMENT,
  `fkIdUsuario` int(11) DEFAULT NULL,
  `fkIdSemestre` int(11) DEFAULT NULL,
  `fkIdProntoPago` int(11) DEFAULT NULL,
  `fkIdBeca` int(11) DEFAULT NULL,
  `Fecha` date DEFAULT NULL,
  `fkIdEstado` int(11) DEFAULT NULL,
  `Vencimiento` date DEFAULT NULL,
  `Total` decimal(20,6) DEFAULT NULL,
  PRIMARY KEY (`IdMatricula`),
  KEY `FK_matricula_usuario` (`fkIdUsuario`),
  KEY `FK_matricula_semestre` (`fkIdSemestre`),
  KEY `FK_matricula_beca` (`fkIdBeca`),
  KEY `FK_matricula_estado` (`fkIdEstado`),
  KEY `FK_matricula_prontopago` (`fkIdProntoPago`) USING BTREE,
  CONSTRAINT `FK_matricula_beca` FOREIGN KEY (`fkIdBeca`) REFERENCES `beca` (`IdBeca`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_matricula_estado` FOREIGN KEY (`fkIdEstado`) REFERENCES `estado` (`IdEstado`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_matricula_prontopago` FOREIGN KEY (`fkIdProntoPago`) REFERENCES `prontopago` (`IdProntoPago`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_matricula_semestre` FOREIGN KEY (`fkIdSemestre`) REFERENCES `semestre` (`IdSemestre`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `FK_matricula_usuario` FOREIGN KEY (`fkIdUsuario`) REFERENCES `usuario` (`IdUsuario`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla matricula.matricula: ~2 rows (aproximadamente)
INSERT INTO `matricula` (`IdMatricula`, `fkIdUsuario`, `fkIdSemestre`, `fkIdProntoPago`, `fkIdBeca`, `Fecha`, `fkIdEstado`, `Vencimiento`, `Total`) VALUES
	(1, 2020066918, 3, 2, 1, '2023-06-05', 2, '2023-06-05', 678.600000),
	(5, 2020066917, 3, 1, 1, '2022-03-11', 1, '2022-03-13', 424.000000);

-- Volcando estructura para tabla matricula.prontopago
CREATE TABLE IF NOT EXISTS `prontopago` (
  `IdProntoPago` int(11) NOT NULL,
  `Estado` char(1) DEFAULT NULL,
  PRIMARY KEY (`IdProntoPago`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla matricula.prontopago: ~2 rows (aproximadamente)
INSERT INTO `prontopago` (`IdProntoPago`, `Estado`) VALUES
	(1, 'A'),
	(2, 'I');

-- Volcando estructura para tabla matricula.semestre
CREATE TABLE IF NOT EXISTS `semestre` (
  `IdSemestre` int(11) NOT NULL,
  `Nombre` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`IdSemestre`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla matricula.semestre: ~4 rows (aproximadamente)
INSERT INTO `semestre` (`IdSemestre`, `Nombre`) VALUES
	(1, '2022-I'),
	(2, '2022-II'),
	(3, '2023-I'),
	(4, '2023-II');

-- Volcando estructura para tabla matricula.usuario
CREATE TABLE IF NOT EXISTS `usuario` (
  `IdUsuario` int(11) NOT NULL,
  `Descripcion` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`IdUsuario`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Volcando datos para la tabla matricula.usuario: ~3 rows (aproximadamente)
INSERT INTO `usuario` (`IdUsuario`, `Descripcion`) VALUES
	(2020066917, 'Marcelo Gomez'),
	(2020066918, 'Fabricio Gutierrez'),
	(2020066919, 'Moises Perez');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
