# Un jugador de videojuegos desea comprar armas para su juego. Mencione 3 artículos: espada 5 mil, arco 7 mil, baston magico 9 mil. El usuario puede comprar los articulos que el desee. Al oprimir la opcion salir, el usuario debe ver su boleta. (Nombre, Direccion, RUT, número de artículos, subtotal y total. Dcto)

espada = 5000
arco = 7000
baston = 9000
subtotal = 0
compras = 0
c_espadas= 0
c_arcos = 0
c_baston = 0
total = 0
sub_arcos = 0
sub_espadas = 0
sub_baston = 0
dcto = 0

while True:
    try:
        print("Bienvenido a la super tienda del MMORPG GG")
        nombre = str(input("Por favor, ingrese su nombre: "))
        direccion = str(input("Por favor, ingrese su direccion: "))

        if len(nombre) <= 0:
            print("Error: El campo de nombre no puede quedar vacío")
            continue
        elif len(direccion) <= 0:
            print("Error: El campo de dirección no puede quedar vacío")
            continue
        else:
            break
        
    except ValueError:
        print("Error: Ingrese un valor válido.")
        continue


while True:
    try:
        print(f"Bienvenido {nombre} - La lista de objetos disponibles es: ")
        print("1. ESPADA $5000 - 2. ARCO $7000 - 3. BASTÓN MÁGICO $9000 - 4. salir")
        sub_espadas = c_espadas * espada
        sub_arcos = c_arcos * arco
        sub_baston = c_baston * baston
        total = sub_arcos + sub_baston + sub_espadas
        print(f"USTED LLEVA: ESPADAS: {c_espadas} ${sub_espadas}- ARCOS: {c_arcos} ${sub_arcos} - BASTONES MÁGICOS: {c_baston} ${sub_baston}")
        print(f"TOTAL: {total}")
        opc = int(input("Ingrese una opción: "))

        if opc == 1:
            print("Perfecto, usted seleccionó ESPADA $5000")
            compras = compras + 1
            c_espadas = c_espadas + 1
            continue
        
        elif opc == 2:
            print("Perfecto, usted seleccionó ARCO $7000")
            compras = compras + 1
            c_arcos = c_arcos + 1
            continue

        elif opc == 3:
            print("Perfecto, usted seleccionó BASTÓN MÁGICO $9000")
            compras = compras + 1
            c_baston = c_baston + 1
            continue

        
        elif opc == 4:
            print("Perfecto, usted eligió salir.")
            break
        

        else:
            print("Error. Ingrese una opción válida.")
            continue

    except ValueError:
        print("Error: Ingrese un valor válido.")
        continue


if total > 100000:
    dcto += 0.10
    print("DESCUENTO ACTIVADO! LLEVAS MÁS DE $100.000. 10% DCTO")
if c_espadas > 5:
    dcto += 0.05
    print(f"DESCUENTO ACTIVADO! LLEVAS {c_espadas} ESPADAS! 5% DCTO")
if c_arcos > 5:
    dcto += 0.05
    print(f"DESCUENTO ACTIVADO! LLEVAS {c_arcos} ARCOS! 5% DCTO")
if c_baston > 5:
    dcto += 0.05 
    print(f"DESCUENTO ACTIVADO! LLEVAS {c_baston} BASTONES MÁGICOS! 5% DCTO")

total = total - (total * dcto)

print(f"BOLETA: {nombre} {direccion}")
print(f"TOTAL DE LA COMPRA: ${total}, con un total de {compras} artículos")
print(f"DESGLOSE")
print(f"USTED COMPRÓ: {c_espadas} ESPADAS - SUBTOTAL: $ {sub_espadas}")
print(f"USTED COMPRÓ: {c_arcos} ARCOS - SUBTOTAL: $ {sub_arcos}")
print(f"USTED COMPRÓ: {c_baston} BASTONES MÁGICOS - SUBTOTAL: $ {sub_baston}")
print(f"DESCUENTOS: {dcto}%")
print("¡Gracias por comprar con nosotros! ¡Vuelva pronto!")

