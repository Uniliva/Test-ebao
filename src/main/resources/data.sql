
insert into TBL_Bill (CREATED_TIME,AMOUNT,DUE_DATE) values('2019-01-18', 100,'2019-03-20'); 
insert into TBL_Bill (CREATED_TIME,AMOUNT,DUE_DATE) values('2019-02-18', 80,'2019-03-20'); 
insert into TBL_Bill (CREATED_TIME,AMOUNT,DUE_DATE) values('2019-03-18', 10,'2019-03-20'); 
insert into TBL_Bill (CREATED_TIME,AMOUNT,DUE_DATE) values('2019-01-10', 20,'2019-01-15'); 
insert into TBL_Bill (CREATED_TIME,AMOUNT,DUE_DATE) values('2019-02-12', 50,'2019-02-13'); 
insert into TBL_Bill (CREATED_TIME,AMOUNT,DUE_DATE) values('2019-03-20', 100,'2019-03-25'); 


insert into TBL_ADJUSTMENT (Bill_ID,STATUS,CREATED_TIME) values(1,'ATIVO','2019-03-20'); 
insert into TBL_ADJUSTMENT (Bill_ID,STATUS,CREATED_TIME) values(2,'ATIVO','2019-03-20'); 
insert into TBL_ADJUSTMENT (Bill_ID,STATUS,CREATED_TIME) values(3,'ATIVO','2019-03-20'); 
insert into TBL_ADJUSTMENT (Bill_ID,STATUS,CREATED_TIME) values(4,'ATIVO','2019-03-20'); 
insert into TBL_ADJUSTMENT (Bill_ID,STATUS,CREATED_TIME) values(5,'ATIVO','2019-01-15'); 
insert into TBL_ADJUSTMENT (Bill_ID,STATUS,CREATED_TIME) values(6,'ATIVO','2019-02-13'); 
insert into TBL_ADJUSTMENT (Bill_ID,STATUS,CREATED_TIME) values(5,'CANCELADO','2019-02-14'); 
insert into TBL_ADJUSTMENT (Bill_ID,STATUS,CREATED_TIME) values(6,'CANCELADO','2019-03-27'); 