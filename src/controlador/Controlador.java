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

import java.util.ArrayList;
import java.util.List;
import modelo.Barco;
import modelo.Carga;
import modelo.Juego;
import views.EstadoJuego;
import views.MovibleView;


public class Controlador {
    private Juego juego;
    private int anchoPantalla;
    private int altoPantalla;
    private static Controlador instance;
    

    public Controlador()
    {
        //juego= new Juego();
        this.juego = new Juego();
        this.anchoPantalla = 1024; // El tamaño que decidan para la pantalla
        this.altoPantalla = 768; // El tamaño que decidan para la pantalla
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
    public int obtenerAltoPantalla()
    {
    	return altoPantalla;
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
        juego.getSubmarino().moverX(-10, obtenerAnchoPantalla(), 120);
    }

    public void moverDerecha()
    {
        juego.getSubmarino().moverX(10, obtenerAnchoPantalla(), 120);
    }

    public void moverArriba()
    {
        juego.getSubmarino().moverY(-10, obtenerAltoPantalla(), 100);
    }

    public void moverAbajo()
    {
        juego.getSubmarino().moverY(10, obtenerAltoPantalla(), 100);
    }
    

    //Views:

    public MovibleView getSubmarinoViews()
    {
        return new MovibleView(
            (int) juego.getSubmarino().getPosX(),
            (int) juego.getSubmarino().getPosY(),
            80, // Ancho del submarino
            40, // Alto del submarino
            false // El submarino no explota
        );


    }
    public List<MovibleView> getBarcosView() {
        List<MovibleView> views = new ArrayList<>();
        for(Barco b : juego.getBarcosActivos()) {
            views.add(new MovibleView((int) b.getPosX(), (int) b.getPosY(), 120, 60, false));
        }
        return views;
    }

    public List<MovibleView> getCargasView() {
        List<MovibleView> views = new ArrayList<>();
        for(Carga c : juego.getCargasActivas()) 
            {
            views.add(new MovibleView((int) c.getPosX(),(int) c.getPosY(),60,60,c.isExplotando()));
            }
        return views;
    }

    public EstadoJuego getEstadoJuegoView() {
        return new EstadoJuego(
            juego.getSubmarino().getVida(),
            juego.getSubmarino().getPuntaje(),
            juego.getSubmarino().getVidas(),
            juego.getNivelActual(),
            juego.getSubmarino().estaMuerto() // Asumo que creaste este método en Submarino
        );
    }

   


    

}
