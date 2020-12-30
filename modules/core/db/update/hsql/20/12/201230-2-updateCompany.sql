-- update CUBATRAINING_COMPANY set INN = <default_value> where INN is null ;
alter table CUBATRAINING_COMPANY alter column INN set not null ;
