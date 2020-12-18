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
    NAME_SERVICE varchar(255) not null,
    PHONE varchar(255) not null,
    CITY_ID varchar(36),
    ADDRESS varchar(255),
    --
    primary key (ID)
);