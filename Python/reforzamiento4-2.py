coleccion_productos = []

def busqueda_id(id_buscar: str) -> int | None:
    for i in range (len(coleccion_productos)):
        if coleccion_productos[i]["nombre"]:
            return i
        return None

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
    try:
        opc = int(input("Seleccione una opción (1-2-3-4-5-6): "))

        if opc <1 or opc >6:
            print("Error: Ingrese un número entre el 1 y el 6. Intente nuevamente")
            return

        return opc
    
    except ValueError:
        print("Error: Ingrese un número entre el 1 y el 6.")

def validar():
    pass

def agregar():
    nombre_item = str(input("Ingrese el nombre del elemento a añadir: ")).strip()



    for i in coleccion_productos:     
            if i["nombre"] == nombre_item:
                print(f"Producto {nombre_item} ya existe en la base de datos")
                return
    
    if len(nombre_item) <1 or nombre_item == " ":
        print("Error: El campo nombre no puede quedar vacío")
        return
    
    stock_item = int(input(f"Ingrese el stock del elemento {nombre_item}: "))

    if stock_item <0:
        print(f"Error: El stock de {nombre_item} debe ser superior o igual a 0")
        return
    
    precio_item = float(input(f"Ingrese el precio unitario del ítem {nombre_item}: "))

    if precio_item <0:
        print(f"El precio de {nombre_item} debe ser superior a 0.")
        return
    
    base_datos = {
        "nombre" : nombre_item,
        "stock" : stock_item,
        "precio" : precio_item,
        "disponible" : False
    }
    coleccion_productos.append(base_datos)
    print("Elementos añadidos correctamente.")

def quitar():
    id_buscar = str(input("Ingrese el nombre del artículo a eliminar: "))
    posicion = busqueda_id(id_buscar)

    if posicion is None:
        print(f"El producto '{id_buscar}' no se encuentra registrado.")
        return
    
    eliminar = coleccion_productos.pop(posicion)
    print(f"Elemento {eliminar['nombre']} eliminado.")
    


def buscar():
    id_buscar = str(input("Ingrese el nombre del artículo a buscar: "))
    posicion = busqueda_id(id_buscar)

    if posicion is None:
        print(f"Error: Artículo {id_buscar} no encontrado. Busque otro artículo o intente nuevamente.")
        return
    
    else:
        for j in coleccion_productos:     
            if j["nombre"] == id_buscar:
                print(f"Artículo encontrado: ")
                print(f"Nombre: {j["nombre"]} - Stock: {j["stock"]} - Precio: {j["precio"]} - Estado: {j["disponible"]}")
            else:
                print("Item no encontrado. Intente nuevamente.")

def mostrar():
    if len(coleccion_productos) == 0:
        print("Aún no hay productos registrados. Añade uno para visualizarlo en esta opción.")
        return
    
    actualizar()
    for u in coleccion_productos:
        if u["disponible"] == True:
            estado = "DISPONIBLE"
        else:
            estado = "SIN STOCK"
        print("=== LISTA DE PRODUCTOS ===")
        print(f"Nombre: {u["nombre"]}")
        print(f"Stock: {u["stock"]}")
        print(f"Precio: {u["precio"]}")
        print(f"Estado: {estado}")
        print(f"********************************************")



def actualizar():
    for e in coleccion_productos:
        if e["stock"] > 0:
            e["disponible"] = True  
        else:
            e["disponible"] = False 
    print("Disponibilidad de productos actualizada según stock.")



while True:

    menu()
    opc = opcion()
    
    if opc == 1:
        agregar()

    elif opc == 2:
        buscar()

    elif opc == 3:
        quitar()

    elif opc == 4:
        actualizar()

    elif opc == 5:
        mostrar()

    elif opc == 6:
        print("Gracias por usar el sistema. Vuelva Pronto")
        break
