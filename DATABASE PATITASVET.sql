create DATABASE PatitasVet

use database PatitasVet

create table Empleado( 
	ID char(4) primary key,
	nombre nvarchar(25),
	apellidos nvarchar (20),
	fecha_nacimiento date,
	genero char(1),
	tipo_doc char(1),
	num_documento varchar(8),
	direccion nvarchar(30),
	telefono varchar(9),
	correo nvarchar(15))
	
create table Cliente(
	ID char(4) primary key,
	estado_cliente char(1),
	nombre nvarchar(25),
	apellidos nvarchar (20),
	fecha_nacimiento date,
	genero char(1),
	tipo_doc char(1),
	num_documento varchar(8),
	direccion nvarchar(30),
	telefono varchar(9),
	correo nvarchar(15),
	ciudad nvarchar(15),
	distrito nvarchar(15),
	fecha_registro date default getdate())
	
create table Tipos_Mascota(
	ID char(4) primary key,
	nombre nvarchar(15))
	
create table Concepto(
	ID char(2) primary key,
	concepto nvarchar(20))
	
create table Paciente(
	ID char(4) primary key,
	ID_titular char(4),
	nombre nvarchar(25),
	apellidos nvarchar (20),
	tipo char(4),
	fecha_nacimiento date,
	fecha_fallecimiento date null,
	sexo char(1),
	color nvarchar(10),
	esterilizado bit,
	longitud int,
	altura int,
	peso int,
	morfologia nvarchar(15),
	grupo_sanguineo nchar(3),
	microchip bit,
	tatuaje bit,
	observaciones nvarchar(30),
	constraint fk_paciente_cliente foreign key(ID_titular) references Cliente(ID),
	constraint fk_paciente_tiposmascota foreign key(tipo) references Tipos_Mascota(ID))
	
create table Registro(
	ID char(4) primary key,
	fecha date default getdate(),
	hora TIME(0) DEFAULT CONVERT(TIME(0), GETDATE()),
	ID_mascota char(4),
	ID_empleado char(4),
	constraint fk_registro_paciente foreign key(ID_mascota) references Paciente(ID),
	constraint fk_registro_empleado foreign key(ID_empleado) references Empleado(ID))
	
create table Tipos_Diagnostico(
	ID char(4) primary key,
	diagnostico nvarchar(30))
	
create table Diagnostico(
	ID char(4),
	ID_medico char(4),
	diagnostico char(4),
	constraint fk_diagnostico_registro foreign key(ID) references Registro(ID),
	constraint fk_diagnostico_empleado foreign key(ID_medico) references Empleado(ID),
	constraint fk_diagnostico_tiposdiagnostico foreign key(diagnostico) references Tipos_Diagnostico(ID))
	
create table Estetica(
	ID char(4),
	ID_empleado char(4),
	concepto char(2),
	constraint fk_estetica_registro foreign key(ID) references Registro(ID),
	constraint fk_estetica_empleado foreign key(ID_empleado) references Empleado(ID),
	constraint fk_estetica_concepto foreign key(concepto) references Concepto(ID))
	
create table Accesos(
	ID char(4),
	usuario nvarchar(10),
	contra nvarchar(15),
	constraint fk_accesos_empleados foreign key(ID) references Empleado(ID))

create table Tipos_Vacuna(
	ID char(3) primary key,
	vacuna nvarchar(15))
	
create table Vacunas(
	ID_paciente char(4),
	ID_vacuna char(3),
	constraint fk_vacunas_paciente foreign key(ID_paciente) references Paciente(ID),
	constraint fk_vacunas_tiposvacuna foreign key(ID_vacuna) references Tipos_Vacuna(ID))
