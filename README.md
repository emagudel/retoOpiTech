# Proyecto Base Screenplay Web - SerenityBDD

Este reto consistirá en automatizar la página de demoqa.com/books, en donde debemos escoger y agregar libros para su respectivas validaciones.

<H2>Este proyecto cuenta con las siguientes características:</H2>

- Lenguaje de programación: Java
- Framework de Automatización: Serenity BDD
- Patrón de diseño: Screenplay
- Framework de soporte BDD (Behavior development driver): Cucumber
- Lenguaje de BDD (Behavior development driver): Gherkin
- Constructor de proyecto: Gradle

**Nota:** El proyecto esta diseñado para ser ejecutado en maquinas Windows y navegador Chrome.

<H2>El proyecto posee la siguiente estructura:</H2>

- [ ] src/main/java/com/reto/execptions: Este paquete contiene todas las excepciones que fueron diseñadas en el proyecto.
- [ ] src/main/java/com/reto/interactions: Este paquete maneja todas las funciones de iteraciones.
- [ ] src/main/java/com/reto/questions: Este paquete contiene las questions que se realizaran durante la prueba.
- [ ] src/main/java/com/reto/tasks: Este paquete maneja las tareas que va realizar el usuario para cumplir con lo esperado en la prueba automatizada, asi cumpliendo con el patrón de diseño Screenplay
- [ ] src/main/java/com/reto/utils: En este paquete tenemos las clases que nos ayudaran a cumplir con el BDD ya sea seteando data, obteniendo un texto, entre otros.
- [ ] src/test/java/com/reto/runner: Este paquete contiene el archivo runner el cual se encarga de ejecutar la prueba.
- [ ] src/test/java/com/reto/stepDefinitios: Este paquete contiene los archivos de steps los cuales definen el paso a paso de el lado de lógica de programación.
- [ ] src/test/resources/com/reto/features: Este paquete contiene los archivos feature los cuales definen el escenario a evaluar del lado del BDD.
- [ ] gitignore: El archivo encargado de bloquear subir archivos no necesarios en el repositorio.

## Contenido

- Automatización Screenplay Web
- Ejecución por Terminal


## Automatización Screenplay Web

En la rama principal [master](https://github.com/emagudel/retoOpiTech "master") encontrarás 1 escenario, para agregar los libros.

<H2>Pasos para obtener el proyecto de automation:</H2>

- Clonar el repositorio en la ubicación deseada, usando el comando: git clone https://github.com/emagudel/retoOpiTech

<H2>Pasos para ejecutar el proyecto</H2>

- Se debe primero realizar los pasos de la sección "Pasos para obtener el proyecto de automation"
- Abrir el proyecto en el IDE de su preferencia que soporte Java, ejecutar el archivo BuscarLibrosRunner.

<H2>Generación de reporte del framework</H2>
- Ejecute el proyecto, diríjase a la carpeta target/site/serenity y una vez alli abra en el navegador de su preferencia el archivo index

## Ejecución por Terminal

Para ejecutar y generar la documentación viva, basta con que por medio de una terminal en la ruta donde esta el proyecto ejecutes la siguiente linea:

`gradle clean test aggregate`

Si no cuentas con gradle configurado en tu maquina, usa el wrapper.

`./gradlew clean test aggregate`

Con esta instrucción limpias el proyecto de archivos temporales, ejecuta los test y genera la documentación viva.

Una vez ejecutado, puedes verificar las evidencias en la ruta:

`.../target/site/serenity/index.html`

