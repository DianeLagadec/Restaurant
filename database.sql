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
(1, 'steack', 1, 56, '', 'viande rouge', 'meat', NULL),
(2, 'Merguez', 0, 29, '', 'Porc', 'meat', NULL),
(3, 'Carotte', 1, 56, 'legume', NULL, 'vegetable', NULL),
(4, 'Radis', 1, 12, 'legume', NULL, 'vegetable', NULL),
(5, 'Navet', 0, 34, 'legume', NULL, 'vegetable', NULL),
(6, 'poireau', 1, 4, 'legume', NULL, 'vegetable', NULL),
(9, 'Choux-Fleur', 0, 32, 'legume', NULL, 'vegetable', NULL),
(10, 'Cucumber', 1, 3, 'Cucurbits', NULL, 'vegetable', NULL),
(11, 'Turkey', 1, 22, NULL, 'White Meat', 'meat', NULL),
(12, 'Chicken', 1, 2, NULL, 'White Meat', 'meat', NULL),
(21, 'Fries', 0, 70, NULL, NULL, 'startchyFood', 'Potatoes'),
(22, 'Courgette', 1, 23, 'legume', NULL, 'vegetable', NULL),
(23, 'Collier d\'agneau', 0, 22, NULL, 'Agneau', 'meat', ''),
(24, 'Cuisse de poulet', 0, 32, NULL, 'Poulet', 'meat', NULL),
(25, 'Semoule', 0, 33, NULL, NULL, 'startchyFood', 'semoule');

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
(1, 'BOUQUIN', 'Malo', 'Test', 'je test le message', '0652689400', 'malo.bouquin@live.fr', '2021-04-08');

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
(1, 4, 'coolccxhghghghghghghghghghghghghghghghhghghghghghhhhhhhhhghghghhghghghghhghghghghghghhghghghghghghghghghghghghhghghghgh', 'Malo', '2022-03-19'),
(2, 5, 'Super', 'Test', '2020-05-15'),
(3, 2, 'Pas cool', 'Moi', '2021-04-08');

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
(7, 2, 25);

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
(1, 'malo', '2022-04-16', 4, '0564769806', 'a', 'a', '18:41:00'),
(2, 'Jarrod', '2025-05-21', 5, '08 39 97 96 32', 'diam.at.pretium@antedictum.co.uk', 'Athena', '19:00:00'),
(3, 'Drew', '2010-04-20', 2, '09 89 70 22 31', 'Etiam.laoreet@aliquetdiam.ca', 'Dillon', '19:00:00'),
(4, 'Berk', '2003-01-21', 5, '04 90 61 71 10', 'sem@elitelitfermentum.co.uk', 'Flynn', '19:00:00'),
(5, 'Garth', '2003-03-22', 5, '05 60 45 62 17', 'vulputate@auctor.org', 'Owen', '19:00:00'),
(6, 'Nehru', '2020-04-21', 6, '03 59 84 76 19', 'nisl.Maecenas@tortorIntegeraliquam.net', 'Cassady', '19:00:00'),
(7, 'Ralph', '2009-01-22', 9, '03 58 65 04 34', 'Nullam.ut@fringillamilacinia.net', 'Nadine', '19:00:00'),
(8, 'Bernard', '2010-07-20', 6, '03 20 34 72 69', 'scelerisque.dui@dictummagnaUt.ca', 'Bethany', '19:00:00'),
(9, 'Felix', '2001-06-20', 6, '07 11 45 60 24', 'nunc.id.enim@augueacipsum.com', 'Sheila', '19:00:00'),
(10, 'Malik', '2022-06-20', 10, '02 68 71 21 80', 'In.mi.pede@ipsumdolorsit.ca', 'Gray', '19:00:00'),
(11, 'Drew', '2009-05-21', 8, '02 61 60 85 88', 'ridiculus.mus.Proin@nonummyac.org', 'Elvis', '19:00:00'),
(12, 'Harper', '2018-02-21', 10, '03 05 65 85 34', 'in@Aliquam.com', 'Deacon', '19:00:00'),
(13, 'Omar', '2027-06-20', 8, '08 72 19 77 16', 'cursus.a.enim@dignissimmagnaa.co.uk', 'Emily', '19:00:00'),
(14, 'Thaddeus', '2018-10-21', 9, '03 74 29 52 18', 'pretium.neque@Praesent.org', 'Tate', '19:00:00'),
(15, 'Chandler', '2024-05-21', 2, '06 84 85 15 67', 'quis.diam.Pellentesque@enimEtiamgravida.net', 'Erica', '19:00:00'),
(16, 'Alden', '2002-03-21', 8, '07 08 23 93 64', 'pede.malesuada.vel@felisadipiscingfringilla.com', 'Sean', '19:00:00'),
(17, 'Anthony', '2012-12-21', 5, '03 54 47 09 27', 'adipiscing@vel.com', 'Marny', '19:00:00'),
(18, 'Scott', '2009-09-21', 6, '04 86 82 56 23', 'Sed.dictum.Proin@nonloremvitae.ca', 'Keith', '19:00:00'),
(19, 'Nathaniel', '2017-04-20', 1, '02 21 61 06 91', 'erat.nonummy.ultricies@ante.org', 'Hunter', '19:00:00'),
(20, 'Acton', '2019-06-21', 7, '04 90 92 67 46', 'mollis.vitae.posuere@malesuadaInteger.net', 'Jasper', '19:00:00'),
(21, 'Joseph', '2002-12-21', 7, '04 84 61 01 90', 'lacinia.at@uterosnon.com', 'Destiny', '19:00:00'),
(22, 'Byron', '2005-09-20', 3, '05 22 95 52 04', 'quis.arcu.vel@adipiscingenim.org', 'Colton', '19:00:00'),
(23, 'Nash', '2015-11-21', 7, '05 01 49 88 39', 'dapibus@ipsum.co.uk', 'Kirk', '19:00:00'),
(24, 'Yardley', '2029-05-20', 3, '09 01 03 69 26', 'risus.Donec@quam.ca', 'Quinn', '19:00:00'),
(25, 'Gavin', '2009-09-20', 2, '07 85 04 05 16', 'laoreet.posuere@nonummyipsumnon.ca', 'Hayden', '19:00:00'),
(26, 'Marvin', '2027-07-20', 1, '04 87 31 31 42', 'odio.Nam.interdum@ornarelectusjusto.edu', 'Sopoline', '19:00:00'),
(27, 'Raphael', '2021-11-21', 7, '02 62 77 21 09', 'ligula.Aenean.gravida@luctusetultrices.ca', 'Judah', '19:00:00'),
(28, 'Jordan', '2015-01-22', 4, '05 41 38 27 76', 'malesuada.id@liberoInteger.ca', 'Odessa', '19:00:00'),
(29, 'Addison', '2027-03-22', 3, '08 18 61 53 09', 'vitae.mauris@odio.ca', 'Camden', '19:00:00'),
(30, 'Tyrone', '2003-10-21', 4, '06 69 88 66 96', 'erat.nonummy@Fuscefermentumfermentum.co.uk', 'Gisela', '19:00:00'),
(31, 'Zane', '2015-11-20', 4, '04 95 16 43 93', 'enim@Sedid.org', 'Macey', '19:00:00'),
(32, 'Jerry', '2009-05-21', 6, '06 21 93 12 37', 'interdum@feugiat.org', 'Larissa', '19:00:00'),
(33, 'Oleg', '2018-08-21', 6, '02 08 09 85 46', 'nibh@semperNam.org', 'Hillary', '19:00:00'),
(34, 'Stewart', '2012-02-21', 5, '06 49 27 98 31', 'metus.In@quisdiamPellentesque.edu', 'Nomlanga', '19:00:00'),
(35, 'Jerome', '2010-10-21', 1, '07 41 96 82 11', 'amet.lorem@elit.co.uk', 'Adrian', '19:00:00'),
(36, 'Raja', '2018-10-20', 8, '05 82 90 87 73', 'Nunc@egestasAliquam.net', 'Nayda', '19:00:00'),
(37, 'Allen', '2011-06-21', 10, '03 30 66 61 71', 'risus.Duis.a@leoCrasvehicula.com', 'Cedric', '19:00:00'),
(38, 'Amir', '2028-02-22', 7, '08 52 60 82 43', 'tristique@Maurisutquam.net', 'Hiram', '19:00:00'),
(39, 'Hop', '2017-08-21', 4, '04 33 82 91 05', 'ullamcorper.nisl.arcu@tortorat.co.uk', 'Abigail', '19:00:00'),
(40, 'Aaron', '2002-05-20', 1, '05 58 26 67 59', 'aliquet.libero@estconguea.com', 'Rooney', '19:00:00'),
(41, 'Acton', '2018-03-22', 3, '01 60 66 37 22', 'dictum@mauriselitdictum.com', 'Xantha', '19:00:00'),
(42, 'Fitzgerald', '2020-03-21', 3, '06 09 22 52 10', 'velit.justo.nec@Etiam.co.uk', 'Ciaran', '19:00:00'),
(43, 'Conan', '2029-05-21', 4, '01 03 90 26 68', 'risus@Nuncmauris.co.uk', 'Zeph', '19:00:00'),
(44, 'Nathan', '2027-08-21', 10, '08 57 02 39 62', 'ipsum@placerat.com', 'Warren', '19:00:00'),
(45, 'Jerry', '2010-04-20', 10, '02 92 08 98 33', 'Quisque.imperdiet.erat@enim.edu', 'Marny', '19:00:00'),
(46, 'Jesse', '2005-09-21', 9, '05 29 21 18 66', 'Nam.porttitor.scelerisque@magnaDuis.co.uk', 'Kennan', '19:00:00'),
(47, 'Timothy', '2005-09-21', 4, '05 86 99 95 23', 'euismod.est@aliquetlibero.co.uk', 'Herman', '19:00:00'),
(48, 'Chancellor', '2009-07-20', 4, '05 84 26 99 10', 'In@dui.edu', 'Buffy', '19:00:00'),
(49, 'Jackson', '2007-07-20', 7, '01 74 70 15 95', 'luctus.et.ultrices@Nuncsedorci.com', 'Thomas', '19:00:00'),
(50, 'Seth', '2028-02-21', 8, '01 16 81 65 83', 'semper@sit.edu', 'Geoffrey', '19:00:00'),
(51, 'Quentin', '2024-09-20', 8, '05 05 48 93 54', 'dignissim.lacus@Nunclaoreet.org', 'Aspen', '19:00:00'),
(52, 'Callum', '2023-11-20', 4, '07 71 30 47 48', 'amet.massa.Quisque@Utnec.ca', 'Porter', '19:00:00'),
(53, 'Tarik', '2008-01-22', 3, '02 95 70 27 81', 'tincidunt@sedhendrerita.net', 'Otto', '19:00:00'),
(54, 'Declan', '2023-07-21', 9, '06 56 93 38 02', 'enim.gravida@sitamet.edu', 'Mariko', '19:00:00'),
(55, 'Nash', '2008-02-21', 1, '09 92 35 11 57', 'ornare.elit@idmollisnec.edu', 'Ashely', '19:00:00'),
(56, 'Stuart', '2002-09-21', 8, '05 20 90 61 35', 'vestibulum.Mauris.magna@metus.org', 'Anika', '19:00:00'),
(57, 'Carl', '2008-10-20', 1, '08 05 62 41 28', 'augue.Sed.molestie@afacilisis.com', 'Warren', '19:00:00'),
(58, 'Hedley', '2011-04-21', 5, '03 46 50 88 80', 'erat.eget@Innec.org', 'Derek', '19:00:00'),
(59, 'Blake', '2018-06-21', 3, '07 76 62 01 51', 'lacinia@tristique.co.uk', 'Colleen', '19:00:00'),
(60, 'Keane', '2010-01-21', 10, '02 65 85 68 51', 'lacinia.orci@eleifendnunc.net', 'Courtney', '19:00:00'),
(61, 'Cooper', '2007-02-22', 2, '09 27 51 63 25', 'tortor.nibh@eu.net', 'Theodore', '19:00:00'),
(62, 'Hasad', '2009-07-20', 6, '04 61 65 79 36', 'porttitor@utmiDuis.com', 'Lois', '19:00:00'),
(63, 'Gil', '2029-07-20', 2, '04 83 29 44 28', 'sed.libero.Proin@in.com', 'Tanisha', '19:00:00'),
(64, 'Declan', '2021-09-20', 6, '03 40 43 29 95', 'ac.risus.Morbi@mauris.edu', 'Damon', '19:00:00'),
(65, 'Hamilton', '2028-02-22', 2, '07 55 21 82 00', 'lobortis@amet.edu', 'Malachi', '19:00:00'),
(66, 'Shad', '2016-07-20', 2, '05 20 22 43 61', 'amet@ornareFusce.ca', 'Madaline', '19:00:00'),
(67, 'Nash', '2022-12-20', 2, '05 20 72 65 97', 'et@tristiquenequevenenatis.net', 'Sloane', '19:00:00'),
(68, 'Boris', '2028-11-21', 6, '07 41 15 23 07', 'placerat.Cras@pharetrafelis.edu', 'Barry', '19:00:00'),
(69, 'Mark', '2020-08-21', 4, '07 08 03 17 16', 'enim.nec@anteMaecenasmi.com', 'Lawrence', '19:00:00'),
(70, 'Jared', '2012-04-20', 3, '08 49 39 93 17', 'sem.Pellentesque.ut@etrutrumeu.ca', 'Brenden', '19:00:00'),
(71, 'Hyatt', '2021-03-21', 8, '03 20 55 17 79', 'orci.tincidunt.adipiscing@magna.com', 'Bell', '19:00:00'),
(72, 'Quentin', '2026-10-20', 4, '03 35 57 52 64', 'bibendum.Donec@duiaugueeu.org', 'Calista', '19:00:00'),
(73, 'Sebastian', '2026-02-21', 6, '08 63 21 12 76', 'enim.condimentum@justo.org', 'Jasper', '19:00:00'),
(74, 'Linus', '2016-05-21', 1, '07 54 35 58 20', 'Duis@est.edu', 'Keane', '19:00:00'),
(75, 'Henry', '2025-11-21', 7, '04 21 01 73 58', 'scelerisque.dui@Aliquam.org', 'Tana', '19:00:00'),
(76, 'Griffith', '2026-05-21', 10, '02 76 40 07 74', 'Maecenas.ornare.egestas@ultricesVivamus.com', 'Coby', '19:00:00'),
(77, 'Gavin', '2023-11-20', 1, '04 28 24 18 10', 'purus.mauris@diam.edu', 'Jorden', '19:00:00'),
(78, 'Hayden', '2016-08-20', 1, '09 98 10 46 07', 'urna@Suspendisseseddolor.net', 'Melodie', '19:00:00'),
(79, 'Zachary', '2010-01-22', 3, '03 16 42 15 74', 'luctus@Aeneaneget.org', 'Isaiah', '19:00:00'),
(80, 'Stone', '2008-08-20', 1, '07 72 92 12 46', 'sed@felis.com', 'Halla', '19:00:00'),
(81, 'Joseph', '2022-06-21', 8, '03 95 67 13 58', 'et.lacinia.vitae@temporbibendum.com', 'Kamal', '19:00:00'),
(82, 'Alexander', '2021-12-20', 9, '08 27 30 60 61', 'mollis@Sedid.net', 'Dacey', '19:00:00'),
(83, 'Lamar', '2026-10-21', 2, '08 52 27 90 74', 'sed@bibendum.edu', 'Cade', '19:00:00'),
(84, 'Theodore', '2011-01-21', 8, '04 21 40 52 06', 'sapien.imperdiet.ornare@Suspendissetristique.com', 'Dean', '19:00:00'),
(85, 'Wade', '2018-04-21', 3, '05 07 04 38 74', 'vulputate.lacus@senectuset.org', 'Damian', '19:00:00'),
(86, 'Kasimir', '2006-08-21', 8, '07 03 31 44 49', 'ante@mollisInteger.ca', 'Hasad', '19:00:00'),
(87, 'Fulton', '2004-10-20', 3, '09 23 22 60 19', 'tempor@augue.com', 'Chava', '19:00:00'),
(88, 'Acton', '2012-07-21', 4, '06 58 05 45 49', 'neque.non@Suspendissedui.org', 'Ryan', '19:00:00'),
(89, 'Seth', '2007-01-21', 2, '08 77 22 21 28', 'hendrerit@neque.com', 'Fiona', '19:00:00'),
(90, 'Austin', '2010-06-21', 10, '04 24 73 49 28', 'lectus.sit@Aliquamfringilla.net', 'Beau', '19:00:00'),
(91, 'Addison', '2023-12-21', 10, '06 36 24 82 80', 'vehicula.aliquet.libero@Nullainterdum.co.uk', 'Teegan', '19:00:00'),
(92, 'Silas', '2009-07-20', 7, '02 74 49 62 70', 'pellentesque.tellus@vestibulumlorem.net', 'Xerxes', '19:00:00'),
(93, 'Chase', '2010-05-20', 9, '08 42 40 36 06', 'enim.commodo.hendrerit@lectusCumsociis.co.uk', 'Carl', '19:00:00'),
(94, 'Jared', '2021-07-21', 1, '04 24 46 17 27', 'hendrerit.neque.In@ligulaNullam.net', 'Regan', '19:00:00'),
(95, 'Chaney', '2015-04-20', 8, '03 26 83 40 71', 'mattis.velit.justo@Vestibulumante.com', 'Hasad', '19:00:00'),
(96, 'Ulysses', '2030-12-20', 6, '01 44 00 26 66', 'odio@ultriciesadipiscingenim.com', 'Ignatius', '19:00:00'),
(97, 'Cyrus', '2005-08-21', 3, '08 98 19 26 99', 'Nunc.quis@Aliquamtincidunt.org', 'Calvin', '19:00:00'),
(98, 'Carson', '2028-08-21', 1, '07 51 81 27 48', 'Cras.dictum.ultricies@libero.com', 'Chester', '19:00:00'),
(99, 'Kennan', '2029-03-22', 1, '06 99 67 95 89', 'elit@auguescelerisquemollis.net', 'Coby', '19:00:00'),
(100, 'Tobias', '2023-08-20', 8, '05 95 68 49 93', 'sed@Aliquamnecenim.org', 'Rashad', '19:00:00'),
(101, 'Theodore', '2030-05-21', 4, '01 75 77 89 62', 'natoque.penatibus.et@euismodin.org', 'Harriet', '19:00:00'),
(102, 'Jarrod', '2025-05-21', 5, '08 39 97 96 32', 'diam.at.pretium@antedictum.co.uk', 'Athena', '19:00:00'),
(103, 'Drew', '2010-04-20', 2, '09 89 70 22 31', 'Etiam.laoreet@aliquetdiam.ca', 'Dillon', '19:00:00'),
(104, 'Berk', '2003-01-21', 5, '04 90 61 71 10', 'sem@elitelitfermentum.co.uk', 'Flynn', '19:00:00'),
(105, 'Garth', '2003-03-22', 5, '05 60 45 62 17', 'vulputate@auctor.org', 'Owen', '19:00:00'),
(106, 'Nehru', '2020-04-21', 6, '03 59 84 76 19', 'nisl.Maecenas@tortorIntegeraliquam.net', 'Cassady', '19:00:00'),
(107, 'Ralph', '2009-01-22', 9, '03 58 65 04 34', 'Nullam.ut@fringillamilacinia.net', 'Nadine', '19:00:00'),
(108, 'Bernard', '2010-07-20', 6, '03 20 34 72 69', 'scelerisque.dui@dictummagnaUt.ca', 'Bethany', '19:00:00'),
(109, 'Felix', '2001-06-20', 6, '07 11 45 60 24', 'nunc.id.enim@augueacipsum.com', 'Sheila', '19:00:00'),
(110, 'Malik', '2022-06-20', 10, '02 68 71 21 80', 'In.mi.pede@ipsumdolorsit.ca', 'Gray', '19:00:00'),
(111, 'Drew', '2009-05-21', 8, '02 61 60 85 88', 'ridiculus.mus.Proin@nonummyac.org', 'Elvis', '19:00:00');

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
(20, 'Aaron', '841-259 Ornare. Street', 'Muno', '21631', '08 32 25 39 75', 'dui.augue@lacusCrasinterdum.net', 'Mauris vel', 1, 1, 'est', NULL),
(21, 'Solomon', 'P.O. Box 795, 8986 Feugiat St.', 'Albury', '48547', '08 66 17 72 97', 'ornare.Fusce.mollis@est.net', 'nec ante.', 1, 1, 'posuere,', NULL),
(22, 'Gray', 'Ap #612-6725 Aliquam Av.', 'Ellon', '28104', '05 72 47 05 23', 'Cras@erat.ca', 'ipsum. Suspendisse', 0, 0, 'vel', NULL),
(23, 'Fitzgerald', '392 Enim. Rd.', 'Ch‰telineau', '22637', '05 14 92 70 78', 'tellus.imperdiet.non@liberoMorbi.com', 'tempus risus.', 0, 1, 'Mauris', NULL),
(24, 'Kane', '3938 Nibh. Street', 'Barrhead', '839911', '05 06 33 66 76', 'interdum.feugiat@Suspendisse.edu', 'ut, nulla.', 0, 0, 'Suspendisse', NULL),
(25, 'Keith', '240-1886 Lobortis Road', 'Oostkerke', '01438', '08 00 79 12 21', 'nisi@semvitae.edu', 'a neque.', 1, 0, 'natoque', NULL),
(26, 'Kenyon', '241-4668 Ligula. Road', 'Tando Allahyar', '2377', '04 49 54 21 11', 'et.commodo@sitametmassa.org', 'eros. Proin', 1, 0, 'nec,', NULL),
(27, 'Vladimir', 'P.O. Box 748, 9108 Leo. Ave', 'Caucaia', '22321', '05 87 97 42 80', 'Sed.congue@convallis.net', 'et magnis', 0, 0, 'metus.', NULL),
(28, 'Oren', 'P.O. Box 864, 9781 Non, St.', 'Vancouver', '441444', '05 92 55 19 27', 'nec.urna@lobortisquama.edu', 'Nullam scelerisque', 1, 1, 'lacus', NULL),
(29, 'Yuli', '533-8940 Volutpat. Avenue', 'Koekelberg', '7558', '04 06 61 40 16', 'diam@tincidunt.org', 'Donec vitae', 0, 1, 'nec', NULL),
(30, 'Nash', '7034 Metus. Rd.', 'Saint-Brieuc', '29566', '03 20 62 62 82', 'posuere.vulputate.lacus@mollisnoncursus.com', 'In lorem.', 0, 1, 'dignissim', NULL),
(31, 'Jamal', '7771 Sit Rd.', 'Isle-aux-Coudres', '37144', '07 02 66 30 54', 'dui.Cum@vestibulumneceuismod.ca', 'Morbi non', 0, 1, 'consequat,', NULL),
(32, 'Chancellor', 'P.O. Box 359, 9629 Lacus. Rd.', 'Paradise', '21914', '03 29 39 29 41', 'dolor.sit@vel.edu', 'est ac', 0, 1, 'ipsum.', NULL),
(33, 'Aristotle', '454-8656 Tincidunt Street', 'Munger', 'S9S 6B6', '08 82 41 05 20', 'orci.Ut@In.ca', 'lacus, varius', 1, 0, 'cursus', NULL),
(34, 'Kennedy', '665-1643 Vel, Rd.', 'Requínoa', '7239', '09 43 42 28 39', 'parturient.montes@ligulaNullam.org', 'inceptos hymenaeos.', 1, 1, 'vitae,', NULL),
(35, 'Amery', 'Ap #512-4327 Orci. St.', 'Tuglie', '00493', '01 69 67 07 54', 'nibh.vulputate.mauris@cursusdiam.edu', 'nascetur ridiculus', 0, 1, 'morbi', NULL),
(36, 'Jesse', 'P.O. Box 847, 1293 Montes, Rd.', 'Castri di Lecce', '51282-90571', '04 22 36 55 20', 'vitae@a.com', 'Mauris vestibulum,', 1, 1, 'faucibus', NULL),
(37, 'Daquan', 'Ap #634-7946 Ornare. St.', 'Annan', '31557', '05 51 84 96 95', 'arcu.iaculis.enim@mi.ca', 'dignissim magna', 0, 1, 'quis', NULL),
(38, 'Bernard', 'P.O. Box 657, 2514 In Avenue', 'Gressan', 'X0H 1A4', '09 94 70 95 18', 'interdum.enim.non@faucibusorciluctus.edu', 'pharetra. Nam', 1, 0, 'quis', NULL),
(39, 'Noble', 'P.O. Box 845, 7402 Eu Avenue', 'Vezin', '9344', '06 09 42 95 31', 'Vestibulum.ut.eros@sapien.com', 'Donec porttitor', 0, 1, 'mollis', NULL),
(40, 'Stuart', '3957 Fames Road', 'Okigwe', '845963', '01 79 82 74 23', 'sagittis.Nullam.vitae@tinciduntnunc.ca', 'pellentesque massa', 1, 1, 'ultricies', NULL),
(41, 'Jameson', '2292 Nisi St.', 'Gespeg', '24767', '02 59 85 60 44', 'mauris.Suspendisse.aliquet@idenim.edu', 'montes, nascetur', 0, 1, 'iaculis', NULL),
(42, 'Stuart', '337-5055 Vitae St.', 'Whitewater Region Township', 'Z4482', '07 62 20 86 35', 'ligula.Aliquam.erat@idblandit.edu', 'tellus faucibus', 1, 0, 'ultrices.', NULL),
(43, 'Zeph', 'Ap #739-3800 Montes, St.', 'Pazarcık', '69353', '05 20 82 24 41', 'non@risusquisdiam.edu', 'Mauris blandit', 1, 0, 'nulla.', NULL),
(44, 'Wesley', '644-7876 Vestibulum Rd.', 'Siculiana', '57814-749', '08 74 52 02 23', 'hendrerit.consectetuer.cursus@facilisisvitae.ca', 'vitae mauris', 1, 1, 'justo.', NULL),
(45, 'Carlos', 'Ap #524-4964 Orci Rd.', 'Saint-Denis', '383407', '09 10 47 95 15', 'amet@semper.co.uk', 'Mauris quis', 1, 1, 'id', NULL),
(46, 'Bevis', '4024 Molestie Av.', 'Swan', '5095', '04 37 85 60 59', 'diam.Pellentesque@vehiculaet.co.uk', 'imperdiet ornare.', 1, 0, 'nec', NULL),
(47, 'Ulric', '330-3265 Tempor Street', 'Stirling', '48387', '09 47 54 97 18', 'ligula.tortor@Pellentesque.com', 'ultricies ligula.', 1, 1, 'sodales', NULL),
(48, 'Cedric', 'Ap #614-5321 Facilisis Street', 'Dolceacqua', 'Z4974', '03 70 86 91 39', 'accumsan.neque.et@nunc.ca', 'eu, ligula.', 0, 0, 'nonummy', NULL),
(49, 'Thane', 'Ap #734-5368 In St.', 'Bhavnagar', '468703', '01 41 99 63 11', 'sollicitudin.orci.sem@blanditcongue.com', 'primis in', 1, 1, 'primis', NULL),
(50, 'Oliver', '697-7843 Cursus Street', 'Mapiripana', '688121', '06 74 74 06 00', 'diam.Proin.dolor@estconguea.ca', 'Sed pharetra,', 0, 1, 'Fusce', NULL),
(51, 'Dustin', '964-2338 Semper, Av.', 'Rouvreux', '24759', '06 82 30 01 92', 'sagittis@tinciduntnibh.net', 'dignissim tempor', 0, 1, 'Duis', NULL),
(52, 'Kennedy', '111-328 Interdum. Rd.', 'Reims', '54041', '04 36 05 00 57', 'tellus@Nam.co.uk', 'neque non', 1, 1, 'eget', NULL),
(53, 'Kennan', '970-9625 Elit Road', 'Jerzu', '533048', '05 46 87 21 18', 'dictum@Aliquam.co.uk', 'Quisque varius.', 1, 1, 'feugiat.', NULL),
(54, 'Mufutau', 'P.O. Box 286, 4310 Sed, St.', 'Coldstream', '863269', '05 10 27 65 55', 'consequat.dolor@liberonecligula.com', 'In faucibus.', 1, 0, 'Nulla', NULL),
(55, 'Colorado', '480-8987 Dolor Street', 'Fontaine-l\'Evque', '875474', '04 72 68 29 79', 'imperdiet@eget.ca', 'Nullam enim.', 0, 1, 'interdum', NULL),
(56, 'Zachery', 'P.O. Box 236, 7704 Consequat St.', 'Detroit', '53078-75072', '08 18 74 95 28', 'elementum.purus.accumsan@in.co.uk', 'pretium neque.', 0, 1, 'et,', NULL),
(57, 'Amery', '189-5321 Morbi Street', 'Tando Allahyar', '20534', '06 76 49 25 97', 'euismod@egestasAliquam.org', 'facilisis. Suspendisse', 1, 0, 'lacus,', NULL),
(58, 'Baker', 'P.O. Box 764, 3280 Ut, Road', 'Tintange', '92056', '04 49 20 94 20', 'erat@iaculis.net', 'pede. Praesent', 1, 1, 'et', NULL),
(59, 'Alan', '9190 Ante Street', 'Chapra', '5755', '03 02 86 01 67', 'luctus.vulputate.nisi@parturientmontes.org', 'Pellentesque tincidunt', 0, 1, 'Aliquam', NULL),
(60, 'Ivor', 'Ap #782-6317 Ultricies Road', 'Uitbergen', '71271', '07 68 84 52 04', 'consequat.auctor@Nullainterdum.edu', 'ornare sagittis', 1, 1, 'In', NULL),
(61, 'Kelly', 'Ap #509-1730 Lorem Ave', 'Brindisi', '61071', '07 29 05 01 89', 'Sed.id.risus@duinec.net', 'lacus. Quisque', 1, 0, 'tellus', NULL),
(62, 'Upton', '6146 Sed Rd.', 'Tollembeek', '3165', '02 99 39 06 99', 'Quisque.purus.sapien@dolortempusnon.org', 'Mauris molestie', 1, 1, 'Praesent', NULL),
(63, 'Kareem', 'P.O. Box 469, 9255 Sapien. Rd.', 'Tiverton', '93344-83728', '08 62 34 14 48', 'nulla.vulputate@Phasellusinfelis.co.uk', 'ante. Nunc', 0, 0, 'imperdiet', NULL),
(64, 'Wesley', 'Ap #314-5909 Vestibulum. Street', 'Fernie', '07303', '07 34 41 86 58', 'tortor.dictum.eu@Proin.net', 'iaculis quis,', 1, 0, 'non', NULL),
(65, 'Hammett', 'P.O. Box 394, 1681 Et, Street', 'Schwäbisch Gmünd', '2338 IC', '09 19 33 23 32', 'nisl.Maecenas@egestas.org', 'Proin non', 1, 0, 'id,', NULL),
(66, 'Nathan', '5540 In Avenue', 'Alma', '49265', '05 81 27 28 39', 'Cras.interdum.Nunc@risusvarius.ca', 'accumsan convallis,', 0, 1, 'nibh', NULL),
(67, 'Demetrius', 'Ap #315-5368 Velit. St.', 'Brunn am Gebirge', '4397 PT', '09 38 41 08 43', 'facilisis.non.bibendum@quisdiam.edu', 'lectus convallis', 1, 0, 'eu,', 2),
(68, 'Troy', '1162 Lorem, Avenue', 'Hope', '17427', '03 13 68 69 83', 'nunc.sit.amet@aliquet.org', 'enim. Mauris', 1, 0, 'risus.', NULL),
(69, 'Roth', '260-1760 Mauris Avenue', 'Soacha', '73171', '01 11 14 67 34', 'at.lacus.Quisque@felisullamcorperviverra.com', 'tincidunt congue', 1, 1, 'ipsum', NULL),
(70, 'David', '2367 Commodo Rd.', 'Bouge', '50019', '08 96 08 47 08', 'morbi@nisinibh.net', 'ipsum primis', 0, 1, 'lorem,', NULL),
(71, 'Ciaran', '7219 Velit Rd.', 'Verkhneuralsk', '59694', '05 54 70 40 10', 'tempus@iaculis.net', 'Quisque ac', 1, 1, 'odio', NULL),
(72, 'Geoffrey', 'Ap #723-4152 Phasellus Road', 'Little Rock', '49008', '08 35 49 35 88', 'nunc.sed.libero@sitametlorem.ca', 'consequat nec,', 1, 0, 'ut,', NULL),
(73, 'Uriah', 'P.O. Box 430, 1466 Varius Avenue', 'New Plymouth', '3444 PI', '02 74 04 00 94', 'lobortis.mauris.Suspendisse@etmalesuada.co.uk', 'mauris erat', 0, 0, 'nec', NULL),
(74, 'Warren', '7950 Orci. Street', 'Facatativá', '21500-976', '04 44 89 60 77', 'Nullam.nisl.Maecenas@In.com', 'Fusce fermentum', 1, 0, 'et', NULL),
(75, 'Basil', '7961 Nec, St.', 'Friedrichsdorf', '60519', '09 61 61 37 01', 'turpis@vitaealiquet.net', 'tellus sem', 0, 0, 'commodo', NULL),
(76, 'Reuben', 'Ap #908-9472 Donec St.', 'Vottem', '33438', '08 21 61 02 45', 'a@amet.edu', 'tristique neque', 0, 0, 'egestas', NULL),
(77, 'Owen', 'Ap #556-2593 Consectetuer Street', 'Peine', '60727', '04 50 94 02 22', 'Nam@consectetuerrhoncus.net', 'sociosqu ad', 1, 0, 'Vivamus', NULL),
(78, 'Nash', '5332 Porttitor Street', 'Metro', '27697', '04 75 87 75 25', 'accumsan.convallis.ante@Suspendissealiquetsem.net', 'luctus vulputate,', 1, 0, 'id', NULL),
(79, 'Quinlan', 'Ap #538-6596 Non Av.', 'Püttlingen', '67606', '07 70 90 93 36', 'Proin@velquam.com', 'condimentum eget,', 0, 0, 'pede.', NULL),
(80, 'Mufutau', 'P.O. Box 205, 4084 Aenean Avenue', 'Casoli', 'X3G 0Z8', '06 96 62 76 44', 'Nullam.suscipit@loremipsum.net', 'vestibulum. Mauris', 1, 0, 'imperdiet,', NULL),
(81, 'Baxter', '711-7764 Arcu. Rd.', 'Katsina', '185571', '08 15 92 68 71', 'Vestibulum.ut@nonlorem.net', 'dolor. Fusce', 1, 1, 'tellus', NULL),
(82, 'Levi', 'Ap #976-6964 Mollis Street', 'Forchies-la-Marche', '880623', '02 90 95 47 21', 'Sed@dolor.co.uk', 'interdum ligula', 1, 0, 'Donec', NULL),
(83, 'Herman', 'P.O. Box 996, 6997 Ut Street', 'Barrie', '37324', '06 95 95 50 57', 'pharetra.felis.eget@ut.co.uk', 'quam. Pellentesque', 1, 0, 'placerat,', NULL),
(84, 'Carter', '2940 Ipsum Rd.', 'Rapone', '00991', '09 15 41 02 12', 'Phasellus.fermentum@magnisdis.edu', 'adipiscing non,', 1, 0, 'ac', NULL),
(85, 'Talon', 'P.O. Box 335, 3078 Sed Rd.', 'Forst', '56913', '04 60 17 95 89', 'amet.consectetuer@MaurisnullaInteger.ca', 'Etiam bibendum', 1, 1, 'congue.', NULL),
(86, 'Reed', '162-7399 Phasellus Rd.', 'Castello Tesino', '78110', '01 47 94 99 92', 'Integer.urna.Vivamus@vulputateeu.edu', 'Maecenas ornare', 1, 0, 'dictum', NULL),
(87, 'Tate', '944-1674 Phasellus Rd.', 'Makurdi', '371237', '02 02 83 80 44', 'lacus.Aliquam@maurisidsapien.com', 'molestie tortor', 0, 1, 'ligula', NULL),
(88, 'Daquan', '7827 Tellus Ave', 'Gosselies', '63033-18906', '02 27 51 63 30', 'Morbi@ipsum.net', 'lobortis quis,', 0, 1, 'urna', NULL),
(89, 'Tiger', 'P.O. Box 760, 9034 Eleifend. Street', 'Rocca d\'Arce', '95701', '01 81 36 98 83', 'feugiat@semeget.com', 'mollis. Duis', 0, 1, 'ut,', NULL),
(91, 'Burton', '609-6476 Ut Street', 'Christchurch', '9376', '09 91 07 35 18', 'aliquam@non.edu', 'vulputate ullamcorper', 0, 1, 'consectetuer', NULL),
(92, 'Ishmael', 'Ap #939-7516 Cursus. Avenue', 'Miramichi', '29466', '07 95 08 31 24', 'non@gravidanon.ca', 'magna. Praesent', 0, 1, 'elit,', NULL),
(93, 'Ian', '755-5871 Libero Street', 'Andalo', '67819', '04 67 92 27 86', 'sed@mollisvitae.ca', 'vel, mauris.', 1, 1, 'feugiat.', NULL),
(94, 'Leo', '1438 Lorem Rd.', 'Nemoli', '839479', '07 49 16 17 90', 'pede.et.risus@accumsansed.edu', 'vitae risus.', 0, 0, 'Cras', NULL),
(95, 'Julian', 'P.O. Box 566, 6985 Porttitor Road', 'Rae-Edzo', '933198', '01 37 03 92 56', 'Sed@gravida.edu', 'ullamcorper magna.', 1, 0, 'sodales', NULL),
(96, 'Coby', '786-5852 A Avenue', 'Hall in Tirol', '65879', '04 28 30 14 08', 'vitae.erat@aliquet.net', 'quam vel', 0, 0, 'accumsan', NULL),
(97, 'Louis', 'P.O. Box 894, 2796 Ornare, Av.', 'Giove', '45764', '03 61 28 01 12', 'tempor.diam.dictum@nonegestas.org', 'porttitor tellus', 0, 1, 'rhoncus.', NULL),
(98, 'Adam', 'Ap #756-3279 Hendrerit St.', 'Krasnoarmeysk', '416186', '09 31 54 18 88', 'magna.Suspendisse@auctornonfeugiat.co.uk', 'scelerisque neque', 1, 1, 'ante.', NULL),
(99, 'Palmer', 'P.O. Box 216, 2775 Nunc Ave', 'Ballarat', '238919', '04 78 93 32 33', 'Curabitur.vel.lectus@utmiDuis.org', 'dictum placerat,', 0, 1, 'consectetuer', NULL),
(100, 'Abbot', 'P.O. Box 957, 7376 Sem Avenue', 'Lauregno/Laurein', '1124', '08 00 33 93 06', 'In.at.pede@cubilia.net', 'dui. Fusce', 0, 0, 'elit.', NULL),
(101, 'Denton', 'Ap #703-8551 Ac Street', 'Huntsville', '10315', '04 86 97 78 42', 'vel@utlacusNulla.edu', 'lacus. Nulla', 1, 0, 'sociis', NULL),
(102, 'Lawrence', 'Ap #648-9250 Ac Road', 'Vellore', '60088', '06 93 01 00 74', 'sed.leo@nisi.ca', 'pede et', 1, 1, 'senectus', NULL),
(103, 'Gannon', '4858 Urna St.', 'Pau', '11702', '08 66 85 24 07', 'volutpat@eueratsemper.org', 'nisl. Nulla', 0, 0, 'Fusce', NULL),
(104, 'Ulysses', 'Ap #385-7420 A Ave', 'Montleban', '20116', '08 66 11 62 36', 'pellentesque@Etiamligula.org', 'at pretium', 1, 1, 'dictum', NULL),
(105, 'Zachary', '736-4960 Pede. Rd.', 'Windermere', 'P1G 3X9', '07 52 50 30 18', 'nec.luctus.felis@vulputaterisusa.com', 'vitae mauris', 1, 0, 'quis', NULL),
(106, 'Julian', 'Ap #313-7552 At Road', 'Port Pirie', '053214', '04 79 97 91 31', 'lobortis.ultrices.Vivamus@adipiscing.org', 'ornare egestas', 0, 0, 'Sed', NULL),
(107, 'Nicholas', '254-8812 Quam. Rd.', 'Morrovalle', '918758', '09 67 01 21 90', 'ac@pede.org', 'id risus', 1, 0, 'enim', NULL),
(108, 'Jesse', 'P.O. Box 545, 5006 Etiam Rd.', 'Spresiano', '5514', '04 09 80 11 79', 'Proin@temporarcu.org', 'pede. Praesent', 1, 1, 'elit,', NULL),
(109, 'Eagan', 'P.O. Box 232, 8279 Dui, Avenue', 'Lacombe', 'M4W 4W3', '02 19 34 88 92', 'Donec.fringilla.Donec@eu.co.uk', 'lorem fringilla', 0, 0, 'malesuada', NULL),
(110, 'Abel', 'Ap #747-3714 Donec Rd.', 'Mackay', '14482-85659', '08 67 19 76 00', 'mauris.aliquam.eu@a.org', 'pretium aliquet,', 0, 0, 'cursus.', NULL),
(111, 'Hop', '149-2575 Ipsum Street', 'Llandrindod Wells', '03371', '08 19 42 23 24', 'Integer.aliquam.adipiscing@eratVivamus.com', 'Donec dignissim', 0, 1, 'imperdiet', NULL),
(112, 'Gage', 'P.O. Box 774, 9717 Vivamus Road', 'Nanaimo', '39157-005', '06 11 30 94 87', 'elementum.purus.accumsan@CuraePhasellus.ca', 'Suspendisse non', 0, 1, 'luctus', NULL),
(113, 'Rafael', '8302 Vitae Avenue', 'Noorderwijk', '59439', '05 90 72 24 62', 'auctor.Mauris.vel@sociisnatoque.net', 'arcu. Sed', 0, 0, 'diam', NULL),
(114, 'Lionel', 'Ap #466-558 Consectetuer St.', 'Vichy', '3862', '02 67 41 20 52', 'ridiculus.mus@etarcu.net', 'varius. Nam', 1, 1, 'dui.', NULL),
(115, 'Conan', 'P.O. Box 173, 7228 Proin Ave', 'Moere', '45734', '06 50 92 48 83', 'lacinia@cursusinhendrerit.org', 'mi lacinia', 0, 1, 'nulla.', NULL),
(116, 'Lucian', 'P.O. Box 270, 3304 Vitae Ave', 'Thanjavur', 'Z6414', '01 06 95 93 84', 'elit.a.feugiat@elementum.net', 'hendrerit id,', 0, 1, 'magna', NULL),
(117, 'Raphael', 'P.O. Box 496, 7646 Id Av.', 'Boston', '681319', '03 93 23 64 55', 'et.netus@enimEtiamimperdiet.net', 'vel, faucibus', 0, 1, 'Vivamus', NULL),
(118, 'Henry', 'P.O. Box 404, 3090 Nunc St.', 'Langenhagen', 'Z9889', '03 56 57 52 13', 'Suspendisse.sed.dolor@semconsequat.ca', 'dolor egestas', 0, 1, 'pede.', NULL),
(119, 'Bernard', '850-2352 Dictum. Road', 'Chiguayante', '7106', '07 37 26 94 90', 'dui.augue@hymenaeosMauris.co.uk', 'Vivamus sit', 1, 1, 'velit.', NULL);

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
(1, 67, 1);

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
(1, 67, 1),
(2, 67, 2),
(3, 67, 2),
(4, 67, 2),
(5, 67, 1),
(6, 67, 3);

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
(1, 106, 86),
(2, 97, 99),
(3, 22, 45),
(4, 49, 66),
(5, 116, 12),
(6, 79, 92),
(7, 69, 2),
(8, 103, 98),
(9, 105, 18),
(10, 67, 105),
(11, 94, 11),
(12, 112, 105),
(13, 70, 109),
(14, 48, 98),
(15, 104, 94),
(16, 40, 106),
(17, 92, 80),
(18, 89, 16),
(19, 66, 21),
(20, 95, 57),
(21, 76, 13),
(22, 47, 47),
(23, 108, 106),
(24, 24, 12),
(25, 67, 15),
(26, 94, 62),
(27, 62, 31),
(28, 118, 53),
(29, 100, 38),
(30, 64, 52),
(31, 67, 111),
(32, 59, 89),
(33, 67, 64),
(34, 67, 99),
(35, 64, 59),
(36, 47, 7),
(37, 52, 6),
(38, 63, 55),
(39, 40, 11),
(40, 87, 44),
(41, 22, 45),
(42, 22, 92),
(43, 22, 45),
(44, 22, 45);

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
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=26;

--
-- AUTO_INCREMENT for table `Message`
--
ALTER TABLE `Message`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `notes`
--
ALTER TABLE `notes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `plat`
--
ALTER TABLE `plat`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `plat_ingredient`
--
ALTER TABLE `plat_ingredient`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `reservation`
--
ALTER TABLE `reservation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=112;

--
-- AUTO_INCREMENT for table `restaurant`
--
ALTER TABLE `restaurant`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=120;

--
-- AUTO_INCREMENT for table `restaurant_message`
--
ALTER TABLE `restaurant_message`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT for table `restaurant_note`
--
ALTER TABLE `restaurant_note`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `restaurant_reservation`
--
ALTER TABLE `restaurant_reservation`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=45;

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
