#language:es

Característica: Agregar Productos a la cesta

  Antecedentes: Iniciar sesion
    Dado ingreso a la Tienda Jugos Owasp
    Dado Ingreso al Login
    Cuando Ingresar la informacion de  usuarios
      |pruebas123@prueba.com|123456789|

  Escenario: Agregar productos a la cesta
    Cuando agrega los productos
    |apple|Banana|Shirt|
    Cuando selecciona la direccion y el metodo de pago
    Entonces se evidencia que completa su orden de pago de los productos

  Escenario: Agregar productos aleatorios a la cesta
    Cuando agrega los productos aleatorios
    Cuando selecciona la direccion y el metodo de pago
    Entonces se evidencia que completa su orden de pago de los productos

