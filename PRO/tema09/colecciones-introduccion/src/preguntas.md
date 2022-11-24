# Estructuras dinámicas de datos: Colecciones

### 1. ¿Qué es una colección?

Una colección es un conjunto de elementos de un mismo tipo, el tamaño de la colección es dinámico.

### 2. Tratamiento de datos ¿Estático o dinámico?

Dinámico, no reserva un tamaño fijo en memoria.

### 3. ¿Qué tipos de colecciones hay?

Conjuntos, listas y mapas.

### 4. ¿De quién heredan y a quien implementan?

Las listas implementan List, esta interfaz hereda de Collection. Las colecciones implementan Set, esta interfaz hereda
de Collection. Los mapas implementan Map.

### 5. Métodos típicos de todas las colecciones

* int size()
* booean add(E elemento)
* Iterator <e> iterator()
* void clear()
* boolen contains(Object elemento)
* Object[] toArray()
* boolean isEmpty()
* boolean equals(Object elemento)