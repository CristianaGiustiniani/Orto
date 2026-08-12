-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema orto
-- -----------------------------------------------------
DROP SCHEMA IF EXISTS `orto` ;

-- -----------------------------------------------------
-- Schema orto
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `orto` DEFAULT CHARACTER SET utf8 ;
USE `orto` ;

-- -----------------------------------------------------
-- Table `orto`.`Seller`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `orto`.`Seller` ;

CREATE TABLE IF NOT EXISTS `orto`.`Seller` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `addressStreet` VARCHAR(45) NOT NULL,
  `addressNumber` VARCHAR(45) NOT NULL,
  `addressPostalCode` VARCHAR(45) NOT NULL,
  `addressCity` VARCHAR(45) NOT NULL,
  `addressProvince` VARCHAR(45) NOT NULL,
  `addressCountry` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) INVISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `orto`.`Product`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `orto`.`Product` ;

CREATE TABLE IF NOT EXISTS `orto`.`Product` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `seller` INT UNSIGNED NOT NULL,
  `description` VARCHAR(200) NULL,
  `price` DECIMAL(10,2) NOT NULL,
  `unit` ENUM('L', 'mL', 'kg', 'hg', 'g', 'piece', 'pack') NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `seller_idx` (`seller` ASC) VISIBLE,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  CONSTRAINT `product_seller`
    FOREIGN KEY (`seller`)
    REFERENCES `orto`.`Seller` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `orto`.`Buyer`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `orto`.`Buyer` ;

CREATE TABLE IF NOT EXISTS `orto`.`Buyer` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `username` VARCHAR(45) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `surname` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE,
  UNIQUE INDEX `email_UNIQUE` (`email` ASC) VISIBLE,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `orto`.`Order`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `orto`.`Order` ;

CREATE TABLE IF NOT EXISTS `orto`.`Order` (
  `id` INT UNSIGNED NOT NULL AUTO_INCREMENT,
  `buyer` INT UNSIGNED NOT NULL,
  `seller` INT UNSIGNED NOT NULL,
  `paymentType` ENUM('cash', 'online') NOT NULL,
  `paymentStatus` ENUM('successful', 'failed') NOT NULL,
  `totalPrice` DECIMAL(10,2) UNSIGNED NOT NULL,
  `created_at` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `status` ENUM("completed", "rejected", "pending") NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `seller_idx` (`seller` ASC) VISIBLE,
  INDEX `buyer_idx` (`buyer` ASC) VISIBLE,
  UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE,
  CONSTRAINT `order_buyer`
    FOREIGN KEY (`buyer`)
    REFERENCES `orto`.`Buyer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `order_seller`
    FOREIGN KEY (`seller`)
    REFERENCES `orto`.`Seller` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `orto`.`OrderLine`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `orto`.`OrderLine` ;

CREATE TABLE IF NOT EXISTS `orto`.`OrderLine` (
  `orderId` INT UNSIGNED NOT NULL,
  `productId` INT UNSIGNED NOT NULL,
  `quantity` DOUBLE NOT NULL,
  `annotation` VARCHAR(200) NULL,
  UNIQUE INDEX `UNIQUE` (`orderId` ASC, `productId` ASC) VISIBLE,
  INDEX `product_idx` (`productId` ASC) INVISIBLE,
  PRIMARY KEY (`productId`, `orderId`),
  CONSTRAINT `orderLine_product`
    FOREIGN KEY (`productId`)
    REFERENCES `orto`.`Product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `orderLine_order`
    FOREIGN KEY (`orderId`)
    REFERENCES `orto`.`Order` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `orto`.`Delivery`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `orto`.`Delivery` ;

CREATE TABLE IF NOT EXISTS `orto`.`Delivery` (
  `orderId` INT UNSIGNED NOT NULL,
  `type` ENUM('pickup', 'shipping') NOT NULL,
  `recipientName` VARCHAR(45) NULL,
  `recipientSurname` VARCHAR(45) NULL,
  `addressName` VARCHAR(45) NOT NULL,
  `addressNumber` VARCHAR(45) NOT NULL,
  `addressPostalCode` VARCHAR(45) NOT NULL,
  `addressCity` VARCHAR(45) NOT NULL,
  `addressProvince` VARCHAR(45) NOT NULL,
  `addressCountry` VARCHAR(45) NOT NULL,
  `phoneNumber` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`orderId`),
  UNIQUE INDEX `orderId_UNIQUE` (`orderId` ASC) VISIBLE,
  CONSTRAINT `delivery_order`
    FOREIGN KEY (`orderId`)
    REFERENCES `orto`.`Order` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `orto`.`OpeningHours`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `orto`.`OpeningHours` ;

CREATE TABLE IF NOT EXISTS `orto`.`OpeningHours` (
  `sellerId` INT UNSIGNED NOT NULL,
  `monOpening` TIME NOT NULL,
  `monClosing` TIME NOT NULL,
  `tueOpening` TIME NOT NULL,
  `tueClosing` TIME NOT NULL,
  `wedOpening` TIME NOT NULL,
  `wedClosing` TIME NOT NULL,
  `thuOpening` TIME NOT NULL,
  `thuClosing` TIME NOT NULL,
  `friOpening` TIME NOT NULL,
  `friClosing` TIME NOT NULL,
  `satOpening` TIME NOT NULL,
  `satClosing` TIME NOT NULL,
  `sunOpening` TIME NOT NULL,
  `sunClosing` TIME NOT NULL,
  PRIMARY KEY (`sellerId`),
  UNIQUE INDEX `sellerId_UNIQUE` (`sellerId` ASC) VISIBLE,
  CONSTRAINT `openingHours_seller`
    FOREIGN KEY (`sellerId`)
    REFERENCES `orto`.`Seller` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `orto`.`SellerProductType`
-- -----------------------------------------------------
DROP TABLE IF EXISTS `orto`.`SellerProductType` ;

CREATE TABLE IF NOT EXISTS `orto`.`SellerProductType` (
  `seller` INT UNSIGNED NOT NULL,
  `productType` ENUM('agricultural', 'animal', 'cleaning_cosmetics') NOT NULL,
  PRIMARY KEY (`seller`, `productType`),
  CONSTRAINT `sellerProductType_seller`
    FOREIGN KEY (`seller`)
    REFERENCES `orto`.`Seller` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Data for table `orto`.`Seller`
-- -----------------------------------------------------
START TRANSACTION;
USE `orto`;
INSERT INTO `orto`.`Seller` (`id`, `name`, `addressStreet`, `addressNumber`, `addressPostalCode`, `addressCity`, `addressProvince`, `addressCountry`) VALUES (1, 'Federico Bianchi', 'via roma', '12', '02033', 'Ginestra Sabina', 'Rieti', 'Italia');
INSERT INTO `orto`.`Seller` (`id`, `name`, `addressStreet`, `addressNumber`, `addressPostalCode`, `addressCity`, `addressProvince`, `addressCountry`) VALUES (2, 'La dispensa di Maria', 'via alessandro manzoni', '10', '02030', 'Casali di Poggio Nativo', 'Rieti', 'Italia');
INSERT INTO `orto`.`Seller` (`id`, `name`, `addressStreet`, `addressNumber`, `addressPostalCode`, `addressCity`, `addressProvince`, `addressCountry`) VALUES (3, 'Nonna Giovanna', 'via giacomo leopardi', '2a', '02038', 'Scandriglia', 'Rieti', 'Italia');
INSERT INTO `orto`.`Seller` (`id`, `name`, `addressStreet`, `addressNumber`, `addressPostalCode`, `addressCity`, `addressProvince`, `addressCountry`) VALUES (4, 'Fratelli Principessa', 'via santa liberata', '37', '02033', 'Monteleone Sabino', 'Rieti', 'Italia');
INSERT INTO `orto`.`Seller` (`id`, `name`, `addressStreet`, `addressNumber`, `addressPostalCode`, `addressCity`, `addressProvince`, `addressCountry`) VALUES (5, 'Charlotte Primicieri', 'via monteleone', '52', '02037', 'Poggio Moiano', 'Rieti', 'Italia');
INSERT INTO `orto`.`Seller` (`id`, `name`, `addressStreet`, `addressNumber`, `addressPostalCode`, `addressCity`, `addressProvince`, `addressCountry`) VALUES (6, 'Fabione', 'viale umberto i', '16b', '02032', 'Passo Corese', 'Rieti', 'Italia');
INSERT INTO `orto`.`Seller` (`id`, `name`, `addressStreet`, `addressNumber`, `addressPostalCode`, `addressCity`, `addressProvince`, `addressCountry`) VALUES (7, 'Eva Tomassi', 'via san martino', '23', '02030', 'Frasso Sabino', 'Rieti', 'Italia');
INSERT INTO `orto`.`Seller` (`id`, `name`, `addressStreet`, `addressNumber`, `addressPostalCode`, `addressCity`, `addressProvince`, `addressCountry`) VALUES (8, 'Francesco Aureli', 'vicolo primo', '1', '02035', 'Orvinio', 'Rieti', 'Italia');
INSERT INTO `orto`.`Seller` (`id`, `name`, `addressStreet`, `addressNumber`, `addressPostalCode`, `addressCity`, `addressProvince`, `addressCountry`) VALUES (9, 'Mirko Farinelli', 'via piana', '7', '02030', 'Pozzaglia Sabina', 'Rieti', 'Italia');
INSERT INTO `orto`.`Seller` (`id`, `name`, `addressStreet`, `addressNumber`, `addressPostalCode`, `addressCity`, `addressProvince`, `addressCountry`) VALUES (10, 'Pollajo', 'piazza dei re di roma', '5', '02030', 'Poggio Nativo', 'Rieti', 'Italia');

COMMIT;


-- -----------------------------------------------------
-- Data for table `orto`.`Product`
-- -----------------------------------------------------
START TRANSACTION;
USE `orto`;
INSERT INTO `orto`.`Product` (`id`, `name`, `seller`, `description`, `price`, `unit`) VALUES (1, 'Patata rossa', 1, NULL, 3, 'kg');
INSERT INTO `orto`.`Product` (`id`, `name`, `seller`, `description`, `price`, `unit`) VALUES (2, 'Yogurt all\'albicocca 125 gr in vetro', 1, 'Yogurt di latte vaccino con albicocche a pezzi', 1.50, 'piece');
INSERT INTO `orto`.`Product` (`id`, `name`, `seller`, `description`, `price`, `unit`) VALUES (3, 'Limoni', 2, 'Limoni medi biologici, circa 100 grammi l\'uno', 1, 'piece');
INSERT INTO `orto`.`Product` (`id`, `name`, `seller`, `description`, `price`, `unit`) VALUES (4, 'Burro cacao alla mandorla', 2, 'Con olio di mandorla', 5, 'piece');
INSERT INTO `orto`.`Product` (`id`, `name`, `seller`, `description`, `price`, `unit`) VALUES (5, 'Susine', 3, NULL, 4, 'kg');
INSERT INTO `orto`.`Product` (`id`, `name`, `seller`, `description`, `price`, `unit`) VALUES (6, 'Albicocche', 3, NULL, 5, 'kg');
INSERT INTO `orto`.`Product` (`id`, `name`, `seller`, `description`, `price`, `unit`) VALUES (7, 'Miele millefiori locale', 4, 'Mezzo kilo', 9.50, 'piece');
INSERT INTO `orto`.`Product` (`id`, `name`, `seller`, `description`, `price`, `unit`) VALUES (8, 'Nocciole sabine', 4, NULL, 30, 'kg');
INSERT INTO `orto`.`Product` (`id`, `name`, `seller`, `description`, `price`, `unit`) VALUES (9, 'Crema doposole alla camomilla', 5, 'Formato da 30 grammi. Per pelli sensibili e delicate', 6, 'piece');
INSERT INTO `orto`.`Product` (`id`, `name`, `seller`, `description`, `price`, `unit`) VALUES (10, 'Crema doposole all\'olio di oliva', 5, 'Formato da 30 grammi. Idratante e adatta a tutte le pelli', 6, 'piece');
INSERT INTO `orto`.`Product` (`id`, `name`, `seller`, `description`, `price`, `unit`) VALUES (11, 'Pancetta', 6, 'Circa 700 gr', 12, 'piece');
INSERT INTO `orto`.`Product` (`id`, `name`, `seller`, `description`, `price`, `unit`) VALUES (12, 'Uovo', 6, 'Un uovo medio', 1.20, 'piece');
INSERT INTO `orto`.`Product` (`id`, `name`, `seller`, `description`, `price`, `unit`) VALUES (13, 'Olio extravergine di oliva 5L', 7, 'Latta da 5L', 65, 'piece');
INSERT INTO `orto`.`Product` (`id`, `name`, `seller`, `description`, `price`, `unit`) VALUES (14, 'Olio extravergine di oliva 1L', 7, 'Bottiglia di vetro da 1L', 15, 'piece');
INSERT INTO `orto`.`Product` (`id`, `name`, `seller`, `description`, `price`, `unit`) VALUES (15, 'Sacchetto profumato alla lavanda', 8, 'Per profumare armadi e cassettiere', 4.50, 'piece');
INSERT INTO `orto`.`Product` (`id`, `name`, `seller`, `description`, `price`, `unit`) VALUES (16, 'Saponetta alla lavanda', 8, 'Per pelli delicate, 40 grammi', 4, 'piece');
INSERT INTO `orto`.`Product` (`id`, `name`, `seller`, `description`, `price`, `unit`) VALUES (17, 'Mele renette', 9, 'Senza trattamenti', 3, 'kg');
INSERT INTO `orto`.`Product` (`id`, `name`, `seller`, `description`, `price`, `unit`) VALUES (18, 'Salamella 300g', 9, 'Suino e spezie varie', 6, 'piece');
INSERT INTO `orto`.`Product` (`id`, `name`, `seller`, `description`, `price`, `unit`) VALUES (19, 'Petto di pollo', 10, 'Bio e bono vero, da polli ruspanti', 15, 'kg');
INSERT INTO `orto`.`Product` (`id`, `name`, `seller`, `description`, `price`, `unit`) VALUES (20, 'Cartone di uova', 10, 'Sei uova biologiche fresche fresche dalle nostre gallinelle belle belle', 9, 'pack');

COMMIT;

-- -----------------------------------------------------
-- Data for table `orto`.`OpeningHours`
-- -----------------------------------------------------
START TRANSACTION;
USE `orto`;
INSERT INTO `orto`.`OpeningHours` (`sellerId`, `monOpening`, `monClosing`, `tueOpening`, `tueClosing`, `wedOpening`, `wedClosing`, `thuOpening`, `thuClosing`, `friOpening`, `friClosing`, `satOpening`, `satClosing`, `sunOpening`, `sunClosing`) VALUES (1, '08:00', '18:00', '08:00', '18:00', '08:00', '18:00', '08:00', '18:00', '08:00', '18:00', '08:00', '18:00', '08:00', '18:00');
INSERT INTO `orto`.`OpeningHours` (`sellerId`, `monOpening`, `monClosing`, `tueOpening`, `tueClosing`, `wedOpening`, `wedClosing`, `thuOpening`, `thuClosing`, `friOpening`, `friClosing`, `satOpening`, `satClosing`, `sunOpening`, `sunClosing`) VALUES (2, '08:00', '18:00', '08:00', '18:00', '08:00', '18:00', '08:00', '18:00', '08:00', '18:00', '09:00', '17:00', '09:00', '14:00');
INSERT INTO `orto`.`OpeningHours` (`sellerId`, `monOpening`, `monClosing`, `tueOpening`, `tueClosing`, `wedOpening`, `wedClosing`, `thuOpening`, `thuClosing`, `friOpening`, `friClosing`, `satOpening`, `satClosing`, `sunOpening`, `sunClosing`) VALUES (3, '08:00', '18:00', '08:00', '18:00', '08:00', '18:00', '08:00', '18:00', '08:00', '18:00', '09:00', '17:00', '09:00', '14:00');
INSERT INTO `orto`.`OpeningHours` (`sellerId`, `monOpening`, `monClosing`, `tueOpening`, `tueClosing`, `wedOpening`, `wedClosing`, `thuOpening`, `thuClosing`, `friOpening`, `friClosing`, `satOpening`, `satClosing`, `sunOpening`, `sunClosing`) VALUES (4, '08:00', '18:00', '08:00', '18:00', '08:00', '18:00', '08:00', '18:00', '08:00', '18:00', '09:00', '17:00', '09:00', '14:00');
INSERT INTO `orto`.`OpeningHours` (`sellerId`, `monOpening`, `monClosing`, `tueOpening`, `tueClosing`, `wedOpening`, `wedClosing`, `thuOpening`, `thuClosing`, `friOpening`, `friClosing`, `satOpening`, `satClosing`, `sunOpening`, `sunClosing`) VALUES (5, '08:00', '18:00', '08:00', '18:00', '08:00', '18:00', '08:00', '18:00', '08:00', '18:00', '09:00', '17:00', '09:00', '14:00');
INSERT INTO `orto`.`OpeningHours` (`sellerId`, `monOpening`, `monClosing`, `tueOpening`, `tueClosing`, `wedOpening`, `wedClosing`, `thuOpening`, `thuClosing`, `friOpening`, `friClosing`, `satOpening`, `satClosing`, `sunOpening`, `sunClosing`) VALUES (6, '08:00', '18:00', '08:00', '18:00', '08:00', '18:00', '08:00', '18:00', '08:00', '18:00', '09:00', '17:00', '09:00', '14:00');
INSERT INTO `orto`.`OpeningHours` (`sellerId`, `monOpening`, `monClosing`, `tueOpening`, `tueClosing`, `wedOpening`, `wedClosing`, `thuOpening`, `thuClosing`, `friOpening`, `friClosing`, `satOpening`, `satClosing`, `sunOpening`, `sunClosing`) VALUES (7, '08:00', '18:00', '08:00', '18:00', '08:00', '18:00', '08:00', '18:00', '08:00', '18:00', '09:00', '17:00', '09:00', '14:00');
INSERT INTO `orto`.`OpeningHours` (`sellerId`, `monOpening`, `monClosing`, `tueOpening`, `tueClosing`, `wedOpening`, `wedClosing`, `thuOpening`, `thuClosing`, `friOpening`, `friClosing`, `satOpening`, `satClosing`, `sunOpening`, `sunClosing`) VALUES (8, '08:00', '18:00', '08:00', '18:00', '08:00', '18:00', '08:00', '18:00', '08:00', '18:00', '09:00', '17:00', '09:00', '14:00');
INSERT INTO `orto`.`OpeningHours` (`sellerId`, `monOpening`, `monClosing`, `tueOpening`, `tueClosing`, `wedOpening`, `wedClosing`, `thuOpening`, `thuClosing`, `friOpening`, `friClosing`, `satOpening`, `satClosing`, `sunOpening`, `sunClosing`) VALUES (9, '08:00', '18:00', '08:00', '18:00', '08:00', '18:00', '08:00', '18:00', '08:00', '18:00', '09:00', '17:00', '09:00', '14:00');
INSERT INTO `orto`.`OpeningHours` (`sellerId`, `monOpening`, `monClosing`, `tueOpening`, `tueClosing`, `wedOpening`, `wedClosing`, `thuOpening`, `thuClosing`, `friOpening`, `friClosing`, `satOpening`, `satClosing`, `sunOpening`, `sunClosing`) VALUES (10, '08:00', '18:00', '08:00', '18:00', '08:00', '18:00', '08:00', '18:00', '08:00', '18:00', '09:00', '17:00', '09:00', '14:00');

COMMIT;


-- -----------------------------------------------------
-- Data for table `orto`.`SellerProductType`
-- -----------------------------------------------------
START TRANSACTION;
USE `orto`;
INSERT INTO `orto`.`SellerProductType` (`seller`, `productType`) VALUES (1, 'agricultural');
INSERT INTO `orto`.`SellerProductType` (`seller`, `productType`) VALUES (1, 'animal');
INSERT INTO `orto`.`SellerProductType` (`seller`, `productType`) VALUES (2, 'agricultural');
INSERT INTO `orto`.`SellerProductType` (`seller`, `productType`) VALUES (2, 'cleaning_cosmetics');
INSERT INTO `orto`.`SellerProductType` (`seller`, `productType`) VALUES (3, 'agricultural');
INSERT INTO `orto`.`SellerProductType` (`seller`, `productType`) VALUES (4, 'agricultural');
INSERT INTO `orto`.`SellerProductType` (`seller`, `productType`) VALUES (4, 'animal');
INSERT INTO `orto`.`SellerProductType` (`seller`, `productType`) VALUES (5, 'cleaning_cosmetics');
INSERT INTO `orto`.`SellerProductType` (`seller`, `productType`) VALUES (6, 'animal');
INSERT INTO `orto`.`SellerProductType` (`seller`, `productType`) VALUES (7, 'agricultural');
INSERT INTO `orto`.`SellerProductType` (`seller`, `productType`) VALUES (8, 'cleaning_cosmetics');
INSERT INTO `orto`.`SellerProductType` (`seller`, `productType`) VALUES (9, 'agricultural');
INSERT INTO `orto`.`SellerProductType` (`seller`, `productType`) VALUES (9, 'animal');
INSERT INTO `orto`.`SellerProductType` (`seller`, `productType`) VALUES (10, 'animal');

COMMIT;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
