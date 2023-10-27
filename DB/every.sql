-- phpMyAdmin SQL Dump
-- version 5.1.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Oct 24, 2023 at 11:28 AM
-- Server version: 8.0.27
-- PHP Version: 7.4.26

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `every`
--

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

use every;

DROP TABLE IF EXISTS `customer`;
CREATE TABLE IF NOT EXISTS `customer` (
  `customer_id` varchar(6) NOT NULL,
  `name` char(100) DEFAULT NULL,
  `email` varchar(150) DEFAULT NULL,
  `shopname` varchar(100) DEFAULT NULL,
  `contact_number` varchar(10) DEFAULT NULL,
  `type` char(20) DEFAULT NULL,
  `date_of_birthday` date DEFAULT NULL,
  PRIMARY KEY (`customer_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
CREATE TABLE IF NOT EXISTS `employee` (
  `employee_id` varchar(6) NOT NULL,
  `name` char(100) DEFAULT NULL,
  `email` varchar(150) NOT NULL,
  `contact_number` varchar(10) NOT NULL,
  `type` char(20) NOT NULL,
  `date_of_birthday` date NOT NULL,
  PRIMARY KEY (`employee_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `expensess`
--

DROP TABLE IF EXISTS `expensess`;
CREATE TABLE IF NOT EXISTS `expensess` (
  `ex_id` varchar(6) NOT NULL,
  `description` char(200) NOT NULL,
  `amount` double NOT NULL,
  `type` char(10) NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`ex_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `income`
--

DROP TABLE IF EXISTS `income`;
CREATE TABLE IF NOT EXISTS `income` (
  `income_id` varchar(6) NOT NULL,
  `description` char(200) NOT NULL,
  `amount` double NOT NULL,
  `date` date NOT NULL,
  PRIMARY KEY (`income_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `invoice`
--

DROP TABLE IF EXISTS `invoice`;
CREATE TABLE IF NOT EXISTS `invoice` (
  `invoice_id` varchar(6) NOT NULL,
  `type` char(100) NOT NULL,
  `date` date NOT NULL,
  `description` char(200) NOT NULL,
  `invoice_file` longblob NOT NULL,
  PRIMARY KEY (`invoice_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
CREATE TABLE IF NOT EXISTS `item` (
  `item_id` varchar(6) NOT NULL,
  `name` char(100) NOT NULL,
  `description` varchar(200) NOT NULL,
  `available_countity` int NOT NULL,
  `item_price` double NOT NULL,
  `supplier_id` varchar(6) NOT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `item_sale`
--

DROP TABLE IF EXISTS `item_sale`;
CREATE TABLE IF NOT EXISTS `item_sale` (
  `item_id` varchar(6) NOT NULL,
  `customer_id` varchar(6) NOT NULL,
  `date` date NOT NULL,
  `amount` double NOT NULL,
  `countity` int NOT NULL,
  PRIMARY KEY (`item_id`,`customer_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `item_supply`
--

DROP TABLE IF EXISTS `item_supply`;
CREATE TABLE IF NOT EXISTS `item_supply` (
  `item_id` varchar(6) NOT NULL,
  `supplier_id` varchar(6) NOT NULL,
  `date` date NOT NULL,
  `amount` double NOT NULL,
  `countity` int NOT NULL,
  PRIMARY KEY (`item_id`,`supplier_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `purchase_return`
--

DROP TABLE IF EXISTS `purchase_return`;
CREATE TABLE IF NOT EXISTS `purchase_return` (
  `item_id` varchar(6) NOT NULL,
  `supplier_id` varchar(6) NOT NULL,
  `date` date NOT NULL,
  `amount` double NOT NULL,
  `countity` int NOT NULL,
  PRIMARY KEY (`item_id`,`supplier_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `report`
--

DROP TABLE IF EXISTS `report`;
CREATE TABLE IF NOT EXISTS `report` (
  `report_id` varchar(6) NOT NULL,
  `date` date NOT NULL,
  `description` char(200) NOT NULL,
  `type` char(20) NOT NULL,
  `report_file` longblob NOT NULL,
  PRIMARY KEY (`report_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `sales_return`
--

DROP TABLE IF EXISTS `sales_return`;
CREATE TABLE IF NOT EXISTS `sales_return` (
  `item_id` varchar(6) NOT NULL,
  `customer_id` varchar(6) NOT NULL,
  `date` date NOT NULL,
  `amounr` double NOT NULL,
  `countity` int NOT NULL,
  PRIMARY KEY (`item_id`,`customer_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- --------------------------------------------------------

--
-- Table structure for table `supplier`
--

DROP TABLE IF EXISTS `supplier`;
CREATE TABLE IF NOT EXISTS `supplier` (
  `supplier_id` varchar(6) NOT NULL,
  `company_name` char(200) NOT NULL,
  `company_mail` varchar(200) NOT NULL,
  `contact_numer` varchar(10) NOT NULL,
  PRIMARY KEY (`supplier_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;



use every;


ALTER TABLE item ADD FOREIGN KEY (supplier_id) references supplier(supplier_id);

ALTER TABLE item_supply ADD FOREIGN KEY (item_id) references item(item_id);
ALTER TABLE item_supply ADD FOREIGN KEY (supplier_id) references supplier(supplier_id);

ALTER TABLE item_sale ADD FOREIGN KEY (item_id) references item(item_id);
ALTER TABLE item_sale ADD FOREIGN KEY (customer_id) references customer(customer_id);

ALTER TABLE sales_return ADD FOREIGN KEY (item_id) references item(item_id);
ALTER TABLE sales_return ADD FOREIGN KEY (customer_id) references customer(customer_id);

ALTER TABLE purchase_return ADD FOREIGN KEY (item_id) references item(item_id);
ALTER TABLE purchase_return ADD FOREIGN KEY (supplier_id) references supplier(supplier_id);

