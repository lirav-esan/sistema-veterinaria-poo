INSERT INTO Cliente (ID, estado_cliente, nombre, apellidos, fecha_nacimiento, genero, telefono)
VALUES ('C001', '1', 'Luis', 'Ramírez', '1998-05-12', 'M', '948275890');

INSERT INTO Cliente (ID, estado_cliente, nombre, apellidos, fecha_nacimiento, genero, telefono)
VALUES ('C002', '1', 'Ana', 'Fernández', '1995-11-03', 'F', '932384728');

INSERT INTO Cliente (ID, estado_cliente, nombre, apellidos, fecha_nacimiento, genero, telefono)
VALUES ('C003', '1', 'Carlos', 'Gómez', '2000-02-25', 'M', '909971389');

INSERT INTO Cliente (ID, estado_cliente, nombre, apellidos, fecha_nacimiento, genero, telefono)
VALUES ('C004', '1', 'María', 'López', '1997-08-14', 'F', '901273648');

INSERT INTO Cliente (ID, estado_cliente, nombre, apellidos, fecha_nacimiento, genero, telefono)
VALUES ('C005', '1', 'Jorge', 'Torres', '1992-03-10', 'M', '912725162');

INSERT INTO Cliente (ID, estado_cliente, nombre, apellidos, fecha_nacimiento, genero, telefono)
VALUES ('C006', '1', 'Lucía', 'Ríos', '1999-09-21', 'F', '991327625');

INSERT INTO Cliente (ID, estado_cliente, nombre, apellidos, fecha_nacimiento, genero, telefono)
VALUES ('C007', '1', 'Andrés', 'Pérez', '1996-07-18', 'M', '912387489');

INSERT INTO Cliente (ID, estado_cliente, nombre, apellidos, fecha_nacimiento, genero, telefono)
VALUES ('C008', '1', 'Paola', 'Mendoza', '1994-04-07', 'F', '910028345');

INSERT INTO Cliente (ID, estado_cliente, nombre, apellidos, fecha_nacimiento, genero, telefono)
VALUES ('C009', '1', 'Eduardo', 'Silva', '1990-12-30', 'M', '901827394');

INSERT INTO Cliente (ID, estado_cliente, nombre, apellidos, fecha_nacimiento, genero, telefono)
VALUES ('C010', '1', 'Camila', 'Vega', '1993-06-16', 'F', '976283923');



-- select * from Cliente
declare @CODIGO char(4)
declare @NOMBRE varchar(25)
declare @APELLI varchar(25)
declare @ESTADO char(1)
declare @FECHAN date
declare @GENERO char(1)
declare @TELEF varchar(9)

declare CursorPatitasVet cursor for select ID, estado_cliente, nombre, apellidos, fecha_nacimiento, genero, telefono
                                from Cliente 
                            order by 1
print('----------------------------------------')
print('ID     Estado   Nombre y Apellidos			FechaNac	Genero	Telefono')
print('----------------------------------------')
OPEN CursorPatitasVet
FETCH FROM CursorPatitasVet INTO @CODIGO,@ESTADO,@NOMBRE,@APELLI,@FECHAN,@GENERO,@TELEF
WHILE @@FETCH_STATUS=0 
BEGIN
   print @CODIGO + space(3) + @ESTADO + space(8) + @NOMBRE + space(10-len(@NOMBRE)) + @APELLI + 
		 space(18-len(@APELLI)) + convert(varchar,@FECHAN) + space(2) + @GENERO + space(7) + @TELEF
   FETCH FROM CursorPatitasVet INTO @CODIGO,@ESTADO,@NOMBRE,@APELLI,@FECHAN,@GENERO,@TELEF
END
print('----------------------------------------')
CLOSE CursorPatitasVet
DEALLOCATE CursorPatitasVet

