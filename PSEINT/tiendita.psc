Proceso tiendita
	Definir nombre, nventa Como Caracter;
	Definir precio, subtotal, numventa, ventatotal, contador, opc Como Entero;
	Definir cantidad Como Entero;

	precio <- 0;
	ventatotal <- 0;
	numventa <- 0;
	subtotal <- 0;
	
	Escribir "Bienvenido al registrador de ventas de la tienda Gatito Feliz";
	Escribir "Por favor, ingrese su nombre";
	Leer nombre;
	
	
	
Repetir
		Escribir "Hola ", nombre, " !";
		Escribir "Selecciona una opción";
		Escribir "---------Menu---------";
		Escribir "1- Registrar ventas.";
		Escribir "2- Análisis ventas totales";
		Escribir "3- Salir";
		Leer opc;
	Segun opc Hacer
		1:
			Escribir "Usted seleccionó Registrar venta";
			
			Escribir "Por favor, ingrese el número de ventas.";
			Leer numventa;
			
			Para contador <- 1 Hasta numventa Hacer
				
				Escribir "Por favor, ingrese el valor unitario del producto";
				Leer precio;
				Escribir "Por favor, ingrese el número de productos vendidos";
				Leer cantidad;
				Escribir "Por favor, ingrese el nombre de la venta";
				Leer nventa;
				
				subtotal <- precio * cantidad;
				ventatotal <- ventatotal + subtotal;
			FinPara
			
			Escribir "Ventas registradas. Digite cualquier tecla para continuar";
			Esperar Tecla;
			
		2:
			Escribir "Usted eligió 2- Análisis";
			Escribir "El total ingresos por ventas diario de: ", ventatotal;
			Escribir "Último producto vendido: ", nventa, " $ ", precio;
			Escribir "Presione cualquier tecla para continuar";
			Esperar Tecla;
		3:
			Escribir "Usted eligió salir";
			Escribir "Registro finalizado.";
			Escribir "¡Hasta pronto ", nombre, " !";
		De Otro Modo:
			Escribir "Acción incorrecta. Por favor, ingrese un valor válido";
	FinSegun	
Hasta Que opc = 3;

FinProceso
