# Biblioteca API

Este proyecto es una API para la gestión de una biblioteca, desarrollada utilizando Spring Framework y Hibernate. Permite administrar libros, personas y préstamos de libros.

## Estructura del Proyecto

El proyecto está organizado de la siguiente manera:

- **src/main/java/com/ejemplo/biblioteca**: Contiene el código fuente de la aplicación.
  - **BibliotecaApiApplication.java**: Punto de entrada de la aplicación.
  - **controller**: Controladores para gestionar libros, personas y préstamos.
    - **LibroController.java**: Controlador para operaciones relacionadas con libros.
    - **PersonaController.java**: Controlador para operaciones relacionadas con personas.
    - **PrestamoController.java**: Controlador para operaciones relacionadas con préstamos.
  - **model**: Clases que representan las entidades del sistema.
    - **Libro.java**: Representa la entidad Libro.
    - **Persona.java**: Representa la entidad Persona.
    - **Prestamo.java**: Representa la entidad Prestamo.
  - **repository**: Interfaces para acceder a los datos.
    - **LibroRepository.java**: Repositorio para la entidad Libro.
    - **PersonaRepository.java**: Repositorio para la entidad Persona.
    - **PrestamoRepository.java**: Repositorio para la entidad Prestamo.
  - **service**: Clases que contienen la lógica de negocio.
    - **LibroService.java**: Servicio para la entidad Libro.
    - **PersonaService.java**: Servicio para la entidad Persona.
    - **PrestamoService.java**: Servicio para la entidad Prestamo.

- **src/main/resources**: Contiene recursos de la aplicación.
  - **application.properties**: Configuración de la aplicación.
  - **README.md**: Documentación específica de recursos.

- **src/test/java/com/ejemplo/biblioteca**: Contiene pruebas unitarias para la aplicación.
  - **BibliotecaApiApplicationTests.java**: Pruebas para la aplicación.

- **pom.xml**: Archivo de configuración de Maven que define las dependencias y configuraciones del proyecto.

## Requisitos

- Java 17 o superior
- Maven
- MariaDB

## Cómo Ejecutar el Proyecto

1. Clona el repositorio.
2. Navega al directorio del proyecto.
3. Ejecuta el siguiente comando para compilar y ejecutar la aplicación:

```
mvn spring-boot:run
```

## Cómo Probar la API

Para instrucciones detalladas sobre cómo probar los endpoints de la API utilizando curl en la terminal y Postman, consulta el archivo [API_TESTING.md](API_TESTING.md).

## Contribuciones

Las contribuciones son bienvenidas. Si deseas contribuir, por favor abre un issue o envía un pull request.

## Licencia

Este proyecto está bajo la Licencia MIT.

## Cambios Realizados

Se han realizado los siguientes cambios para hacer funcional el proyecto:

1. Actualización de la versión de Spring Boot de 3.4.5 (que no existe) a 3.2.0 (versión estable).
2. Reemplazo de la dependencia javax.persistence-api por jakarta.persistence-api para compatibilidad con Spring Boot 3.x.
3. Actualización de las clases de modelo (Libro, Persona, Prestamo) para usar las importaciones de jakarta.persistence en lugar de javax.persistence.
4. Actualización de la documentación para reflejar el requisito de Java 17 y la dependencia de MariaDB.

Estos cambios permiten que el proyecto compile y se ejecute correctamente con las versiones actuales de Spring Boot y Java.
