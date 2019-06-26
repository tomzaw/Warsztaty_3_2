connect crm;
insert into client(name, surname), address, phone) values("A1","A1","A1",0001);
insert into client(name, surname), address, phone) values("A2","A2","A2",0002);
insert into client(name, surname), address, phone) values("A4","A4","A4",0004);
insert into client(name, surname), address, phone) values("A5","A5","A5",0005);

insert into employee(name, surname, address, phone, note, workhours_salary, orderId) values("A1","A1","A1","1001","A1", 20, 1);
insert into employee(name, surname, address, phone, note, workhours_salary, orderId) values("A2","A2","A2","1002","A2", 20, 1);
insert into employee(name, surname, address, phone, note, workhours_salary, orderId) values("A4","A4","A4","1004","A4", 20, 2);
insert into employee(name, surname, address, phone, note, workhours_salary, orderId) values("A5","A5","A5","1005","A5", 20, 4);

insert into users(name, surname, email) values("A1","A1","a1@foo.com");
insert into users(name, surname, email) values("A2","A2","a2@foo.com");

insert into orders(order_acceptance_date, planned_repair_start_date, repair_start_date, order_employee, problem_description, repair_description,
status, vehicle, oder_cost, parts_cost, workhours_cost, workhours, client_id, vehicle_id, employee_id)
values(now(), "2020-01-01T00-00-00", "2020-01-01T00-00-00", null, "A1", "A1", null, null, 1000, 500, 500, 100, 1, 1, 1);

insert into vehicle(model, producent, production_date, registration, next_review_date, client_id)
values("A1", "A1", "2019-01-01", "A100", "2020-01-01", 1);

insert into vehicle(model, producent, production_date, registration, next_review_date, client_id)
values("A2", "A2", "2019-01-01", "A200", "2020-01-01", 1);

insert into vehicle(model, producent, production_date, registration, next_review_date, client_id)
values("A4", "A4", "2019-01-01", "A400", "2020-01-01", 2);

insert into vehicle(model, producent, production_date, registration, next_review_date, client_id)
values("A5", "A5", "2019-01-01", "A500", "2020-01-01", 4);
