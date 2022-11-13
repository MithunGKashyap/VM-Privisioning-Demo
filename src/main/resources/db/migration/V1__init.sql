
create table app_user
(
    id        bigserial
        primary key,
    username  varchar(255) not null,
    password  varchar(255) not null,
    email     varchar(255) not null
        constraint unique_email
            unique,
    mobile_no varchar(255) not null
        constraint unique_mobile_no
            unique,
    role      varchar(255) not null
);

CREATE TABLE IF NOT EXISTS vm_ram
(
    id bigint NOT NULL,
    ram_size character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT vm_ram_pkey PRIMARY KEY (id)
)
;

CREATE TABLE IF NOT EXISTS vm_os
(
    id bigint NOT NULL,
    os_name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT vm_os_pkey PRIMARY KEY (id)
)
;
CREATE TABLE IF NOT EXISTS vm_hard_disk
(
    id bigint NOT NULL,
    hard_disk_size character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT vm_hard_disk_pkey PRIMARY KEY (id)
)
;

CREATE TABLE IF NOT EXISTS vm_cpu
(
    id bigint NOT NULL,
    cpu_type character varying(100) COLLATE pg_catalog."default" NOT NULL,
    CONSTRAINT vm_cpu_pkey PRIMARY KEY (id)
);

CREATE TABLE IF NOT EXISTS user_vm
(
    id bigserial NOT NULL ,
    app_user_id integer NOT NULL references app_user(id) ON DELETE CASCADE,
    vm_os_id integer NOT NULL references vm_os(id),
    vm_ram_id integer NOT NULL references vm_ram(id),
    vm_hard_disk_id integer NOT NULL references vm_hard_disk(id),
    vm_cpu_id integer NOT NULL references vm_cpu(id),
    CONSTRAINT user_vm_pkey PRIMARY KEY (id)
)
;
create unique index comp_key
    on user_vm (app_user_id, vm_os_id, vm_ram_id, vm_hard_disk_id, vm_cpu_id);


