grant connect on database scheduler_db to root;

grant usage on schema scheduler_db to root;

grant select,update,insert,delete on table scheduler_db.user_login to root;

grant select,update,insert,delete on table scheduler_db.scheduler_job_group to root;

grant usage,select on sequence scheduler_db.scheduler_job_group_sch_job_group_id_seq to root;