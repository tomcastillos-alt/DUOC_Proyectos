info_estudiantes = {
    "nombres": [],
    "ingles": [],
    "mate": [],
    "lenguaje": [],
    "historia": [],
    "ciencia": [],
    "promedios": []
}
print("Bienvenido al sistema de calificaciones de Juanito School")


while True:
    try:
        nombre_estudiante = str(input("Por favor, ingrese el nombre del estudiante a evaluar: "))
        if nombre_estudiante.strip() == "":
            print("Error: El nombre no puede estar vacío. Por favor, ingresa un nombre válido.")
            continue
        else:
            info_estudiantes["nombres"].append(nombre_estudiante)
        break
    except:
        print("Error: Intenta de nuevo, el nombre no es válido.")
        continue
while True:
    try:
        nota_ingles = float(input("Ingrese nota de Inglés: "))
        if nota_ingles < 1 or nota_ingles > 7:
            print("Error: La nota de Inglés debe estar entre 1 y 7. Por favor, ingresa una nota válida.")
            continue
        info_estudiantes["ingles"].append(nota_ingles)
        break
    except:
        print("Error: Intenta de nuevo, la nota de Inglés no es válida.")
        continue

while True:
    try:
        nota_mates = float(input("Ingrese nota de Matemáticas: "))
        if nota_mates < 1 or nota_mates > 7:
            print("Error: La nota de Matemáticas debe estar entre 1 y 7. Por favor, ingresa una nota válida.")
            continue
        info_estudiantes["mate"].append(nota_mates)
        break
    except:
        print("Error: Intenta de nuevo, la nota de Matemáticas no es válida.")
        continue

while True:
    try:
        nota_lengua = float(input("Ingrese nota de Lenguaje: "))
        if nota_lengua < 1 or nota_lengua > 7:
            print("Error: La nota de Lenguaje debe estar entre 1 y 7. Por favor, ingresa una nota válida.")
            continue
        info_estudiantes["lenguaje"].append(nota_lengua)
        break
    except:
        print("Error: Intenta de nuevo, la nota de Lenguaje no es válida.")
        continue

while True:
    try:
        nota_historia = float(input("Ingrese nota de Historia: "))
        if nota_historia < 1 or nota_historia > 7:
            print("Error: La nota de Historia debe estar entre 1 y 7. Por favor, ingresa una nota válida.")
            continue
        info_estudiantes["historia"].append(nota_historia)
        break
    except:
        print("Error: Intenta de nuevo, la nota de Historia no es válida.")
        continue

while True:
    try:
        nota_ciencia = float(input("Ingrese nota de Ciencia: "))
        if nota_ciencia < 1 or nota_ciencia > 7:
            print("Error: La nota de Ciencia debe estar entre 1 y 7. Por favor, ingresa una nota válida.")
            continue
        info_estudiantes["ciencia"].append(nota_ciencia)
        break
    except:
        print("Error: Intenta de nuevo, la nota de Ciencia no es válida.")
        continue

promedio = (nota_ingles + nota_mates + nota_lengua + nota_historia + nota_ciencia) / 5

info_estudiantes["promedios"].append(round(promedio, 2))

print(f"Estudiante: {info_estudiantes['nombres']}")
print(f"Inglés: {info_estudiantes['ingles']}")
print(f"Matemáticas: {info_estudiantes['mate']}")
print(f"Lenguaje: {info_estudiantes['lenguaje']}")
print(f"Historia: {info_estudiantes['historia']}")
print(f"Ciencia: {info_estudiantes['ciencia']}")
print(f"Promedio: {info_estudiantes['promedios']}")

if promedio > 4.0:
    print("Estudiante aprobado.")
else:    print("Estudiante reprobado.")

