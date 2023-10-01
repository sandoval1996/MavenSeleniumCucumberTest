#language:es

Característica: Agregar Metodos de pagos

  Antecedentes: Iniciar sesion
    Dado ingreso a la Tienda Jugos Owasp
    Dado Ingreso al Login
    Cuando Ingresar la informacion de  usuarios
      |pruebas123@prueba.com|123456789|

  Esquema del escenario: Agregar metodos de pagos
    Cuando selecciona la opcion de agregar metodo de pagos
    Cuando Ingresar la informacion de metodo de pagos
      |NombreTarjeta  |NumeroTarjeta  | Mes |Ano  |
      |<nombretarjeta>|<numerotarjeta>|<mes>|<ano>|
    Entonces se evidencia que guarda la informacion del metodo de pago.

    Ejemplos:
      | nombretarjeta      | numerotarjeta | mes| ano      |
      | mastercard         | 1234567891011213     | 1 | 2092     |
      | america express    | 1234561191011213     | 2 | 2093     |
