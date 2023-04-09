create database universitymanagementsystem;

use universitymanagementsystem;

create table studentLogin(UserName varchar(50), Password varchar(50));
insert into studentLogin values('student','student');

Drop table studentLogin;

create table adminLogin(username varchar(50), password varchar(50));
insert into adminLogin values('admin','admin');

create table alumniLogin(username varchar(50), password varchar(50));
insert into alumniLogin values('alumni','alumni');

create table counselorLogin(username varchar(50), password varchar(50));
insert into counselorLogin values('counselor','counselor');

create table studentProfile(enrollmentNo varchar(10), programme varchar(30), dateOfBirth varchar(11));
insert into studentProfile values('197287390','BCA','02-Dec-1998');

CREATE TABLE studentRegistration(UserName varchar(30),FullName varchar(30),Email varchar(50),Password varchar(50),PhoneNumber varchar(15));

create table programme(programme varchar(30));
insert into programme values('BCA');
insert into programme values('MCA');
insert into programme values('BBA');
insert into programme values('BA');
insert into programme values('MA');



