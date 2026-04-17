Proceso inventario
	Definir cantidad, precio, contador, subtotal, total, opc, nventas Como Entero;
	Definir nombre Como Caracter;
	
	// Valores inicializados pa que el programa no muera
	
	cantidad <- 0;
	precio <- 0;
	contador <- 0;
	subtotal <- 0;
	total <- 0;
	
	
	Repetir
		Escribir "Bievenido al registro de comprar de Michimart";
		Escribir "Por favor, seleccione una opción";
		Escribir "1 - Registrar venta.";
		Escribir "2 - Análisis del día.";
		Escribir "3 - Salir";
		Leer opc;
		Limpiar Pantalla;
		Segun opc Hacer
			1:
				Escribir "Usted eligió 1 - Registrar venta";
				Escribir "Por favor, ingrese el número de ventas a registrar";
				Leer nventas;
				
				Para contador <- 1 Hasta nventas Hacer
					Escribir "ingresa nombre producto";
					Leer nombre;
					Escribir "precio";
					Leer precio;
					Escribir "cantidad";
					Leer cantidad;
					
					subtotal <- precio * cantidad;
					total <- subtotal + total;
					
					Escribir "Perfecto. Usted registró ", cantidad, " unidades de ", nombre, " vendidas a ", precio;
					Escribir "El total de ventas, hasta ahora, es ", total;
					
				FinPara
			2:
				Escribir "Usted seleccionó 2 - Análisis";
				Escribir "Último registro: ", cantidad, " unidades de ", nombre, " vendidas a ", precio;
				Escribir "El total del día hasta el momento es ", total;
				
			3:
				Escribir "Usted eligió salir";
				opc <- 3;
			De Otro Modo:
				Escribir "Valor inválido. Intente nuevamente";
		FinSegun
	Hasta Que opc = 3
	
FinProceso
