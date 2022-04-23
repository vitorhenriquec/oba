CREATE TABLE auto_mantenedor (
	id int8 NOT NULL,
	email varchar(255) NULL,
	nome varchar(255) NULL,
	site varchar(255) NULL,
	CONSTRAINT auto_mantenedor_pk PRIMARY KEY (id)
);

CREATE TABLE curriculo (
	id int8 NOT NULL,
	nome_abreviado varchar(255) NULL,
	nome_completo varchar(255) NULL,
	CONSTRAINT curriculo_pk PRIMARY KEY (id)
);

CREATE TABLE disciplina (
	id int8 NOT NULL,
	nome varchar(255) NULL,
	CONSTRAINT disciplina_pk PRIMARY KEY (id)
);


CREATE TABLE idioma (
	id int8 NOT NULL,
	nome varchar(255) NULL,
	CONSTRAINT idioma_pk PRIMARY KEY (id)
);


CREATE TABLE nivel_ensino (
	id int8 NOT NULL,
	nome varchar(255) NULL,
	nome_abreviado varchar(255) NULL,
	CONSTRAINT nivel_ensino_pk PRIMARY KEY (id)
);

CREATE TABLE plataforma (
	id int8 NOT NULL,
	nome varchar(255) NULL,
	CONSTRAINT plataforma_pk PRIMARY KEY (id)
);


CREATE TABLE tipo_licenca_uso (
	id int8 NOT NULL,
	nome varchar(255) NULL,
	versao varchar(255) NULL,
	CONSTRAINT tipo_licenca_uso_pk PRIMARY KEY (id)
);


CREATE TABLE tipo_objeto (
	id int8 NOT NULL,
	nome varchar(255) NULL,
	CONSTRAINT tipo_objeto_pk PRIMARY KEY (id)
);


CREATE TABLE ano_ensino (
	id int8 NOT NULL,
	nome varchar(255) NULL,
	nivel_ensino_id int8 NULL,
	CONSTRAINT ano_ensino_pk PRIMARY KEY (id),
	CONSTRAINT ano_ensino_fk01 FOREIGN KEY (nivel_ensino_id) REFERENCES nivel_ensino(id)
);


CREATE TABLE objeto_aprendizagem (
	id int8 NOT NULL,
	ativo bool NULL,
	data_lancamento timestamp NULL,
	descricao text NULL,
	link text NULL,
	nome varchar(255) NULL,
	path_arquivo varchar(255) NULL,
	quantidade_acessos int4 NULL,
	tipo_visualizacao varchar(255) NULL,
	versao varchar(255) NULL,
	id_tipo_licenca_uso int8 NULL,
	id_plataforma int8 NULL,
	id_tipo_objeto int8 NULL,
	CONSTRAINT objeto_aprendizagem_pk PRIMARY KEY (id),
	CONSTRAINT objeto_aprendizagem_fk01 FOREIGN KEY (id_plataforma) REFERENCES plataforma(id),
	CONSTRAINT objeto_aprendizagem_fk02 FOREIGN KEY (id_tipo_licenca_uso) REFERENCES tipo_licenca_uso(id),
	CONSTRAINT objeto_aprendizagem_fk03 FOREIGN KEY (id_tipo_objeto) REFERENCES tipo_objeto(id)
);


CREATE TABLE objetoaprendizagem_autormantenedor (
	objeto_aprendizagem_id int8 NOT NULL,
	autores_mantenedores_id int8 NOT NULL,
	CONSTRAINT objetoaprendizagem_autormantenedor_fk01 FOREIGN KEY (autores_mantenedores_id) REFERENCES auto_mantenedor(id),
	CONSTRAINT objetoaprendizagem_autormantenedor_fk02 FOREIGN KEY (objeto_aprendizagem_id) REFERENCES objeto_aprendizagem(id)
);


CREATE TABLE objetoaprendizagem_idioma (
	objeto_aprendizagem_id int8 NOT NULL,
	idioma_id int8 NOT NULL,
	CONSTRAINT objetoaprendizagem_idioma_fk01 FOREIGN KEY (objeto_aprendizagem_id) REFERENCES objeto_aprendizagem(id),
	CONSTRAINT objetoaprendizagem_idioma_fk02 FOREIGN KEY (idioma_id) REFERENCES idioma(id)
);


CREATE TABLE tema_conteudo (
	id int8 NOT NULL,
	nome varchar(255) NULL,
	curriculo_id int8 NULL,
	disciplina int8 NULL,
	CONSTRAINT tema_conteudo_pk PRIMARY KEY (id),
	CONSTRAINT tema_conteudo_fk01 FOREIGN KEY (disciplina) REFERENCES disciplina(id),
	CONSTRAINT tema_conteudo_fk02 FOREIGN KEY (curriculo_id) REFERENCES curriculo(id)
);


CREATE TABLE descritor (
	id int8 NOT NULL,
	código varchar(255) NULL,
	descricao varchar(255) NULL,
	tema_conteudo int8 NULL,
	CONSTRAINT descritor_pk PRIMARY KEY (id),
	CONSTRAINT descritor_fk01 FOREIGN KEY (tema_conteudo) REFERENCES tema_conteudo(id)
);



CREATE TABLE habilidade (
	id int8 NOT NULL,
	código varchar(255) NULL,
	conhecimentos text NULL,
	descricao text NULL,
	ano_ensino_id int8 NULL,
	tema_conteudo int8 NULL,
	CONSTRAINT habilidade_pk PRIMARY KEY (id),
	CONSTRAINT habilidade_fk01 FOREIGN KEY (tema_conteudo) REFERENCES tema_conteudo(id),
	CONSTRAINT habilidade_fk02 FOREIGN KEY (ano_ensino_id) REFERENCES ano_ensino(id)
);


CREATE TABLE objetoaprendizagem_descritor (
	objetoaprendizagem int8 NOT NULL,
	descritor_id int8 NOT NULL,
	CONSTRAINT objetoaprendizagem_descritor_pk PRIMARY KEY (objetoaprendizagem, descritor_id),
	CONSTRAINT objetoaprendizagem_descritor_fk01 FOREIGN KEY (objetoaprendizagem) REFERENCES objeto_aprendizagem(id),
	CONSTRAINT objetoaprendizagem_descritor_fk02 FOREIGN KEY (descritor_id) REFERENCES descritor(id)
);


CREATE SEQUENCE sq_ano_ensino_id INCREMENT BY 1
START WITH 1
MAXVALUE 99999999999
MINVALUE 1
CACHE 10;

CREATE SEQUENCE sq_auto_mantenedor_id INCREMENT BY 1
START WITH 1
MAXVALUE 99999999999
MINVALUE 1
CACHE 10;

CREATE SEQUENCE sq_curriculo_id INCREMENT BY 1
START WITH 1
MAXVALUE 99999999999
MINVALUE 1
CACHE 10;

CREATE SEQUENCE sq_descritor_id INCREMENT BY 1
START WITH 1
MAXVALUE 99999999999
MINVALUE 1
CACHE 10;

CREATE SEQUENCE sq_disciplina_id INCREMENT BY 1
START WITH 1
MAXVALUE 99999999999
MINVALUE 1
CACHE 10;

CREATE SEQUENCE sq_habilidade_id INCREMENT BY 1
START WITH 1
MAXVALUE 99999999999
MINVALUE 1
CACHE 10;

CREATE SEQUENCE sq_idioma_id INCREMENT BY 1
START WITH 1
MAXVALUE 99999999999
MINVALUE 1
CACHE 10;

CREATE SEQUENCE sq_nivel_ensino_id INCREMENT BY 1
START WITH 1
MAXVALUE 99999999999
MINVALUE 1
CACHE 10;

CREATE SEQUENCE sq_objeto_aprendizagem_id INCREMENT BY 1
START WITH 1
MAXVALUE 99999999999
MINVALUE 1
CACHE 10;

CREATE SEQUENCE sq_plataforma_id INCREMENT BY 1
START WITH 1
MAXVALUE 99999999999
MINVALUE 1
CACHE 10;

CREATE SEQUENCE sq_tema_conteudo_id INCREMENT BY 1
START WITH 1
MAXVALUE 99999999999
MINVALUE 1
CACHE 10;

CREATE SEQUENCE sq_tipo_licenca_uso_id INCREMENT BY 1
START WITH 1
MAXVALUE 99999999999
MINVALUE 1
CACHE 10;

CREATE SEQUENCE sq_tipo_objeto_id INCREMENT BY 1
START WITH 1
MAXVALUE 99999999999
MINVALUE 1
CACHE 10;

