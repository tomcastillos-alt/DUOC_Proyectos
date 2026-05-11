suma = 0


for i in range (5):
    while True:
        try:

            numero = float(input(f"Ingresa el número {i +1}: "))

            suma = suma + numero

            break

        except:
            print("Error, intenta nuevamente: ")
    
print("La suma total es: ", suma)