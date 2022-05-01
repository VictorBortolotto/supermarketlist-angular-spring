create database supermarketlist;
use supermarketlist;

create table user (
	id int primary key auto_increment,
    nickname varchar(300) not null,
    email varchar(300) unique not null,
    password varchar(300) not null
);

create table user_shopping_list (
    id_user int,
    id_shopping_list int
);

create table shopping_list (
    id int primary key auto_increment,
    name varchar(350) not null,
    status boolean default false
);

create table product_shopping_list(
    id_shopping_list int,
    id_product int
);

create table product(
	id int primary key,
    name varchar(300) not null
);

alter table product_shopping_list add foreign key (id_shopping_list) references shopping_list(id);
alter table product_shopping_list add foreign key (id_product) references product(id);
alter table user_shopping_list add foreign key (id_user) references user(id);
alter table user_shopping_list add foreign key (id_shopping_list) references shopping_list(id);

insert into product(id, name) values (1, "MAÇÃ");
insert into product(id, name) values (1, "MAÇÃ");
insert into product(id, name) values (2, "MAMÃO");
insert into product(id, name) values (3, "BANANA");
insert into product(id, name) values (4, "ARROZ");
insert into product(id, name) values (5, "MACARRÃO");
insert into product(id, name) values (6, "SAL");
insert into product(id, name) values (7, "AÇÚCAR");
insert into product(id, name) values (8, "LIMÃO");
insert into product(id, name) values (9, "FEIJÃO");
insert into product(id, name) values (10, "COCA-COLA");
insert into product(id, name) values (11, "PIMENTA");
insert into product(id, name) values (12, "ABACATE");
insert into product(id, name) values (13, "ALFACE AMERICANA");
insert into product(id, name) values (14, "CERVEJA");
insert into product(id, name) values (15, "ÁGUA");
insert into product(id, name) values (16, "LARANJA");
insert into product(id, name) values (17, "MANGA");
insert into product(id, name) values (18, "ABACAXI");
insert into product(id, name) values (19, "NESCAU");
insert into product(id, name) values (20, "GUARANÁ");