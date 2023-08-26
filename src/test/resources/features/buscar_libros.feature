#language:es

Característica: Busqueda de libros
  Yo como usuario, realizó la búsqueda de un libro en la página de demoqa/books.
  Válido que sea el libro que busco y lo agrego a mi colección.

  Esquema del escenario: Buscar y agregar un libro de manera exitosa
    Dado que <nombre> ingresa a la pagina
    Y verifico que al loguearse sea el nombre del usuario registrado
    Cuando el usuario busca el libro "Speaking JavaScript"
    Entonces el usuario deberia de ver el libro en el profile exitosamente
    Y luego elimino el libro y verifico que no este presente en el profile
    Ejemplos:
      | nombre |
      | Juan   |

  Esquema del escenario: Buscar un libro que no exista
    Dado que <nombre> ingresa a la pagina
    Y verifico que al loguearse sea el nombre del usuario registrado
    Cuando el usuario busca el libro "Goku"
    Entonces el usuario NO deberia de ver el libro en el profile exitosamente
    Ejemplos:
      | nombre |
      | Juan   |