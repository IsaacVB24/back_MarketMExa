-- CREAR ESQUEMA O BASE DE DATOS USANDO MYSQL

CREATE DATABASE `market_mexa`;

-- Indicarle a MySQL que voy a usar la DB creada para modificarla
USE `market_mexa`;

-- -------------------------------------------
-- Crear tabla users -------------------------
-- -------------------------------------------
CREATE TABLE `users` (
    `id_user` INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    `name` VARCHAR(50) NOT NULL,
    `email` VARCHAR(50) NOT NULL UNIQUE,
     `phone` VARCHAR(50) NOT NULL UNIQUE,
    `pass` VARCHAR(60) NOT NULL,
    `user_registred` DATE NOT NULL,
    `address` VARCHAR(100) NOT NULL
);
-- -------------------------------------------
-- Crear tabla products ----------------------
-- -------------------------------------------
CREATE TABLE `products` (
	`id_products` INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    `product_name` VARCHAR(100) NOT NULL,
        `product_description` VARCHAR(500) NOT NULL,
         `product_price` FLOAT NOT NULL,
         `product_category` VARCHAR(10) NOT NULL,
          `product_stock` INT NOT NULL,
          `product_image` VARCHAR(100) NOT NULL
          );        
          
CREATE TABLE `orders` (
	`id_order` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
     `users_id_user` INT NOT NULL,
    `id_producto` INT NOT NULL,
    `amount` INT NOT NULL,
    `order_date` DATETIME NOT NULL
);
-- DROP DATABASE market_mexa;