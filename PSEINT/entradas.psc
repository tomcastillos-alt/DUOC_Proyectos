Proceso entradas
		Definir nombre, rut, confirmacion, s, A, B, C, D, E Como Caracter;
		Definir cancha, plateabajasil, plateabajagol, plateaalta, tribuna, intento, opcion, asiento, preciofinal, descuento Como Entero;
		
		cancha <- 34000;
		plateabajasil <- 17000;
		plateabajagol <- 23000;
		plateaalta <- 7000;
		tribuna <- 5000;
		
		intento <- 0;
		A <- "Cancha";
		B <- "Platea Baja Silver";
		C <- "Platea Baja Golden";
		D <- "Platea Alta";
		E <- "Tribuna";
		
		Mientras intento <= 5 Hacer
			Escribir "Bienvenido a la interfaz básica de compra de entradas para el concierto de Tommy Boysen El Papi";
			Escribir "Por favor, ingrese su nombre";
			Leer nombre;
			Escribir "Por favor, ingrese su RUT";
			Leer rut;
			Escribir "¿Es usted estudiante DUOC? s/n";
			Leer s;
			Si s = "s" Entonces
				descuento <- 9990;
				Escribir "Usted tendrá un descuento de 9000 pesos por ser estudiante DUOC.";
			Sino 
				Escribir "Usted no es estudiante. Las tarifas se mantendrán.";
				descuento <- 0;
			FinSi
			
			Escribir "Por favor, ingrese su entrada";
			Escribir "Disponibles: 1) Cancha ($34.000), 2) Platea Baja Silver ($17.000), 3) Platea Baja Golden ($23.000)";
			Escribir "4) Platea Alta ($7.000), 5) Tribuna ($5.000).";
			Leer opcion;
			Segun opcion Hacer
				1:
					asiento <- cancha;
					Escribir "Usted ha elegido: Cancha. El precio base de su entrada es ", asiento, " . Presione cualquier tecla para continuar";
					Leer confirmacion;
					confirmacion <- A;
				2:
					asiento <- plateabajasil;
					Escribir "Usted ha elegido: Platea Baja Silver. El precio base de su entrada es ", asiento, " . Presione cualquier tecla para continuar";
					Leer confirmacion;
					confirmacion <- B;
				3:
					asiento <- plateabajagol;
					Escribir "Usted ha elegido: Platea Baja Golden. El precio base de su entrada es ", asiento, ". Presione cualquier tecla para continuar";
					Leer confirmacion;
					confirmacion <- C;
					
				4: 
					asiento <- plateaalta;
					Escribir "Usted ha elegido: Platea Alta. El precio base de su entrada es ", asiento, ". Presione cualquier tecla para continuar";
					Leer confirmacion;
					confirmacion <- D;
				5:
					asiento <- tribuna;
					Escribir "Usted ha elegido: Tribuna. El precio base de su entrada es ", asiento, ". Presione cualquier tecla para continuar";
					Leer confirmacion;
					confirmacion <- E;
				De Otro Modo:
					Escribir "Opcion no válida. Intente nuevamente.";
			FinSegun
			
			Escribir "Antes de terminar, los datos de su compra son: ";
			Escribir "Nombre: ", nombre, " Rut: ", rut;
			Escribir "Usted eligió: ", " Asiento - ", confirmacion;
			preciofinal <- asiento - descuento;
			Si preciofinal <= 0 Entonces
				Escribir "Felicidades. Su entrada es gratuita";
				preciofinal <- 0;
			FinSi
			Escribir "Precio final: ", preciofinal;
			intento <- intento + 1;
			Escribir "Ha terminado su compra. Lleva ", intento, " intentos de 5";
		FinMientras
FinProceso

