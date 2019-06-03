INSERT INTO property (id,address, price, acquisition_date,created_at) VALUES
    (1,'Budapest, Erzsébet tér, 1051',300000000, '2011-03-12','2019-04-24');
    
--INSERT INTO user_entity (id,name,password,email_address,created_at) VALUES
-- 	('1','admin','admin','demo@gmail.com',GETDATE());

--Insert Roles to DB
insert into role_entity(id,name,created_at)
	values(1,'USER',current_date);
insert into role_entity(id,name,created_at)
	values(2,'ADMIN',current_date);
		
insert into user_entity(id,name,password,created_at)
	values(100000,'admin','$2a$10$Q6k7NPc.BEVDG22z7vYcAuKme/ejJwvvS6UX8m.1ZHmHxDk/YxQRO',current_date);
	
insert into user_role(user_id,role_id)
	values(100000,2);