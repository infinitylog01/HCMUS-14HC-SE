/**
PREFERENCES DOCUMENT:
	data type:
		https://dev.mysql.com/doc/refman/5.1/en/data-types.html
	function & operation:
		https://dev.mysql.com/doc/refman/5.1/en/functions.html
	sql statement syntax:
		https://dev.mysql.com/doc/refman/5.1/en/sql-syntax.html
*/

CREATE TABLE Configuration (
	/* THOI GIAN BAY TOI THIEU | đơn vị seconds */
	minimum_fly_time SMALLINT UNSIGNED NOT NULL,
    /* SO SAN BAY TRUNG GIAN TOI DA */
    maximum_intermediate_airport_amount TINYINT UNSIGNED NOT NULL,
    /* THOI GIAN DUNG TOI THIEU | đơn vị seconds */
    minimum_stop_time SMALLINT UNSIGNED NOT NULL,
    /* THOI GIAN DUNG TOI DA | đơn vị seconds */
    maximum_stop_time SMALLINT UNSIGNED NOT NULL
);

CREATE TABLE Staff(
	/* Identication Number | so CMND */
	id char(10) PRIMARY KEY,
    fullname varchar(50) NOT NULL,
    phone varchar(11) NOT NULL
);

CREATE TABLE Airport(
	id TINYINT UNSIGNED PRIMARY KEY,
    airport_name varchar(50) NOT NULL
);

CREATE TABLE Flight(
	id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
	flight_code CHAR(10) UNIQUE NOT NULL,
    depart_time TIMESTAMP NOT NULL,
    duration MEDIUMINT NOT NULL,
    business_class_tickets TINYINT NOT NULL,
    ecomomy_class_tickets TINYINT NOT NULL,
    /* foreign key point to FlightRoute(route_id) tbl */
    route_id INT UNSIGNED
);

CREATE TABLE FlightRoute(
	route_id INT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    start_airport_id TINYINT UNSIGNED NOT NULL,
    des_airport_id TINYINT UNSIGNED NOT NULL,
    first_med_airport TINYINT UNSIGNED,
    second_med_airport TINYINT UNSIGNED
);

CREATE TABLE Ticket(
	ticket_code char(10) PRIMARY KEY,
    /* foreign key point to Passenger(id) tbl */
    passenger_id char(10),
    /* foreign key point to TicketClass(id) tbl */
    ticket_class TINYINT UNSIGNED NOT NULL,
    /* foreign key point to Flight(id) tbl */
    flight_id INT NOT NULL
);

CREATE TABLE TicketClass(
	id TINYINT UNSIGNED PRIMARY KEY,
    t_class_name char(10),
    price DECIMAL(5,2) /* cách tính giá tiền???*/
    /* có thể lưu tọa độ của mỗi airport -> tính được khoảng cách
		tính giá tiền dựa vào t/g bay và khoảng cách
    */
);

INSERT INTO configuration
VALUES (1800, 2 , 600, 1200);

INSERT INTO configuration
VALUES (1800, 3 , 600, 1200);

Select * from configuration;