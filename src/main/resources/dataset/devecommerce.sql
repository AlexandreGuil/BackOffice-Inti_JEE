SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";

--
-- Base de données: `devecommerce`
--
CREATE DATABASE IF NOT EXISTS `devecommerce` DEFAULT CHARACTER SET latin1 COLLATE latin1_swedish_ci;
USE `devecommerce`;

-- --------------------------------------------------------

--
-- Structure de la table `categorie`
--

CREATE TABLE IF NOT EXISTS `categorie` (
  `categorie_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `photo` tinyblob,
  `description` varchar(255) DEFAULT NULL,
  `designation` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`categorie_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=6 ;

--
-- Contenu de la table `categorie`
--

INSERT INTO `categorie` (`categorie_id`, `photo`, `description`, `designation`) VALUES
(1, NULL, 'laptop de toute marque et de tout systeme d''exploitation', 'laptop'),
(2, NULL, 'Smart phone for speak with all your friends', 'smart-phone'),
(3, NULL, 'tablette multimedia tactile ', 'tablette'),
(4, NULL, 'materialle infromatique pour maximiser les perf de vos machine', 'infrimatic material'),
(5, NULL, 'ecouteurs multimadia', 'headphones');

-- --------------------------------------------------------

--
-- Structure de la table `client`
--

CREATE TABLE IF NOT EXISTS `client` (
  `client_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `adresse` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `nom_client` varchar(255) DEFAULT NULL,
  `numerot_telephone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`client_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `commande`
--

CREATE TABLE IF NOT EXISTS `commande` (
  `commande_id` bigint(20) NOT NULL,
  `date_commande` datetime DEFAULT NULL,
  `id_client` bigint(20) DEFAULT NULL,
  `client_fk` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`commande_id`),
  KEY `FKfh667737scbwrhtkephs23hq` (`id_client`),
  KEY `FK7wa46dao6r8qt0qt1m2haw2e1` (`client_fk`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Structure de la table `ligne_de_commande`
--

CREATE TABLE IF NOT EXISTS `ligne_de_commande` (
  `ligne_commande_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `prix` double DEFAULT NULL,
  `quantite` int(11) DEFAULT NULL,
  `commande_id` bigint(20) DEFAULT NULL,
  `produit_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`ligne_commande_id`),
  KEY `FKfv205o8aatlnoylt01artdlh6` (`commande_id`),
  KEY `FKki2djb68g804n4coovhjrx6sq` (`produit_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `produit`
--

CREATE TABLE IF NOT EXISTS `produit` (
  `produit_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) DEFAULT NULL,
  `designation` varchar(255) DEFAULT NULL,
  `photo` varchar(255) DEFAULT NULL,
  `prix` double DEFAULT NULL,
  `quantite` int(11) DEFAULT NULL,
  `selectione` bit(1) DEFAULT NULL,
  `categorie_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`produit_id`),
  KEY `FK52xhp55kbbl6u4rbluxm3g9hw` (`categorie_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=62 ;

--
-- Contenu de la table `produit`
--

INSERT INTO `produit` (`produit_id`, `description`, `designation`, `photo`, `prix`, `quantite`, `selectione`, `categorie_id`) VALUES
(1, 'The ultimate pro notebook. MacBook Pro features faster processors ;upgraded memory;the Apple T2 chip;and a Retina display with True Tone technology.', 'Macbook Pro (2017)', 'src/img/image1.jpg', 1299, 3, b'1', 1),
(2, 'The iPhone X display is so immersive the device itself disappears into the experience.', 'Iphone X', 'src/img/image2.jpg', 799, 5, b'0', 2),
(33, 'The ultimate pro notebook. MacBook Pro features faster processors ;upgraded memory;the Apple T2 chip;and a Retina display with True Tone technology.', 'Macbook Pro (2017)', '/img/photo.jpg', 2199, 2, b'0', 1),
(34, 'MacBook Air lasts up to an incredible 12 hours between charges So from your morning coffee till your evening commute;you can work unplugged. When itís time to kick back and relax;you can get up to 12 hours of iTunes movie playback.', 'Macbook Air (2015) ', '/img/photo.jpg', 999, 1, b'0', 1),
(35, 'MacBook Air lasts up to an incredible 12 hours between charges So from your morning coffee till your evening commute;you can work unplugged. When itís time to kick back and relax;you can get up to 12 hours of iTunes movie playback.', 'Macbook Air (2015) ', '/img/photo.jpg', 1099, 4, b'0', 1),
(36, 'The iPhone X display is so immersive the device itself disappears into the experience. ', 'Iphone X', '/img/photo.jpg', 799, 5, b'0', 2),
(37, 'The iPhone X display is so immersive the device itself disappears into the experience. ', 'Iphone X', '/img/photo.jpg', 899, 7, b'0', 2),
(38, 'Great connectivity of this device includes Bluetooth 4.2 version with A2DP', 'Iphone 7', '/img/photo.jpg', 399, 8, b'0', 2),
(39, 'Great connectivity of this device includes Bluetooth 4.2 version with A2DP', 'Iphone 7', '/img/photo.jpg', 499, 9, b'0', 2),
(40, 'iPhone 8 introduces a glass design. The glass back enables easy wireless charging.', 'Iphone 8', '/img/photo.jpg', 599, 4, b'0', 2),
(41, 'iPhone 8 introduces a glass design. The glass back enables easy wireless charging.', 'Iphone 8', '/img/photo.jpg', 699, 7, b'0', 2),
(42, '4th gen The iPad Air is unbelievably thin and light. And yet it is so much more powerful and capable', 'Ipad Air', '/img/photo.jpg', 899, 20, b'0', 3),
(43, '4th gen The iPad Air is unbelievably thin and light. And yet it is so much more powerful and capable', 'Ipad Air', '/img/photo.jpg', 999, 9, b'0', 3),
(44, '3th gen Everything you love about iPad ó the beautiful screen and fast', 'Ipad Mini 3th gen', '/img/photo.jpg', 499, 40, b'0', 3),
(45, '3th gen Everything you love about iPad ó the beautiful screen and fast', 'Ipad Mini 3th gen', '/img/photo.jpg', 599, 100, b'0', 3),
(46, 'G3 High-density GPU server with hybrid computing power. ASUS-patented Adaptable Topology design.', 'ESC8000 G3', '/img/photo.jpg', 650, 4, b'0', 4),
(47, 'G3 High-density GPU server with hybrid computing power. ASUS-patented Adaptable Topology design.', 'ESC8000 G3', '/img/photo.jpg', 750, 6, b'0', 4),
(48, 'G4 High performance ASUS 2U server with hybrid-storage design and high power-efficiency', 'ESC8000 G4', '/img/photo.jpg', 450, 1, b'0', 4),
(49, 'G4 High performance ASUS 2U server with hybrid-storage design and high power-efficiency', 'ESC8000 G4', '/img/photo.jpg', 550, 2, b'0', 4),
(50, 'Thinner and more powerful than ever the Dell XPS reinforces its lofty standing with an 8th Gen Intel Core processor immaculate 4K UHD display, and super-slim build.', 'XPS 13 - 5080', '/img/photo.jpg', 1250, 7, b'0', 4),
(51, 'Thinner and more powerful than ever the Dell XPS reinforces its lofty standing with an 8th Gen Intel Core processor immaculate 4K UHD display, and super-slim build.', 'XPS 13 - 5080', '/img/photo.jpg', 1650, 1, b'0', 4),
(52, 'Ultra-thin and distinctly refined the stylish Dell Inspiron gives definitive elegance to a powerful and expansive PC experience.', 'XPS 15 - 5070', '/img/photo.jpg', 600, 10, b'0', 4),
(53, 'Ultra-thin and distinctly refined the stylish Dell Inspiron gives definitive elegance to a powerful and expansive PC experience.', 'XPS 15 - 5070', '/img/photo.jpg', 700, 50, b'0', 4),
(54, 'The Monoprice Ultra Slim Active High Speed HDMI Cable series is designed with the thinnest TVs in mind', 'Monoprice Ultra Slim Series High Speed HDMI Cable', '/img/photo.jpg', 15, 40, b'0', 4),
(55, 'The Monoprice Ultra Slim Active High Speed HDMI Cable series is designed with the thinnest TVs in mind', 'Monoprice Ultra Slim Series High Speed HDMI Cable', '/img/photo.jpg', 25, 30, b'0', 4),
(56, 'Monoprice Commercial Cable supports the following HDMI features: 4K resolution at 24Hz. 3D video. ', 'Monoprice Ultra Slim Series High Speed HDMI Cable - 4K', '/img/photo.jpg', 10, 1, b'0', 4),
(57, 'Monoprice Commercial Cable supports the following HDMI features: 4K resolution at 24Hz. 3D video. ', 'Monoprice Ultra Slim Series High Speed HDMI Cable - 4K', '/img/photo.jpg', 20, 10, b'0', 4),
(58, 'Avantree HT3189 Wireless Headphones for TV Watching & PC Gaming with Bluetooth', 'Avantree HT3189 Wireless Headphones', '/img/photo.jpg', 250, 1, b'0', 5),
(59, 'Avantree HT3189 Wireless Headphones for TV Watching & PC Gaming with Bluetooth', 'Avantree HT3189 Wireless Headphones', '/img/photo.jpg', 350, 20, b'0', 5),
(60, 'Active Noise Cancelling Headphone Bluetooth Headphones with Microphone Hi-Fi Deep Bass Wireless Headphones Over Ear 30H Playtime for Travel Work TV Computer Phone', 'COWIN E7 PRO', '/img/photo.jpg', 800, 9, b'0', 5),
(61, 'Active Noise Cancelling Headphone Bluetooth Headphones with Microphone Hi-Fi Deep Bass Wireless Headphones Over Ear 30H Playtime for Travel Work TV Computer Phone', 'COWIN E7 PRO', '/img/photo.jpg', 900, 60, b'0', 5);

-- --------------------------------------------------------

--
-- Structure de la table `role`
--

CREATE TABLE IF NOT EXISTS `role` (
  `role_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `nom_role` varchar(255) DEFAULT NULL,
  `utilisateur_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`role_id`),
  KEY `FKj6fh2p1i1sgn94qyea34jqcy7` (`utilisateur_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1 AUTO_INCREMENT=1 ;

-- --------------------------------------------------------

--
-- Structure de la table `utilisateur`
--

CREATE TABLE IF NOT EXISTS `utilisateur` (
  `utilisateur_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `actif` bit(1) DEFAULT NULL,
  `mot_de_passe` varchar(255) DEFAULT NULL,
  `nom_utilisateur` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`utilisateur_id`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=17 ;

--
-- Contenu de la table `utilisateur`
--

INSERT INTO `utilisateur` (`utilisateur_id`, `actif`, `mot_de_passe`, `nom_utilisateur`) VALUES
(1, b'0', NULL, NULL),
(2, b'0', NULL, NULL),
(3, b'0', NULL, NULL),
(4, b'0', NULL, NULL),
(5, b'0', NULL, NULL),
(6, b'0', NULL, NULL),
(7, b'0', NULL, NULL),
(8, b'0', NULL, NULL),
(9, b'0', NULL, NULL),
(10, b'0', NULL, NULL),
(11, b'0', NULL, NULL),
(12, b'0', NULL, NULL),
(13, b'0', NULL, NULL),
(14, b'0', NULL, NULL),
(15, b'0', NULL, NULL),
(16, b'0', NULL, NULL);

--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `commande`
--
ALTER TABLE `commande`
  ADD CONSTRAINT `FK7wa46dao6r8qt0qt1m2haw2e1` FOREIGN KEY (`client_fk`) REFERENCES `client` (`client_id`),
  ADD CONSTRAINT `FKfh667737scbwrhtkephs23hq` FOREIGN KEY (`id_client`) REFERENCES `client` (`client_id`);

--
-- Contraintes pour la table `ligne_de_commande`
--
ALTER TABLE `ligne_de_commande`
  ADD CONSTRAINT `FKki2djb68g804n4coovhjrx6sq` FOREIGN KEY (`produit_id`) REFERENCES `produit` (`produit_id`),
  ADD CONSTRAINT `FKfv205o8aatlnoylt01artdlh6` FOREIGN KEY (`commande_id`) REFERENCES `commande` (`commande_id`);

--
-- Contraintes pour la table `produit`
--
ALTER TABLE `produit`
  ADD CONSTRAINT `FK52xhp55kbbl6u4rbluxm3g9hw` FOREIGN KEY (`categorie_id`) REFERENCES `categorie` (`categorie_id`);

--
-- Contraintes pour la table `role`
--
ALTER TABLE `role`
  ADD CONSTRAINT `FKj6fh2p1i1sgn94qyea34jqcy7` FOREIGN KEY (`utilisateur_id`) REFERENCES `utilisateur` (`utilisateur_id`);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
