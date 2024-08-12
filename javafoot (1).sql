-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3308
-- Generation Time: Aug 08, 2024 at 10:43 AM
-- Server version: 10.4.22-MariaDB
-- PHP Version: 7.3.33

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `javafoot`
--

-- --------------------------------------------------------

--
-- Table structure for table `arbitre`
--

CREATE TABLE `arbitre` (
  `idarbitre` int(11) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `poste` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `arbitre`
--

INSERT INTO `arbitre` (`idarbitre`, `nom`, `prenom`, `poste`) VALUES
(1, 'NZEYIMANA', 'Claude', 'arbitre-central');

-- --------------------------------------------------------

--
-- Table structure for table `coach`
--

CREATE TABLE `coach` (
  `idcoach` int(11) NOT NULL,
  `nom` varchar(20) NOT NULL,
  `prenom` varchar(20) NOT NULL,
  `age` varchar(11) NOT NULL,
  `nationalite` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `coach`
--

INSERT INTO `coach` (`idcoach`, `nom`, `prenom`, `age`, `nationalite`) VALUES
(1, 'Cruyff', 'Johan', '43ans', 'NIGERIENNE'),
(2, 'Gaal', 'Lois Van', '40ans', 'KENYANNE'),
(3, 'Rijkaard', 'Frank', '42ans', 'TANAZANIENNE');

-- --------------------------------------------------------

--
-- Table structure for table `equipe`
--

CREATE TABLE `equipe` (
  `idequipe` int(11) NOT NULL,
  `pays_equipe` varchar(20) NOT NULL,
  `coach_id` int(11) NOT NULL,
  `president_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `equipe`
--

INSERT INTO `equipe` (`idequipe`, `pays_equipe`, `coach_id`, `president_id`) VALUES
(1, 'Bresil', 2, 2),
(2, 'Europe', 2, 2),
(3, 'Espagne', 2, 2),
(4, 'Marroc', 3, 3),
(5, 'BURUNDI', 2, 2),
(6, 'RWANDA', 3, 3),
(7, 'TANZANIE', 2, 2),
(8, 'NIGERIA', 3, 2),
(9, 'OUGANDA', 2, 2),
(10, 'MAROC', 1, 3),
(11, 'TANZANIE', 2, 2),
(12, 'TANZANIE', 2, 2);

-- --------------------------------------------------------

--
-- Table structure for table `joueur`
--

CREATE TABLE `joueur` (
  `idjoueur` int(11) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `datenaiss` date NOT NULL,
  `nationalite` varchar(30) NOT NULL,
  `position` varchar(30) NOT NULL,
  `equipe_id` int(11) NOT NULL,
  `coach_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `joueur`
--

INSERT INTO `joueur` (`idjoueur`, `nom`, `prenom`, `datenaiss`, `nationalite`, `position`, `equipe_id`, `coach_id`) VALUES
(1, 'katihabwa', 'chelsea', '2000-02-12', 'RWANNDAISE', 'p-3', 2, 2),
(2, 'katiha', 'chelsea', '2000-02-12', 'RWANNDAISE', 'p-3', 2, 2),
(3, 'katiha', 'chelsea', '2000-02-12', 'RWANNDAISE', 'p-3', 1, 1);

-- --------------------------------------------------------

--
-- Table structure for table `president`
--

CREATE TABLE `president` (
  `idpresident` int(11) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `email` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `president`
--

INSERT INTO `president` (`idpresident`, `nom`, `prenom`, `email`) VALUES
(1, 'Pep', 'Guardiola', 'pepguard@gmail.com'),
(2, 'Titoes', 'Vilanova', 'Titoesvil@gmail.com'),
(3, 'Gerardo', 'Martino', 'GerardoMarti@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `secouriste`
--

CREATE TABLE `secouriste` (
  `idsecouriste` int(11) NOT NULL,
  `nom` varchar(30) NOT NULL,
  `prenom` varchar(30) NOT NULL,
  `medicaments` varchar(40) NOT NULL,
  `outilssecours` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `secouriste`
--

INSERT INTO `secouriste` (`idsecouriste`, `nom`, `prenom`, `medicaments`, `outilssecours`) VALUES
(1, 'Katihabwa', 'Chelsea', 'Bronchodilatate', 'Defibrillateur Autom');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `arbitre`
--
ALTER TABLE `arbitre`
  ADD PRIMARY KEY (`idarbitre`);

--
-- Indexes for table `coach`
--
ALTER TABLE `coach`
  ADD PRIMARY KEY (`idcoach`);

--
-- Indexes for table `equipe`
--
ALTER TABLE `equipe`
  ADD PRIMARY KEY (`idequipe`),
  ADD KEY `equipe_fk` (`coach_id`),
  ADD KEY `equipe_fk1` (`president_id`);

--
-- Indexes for table `joueur`
--
ALTER TABLE `joueur`
  ADD PRIMARY KEY (`idjoueur`),
  ADD KEY `joueur_fk` (`equipe_id`),
  ADD KEY `coachfk` (`coach_id`);

--
-- Indexes for table `president`
--
ALTER TABLE `president`
  ADD PRIMARY KEY (`idpresident`);

--
-- Indexes for table `secouriste`
--
ALTER TABLE `secouriste`
  ADD PRIMARY KEY (`idsecouriste`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `equipe`
--
ALTER TABLE `equipe`
  ADD CONSTRAINT `equipe_fk` FOREIGN KEY (`coach_id`) REFERENCES `coach` (`idcoach`) ON DELETE CASCADE,
  ADD CONSTRAINT `equipe_fk1` FOREIGN KEY (`president_id`) REFERENCES `president` (`idpresident`) ON DELETE CASCADE;

--
-- Constraints for table `joueur`
--
ALTER TABLE `joueur`
  ADD CONSTRAINT `coachfk` FOREIGN KEY (`coach_id`) REFERENCES `coach` (`idcoach`) ON DELETE CASCADE,
  ADD CONSTRAINT `joueur_fk` FOREIGN KEY (`equipe_id`) REFERENCES `equipe` (`idequipe`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
