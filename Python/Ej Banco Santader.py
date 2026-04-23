print("Bienvenido a la interfaz de Cajeros Automáticos de Banco Santander")

while True:
    rut = input("Ingrese su RUT (sin puntos ni guion, ej: 12345678k): ").lower() # ponemos todo en minúscula para evitar la temida K

    # Súper validación de longitud
    if len(rut) != 9:
        print("Error: El RUT debe tener exactamente 9 caracteres.")
        continue

    # Extraemos el último digito para cachar si es válido
    verificador = rut[-1]
    if not (verificador.isdigit() or verificador == 'k'):
        print("Error: El dígito verificador no es válido (debe ser número o 'k').")
        continue


    print("RUT validado correctamente.")
    
    # Validamos longitud de clave
    clave = input("Por favor, ingresa tu clave (10 dígitos): ")
    
    if len(clave) == 10:
        print("Clave correcta. Bienvenido al Banco Santander. ¿Qué desea hacer?")
        break  # chao usuario
    else:
        print(f"Error: Clave errónea. Ingresaste {len(clave)} dígitos, no 10. Intente nuevamente desde el RUT.") 
