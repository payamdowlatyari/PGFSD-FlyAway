DROP DATABASE IF EXISTS fly_away;
CREATE DATABASE fly_away;
USE fly_away;

CREATE TABLE Customer(
customer_id INTEGER,
first_name VARCHAR (50) NOT NULL,
last_name VARCHAR (50) NOT NULL,
PRIMARY KEY (customer_id)
);

CREATE TABLE Flight(
flight_id INTEGER,
dep_airport VARCHAR (3) NOT NULL,
arr_airport VARCHAR (3) NOT NULL,
dep_time DATETIME NOT NULL,
arr_time DATETIME NOT NULL,
available_seats INTEGER NOT NULL,
price INTEGER NOT NULL,
PRIMARY KEY (flight_id)
);

CREATE TABLE Ticket(
ticket_id INTEGER NOT NULL AUTO_INCREMENT,
first_name VARCHAR (50) NOT NULL,
last_name VARCHAR (50) NOT NULL,
flight_id INTEGER NOT NULL,
quantity INTEGER DEFAULT 1,
price INTEGER NOT NULL,
status VARCHAR (10) NOT NULL,
PRIMARY KEY (ticket_id)
);


INSERT INTO Flight VALUES (101,'SFO','LAX','2021-12-31 17:30:00','2021-12-31 18:25:00',240,100),
(102,'JFK','LAX','2021-12-31 12:30:00','2021-12-31 15:45:00',320,400),
(103,'LAX','SFO','2021-12-31 20:10:00','2021-12-31 21:05:00',160,120);

INSERT INTO Customer VALUES (1,'Payam','Dowlatyari');

INSERT INTO Ticket VALUES (1,'Payam','Dowlatyari',101,1,100,'Pending');