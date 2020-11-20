-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 18, 2020 at 05:58 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.4.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_presensi_kelas`
--

-- --------------------------------------------------------

--
-- Table structure for table `tb_users`
--

CREATE TABLE `tb_users` (
  `users_id` int(32) NOT NULL,
  `users_username` varchar(64) DEFAULT NULL,
  `users_password` varchar(64) DEFAULT NULL,
  `users_level` enum('admin','dosen') DEFAULT NULL,
  `users_nama` varchar(32) DEFAULT NULL,
  `users_gender` enum('Laki-laki','Perempuan') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `tb_users`
--

INSERT INTO `tb_users` (`users_id`, `users_username`, `users_password`, `users_level`, `users_nama`, `users_gender`) VALUES
(1, 'admin', 'admin', 'admin', 'Asmiranda', 'Perempuan'),
(2, 'dosen', 'dosen', 'dosen', 'Sugiono', 'Laki-laki'),
(3, 'panjul', 'panjul', 'dosen', 'Pak Panjul', 'Laki-laki'),
(4, 'sitikomah', 'sitikomah', 'dosen', 'Sitikomah manyun', 'Perempuan'),
(5, 'polokoki', 'polokoki', 'dosen', 'kokipolo', 'Laki-laki'),
(10, 'asdasd', 'asdasd', 'dosen', 'asdasdasd', 'Perempuan'),
(11, 'polokoki', 'poolokok', 'dosen', 'yeru tho', 'Perempuan'),
(12, '54321', '54321', 'dosen', 'tere', 'Perempuan');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tb_users`
--
ALTER TABLE `tb_users`
  ADD PRIMARY KEY (`users_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tb_users`
--
ALTER TABLE `tb_users`
  MODIFY `users_id` int(32) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
