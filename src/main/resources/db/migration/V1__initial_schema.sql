CREATE TABLE maintaining_author (
	id int8 NOT NULL,
	email varchar(255) NULL,
	name varchar(255) NOT NULL,
	site varchar(255) NULL,
	CONSTRAINT maintaining_author_pk PRIMARY KEY (id)
);

CREATE TABLE curriculum (
	id int8 NOT NULL,
	short_name varchar(255) NOT NULL,
	full_name varchar(255) NOT NULL,
	CONSTRAINT curriculum_pk PRIMARY KEY (id)
);

CREATE TABLE subject (
	id int8 NOT NULL,
	name varchar(255) NOT NULL,
	CONSTRAINT subject_pk PRIMARY KEY (id)
);


CREATE TABLE idiom (
	id int8 NOT NULL,
	name varchar(255) NOT NULL,
	CONSTRAINT idiom_pk PRIMARY KEY (id)
);


CREATE TABLE education_level (
	id int8 NOT NULL,
	name varchar(255) NOT NULL,
	short_name varchar(255) NOT NULL,
	CONSTRAINT education_level_pk PRIMARY KEY (id)
);

CREATE TABLE plataform (
	id int8 NOT NULL,
	name varchar(255) NOT NULL,
	CONSTRAINT plataform_pk PRIMARY KEY (id)
);


CREATE TABLE use_license_type (
	id int8 NOT NULL,
	name varchar(255) NOT NULL,
	version varchar(255) NOT NULL,
	CONSTRAINT use_license_type_pk PRIMARY KEY (id)
);


CREATE TABLE object_type (
	id int8 NOT NULL,
	name varchar(255) NOT NULL,
	CONSTRAINT object_type_pk PRIMARY KEY (id)
);


CREATE TABLE education_year (
	id int8 NOT NULL,
	name varchar(255) NOT NULL,
	education_level_id int8 NOT NULL,
	CONSTRAINT education_year_pk PRIMARY KEY (id),
	CONSTRAINT education_year_fk01 FOREIGN KEY (education_level_id) REFERENCES education_level(id)
);


CREATE TABLE learning_object (
	id int8 NOT NULL,
	active bool NOT NULL,
	release_date timestamp NULL,
	description text NULL,
	name varchar(255) NOT NULL,
	thumbnail_path varchar(255) NULL,
	accesses_number int4 NOT NULL,
	version varchar(255) NULL,
	use_license_type_id int8 NULL,
	object_type_id int8 NULL,
	CONSTRAINT learning_object_pk PRIMARY KEY (id),
	CONSTRAINT learning_object_fk02 FOREIGN KEY (use_license_type_id) REFERENCES use_license_type(id),
	CONSTRAINT learning_object_fk03 FOREIGN KEY (object_type_id) REFERENCES object_type(id)
);


CREATE TABLE learning_object_maintaining_author (
	learning_object_id int8 NOT NULL,
	maintaining_author_id int8 NOT NULL,
	CONSTRAINT learning_object_maintaining_author_pk PRIMARY KEY (learning_object_id, maintaining_author_id),
	CONSTRAINT learning_object_maintaining_author_fk01 FOREIGN KEY (maintaining_author_id) REFERENCES maintaining_author(id),
	CONSTRAINT learning_object_maintaining_author_fk02 FOREIGN KEY (learning_object_id) REFERENCES learning_object(id)
);


CREATE TABLE learning_object_idiom (
	learning_object_id int8 NOT NULL,
	idiom_id int8 NOT NULL,
	CONSTRAINT learning_object_idiom_pk PRIMARY KEY (learning_object_id, idiom_id),
	CONSTRAINT learning_object_idiom_fk01 FOREIGN KEY (learning_object_id) REFERENCES learning_object(id),
	CONSTRAINT learning_object_idiom_fk02 FOREIGN KEY (idiom_id) REFERENCES idiom(id)
);


CREATE TABLE content_theme (
	id int8 NOT NULL,
	name varchar(255) NOT NULL,
	curriculum_id int8 NOT NULL,
	subject_id int8 NULL,
	CONSTRAINT content_theme_pk PRIMARY KEY (id),
	CONSTRAINT content_theme_fk01 FOREIGN KEY (subject_id) REFERENCES subject(id),
	CONSTRAINT content_theme_fk02 FOREIGN KEY (curriculum_id) REFERENCES curriculum(id)
);


CREATE TABLE descriptor (
	id int8 NOT NULL,
	code varchar(255) NULL,
	description varchar(255) NULL,
	content_theme_id int8 NULL,
	education_level_id int8 NULL,
	CONSTRAINT descriptor_pk PRIMARY KEY (id),
	CONSTRAINT descriptor_fk01 FOREIGN KEY (content_theme_id) REFERENCES content_theme(id),
	CONSTRAINT descriptor_fk02 FOREIGN KEY (education_level_id) REFERENCES education_level(id)
);



CREATE TABLE skill (
	id int8 NOT NULL,
	code varchar(255) NULL,
	acquirements text NULL,
	description text NULL,
	education_year_id int8 NULL,
	content_theme_id int8 NULL,
	CONSTRAINT skill_pk PRIMARY KEY (id),
	CONSTRAINT skill_fk01 FOREIGN KEY (content_theme_id) REFERENCES content_theme(id),
	CONSTRAINT skill_fk02 FOREIGN KEY (education_year_id) REFERENCES education_year(id)
);


CREATE TABLE learning_object_descriptor (
	learning_object_id int8 NOT NULL,
	descriptor_id int8 NOT NULL,
	CONSTRAINT learning_object_descriptor_pk PRIMARY KEY (learning_object_id, descriptor_id),
	CONSTRAINT learning_object_descriptor_fk01 FOREIGN KEY (learning_object_id) REFERENCES learning_object(id),
	CONSTRAINT learning_object_descriptor_fk02 FOREIGN KEY (descriptor_id) REFERENCES descriptor(id)
);

CREATE TABLE learning_object_skill (
	learning_object_id int8 NOT NULL,
	skill_id int8 NOT NULL,
	CONSTRAINT learning_object_skill_pk PRIMARY KEY (learning_object_id, skill_id),
	CONSTRAINT learning_object_skill_fk01 FOREIGN KEY (learning_object_id) REFERENCES learning_object(id),
	CONSTRAINT learning_object_skill_fk02 FOREIGN KEY (skill_id) REFERENCES skill(id)
);

CREATE TABLE learning_object_plataform (
	learning_object_id int8 NOT NULL,
	plataform_id int8 NOT NULL,
	access_type varchar(255) NOT NULL,
	link text NOT NULL,
	CONSTRAINT learning_object_skill_fk01 FOREIGN KEY (learning_object_id) REFERENCES learning_object(id),
	CONSTRAINT learning_object_skill_fk02 FOREIGN KEY (plataform_id) REFERENCES plataform(id)
);


CREATE SEQUENCE sq_education_year_id INCREMENT BY 1
START WITH 1
MAXVALUE 99999999999
MINVALUE 1
CACHE 10;

CREATE SEQUENCE sq_maintaining_author_id INCREMENT BY 1
START WITH 1
MAXVALUE 99999999999
MINVALUE 1
CACHE 10;

CREATE SEQUENCE sq_curriculum_id INCREMENT BY 1
START WITH 1
MAXVALUE 99999999999
MINVALUE 1
CACHE 10;

CREATE SEQUENCE sq_descriptor_id INCREMENT BY 1
START WITH 1
MAXVALUE 99999999999
MINVALUE 1
CACHE 10;

CREATE SEQUENCE sq_subject_id INCREMENT BY 1
START WITH 1
MAXVALUE 99999999999
MINVALUE 1
CACHE 10;

CREATE SEQUENCE sq_skill_id INCREMENT BY 1
START WITH 1
MAXVALUE 99999999999
MINVALUE 1
CACHE 10;

CREATE SEQUENCE sq_idiom_id INCREMENT BY 1
START WITH 1
MAXVALUE 99999999999
MINVALUE 1
CACHE 10;

CREATE SEQUENCE sq_education_level_id INCREMENT BY 1
START WITH 1
MAXVALUE 99999999999
MINVALUE 1
CACHE 10;

CREATE SEQUENCE sq_learning_object_id INCREMENT BY 1
START WITH 1
MAXVALUE 99999999999
MINVALUE 1
CACHE 10;


CREATE SEQUENCE sq_content_theme_id INCREMENT BY 1
START WITH 1
MAXVALUE 99999999999
MINVALUE 1
CACHE 10;

CREATE SEQUENCE sq_use_license_type_id INCREMENT BY 1
START WITH 1
MAXVALUE 99999999999
MINVALUE 1
CACHE 10;

CREATE SEQUENCE sq_object_type_id INCREMENT BY 1
START WITH 1
MAXVALUE 99999999999
MINVALUE 1
CACHE 10;

