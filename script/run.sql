CREATE TABLE `smartlaundry`.`user` (
  `UserId` INT AUTO_INCREMENT,
  `Name` VARCHAR(45) NULL,
  `PhoneNumber` VARCHAR(45) NULL,
  `Password` VARCHAR(45) NULL,
  `IsOwner` BOOLEAN NULL,
  PRIMARY KEY (`UserId`));