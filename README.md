# Trabajo Práctico Obligatorio
## Paradigma Orientado a Objetos

### Submarine Attack

El equipo de analistas ha finalizado el relevamiento para la confección de un videojuego de submarinos denominado “submarine attack” y se solicita al equipo de diseñadores que modele e implemente el sistema relevado. A continuación, se detallan los requerimientos obtenidos por el equipo:

* El juego consiste en manejar un submarino mientras una serie de barcos enemigos nos atacan y nosotros debemos esquivarlos hasta que completen su paso.
* El submarino se mueve bajo el agua de izquierda a derecha o viceversa y puede subir o bajar entre los 300 y 800 metros para esquivar las cargas de profundidad que lanzan los barcos.
* Las cargas de profundidad no son guiadas solamente se hunden en línea recta desde la posición de barco que las lanzó.
* Las cargas poseen un detonador preparado para explotar a una profundidad determinada. Esa profundidad es un valor aleatorio acotado entre los 300 y 700 metros que se define en el momento en que la carga es lanzada.
* Los barcos enemigos están organizados en series de 12 (doce) que circulan de izquierda a derecha o de derecha a izquierda. Nunca puede haber más de 3 (tres) barcos al mismo tiempo. Se considera que los barcos transitan a una profundidad cero.
* Cada nueva nave que comienza su recorrido lo hace desde la derecha o desde la izquierda de manera aleatoria.
* Si sobrevivimos a las cargas explosivas que nos dispararon las naves enemigas pasamos de nivel.
* Si bien todos los niveles tienen las mismas características lo que cambia al pasar de nivel es la velocidad de movimiento de las naves y la velocidad en que lanzan las cargas de profundidad.
* Cada paso de nivel incrementa en un 20% la velocidad de movimiento y la de caída.
* Las cargas de profundidad cuando explotan pueden dañar al submarino según el siguiente criterio:
  * Por cada carga que explota a más de 100m alrededor del submarino obtenemos 30 puntos y no nos produce daño.
  * Por cada carga que explota entre los 50m y los 100m alrededor del submarino obtenemos 10 puntos y disminuye nuestra vida en un 30%.
  * Por cada carga que explota entre 10m y los 50m alrededor del submarino obtenemos 0 puntos y disminuye nuestra vida en un 50%.
  * Por cada carga que explota a menos de 10m alrededor del submarino obtenemos 0 puntos y perdemos una vida.
* Cada vez que se cambia de nivel se obtienen 200 puntos. Cada vez que se consiguen 500 puntos se consigue una vida extra.

---

### Pautas para la entrega:

* Todas las entregas serán digitales. Se incluirá un archivo extra conteniendo el número de grupo y los integrantes y el número de fase.
* Se considerará como fecha de entrega a la correspondiente a la última versión subida a Teams en la sección grupos.
* Las entregas deben realizarse en un único archivo comprimido (`.zip` o `.rar`).
* Si se les solicitaron correcciones a las entregas anteriores, las mismas deben incluirse en la nueva entrega.
* Respetar las consignas y los objetivos.
* Si bien el TPO es de desarrollo grupal, la aprobación es individual ya que en la entrega final se le realizara una evaluación a cada integrante del grupo sobre cualquiera de las partes y/o etapas del TPO.

---

### Pautas para la aprobación del Trabajo Practico Cuatrimestral

* Cumplir con todas las entregas definidas en tiempo y forma.
* Aprobar todas las entregas y/o correcciones.
* Aprobar la evaluación final sobre TPO.

---

### Fases de Entregas

* **Fase A:** Definición de los requerimientos y diagrama de clases.
* **Fase B:** Diagramas de secuencia (todos los requerimientos).
* **Fase C:** Código del negocio funcionando con controlador y test.
* **Final:** Interfaz gráfica que utilice el negocio entregado en la Fase C.

---

### Fechas de Entrega

* **Fase A:** 23/04
* **Fase B:** 30/04
* **Fase C:** 04/06
* **Final:** 18/06 (Defensa según fecha indicada)