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

-- Dumping structure for table quanlyrapphim.khachhang
CREATE TABLE IF NOT EXISTS `khachhang` (
  `makhachhang` int(11) NOT NULL AUTO_INCREMENT,
  `tenkhachhang` varchar(100) DEFAULT NULL,
  `namsinh` int(11) NOT NULL,
  `sdt` int(11) unsigned NOT NULL,
  PRIMARY KEY (`makhachhang`)
) ENGINE=InnoDB AUTO_INCREMENT=235 DEFAULT CHARSET=utf8mb4;

-- Dumping data for table quanlyrapphim.khachhang: ~4 rows (approximately)
DELETE FROM `khachhang`;
INSERT INTO `khachhang` (`makhachhang`, `tenkhachhang`, `namsinh`, `sdt`) VALUES
	(1, 'nguyen tan tra', 2002, 93939393),
	(2, 'Đỗ việt thành ', 2004, 202292),
	(3, 'haison', 1975, 123),
	(123, 'hải sơn', 1970, 976),
	(234, '234', 1970, 987);

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
