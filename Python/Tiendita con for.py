print(" Bienvenido a la Panadería Mayorista del Gato Guatón")

# Inicializamos pa evitar que el programa explote
total_dia = 0

while True:    
    try:
        nombre = input("Ingrese su nombre para la boleta: ")
        if not nombre.strip():
            print("Error: El nombre no puede estar vacío.")
            continue
        break
    except ValueError:
        print("Error: Ingrese un nombre válido.")
        continue

while True:
    try:
        direccion = input("Ingrese su dirección de envío: ")
        if not direccion.strip():
            print("Error: La dirección no puede estar vacía.")
            continue
        break
    except ValueError:
        print("Error: Ingrese una dirección válida.")
        continue

while True:
    try:
        correo = input("Ingrese su correo electrónico para recibir la boleta: ")
        if "@" in correo and "." in correo:
            print("Correo válido. Se enviará la boleta a su correo.")
            break
        else:
            print("Correo inválido. Por favor, ingrese un correo electrónico válido.")
    except ValueError:
        print("Error: Ingrese un correo electrónico válido.")
        continue

while True:
    try:
      rut = input("Ingresa tu rut sin el codigo verificador para acumular puntos: ")

      if rut.isdigit() and len(rut) ==8:
        break
      else:
        print("Error: Rut inválido")
        continue
    except ValueError:
        print("Error: Ingrese un número válido para el Rut.")
        continue

while True:
    try:
      dv = input("Ahora ingresa tu codigo verificador: ").upper()
      if len(dv) == 1 and (dv.isdigit() or dv == 'K'):
        break
      else:
        print("Error: DV inválido")
        continue
    except ValueError:
        print("Error: Ingrese un número válido para el Digito Verificador.")
        continue


print(f"Cliente registrado. Bienvenido, {nombre}!")

#PRecios sin iva

marraqueta = 2000
hallulla = 1900
amasado = 2100
molde = 2100
integral = 2200
baguette = 2600
p_completo = 2100
bebida = 1500
agua = 1000
jugo = 1250

while True:
    try:
        num_ventas = int(input("¿Cuántas compras desea registrar hoy? "))
        if num_ventas > 0:
            break
        print("Debe ingresar un número mayor a 0.")
    except:
        print("Ingrese un número válido.")
        continue

#Loop que repite según input

for i in range(1, num_ventas + 1):
    print(f"          VENTA N° {i} de {num_ventas}")
    print("Tenemos los siguientes productos disponibles: ")
    print(f"1. Marraqueta: ${marraqueta} por kilo")
    print(f"2. Hallulla: ${hallulla} por kilo")
    print(f"3. Amasado: ${amasado} por kilo")
    print(f"4. Molde Ideal: ${molde} por kilo")
    print(f"5. Hallulla Integral: ${integral} por kilo")
    print(f"6. Mini Baguette: ${baguette} por kilo")
    print(f"7. Pan de Completo: ${p_completo} por kilo")
    print(f"8. Bebida 1.5 lt: ${bebida} por unidad")
    print(f"9. Agua 1.5 lt: ${agua} por unidad")
    print(f"10. Jugo 1.5 lt: ${jugo} por unidad")
        
    while True:
        try:
            opcion = int(input("\nIngrese número del producto (1-10): "))
            if 1 <= opcion <= 10:
                break
            print("Opción inválida.")
        except:
            print("Ingrese un número entre el 1 y el 10")
        
    while True:
        try:
            cantidad = int(input("Cantidad: "))
            if cantidad > 0:
                break
            print("La cantidad debe ser mayor a 0.")
        except:
            print("Ingrese un número válido.")
        
    # PRecios unitarios
    if opcion == 1: precio_unit = marraqueta
    elif opcion == 2: precio_unit = hallulla
    elif opcion == 3: precio_unit = amasado
    elif opcion == 4: precio_unit = molde
    elif opcion == 5: precio_unit = integral
    elif opcion == 6: precio_unit = baguette
    elif opcion == 7: precio_unit = p_completo
    elif opcion == 8: precio_unit = bebida
    elif opcion == 9: precio_unit = agua
    elif opcion == 10: precio_unit = jugo
        
    subtotal = precio_unit * cantidad
        
    # Descuentitos
    if cantidad >= 20:
        descuento = 0.30
    elif cantidad >= 10:
        descuento = 0.20
    elif cantidad >= 5:
        descuento = 0.10
    else:
        descuento = 0.0
    precio_con_desc = subtotal * (1 - descuento)
    iva = precio_con_desc * 0.19
    total_venta = precio_con_desc + iva
    
    # Acumulador total del las compras del día
    total_dia += total_venta
        
        # Boleta
    print("--- BOLETA ---")
    print(f"Nombre: {nombre}")
    print(f"Dirección: {direccion}")
    print(f"RUT: {rut}-{dv}")
    print(f"Producto: {opcion}")
    print(f"Cantidad: {cantidad}")
    print(f"Subtotal: ${subtotal:.0f}")
    print(f"IVA de esta compra (19%): ${iva:.0f}")
    print(f"Total esta compra: ${total_venta:.0f}")
    print(f"Total acumulado: ${total_dia:.0f}")
        

print("¡Gracias por su compra!")