juegos = {
    'G001': ['Eclipse Runner', 'PC', 'accion', 'T', True, 'NovaStudio'],
    'G002': ['Puzzle Atlas', 'Switch', 'puzzle', 'E', False, 'BrightWorks'],
    'G003': ['Sky Legends', 'PS5', 'aventura', 'T', True, 'OrionGames'],
    'G004': ['Racing Pulse', 'PC', 'carreras', 'E', True, 'VelocityLab'],
    'G005': ['Mystic Farm', 'Switch', 'simulacion', 'E', False, 'GreenSeed'],
    'G006': ['Shadow Tactics', 'Xbox', 'estrategia', 'M', False, 'IronGate'],
}

inventario = {
    'G001': [9990, 7], #pc
    'G002': [19990, 0], #switch
    'G003': [42990, 3], #ps5
    'G004': [14990, 5], #pc
    'G005': [17990, 9], #switch
    'G006': [39990, 2], #xbox
}

def menu():
    print("========== MENÚ PRINCIPAL ==========")
    print("1. Stock por plataforma")
    print("2. Búsqueda de juegos por rango de precio")
    print("3. Actualizar precio de juego")
    print("4. Agregar juego")
    print("5. Eliminar juego")
    print("6. Salir")
    print("=====================================")


def stock_plataforma(plataforma):
    lista_stock = []
    total = 0
    for busca in juegos:
        if plataforma.upper() == juegos[busca][1].upper():

            lista_stock.append(busca)
    for busca in lista_stock:
            if busca in inventario: 
                total += inventario[busca][1]
     
    print(f"El total de stock disponibles es {total}")

def busqueda_precio(p_min, p_max):
    lista_productos = []

    for busca, encuentra in inventario.items():
        precio = encuentra[0]
        unidad = encuentra[1]
        if p_min <= precio <= p_max:
            if busca in juegos[busca][0]:
                lista_productos.append(busca)
    
    if len(lista_productos) == 0:
        print("No hay juegos en ese rango de precios")
        return False

    lista_productos.sort()

    print(f"Los juegos encontrados son: {lista_productos}")
    return True
    

def actualizar_precio(codigo, nuevo_precio):
    codigo = codigo.capitalize()

    while True:

        for busca in inventario:
            if codigo in inventario.items():
                inventario[busca][1] = nuevo_precio
                print("Precio actualizado")
            else:
                print("El código no existe")
            
        respuesta = str(input("¿Desea actualizar otro precio (s/n)?")).lower().strip()

        if respuesta == "s":
                continue
        else:
            break
               

def agregar_juego(codigo, titulo, plataforma, genero, clasificacion, multiplayer, editor, precio, stock):

    for busca in juegos:
        if codigo in juegos.items():
            print("El código ya existe")
            return False

    juegos[codigo] = [titulo, plataforma, genero, clasificacion, multiplayer, editor]
    inventario[codigo] = [precio, stock]
    print("Juego agregado")
    return True

def eliminar_juego(codigo):
    codigo = codigo.capitalize()
    if codigo in juegos:
        juegos.pop(codigo)
        inventario.pop(codigo)
        print("Juego eliminado")
        return True
    else:
        print("El código no existe.")
        return False

while True:
    menu()
    try:
        opc = int(input("Ingrese opción: "))
    
    except ValueError:
        print("Debe seleccionar una opción válida (1-2-3-4-5-6).")
        continue

    if opc == 1:
        try:
            plataforma = str(input("Ingrese plataforma a consultar: ")).strip().lower()

            if plataforma == "":
                print("El campo plataforma no puede quedar vacío. Intente nuevamente. ")
        
        except ValueError:
            print("Error: Ingrese un nombre en el campo plataforma.")

        stock_plataforma(plataforma)

    elif opc == 2:
        try:
            p_min = int(input("Ingrese precio mínimo: "))

            p_max = int(input("Ingrese precio máximo: "))

            if p_min >= p_max:
                print("Error: el precio mínimo no puede ser mayor que el máximo.")
            
            if p_min < 0 or p_max < 0:
                print("Debe ingresar valores enteros")
                continue

        except ValueError:
            print("Ingrese un número en el campo solicitado.")
            continue

        busqueda_precio(p_min, p_max)

    elif opc == 3:
        try:
            codigo = str(input("Ingrese código del juego: ")).strip()

            if codigo == "":
                print("Error: El campo código no puede quedar vacío.")
                continue

            nuevo_precio = int(input("Ingrese nuevo precio: "))

            if nuevo_precio <= 0:
                print("Error: El nuevo precio debe ser un número entero mayor a 0.")
                continue
            
        
        except ValueError:
            print("Ingrese lo solicitado en el campo disponible. Intente nuevamente.")
            continue
        actualizar_precio(codigo, nuevo_precio)

    elif opc == 4:
        try:
            error = 0
            multiplayer = False
            
            codigo = str(input("Ingrese código del juego: ")).strip().capitalize()

            titulo = str(input("Ingrese título: ")).strip()

            plataforma = str(input("Ingrese plataforma: ")).strip()

            genero = str(input("Ingrese genero: ")).strip()

            clasificacion = str(input("Ingrese clasificación: ")).strip().upper()

            if clasificacion or titulo or plataforma or genero or clasificacion == "":
                error = 1
                
            elif clasificacion is not "E" or clasificacion is not "T" or clasificacion is not "M":
                error = 1
                
            multiplayer_a = str(input("¿Es multiplayer? (s/n) ")).strip().lower()
            
            if multiplayer_a is not "s" or multiplayer_a is not "n":
                error = 0

            elif multiplayer_a == "s":
                multiplayer = True
            
            elif multiplayer_a == "n":
                multiplayer == False

            editor = str(input("Ingrese editor: ")).strip()

            if editor == "":
                error = 1

            precio = int(input("Ingrese precio: "))

            if precio <= 0:
                error = 1

            stock = int(input("Ingrese stock: "))

            if stock < 0:
                error = 1

        except ValueError:
            print("Error: Ingrese el dato requerido en el campo solicitado.")
            continue

        if error == 1:
            print("Error: Datos solicitados ingresados incorrectamente. Intente nuevamente")

        else:
            agregar_juego(codigo, titulo, plataforma, genero, clasificacion, multiplayer, editor, precio, stock)

    elif opc == 5:
        try:
            codigo = str(input("Ingrese código del juego: ")).strip()

            if codigo == "":
                print("Error: El campo código no puede quedar vacío")
        
        except ValueError:
            print("Ingrese un código válido. Intente nuevamente.")
            continue

        eliminar_juego(codigo)

    elif opc == 6:
        print("Programa finalizado.")
        break

    else:
        print("Debe seleccionar una opción válida.")
        continue
