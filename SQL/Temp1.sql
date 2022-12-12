create table "Temp1"
(
    id                     serial
        constraint temp1_pk
            primary key,
    "RegisterID"           int,
    "RegisterName"         varchar(1024),
    "QueryID"              int,
    "QueryName"            varchar(512),
    "PublishAsAdhocSurvey" int,
    "isPagingEnabled"      boolean
);

