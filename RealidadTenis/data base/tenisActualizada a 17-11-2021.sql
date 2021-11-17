-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 17-11-2021 a las 22:37:24
-- Versión del servidor: 10.4.21-MariaDB
-- Versión de PHP: 8.0.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tenis`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cancha`
--

CREATE TABLE `cancha` (
  `id_cancha` int(11) NOT NULL,
  `ciudad` varchar(25) NOT NULL,
  `direccion` varchar(100) NOT NULL,
  `ancho` float NOT NULL,
  `largo` float NOT NULL,
  `categoria` varchar(25) NOT NULL,
  `capacidad` int(11) NOT NULL,
  `numero_cancha` int(11) NOT NULL,
  `enUso` tinyint(1) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `cancha`
--

INSERT INTO `cancha` (`id_cancha`, `ciudad`, `direccion`, `ancho`, `largo`, `categoria`, `capacidad`, `numero_cancha`, `enUso`) VALUES
(1, 'San Luis', 'Rivadavia 1266', 6, 5, 'Cesped', 25000, 1, 1),
(2, 'Mercedes', 'Rivadavia 1266', 7, 5, 'Cesped', 25000, 0, 0),
(3, 'asd', 'asd', 7, 8, 'asd', 25, 0, 1),
(4, 'asd', 'asd', 7, 9, 'asd', 88, 0, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contrato`
--

CREATE TABLE `contrato` (
  `id_contrato` int(11) NOT NULL,
  `id_jugador` int(11) NOT NULL,
  `id_patrocinador` int(11) NOT NULL,
  `articulo` varchar(30) NOT NULL,
  `inicio_contrato` date NOT NULL,
  `fin_contrato` date NOT NULL,
  `activo` tinyint(2) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `contrato`
--

INSERT INTO `contrato` (`id_contrato`, `id_jugador`, `id_patrocinador`, `articulo`, `inicio_contrato`, `fin_contrato`, `activo`) VALUES
(1, 1, 1, 'Raqueta', '2021-11-04', '2021-11-06', 1),
(2, 1, 3, 'Remera', '2021-11-04', '2021-11-05', 1),
(3, 1, 3, 'Zapatillas', '2021-11-05', '2021-11-19', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `encuentro`
--

CREATE TABLE `encuentro` (
  `id_encuentro` int(11) NOT NULL,
  `id_torneo` int(11) NOT NULL,
  `id_jugador1` int(11) NOT NULL,
  `id_jugador2` int(11) NOT NULL,
  `id_ganador` int(11) DEFAULT NULL,
  `id_cancha` int(11) NOT NULL,
  `fecha` date NOT NULL,
  `estado` varchar(15) NOT NULL,
  `activo` tinyint(2) NOT NULL DEFAULT 1,
  `resultado_j1` int(11) DEFAULT NULL,
  `resultado_j2` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `encuentro`
--

INSERT INTO `encuentro` (`id_encuentro`, `id_torneo`, `id_jugador1`, `id_jugador2`, `id_ganador`, `id_cancha`, `fecha`, `estado`, `activo`, `resultado_j1`, `resultado_j2`) VALUES
(1, 7, 2, 1, NULL, 1, '2021-11-27', 'Jugado', 1, NULL, NULL),
(2, 6, 1, 2, 2, 1, '2021-11-17', 'En Curso', 1, 3, 6),
(3, 2, 1, 2, 1, 1, '2021-11-30', 'Jugado', 1, 6, 6),
(4, 1, 1, 1, 1, 1, '2021-11-10', 'Jugado', 1, 6, 5),
(5, 7, 2, 1, NULL, 1, '2021-11-06', 'Jugado', 1, NULL, NULL),
(6, 6, 2, 1, 1, 1, '2021-11-12', 'Jugado', 1, 1, 5),
(7, 6, 2, 1, NULL, 1, '2021-11-06', 'Jugado', 1, NULL, NULL);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `jugador`
--

CREATE TABLE `jugador` (
  `id_jugador` int(11) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `apellido` varchar(25) NOT NULL,
  `dni` int(11) NOT NULL,
  `fecha_nacimiento` date NOT NULL,
  `altura` double NOT NULL,
  `peso` decimal(11,0) NOT NULL,
  `estilo` varchar(25) NOT NULL,
  `diestro` tinyint(2) NOT NULL DEFAULT 1,
  `activo` tinyint(2) NOT NULL DEFAULT 1
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `jugador`
--

INSERT INTO `jugador` (`id_jugador`, `nombre`, `apellido`, `dni`, `fecha_nacimiento`, `altura`, `peso`, `estilo`, `diestro`, `activo`) VALUES
(1, 'adriel', 'gomez', 33888429, '1989-06-02', 1.9, '92', 'Ataque', 1, 1),
(2, 'Jorge', 'Gonzalez', 26549852, '2021-11-02', 1.75, '26', 'Defensa', 1, 1),
(5, 'asd', 'asd', 125215, '1989-06-17', 1.85, '95', 'Agresivo', 1, 0),
(8, 'asd', 'asd', 12521, '2021-11-12', 1.95, '52', 'Agresivo', 0, 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `patrocinador`
--

CREATE TABLE `patrocinador` (
  `id_patrocinador` int(11) NOT NULL,
  `marca` varchar(25) NOT NULL,
  `activo` tinyint(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `patrocinador`
--

INSERT INTO `patrocinador` (`id_patrocinador`, `marca`, `activo`) VALUES
(1, 'Nike', 1),
(2, 'Adidas', 0),
(3, 'Reef', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `torneo`
--

CREATE TABLE `torneo` (
  `id_torneo` int(11) NOT NULL,
  `nombre_copa` varchar(100) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_fin` date NOT NULL,
  `activo` tinyint(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Volcado de datos para la tabla `torneo`
--

INSERT INTO `torneo` (`id_torneo`, `nombre_copa`, `fecha_inicio`, `fecha_fin`, `activo`) VALUES
(1, 'Torneo 1', '2021-11-02', '2021-11-02', 0),
(2, 'asdqw', '2021-11-01', '2021-11-03', 1),
(3, 'asd', '2021-11-03', '2021-11-03', 0),
(4, 'asd', '2021-11-03', '2021-11-03', 0),
(5, 'asd', '2021-11-05', '2021-11-05', 0),
(6, 'asd4', '2021-11-03', '2021-11-03', 1),
(7, '123', '2021-11-17', '2021-11-17', 1),
(8, '540', '2021-11-17', '2021-11-17', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cancha`
--
ALTER TABLE `cancha`
  ADD PRIMARY KEY (`id_cancha`);

--
-- Indices de la tabla `contrato`
--
ALTER TABLE `contrato`
  ADD PRIMARY KEY (`id_contrato`),
  ADD KEY `id_jugador` (`id_jugador`),
  ADD KEY `id_patrocinador` (`id_patrocinador`);

--
-- Indices de la tabla `encuentro`
--
ALTER TABLE `encuentro`
  ADD PRIMARY KEY (`id_encuentro`),
  ADD KEY `id_ganador` (`id_ganador`),
  ADD KEY `id_jugador1` (`id_jugador1`),
  ADD KEY `id_jugador2` (`id_jugador2`),
  ADD KEY `id_torneo` (`id_torneo`),
  ADD KEY `id_cancha` (`id_cancha`);

--
-- Indices de la tabla `jugador`
--
ALTER TABLE `jugador`
  ADD PRIMARY KEY (`id_jugador`),
  ADD UNIQUE KEY `dni` (`dni`);

--
-- Indices de la tabla `patrocinador`
--
ALTER TABLE `patrocinador`
  ADD PRIMARY KEY (`id_patrocinador`),
  ADD UNIQUE KEY `marca` (`marca`);

--
-- Indices de la tabla `torneo`
--
ALTER TABLE `torneo`
  ADD PRIMARY KEY (`id_torneo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cancha`
--
ALTER TABLE `cancha`
  MODIFY `id_cancha` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de la tabla `contrato`
--
ALTER TABLE `contrato`
  MODIFY `id_contrato` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `encuentro`
--
ALTER TABLE `encuentro`
  MODIFY `id_encuentro` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `jugador`
--
ALTER TABLE `jugador`
  MODIFY `id_jugador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `patrocinador`
--
ALTER TABLE `patrocinador`
  MODIFY `id_patrocinador` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT de la tabla `torneo`
--
ALTER TABLE `torneo`
  MODIFY `id_torneo` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `contrato`
--
ALTER TABLE `contrato`
  ADD CONSTRAINT `id_jugador` FOREIGN KEY (`id_jugador`) REFERENCES `jugador` (`id_jugador`),
  ADD CONSTRAINT `id_patrocinador` FOREIGN KEY (`id_patrocinador`) REFERENCES `patrocinador` (`id_patrocinador`);

--
-- Filtros para la tabla `encuentro`
--
ALTER TABLE `encuentro`
  ADD CONSTRAINT `id_cancha` FOREIGN KEY (`id_cancha`) REFERENCES `cancha` (`id_cancha`),
  ADD CONSTRAINT `id_ganador` FOREIGN KEY (`id_ganador`) REFERENCES `jugador` (`id_jugador`),
  ADD CONSTRAINT `id_jugador1` FOREIGN KEY (`id_jugador1`) REFERENCES `jugador` (`id_jugador`),
  ADD CONSTRAINT `id_jugador2` FOREIGN KEY (`id_jugador2`) REFERENCES `jugador` (`id_jugador`),
  ADD CONSTRAINT `id_torneo` FOREIGN KEY (`id_torneo`) REFERENCES `torneo` (`id_torneo`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
