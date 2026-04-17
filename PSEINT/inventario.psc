Proceso inventario
	
	// Variables
	Definir nombre_producto como cadena;
	Definir cantidad, cantidadnuevaproducto, opcion, i, opc, precio, preciofinal, cantidadventas, cantidadvender Como Entero;
	Definir contadooperador Como Entero;
	opc = 0;
	cantidadnuevaproducto = 0;
	i = 0;
	contadooperador = 0;
	
	Mientras opc <> 6 Hacer;
		Escribir " (1) Registre un producto.";
		Escribir " (2) Aumentar stock.";
		Escribir " (3) Procesar ventas.";
		Escribir " (4) Mostrar estado actual inventario.";
		Escribir " (5) Mostrar informe de ventas.";
		Escribir " (6) Salir.";
		Leer opc;
		
		Segun opc Hacer
			1:
				Escribir "Usted eligió la opción 1: Registrar un producto";
				Escribir "Ingrese el nombre del producto";
				Leer nombre_producto;
				Repetir
					Escribir "Ingrese el precio unitario del producto";
					Leer precio;
				Hasta Que precio > 0
				Repetir
					Escribir "Ingrese la cantidad";
					Leer cantidad;
				Hasta Que cantidad > 0
				Escribir "Producto registrado";
				
			2:
				Escribir "Usted eligió la opción 2: Aumentar stock";
				Escribir "Ingrese el nombre del producto";
				Leer nombre_producto;
				Escribir "Ingrese cantidad a añadir";
				Leer cantidadnuevaproducto;
				Si cantidad <= 0 Entonces
					Escribir "La cantidad debe ser un número positivo";
				FinSi
				cantidad = cantidad + cantidadnuevaproducto;
				Escribir "Ahora hay ", cantidad, " de este producto: ", nombre_producto;
				
				
			3:
				Escribir "Usted eligió la opción 3: Proceso de ventas.";
				Escribir "Ingrese cuántas ventas desea inicializar.";
				Leer cantidadventas;
				Para i = 0 Hasta cantidadventas Con Paso 1 Hacer
					contadooperador = contadooperador +1;
				Escribir "Ingrese cuántos productos desea vender.";
				Leer cantidadvender;
				FinPara
				
				si cantidad <= 0 O cantidad < cantidadvender Entonces
					Escribir "No hay stock";
				SiNo
					cantidad = cantidad - cantidadvender;
				FinSi
			4:
				Escribir "Usted eligió la opción 4: Mostrar estado actual inventario.";
				Si nombre_producto = "" Entonces
					Escribir "No hay un producto registrado. Registre un producto para comenzar";
				SiNo
					Escribir "Nombre: ", nombre_producto;
					Escribir "Cantidad producto: ", cantidad;
					Escribir "Precio inventario: ", precio * cantidad;
				FinSi
				
			5:
				
			
			De Otro Modo:
				Escribir "Valor no válido. Intente nuevamente";
		FinSegun
	FinMientras
	
	
FinProceso
