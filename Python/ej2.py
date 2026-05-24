import random

print("Bienvenido al adivinador de números, juego donde debes adivinar un número entre dos valores ingresados!")

try:
    while True:
        num1 = int(input("Ingrese el primer número: "))
        num2 = int(input("Ingrese el segundo número: "))
        if num1 > num2:
            print("El primer número debe ser menor que el segundo. Inténtalo de nuevo.")
            continue
        if num1 == num2:
            print("Los números deben ser diferentes.")
            continue
        random_num = random.randint(num1, num2)
        break
except ValueError:
    print("Entrada no válida. Por favor, ingresa números enteros.")
    exit()

intentos = 0
max_intentos = 3

while intentos < max_intentos:
    try:
        adivina = int(input(f"Adivina el número (Intento {intentos+1}/{max_intentos}): "))
        intentos += 1
        if adivina < random_num:
            print("Demasiado bajo. Inténtalo de nuevo.")
        elif adivina > random_num:
            print("Demasiado alto. Inténtalo de nuevo.")
        else:
            print(f"¡Felicidades! Has adivinado el número {random_num} en {intentos} intentos.")
            break
    except ValueError:
        print("Entrada no válida. Ingresa un número entero.")
        intentos += 1 
else:
    print(f"Fallaste!. El número era {random_num}.")