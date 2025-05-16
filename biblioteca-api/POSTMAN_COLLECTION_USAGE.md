# Guía para Importar y Usar la Colección de Postman para la API de Biblioteca

Este documento proporciona instrucciones sobre cómo importar y utilizar la colección de Postman incluida en este repositorio para probar los endpoints de la API de Biblioteca.

## Requisitos Previos

1. Tener [Postman](https://www.postman.com/downloads/) instalado en tu computadora.
2. Tener la aplicación de la API de Biblioteca en ejecución localmente.

## Importar la Colección

1. Abre Postman.
2. Haz clic en el botón "Import" en la esquina superior izquierda.
3. Selecciona la opción "File" y luego "Upload Files".
4. Navega hasta donde hayas guardado el archivo `Biblioteca_API_Postman_Collection.json` y selecciónalo.
5. Haz clic en "Import" para completar el proceso.

![Importar Colección](https://learning.postman.com/docs/img/importing-and-exporting-data/import-button.jpg)

## Estructura de la Colección

La colección está organizada en tres carpetas principales:

1. **Libros**: Contiene todas las operaciones relacionadas con libros (obtener todos, obtener por ID, crear, actualizar, eliminar).
2. **Personas**: Contiene todas las operaciones relacionadas con personas (obtener todas, obtener por ID, crear, actualizar, eliminar, obtener préstamos).
3. **Préstamos**: Contiene todas las operaciones relacionadas con préstamos (obtener todos, crear, eliminar).

## Uso de la Colección

### Configuración Inicial

Antes de comenzar a usar la colección, asegúrate de que la API esté en ejecución en `http://localhost:8080`. Si tu API se ejecuta en un host o puerto diferente, necesitarás actualizar las URLs en las solicitudes.

### Probar los Endpoints

1. **Libros**:
   - Para obtener todos los libros, simplemente ejecuta la solicitud "Obtener todos los libros".
   - Para obtener un libro específico, ajusta el ID en la URL de la solicitud "Obtener libro por ID".
   - Para crear un nuevo libro, modifica el cuerpo de la solicitud "Crear nuevo libro" según sea necesario.
   - Para actualizar un libro, ajusta el ID en la URL y modifica el cuerpo de la solicitud "Actualizar libro".
   - Para eliminar un libro, ajusta el ID en la URL de la solicitud "Eliminar libro".

2. **Personas**:
   - Para obtener todas las personas, ejecuta la solicitud "Obtener todas las personas".
   - Para obtener una persona específica, ajusta el ID en la URL de la solicitud "Obtener persona por ID".
   - Para crear una nueva persona, modifica el cuerpo de la solicitud "Crear nueva persona".
   - Para actualizar una persona, ajusta el ID en la URL y modifica el cuerpo de la solicitud "Actualizar persona".
   - Para eliminar una persona, ajusta el ID en la URL de la solicitud "Eliminar persona".
   - Para obtener los préstamos de una persona, ajusta el ID en la URL de la solicitud "Obtener préstamos de una persona".

3. **Préstamos**:
   - Para obtener todos los préstamos, ejecuta la solicitud "Obtener todos los préstamos".
   - Para crear nuevos préstamos, modifica el cuerpo de la solicitud "Crear nuevos préstamos" con el ID de la persona y los IDs de los libros.
   - Para eliminar un préstamo, ajusta el ID en la URL de la solicitud "Eliminar préstamo".

### Flujo de Trabajo Recomendado

Para probar completamente la API, se recomienda seguir este flujo de trabajo:

1. Crear algunas personas usando "Crear nueva persona".
2. Crear algunos libros usando "Crear nuevo libro".
3. Crear préstamos usando "Crear nuevos préstamos".
4. Verificar los préstamos creados usando "Obtener todos los préstamos".
5. Verificar que los libros prestados ya no estén disponibles usando "Obtener libro por ID".
6. Eliminar un préstamo usando "Eliminar préstamo".
7. Verificar que el libro devuelto ahora esté disponible usando "Obtener libro por ID".

## Consejos Adicionales

- Puedes usar la función "Collections Runner" de Postman para ejecutar múltiples solicitudes en secuencia.
- Puedes guardar las respuestas de las solicitudes para referencia futura.
- Si encuentras errores, verifica que la API esté en ejecución y que estés usando los IDs correctos en las URLs y cuerpos de las solicitudes.

## Solución de Problemas

- Si recibes un error 404, verifica que la URL sea correcta y que el recurso solicitado exista.
- Si recibes un error 400, verifica que el formato del cuerpo de la solicitud sea correcto.
- Si recibes un error 500, verifica los logs del servidor para obtener más información sobre el error.