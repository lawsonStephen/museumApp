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

INSERT INTO ARTIST (id, name, birthplace, birth_year, ARTIST_URL)
VALUES (default, 'Michelangelo', 'Italy', 1475, 'michelangelo'),
       (default, 'Rodin', 'France', 1840, 'auguste-rodin'),
       (default, 'Donatello', 'Italy', 1386, 'donatello'),
       (default, 'VanGogh', 'Netherlands', 1853, 'vincent-van-gogh'),
       (default, 'Picasso', 'Spain', 1881, 'pablo-picasso'),
       (default, 'daVinci', 'Italy', 1452, 'leonardo-da-vinci'),
       (default, 'Rembrandt', 'Netherlands', 1606, 'rembrandt'),
       (default, 'Monet', 'France', 1840, 'claude-monet'),
       (default, 'Dali', 'Spain', 1904, 'salvador-dali'),
       (default, 'Warhol', 'United States', 1928, 'andy-warhol'),
       (default, 'Vermeer', 'Netherlands', 1632, 'johannes-vermeer'),
       (default, 'Raphael', 'Italy', 1483, 'raphael'),
       (default, 'Gauguin', 'France', 1848, 'paul-gauguin'),
       (default, 'Titian', 'Italy', 1488, 'titian'),
       (default, 'Munch', 'Norway', 1863, 'edvard-munch'),
       (default, 'Matisse', 'France', 1869, 'henri-matisse'),
       (default, 'Renoir', 'France', 1841, 'pierre-auguste-renoir'),
       (default, 'OKeeffe', 'United States', 1887, 'georgia-o-keeffe'),
       (default, 'Klimt', 'Austria', 1862, 'gustav-klimt'),
       (default, 'Cezanne', 'France', 1839, 'paul-cezanne'),
       (default, 'Pollock', 'United States', 1912, 'jackson-pollock');

INSERT INTO SCULPTURE (id, name, sculpture_year, sculpture_price, artist_id, museum_id, IMAGE_PATH)
VALUES (default, 'David', 1501, 100, select id from artist where name = 'Michelangelo', select id from museum where
        name = 'Accademia', 'images/sculptures/David.jpg'),
       (default, 'Dying Slave', 1516, 1.5, select id from artist where name = 'Michelangelo', select id from museum
        where name = 'Louvre', 'images/sculptures/Dying Slave.jpg'),
       (default, 'Thinker', 1904, 80, select id from artist where name = 'Rodin', select id from museum where name =
        'Louvre', 'images/sculptures/Thinker.jpg'),
       (default, 'Saint Mark', 1411, 7.5, select id from artist where name = 'Donatello', select id from museum where
        name = 'Louvre', 'images/sculptures/Saint Mark.jpg'),
       (default, 'Pieta', 1499, 5, select id from artist where name = 'Michelangelo', select id from museum where name =
        'St Peters Basilica', 'images/sculptures/Pieta.jpg'),
       (default, 'Bacchus', 1497, 4.5, (select id from artist where name = 'Michelangelo'),
        (select id from museum where name = 'Museum of Modern Art'), 'images/sculptures/Bacchus.jpg'),
       (default, 'Brillo Boxes', 1964, 1.8, (select id from artist where name = 'Warhol'),
        (select id from museum where name = 'Smithsonian National Museum of American History'),
        'images/sculptures/Brillo Boxes.PNG'),
       (default, 'Woman Aflame', 1980, 4.7, (select id from artist where name = 'Dali'),
        (select id from museum where name = 'Museum of Modern Art'), 'images/sculptures/Woman Aflame.jpg');


INSERT INTO PAINTING (id, IMAGE_PATH, name, painting_price, painting_year, museum_id, artist_id, LINK)
VALUES (default, 'images/paintings/The Starry Night.jpg', 'The Starry Night', 117, 1890, SELECT id FROM museum WHERE
        name = 'Museum of Modern Art', SELECT id FROM artist WHERE name = 'VanGogh',
        'https://en.wikipedia.org/wiki/The_Starry_Night'),
       (default, 'images/paintings/The Kiss.jpg', 'The Kiss', 5.5, 1908, SELECT id from museum where name =
        'Musée dOrsay', SELECT id from artist where name = 'Klimt',
        'https://en.wikipedia.org/wiki/The_Kiss_%28Klimt%29'),
       (default, 'images/paintings/The Creation of Adam.jpg', 'The Creation of Adam', 80, 1512,
           SELECT id from museum where name = 'Sistine Chapel', select id from artist where name = 'Michelangelo',
        'https://en.wikipedia.org/wiki/The_Creation_of_Adam'),
       (default, 'images/paintings/Wheatfield with Crows.jpeg', 'Wheatfield with Crows', 117, 1890,
           SELECT id from museum where name = 'Van Gogh Museum', select id from artist where name = 'VanGogh',
        'https://en.wikipedia.org/wiki/Wheatfield_with_Crows'),
       (default, 'images/paintings/Mona Lisa.jpeg', 'Mona Lisa', 870, 1517,
           SELECT id from museum where name = 'Louvre', select id from artist where name = 'daVinci',
        'https://en.wikipedia.org/wiki/Mona_Lisa'),
       (default, 'images/paintings/The Scream.jpg', 'The Scream', 100, 1888,
           SELECT id FROM museum WHERE name = 'National Gallery', SELECT id FROM artist WHERE name = 'Munch',
        'https://en.wikipedia.org/wiki/The_Scream'),
       (default, 'images/paintings/Les femmes dAlger.jpg', 'Les femmes dAlger', 10, 1954,
           SELECT id FROM museum WHERE name = 'Louvre', SELECT id FROM artist WHERE name = 'Picasso',
        'https://en.wikipedia.org/wiki/Les_Femmes_dAlger'),
       (default, 'images/paintings/Prophet Isaiah.jpg', 'Prophet Isaiah', 80, 1512,
           SELECT id FROM museum WHERE name = 'Sistine Chapel', SELECT id FROM artist WHERE name = 'Michelangelo',
        'https://en.wikipedia.org/wiki/Les_Femmes_dAlger'),
       (default, 'images/paintings/The Deluge.jpg', 'The Deluge', 870, 1512,
           SELECT id FROM museum WHERE name = 'Sistine Chapel', SELECT id FROM artist WHERE name = 'Michelangelo', ''),
       (default, 'images/paintings/The Temptation of St. Anthony.jpg', 'The Temptation of St. Anthony', 125, 1946,
           SELECT id FROM museum WHERE name = 'Museum of Modern Art', SELECT id FROM artist WHERE name = 'Dali',
        'https://en.wikipedia.org/wiki/The_Temptation_of_St._Anthony_(Dal%C3%AD)'),
       (default, 'images/paintings/The Persistence of Memory.jpg', 'The Persistence of Memory', 110, 1931,
           SELECT id FROM museum WHERE name = 'Museum of Modern Art', SELECT id FROM artist WHERE name = 'Dali',
        'https://en.wikipedia.org/wiki/The_Persistence_of_Memory'),
       (default, 'images/paintings/Night Watch.jpg', 'Night Watch', 140, 1642,
           SELECT id FROM museum WHERE name = 'Rijksmuseum', SELECT id FROM artist WHERE name = 'Rembrandt', ''),
       (default, 'images/paintings/sunflowers.jpeg', 'Sunflowers', 100, 1888,
           SELECT id FROM museum WHERE name = 'Van Gogh Museum', SELECT id FROM artist WHERE name = 'VanGogh', ''),
       (default, 'images/paintings/Buste de femme.jpg', 'Buste de femme', 10, 1943,
           SELECT id FROM museum WHERE name = 'Louvre', SELECT id FROM artist WHERE name = 'Picasso', ''),
       (default, 'images/paintings/The School of Athens.png', 'The School of Athens', 160, 1510,
           SELECT id FROM museum WHERE name = 'Sistine Chapel', SELECT id FROM artist WHERE name = 'Raphael', '');





