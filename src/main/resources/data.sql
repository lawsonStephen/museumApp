INSERT INTO MUSEUM VALUES
    (default, 'images/prado.jpeg', 'Madrid','Prado'),
    (default, 'images/louvre.jpeg', 'Paris', 'Louvre'),
    (default, 'images/britishMuseum.jpeg','London','British Museum'),
    (default, 'images/nationalGallery.jpeg', 'London','National Gallery'),
    (default, 'images/accademia.jpeg','Florence','Accademia'),
    (default, 'images/stPeter.jpeg','Vatican City','St Peters Basilica'),
    (default, 'images/sistine.jpeg','Vatican City', 'Sistine Chapel'),
    (default, 'images/vanGogh.jpeg','Amsterdam','Van Gogh Museum'),
    (default, 'images/nationalHistory.jpeg','New York','American Museum of Natural History'),
    (default, 'images/smithsonian.jpeg','Washington D.C.','Smithsonian National Museum of American History'),
    (default, 'images/tateModern.jpeg','London','Tate Modern'),
    (default, 'images/uffizi.jpeg','Florence','Uffizi Gallery'),
    (default, 'images/hermitage.jpeg','St Petersburg','Hermitage Museum'),
    (default, 'images/rijksmuseum.jpeg','Amsterdam','Rijksmuseum'),
    (default, 'images/dOrsay.jpeg','Paris','Musee dOrsay'),
    (default, 'images/moma.jpeg','New York','MOMA'),
    (default, 'images/nmok.jpeg','Seoul','National Museum of Korea'),
    (default, 'images/pergamon.jpeg','Berlin','Pergamon Museum');

INSERT INTO ARTIST (id, name, birthplace, birth_year) VALUES
    (default, 'Michelangelo', 'Italy', 1475),
    (default, 'Rodin', 'France', 1840),
    (default, 'Donatello', 'Italy', 1386),
    (default, 'Van Gogh', 'Netherlands', 1853),
    (default, 'Picasso', 'Spain', 1881),
    (default, 'da Vinci', 'Italy', 1452);

INSERT INTO SCULPTURE (id, name, sculpture_year, sculpture_price, artist_id, museum_id) VALUES
    (default, 'David', 1501, 100, select id from artist where name='Michelangelo', select id from museum where name='Accademia'),
    (default, 'Saint Mark', 1411, 7.5, select id from artist where name='Donatello', select id from museum where name='Louvre'),
    (default, 'Thinker', 1904, 80, select id from artist where name='Rodin', select id from museum where name='Louvre'),
    (default, 'Dying Slave', 1516, 1.5, select id from artist where name='Michelangelo', select id from museum where name='Louvre'),
    (default, 'Pieta', 1499, 5, select id from artist where name='Michelangelo', select id from museum where name='St Peters Basilica');

INSERT INTO PAINTING (id, name, painting_year, painting_price, museum_id, artist_id) VALUES
                        (default, 'Sunflowers', 1888, 100, SELECT id FROM museum WHERE name = 'Van Gogh Museum', SELECT id FROM artist WHERE name = 'Van Gogh'),
                        (default, 'Buste de femme', 1943, 10, SELECT id FROM museum WHERE name = 'Louvre', SELECT id FROM artist WHERE name = 'Picasso'),
                        (default, 'Sistine Chapel Ceiling', 1512, 80, select id from museum where name ='Sistine Chapel', select id from artist where name ='Michelangelo'),
                        (default, 'Wheatfield with Crows', 1890,  117, select id from museum where name ='Van Gogh Museum', select id from artist where name = 'Van Gogh'),
                        (default, 'Mona Lisa', 1517, 870, select id from museum where name ='Louvre', select id from artist where name ='da Vinci');

