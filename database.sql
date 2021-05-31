-- phpMyAdmin SQL Dump
-- version 4.9.7
-- https://www.phpmyadmin.net/
--
-- Host: localhost:3306
-- Generation Time: May 31, 2021 at 06:29 PM
-- Server version: 5.7.32
-- PHP Version: 7.4.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Database: `Restaurant`
--

-- --------------------------------------------------------

--
-- Table structure for table `ingredient`
--
CREATE DATABASE `Restaurant`;

USE `Restaurant`;

CREATE TABLE `ingredient` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `seasonal` tinyint(1) NOT NULL DEFAULT '0',
  `origin` int(11) NOT NULL,
  `famille` varchar(100) DEFAULT NULL,
  `type` varchar(100) DEFAULT NULL,
  `ingredientType` varchar(100) NOT NULL,
  `groupColumn` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `ingredient`
--

INSERT INTO `ingredient` (`id`, `name`, `seasonal`, `origin`, `famille`, `type`, `ingredientType`, `groupColumn`) VALUES
(1, 'steak', 1, 56, '', 'viande rouge', 'meat', NULL),
(2, 'Merguez', 0, 29, '', 'Porc', 'meat', NULL),
(3, 'Carotte', 1, 56, 'legume', NULL, 'vegetable', NULL),
(4, 'Radis', 1, 12, 'legume', NULL, 'vegetable', NULL),
(5, 'Navet', 0, 34, 'legume', NULL, 'vegetable', NULL),
(6, 'poireau', 1, 4, 'legume', NULL, 'vegetable', NULL),
(9, 'Choux-Fleur', 0, 32, 'legume', NULL, 'vegetable', NULL),
(10, 'Concombre', 1, 3, 'Cucurbits', NULL, 'vegetable', NULL),
(11, 'Dinde', 1, 22, NULL, 'White Meat', 'meat', NULL),
(12, 'Poulet', 1, 2, NULL, 'White Meat', 'meat', NULL),
(21, 'Frites', 0, 70, NULL, NULL, 'startchyFood', 'Potatoes'),
(22, 'Courgette', 1, 23, 'legume', NULL, 'vegetable', NULL),
(23, 'Collier d\'agneau', 0, 22, NULL, 'Agneau', 'meat', ''),
(24, 'Cuisse de poulet', 0, 32, NULL, 'Poulet', 'meat', NULL),
(25, 'Semoule', 0, 33, NULL, NULL, 'startchyFood', 'semoule'),
(26, 'oeuf', 0, 29, NULL, 'poule élevée en plein air', 'meat', NULL),
(27, 'sauce tomate', 1, 29, 'legume', NULL, 'vegetable', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `Message`
--

CREATE TABLE `Message` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `lastName` varchar(100) NOT NULL,
  `subject` varchar(255) NOT NULL,
  `comment` longtext NOT NULL,
  `phone` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `Message`
--

INSERT INTO `Message` (`id`, `name`, `lastName`, `subject`, `comment`, `phone`, `email`, `date`) VALUES
(8, 'Diane', 'Chevalier', 'Qualité', 'Je n\'ai pas trouvé satisfaisante la qualité de vos produis', '09 78 65 88 11', 'dianechevalier@gmail.com', '2021-05-31'),
(10, 'rinaudo', 'enora', 'Merci pour hier', 'Merci pour ce delicieux tartare.', '09 89 00 56 22', 'e.r@gmail.com', '2021-05-31');

-- --------------------------------------------------------

--
-- Table structure for table `notes`
--

CREATE TABLE `notes` (
  `id` int(11) NOT NULL,
  `note` int(11) NOT NULL,
  `comment` longtext NOT NULL,
  `name` varchar(100) NOT NULL,
  `date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `notes`
--

INSERT INTO `notes` (`id`, `note`, `comment`, `name`, `date`) VALUES
(4, 5, 'Top !!!', 'DIane', '2021-05-31'),
(5, 2, 'Pas bien du tout, c\'est arrivé froid...', 'Thomas', '2021-05-31'),
(6, 5, 'C\'etait au top du top', 'enora', '2021-05-31');

-- --------------------------------------------------------

--
-- Table structure for table `plat`
--

CREATE TABLE `plat` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `plat`
--

INSERT INTO `plat` (`id`, `name`) VALUES
(1, 'tartare'),
(2, 'Couscous');

-- --------------------------------------------------------

--
-- Table structure for table `plat_ingredient`
--

CREATE TABLE `plat_ingredient` (
  `id` int(11) NOT NULL,
  `platId` int(11) NOT NULL,
  `ingredientId` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `plat_ingredient`
--

INSERT INTO `plat_ingredient` (`id`, `platId`, `ingredientId`) VALUES
(1, 1, 1),
(2, 2, 2),
(3, 2, 3),
(4, 2, 22),
(5, 2, 23),
(6, 2, 24),
(7, 2, 25),
(8, 1, 26),
(9, 1, 27);

-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

CREATE TABLE `reservation` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `date` date NOT NULL,
  `nbrReservation` int(11) NOT NULL,
  `phone` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `lastName` varchar(100) NOT NULL,
  `hour` time NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `reservation`
--

INSERT INTO `reservation` (`id`, `name`, `date`, `nbrReservation`, `phone`, `email`, `lastName`, `hour`) VALUES
(113, 'Marie', '2021-06-10', 5, '09 87 88 99 00', 'marie@gmail.com', 'Jean', '12:45:00'),
(114, 'rinaudo', '2021-05-31', 3, '0879765454', 'e.r@gmailcom', 'enora', '12:30:00');

-- --------------------------------------------------------

--
-- Table structure for table `restaurant`
--

CREATE TABLE `restaurant` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `adress` varchar(100) NOT NULL,
  `city` varchar(100) NOT NULL,
  `zipCode` varchar(100) NOT NULL,
  `phone` varchar(100) NOT NULL,
  `mail` varchar(255) NOT NULL,
  `diet` varchar(100) DEFAULT NULL,
  `localProducts` tinyint(1) DEFAULT NULL,
  `doggyBag` tinyint(1) DEFAULT '0',
  `label` varchar(100) DEFAULT NULL,
  `plat` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `restaurant`
--

INSERT INTO `restaurant` (`id`, `name`, `adress`, `city`, `zipCode`, `phone`, `mail`, `diet`, `localProducts`, `doggyBag`, `label`, `plat`) VALUES
(120, 'McDonalds', '115 Avenue de Tallinn', 'Brest', '29200', '08 32 25 39 75', 'mco@contact.com', 'omnivore', 0, 1, 'France', NULL),
(121, 'Del Arte', 'Place Liberté', 'Brest', '29200', '06 32 35 89 75', 'delarte@gmail.com', 'carnivore', 1, 1, 'Bio', 1),
(122, 'Roadside', 'Place Liberté', 'Brest', '29200', '07 56 42 00 91', 'roadside@gmail.com', 'lacto-végétarisme', 1, 1, 'Label rouge', NULL),
(123, 'Ciel de Paris', '56 eme, Avenue du Maine', 'Paris', '75015', '02 97 00 96 54', 'cieldeparis@yahoo.com', 'végétarien', 1, 0, 'Label rouge', NULL),
(124, 'La base', 'Base des sous-marins', 'Lorient', '56100', '03 56 78 90 00', 'labase@hello.fr', 'végan', 1, 1, 'Fairtrade', NULL),
(125, 'Le yachtman', '14 rue poissoniere', 'Lorient', '56100', '02 97 87 24 15', 'contact@gmail.com', 'carnivore', 0, 1, 'Peche durable', NULL),
(126, 'Chez Franklin', '10 rue Franklin', 'Nantes', '44000', '07 65 43 21 88', 'franklin@yahoo.com', 'végétalien', 0, 1, 'IGP', NULL),
(127, 'Le carré', '34 place des Lices', 'Rennes', '35000', '08 76 54 32 11', 'carre@icloud.com', 'pesco-végétarien', 1, 1, 'Bio', NULL),
(128, 'McDonalds', '140 av. des Champs Elysées', 'Paris', '75008', '07 65 72 99 11', 'mcdo@contact.com', 'omnivore', 0, 1, 'AOP', NULL),
(129, 'Montmartre', '45 rue des toiles', 'Nice', '89777', '02 97 00 96 54', 'mont@yahoo.com', 'sans gluten', 1, 0, 'Label rouge', NULL),
(130, 'La cantoche', '67 rue des tortues', 'Marseille', '32000', '07 65 43 21 88', 'contact@yahoo.com', 'flexitarien', 0, 1, 'IGP', NULL),
(131, 'Palais du bourg', '56 rue st exupery', 'Morlaix', '29350', '08 78 90 00 11', 'palais@gmail.com', 'sans gluten', 0, 1, 'AUCUN', NULL),
(132, 'Le Bordeaux', 'place de la comedie', 'Bordeaux', '87670', '08 78 90 00 11', 'bordeaux@gmail.com', 'pesco-végétarien', 1, 0, 'Peche durable', NULL),
(133, 'Chez Jean', '01 rue du commerce ', 'Vannes', '56400', '08 67 23 10 22', 'jean@yahoo.com', 'végan', 1, 1, 'AUCUN', NULL),
(134, 'Del Arte', '45 rue des chasseurs', 'Brest', '29200', '0987654321', 'marie@gmail.com', 'végan', 1, 1, 'AOP', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `restaurant_message`
--

CREATE TABLE `restaurant_message` (
  `id` int(11) NOT NULL,
  `idRestaurant` int(11) NOT NULL,
  `idMessage` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `restaurant_message`
--

INSERT INTO `restaurant_message` (`id`, `idRestaurant`, `idMessage`) VALUES
(8, 121, 8),
(10, 121, 10);

-- --------------------------------------------------------

--
-- Table structure for table `restaurant_note`
--

CREATE TABLE `restaurant_note` (
  `id` int(11) NOT NULL,
  `idRestaurant` int(11) NOT NULL,
  `idNote` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `restaurant_note`
--

INSERT INTO `restaurant_note` (`id`, `idRestaurant`, `idNote`) VALUES
(7, 121, 4),
(8, 121, 5),
(9, 121, 6);

-- --------------------------------------------------------

--
-- Table structure for table `restaurant_reservation`
--

CREATE TABLE `restaurant_reservation` (
  `id` int(11) NOT NULL,
  `idRestaurant` int(11) NOT NULL,
  `idReservation` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `restaurant_reservation`
--

INSERT INTO `restaurant_reservation` (`id`, `idRestaurant`, `idReservation`) VALUES
(46, 121, 113),
(47, 121, 114);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `ingredient`
--
ALTER TABLE `ingredient`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `Message`
--
ALTER TABLE `Message`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `notes`
--
ALTER TABLE `notes`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `plat`
--
ALTER TABLE `plat`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `plat_ingredient`
--
ALTER TABLE `plat_ingredient`
  ADD PRIMARY KEY (`id`),
  ADD KEY `plat_ingredient_FK` (`platId`),
  ADD KEY `plat_ingredient_FK_1` (`ingredientId`);

--
-- Indexes for table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `restaurant`
--
ALTER TABLE `restaurant`
  ADD PRIMARY KEY (`id`),
  ADD KEY `restaurant_FK` (`plat`);

--
-- Indexes for table `restaurant_message`
--
ALTER TABLE `restaurant_message`
  ADD PRIMARY KEY (`id`),
  ADD KEY `restaurant_message_FK` (`idMessage`),
  ADD KEY `restaurant_message_FK_1` (`idRestaurant`);

--
-- Indexes for table `restaurant_note`
--
ALTER TABLE `restaurant_note`
  ADD PRIMARY KEY (`id`),
  ADD KEY `restaurant_note_FK` (`idRestaurant`),
  ADD KEY `restaurant_note_FK_1` (`idNote`);

--
-- Indexes for table `restaurant_reservation`
--
ALTER TABLE `restaurant_reservation`
  ADD PRIMARY KEY (`id`),
  ADD KEY `restaurant_reservation_FK` (`idRestaurant`),
  ADD KEY `restaurant_reservation_FK_1` (`idReservation`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `ingredient`
--
ALTER TABLE `ingredient`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;

--
-- AUTO_INCREMENT for table `Message`
--
ALTER TABLE `Message`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `notes`
--
ALTER TABLE `notes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `plat`
--
ALTER TABLE `plat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `plat_ingredient`
--
ALTER TABLE `plat_ingredient`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=115;

--
-- AUTO_INCREMENT for table `restaurant`
--
ALTER TABLE `restaurant`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=135;

--
-- AUTO_INCREMENT for table `restaurant_message`
--
ALTER TABLE `restaurant_message`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `restaurant_note`
--
ALTER TABLE `restaurant_note`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT for table `restaurant_reservation`
--
ALTER TABLE `restaurant_reservation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `plat_ingredient`
--
ALTER TABLE `plat_ingredient`
  ADD CONSTRAINT `plat_ingredient_FK` FOREIGN KEY (`platId`) REFERENCES `plat` (`id`),
  ADD CONSTRAINT `plat_ingredient_FK_1` FOREIGN KEY (`ingredientId`) REFERENCES `ingredient` (`id`);

--
-- Constraints for table `restaurant`
--
ALTER TABLE `restaurant`
  ADD CONSTRAINT `restaurant_FK` FOREIGN KEY (`plat`) REFERENCES `plat` (`id`);

--
-- Constraints for table `restaurant_message`
--
ALTER TABLE `restaurant_message`
  ADD CONSTRAINT `restaurant_message_FK` FOREIGN KEY (`idMessage`) REFERENCES `Message` (`id`),
  ADD CONSTRAINT `restaurant_message_FK_1` FOREIGN KEY (`idRestaurant`) REFERENCES `restaurant` (`id`);

--
-- Constraints for table `restaurant_note`
--
ALTER TABLE `restaurant_note`
  ADD CONSTRAINT `restaurant_note_FK` FOREIGN KEY (`idRestaurant`) REFERENCES `restaurant` (`id`),
  ADD CONSTRAINT `restaurant_note_FK_1` FOREIGN KEY (`idNote`) REFERENCES `notes` (`id`);

--
-- Constraints for table `restaurant_reservation`
--
ALTER TABLE `restaurant_reservation`
  ADD CONSTRAINT `restaurant_reservation_FK` FOREIGN KEY (`idRestaurant`) REFERENCES `restaurant` (`id`),
  ADD CONSTRAINT `restaurant_reservation_FK_1` FOREIGN KEY (`idReservation`) REFERENCES `reservation` (`id`);
