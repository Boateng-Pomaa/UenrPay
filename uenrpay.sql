-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Sep 09, 2021 at 09:39 PM
-- Server version: 10.4.20-MariaDB
-- PHP Version: 8.0.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `uenrpay`
--

-- --------------------------------------------------------

--
-- Table structure for table `courses`
--

DROP TABLE IF EXISTS `courses`;
CREATE TABLE `courses` (
  `Course_code` varchar(15) NOT NULL,
  `Course_name` varchar(100) NOT NULL,
  `dept_ID` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `courses`
--

INSERT INTO `courses` (`Course_code`, `Course_name`, `dept_ID`) VALUES
('COMP061', 'Data Structure', 'DID001'),
('COMP072', 'System Analysis', 'DID001'),
('INFT061', 'Database', 'DID001');

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

DROP TABLE IF EXISTS `department`;
CREATE TABLE `department` (
  `dept_ID` varchar(15) NOT NULL,
  `dept_name` varchar(100) NOT NULL,
  `Prog_id` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`dept_ID`, `dept_name`, `Prog_id`) VALUES
('DID001', 'Computer Science And Informatics', 'PID001');

-- --------------------------------------------------------

--
-- Table structure for table `login`
--

DROP TABLE IF EXISTS `login`;
CREATE TABLE `login` (
  `Index_Number` varchar(15) NOT NULL,
  `Password` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `login`
--

INSERT INTO `login` (`Index_Number`, `Password`) VALUES
('UED2700119', '8384'),
('UED2700219', 'darl8384'),
('UED27003519', '1234');

-- --------------------------------------------------------

--
-- Table structure for table `programme`
--

DROP TABLE IF EXISTS `programme`;
CREATE TABLE `programme` (
  `Prog_id` varchar(15) NOT NULL,
  `prog_name` varchar(50) NOT NULL,
  `dept_ID` varchar(15) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `programme`
--

INSERT INTO `programme` (`Prog_id`, `prog_name`, `dept_ID`) VALUES
('PID001', 'Information Technology', 'DID001'),
('PID002', 'Computer Science', 'DID001'),
('PID003', 'Dip Information Technology', 'DID001');

-- --------------------------------------------------------

--
-- Table structure for table `registration`
--

DROP TABLE IF EXISTS `registration`;
CREATE TABLE `registration` (
  `Reg_id` varchar(15) NOT NULL,
  `Std_id` varchar(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

DROP TABLE IF EXISTS `students`;
CREATE TABLE `students` (
  `Index_Number` varchar(15) NOT NULL,
  `Name` varchar(50) NOT NULL,
  `Programme` varchar(50) NOT NULL,
  `Level` int(10) NOT NULL,
  `Status` varchar(15) NOT NULL,
  `Semester` varchar(25) NOT NULL,
  `Dept_id` varchar(20) NOT NULL,
  `Reg_id` varchar(20) NOT NULL,
  `Fees` int(10) NOT NULL,
  `Amt_paid` int(10) NOT NULL,
  `Rem_balance` int(10) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`Index_Number`, `Name`, `Programme`, `Level`, `Status`, `Semester`, `Dept_id`, `Reg_id`, `Fees`, `Amt_paid`, `Rem_balance`) VALUES
('UED2700119', 'Nana Yaa Yeboah', 'Dip Information Technolgy', 200, 'Continuing', 'Second', 'DID001', '', 1030, 1030, 0),
('UED2700219', 'Boateng Pomaa Linda', 'Dip Information Technolgy', 200, 'Continuing', 'Second', 'DID001', '', 1030, 1030, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `courses`
--
ALTER TABLE `courses`
  ADD PRIMARY KEY (`Course_code`);

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`dept_ID`);

--
-- Indexes for table `login`
--
ALTER TABLE `login`
  ADD PRIMARY KEY (`Index_Number`);

--
-- Indexes for table `programme`
--
ALTER TABLE `programme`
  ADD PRIMARY KEY (`Prog_id`);

--
-- Indexes for table `registration`
--
ALTER TABLE `registration`
  ADD PRIMARY KEY (`Reg_id`);

--
-- Indexes for table `students`
--
ALTER TABLE `students`
  ADD PRIMARY KEY (`Index_Number`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
