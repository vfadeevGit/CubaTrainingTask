alter table CUBATRAINING_COMPANY add column PHONE varchar(255) ;
alter table CUBATRAINING_COMPANY add column DELETED_BY varchar(50) ;
alter table CUBATRAINING_COMPANY add column UPDATE_TS timestamp ;
alter table CUBATRAINING_COMPANY add column EMAIL varchar(255) ;
alter table CUBATRAINING_COMPANY add column DELETE_TS timestamp ;
alter table CUBATRAINING_COMPANY add column UPDATED_BY varchar(50) ;
alter table CUBATRAINING_COMPANY add column NAME varchar(255) ^
update CUBATRAINING_COMPANY set NAME = '' where NAME is null ;
alter table CUBATRAINING_COMPANY alter column NAME set not null ;
alter table CUBATRAINING_COMPANY add column CREATED_BY varchar(50) ;
alter table CUBATRAINING_COMPANY add column CREATE_TS timestamp ;
alter table CUBATRAINING_COMPANY add column VERSION integer ^
update CUBATRAINING_COMPANY set VERSION = 0 where VERSION is null ;
alter table CUBATRAINING_COMPANY alter column VERSION set not null ;
