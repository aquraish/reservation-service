DROP TABLE IF EXISTS RESERVATION;

CREATE TABLE RESERVATION
(
    id             INT AUTO_INCREMENT PRIMARY KEY,
    first_name     VARCHAR(250) NOT NULL,
    last_name      VARCHAR(250) NOT NULL,
    arrival_date   DATE         NOT NULL,
    departure_date DATE         NOT NULL
);