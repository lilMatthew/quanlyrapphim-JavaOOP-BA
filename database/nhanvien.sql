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

-- Dumping structure for table quanlyrapphim.nhanvien
CREATE TABLE IF NOT EXISTS `nhanvien` (
  `manhanvien` int(11) NOT NULL,
  `tennhanvien` varchar(100) NOT NULL,
  `ngaysinh` int(11) DEFAULT NULL,
  `thangsinh` int(11) DEFAULT NULL,
  `namsinh` int(11) DEFAULT NULL,
  `chucvu` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`manhanvien`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- Dumping data for table quanlyrapphim.nhanvien: ~2 rows (approximately)
DELETE FROM `nhanvien`;
INSERT INTO `nhanvien` (`manhanvien`, `tennhanvien`, `ngaysinh`, `thangsinh`, `namsinh`, `chucvu`) VALUES
	(1, 'nguyễn hữu thắng ', 30, 12, 2003, 'giám đốc '),
	(2, 'Đỗ việt thành ', 23, 6, 2004, 'nhân viên'),
	(3, 'nguyễn hữu thắng', 1, 1, 1970, 'giám đốc');

/*!40103 SET TIME_ZONE=IFNULL(@OLD_TIME_ZONE, 'system') */;
/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IFNULL(@OLD_FOREIGN_KEY_CHECKS, 1) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40111 SET SQL_NOTES=IFNULL(@OLD_SQL_NOTES, 1) */;
