-- phpMyAdmin SQL Dump
-- version 5.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: May 06, 2020 at 08:00 AM
-- Server version: 10.4.11-MariaDB
-- PHP Version: 7.2.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `restdb`
--

-- --------------------------------------------------------

--
-- Table structure for table `payment`
--

CREATE TABLE `payment` (
  `paymentID` int(5) NOT NULL,
  `paymentCode` varchar(10) NOT NULL,
  `paymentType` varchar(20) NOT NULL,
  `paymentAmount` decimal(10,2) NOT NULL,
  `paymentDesc` varchar(60) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `payment`
--

INSERT INTO `payment` (`paymentID`, `paymentCode`, `paymentType`, `paymentAmount`, `paymentDesc`) VALUES
(1, 'asdc7', 'cash', '700.52', 'chanellingcharges'),
(2, 'asc4', 'cash', '450.00', 'channeling service'),
(3, 'asc4', 'cash', '14500.00', 'Biopsy'),
(14, 'asq1256', 'visa', '10000.00', 'operation'),
(15, 'z123', 'Genie', '1200.00', 'Chnnelling'),
(16, 'awe12', 'credit', '1500.00', 'prescription'),
(18, 'oop120', 'credit', '10300.00', 'kcjkjkljdldkldkdld'),
(19, '455wer', 'cash', '450.00', 'biopsy'),
(20, 'xccvzs1', 'cash', '1234.00', 'pharmacy');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `payment`
--
ALTER TABLE `payment`
  ADD PRIMARY KEY (`paymentID`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `payment`
--
ALTER TABLE `payment`
  MODIFY `paymentID` int(5) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
