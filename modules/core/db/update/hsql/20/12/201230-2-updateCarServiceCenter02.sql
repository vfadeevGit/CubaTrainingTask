alter table CUBATRAINING_CAR_SERVICE_CENTER add constraint FK_CUBATRAINING_CAR_SERVICE_CENTER_ON_AUTHOR foreign key (AUTHOR_ID) references SEC_USER(ID);
create index IDX_CUBATRAINING_CAR_SERVICE_CENTER_ON_AUTHOR on CUBATRAINING_CAR_SERVICE_CENTER (AUTHOR_ID);
