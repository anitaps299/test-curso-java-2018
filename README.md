# Curso Java atSistemas 2018

Este repositorio se usará para la realización de una prueba para mostrar los conocimientos adquiridos durante el curso. 
A continuación se muestra las indicaciones para realizar la prueba:

## Requisitos
- Es necesario tener instalado al menos la JDK 8
- Es necesario tener instalado GIT
- Es necesario tener instalado Maven ya sea de forma local o bien mediante la versión embebida que ofrece Eclipse

## Descripción del problema
Se requiere implementar un API REST con las operaciones CRUD básicas para gestionar libros. La ruta para acceder a este
recurso será "/book" y el servidor donde se ejecute lo hará a través del puerto 8080.

## Modelo de datos
`{
	"isbn": "ABN123443311",
	"name": "The lord of the rings",
	"synopsis": "The Lord of the Rings is an epic high fantasy novel written by English author and scholar ...",
	"pages": "1900"
}`
- isbn: Codigo unico que identifica un libro
- name: Nombre del libro
- synopsis: Descripción breve del libro
- pages: Numero de paginas que contiene el libro

## Control de errores
- 400 (Bad request): La url que se ha usado no cumple con las especificaciones fijadas en el controlador
- 404 (Not found): No existe en recurso que se busca
