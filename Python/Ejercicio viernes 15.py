while True:
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

    libromatematica = {
        "nombre" : "Matemática 1",
        "notas" : []
    }

    librofundamentos = {
        "nombre" : "Fundamentos de Programación",
        "notas" : []
    }
        

    
    librodevops = {
        "nombre" : "DevOps",
        "notas" : []
    }

    
    libroia = {
        "nombre" : "Inteligencia Artificial",
        "notas" : []
    }

    
    librocienciadatos = {
        "nombre" : "Ciencia de datos",
        "notas" : []
    }

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

    while True:
        try:
            print("Opciones: 1) Matemática 1 - 2) Fundamentos de Programación - 3) DevOps - 4) Inteligencia Artificial - 5) Ciencia de Datos")
            opc = str(input("Por favor, ingrese el número una de estas materias a evaluar para continuar: ")).strip()

            if opc == "1":
                libro = libromatematica
            elif opc == "2":
                libro = librofundamentos
            elif opc == "3":
                libro = librodevops
            elif opc == "4":
                libro = libroia
            else:
                libro = librocienciadatos
            break
        except ValueError:
            print("Error en la selección, intente nuevamente.")
            continue

    while True:
        try:
            cantidad = int(input(f"\nIngrese cuántas notas desea registrar para {libro['nombre']}: "))
            if cantidad > 0:
                break
            print("Debe ingresar al menos 1 nota.")
        except ValueError:
            print("Error: Ingrese un número válido.")

    for i in range(cantidad):
        while True:
            try:
                nota = float(input(f"Ingrese nota {i+1}: "))
                if 1.0 <= nota <= 7.0:
                    libro["notas"].append(nota)
                    print(f"Nota {nota} registrada correctamente.")
                    break 
                else:
                    print("La nota debe estar entre 1.0 y 7.0")
            except ValueError:
                print("Error: Ingrese un número válido.")
                
    print("¿Desea realizar otra opción?")
    cierre = str(input(" s/ n ")).strip().lower()

    if cierre == "s":
        continue
    elif cierre == "n":
        break
    else:
        print("Error: Intente nuevamente")
        continue


    
