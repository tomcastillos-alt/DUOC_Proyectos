
usuario = str(input("Ingrese su nombre de usuario: "))
contra = str(input(" Ingrese su contraseña: "))


print(f"Perfecto {usuario}, usted está registrado")

i = 1

while i == 1:
    print(f"Por favor seguridad, vuelva a ingresar sus credenciales, {usuario} ")
    user=input(" Ingrese su nombre de usuario: ")
    if usuario == user:
        print ("Usuario correcto")
        i = 2
    else: 
        print("Usuario incorrecto.")

while i == 2:
    password=input(" Ingrese su contraseña: ")
    if contra == password:
        print ("contraseña correcta")
        print (f"Bienvenido, {usuario}.")
        i = 3
    else: 
        print("contraseña errónea.")


