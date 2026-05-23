# Sistema de Películas

El siguiente codigo de Java permite gestionar una Lista de películas utilizando colecciones del framework de Java: `List`, `Set`, `Map`, `TreeSet`  
Implementa un menú por consola para realizar operaciones como agregar, buscar, ordenar y agrupar películas por género.

## El sistema realiza:

- Definir una clase `Pelicula` con atributos: nombre, director, género, duración, año de estreno y rating.
- Usar `ArrayList` para almacenar dinámicamente las películas.
- Usar `HashSet` para evitar películas duplicadas (basado en nombre y año).
- Usar `Map<String, List<Pelicula>>` para agrupar películas por género.
- Permitir búsquedas en `List`, `Set` y `Map`.
- Agregar nuevas películas mediante `Scanner`.
- Ordenar la lista por duración.
- Usar `TreeSet` con `Comparator` para ordenar alfabéticamente por nombre.

## Características

- Menú con 7 opciones.
- Validación de duplicados - no se agregan películas con mismo nombre y año
- Búsqueda eficiente en las tres estructuras.
- Visualización de películas por género.
- Ordenamiento ascendente por duración.
- Visualización de películas en orden alfabético con:  `TreeSet`

## Herramientas 
- Java 11 o superior
- IntelliJ IDEA 
- Colecciones de Java `java.util.*`

