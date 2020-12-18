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
