INSERT INTO MUSEUM (id, IMAGE_PATH, location, name, AVAILABLE_QUANTITY, PRICE)
VALUES (default, 'images/prado.jpeg', 'Madrid', 'Prado', 10, 10),
       (default, 'images/louvre.jpeg', 'Paris', 'Louvre', 10, 10),
       (default, 'images/britishMuseum.jpeg', 'London', 'British Museum', 10, 10),
       (default, 'images/nationalGallery.jpeg', 'London', 'National Gallery', 10, 10),
       (default, 'images/accademia.jpeg', 'Florence', 'Accademia', 10, 10),
       (default, 'images/stPeter.jpeg', 'Vatican City', 'St Peters Basilica', 10, 10),
       (default, 'images/sistine.jpeg', 'Vatican City', 'Sistine Chapel', 10, 10),
       (default, 'images/vanGoghMuseum.jpeg', 'Amsterdam', 'Van Gogh Museum', 10, 10),
       (default, 'images/nationalHistory.jpeg', 'New York', 'American Museum of Natural History', 10, 10),
       (default, 'images/smithsonian.jpeg', 'Washington D.C.', 'Smithsonian National Museum of American History', 10,
        10),
       (default, 'images/tateModern.jpeg', 'London', 'Tate Modern', 10, 10),
       (default, 'images/uffizi.jpeg', 'Florence', 'Uffizi Gallery', 10, 10),
       (default, 'images/hermitage.jpeg', 'St Petersburg', 'Hermitage Museum', 10, 10),
       (default, 'images/rijksmuseum.jpeg', 'Amsterdam', 'Rijksmuseum', 10, 10),
       (default, 'images/dOrsay.jpeg', 'Paris', 'Musée dOrsay', 10, 10),
       (default, 'images/moma.jpeg', 'New York', 'Museum of Modern Art', 10, 10),
       (default, 'images/nmok.jpeg', 'Seoul', 'National Museum of Korea', 10, 10),
       (default, 'images/pergamon.jpeg', 'Berlin', 'Pergamon Museum', 10, 10);

INSERT INTO ARTIST (id, name, birthplace, birth_year)
VALUES (default, 'Michelangelo', 'Italy', 1475),
       (default, 'Rodin', 'France', 1840),
       (default, 'Donatello', 'Italy', 1386),
       (default, 'VanGogh', 'Netherlands', 1853),
       (default, 'Picasso', 'Spain', 1881),
       (default, 'daVinci', 'Italy', 1452),
       (default, 'Rembrandt', 'Netherlands', 1606),
       (default, 'Monet', 'France', 1840),
       (default, 'Dali', 'Spain', 1904),
       (default, 'Warhol', 'United States', 1928),
       (default, 'Vermeer', 'Netherlands', 1632),
       (default, 'Raphael', 'Italy', 1483),
       (default, 'Gauguin', 'France', 1848),
       (default, 'Titian', 'Italy', 1488),
       (default, 'Munch', 'Norway', 1863),
       (default, 'Matisse', 'France', 1869),
       (default, 'Renoir', 'France', 1841),
       (default, 'OKeeffe', 'United States', 1887),
       (default, 'Klimt', 'Austria', 1862),
       (default, 'Cezanne', 'France', 1839),
       (default, 'Pollock', 'United States', 1912);

INSERT INTO SCULPTURE (id, name, sculpture_year, sculpture_price, artist_id, museum_id)
VALUES (default, 'David', 1501, 100, select id from artist where name = 'Michelangelo', select id from museum where
        name = 'Accademia'),
       (default, 'Saint Mark', 1411, 7.5, select id from artist where name = 'Donatello', select id from museum where
        name = 'Louvre'),
       (default, 'Thinker', 1904, 80, select id from artist where name = 'Rodin', select id from museum where name =
        'Louvre'),
       (default, 'Dying Slave', 1516, 1.5, select id from artist where name = 'Michelangelo', select id from museum
        where name = 'Louvre'),
       (default, 'Pieta', 1499, 5, select id from artist where name = 'Michelangelo', select id from museum where name =
        'St Peters Basilica'),
       (default, 'The Kiss', 1908, 5.5, (select id from artist where name = 'Klimt'),
        (select id from museum where name = 'Musée dOrsay')),
       (default, 'Migrant Mother', 1936, 2.0, (select id from artist where name = 'Klimt'),
        (select id from museum where name = 'Smithsonian National Museum of American History')),
       (default, 'The Persistence of Memory', 1931, 4.5, (select id from artist where name = 'Dali'),
        (select id from museum where name = 'Museum of Modern Art')),
       (default, 'Eagle', 1905, 1.8, (select id from artist where name = 'Pollock'),
        (select id from museum where name = 'Smithsonian National Museum of American History')),
       (default, 'Liberty Leading the People', 1830, 4.7, (select id from artist where name = 'Munch'),
        (select id from museum where name = 'Musée dOrsay')),
       (default, 'Campbells Soup Cans', 1962, 9.0, (select id from artist where name = 'Warhol'),
        (select id from museum where name = 'Tate Modern')),
       (default, 'The Yellow Christ', 1889, 4.5, (select id from artist where name = 'Gauguin'),
        (select id from museum where name = 'Musée dOrsay')),
       (default, 'The Card Players', 1890 - 92, 7.5, (select id from artist where name = 'Cezanne'),
        (select id from museum where name = 'Musée dOrsay')),
       (default, 'The Portrait of Adele Bloch-Bauer I', 1907, 8.0, (select id from artist where name = 'Klimt'),
        (select id from museum where name = 'Pergamon Museum')),
       (default, 'No. 61 (Brown and Bronze)', 1951, 5.0, (select id from artist where name = 'Pollock'),
        (select id from museum where name = 'Museum of Modern Art'));

INSERT INTO PAINTING (id, IMAGE_PATH, name, painting_price, painting_year, museum_id, artist_id)
VALUES (default, 'images/paintings/The Starry Night.jpg', 'The Starry Night', 117, 1890,
           SELECT id FROM museum WHERE name = 'Museum of Modern Art', SELECT id FROM artist WHERE name = 'VanGogh'),
       (default, 'images/paintings/The Creation of Adam.jpg', 'The Creation of Adam', 80, 1512,
           SELECT id from museum where name = 'Sistine Chapel', select id from artist where name = 'Michelangelo'),
       (default, 'images/paintings/Wheatfield with Crows.jpeg', 'Wheatfield with Crows', 117, 1890,
           SELECT id from museum where name = 'Van Gogh Museum', select id from artist where name = 'VanGogh'),
       (default, 'images/paintings/Mona Lisa.jpeg', 'Mona Lisa', 870, 1517,
           SELECT id from museum where name = 'Louvre', select id from artist where name = 'daVinci'),
       (default, 'images/paintings/The Scream.jpg', 'The Scream', 100, 1888,
           SELECT id FROM museum WHERE name = 'National Gallery', SELECT id FROM artist WHERE name = 'Munch'),
       (default, 'images/paintings/Les femmes dAlger.jpg', 'Les femmes dAlger', 10, 1954,
           SELECT id FROM museum WHERE name = 'Louvre', SELECT id FROM artist WHERE name = 'Picasso'),
       (default, 'images/paintings/Prophet Isaiah.jpg', 'Prophet Isaiah', 80, 1512,
           SELECT id FROM museum WHERE name = 'Sistine Chapel', SELECT id FROM artist WHERE name = 'Michelangelo'),
       (default, 'images/paintings/The Deluge.jpg', 'The Deluge', 870, 1512,
           SELECT id FROM museum WHERE name = 'Sistine Chapel', SELECT id FROM artist WHERE name = 'Michelangelo'),
       (default, 'images/paintings/The Temptation of St. Anthony.jpg', 'The Temptation of St. Anthony', 125, 1946,
           SELECT id FROM museum WHERE name = 'Museum of Modern Art', SELECT id FROM artist WHERE name = 'VanGogh'),
       (default, 'images/paintings/The Persistence of Memory.jpg', 'The Persistence of Memory', 110, 1931,
           SELECT id FROM museum WHERE name = 'Museum of Modern Art', SELECT id FROM artist WHERE name = 'Dali'),
       (default, 'images/paintings/Night Watch.jpg', 'Night Watch', 140, 1642,
           SELECT id FROM museum WHERE name = 'Rijksmuseum', SELECT id FROM artist WHERE name = 'Rembrandt'),
       (default, 'images/paintings/sunflowers.jpeg', 'Sunflowers', 100, 1888,
           SELECT id FROM museum WHERE name = 'Van Gogh Museum', SELECT id FROM artist WHERE name = 'VanGogh'),
       (default, 'images/paintings/Buste de femme.jpg', 'Buste de femme', 10, 1943,
           SELECT id FROM museum WHERE name = 'Louvre', SELECT id FROM artist WHERE name = 'Picasso'),
       (default, 'images/paintings/The School of Athens.png', 'The School of Athens', 160, 1510,
           SELECT id FROM museum WHERE name = 'Sistine Chapel', SELECT id FROM artist WHERE name = 'Raphael');
