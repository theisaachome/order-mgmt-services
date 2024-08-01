# CREATE  TABLE IF NOT EXISTS CATEGORY
# (
#     id integer NOT NULL AUTO_INCREMENT PRIMARY KEY ,
#     name varchar(255) NOT NULL ,
#     description VARCHAR(255)
# );
#
# CREATE TABLE  IF NOT EXISTS PRODUCT
# (
#     id integer NOT NULL AUTO_INCREMENT PRIMARY KEY ,
#     name varchar(255) NOT NULL ,
#     description VARCHAR(255),
#     available_quantity DOUBLE precision NOT NULL ,
#     price  numeric(38,2),
#     category_id integer,
#     CONSTRAINT FK_PersonOrder FOREIGN KEY (category_id)
#     REFERENCES CATEGORY(id)
# );

-- Create the category table with AUTO_INCREMENT
# DROP TABLE  category;
CREATE TABLE IF NOT EXISTS category (
                          id INT AUTO_INCREMENT PRIMARY KEY,
                          description VARCHAR(255),
                          name VARCHAR(255)
);


-- Create the product table with AUTO_INCREMENT and foreign key constraint
# DROP TABLE  PRODUCT;
CREATE TABLE  IF NOT EXISTS product (
                         id INT AUTO_INCREMENT PRIMARY KEY,
                         available_quantity DOUBLE precision NOT NULL,
                         description VARCHAR(255),
                         name VARCHAR(255),
                         price DECIMAL(10,2),
                         category_id INT,
                         FOREIGN KEY (category_id) REFERENCES category(id)
);
