-- users: login identity only. Everything else about a person lives in user_profile.
create table users (
    id            bigint generated always as identity primary key,
    email         varchar(255) not null,
    password_hash varchar(255) not null,   -- BCrypt hash, never the plain password
    created_at    timestamptz  not null default now(),
    updated_at    timestamptz  not null default now(),

    constraint uq_users_email       unique (email),
    constraint ck_users_email_lower check (email = lower(email))
);

-- user_profile: personal details, exactly one row per user.
-- user_id is BOTH the primary key and the foreign key (a "shared primary key"),
-- so the database itself guarantees one profile per user.
create table user_profile (
    user_id             bigint primary key references users (id) on delete cascade,
    full_name           varchar(150) not null,
    phone               varchar(30),
    location            varchar(150),
    current_company     varchar(150),
    job_title           varchar(150),   -- not "current_role": reserved word in PostgreSQL
    years_of_experience numeric(3,1),
    linkedin_url        varchar(255),
    github_url          varchar(255),
    updated_at          timestamptz not null default now(),

    constraint ck_profile_experience check (years_of_experience is null
                                            or years_of_experience between 0 and 60)
);

-- skills: many per profile, each with a proficiency label.
create table skills (
    id         bigint generated always as identity primary key,
    profile_id bigint      not null references user_profile (user_id) on delete cascade,
    name       varchar(60) not null,
    level      varchar(20) not null,
    created_at timestamptz not null default now(),

    constraint ck_skills_level check (level in ('BEGINNER', 'INTERMEDIATE', 'EXPERT'))
);

-- One profile cannot have "Java" and "java" twice. Also serves lookups by profile_id.
create unique index uq_skills_profile_name on skills (profile_id, lower(name));
