-- phpMyAdmin SQL Dump
-- version 5.0.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 13, 2020 at 01:16 PM
-- Server version: 10.4.14-MariaDB
-- PHP Version: 7.4.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `moviesdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `hibernate_sequence`
--

CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `hibernate_sequence`
--

INSERT INTO `hibernate_sequence` (`next_val`) VALUES
(22);

-- --------------------------------------------------------

--
-- Table structure for table `movie`
--

CREATE TABLE `movie` (
  `id` int(11) NOT NULL,
  `availability` bit(1) DEFAULT NULL,
  `description` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `img` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `rental_price` double DEFAULT NULL,
  `sell_price` double DEFAULT NULL,
  `stock` int(11) DEFAULT NULL,
  `title` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `movie`
--

INSERT INTO `movie` (`id`, `availability`, `description`, `img`, `rental_price`, `sell_price`, `stock`, `title`) VALUES
(1, b'0', 'el hombre mas fuerte de el mundo y todo ', 'https://pulpfictioncine.com/download/multimedia.normal.a9532072a731ff17.48756c6b204e616d6f725f6e6f726d616c2e6a7067.jpg', 40.1, 42, 40, 'hulk'),
(6, b'0', 'marvel movie', 'https://i.blogs.es/876f04/los-vengadores-4/450_1000.jpg', 22.2, 34.3, 20, 'los vengadores'),
(8, b'1', 'El perro fiel HACHI', 'https://lamenteesmaravillosa.com/wp-content/uploads/2014/02/Hachiko.jpg', 40.1, 42, 40, 'Siempe a tu lado'),
(10, b'0', NULL, NULL, 0, 0, NULL, NULL),
(11, b'1', 'El perro fiel HACHI', 'https://lamenteesmaravillosa.com/wp-content/uploads/2014/02/Hachiko.jpg', 40.1, 42, 40, 'Siempe a tu lado'),
(12, b'1', 'El perro fiel HACHI', 'https://lamenteesmaravillosa.com/wp-content/uploads/2014/02/Hachiko.jpg', 40.1, 42, 40, 'Siempe a tu lado'),
(13, b'1', 'El perro fiel HACHI', 'https://lamenteesmaravillosa.com/wp-content/uploads/2014/02/Hachiko.jpg', 40.1, 42, 40, 'Siempe a tu lado'),
(14, b'1', 'El perro fiel HACHI', 'https://lamenteesmaravillosa.com/wp-content/uploads/2014/02/Hachiko.jpg', 40.1, 42, 40, 'Siempe a tu lado'),
(15, b'1', 'El perro fiel HACHI', 'https://lamenteesmaravillosa.com/wp-content/uploads/2014/02/Hachiko.jpg', 40.1, 42, 40, 'Siempe a tu lado'),
(16, b'1', 'El perro fiel HACHI', 'https://lamenteesmaravillosa.com/wp-content/uploads/2014/02/Hachiko.jpg', 40.1, 42, 40, 'Siempe a tu lado'),
(17, b'1', 'El perro fiel HACHI', 'https://lamenteesmaravillosa.com/wp-content/uploads/2014/02/Hachiko.jpg', 40.1, 42, 40, 'Siempe a tu lado'),
(18, b'1', 'El perro fiel HACHI', 'https://lamenteesmaravillosa.com/wp-content/uploads/2014/02/Hachiko.jpg', 40.1, 42, 40, 'Siempe a tu lado'),
(19, b'1', 'El perro fiel HACHI', 'https://lamenteesmaravillosa.com/wp-content/uploads/2014/02/Hachiko.jpg', 40.1, 42, 40, 'Siempe a tu lado'),
(20, b'1', 'el hombre rayo', 'https://www.cinemascomics.com/wp-content/uploads/2020/06/the-flash-septima-temporada-godspeed-960x560.jpg', 40.1, 42, 40, 'flash'),
(21, b'1', 'el hombre rayo', 'https://www.cinemascomics.com/wp-content/uploads/2020/06/the-flash-septima-temporada-godspeed-960x560.jpg', 40.1, 42, 40, 'flash');

-- --------------------------------------------------------

--
-- Table structure for table `users`
--

CREATE TABLE `users` (
  `id` bigint(20) NOT NULL,
  `password` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `rol` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL,
  `username` varchar(255) COLLATE utf8_spanish_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_spanish_ci;

--
-- Dumping data for table `users`
--

INSERT INTO `users` (`id`, `password`, `rol`, `username`) VALUES
(1, 'user', 'ROLE_USER', 'ruddy'),
(2, 'prueba', 'ROLE_ADMIN', 'nelson'),
(3, 'prueba', 'ROLE_ADMIN', 'administrador'),
(5, '$2a$10$woIexneuejyUrSv6jpVkXuQPbt660PF7Q/PVCALexRVgXX.Ok/keW', 'ROLE_ADMIN', 'antonio'),
(6, '$2a$10$0C/er/OFVLO3dySQpY72LuOD0z4yOXDqcfOKwsQ.frBzN2zUCw42W', 'ROLE_USER', 'pedro'),
(7, '$2a$10$mhbyTxTrMu9x16pHARw4uOQUZkivUeMVcM8YU9X9p7mDIOnXtm60.', 'ROLE_USER', 'user');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `movie`
--
ALTER TABLE `movie`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `users`
--
ALTER TABLE `users`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `users`
--
ALTER TABLE `users`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
