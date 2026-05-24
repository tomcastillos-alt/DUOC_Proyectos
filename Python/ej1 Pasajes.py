basepasaje= 95000
emisiontarjeta= 5000

print("Bienvenido al sistema de calculo de pasajes de Latam Air")
print("La tarifa base del pasaje es de $95.000, y el costo de emisión de la tarjeta de embarque es de $5.000.")
print("Descuentos: Distancia igual o mayor a 400km 20% dcto / Distancia menor a 400km 14% dcto")
print("El valor final corresponde al coste mensual de los pasajes")

        
try:
    while True:
        distancia = int(input("Ingrese la distancia del vuelo en kilómetros para calcular los descuentos: "))
        if distancia < 0:
            print("La distancia no puede ser negativa. Por favor, ingresa un número válido.")
            continue
        else: 
            break
except ValueError:
    print("Entrada no válida. Por favor, ingresa un número entero.")
    exit() 


if distancia >= 400:
    descuento = basepasaje * 0.20
    categoria = "Categoria 1 o 2"   
else:    descuento = basepasaje * 0.14
categoria = "Categoria 3 o 4"

total = basepasaje - descuento + emisiontarjeta
print(f"El total a pagar por el pasaje es: ${total:.2f}")
print(f"La categoría del pasaje es: {categoria}")

