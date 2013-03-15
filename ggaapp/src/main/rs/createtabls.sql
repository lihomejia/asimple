create TABLE  ma_stock (
	mastock_Id int AUTO_INCREMENT,
	mastock_Totqty decimal(18,3) default 0,
	mastock_Usedqty decimal(18,3) default 0,
	mastock_Balqty decimal(18,3) default 0,
	mastock_Note varchar(255) default '',
	PRIMARY key (mastock_Id)
);


INSERT INTO ma_stock VALUES ('1', '12345.000', '1234.000', '11111.000', '1111111');
INSERT INTO ma_stock VALUES ('2', '54321.000', '4321.000', '50000.000', '2222222');

insert into ma_stock (mastock_Totqty, mastock_Usedqty, mastock_Balqty, mastock_Note)
select floor(rand()*1001), floor(rand()*1001), floor(rand()*1001), uuid() from  ma_stock