# Ej Sushi

# Tabla rígida de precios
pikachu_roll = 4500
otaku_roll = 5000
pulpo_roll = 5200
anguila_roll = 4800

# Subtotales y total
sub_pika = 0
sub_otaku = 0
sub_pulpo = 0
sub_anguila = 0

# Contadores cantidad
cont_pika = 0
cont_otaku = 0
cont_pulpo = 0
cont_anguila = 0
ciclo = 0

# Descuento
dcto = 0

print("Bienvenido a la App de Kawaii Sushi")

while True:
    try:
        nombre = str(input("Por favor, ingrese su nombre: ")).strip().title()
        rut = str(input("Por favor, ingrese su RUT sin dígito verificador o puntos (Ej: 12345678): "))
        dig_verificador = str(input("Por favor, ingrese el dígito verificador de su RUT: ")).lower()
        direccion = str(input("Por favor, ingrese la dirección de envío: ")).strip().title()

        if len(nombre) < 3:
            print("Error: El campo nombre no puede tener menos de 3 caracteres")
            continue
        
        elif len(direccion) < 3:
            print("Error: El campo dirección no puede tener menos de 3 caracteres")
            continue

        if dig_verificador.isdigit() or dig_verificador == 'k':
            print(f"Datos guardados!")
            break
        
        else:
            print("Error: Rut no válido.")
            continue
     

    except ValueError:
        print("Error: Dato ingresado no es válido. Intente nuevamente.")


while True:
    try:
        print(f"Bienvenido {nombre} ¿Qué deseas llevar?")
        opc= int(input(("1. Pikachu Roll $4500 - 2. Otaku Roll $5000 - 3. Pulpo Venenoso Roll $5200 - 4. Anguila Eléctrica Roll $4800 - 5. Salir y pagar ")))
        ciclo += 1
            
        if opc == 1:
            sub_pika = sub_pika + pikachu_roll
            cont_pika = cont_pika + 1
            print("Añadido!")

        elif opc == 2:
            sub_otaku = sub_otaku + otaku_roll
            cont_otaku = cont_otaku + 1
            print("Añadido!")
        
        elif opc == 3:
            sub_pulpo = sub_pulpo + pulpo_roll
            cont_pulpo = cont_pulpo + 1
            print("Añadido!")

        elif opc == 4:
            sub_anguila = sub_anguila + anguila_roll
            cont_anguila = cont_anguila + 1
            print("Añadido!")
        
        elif opc == 5:
            print("¡Terminando!")
            break

        else: 
            print("Por favor, seleccione una opción válida.")
            continue

        if ciclo >= 1:
            print("\n" * 100)
            total = sub_pika + sub_otaku + sub_pulpo + sub_anguila
            cont_total = cont_pika + cont_otaku + cont_pulpo + cont_anguila
            print(f"-------------Usted lleva: {cont_total} ROLLS - ${total}---------------")
            print(f"Stats: Pikachu Roll: {cont_pika} $ {sub_pika} - Otaku Roll {cont_otaku} $ {sub_otaku}") 
            print(f"Pulpo Venenoso Roll {cont_pulpo} $ {sub_pulpo} - Anguila Eléctrica Roll {cont_anguila} $ {sub_anguila}")

    except ValueError:
        print("Error: Dato ingresado no es válido. Intente nuevamente.")

while True:
    try:
        print(f"Perfecto. Su total, sin aplicar descuentos es $ {total}")
        codigo = str(input("Pero puede ser menos si tienes tu código promocional :3 - Ingresalo aquí para un 10% de dcto: ")).strip().lower()

        if codigo == "soyotaku":
            dcto = 0.10
            print("¡Descuento aplicado!")
            break

        else:
            print("Código no válido")
            opc2 = str(input("¿Quieres intentarlo nuevamente? (Digita X para salir )")).upper()

        if opc2 == "X":
            break
        else:
            continue

    except ValueError:
        print("Error: Dato ingresado no válido. Intente nuevamente.")
        continue



total = total - (total * dcto)

print("Ha finalizado su compra ")
print("-----------------BOLETA---------------------")
print(f"Nombre: {nombre} - Dirección {direccion}")
print(f"TOTAL DE COMPRA: ${total}")
print("-----------------USTED LLEVA:---------------")
print(f"TOTAL DE PRODUCTOS {cont_total} ROLLS")
print(f"Pikachu Roll: {cont_pika} $ {sub_pika} - Otaku Roll {cont_otaku} $ {sub_otaku}")
print(f"Pulpo Venenoso Roll {cont_pulpo} $ {sub_pulpo} - Anguila Eléctrica Roll {cont_anguila} $ {sub_anguila}")
print("¡Gracias por comprar en Kawaii Sushi! ¡Vuelva pronto!")