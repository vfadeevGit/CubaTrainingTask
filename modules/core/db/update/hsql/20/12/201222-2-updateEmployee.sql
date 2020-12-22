-- update CUBATRAINING_EMPLOYEE set CAR_SERVICE_CENTER_ID = <default_value> where CAR_SERVICE_CENTER_ID is null ;
alter table CUBATRAINING_EMPLOYEE alter column CAR_SERVICE_CENTER_ID set not null ;
