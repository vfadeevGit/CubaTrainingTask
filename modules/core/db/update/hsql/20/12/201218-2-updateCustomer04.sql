alter table CUBATRAINING_CUSTOMER alter column COMPANY_ID rename to COMPANY_ID__U28062 ^
alter table CUBATRAINING_CUSTOMER drop constraint FK_CUBATRAINING_CUSTOMER_ON_COMPANY ;
alter table CUBATRAINING_CUSTOMER alter column INDIVIDUAL_ID rename to INDIVIDUAL_ID__U31257 ^
alter table CUBATRAINING_CUSTOMER drop constraint FK_CUBATRAINING_CUSTOMER_ON_INDIVIDUAL ;
alter table CUBATRAINING_CUSTOMER alter column CUSTOMER_TYPE rename to CUSTOMER_TYPE__U82725 ^
alter table CUBATRAINING_CUSTOMER alter column CUSTOMER_TYPE__U82725 set null ;
