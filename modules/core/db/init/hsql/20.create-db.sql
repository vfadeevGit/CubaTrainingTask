-- begin CUBATRAINING_INDIVIDUAL
alter table CUBATRAINING_INDIVIDUAL add constraint FK_CUBATRAINING_INDIVIDUAL_ON_ID foreign key (ID) references CUBATRAINING_CUSTOMER(ID) on delete CASCADE^
-- end CUBATRAINING_INDIVIDUAL
-- begin CUBATRAINING_COMPANY
alter table CUBATRAINING_COMPANY add constraint FK_CUBATRAINING_COMPANY_ON_ID foreign key (ID) references CUBATRAINING_CUSTOMER(ID) on delete CASCADE^
create unique index IDX_CUBATRAINING_COMPANY_UNIQ_INN on CUBATRAINING_COMPANY (INN)^
-- end CUBATRAINING_COMPANY
-- begin CUBATRAINING_REPAIR
alter table CUBATRAINING_REPAIR add constraint FK_CUBATRAINING_REPAIR_ON_CENTER foreign key (CENTER_ID) references CUBATRAINING_CAR_SERVICE_CENTER(ID)^
alter table CUBATRAINING_REPAIR add constraint FK_CUBATRAINING_REPAIR_ON_EMPLOYEE foreign key (EMPLOYEE_ID) references CUBATRAINING_EMPLOYEE(ID)^
create index IDX_CUBATRAINING_REPAIR_ON_CENTER on CUBATRAINING_REPAIR (CENTER_ID)^
create index IDX_CUBATRAINING_REPAIR_ON_EMPLOYEE on CUBATRAINING_REPAIR (EMPLOYEE_ID)^
-- end CUBATRAINING_REPAIR
-- begin CUBATRAINING_CAR_SERVICE_CENTER
alter table CUBATRAINING_CAR_SERVICE_CENTER add constraint FK_CUBATRAINING_CAR_SERVICE_CENTER_ON_CITY foreign key (CITY_ID) references CUBATRAINING_CITY(ID)^
create index IDX_CUBATRAINING_CAR_SERVICE_CENTER_ON_CITY on CUBATRAINING_CAR_SERVICE_CENTER (CITY_ID)^
create index IDX_CUBATRAINING_CAR_SERVICE_CENTER on CUBATRAINING_CAR_SERVICE_CENTER (NAME_SERVICE)^
-- end CUBATRAINING_CAR_SERVICE_CENTER
-- begin CUBATRAINING_EMPLOYEE
alter table CUBATRAINING_EMPLOYEE add constraint FK_CUBATRAINING_EMPLOYEE_ON_CAR_SERVICE_CENTER foreign key (CAR_SERVICE_CENTER_ID) references CUBATRAINING_CAR_SERVICE_CENTER(ID)^
create index IDX_CUBATRAINING_EMPLOYEE_ON_CAR_SERVICE_CENTER on CUBATRAINING_EMPLOYEE (CAR_SERVICE_CENTER_ID)^
create index IDX_CUBATRAINING_EMPLOYEE on CUBATRAINING_EMPLOYEE (LAST_NAME)^
-- end CUBATRAINING_EMPLOYEE
-- begin CUBATRAINING_CITY
create unique index IDX_CUBATRAINING_CITY_UNIQ_CITY_NAME on CUBATRAINING_CITY (CITY_NAME)^
create index IDX_CUBATRAINING_CITY on CUBATRAINING_CITY (CITY_NAME)^
-- end CUBATRAINING_CITY
-- begin CUBATRAINING_CAR_SERVICE_CENTER_CUSTOMER_LINK
alter table CUBATRAINING_CAR_SERVICE_CENTER_CUSTOMER_LINK add constraint FK_CARSERCENCUS_ON_CAR_SERVICE_CENTER foreign key (CAR_SERVICE_CENTER_ID) references CUBATRAINING_CAR_SERVICE_CENTER(ID)^
alter table CUBATRAINING_CAR_SERVICE_CENTER_CUSTOMER_LINK add constraint FK_CARSERCENCUS_ON_CUSTOMER foreign key (CUSTOMER_ID) references CUBATRAINING_CUSTOMER(ID)^
-- end CUBATRAINING_CAR_SERVICE_CENTER_CUSTOMER_LINK
