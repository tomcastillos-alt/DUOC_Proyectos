coleccion = []

buscar_nombre = 0

def menu():
    print("========== MENÚ PRINCIPAL ==========")
    print("1. Agregar estudiante")
    print("2. Buscar estudiante")
    print("3. Eliminar estudiante")
    print("4. Actualizar estados")
    print("5. Mostrar estudiantes")
    print("6. Salir")


def opciones():
    try:
        opc = int(input("Por favor, ingrese una opción [1-2-3-4-5-6]: "))

        if opc < 1 or opc > 6:
            print("Error: Por favor, ingrese una opción válida [1-2-3-4-5-6]")
            return
        else:
            return opc
    
    except ValueError:
        print("Error: Por favor, ingrese un número en el campo de opciones [1-2-3-4-5-6]")
        return

def agregar(): # nombre, edad, nota, aprobado


    try:
        nombre_alumno = str(input("Por favor, ingrese el nombre del alumno a registrar: ")).strip().capitalize()

        if nombre_alumno == "" or len(nombre_alumno) <0:
            print("Error: Ingrese el nombre del estudiante a registrar. El campo no puede quedar vacío.")
            return
        
        edad_alumno = int(input("Por favor, ingrese la edad del alumno: "))
        if edad_alumno <=0:
            print("Error: La edad del alumno debe ser superior a 0. Intente nuevamente")
            return

        nota_alumno = float(input("Por favor, ingrese la nota del estudiante: "))
        if nota_alumno <1 or nota_alumno >7:
            print("Error: La nota del estudiante debe estar entre el 1.0 y el 7.0. Intente nuevamente.")
            return
        
        nuevo_alumno = {
            "nombre" : nombre_alumno,
            "edad" : edad_alumno,
            "nota" : nota_alumno,
            "aprobado": False
        }

        coleccion.append(nuevo_alumno)
        
    except ValueError:
        print("Por favor, ingrese un dato válido en el campo solicitado.")
        return
     
def buscar():
    alumno_buscar = str(input("Ingrese el nombre del estudiante a buscar: "))

    if len(coleccion) == 0:
        print("Aún no hay alumnos registrados. Ingrese uno para continuar.")
        return

    for i in range (len(coleccion)):
        if alumno_buscar == coleccion[i]["nombre"]:
            print(f"Alumno encontrado {["nombre"]}")
        else:
            print(f"Alumno no encontrado {alumno_buscar}")


def actualizar():
    for i in range (len(coleccion)):
        i["aprobado"][False] = i["aprobado"][True] >= 4
    print("Estados actualizados.")
    

def quitar():
    alumno_buscar = str(input("Ingrese el nombre del estudiante a eliminar: "))
    for i in range (len(coleccion)):
        if alumno_buscar == ["nombre"]:
            print(f"Alumno encontrado {i["nombre"]}")
            coleccion.pop(i)
            print(f"Alumno eliminado.")
        else:
            print(f"El estudiante {alumno_buscar} no se encuentra registrado.")
            
def mostrar():
    if len(coleccion) == 0:
        print("No hay alumnos registrados.")
    
    for i in coleccion:
        print("=== LISTA DE ESTUDIANTES ===")
        print(f"Nombre: {i["nombre"]} ") 
        print(f"Edad: {i["edad"]} ")
        print(f"Nota: {i["nota"]} ")
        print(f" ¿Aprobado? {i["aprobado"]}")
        print("********************************************")

while True:

    menu()

    opc = opciones()
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
    else:
        print("Error: Por favor, ingrese una opción válida [1-2-3-4-5-6]")
        continue

