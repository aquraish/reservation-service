INSERT INTO RESERVATION (first_name, last_name, arrival_date, departure_date)
VALUES ('Lokesh', 'Gupta', PARSEDATETIME('01/16/2021', 'MM/dd/yyyy'), PARSEDATETIME('01/17/2021', 'MM/dd/yyyy')),
       ('Deja', 'Vu', PARSEDATETIME('01/20/2021', 'MM/dd/yyyy'), PARSEDATETIME('01/22/2021', 'MM/dd/yyyy')),
       ('Caption', 'America', PARSEDATETIME('01/23/2021', 'MM/dd/yyyy'), PARSEDATETIME('01/26/2021', 'MM/dd/yyyy'));