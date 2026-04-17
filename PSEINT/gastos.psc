Proceso gastos
	Definir nombre, nombre_gasto Como Caracter;
	Definir gasto, gastototal, numgastos, op, cont Como Entero;
	
	gasto <- 0;
	Escribir "Bienvenido al programa de Registro de gastos diarios";
	
	Escribir "Por favor, ingrese su nombre";
	Leer nombre;
	
	Repetir
		Escribir "Por favor, ", nombre, " seleccione una de las siguientes opciones para continuar";
		Escribir "1 - Registro de gastos diarios / 2 - Mostrar análisis del total / 3 - Salir";
		Leer op;
		Segun op Hacer
			1:
				Escribir "Ingrese el número de gastos. Este debe ser un número entero mayor o igual a 2.";
				gastototal <- 0;
				Leer numgastos;
				
				Si numgastos < 2 Entonces
					Repetir 
					Escribir "Error: mínimo 2 gastos. Intente nuevamente";
					Leer numgastos;
				Hasta Que numgastos >= 2;
				FinSi
				
				Para cont<-1 Hasta numgastos Hacer
					Escribir "Ingrese el nombre del gasto";
					Leer nombre_gasto;
					Escribir "Ingrese la cantidad del gasto a registrar.";
					Leer gasto;
					gastototal <- gastototal + gasto;
				FinPara
				Escribir "Gastos registrados. Presione cualquier tecla para continuar.";
				Esperar Tecla;
				
				
			2:
				Escribir "El total de gastos diarios es: ", gastototal;
				Escribir "Último gasto registrado: ", nombre;
				Si gastototal > 50000 Entonces
					Escribir "Atención: Gasto diario elevado.";
				SiNo
					Escribir "Observación: Gasto diario controlado";
				FinSi
				Escribir "Presione cualquier tecla para continuar.";
				Esperar Tecla;
			3:
				Escribir "Usted eligió salir del programa. Hasta luego!";
				Escribir "Fin del registro";
				op <- 3;
				
		FinSegun
	Hasta Que op = 3
		
	
FinProceso
