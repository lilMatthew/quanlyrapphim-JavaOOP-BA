-- --------------------------------------------------------
-- Máy chủ:                      127.0.0.1
-- Server version:               10.4.24-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Phiên bản:           12.5.0.6677
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;


-- Dumping database structure for quanlyrapphim
CREATE DATABASE IF NOT EXISTS `quanlyrapphim` /*!40100 DEFAULT CHARACTER SET utf8mb4 */;
USE `quanlyrapphim`;

-- Dumping structure for table quanlyrapphim.hoadon
CREATE TABLE IF NOT EXISTS `hoadon` (
  `mahoadon` int(11) NOT NULL AUTO_INCREMENT,
  `tenphim` varchar(200) NOT NULL,
  `sobong` int(11) NOT NULL,
  `sonuoc` int(11) NOT NULL,
  `sove` int(11) NOT NULL,
  `tongtien` float NOT NULL,
  `vitrighe` varchar(50) NOT NULL,
  `tenrap` varchar(50) NOT NULL,
  PRIMARY KEY (`mahoadon`),
  KEY `tenphim` (`tenphim`)
) ENGINE=InnoDB AUTO_INCREMENT=124 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table quanlyrapphim.hoadon: ~4 rows (approximately)
DELETE FROM `hoadon`;
INSERT INTO `hoadon` (`mahoadon`, `tenphim`, `sobong`, `sonuoc`, `sove`, `tongtien`, `vitrighe`, `tenrap`) VALUES
	(1, 'latmat', 1, 2, 1, 200000, 'A1', '2'),
	(2, 'connan', 2, 2, 3, 150000, 'A2', '3'),
	(3, 'doraemon', 1, 1, 1, 150000, 'A1', '4'),
	(4, 'doraemon', 1, 3, 3, 350000, 'E2', '3');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
