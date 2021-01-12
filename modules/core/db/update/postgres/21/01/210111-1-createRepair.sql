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
);