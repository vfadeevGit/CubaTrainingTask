alter table CUBATRAINING_REPAIR add constraint FK_CUBATRAINING_REPAIR_ON_CENTER foreign key (CENTER_ID) references CUBATRAINING_CAR_SERVICE_CENTER(ID);
alter table CUBATRAINING_REPAIR add constraint FK_CUBATRAINING_REPAIR_ON_EMPLOYEE foreign key (EMPLOYEE_ID) references CUBATRAINING_EMPLOYEE(ID);
create index IDX_CUBATRAINING_REPAIR_ON_CENTER on CUBATRAINING_REPAIR (CENTER_ID);
create index IDX_CUBATRAINING_REPAIR_ON_EMPLOYEE on CUBATRAINING_REPAIR (EMPLOYEE_ID);
