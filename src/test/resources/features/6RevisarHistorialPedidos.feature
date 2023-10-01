#language:es

Característica: Revisar Historial pedidos

  Antecedentes: Iniciar sesion
    Dado ingreso a la Tienda Jugos Owasp
    Dado Ingreso al Login
    Cuando Ingresar la informacion de  usuarios
      |pruebas879@prueba.com|123456789|

  Escenario: Revisar Historial pedidos agregados
    Cuando selecciona la opcion de historial de pedidos
    Entonces se visualiza los pedidos completados
