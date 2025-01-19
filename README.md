# Proyecto: The Legend of Morio

**Autor:** Vicente Perez  

## Descripción del Proyecto
Este proyecto implementa un juego de rol basado en texto, inspirado en "The Legend of Morio". El juego permite al jugador interactuar con un mundo mágico creado por un Dungeon Master (DM). Los jugadores pueden elegir entre clases como mago, druida y guerrero, completar misiones, enfrentarse a enemigos y subir de nivel, todo mientras exploran un mundo cíclico compuesto por montañas, planicies y bosques.

## Instrucciones de Compilación y Ejecución
1. Abrir la consola en la carpeta **Tarea3LP_2020730423**.
2. Ejecutar el comando `make run` para compilar y ejecutar el programa utilizando el Makefile.
3. Alternativamente, compilar manualmente los archivos Java y ejecutar el programa con:
   ```bash
   javac Main.java
   java Main
   ```
4. Para ejecutar el archivo JAR generado, utilizar:
   ```bash
   java -jar Main.jar
   ```
5. Para limpiar los archivos compilados:
   ```bash
   make clean
   ```
6. Todas las interacciones del juego se realizan por consola. Cada pregunta incluye opciones indicadas entre paréntesis para facilitar la elección.

## Suposiciones
- No se ingresarán inputs erróneos.
- Todas las letras **"ñ"** se han cambiado por **"n"** para evitar problemas al imprimir datos por pantalla.

## Funcionalidades Extra
1. **Nuevos Atributos:**
   - Se han agregado los atributos `vidaMax`, `manaMax`, `energiaMax`, `inteligenciaMax` y `fuerzaMax` a las clases **Mago**, **Druida** y **Guerrero**. Estos atributos permiten gestionar el incremento de capacidades al subir de nivel.

2. **Método de Nivel Actual:**
   - Se implementó un método que calcula y retorna el nivel actual del personaje basado en su experiencia acumulada.

## Estructura del Proyecto
El proyecto incluye las siguientes clases:
- **Jugador.java** (abstracta): Clase base para los personajes del jugador.
  - Subclases: **Mago.java**, **Guerrero.java**, **Druida.java**.
- **Mision.java:** Maneja los objetivos y recompensas de las misiones.
- **NPC.java** (abstracta): Base para los NPC buenos, malos y neutros.
- **Enemigo.java** (interfaz): Implementada por **Monstruo.java** y **JefeFinal.java**.
- **Tierra.java** (abstracta): Define los tipos de terreno del mundo, como **Montana.java**, **Planicie.java** y **Bosque.java**.
- **Main.java:** Contiene la lógica principal del juego.
- **Makefile:** Simplifica la compilación y ejecución.

## Ejemplo de Ejecución
- Al iniciar el programa, el DM define el tamaño y composición del mundo.
- El jugador elige su nombre y clase.
- Durante el juego, el jugador puede moverse por el mundo, interactuar con NPCs, completar misiones y enfrentarse a enemigos.
- El programa guía al jugador con mensajes claros sobre sus acciones, decisiones y consecuencias.

---
Este README proporciona una guía completa para compilar, ejecutar y entender el funcionamiento del proyecto. ¡Disfruta de tu aventura en The Legend of Morio!

