USE `market_mexa`;

INSERT INTO  `users` (`name`, `email`, `phone`, `pass`, `user_registred`, `address` )
VALUES 
('Carlos López', 'carlos.lopez@example.com', '555-1234', 'password123', '2024-12-20', 'NEZA'),
('María Gómez', 'maria.gomez@example.com', '555-5678', 'mariaPass456', '2024-12-21', 'IZPALAPA'),
('Juan Pérez', 'juan.perez@example.com', '555-9012', 'juanSecure789', '2024-12-22', 'GUADALAJARA'),
('Juan Pérez', 'juan.perez.G@example.com', '555-8970', 'JuanPG', '2024-11-24', 'COYOACAN');
-- SELECT*FROM users;

INSERT INTO `products`(`product_name`, `product_description`, `product_price`, `product_category`, `product_stock`,  `product_image`)
VALUE 
('Guitarra Acústica', 'Diapason clasico,Trastes 19, Acabado Natural, Mate, Negro y Vino, Aro, Fondo y Mastil Aile, Diapason y Puente Encino, Maquinaria Clasica, Cuerdas Nylon', 1250, 'musica', 1, 'https://res.cloudinary.com/marketmexa/image/upload/v1738617533/dspwmnc0hsrpnuxbujgh.webp'),
('Balon Fútbol Americano', 'Ovalado, con una longitud de 29cm y u un peso de 400gr. Cuatro paneles de cuero cocidos con hilo resistente', 420, 'deportes', 3, 'https://res.cloudinary.com/marketmexa/image/upload/v1738617438/xmvavcxvyfzjumsatrs5.jpg'),
('Balón Fútbol Soccer', 'Diametro de 22cm. Peso de 450gr. Cubierto de peneles de cuero cosidos', 350, 'deportes',  3, 'https://res.cloudinary.com/marketmexa/image/upload/v1738617527/wp4rjdyldebwljqwkzdj.webp'),
('Nintendo Switch 32GB', 'Nintendo Switch es la consola de Nintendo híbrida entre portátil y sobremesa. La Nintendo Switch incorpora dos controladores llamados Joy Con que se pueden desacoplar de la consola para juegos multijugador local como el Mario Kart, también tienen giroscopio, cámara infrarroja, NFC y vibración HD tecnologías que son aprovechadas por otros juegos, como 1,2,3 Switch, que acompañó a la consola en su lanzamiento.', 7864.25, 'tecnología', 2, 'https://res.cloudinary.com/marketmexa/image/upload/v1738617593/blffrshxhpwjubmieaxe.jpg'),
('Album Beatles Sergeant Pepper', 'Peppers Lonely Hearts Club Band , álbum de estudio grabado por la banda de rock británica The Beatles, lanzado en 1967. El álbum resultó revolucionario por su tono psicodélico, sus efectos de estudio experimentales y su contribución musical al espíritu de la época contracultural de finales de los años 1960.', 564, 'musica', 1, 'https://res.cloudinary.com/marketmexa/image/upload/v1738617565/qzvzcg6milgxc1dx7znf.webp');
-- SELECT * FROM products;


INSERT INTO `orders` (`users_id_user`, `id_producto`, `amount`, `order_date`)
VALUES (1, 4, 898, now()),
(2, 3, 5, now()),
(3, 5, 6, now()),
(4, 7, 2, now()),
(5, 8, 1, now());
-- SELECT * FROM orders;

