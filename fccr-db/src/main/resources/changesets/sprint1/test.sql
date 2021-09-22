--liquibase formatted sql logicalFilePath:changesets/sprint1

--changeSet dshablov:test-01
create sequence fccr.test_s;

create table fccr.test (
  id                    bigint            not null,
  code                  varchar(50)       not null,
  created_by            varchar(50)       not null,
  creation_date         timestamp without time zone not null,
  last_updated_by       varchar(50)       not null,
  last_update_date      timestamp without time zone not null,
  object_version_number bigint            not null
);

alter table fccr.test add constraint test_pk primary key (id);

create unique index test_u1 on fccr.test (code);