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
);