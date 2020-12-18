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
    CENTER_ID varchar(36) not null,
    EMPLOYEE_ID varchar(36) not null,
    --
    primary key (ID)
);