DROP DATABASE library;

CREATE DATABASE library;

\connect library

CREATE TABLE readers (
    library_card_number SERIAL PRIMARY KEY,
    surname text NOT NULL,
    name text NOT NULL,
    patronymic text,
    address text,
    reader_login text UNIQUE NOT NULL,
    reader_password text NOT NULL
);

CREATE TABLE books (
    book_id SERIAL PRIMARY KEY,
    book_name text NOT NULL,
    authors text,
    publisher text NOT NULL,
    publish_year integer,
    isbn integer,
    total_amount integer,
    current_count integer
);

CREATE TABLE book_copies (
    copy_id SERIAL PRIMARY KEY,
    book_id integer REFERENCES books ON DELETE CASCADE,
    copy_number integer
);

CREATE TABLE reader_story (
    reader_id integer REFERENCES readers ON DELETE CASCADE,
    copy_id integer REFERENCES book_copies ON DELETE CASCADE,
    issue_date date,
    return_date date
);

CREATE TABLE admin (
    admin_id SERIAL PRIMARY KEY,
    admin_login text UNIQUE NOT NULL,
    admin_password text
);

INSERT INTO readers (library_card_number, surname, name, patronymic, address, reader_login, reader_password) VALUES
(1, 'Киреев', 'Артур', 'Михайлович', 'Московская, 5с1', 'kireev', '1234'),
(2, 'Романов', 'Александр', 'Валерьевич', 'Ленинский пр-т, 78с5', 'romanov', '1234'),
(3, 'Бухметов', 'Георгий', 'Олегович', 'Университетский пр-т, 28к7', 'buhmetov', '1234');

INSERT INTO books (book_id, book_name, authors, publisher, publish_year, isbn, total_amount, current_count) VALUES
(1, 'Зов Ктулху', 'Лавкрафт', 'Лабирин Манн', 2004, 235, 1, 1),
(2, 'Война и мир', 'Толстой', 'Феникс', 2010, 143, 1, 1),
(3, '1984', 'Оруэлл', 'Просвещение', 2008, 321, 1, 1);

INSERT INTO book_copies (copy_id, book_id, copy_number) VALUES
(1, 1, 1), (2, 2, 1), (3, 3, 1);

INSERT INTO reader_story (reader_id, copy_id, issue_date, return_date) VALUES
(1, 1, '2022-02-13', '2022-03-1'),
(2, 2, '2022-02-25', '2022-03-7'),
(3, 3, '2022-03-3', NULL);

INSERT INTO admin (admin_id, admin_login, admin_password) VALUES
(1, 'admin1', 'admin1'),
(2, 'admin2', 'admin2'),
(3, 'admin3', 'admin3');
