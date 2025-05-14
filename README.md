# ExITS_64638
username=fernando
password=reyes2004

POSTMAN
POST
http://localhost:8080/api/personas

GET
http://localhost:8080/api/personas

GET
http://localhost:8080/api/personas/1

POST
http://localhost:8080/api/libros

GET
http://localhost:8080/api/libros

GET
http://localhost:8080/api/libros/1

POST 
http://localhost:8080/api/prestamos?libroId=1&personaId=1&fechaPrestamo=2025-05-15

GET
http://localhost:8080/api/prestamos

DELETE
http://localhost:8080/api/prestamos/1
