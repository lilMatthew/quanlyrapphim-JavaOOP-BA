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

-- Dumping structure for table quanlyrapphim.phim
CREATE TABLE IF NOT EXISTS `phim` (
  `tenphim` varchar(100) NOT NULL,
  `ngaychieu` int(11) NOT NULL DEFAULT 0,
  `thangchieu` int(11) NOT NULL DEFAULT 0,
  `namchieu` int(11) NOT NULL DEFAULT 0,
  `hangsanxuat` varchar(100) NOT NULL,
  `trangthai` varchar(50) NOT NULL,
  PRIMARY KEY (`tenphim`),
  KEY `tenphim` (`tenphim`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table quanlyrapphim.phim: ~6 rows (approximately)
DELETE FROM `phim`;
INSERT INTO `phim` (`tenphim`, `ngaychieu`, `thangchieu`, `namchieu`, `hangsanxuat`, `trangthai`) VALUES
	('abc', 1, 1, 1990, 'xyz', 'sắp chiếu'),
	('conan', 13, 6, 2023, 'japan', 'đang chiếu '),
	('doraemon', 23, 6, 2023, 'japan', 'đang chiếu'),
	('fast and forious', 6, 6, 2023, 'american', 'đang chiếu'),
	('latmat', 20, 6, 2023, 'việt nam', 'đang chiếu');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
