-- begin CUBATRAINING_CUSTOMER
create table CUBATRAINING_CUSTOMER (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    TYPE varchar(31),
    --
    NAME varchar(255) not null,
    PHONE varchar(255),
    EMAIL varchar(255),
    --
    primary key (ID)
)^
-- end CUBATRAINING_CUSTOMER
-- begin CUBATRAINING_REPAIR
create table CUBATRAINING_REPAIR (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    DESCRIPTION text not null,
    EMPLOYEE_ID uuid not null,
    CAR_SERVICE_CENTER_ID uuid not null,
    --
    primary key (ID)
)^
-- end CUBATRAINING_REPAIR
-- begin CUBATRAINING_CAR_SERVICE_CENTER
create table CUBATRAINING_CAR_SERVICE_CENTER (
    ID uuid,
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
    CITY_ID uuid,
    ADDRESS text,
    AUTHOR_ID uuid,
    --
    primary key (ID)
)^
-- end CUBATRAINING_CAR_SERVICE_CENTER
-- begin CUBATRAINING_EMPLOYEE
create table CUBATRAINING_EMPLOYEE (
    ID uuid,
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
    CAR_SERVICE_CENTER_ID uuid not null,
    --
    primary key (ID)
)^
-- end CUBATRAINING_EMPLOYEE
-- begin CUBATRAINING_CITY
create table CUBATRAINING_CITY (
    ID uuid,
    VERSION integer not null,
    CREATE_TS timestamp,
    CREATED_BY varchar(50),
    UPDATE_TS timestamp,
    UPDATED_BY varchar(50),
    DELETE_TS timestamp,
    DELETED_BY varchar(50),
    --
    NAME varchar(255),
    IS_DEFAULT boolean,
    CODE varchar(255),
    --
    primary key (ID)
)^
-- end CUBATRAINING_CITY
-- begin CUBATRAINING_INDIVIDUAL
create table CUBATRAINING_INDIVIDUAL (
    ID uuid,
    --
    PASSPORT_NO varchar(255) not null,
    --
    primary key (ID)
)^
-- end CUBATRAINING_INDIVIDUAL
-- begin CUBATRAINING_COMPANY
create table CUBATRAINING_COMPANY (
    ID uuid,
    --
    INN varchar(255) not null,
    --
    primary key (ID)
)^
-- end CUBATRAINING_COMPANY
-- begin CUBATRAINING_CAR_SERVICE_CENTER_CUSTOMER_LINK
create table CUBATRAINING_CAR_SERVICE_CENTER_CUSTOMER_LINK (
    CAR_SERVICE_CENTER_ID uuid,
    CUSTOMER_ID uuid,
    primary key (CAR_SERVICE_CENTER_ID, CUSTOMER_ID)
)^
-- end CUBATRAINING_CAR_SERVICE_CENTER_CUSTOMER_LINK
