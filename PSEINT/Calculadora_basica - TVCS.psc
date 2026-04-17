Proceso Calculadora_basica
	Definir operacion Como Caracter;
	Definir num1, num2, resultado Como Entero;
	
	// Valores como suma
	Definir suma Como Entero;
	suma <- 0;
	Definir resta Como Entero;
	resta <- 0;
	
	Escribir "Ingrese su operacion: suma o resta";
	leer operacion;
	Si operacion = "suma" Entonces
		Escribir "Digite su primer número";
		Leer num1; 
		Escribir "Digite su segundo número";
		Leer num2;
		resultado = num1 + num2;
		Escribir "Tu resultado es ", resultado;
	SiNo
		operacion = "resta";
		Escribir "Digite su primer número";
		Leer num1; 
		Escribir "Digite su segundo número";
		Leer num2;
		resultado = num1 - num2;
		Escribir "Tu resultado es ", resultado;
	FinSi
FinProceso
