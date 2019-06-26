create database crm;
connect crm;
create table client(id int primary key auto_increment, name varchar(255), surname varchar(255), address varchar(255), phone int);

create table employee(id int primary key auto_increment, name varchar(255), surname varchar(255), address varchar(255), phone int, note varchar(255),
decimal workhours_salary, orderId int);

create table users(id int primary key auto_increment, name varchar(255), surname varchar(255), email varchar(255) UNIQUE);

create table orders(id int primary key auto_increment, order_acceptance_date datetime, planned_repair_start_date datetime, repair_start_date datetime,
order_employee employee, problem_description text, repair_description text, status Status, vehicle Vehicle, oder_cost decimal,
parts_cost decimal, workhours_cost decimal, workhours int, client_id int, vehicle_id int, employee_id int,
foreign key(client_id) references client(id), foreign key(vehicle_id) references vehicle(id), foreign key(employee_id) references employee(id));

create table vehicle(id int primary key auto_increment, model varchar(255), producent varchar(255), production_date date, registration varchar(255),
next_review_date date, client_id int, foreign key(client_id) references client(id));

create table status(id int primary key auto_increment);