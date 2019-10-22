CREATE TABLE product ( prod_id int not null auto_increment,
prod_name varchar(300) not null,
price double not null,
primary key (prod_id));

CREATE TABLE reviews ( reviews_id int not null auto_increment,
prod_id int,
reviewer_name varchar(300) not null,
constraint reviews_pk primary key (reviews_id),
constraint product_reviews_fk FOREIGN key (prod_id) references product (prod_id));

CREATE TABLE comments ( comments_id int not null auto_increment,
reviews_id  int,
comment varchar(1000) not null,
constraint comments_pk primary key (comments_id ),
constraint reviews_comments_fk FOREIGN key (reviews_id) references reviews (reviews_id));