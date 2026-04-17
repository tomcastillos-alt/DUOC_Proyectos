# Super App Banco Estado

# Contador

intento = 5

# Inicio programa

print("Bienvenido al login de la nueva app de Banco Estado.") 
user = input("Digite su nombre de usuario: ")

# Bucle de intentos

while intento > 0:
    print(f"Por favor {user}, escriba sus credenciales.")
    password = input("Digite su clave: ")

    if password == "1234":
        print(f"¡Bienvenido {user} a la app de Banco Estado!")

        break
    else:
        intento = intento - 1
        print(f"Credenciales incorrectas. Le quedan {intento} intentos.")

    if intento == 0:
        print("Error: Por favor, comuníquese con nuestro Call Center.")

