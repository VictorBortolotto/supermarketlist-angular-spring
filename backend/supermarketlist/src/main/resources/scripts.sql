create database supermarketlist;
use supermarketlist;

create table user (
	id int primary key auto_increment,
    nickname varchar(300) not null,
    email varchar(300) unique not null,
    password varchar(300) not null
);

create table intens_list(
    id_user int,
    id_product int,
    status boolean default false
);

create table product(
	id int primary key,
    name varchar(300) not null
);

alter table intens_list add foreign key (id_user) references user(id);
alter table intens_list add foreign key (id_product) references product(id);