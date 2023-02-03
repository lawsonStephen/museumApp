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
       (default, 'Woman Aflame', 1980, 4.7, (select id from artist where name = 'Dali'),
        (select id from museum where name = 'Museum of Modern Art'), 'images/sculptures/Woman Aflame.jpg'),
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
        'images/sculptures/Brillo Boxes.PNG');

INSERT INTO PAINTING (id, IMAGE_PATH, name, painting_price, painting_year, museum_id, artist_id, LINK, DESCRIPTION)
VALUES (default, 'images/paintings/The Starry Night.jpg', 'The Starry Night', 117, 1890, SELECT id FROM museum WHERE
        name = 'Museum of Modern Art', SELECT id FROM artist WHERE name = 'VanGogh',
        'https://en.wikipedia.org/wiki/The_Starry_Night',
        'The Starry Night is an oil-on-canvas painting by the Dutch Post-Impressionist painter Vincent van Gogh. Painted in June 1889, it depicts the view from the east-facing window of his asylum room at Saint-Rémy-de-Provence, just before sunrise, with the addition of an imaginary village'),
       (default, 'images/paintings/The Kiss.jpeg', 'The Kiss', 5.5, 1908, SELECT id from museum where name =
        'Musée dOrsay', SELECT id from artist where name = 'Klimt',
        'https://en.wikipedia.org/wiki/The_Kiss_%28Klimt%29',
        'The Kiss is an oil-on-canvas painting with added gold leaf, silver and platinum by the Austrian Symbolist painter Gustav Klimt. It was painted at some point in 1907 and 1908, during the height of what scholars call his "Golden Period".'),
       (default, 'images/paintings/The Creation of Adam.jpg', 'The Creation of Adam', 80, 1512,
           SELECT id from museum where name = 'Sistine Chapel', select id from artist where name = 'Michelangelo',
        'https://en.wikipedia.org/wiki/The_Creation_of_Adam',
        'The Creation of Adam is a fresco painting by Italian artist Michelangelo, which forms part of the Sistine Chapel''s ceiling, painted c. 1508–1512. It illustrates the Biblical creation narrative from the Book of Genesis in which God gives life to Adam, the first man.'),
       (default, 'images/paintings/Wheatfield with Crows.jpeg', 'Wheatfield with Crows', 117, 1890,
           SELECT id from museum where name = 'Van Gogh Museum', select id from artist where name = 'VanGogh',
        'https://en.wikipedia.org/wiki/Wheatfield_with_Crows',
        'Wheatfield with Crows is a July 1890 painting by Vincent van Gogh. It has been cited by several critics as one of his greatest works. It is commonly stated that this was van Gogh''s final painting because Vincente Minnelli’s 1956 biopic “Lust for Life” depicts van Gogh painting it shortly before killing himself.'),
       (default, 'images/paintings/Mona Lisa.jpeg', 'Mona Lisa', 870, 1517,
           SELECT id from museum where name = 'Louvre', select id from artist where name = 'daVinci',
        'https://en.wikipedia.org/wiki/Mona_Lisa',
        'The Mona Lisa is a half-length portrait painting by Italian artist Leonardo da Vinci. Considered an archetypal masterpiece of the Italian Renaissance, it has been described as "the best known, the most visited, the most written about, the most sung about, the most parodied work of art in the world".'),
       (default, 'images/paintings/The Scream.jpg', 'The Scream', 100, 1888,
           SELECT id FROM museum WHERE name = 'National Gallery', SELECT id FROM artist WHERE name = 'Munch',
        'https://en.wikipedia.org/wiki/The_Scream',
        'The Scream is a composition created by Norwegian artist Edvard Munch in 1893. The agonized face in the painting has become one of the most iconic images of art, seen as symbolizing the anxiety of the human condition.'),
       (default, 'images/paintings/Les femmes dAlger.jpg', 'Les femmes dAlger', 10, 1954,
           SELECT id FROM museum WHERE name = 'Louvre', SELECT id FROM artist WHERE name = 'Picasso',
        'https://en.wikipedia.org/wiki/Les_Femmes_dAlger',
        'Les Femmes d''Alger is a series of 15 paintings and numerous drawings by the Spanish artist Pablo Picasso. The series, created in 1954–1955, was inspired by Eugène Delacroix''s 1834 painting The Women of Algiers in their Apartment. The series is one of several painted by Picasso in tribute to artists that he admired.'),
       (default, 'images/paintings/Prophet Isaiah.jpg', 'Prophet Isaiah', 80, 1512,
           SELECT id FROM museum WHERE name = 'Sistine Chapel', SELECT id FROM artist WHERE name = 'Michelangelo',
        'https://en.wikipedia.org/wiki/Les_Femmes_dAlger',
        'The Prophet Isaiah is one of the seven Old Testament prophets painted by the Italian High Renaissance master Michelangelo on the Sistine Chapel ceiling. The Sistine Chapel is in Vatican Palace, in the Vatican City.'),
       (default, 'images/paintings/The Deluge.jpg', 'The Deluge', 870, 1512,
           SELECT id FROM museum WHERE name = 'Sistine Chapel', SELECT id FROM artist WHERE name = 'Michelangelo',
        'https://en.wikipedia.org/wiki/Sistine_Chapel',
        'Michelangelo''s Deluge sits at the heart of the masterwork which is the ceiling of the Sistine Chapel. Comprising thirty three different panels in all, it is the central section of nine panels, depicting the story of Genesis which lie at the heart of the ceiling; and which could be considered Michelangelo''s masterwork.'),
       (default, 'images/paintings/The Temptation of St. Anthony.jpg', 'The Temptation of St. Anthony', 125, 1946,
           SELECT id FROM museum WHERE name = 'Museum of Modern Art', SELECT id FROM artist WHERE name = 'Dali',
        'https://en.wikipedia.org/wiki/The_Temptation_of_St._Anthony_(Dal%C3%AD)',
        'The Temptation of St. Anthony is a painting by Spanish surrealist artist Salvador Dalí. Painted in 1946, it is a precursor to the body of Dalí''s work commonly known as the "classical period" or the "Dalí Renaissance".'),
       (default, 'images/paintings/The Persistence of Memory.jpg', 'The Persistence of Memory', 110, 1931,
           SELECT id FROM museum WHERE name = 'Museum of Modern Art', SELECT id FROM artist WHERE name = 'Dali',
        'https://en.wikipedia.org/wiki/The_Persistence_of_Memory',
        'The Persistence of Memory is a 1931 painting by artist Salvador Dalí and one of the most recognizable works of Surrealism. First shown at the Julien Levy Gallery in 1932, since 1934 the painting has been in the collection of the Museum of Modern Art in New York City, which received it from an anonymous donor.'),
       (default, 'images/paintings/Night Watch.jpg', 'Night Watch', 140, 1642,
           SELECT id FROM museum WHERE name = 'Rijksmuseum', SELECT id FROM artist WHERE name = 'Rembrandt',
        'https://en.wikipedia.org/wiki/The_Night_Watch',
        'Militia Company of District II under the Command of Captain Frans Banninck Cocq, also known as The Shooting Company of Frans Banning Cocq and Willem van Ruytenburch, but commonly referred to as The Night Watch, is a 1642 painting by Rembrandt van Rijn. '),
       (default, 'images/paintings/sunflowers.jpeg', 'Sunflowers', 100, 1888,
           SELECT id FROM museum WHERE name = 'Van Gogh Museum', SELECT id FROM artist WHERE name = 'VanGogh',
        'https://en.wikipedia.org/wiki/Sunflowers_(Van_Gogh_series)',
        'Sunflowers is the title of two series of still life paintings by the Dutch painter Vincent van Gogh. The first series, executed in Paris in 1887, depicts the flowers lying on the ground, while the second set, made a year later in Arles, shows a bouquet of sunflowers in a vase.'),
       (default, 'images/paintings/Buste de femme.jpg', 'Buste de femme', 10, 1943,
           SELECT id FROM museum WHERE name = 'Louvre', SELECT id FROM artist WHERE name = 'Picasso',
        'https://en.wikipedia.org/wiki/File:Pablo_Picasso,_1909,_Buste_de_femme,_Femme_en_vert,_Femme_assise,_oil_on_canvas,_100.3_x_81.3_cm,_Van_Abbemuseum,_Netherlands.jpg',
        'Pablo Picasso painted Buste de femme (Femme à la résille) on 12 January 1938, at the height of his relationship with the photographer Dora Maar. This picture is one of the best-known of his series of images of Dora, and crucially one of the best known remaining in private hands.'),
       (default, 'images/paintings/The School of Athens.png', 'The School of Athens', 160, 1510,
           SELECT id FROM museum WHERE name = 'Sistine Chapel', SELECT id FROM artist WHERE name = 'Raphael',
        'https://en.wikipedia.org/wiki/The_School_of_Athens',
        'The School of Athens is a fresco by the Italian Renaissance artist Raphael. The fresco was painted between 1509 and 1511 as a part of Raphael''s commission to decorate the rooms now known as the Stanze di Raffaello, in the Apostolic Palace in the Vatican.');


INSERT INTO CUSTOMER VALUES (1,'peter.smith@gmail.com','Peter Smith','peter');
INSERT INTO CUSTOMER VALUES (2,'helen.stewart@gmail.com', 'Helen Stewart','helen');
INSERT INTO CUSTOMER VALUES (3,'nicole.jackson@gmail.com', 'Nicole Jackson','nicole');
INSERT INTO CUSTOMER VALUES (4,'richard.gibson@gmail.com','Richard Gibson', 'richard');



