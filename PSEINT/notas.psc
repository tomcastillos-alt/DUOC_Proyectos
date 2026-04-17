Proceso notas
	Definir nota, alumnos, totalalumnos, cont, aprobados Como Entero;
	aprobados <- 0;
	
	Escribir "Bienvenido al lector de calificaciones";
	Escribir "Por favor, ingrese el número de alumnos";
	Leer alumnos;
	
	
		
		Para cont <- 1 Hasta alumnos Hacer
			totalalumnos <- alumnos;
			Escribir "Por favor ingrese la nota. Debe ser un número entre el 0 y el 100";
			Leer nota;
			Si nota >= 60 Entonces
				Escribir "Alumno aprobado";
				aprobados <- aprobados + 1;
			FinSi
			
			Si nota < 60 Y nota >= 40 Entonces
				Escribir "Alumno reprobado - Puede recuperar.";
			FinSi
			
			Si nota < 40 Entonces
				Escribir "Alumno reprobado.";
			FinSi
			
		FinPara
		

	
	Escribir "Se ingresaron ", totalalumnos;
	Escribir "Aprobaron ", aprobados;

FinProceso
