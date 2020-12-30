alter table CUBATRAINING_CAR_SERVICE_CENTER alter column NAME_SERVICE rename to NAME_SERVICE__U77662 ^
alter table CUBATRAINING_CAR_SERVICE_CENTER alter column NAME_SERVICE__U77662 set null ;
alter table CUBATRAINING_CAR_SERVICE_CENTER add column AUTHOR_ID varchar(36) ;
alter table CUBATRAINING_CAR_SERVICE_CENTER add column NAME varchar(255) ^
update CUBATRAINING_CAR_SERVICE_CENTER set NAME = '' where NAME is null ;
alter table CUBATRAINING_CAR_SERVICE_CENTER alter column NAME set not null ;
