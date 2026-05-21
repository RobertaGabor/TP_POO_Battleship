/*
********************
RESPONSABLE: -
********************
⚠️ AVISO⚠️

Estimado equipo, las estructuras base del proyecto ya están definidas en código.

Se pueden agregar nuevos atributos y funciones según se requiera, bajo las siguientes condiciones obligatorias:



Comunicación inmediata: Todo cambio o incorporación debe notificarse al equipo por este canal sin excepción.

Responsabilidad: Cada integrante es responsable de su código y del impacto que este genere en el trabajo de los demás.

Mantengamos una comunicación fluida para evitar conflictos en la integración del sistema.

************************************RECUERDEN USAR SUS BRANCHES PARA LUEGO MERGEAR*********************

*/

package controlador;

import juego.Juego;


public class Controlador {
    public Juego juego;
    private int anchoPantalla;


    public Controlador()
    {
        //juego= new Juego();
        this.juego = new Juego();
        this.anchoPantalla = 1024; // El tamaño que decidan para la pantalla
    };

    public void iniciarPartida()
    {
        juego.iniciarPartida();
        // El bucle principal del juego
        while (juego.isEnPartida()) {

            procesarEntrada(); // Acá leeríamos el teclado del jugador

            juego.actualizarJuego(anchoPantalla);

            // Pausa de milisegundos para que el juego no corra a la velocidad de la luz

            try {
                Thread.sleep(50); 
            } catch (InterruptedException e) {
                e.printStackTrace();

            }
        }

        System.out.println("Fin del juego.");

        //instanciar controladores de movimiento
        //instanciar pantallas
        //instanciar timers de actualizacion de pantalla
    };
    public void actualizarJuego()
    {

    };
    public int obtenerAnchoPantalla()
    {


    	return 1;
    };
    public void procesarEntrada()
    {

    };

}
