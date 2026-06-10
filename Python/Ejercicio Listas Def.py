lista_pares = []
lista_impares = []

while True:
    try:
        cantidad = int(input("Ingrese cantidad de números a ingresar: "))
        if cantidad <= 0:
            print("Error: Ingrese un valor superior a 0")
            continue
        else:
            break
    except ValueError:
        print("Error: Ingrese un número.")
        continue
    
def validar_num():
    for i in range(cantidad):
        while True:
            try:
                num = int(input(f"Ingrese el {i + 1} número: "))
                if num %2 == 0:
                    lista_pares.append(num)
                else:
                    lista_impares.append(num)
                break
            except ValueError:
                print("Error: Ingresa un número válido.")

validar_num()
print(f"Se ingresaron {cantidad} números: ")
print(f"Números pares: {lista_pares}")
print(f"Lista impares: {lista_impares}")