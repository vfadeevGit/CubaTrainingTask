alter table CUBATRAINING_COMPANY add constraint FK_CUBATRAINING_COMPANY_ON_ID foreign key (ID) references CUBATRAINING_CUSTOMER(ID) on delete CASCADE;
