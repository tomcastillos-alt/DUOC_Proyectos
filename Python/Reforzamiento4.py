coleccion_productos = []

#funciones menu
def menu():
    print("========== MENÚ PRINCIPAL ==========")
    print("1. Agregar producto")
    print("2. Buscar producto")
    print("3. Eliminar producto")
    print("4. Actualizar disponibilidad")
    print("5. Mostrar productos")
    print("6. Salir")
    print("=====================================")

def opcion():
    while True:
        try:
            opc = int(input("Seleccione una opción (1-2-3-4-5-6): "))
            if 1 <= opc <= 6:
                return opc
            else:
                print("Error: Ingrese un número entre el 1 y el 6.")
        except ValueError:
            print("Error: Ingrese un número en el campo solicitado.")

#validadores
def validar_nombre(nombre: str) -> bool:
    return len(nombre.strip()) > 0

def validar_stock(stock) -> bool:
    try:
        stock_int = int(stock)
        return stock_int >= 0
    except ValueError:
        return False

def validar_precio(precio) -> bool:
    try:
        precio_float = float(precio)
        return precio_float > 0
    except ValueError:
        return False

#opciones
def agregar_producto(lista):
    print("Usted eligió: 1. Agregar producto")
    nombre = input("Ingrese el nombre del producto: ").strip()
    if not validar_nombre(nombre):
        print("Error: El nombre no puede estar vacío.")
        return
    
    for producto in lista:
        if producto["nombre"].lower() == nombre.lower():
            print(f"Error: El producto '{nombre}' ya existe.")
            return

    stock_input = input("Ingrese el stock (número entero mayor o igual 0): ")
    if not validar_stock(stock_input):
        print("Error: El stock debe ser un número entero mayor o igual a 0.")
        return
    stock = int(stock_input)

    precio_input = input("Ingrese el precio (mayor a 0): ")
    if not validar_precio(precio_input):
        print("Error: El precio debe ser un número decimal mayor a 0.")
        return
    precio = float(precio_input)
    nuevo_producto = {
        "nombre": nombre,
        "stock": stock,
        "precio": precio,
        "disponible": False
    }
    lista.append(nuevo_producto)
    print(f"Producto '{nombre}' agregado correctamente.")

def buscar_producto(lista, nombre: str) -> int:
    for i in range(len(lista)):
        if lista[i]["nombre"].lower() == nombre.lower():
            return i
    return -1

def mostrar_busqueda(lista, posicion: int):
    producto = lista[posicion]
    estado = "DISPONIBLE" if producto["disponible"] else "SIN STOCK"
    print(f"Artículo encontrado en posición {posicion}:")
    print(f"Nombre: {producto['nombre']}")
    print(f"Stock: {producto['stock']}")
    print(f"Precio: {producto['precio']}")
    print(f"Estado: {estado}")

def eliminar_producto(lista):
    nombre = input("Ingrese el nombre del producto a eliminar: ").strip()
    if not nombre:
        print("Error: Debe ingresar un nombre.")
        return
    
    posicion = buscar_producto(lista, nombre)

    if posicion == -1:
        print(f"El producto '{nombre}' no se encuentra registrado.")
    else:
        eliminado = lista.pop(posicion)
        print(f"Producto '{eliminado['nombre']}' eliminado correctamente.")

def actualizar_disponibilidad(lista):
    for producto in lista:
        producto["disponible"] = producto["stock"] > 0
    print("Disponibilidad actualizada según stock.")

def mostrar_productos(lista):
    if not lista:
        print("Aún no hay productos registrados. Ingrese uno para visualizarlo en esta opción.")
        return
    actualizar_disponibilidad(lista) 
    
    print("=== LISTA DE PRODUCTOS ===")
    for producto in lista:
        estado = "DISPONIBLE" if producto["disponible"] else "SIN STOCK"
        print(f"Nombre: {producto['nombre']}")
        print(f"Stock: {producto['stock']}")
        print(f"Precio: {producto['precio']}")
        print(f"Estado: {estado}")
        print("********************************************")

#programa
while True:
    menu()
    opc = opcion()
        
    if opc == 1:
        agregar_producto(coleccion_productos)
    elif opc == 2:
        nombre = input("Ingrese el nombre del producto a buscar: ").strip()
        pos = buscar_producto(coleccion_productos, nombre)
        if pos != -1:
            mostrar_busqueda(coleccion_productos, pos)
        else:
            print(f"Error: Item '{nombre}' no encontrado.")
    elif opc == 3:
        eliminar_producto(coleccion_productos)
    elif opc == 4:
        actualizar_disponibilidad(coleccion_productos)
    elif opc == 5:
        mostrar_productos(coleccion_productos)
    elif opc == 6:
        print("Gracias por usar el sistema. Vuelva Pronto")
        break