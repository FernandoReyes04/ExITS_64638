# Guía para Probar los Endpoints de la API de Biblioteca

Este documento proporciona instrucciones detalladas sobre cómo probar los endpoints de la API de Biblioteca utilizando curl en la terminal y Postman.

## Configuración Inicial

La API se ejecuta en `http://localhost:8080` por defecto. Asegúrate de que la aplicación esté en ejecución antes de probar los endpoints.

Para iniciar la aplicación, ejecuta:
```
mvn spring-boot:run
```

## Endpoints de Libros

### Obtener todos los libros

#### Curl
```bash
curl -X GET http://localhost:8080/libros
```

#### Postman
- Método: GET
- URL: http://localhost:8080/libros

### Obtener un libro por ID

#### Curl
```bash
curl -X GET http://localhost:8080/libros/1
```

#### Postman
- Método: GET
- URL: http://localhost:8080/libros/1

### Crear un nuevo libro

#### Curl
```bash
curl -X POST http://localhost:8080/libros \
  -H "Content-Type: application/json" \
  -d '{
    "titulo": "Don Quijote de la Mancha",
    "autor": "Miguel de Cervantes",
    "disponible": true
  }'
```

#### Postman
- Método: POST
- URL: http://localhost:8080/libros
- Headers: Content-Type: application/json
- Body (raw, JSON):
```json
{
  "titulo": "Don Quijote de la Mancha",
  "autor": "Miguel de Cervantes",
  "disponible": true
}
```

### Actualizar un libro

#### Curl
```bash
curl -X PUT http://localhost:8080/libros/1 \
  -H "Content-Type: application/json" \
  -d '{
    "titulo": "Don Quijote de la Mancha (Edición Actualizada)",
    "autor": "Miguel de Cervantes",
    "disponible": false
  }'
```

#### Postman
- Método: PUT
- URL: http://localhost:8080/libros/1
- Headers: Content-Type: application/json
- Body (raw, JSON):
```json
{
  "titulo": "Don Quijote de la Mancha (Edición Actualizada)",
  "autor": "Miguel de Cervantes",
  "disponible": false
}
```

### Eliminar un libro

#### Curl
```bash
curl -X DELETE http://localhost:8080/libros/1
```

#### Postman
- Método: DELETE
- URL: http://localhost:8080/libros/1

## Endpoints de Personas

### Obtener todas las personas

#### Curl
```bash
curl -X GET http://localhost:8080/personas
```

#### Postman
- Método: GET
- URL: http://localhost:8080/personas

### Obtener una persona por ID

#### Curl
```bash
curl -X GET http://localhost:8080/personas/1
```

#### Postman
- Método: GET
- URL: http://localhost:8080/personas/1

### Crear una nueva persona

#### Curl
```bash
curl -X POST http://localhost:8080/personas \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Juan Pérez",
    "correo": "juan.perez@ejemplo.com"
  }'
```

#### Postman
- Método: POST
- URL: http://localhost:8080/personas
- Headers: Content-Type: application/json
- Body (raw, JSON):
```json
{
  "nombre": "Juan Pérez",
  "correo": "juan.perez@ejemplo.com"
}
```

### Actualizar una persona

#### Curl
```bash
curl -X PUT http://localhost:8080/personas/1 \
  -H "Content-Type: application/json" \
  -d '{
    "nombre": "Juan Pérez González",
    "correo": "juan.perez.gonzalez@ejemplo.com"
  }'
```

#### Postman
- Método: PUT
- URL: http://localhost:8080/personas/1
- Headers: Content-Type: application/json
- Body (raw, JSON):
```json
{
  "nombre": "Juan Pérez González",
  "correo": "juan.perez.gonzalez@ejemplo.com"
}
```

### Eliminar una persona

#### Curl
```bash
curl -X DELETE http://localhost:8080/personas/1
```

#### Postman
- Método: DELETE
- URL: http://localhost:8080/personas/1

### Obtener préstamos de una persona

#### Curl
```bash
curl -X GET http://localhost:8080/personas/1/prestamos
```

#### Postman
- Método: GET
- URL: http://localhost:8080/personas/1/prestamos

## Endpoints de Préstamos

### Obtener todos los préstamos

#### Curl
```bash
curl -X GET http://localhost:8080/prestamos
```

#### Postman
- Método: GET
- URL: http://localhost:8080/prestamos

### Crear nuevos préstamos

#### Curl
```bash
curl -X POST http://localhost:8080/prestamos \
  -H "Content-Type: application/json" \
  -d '{
    "personaId": 1,
    "librosIds": [1, 2, 3]
  }'
```

#### Postman
- Método: POST
- URL: http://localhost:8080/prestamos
- Headers: Content-Type: application/json
- Body (raw, JSON):
```json
{
  "personaId": 1,
  "librosIds": [1, 2, 3]
}
```

### Eliminar un préstamo

#### Curl
```bash
curl -X DELETE http://localhost:8080/prestamos/1
```

#### Postman
- Método: DELETE
- URL: http://localhost:8080/prestamos/1

## Consejos Adicionales

### Manejo de Errores
- Si recibes un código de estado 404, significa que el recurso solicitado no existe.
- Si recibes un código de estado 400, verifica que el formato de tu solicitud sea correcto.

### Visualización de Respuestas en Curl
Para una mejor visualización de las respuestas JSON en curl, puedes usar herramientas como `jq`:

```bash
curl -X GET http://localhost:8080/libros | jq
```

### Colecciones de Postman
Puedes crear una colección en Postman para organizar todas tus solicitudes y facilitar las pruebas.