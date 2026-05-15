print("Bienvenido al Sistema de Notas DUOC UC")

total = 0

while True:
    try: 
        print("---REGISTRO---")
        nombre = str(input("Por favor, ingrese su nombre ")).strip()

        password = str(input("Ahora ingrese su clave: "))
        print(f"Perfecto {nombre}. Ahora está registrado.")
        break

    except ValueError:
        print("Error en la autenticación, intente nuevamente.")
        continue

while True: 
    try: 
        print("---LOGIN---")
        valnombre = str(input("Por favor, ingrese su nombre ")).strip()

        valpassword = str(input("Ahora ingrese su clave: "))

        if valnombre != nombre:
            print("Error: Nombre de usuario incorrecto.")
            continue
        elif valpassword != password:
            print("Error: Contraseña incorrecta.")
            continue
        else:
            break
    except ValueError:
        print("Error en la autenticación, intente nuevamente.")
        continue

while True:
    try:
        print("Opciones: 1) Matemática 1 - 2) Fundamentos de Programación - 3) DevOps - 4) Inteligencia Artificial - 5) Ciencia de Datos")
        opc = str(input("Por favor, ingrese el número una de estas materias a evaluar para continuar: ")).strip()

        if opc == "1" or opc == "2" or opc == "3" or opc == "4" or opc == "5":
            break
        else:
            print("Error, seleccione una materia válida.")
            continue
    except ValueError:
        print("Error en la selección, intente nuevamente.")
        continue

if opc == "1":
    opc = "Matemática 1"
elif opc == "2":
    opc = "Fundamentos de Programación"
elif opc == "3":
    opc = "DevOps"
elif opc == "4":
    opc = "Inteligencia Artificial"
elif opc == "5":
    opc = "Ciencia de Datos"
else:
    opc = "Asignatura sin nombre"
 
cantidad = int(input(f"Por favor ingrese el número de notas que desea registrar: "))

librocalificaciones = []

while True:
    try:
        alumno_nombre = str(input("Ingrese el nombre del alumno a evaluar: "))

        if alumno_nombre is alumno_nombre.isdigit():
            print("Error: Nombre no válido")
            continue
        else:
            break
    except ValueError:
        print("Error: Datos no válidos, intente nuevamente.")
        continue

for i in range(cantidad):
    try:
        nota = float(input("Ingrese las notas: "))

        if nota < 1.0 or nota > 7:
            print("Error: La nota debe estar entre un 1 o 7.")
            continue
        else:
            librocalificaciones.append(nota)
            total += 1
    except ValueError:
        print("Error: Digito no válido")
        continue


promedio = sum(librocalificaciones) / total

while True:
    try: 
        opcion2 = input("¿Desea visualizar las notas? s/n ").strip().lower()

        if opcion2 == "s":
                    print(librocalificaciones)
                    print(f"El promedio del alumno {alumno_nombre} en la asignatura {opc} es {promedio:.0f}")
        elif opcion2 == "n":
            break
        else:
            print("Error: Ingrese una opción válida")
            continue
        if promedio < 4.0:
            print("Alumno reprobado.")
        elif promedio >= 4.0:
            print("Alumno aprobado.")
        break
    except ValueError:
        print("Error: Opción no esperada.")
        continue
