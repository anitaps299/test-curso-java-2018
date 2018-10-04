# Curso Java atSistemas 2018

Este repositorio se usará para la realización de una prueba para mostrar los conocimientos adquiridos durante el curso. 
A continuación se muestra las indicaciones para realizar la prueba:

## Requisitos
- Es necesario tener instalado al menos la JDK 8
- Es necesario tener instalado GIT
- Es necesario tener instalado Maven ya sea de forma local o bien mediante la versión embebida que ofrecen algunos IDEs (por ejemplo Eclipse)

## Modelo de datos
```
{
        "id: "1",
	"isbn": "ABN123443311",
	"name": "The lord of the rings",
	"synopsis": "The Lord of the Rings is an epic high fantasy novel written by English author and scholar ...",
	"pages": "1900"
}
```
- id: Identificador unico del recurso
- isbn: Codigo unico que identifica a un libro
- name: Nombre del libro
- synopsis: Descripción breve del libro
- pages: Numero de paginas que contiene el libro

## Control de errores
- 400 (Bad request): La url que se ha usado no cumple con las especificaciones fijadas en el controlador
- 404 (Not found): No existe en recurso que se busca

## Paginación
A continuacion se muestra la paginacion que se ha usado en la solucion del problema descrito:
```
{
    "content": [],
    "pageable": {
        "sort": {
            "sorted": false,
            "unsorted": true
        },
        "pageSize": 10,
        "pageNumber": 0,
        "offset": 0,
        "paged": true,
        "unpaged": false
    },
    "totalPages": 1,
    "totalElements": 2,
    "last": true,
    "first": true,
    "sort": {
        "sorted": false,
        "unsorted": true
    },
    "numberOfElements": 2,
    "size": 10,
    "number": 0
}
```
Sin embargo, es necesario que la paginacion tenga los siguientes campos para cumplir los requerimientos definidos en los test:
- content: Lista de los recursos obtenidos
- totalElements: Número total de elementos recuperados
- numberOfElements: Número de elementos que se mostraran en la página actual
- size: Número de elementos por página
- number: Número de página actual


## Descripción del problema
Se requiere implementar un API REST con las operaciones CRUD básicas para gestionar libros. La ruta para acceder a este
recurso será "/book" y el servidor se ejecutará bajo el puerto 8080.

Ademas de lo anterior se debe permitir realizar busquedas por nombre a traves de la ruta "/book?name=harry". Se debera buscar todos los libros que contengan la palabra "harry" en su nombre.

No se requiere conexion con base de datos ya que con el proyecto base proporcionado para hacer la prueba se autoconfigura una base de datos en memoria H2, por lo que no es necesario realizar ninguna configuracion de la aplicacion con base de datos.

## Correccion de la prueba
Para corregir la solucion implementada se proporciona una coleccion de pruebas para POSTMAN, para ejecutarlo importarlo desde la aplicacion (POSTMAN) y ejecutar todas las pruebas con un Runner (https://www.getpostman.com/docs/v6/postman/collection_runs/starting_a_collection_run)

Para facilitar su uso se definio una variable de entorno en POSTMAN, por lo que para usar las pruebas es necesario que cree una variable de entorno "host" con la url donde se ejecuta su aplication, por ejemplo "localhost"

## Solución
Una vez finalizada la prueba se subirá el codigo al repositorio creando un tag (solucion) para su posterior uso, ya sea para otros cursos o para la comunidad de Github.
