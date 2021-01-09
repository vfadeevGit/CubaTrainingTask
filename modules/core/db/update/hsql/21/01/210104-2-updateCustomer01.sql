alter table CUBATRAINING_CUSTOMER add column PASSPORT_NO varchar(255) ^
update CUBATRAINING_CUSTOMER set PASSPORT_NO = '' where PASSPORT_NO is null ;
alter table CUBATRAINING_CUSTOMER alter column PASSPORT_NO set not null ;
-- alter table CUBATRAINING_CUSTOMER add column INN varchar(255) ^
-- update CUBATRAINING_CUSTOMER set INN = <default_value> ;
-- alter table CUBATRAINING_CUSTOMER alter column INN set not null ;
alter table CUBATRAINING_CUSTOMER add column INN varchar(255) ;
