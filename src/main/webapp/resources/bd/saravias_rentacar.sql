-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-11-2023 a las 10:01:09
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `saravias_rentacar`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `administradores`
--

CREATE TABLE `administradores` (
  `administrador_id` varchar(6) NOT NULL,
  `usuario_admin` varchar(5) NOT NULL,
  `foto_admin` text NOT NULL,
  `nombres_admin` varchar(255) NOT NULL,
  `apellidos_admin` varchar(255) NOT NULL,
  `telefono_admin` varchar(10) NOT NULL,
  `fecha_creacion_admin` timestamp NOT NULL DEFAULT current_timestamp(),
  `estado_admin` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `administradores`
--

INSERT INTO `administradores` (`administrador_id`, `usuario_admin`, `foto_admin`, `nombres_admin`, `apellidos_admin`, `telefono_admin`, `fecha_creacion_admin`, `estado_admin`) VALUES
('DC312A', 'DC312', '/images/user/311023-DC312A', 'Diego Ernesto', 'Chevez Montes', '6061-5247', '2023-11-01 03:23:08', 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `arquileres`
--

CREATE TABLE `arquileres` (
  `arquiler_id` varchar(10) NOT NULL,
  `vehiculo_id` varchar(10) NOT NULL,
  `titulo_arquiler` varchar(100) NOT NULL,
  `descripcion_arquiler` text NOT NULL,
  `precio_arquiler` decimal(10,2) NOT NULL,
  `fecha_inicio` date NOT NULL,
  `fecha_finalizacion` date NOT NULL,
  `estado_arquiler` varchar(25) NOT NULL,
  `cliente_actual` varchar(6) NOT NULL,
  `gestor_id` varchar(6) NOT NULL,
  `fecha_creacion` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `clientes`
--

CREATE TABLE `clientes` (
  `cliente_id` varchar(6) NOT NULL,
  `usuario_cliente` varchar(5) NOT NULL,
  `foto_cli` text NOT NULL,
  `nombres_cli` varchar(255) NOT NULL,
  `apellidos_cli` varchar(255) NOT NULL,
  `telefono_cli` varchar(10) NOT NULL,
  `direccion_cli` text NOT NULL,
  `dui_cli` varchar(11) NOT NULL,
  `fecha_creacion_cli` timestamp NOT NULL DEFAULT current_timestamp(),
  `estado_cli` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `clientes`
--

INSERT INTO `clientes` (`cliente_id`, `usuario_cliente`, `foto_cli`, `nombres_cli`, `apellidos_cli`, `telefono_cli`, `direccion_cli`, `dui_cli`, `fecha_creacion_cli`, `estado_cli`) VALUES
('AV820C', 'AV820', '/images/user/311023-AV820C', 'Angie Michelle', 'Valencia Ramos', '8975-5874', 'jaksdjkasbdajsbdasdasdawdwdasdasd', '24857496-8', '2023-11-01 03:25:36', 'Activo'),
('EF912C', 'EF912', '/images/user/311023-EF912C', 'Erick Eduardo', 'Fuentes Garcia', '8759-8578', 'kjasdkjasdjkasbdjkasdasdasdasdas', '85749858-9', '2023-11-01 03:25:36', 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `empleados`
--

CREATE TABLE `empleados` (
  `empleado_id` varchar(6) NOT NULL,
  `usuario_empleado` varchar(5) NOT NULL,
  `foto_emp` text NOT NULL,
  `nombres_emp` varchar(255) NOT NULL,
  `apellidos_emp` varchar(255) NOT NULL,
  `telefono_emp` varchar(10) NOT NULL,
  `dui_emp` varchar(11) NOT NULL,
  `direccion_emp` text NOT NULL,
  `fecha_creacion_emp` timestamp NOT NULL DEFAULT current_timestamp(),
  `creador_id` varchar(6) NOT NULL,
  `estado_emp` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `empleados`
--

INSERT INTO `empleados` (`empleado_id`, `usuario_empleado`, `foto_emp`, `nombres_emp`, `apellidos_emp`, `telefono_emp`, `dui_emp`, `direccion_emp`, `fecha_creacion_emp`, `creador_id`, `estado_emp`) VALUES
('CR421E', 'CR421', '/images/user/311023-CR421E', 'Cesar Elias', 'Rodas Gonzales', '8598-2141', '87459698-8', 'sadasdasdasd', '2023-11-01 03:30:38', 'DC312A', 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `img_vehiculos`
--

CREATE TABLE `img_vehiculos` (
  `img_vehiculo_id` varchar(12) NOT NULL,
  `img_vehiculo` text NOT NULL,
  `vehiculo_id` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mensajes`
--

CREATE TABLE `mensajes` (
  `mensaje_id` varchar(12) NOT NULL,
  `mensaje` text NOT NULL,
  `emisor_mensaje` varchar(5) NOT NULL,
  `receptor_mensaje` varchar(5) NOT NULL,
  `fecha_creacion` timestamp NOT NULL DEFAULT current_timestamp(),
  `estado_mensaje` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `propietarios`
--

CREATE TABLE `propietarios` (
  `propietario_id` varchar(6) NOT NULL,
  `usuario_propietario` varchar(5) NOT NULL,
  `foto_prop` text NOT NULL,
  `nombres_prop` varchar(255) NOT NULL,
  `apellidos_prop` varchar(255) NOT NULL,
  `telefono_prop` varchar(10) NOT NULL,
  `dui_prop` varchar(11) NOT NULL,
  `direccion_prop` text NOT NULL,
  `fecha_creacion_prop` timestamp NOT NULL DEFAULT current_timestamp(),
  `gestor_id` varchar(6) NOT NULL,
  `estado_prop` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `propietarios`
--

INSERT INTO `propietarios` (`propietario_id`, `usuario_propietario`, `foto_prop`, `nombres_prop`, `apellidos_prop`, `telefono_prop`, `dui_prop`, `direccion_prop`, `fecha_creacion_prop`, `gestor_id`, `estado_prop`) VALUES
('BC321P', 'BC321', '/images/user/311023-BC321P', 'Bryan Steven', 'Cornejo Zavala', '2154-5421', '25416985-5', 'sdasghasdsadasdasd', '2023-11-01 03:32:36', 'CR421E', 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `roles`
--

CREATE TABLE `roles` (
  `rol_id` varchar(5) NOT NULL,
  `rol` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `roles`
--

INSERT INTO `roles` (`rol_id`, `rol`) VALUES
('1', 'Propietario'),
('2', 'Administrador'),
('3', 'Empleado'),
('4', 'Cliente');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `usuario_id` varchar(5) NOT NULL,
  `username` varchar(100) NOT NULL,
  `correo_user` varchar(255) NOT NULL,
  `contrasena_user` varchar(255) NOT NULL,
  `rol_id` varchar(5) NOT NULL,
  `estado_user` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`usuario_id`, `username`, `correo_user`, `contrasena_user`, `rol_id`, `estado_user`) VALUES
('AV820', 'AngieValencia', 'angievalencia@gmail.com', 'passw0rd123', '4', 'Activo'),
('BC321', 'BryanCornejo', 'bryancornejo@gmail.com', 'passw0rd123', '3', 'Activo'),
('CR421', 'CesarRodas', 'cesarrodas@gmail.com', 'passw0rd123', '2', 'Activo'),
('DC312', 'DiegoChevez', 'diegochevez144@gmail.com', 'passw0rd123', '1', 'Activo'),
('EF912', 'ErickFuentes', 'erickfuentes@gmail.com', 'passw0rd123', '4', 'Activo');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `vehiculos`
--

CREATE TABLE `vehiculos` (
  `vehiculo_id` varchar(10) NOT NULL,
  `marca_vehiculo` varchar(50) NOT NULL,
  `modelo_vehiculo` varchar(50) NOT NULL,
  `año_vehiculo` int(4) NOT NULL,
  `tipo_vehiculo` varchar(100) NOT NULL,
  `color_vehiculo` varchar(20) NOT NULL,
  `estado_vehiculo` varchar(25) NOT NULL,
  `placa_vehiculo` varchar(20) NOT NULL,
  `propietario_vehiculo` varchar(6) NOT NULL,
  `motor_vehiculo` varchar(50) NOT NULL,
  `consumo_vehiculo` varchar(50) NOT NULL,
  `fecha_creacion` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ventas`
--

CREATE TABLE `ventas` (
  `venta_id` varchar(10) NOT NULL,
  `vehiculo_id` varchar(10) NOT NULL,
  `titulo_venta` varchar(100) NOT NULL,
  `descripcion_venta` varchar(100) NOT NULL,
  `precio_venta` varchar(255) NOT NULL,
  `comprador_venta` varchar(6) NOT NULL,
  `fecha_compra_venta` date NOT NULL,
  `estado_venta` varchar(25) NOT NULL,
  `gestor_id` varchar(6) NOT NULL,
  `fecha_creacion_venta` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `administradores`
--
ALTER TABLE `administradores`
  ADD PRIMARY KEY (`administrador_id`),
  ADD KEY `usuario_admin` (`usuario_admin`);

--
-- Indices de la tabla `arquileres`
--
ALTER TABLE `arquileres`
  ADD PRIMARY KEY (`arquiler_id`),
  ADD KEY `vehiculo_id` (`vehiculo_id`),
  ADD KEY `gestor_id` (`gestor_id`),
  ADD KEY `cliente_actual` (`cliente_actual`);

--
-- Indices de la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD PRIMARY KEY (`cliente_id`),
  ADD UNIQUE KEY `dui_cli` (`dui_cli`),
  ADD KEY `usuario_cliente` (`usuario_cliente`);

--
-- Indices de la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD PRIMARY KEY (`empleado_id`),
  ADD UNIQUE KEY `dui_emp` (`dui_emp`),
  ADD KEY `creador_id` (`creador_id`),
  ADD KEY `usuario_empleado` (`usuario_empleado`);

--
-- Indices de la tabla `img_vehiculos`
--
ALTER TABLE `img_vehiculos`
  ADD PRIMARY KEY (`img_vehiculo_id`),
  ADD UNIQUE KEY `vehiculo_id` (`vehiculo_id`);

--
-- Indices de la tabla `mensajes`
--
ALTER TABLE `mensajes`
  ADD PRIMARY KEY (`mensaje_id`),
  ADD KEY `receptor_mensaje` (`receptor_mensaje`),
  ADD KEY `emisor_mensaje` (`emisor_mensaje`);

--
-- Indices de la tabla `propietarios`
--
ALTER TABLE `propietarios`
  ADD PRIMARY KEY (`propietario_id`),
  ADD UNIQUE KEY `dui_prop` (`dui_prop`),
  ADD KEY `gestor_id` (`gestor_id`),
  ADD KEY `usuario_propietario` (`usuario_propietario`);

--
-- Indices de la tabla `roles`
--
ALTER TABLE `roles`
  ADD PRIMARY KEY (`rol_id`);

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`usuario_id`),
  ADD UNIQUE KEY `correo_user` (`correo_user`),
  ADD KEY `roles_usuarios` (`rol_id`);

--
-- Indices de la tabla `vehiculos`
--
ALTER TABLE `vehiculos`
  ADD PRIMARY KEY (`vehiculo_id`),
  ADD KEY `propietario_vehiculo` (`propietario_vehiculo`);

--
-- Indices de la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD PRIMARY KEY (`venta_id`),
  ADD KEY `vehiculo_id` (`vehiculo_id`),
  ADD KEY `gestor_id` (`gestor_id`),
  ADD KEY `comprador_venta` (`comprador_venta`);

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `administradores`
--
ALTER TABLE `administradores`
  ADD CONSTRAINT `usuarios_administradores` FOREIGN KEY (`usuario_admin`) REFERENCES `usuarios` (`usuario_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `arquileres`
--
ALTER TABLE `arquileres`
  ADD CONSTRAINT `clientes_arquileres` FOREIGN KEY (`cliente_actual`) REFERENCES `clientes` (`cliente_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `empleados_arquileres` FOREIGN KEY (`gestor_id`) REFERENCES `empleados` (`empleado_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `vehiculos_arquileres` FOREIGN KEY (`vehiculo_id`) REFERENCES `vehiculos` (`vehiculo_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `clientes`
--
ALTER TABLE `clientes`
  ADD CONSTRAINT `usuarios_clientes` FOREIGN KEY (`usuario_cliente`) REFERENCES `usuarios` (`usuario_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `empleados`
--
ALTER TABLE `empleados`
  ADD CONSTRAINT `administradores_empleados` FOREIGN KEY (`creador_id`) REFERENCES `administradores` (`administrador_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `usuarios_empleados` FOREIGN KEY (`usuario_empleado`) REFERENCES `usuarios` (`usuario_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `img_vehiculos`
--
ALTER TABLE `img_vehiculos`
  ADD CONSTRAINT `vehiculos_img-vehiculos` FOREIGN KEY (`vehiculo_id`) REFERENCES `vehiculos` (`vehiculo_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `mensajes`
--
ALTER TABLE `mensajes`
  ADD CONSTRAINT `usuarios_emisor_mensajes` FOREIGN KEY (`emisor_mensaje`) REFERENCES `usuarios` (`usuario_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `usuarios_receptor_mensajes` FOREIGN KEY (`receptor_mensaje`) REFERENCES `usuarios` (`usuario_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `propietarios`
--
ALTER TABLE `propietarios`
  ADD CONSTRAINT `empleados_propietarios` FOREIGN KEY (`gestor_id`) REFERENCES `empleados` (`empleado_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `usuarios_propietarios` FOREIGN KEY (`usuario_propietario`) REFERENCES `usuarios` (`usuario_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD CONSTRAINT `roles_usuarios` FOREIGN KEY (`rol_id`) REFERENCES `roles` (`rol_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `vehiculos`
--
ALTER TABLE `vehiculos`
  ADD CONSTRAINT `propietarios_vehiculos` FOREIGN KEY (`propietario_vehiculo`) REFERENCES `propietarios` (`propietario_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `ventas`
--
ALTER TABLE `ventas`
  ADD CONSTRAINT `clientes_ventas` FOREIGN KEY (`comprador_venta`) REFERENCES `clientes` (`cliente_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `empleados_vehiculos` FOREIGN KEY (`gestor_id`) REFERENCES `empleados` (`empleado_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `vehiculos_ventas` FOREIGN KEY (`vehiculo_id`) REFERENCES `vehiculos` (`vehiculo_id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
