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
    private Juego juego;
    private int anchoPantalla;
    private static Controlador instance;
    

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
       
        }


        //instanciar controladores de movimiento
        //instanciar pantallas
        //instanciar timers de actualizacion de pantalla
    
    public void actualizarJuego()
    {
        // Este método se encarga de actualizar el estado del juego.
    	juego.actualizarJuego(anchoPantalla);

    };
    public int obtenerAnchoPantalla()
    {
    	return anchoPantalla;
    };
    public void procesarEntrada()
    {



    };
     public void pausarJuego()
     {
        juego.pausarJuego();
    }

    public void reanudarJuego()
    {
        juego.reanudarJuego();
    }

    public static Controlador getInstance() {
		//El metodo getInstance es el encargado de devolver la instancia del controlador,
		// si la instancia no existe, se crea una nueva instancia del controlador,
		// si la instancia ya existe, se devuelve la instancia existente

		if(instance == null)
			instance = new Controlador();
		return instance;
	}
    //creo que el get no va aca sino en
    //public Juego getJuego() {
      //  return juego;
    //}

    
    // Agregar métodos para mover el submarino
    public void moverIzquierda()
    {
        juego.getSubmarino().moverX(-10);
    }

    public void moverDerecha()
    {
        juego.getSubmarino().moverX(10);
    }

    public void moverArriba()
    {
        juego.getSubmarino().moverY(-10);
    }

    public void moverAbajo()
    {
        juego.getSubmarino().moverY(10);
    }
    

    

}
