print("Bienvenido a la interfaz de Cajeros Automáticos de Banco Santander")

while True:
    
    rut = input("Ingrese su RUT (sin puntos ni guion, ej: 12345678k): ").lower()

    if len(rut) >= 8 and len(rut) <= 9:
        digitover = rut[-1]

    if digitover.isdigit() or digitover == 'k':
        print("Rut válido.")
    else: 
        print("Rut inválido. Intente nuevamente.")


    clave = str(input(f"Por favor, ingresa tu clave. Esta no debe ser mayor a 10 dígitos: "))
    if len(clave) != 10 :
         print(f"Clave errónea. Lo digitado tiene {len(clave)} dígito(s). Intente nuevamente.")
    else:
      print("Clave correcta. Bienvenido")
      break
 



