drop database if EXISTS `keywords`;
create database `keywords`;
use keywords;
drop table if EXISTS `lan`;
create table lan
(
    lan varchar(20) PRIMARY key not null
);
drop table if EXISTS `words`;
create table words
(
    id       int PRIMARY key auto_increment not null,
    type     VARCHAR(5)                     not null,
    keyword  VARCHAR(20)                    not null,
    rightkey varchar(20)                    null,
    lan      varchar(20)                    not null,
    FOREIGN key (lan) REFERENCES lan (lan)
);