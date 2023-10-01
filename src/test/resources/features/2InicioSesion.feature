#language:es

Característica: Iniciar sesion

  Antecedentes: Iniciar sesion
    Dado ingreso a la Tienda Jugos Owasp
    Dado Ingreso al Login

   Escenario: Inicio sesion exitoso
     Cuando Ingresar la informacion de  usuarios
     |pruebas879@prueba.com|123456789|
     Entonces se evidencia que se muestra el mensaje del inicio de sesion exitoso


   Escenario: Inicio sesion fallido
     Cuando Ingresar la informacion de  usuarios
       |prueba4@prueba.com|123456|
     Entonces se evidencia que se muestra el mensaje del inicio de sesion fallido


