# Proyecto Base Screenplay Web - SerenityBDD

Este reto consistirá en automatizar la página de demoqa.com/books, en donde debemos escoger y agregar libros para su respectivas validaciones.

## Contenido

- Automatización Screenplay Web
- Ejecución por Terminal


## Automatización Screenplay Web

En la rama principal [master](https://github.com/emagudel/retoOpiTech "master") encontrarás 1 escenario, para agregar los libros.

## Ejecución por Terminal

Para ejecutar y generar la documentación viva, basta con que por medio de una terminal en la ruta donde esta el proyecto ejecutes la siguiente linea:

`gradle clean test aggregate`

Si no cuentas con gradle configurado en tu maquina, usa el wrapper.

`./gradlew clean test aggregate`

Con esta instrucción limpias el proyecto de archivos temporales, ejecuta los test y genera la documentación viva.

Una vez ejecutado, puedes verificar las evidencias en la ruta:

`.../target/site/serenity/index.html`

