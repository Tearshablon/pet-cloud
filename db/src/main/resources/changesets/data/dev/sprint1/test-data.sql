--liquibase formatted sql logicalFilePath:changesets/data/dev

--changeSet dshablov:test-data-01
insert into db.test (
    id,
    code,
    created_by,
    creation_date,
    last_updated_by,
    last_update_date,
    object_version_number
)
select nextval('db.test_s'),
       'code',
       current_user,
       current_timestamp,
       current_user,
       current_timestamp,
       0;