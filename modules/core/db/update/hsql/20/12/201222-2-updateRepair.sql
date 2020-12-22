alter table CUBATRAINING_REPAIR alter column CENTER_ID rename to CENTER_ID__U36128 ^
alter table CUBATRAINING_REPAIR alter column CENTER_ID__U36128 set null ;
alter table CUBATRAINING_REPAIR drop constraint FK_CUBATRAINING_REPAIR_ON_CENTER ;
drop index IDX_CUBATRAINING_REPAIR_ON_CENTER ;
-- alter table CUBATRAINING_REPAIR add column CAR_SERVICE_CENTER_ID varchar(36) ^
-- update CUBATRAINING_REPAIR set CAR_SERVICE_CENTER_ID = <default_value> ;
-- alter table CUBATRAINING_REPAIR alter column CAR_SERVICE_CENTER_ID set not null ;
alter table CUBATRAINING_REPAIR add column CAR_SERVICE_CENTER_ID varchar(36) not null ;
