create database universitymanagementsystem;

use universitymanagementsystem;

create table admissionLogin(id int NOT NULL auto_increment,primary key(id),UserName varchar(50), Password varchar(50));
insert into admissionLogin (UserName,Password) values('student','student');


create table studentLogin(EnrollmentNumber varchar(12), Programme varchar(10), dateOfBirth varchar(12));
insert into studentLogin values('197287390','BCA', '02-Dec-1998');


create table adminLogin(username varchar(50), password varchar(50));
insert into adminLogin values('admin','admin');




create table alumniLogin(username varchar(50), password varchar(50));
insert into alumniLogin values('alumni','alumni');

create table counselorLogin(username varchar(50), password varchar(50));
insert into counselorLogin values('counselor','counselor');

create table studentProfile(enrollmentNo varchar(10), programme varchar(30), dateOfBirth varchar(11));
insert into studentProfile values('197287390','BCA','02-Dec-1998');

CREATE TABLE studentRegistration(id int NOT NULL auto_increment,primary key(id), UserName varchar(30),FullName varchar(30),Email varchar(50),Password varchar(50),PhoneNumber varchar(15));






Create table citizenShip (id int NOT NULL auto_increment, country varchar(30), primary key (id));

INSERT INTO citizenShip (country) VALUES ('India');
INSERT INTO citizenShip (country) VALUES ('Pakistan');
INSERT INTO citizenShip (country) VALUES ('Afganistan');
INSERT INTO citizenShip (country) VALUES ('Bangladesh');
INSERT INTO citizenShip (country) VALUES ('Sri Lanka');
INSERT INTO citizenShip (country) VALUES ('Bhutan');
INSERT INTO citizenShip (country) VALUES ('China');
INSERT INTO citizenShip (country) VALUES ('Japan');

create table religion(id int NOT NULL auto_increment, religion varchar(30), primary key (id));
INSERT INTO religion (religion) VALUES ('Hindu');
INSERT INTO religion (religion) VALUES ('Muslim');
INSERT INTO religion (religion) VALUES ('Christian');
INSERT INTO religion (religion) VALUES ('Sikh');
INSERT INTO religion (religion) VALUES ('Jain');
INSERT INTO religion (religion) VALUES ('Buddhist');
INSERT INTO religion (religion) VALUES ('Parsi');
INSERT INTO religion (religion) VALUES ('Jews');
INSERT INTO religion (religion) VALUES ('Other');

CREATE TABLE admissionpersonaldetails(UserName varchar(45),FullName varchar(45), MotherName varchar(45), GuardianRelation varchar(30), GuardianName varchar(45), DateOfBirth varchar(12), Category varchar(35), Gender varchar(15), Citizenship varchar(35), Territory varchar(15), Minority varchar(10), Religion varchar(20), MaritalStatus varchar(15), SocialStatus varchar(30), Email varchar(45), alternateEmail varchar(45), MobileNumber varchar(15), alternateMobileNumber varchar(15), Disability varchar(15), DisabilityCategory varchar(35), otherDisability varchar(50), EmployementStatus varchar(20), scholarshipAmount varchar(20), scholarshipDepartment varchar(15), familyIncome varchar (15), belowPovertyLine varchar(25));

create table admissionprogrammedetails(id int NOT NULL auto_increment, UserName varchar(30), programmeType varchar(30), modeOfStudy varchar(25), programme varchar(30), regionCode varchar(30), studyCenterCode varchar(30), medium varchar(25), primary key (id) );
INSERT INTO admissionprogrammedetails (UserName, programmeType, modeOfStudy, programme, regionCode, studyCenterCode, medium) VALUES ('User','Master','Regular','MCA','Delhi','SGT University','English');

create table centers(id int NOT NULL auto_increment, Region varchar(30), studyCenter varchar(30),primary key (id) );
INSERT INTO centers (Region, studyCenter) VALUES ('Delhi','DTU');
INSERT INTO centers (Region, studyCenter) VALUES ('Delhi','DU');
INSERT INTO centers (Region, studyCenter) VALUES ('Delhi','JNU');
INSERT INTO centers (Region, studyCenter) VALUES ('Delhi','NSIT');
INSERT INTO centers (Region, studyCenter) VALUES ('Delhi','SGT');
INSERT INTO centers (Region, studyCenter) VALUES ('Lucknow','LPU');
INSERT INTO centers (Region, studyCenter) VALUES ('Kanpur','STKU');

CREATE TABLE admissionpersonaldetails(id int NOT NULL auto_increment,primary key (id), UserName varchar(45),FullName varchar(45), MotherName varchar(45), GuardianRelation varchar(30), GuardianName varchar(45), DateOfBirth varchar(12), Category varchar(35), Gender varchar(15), Citizenship varchar(35), Territory varchar(15), Minority varchar(10), Religion varchar(20), MaritalStatus varchar(15), SocialStatus varchar(30), Email varchar(45), alternateEmail varchar(45), MobileNumber varchar(15), alternateMobileNumber varchar(15), Disability varchar(15), DisabilityCategory varchar(35), otherDisability varchar(50), EmployementStatus varchar(20), scholarshipAmount varchar(20), scholarshipDepartment varchar(15), familyIncome varchar (15), belowPovertyLine varchar(25));

INSERT INTO admissionpersonaldetails (UserName, FullName, MotherName, GuardianRelation, GuardianName, DateOfBirth, Category, Gender, Citizenship, Territory, Minority, Religion, MaritalStatus, SocialStatus, Email, alternateEmail, MobileNumber, alternateMobileNumber, Disability, DisabilityCategory, otherDisability, EmployementStatus, scholarshipAmount, scholarshipDepartment, familyIncome, belowPovertyLine) VALUES ('User','Mahesh', 'XYZ', 'Father'"'"'s Name','Pandit','25-Apr-2001','Unreserved (UR)','Male', 'India', 'Rural','No','Hindu','Single','Not Applicable', 'mahesh@gmail.com','maheshwari@gmail.com', '9876543210','9876545678','Yes','Any Other','Nothing','Employed', '100000', 'Other', '200000', 'No');

create table boardname(id int NOT NULL auto_increment, Region varchar(30), boardName varchar(100),primary key (id) );
INSERT INTO boardname (Region, boardName) VALUES ('NEW DELHI','CENTRAL BOARD OF SECONDARY EDUCATION');
INSERT INTO boardname (Region, boardName) VALUES ('NEW DELHI','NATIONAL INSTITUTE OF OPEN SCHOOLING');
INSERT INTO boardname (Region, boardName) VALUES ('NEW DELHI','COUNCIL FOR THE INDIAN SCHOOL CERTIFICATE EXAMINATIONS');
INSERT INTO boardname (Region, boardName) VALUES ('BIHAR','BIHAR SCHOOL EXAMINATION BOARD');
INSERT INTO boardname (Region, boardName) VALUES ('BIHAR','BIHAR BOARD OF OPEN SCHOOLING AND EXAMINATION (BBOSE)');
INSERT INTO boardname (Region, boardName) VALUES ('HARYANA','BOARD OF SCHOOL EDUCATION');
INSERT INTO boardname (Region, boardName) VALUES ('GUJARAT','GUJARAT SECONDARY AND HIGHER SECONDARY EDUCATION BOARD');
INSERT INTO boardname (Region, boardName) VALUES ('RAJASTHAN','BOARD OF SECONDARY EDUCATION');
INSERT INTO boardname (Region, boardName) VALUES ('RAJASTHAN','RAJASTHAN STATE OPEN SCHOOL');
INSERT INTO boardname (Region, boardName) VALUES ('UTTAR PRADESH','U.P. BOARD OF HIGH SCHOOL & INTERMEDIATE EDUCATION');
INSERT INTO boardname (Region, boardName) VALUES ('NEW DELHI','JAMIA MILIA ISLAMIA');
INSERT INTO boardname (Region, boardName) VALUES ('NEW DELHI','INDIAN COUNCIL FOR HINDI & SANSKRIT EDUCATION');

create table location(id int NOT NULL auto_increment, state varchar(30), city varchar(100),primary key (id) );
INSERT INTO location (state, city) VALUES ('DELHI','New Delhi');
INSERT INTO location (state, city) VALUES ('DELHI','South West Delhi');
INSERT INTO location (state, city) VALUES ('DELHI','Central Delhi');
INSERT INTO location (state, city) VALUES ('DELHI','East Delhi');
INSERT INTO location (state, city) VALUES ('DELHI','North Delhi');
INSERT INTO location (state, city) VALUES ('DELHI','North East Delhi');
INSERT INTO location (state, city) VALUES ('DELHI','North West Delhi');
INSERT INTO location (state, city) VALUES ('DELHI','Sahadara');
INSERT INTO location (state, city) VALUES ('DELHI','South East Delhi');
INSERT INTO location (state, city) VALUES ('DELHI','West Delhi');

create table Course(id int NOT NULL auto_increment,Programme varchar(20), CourseCode varchar(15), NameofCourse varchar(40), Credit varchar(2),Semester varchar(2),primary key (id) );
INSERT INTO Course (Programme, CourseCode, NameofCourse, Credit,Semester) VALUES ('BCA','FEG 02','Foundation course in English-2','4','1');
INSERT INTO Course (Programme, CourseCode, NameofCourse, Credit,Semester) VALUES ('BCA','ECO 01','Business Organization','4','1');
INSERT INTO Course (Programme, CourseCode, NameofCourse, Credit,Semester) VALUES ('BCA','BCS 011','Computer Basics and PC Software','3','1');
INSERT INTO Course (Programme, CourseCode, NameofCourse, Credit,Semester) VALUES ('BCA','BCS 012','Mathematics','4','1');
INSERT INTO Course (Programme, CourseCode, NameofCourse, Credit,Semester) VALUES ('BCA','BCSL 013','Computer Basics and PC Software Lab','2','1');
INSERT INTO Course (Programme, CourseCode, NameofCourse, Credit,Semester) VALUES ('BCA','BCSL14','Basics and PC Software Lab','2','2');
INSERT INTO Course (Programme, CourseCode, NameofCourse, Credit,Semester) VALUES ('BCA','BCSL15','Lab','2','2');
INSERT INTO Course (Programme, CourseCode, NameofCourse, Credit,Semester) VALUES ('BCA','BCSL16','Basics','2','2');
INSERT INTO Course (Programme, CourseCode, NameofCourse, Credit,Semester) VALUES ('BCA','BCSL17','PC Software','2','2');

SELECT* FROM Course WHERE Programme = 'bca' && semester = '2' ORDER BY semester LIMIT 1 OFFSET 4;

CREATE TABLE admissionqualificationdetails(id int NOT NULL auto_increment, primary key(id),UserName varchar(40), relevantQualification varchar(45), mainSubjects varchar(100), yearOfPassing varchar(4), division varchar(10), marksPercentage varchar(10), boardName varchar(100));
INSERT INTO admissionqualificationdetails (UserName,relevantQualification,mainSubjects,yearOfPassing,division,marksPercentage,boardName) values ('USER','10+2or its equivalent','Hindi,English','2000','First','80','CBSE');

create table admissioncorrespondencedetails(id int NOT NULL auto_increment, primary key(id),UserName varchar(40), address1 varchar(45), address2 varchar(45), address3 varchar(45), state varchar(25), city varchar(25), pincode varchar(6), mobileNumber varchar(15), email varchar(45));
INSERT INTO admissioncorrespondencedetails (UserName, address1, address2, address3, state, city, pincode, mobileNumber, email) VALUES ('User', 'Address1','address2','address3','state','city','110037','987654543','user@gmail.com');

CREATE TABLE admissionuploadsdocuments(id int NOT NULL auto_increment, primary key(id),UserName varchar(35), DocType VARCHAR(45), FileName varchar(35), File LONGBLOB);

SELECT* FROM Course WHERE Programme = 'bca' && semester = '2' ORDER BY semester LIMIT 1 OFFSET 4;

SELECT DISTINCT city FROM location;

create table programme(id int NOT NULL auto_increment, programmeType varchar(30), online boolean, distance boolean, regular boolean, programmeName varchar(45), programmeCode varchar(10), programmeDurationMin varchar(10),programmeDurationMax varchar(10), programmeEligibility varchar(100), programmeFees varchar(10), medium varchar(25), primary key (id));

INSERT INTO programme (programmeType,distance,regular,programmeName,programmeCode,programmeDurationMin,programmeDurationMax,programmeEligibility,programmeFees,medium) values("xyz",true,true,true,"hgv","bcd","67","78","12","670000","english");

drop table programme