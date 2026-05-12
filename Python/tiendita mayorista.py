
# Tabla precios / por kilo

marraqueta = 2000
hallulla = 1900
amasado = 2100
molde = 2100
integral = 2200
baguette = 2600
p_completo = 2100

# Por unidad
bebida = 1500
agua = 1000
jugo = 1250

# Super Menu
print("\n === Bienvenido a la Panaderia Mayorista del Gato Guaton ===")
print("\nTenemos los siguientes productos disponibles: ")
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
ventas = int(input("Ingrese el número de ventas que desea realizar: "))

# Descuentos mayoristas
if ventas <= 0:
    print("Error: El número de ventas debe ser un número mayor a 0.")
    exit()
elif ventas > 4:
    print("Descuento del 10% aplicado por compra mayor a 4 productos.")
    descuento = 0.10
elif ventas > 7:
    print("Descuento del 20% aplicado por compra mayor a 7 productos.")
    descuento = 0.20
elif ventas > 10:
    print("Descuento del 30% aplicado por compra mayor a 10 productos.") 
    descuento = 0.30
else:
    descuento = 0.0    

# Terminal de compra
for i in range(ventas):
    try:
        opcion = int(input("\nIngrese el número del producto que desea comprar (1-10): "))
        if opcion < 1 or opcion > 10:
            print("Opción inválida. Por favor, ingrese un número entre 1 y 10.")
            continue
        break
    except ValueError:
        print("Error: Ingrese un número válido.")
        continue

if opcion >= 1 and opcion <= 7:
    while True:
        try:
            cantidad = int(input("Ingrese la cantidad en kilos que desea comprar: "))
            if cantidad <= 0:
                print("Error: La cantidad debe ser un número mayor a 0.")
                continue
            break
        except ValueError:
            print("Error: Ingrese un número válido.")
            continue

elif opcion >= 8 and opcion <= 10:
    while True:
        try:
            cantidad = int(input("Ingrese la cantidad de unidades que desea comprar: "))
            if cantidad <= 0:
                print("Error: La cantidad debe ser un número mayor a 0.")
                continue
            break
        except ValueError:
            print("Error: Ingrese un número válido.")
            continue

# Calculadora de precios

if opcion == 1:
    precio = marraqueta * cantidad
elif opcion == 2:
    precio = hallulla * cantidad
elif opcion == 3:
    precio = amasado * cantidad
elif opcion == 4:
    precio = molde * cantidad
elif opcion == 5:
    precio = integral * cantidad
elif opcion == 6:
    precio = baguette * cantidad
elif opcion == 7:
    precio = p_completo * cantidad
elif opcion == 8:
    precio = bebida * cantidad
elif opcion == 9:
    precio = agua * cantidad
elif opcion == 10:
    precio = jugo * cantidad

precio_con_descuento = precio * (1 - descuento)
print(f"\nEl precio total con descuento es: ${precio_con_descuento:.2f}")

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
      rut = input("Ingresa tu rut sin el codigo verificador para acumular puntos: ")

      if rut.isdigit() and len(rut) ==8:
        print("Error: Rut válido")
        break
      else:
        print("Error: Rut inválido")
        continue

while True:
      dv = input("Ahora ingresa tu codigo verificador: ").upper()
      if len(dv) == 1 and (dv.isdigit() or dv == 'K'):
        break
      else:
        print("Error: DV inválido")
        continue

boleta = "Boleta de compra\nNombre: {nombre}\nCorreo: {correo}\nProducto: {opcion}\nCantidad: {cantidad}\nPrecio total con descuento: ${precio_con_descuento:.2f}"
print("\n" + boleta)
print("Gracias por su compra en la Panaderia Mayorista del Gato Guaton. ¡Vuelva pronto!")
