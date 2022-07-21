-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-06-2022 a las 22:19:30
-- Versión del servidor: 10.4.22-MariaDB
-- Versión de PHP: 8.1.2

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `app_web_fullstack`
--
CREATE DATABASE IF NOT EXISTS `quileia` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `quileia`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `appointment`
--

CREATE TABLE `citas` (
  `idCita` int(11) NOT NULL,
  `medico` varchar(45) NOT NULL,
  `paciente` varchar(45) NOT NULL,
  `FECHA` varchar(20) NOT NULL,
  `hora` decimal(4,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `doctor`
--

CREATE TABLE `medico` (
  `idMedico` varchar(15) NOT NULL,
  `horaFinAtencion` decimal(10,0) DEFAULT NULL,
  `horaInicioAtencion` decimal(10,0) DEFAULT NULL,
  `nombreMedico` varchar(30) DEFAULT NULL,
  `tipoIdentificacion` varchar(5) DEFAULT NULL,
  `NTarjetaProfesional` varchar(10) DEFAULT NULL,
  `especialidad` varchar(20) DEFAULT NULL,
  `aniosExperiencia` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `patient`
--

CREATE TABLE `paciente` (
  `idPaciente` varchar(20) NOT NULL,
  `historiaClinica` varchar(255) DEFAULT NULL,
  `fechaNacimiento` varchar(10) DEFAULT NULL,
  `EPS` varchar(30) DEFAULT NULL,
  `tipoIdentificacion` varchar(5) DEFAULT NULL,
  `nombre` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;


--
-- Indices de la tabla `appointment`
--
ALTER TABLE `citas`
  ADD PRIMARY KEY (`idCita`),
  ADD KEY `medico` (`medico`),
  ADD KEY `paciente` (`paciente`);

--
-- Indices de la tabla `doctor`
--
ALTER TABLE `medico`
  ADD PRIMARY KEY (`idMedico`);

--
-- Indices de la tabla `patient`
--
ALTER TABLE `paciente`
  ADD PRIMARY KEY (`idPaciente`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `appointment`
--
ALTER TABLE `citas`
  MODIFY `idCita` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `appointment`
--
ALTER TABLE `citas`
  ADD CONSTRAINT `citas_ibfk_1` FOREIGN KEY (`medico`) REFERENCES `doctor` (`idMedico`),
  ADD CONSTRAINT `citas_ibfk_2` FOREIGN KEY (`paciente`) REFERENCES `patient` (`idPaciente`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
