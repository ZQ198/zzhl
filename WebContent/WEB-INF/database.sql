/* Create Database */ 
CREATE DATABASE CARS CHARSET=UTF8;

/* Switch To DATABASE*/
USE CARS;

/* Drop Tables */

DROP TABLE CAR;




/* Create Tables */

CREATE TABLE CAR
(
	CARID INT NOT NULL AUTO_INCREMENT,
	PINPAIMING VARCHAR(20),
	XILIE VARCHAR(20),
	SHOUJIA INT,
	GONGLISHU INT,
	YANSE VARCHAR(20),
	PAILIANG VARCHAR(20),
	PRIMARY KEY (CARID)
)CHARSET=UTF8;



