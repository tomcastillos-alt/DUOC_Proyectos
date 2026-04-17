Proceso conversor
	Definir result, temp Como Real;
	Definir resp Como Entero;
	
	result <- 0;
	
	Repetir
		Escribir "Bienvenido al conversor de Fahrenheit a Celsius y viceversa";
		Escribir "Por favor, seleccione al tipo de unidad que quiere convertir";
		Escribir "1) Fahrenheit a Celsius - 2) Celsius a Fahrenheit";
		Escribir "3) Salir";
		Leer resp;
		Segun resp Hacer
		1:
			Escribir "Usted eligió A) Convertir de Fahrenheit a Celsius.";
			Escribir "Por favor, ingrese la temperatura a convertir";
			Leer temp;
			result <- (temp - 32) / 1.8;
			Escribir "La temperatura en Fahrenheit es ", result;
		2:
			Escribir "Usted eligió B) Convertir de Celsius a Fahrenreit.";
			Escribir "Por favor, ingrese la temperatura a convertir";
			Leer temp;
			result <- (temp * 1.8) + 32;
			Escribir "La temperatura en celsius es ", result;
		3:
			Escribir "Usted eligió salir.";
		De Otro Modo:
			Escribir "Valor inválido. Ingrese un valor correcto para continuar";
		FinSegun
	Hasta Que resp = 3
	Escribir "¡Hasta pronto!";

FinProceso
