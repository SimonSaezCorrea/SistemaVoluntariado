-- Descripción general:
-- Archivo que genera las tablas para la base de datos
-- con la propiedad de ser geolocalizada.

-- Creación de extensión de postgis.
CREATE EXTENSION postgis;

-- Creación de tablas.
CREATE TABLE eme_habilidad(
	id NUMERIC(8) PRIMARY KEY,
	id_emergencia NUMERIC(6),
	id_habilidad NUMERIC(4)
);

CREATE TABLE emergencia(
	id NUMERIC(6) PRIMARY KEY,
	nombre VARCHAR(100),
	descrip VARCHAR(400),
	finicio DATE,
	ffin DATE,
	id_institucion NUMERIC(4),
	geom GEOMETRY(Point, 4326)
);

CREATE TABLE estado_tarea(
	id NUMERIC(2) PRIMARY KEY,
	descrip VARCHAR(20)
);

CREATE TABLE habilidad(
	id NUMERIC(4) PRIMARY KEY,
	descrip VARCHAR(100)
);

CREATE TABLE institucion(
	id NUMERIC(4) PRIMARY KEY,
	nombre VARCHAR(100),
	descrip VARCHAR(400)
);

CREATE TABLE ranking(
	id NUMERIC(8) PRIMARY KEY,
	id_voluntario NUMERIC(8),
	id_tarea NUMERIC(8),
	puntaje NUMERIC(3,2),
	flg_invitado NUMERIC(1),
	flg_participa NUMERIC(1)
);

CREATE TABLE tarea(
	id NUMERIC(8) PRIMARY KEY,
	nombre VARCHAR(60),
	descrip VARCHAR(300),
	cant_vol_requeridos NUMERIC(4),
	cant_vol_inscritos NUMERIC(4),
	id_emergencia NUMERIC(6),
	finicio DATE,
	ffin DATE,
	id_estado NUMERIC(2),
	geom GEOMETRY(Point, 4326)
);

CREATE TABLE tarea_habilidad(
	id NUMERIC(8) PRIMARY KEY,
	id_emehab NUMERIC(8),
	id_tarea NUMERIC(8)
);

CREATE TABLE vol_habilidad(
	id NUMERIC(8) PRIMARY KEY,
	id_voluntario NUMERIC(8),
	id_habilidad NUMERIC(8)
);

CREATE TABLE voluntario(
	id NUMERIC(8) PRIMARY KEY,
	id_usuario INTEGER,
	nombre VARCHAR(100),
	geom GEOMETRY(Point, 4326)
);

CREATE TABLE usuario(
	id INTEGER PRIMARY KEY,
	email VARCHAR(100),
	password VARCHAR(100),
	rol VARCHAR(50)
);