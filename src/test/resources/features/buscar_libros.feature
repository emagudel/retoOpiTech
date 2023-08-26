#language:es

Característica: Busqueda de libros
  Yo como usuario, realizó la búsqueda de un libro en la página de demoqa/books.
  Válido que sea el libro que busco y lo agrego a mi colección.

  Esquema del escenario: Buscar un libro de manera exitosa
    Dado que <nombre> ingresa a la pagina para buscar libros
    Y verifico que al loguearse sea el nombre del usuario registrado

    #Y selecciona la categoria "Tecnología" y subcategoria "Portátiles"
    Cuando el usuario busca el libro "Speaking JavaScript"

    #Y selecciona otra categoria "Tecnología" y otra subcategoria "Smart TV"

    #Entonces el usuario deberia de ver el detalle del carrito exitosamente
    Ejemplos:
      | nombre |
      | Juan   |