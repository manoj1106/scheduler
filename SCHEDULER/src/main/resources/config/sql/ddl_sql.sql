create database scheduler_db;

create schema scheduler_db;

create table scheduler_db.user_login
(
    ul_user_name character varying,
    ul_password character varying,
    ul_enabled boolean default true,
    ul_role character varying,
    ul_user_full_name character varying,
    constraint ul_user_name_pkey primary key(ul_user_name)
);

CREATE TABLE scheduler_db.scheduler_job_group
(
    sch_job_group_id bigserial,
    sch_job_group_name character varying NOT NULL,
    created_by character varying NOT NULL,
    created_on timestamp without time zone NOT NULL,
    deleted_on timestamp without time zone,
    deleted_by character varying,
    CONSTRAINT sch_job_group_id_pkey PRIMARY KEY (sch_job_group_id),
    CONSTRAINT sch_job_group_name_ukey UNIQUE (sch_job_group_name)
);