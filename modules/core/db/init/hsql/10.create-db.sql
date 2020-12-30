-- begin CUBATRAINING_CUSTOMER
create table CUBATRAINING_CUSTOMER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    customerType varchar(31),
    --
    NAME varchar(255) not null,
    PHONE varchar(255),
    EMAIL varchar(255),
    --
    primary key (ID)
)^
-- end CUBATRAINING_CUSTOMER
-- begin CUBATRAINING_INDIVIDUAL
create table CUBATRAINING_INDIVIDUAL (
    ID varchar(36) not null,
    --
    PASSPORT_NO varchar(255) not null,
    --
    primary key (ID)
)^
-- end CUBATRAINING_INDIVIDUAL
-- begin CUBATRAINING_COMPANY
create table CUBATRAINING_COMPANY (
    ID varchar(36) not null,
    --
    INN varchar(255),
    --
    primary key (ID)
)^
-- end CUBATRAINING_COMPANY
-- begin CUBATRAINING_REPAIR
create table CUBATRAINING_REPAIR (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    DESCRIPTION varchar(255) not null,
    EMPLOYEE_ID varchar(36) not null,
    CAR_SERVICE_CENTER_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end CUBATRAINING_REPAIR
-- begin CUBATRAINING_CAR_SERVICE_CENTER
create table CUBATRAINING_CAR_SERVICE_CENTER (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255) not null,
    PHONE varchar(255) not null,
    CITY_ID varchar(36),
    ADDRESS varchar(255),
    AUTHOR_ID varchar(36),
    --
    primary key (ID)
)^
-- end CUBATRAINING_CAR_SERVICE_CENTER
-- begin CUBATRAINING_EMPLOYEE
create table CUBATRAINING_EMPLOYEE (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    FIRST_NAME varchar(255) not null,
    LAST_NAME varchar(255) not null,
    BIRTH_DATE date not null,
    EMAIL varchar(255),
    SALARY decimal(19, 2),
    CAR_SERVICE_CENTER_ID varchar(36) not null,
    --
    primary key (ID)
)^
-- end CUBATRAINING_EMPLOYEE
-- begin CUBATRAINING_CITY
create table CUBATRAINING_CITY (
    ID varchar(36) not null,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    CITY_NAME varchar(255) not null,
    IS_DEFAULT_CITY boolean,
    CITY_CODE varchar(255),
    --
    primary key (ID)
)^
-- end CUBATRAINING_CITY
-- begin CUBATRAINING_CAR_SERVICE_CENTER_CUSTOMER_LINK
create table CUBATRAINING_CAR_SERVICE_CENTER_CUSTOMER_LINK (
    CAR_SERVICE_CENTER_ID varchar(36) not null,
    CUSTOMER_ID varchar(36) not null,
    primary key (CAR_SERVICE_CENTER_ID, CUSTOMER_ID)
)^
-- end CUBATRAINING_CAR_SERVICE_CENTER_CUSTOMER_LINK
