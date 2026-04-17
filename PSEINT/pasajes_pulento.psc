Proceso pasajes
	Definir nombre, rut, confirmacion, confirmacion2, s, A, B, C, D, E, F Como Caracter;
	Definir stgo, valpo, conce, intento, opcion, opcion2, destino, preciofinal, descuento Como Entero;
	
	stgo <- 10000;
	valpo <- 8000;
	conce <- 15000;
	descuento <- 0;
	
	intento <- 0;
	A <- "Santiago";
	B <- "Valparaíso";
	C <- "Concepción";
	D <- "Normal";
	E <- "Semi-Cama";
	F <- "Cama";
	
	Mientras intento <= 5 Hacer
		Escribir "Bienvenido a la interfaz básica de EmerBus para comprar pasajes";
		Escribir "Por favor, ingrese su nombre";
		Leer nombre;
		Escribir "Por favor, ingrese su RUT";
		Leer rut;
		Escribir "¿Es usted estudiante? s/n";
		Leer s;
		Si s = "s" Entonces
			stgo <- 10000 - 2000;
			valpo <- 8000 - 2000;
			conce <- 15000 - 2000;
			Escribir "Usted tendrá un descuento de 2000 pesos por ser estudiante.";
		Sino 
			Escribir "Usted no es estudiante. Las tarifas se mantendrán.";
		FinSi
		
		Escribir "Por favor, ingrese su destino";
		Escribir "Destinos: 1) Santiago ($10.000), 2) Valparaíso ($8000), 3) Concepción ($15000)";
		Leer opcion;
		Segun opcion Hacer
			1:
				destino <- stgo;
				Escribir "Usted ha elegido: Santiago. El precio base de su pasaje es ", destino, " . Presione cualquier tecla para continuar";
				Leer confirmacion;
				confirmacion <- A;
			2:
				destino <- valpo;
				Escribir "Usted ha elegido: Valparaíso. El precio base de su pasaje es ", destino, " . Presione cualquier tecla para continuar";
				Leer confirmacion;
				confirmacion <- B;
			3:
				destino <- conce;
				Escribir "Usted ha elegido: Concepción. El precio base de su pasaje es ", destino, ". Presione cualquier tecla para continuar";
				Leer confirmacion;
				confirmacion <- C;
			De Otro Modo:
				Escribir "Opcion no válida. Intente nuevamente.";
		FinSegun
		
		Escribir "Selecciones su asiento";
		Escribir "1) Normal, 2) Semi-Cama (+20%), 3) Cama (+40%)";
		Leer opcion2;
		Segun opcion2 Hacer
			1:
				Escribir "Usted ha elegido un asiento normal";
				Escribir "El precio final de su pasaje es ", destino, ". Presione cualquier tecla para continuar.";
				Leer confirmacion2;
				confirmacion2 <- D;
			2:
				Escribir "Usted ha elegido un asiento Semi-Cama (+20% de recargo)";
				Escribir "El precio final de su pasaje es ", destino + destino*0.20, ". Presione cualquier tecla para continuar.";
				Leer confirmacion2;
				confirmacion2 <- D;
			3:
				Escribir "Usted ha elegido un asiento Cama (+40% de recargo)";
				Escribir "El precio final de su pasaje es ", destino + destino*0.40, ". Presione cualquier tecla para continuar.";
				Leer confirmacion2;
				confirmacion2 <- D;
		FinSegun
		
		Escribir "Antes de terminar, los datos de su compra son: ";
		Escribir "Nombre: ", nombre, " Rut: ", rut;
		Escribir "Usted eligió: ", " Destino - ", confirmacion, " Asiento: ", confirmacion2; 
		Escribir "Precio final: ", destino;
		intento <- intento + 1;
		Escribir "Ha terminado su compra. Lleva ", intento, " intentos de 5";
	FinMientras
FinProceso
