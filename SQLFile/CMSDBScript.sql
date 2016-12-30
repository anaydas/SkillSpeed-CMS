create database cms;

use cms;

DROP TABLE IF EXISTS `cms`.`article`;
CREATE TABLE  `cms`.`article` (
  `articleId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `articleName` varchar(45) NOT NULL DEFAULT '',
  `articleFile` blob,
  `imageFile` blob,
  PRIMARY KEY (`articleId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;

DROP TABLE IF EXISTS `cms`.`comment`;
CREATE TABLE  `cms`.`comment` (
  `commentId` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `commantDetails` varchar(45) NOT NULL DEFAULT '',
  `articleId` int(10) unsigned NOT NULL DEFAULT '0',
  PRIMARY KEY (`commentId`),
  KEY `art_Key` (`articleId`),
  CONSTRAINT `art_Key` FOREIGN KEY (`articleId`) REFERENCES `article` (`articleId`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;