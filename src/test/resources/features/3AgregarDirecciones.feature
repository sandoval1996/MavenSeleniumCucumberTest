#language:es

Característica: Agregar Direcciones

  Antecedentes: Iniciar sesion
    Dado ingreso a la Tienda Jugos Owasp
    Dado Ingreso al Login
    Cuando Ingresar la informacion de  usuarios
      |pruebas879@prueba.com|123456789|

  Esquema del escenario: Agregar direcciones
    Cuando selecciona la opcion de agregar direcciones
    Cuando Ingresar la informacion de  la direccion
      |Pais  |Nombre  |Celular  |Zip  |Direccion  |Ciudad  |  Estado|
      |<pais>|<nombre>|<celular>|<zip>|<direccion>|<ciudad>|<estado>|
    Entonces se evidencia que guarda la informacion de la direccion.

    Ejemplos:
    | pais         | nombre  | celular     | zip      | direccion        | ciudad      | estado      |
    | colombia     | Test1   | 1234567890  | 12345678 |  calle 1 b oeste | bogota      | Test1       |
    | venezuela    | Test2   | 0987654321  | 87654321 |  calle 2 b oeste | caracas     | Test2       |



