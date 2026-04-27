print("\n === bienvenido al banco falabella ===")

while True:
      rut = input("ingresa tu rut sin el codigo verificador")

      if rut.isdigit() and len(rut) ==8:
        print("rut valido")
        break
      else:
        print("rut invalido")


while True:
      dv = input("ingresa tu codigo verificador").upper()
      if len(dv) == 1 and (dv.isdigit() or dv == 'K'):
        print("dv valido")
        break
      else:
        print("dv invalido")
# nombre

nombre = input("ingresa tu nombre: ")

#valida compra
while True:
      montos = input("ingresa el monto de la compra: ")
      if montos.isdigit():

        monto = int(montos)

        if monto >= 0:
          break
        else:
          print("error, el monto es invalido")
      else:
        print("error, Ingresa solo numero")

#calculo de descuento

if monto < 10000:
  descuento = 0
  porcentaje = 0

elif monto <= 50000:
   descuento = monto - monto * 0.10
   porcentaje = 10

else:
  descuento = monto - monto * 0.20
  porcentaje = 20


#boleta

print("\n ==== boleta ====")

print(f"rut: {rut}-{dv}")
print(f"nombre: {nombre}")
print(f"monto: {monto}")
print(f"descuento: {descuento}")
print(f"porcentaje de descuento: {porcentaje}")

######################