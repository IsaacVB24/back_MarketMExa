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
    `user_registred` DATE NOT NULL DEFAULT (CURRENT_DATE),
    `address` VARCHAR(100) NOT NULL
);


-- -------------------------------------------
-- Crear tabla products ----------------------
-- -------------------------------------------
CREATE TABLE `products` (
	`id_productos` INT AUTO_INCREMENT NOT NULL PRIMARY KEY,
    `name` VARCHAR(100) NOT NULL,
    `description` VARCHAR(500),
	`image` VARCHAR(100) NOT NULL,
    `price` FLOAT NOT NULL,
     `category` VARCHAR(100) NOT NULL,
    `stock` INT NOT NULL
          );        
          
CREATE TABLE `orders` (
	`id_order` INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
     `users_id_user` INT NOT NULL,
    `id_producto` INT NOT NULL,
    `amount` INT NOT NULL,
    `order_date` DATETIME NOT NULL
);
-- DROP DATABASE market_mexa;

INSERT INTO products(name, description, price,  stock,  image,category)
VALUE 

('Guitarra Acústica', 'Diapason clasico,Trastes 19, Acabado Natural, Mate, Negro y Vino, Aro, Fondo y Mastil Aile, Diapason y Puente Encino, Maquinaria Clasica, Cuerdas Nylon', 1250,  1, 'https://res.cloudinary.com/marketmexa/image/upload/v1738617533/dspwmnc0hsrpnuxbujgh.webp','Música'),
('Balon Fútbol Americano', 'Ovalado, con una longitud de 29cm y u un peso de 400gr. Cuatro paneles de cuero cocidos con hilo resistente', 420, 3, 'https://res.cloudinary.com/marketmexa/image/upload/v1738617438/xmvavcxvyfzjumsatrs5.jpg','Deportes'),
('Balón Fútbol Soccer', 'Diametro de 22cm. Peso de 450gr. Cubierto de peneles de cuero cosidos', 350,  3, 'https://res.cloudinary.com/marketmexa/image/upload/v1738617527/wp4rjdyldebwljqwkzdj.webp','Deportes'),
('Nintendo Switch 32GB', 'Nintendo Switch es la consola de Nintendo híbrida entre portátil y sobremesa. La Nintendo Switch incorpora dos controladores llamados Joy Con que se pueden desacoplar de la consola para juegos multijugador local como el Mario Kart, también tienen giroscopio, cámara infrarroja, NFC y vibración HD tecnologías que son aprovechadas por otros juegos, como 1,2,3 Switch, que acompañó a la consola en su lanzamiento.', 7864.25,  2, 'https://res.cloudinary.com/marketmexa/image/upload/v1738617593/blffrshxhpwjubmieaxe.jpg','Tecnología'),
('Album Beatles Sergeant Pepper', 'Peppers Lonely Hearts Club Band , álbum de estudio grabado por la banda de rock británica The Beatles, lanzado en 1967. El álbum resultó revolucionario por su tono psicodélico, sus efectos de estudio experimentales y su contribución musical al espíritu de la época contracultural de finales de los años 1960.', 564, 1, 'https://res.cloudinary.com/marketmexa/image/upload/v1738617565/qzvzcg6milgxc1dx7znf.webp','Música');

SELECT * FROM products;