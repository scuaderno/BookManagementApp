# BookManagementApp

#Description:
	Welcome to our project! This project is a Book Management Application made in Springboot Framework. It allows users to Create, Retrieve, Update and Delete books and users. It is also capable of viewing all records of all statuses of checked out books, returned and not returned. Users can also view according to filter returned and not returned books. With this application, users can seemlesly manage and keep track of all the books  they have in record. We hope you can enjoy and look forward to your contributions. 

#Contributing
	1. Report bugs and open issue to mitigate the problem.
	2. Contribute code to help us utilize this project for futher use. 
	3. Suggestions for improvement and enhancements. 
	4. Documentations to add for additional details.
	
#Instruction
	1. Fork this repository
	2. Clone the forked repository (https://github.com/scuaderno/BookManagementApp.git)
	3. Add your contributions (code or documentation)
	4. Commit and push
	5. Wait for pull request to be merged

#DB: bookdb

#table structure:
CREATE TABLE IF NOT EXISTS bookdb.customer (
	customer_refno INT(10) NOT NULL AUTO_INCREMENT,
	firstname VARCHAR(50) NOT NULL,
	lastname VARCHAR(50) NOT NULL,
	office_email VARCHAR(50) NOT NULL,
	personal_email VARCHAR(50) NOT NULL,
	mobile_number VARCHAR(50) NOT NULL,
	status VARCHAR(50) NOT NULL,
	CONSTRAINT PK_customer_refno PRIMARY KEY (customer_refno)
);


CREATE TABLE IF NOT EXISTS bookdb.books (
    book_refno int NOT NULL AUTO_INCREMENT,
    book_title varchar(255) NOT NULL,
    book_price decimal NOT NULL,
    quantity int NOT NULL,
	year_published int NOT NULL,
	author varchar(255) NOT NULL,
	category varchar(255) NOT NULL,
    CONSTRAINT PK_book_refno PRIMARY KEY (book_refno)
);

CREATE TABLE IF NOT EXISTS bookdb.checkout (
    checkout_refno int NOT NULL AUTO_INCREMENT,
    start_time timestamp NOT NULL,
    end_time timestamp NOT NULL,
    book_id int NOT NULL,
	customer_id int NOT NULL,
	isReturned boolean NOT NULL,
    CONSTRAINT PK_checkout_refno PRIMARY KEY (checkout_refno),
	FOREIGN KEY (book_id) REFERENCES books(book_refno),
	FOREIGN KEY (customer_id) REFERENCES customer(customer_refno)
);



INSERT INTO bookdb.customer (customer_refno, firstname, lastname, office_email, personal_email, mobile_number, status) 
VALUES (1, 'Sharon Grace', 'Cuaderno', 'sharon.cuaderno@tka-malaysia.com.my', 'sharoncuaderno@gmail.com', '+60142918357', 'regular');

INSERT INTO bookdb.customer (customer_refno, firstname, lastname, office_email, personal_email, mobile_number, status) 
VALUES (2, 'Denny', 'Cuaderno', 'den.cuaderno@tka-malaysia.com.my', 'dencuaderno@gmail.com', '+60142918777', 'walk-in');

INSERT INTO bookdb.books (book_refno, book_title, book_price, quantity, year_published, author, category)
VALUES (1, 'David Coperfield', '125.00', '5', '1850', 'Charles Dickens', 'Magic');

INSERT INTO bookdb.books (book_refno, book_title, book_price, quantity, year_published, author, category)
VALUES (2, 'The Little Prince', '100.00', '7', '1943', 'Antoine de Saint-Exupéry', 'Fable');

INSERT INTO bookdb.checkout (checkout_refno, start_time, end_time, book_id, customer_id, isReturned)
VALUES (1, '2023-04-22 10:34:53.44', '2023-04-25 10:34:53.44', '2', '2', 'false');