#language:es

Característica: Registro de Usuarios


  Esquema del escenario: Registro de usuarios Exitoso.
    Dado ingreso a la Tienda Jugos Owasp
    Cuando Realizo el registro de usuarios
    Cuando Ingreso la informacion de los usuarios
      | Correo   | Contrasena   | RContrasena   | Respuesta   |
      | <correo> | <contrasena> | <rcontrasena> |  <respuesta> |
    Entonces se evidencia que se realizo el registro exitoso

    Ejemplos:
    |correo            | contrasena | rcontrasena  | respuesta |
    |pruebas1236@prueba.com| 123456789  | 123456789    | prueba1     |
    |pruebas4567@prueba.com| 123456789  |  123456789   | prueba2     |






