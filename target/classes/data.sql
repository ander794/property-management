INSERT INTO property (id,address, price, acquisition_date,created_at) VALUES
    (1,'Budapest, Erzsébet tér, 1051',300000000, '2011-03-12','2019-04-24');
    
-- INSERT INTO user (id,name,password,email_address) VALUES
-- 	('1','admin','admin','demo@gmail.com')  

--Insert Roles to DB
insert into role(id,name)
	values(1,'USER');
insert into role(id,name)
	values(2,'ADMIN');
		
insert into user(id,name,password)
	values(100000,'admin','$2a$10$Q6k7NPc.BEVDG22z7vYcAuKme/ejJwvvS6UX8m.1ZHmHxDk/YxQRO');
	
insert into user_role(user_id,role_id)
	values(100000,2);