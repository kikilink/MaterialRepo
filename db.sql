DROP DATABASE
IF EXISTS newbeeDB;

CREATE DATABASE newbeeDB DEFAULT CHARACTER
SET utf8;

CREATE TABLE category (
	id INT AUTO_INCREMENT PRIMARY KEY,
	name VARCHAR(64),
	valid BOOLEAN,
	creation date,
	creator VARCHAR(32)
) ENGINE = INNODB
;

CREATE TABLE type (
	id INT AUTO_INCREMENT NOT NULL,
	category_id INT NOT NULL,
	name VARCHAR(64),
	valid BOOLEAN,
	creation date,
	creator VARCHAR(32),
	CONSTRAINT pk_id PRIMARY KEY(id, category_id),
	CONSTRAINT fk_id FOREIGN KEY(category_id) REFERENCES category (id)
) ENGINE = INNODB;

CREATE TABLE material (
	id INT AUTO_INCREMENT NOT NULL,
	type_id INT NOT NULL,
	category_id INT NOT NULL,
	model VARCHAR(32) NOT NULL,
	footprint VARCHAR(32),
	vendor VARCHAR(32),
	packing VARCHAR(32),
	modelType VARCHAR(32),
	purchasing_date date,
	storage INT NOT NULL,
	unit_price DECIMAL,
	delivery INT,
	guide VARCHAR(2000),
	remark VARCHAR(128),
	CONSTRAINT m_pk_id PRIMARY KEY(id, type_id, category_id),
	CONSTRAINT m_fk_id FOREIGN KEY(type_id, category_id) REFERENCES
	type(id, category_id)
	
) ENGINE = INNODB
