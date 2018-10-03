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
	"isbn": "ABN123443311",
	"name": "The lord of the rings",
	"synopsis": "The Lord of the Rings is an epic high fantasy novel written by English author and scholar ...",
	"pages": "1900"
}
```
- isbn: Codigo unico que identifica a un libro
- name: Nombre del libro
- synopsis: Descripción breve del libro
- pages: Numero de paginas que contiene el libro

## Control de errores
- 400 (Bad request): La url que se ha usado no cumple con las especificaciones fijadas en el controlador
- 404 (Not found): No existe en recurso que se busca

## Paginación
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
- content: Lista de los recursos obtenidos
- totalElements: Número total de elementos recuperados
- numberOfElements: Número de elementos que se mostraran en la página actual
- size: Número de elementos por página
- number: Número de página actual


## Descripción del problema
Se requiere implementar un API REST con las operaciones CRUD básicas para gestionar libros. La ruta para acceder a este
recurso será "/book" y el servidor se ejecutará bajo el puerto 8080.
