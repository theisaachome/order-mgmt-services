CREATE  TABLE IF NOT EXISTS CATEGORY
(
    id integer NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    name varchar(255) NOT NULL ,
    description VARCHAR(255)
);

CREATE TABLE  IF NOT EXISTS PRODUCT
(
    id integer NOT NULL AUTO_INCREMENT PRIMARY KEY ,
    name varchar(255) NOT NULL ,
    description VARCHAR(255),
    available_quantity DOUBLE precision NOT NULL ,
    price  numeric(38,2),
    category_id integer,
    CONSTRAINT FK_PersonOrder FOREIGN KEY (category_id)
    REFERENCES CATEGORY(id)
);
