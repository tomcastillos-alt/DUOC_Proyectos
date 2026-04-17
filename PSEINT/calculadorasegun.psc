Proceso calculadorasegun
	Definir num1, num2, resultado Como Real;
	Definir operacion Como Entero;
	
	Escribir "Bienvenido a la súper calculadora que usa SEGÚN";
	Escribir "Por favor, ingrese el primer número";
	Leer num1;
	Escribir "Por favor, ingrese el segúndo número";
	Leer num2;
	
	Escribir "¿Qué ecuación desea hacer?";
	Escribir "1) Suma - 2) Resta - 3) Multiplicación - 4) División - 5) Potencia 6) División con resto";
	Leer operacion;
	Segun operacion Hacer
		1:
			Escribir "Su resultado es ", num1 + num2;
		2:
			Escribir "Su resultado es ", num1 - num2;
		3:
			Escribir "Su resultado es ", num1 * num2;
		4:
			Escribir "Su resultado es ", num1 / num2;
		5:
			Escribir "Su resultado es ", num1 ^ num2;
		6:
			Definir dividendo, divisor, resto Como Real;
			dividendo <- num1;
			divisor <- num2;
			resto <- dividendo MOD divisor;
			Escribir "Su resultado es ", num1 / num2, "con un sobrante de ", resto;
		De Otro Modo:
			Escribir "Dato ingresado no es válido. Intente nuevamente.";
	FinSegun
FinProceso
