Proceso validador
	Definir respuesta Como Caracter;
	Definir c_deseada, c_disponible Como Entero;
	
	Escribir "Bienvenido al validador";
	
	Escribir "Por favor, ingrese la cantidad de unidades que quiere almacenar.";
	Leer c_disponible;
	Escribir "Usted determinó que habrán ", c_disponible, " unidades disponibles";
	Escribir "Por favor, ingrese la cantidad deseada.";
	Leer c_deseada;
	Escribir "Usted solicitó ", c_deseada, " unidades";
	Escribir "Validando información";
	
	Si c_disponible = c_deseada Entonces
		Escribir "Despacho exacto.";
	FinSi
	
	Si c_disponible > c_deseada Entonces
		Escribir "Despacho parcial con stock restante";
	FinSi
	
	Si c_disponible < c_deseada Entonces
		Escribir "Stock insuficiente";
	FinSi
	
	Escribir "Fin del proceso";
FinProceso
