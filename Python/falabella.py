
while True:
    try:
        print("Bienvenido a la interfaz de pago de Falabella")

        nombre = str(input("Por favor, ingrese su nombre: "))
        rut = input("Por favor, ingrese los primeros 8 digitos de su RUT. Sin puntos (ej:12345678): ")

        int(rut)

        if len(rut) != 8:
            print(f"Longitud de rut incorrecta. Lo ingresado tiene {len(rut)} caracteres")

        else:
            print("Rut correcto.")
            break
    except ValueError:
        print("Error, intente nuevamente.")
        continue

while True:
    try:
        verificador = input("Por favor, ahora ingrese el dígito verificador de su rut. Sin guión (ej 2): ")

        if verificador == 'k':
            print(f"Rut validado. Bienvenido {nombre}")
            break
        elif verificador.isdigit():
            print(f"Rut validado. Bienvenido {nombre}")
            break
        else:
            print("El verificador es incorrecto. Intente nuevamente.")
            continue
    except AttributeError:
        print("Error. El digito ingresado no es un número o una K. Intente nuevamente.")
        continue

str(rut)
str(verificador)

rutcompleto = rut + "-" + verificador
print(f"{rutcompleto}")

while True:

    nombrecompra = str(input("Por favor, ingrese el nombre del artículo comprado: "))
    compra = float(input("Por favor, ingrese el precio del artículo comprado: "))

    if compra < 10000:
        print("No aplica descuento.")
        descuento = compra
        break
    elif compra <= 50000:
        print("¡Descuento del 10%!")
        descuento = compra - compra * 0.10
        break
    elif compra >= 50000:
        print("¡Descuento del 20%!")
        descuento = compra - compra * 0.20
        break

print("Usted ha completado su compra.")
print("-----Boleta-----")
print(f"ESTIMAD@ {nombre}, {rutcompleto}")
print(f"Usted compró: {nombrecompra}, cuyo valor original es de ${compra}")
print(f"El precio final es de ${descuento}")
print("Gracias por comprar e Falabella. ¡Hasta pronto!")