alter table CUBATRAINING_CITY alter column IS_DEFAULT_CITY rename to IS_DEFAULT_CITY__U46309 ^
alter table CUBATRAINING_CITY alter column CITY_NAME rename to CITY_NAME__U73404 ^
alter table CUBATRAINING_CITY alter column CITY_NAME__U73404 set null ;
alter table CUBATRAINING_CITY add column IS_DEFAULT boolean ;
alter table CUBATRAINING_CITY add column NAME varchar(255) ^
update CUBATRAINING_CITY set NAME = '' where NAME is null ;
alter table CUBATRAINING_CITY alter column NAME set not null ;
