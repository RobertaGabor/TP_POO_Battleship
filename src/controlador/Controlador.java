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

import java.util.List;
import modelo.Juego;
import views.BarcoView;
import views.CargaView;
import views.EstadoJuegoView;
import views.SubmarinoView;

 public class Controlador {
    private Juego juego;
    private static Controlador instance;
    

    private Controlador()
    {
    
        this.juego = new Juego();
       
    };

    public void iniciarPartida()
    {
        juego.iniciarPartida();
    };

    
    public void actualizarJuego()
    {
        
    	juego.actualizarJuego();


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
	

		if(instance == null)
			instance = new Controlador();
		return instance;
	}
   
    
    // Agregar métodos para mover el submarino
    public void moverIzquierda()
    {
       juego.moverSubmarinoIzquierda();
    }

    public void moverDerecha()
    {
        juego.moverSubmarinoDerecha();
    }

    public void moverArriba()
    {
        juego.moverSubmarinoArriba();
    }

    public void moverAbajo()
    {
        juego.moverSubmarinoAbajo();
    }
    

    //Views:

    public SubmarinoView getSubmarinoView()
    {
        return juego.getSubmarinoView();
    }
    
    public BarcoView getTamanioBarcoView()
    {
        return juego.getTamanioBarcoView();
    }
    
    public CargaView getTamanioCargaView()
    {
        return juego.getTamanioCargaView();
    }
    
       public List<BarcoView> getBarcosView() {
        return juego.getBarcosView();
    }

    public List<CargaView> getCargasView() {
        return juego.getCargasView();
    }

    public EstadoJuegoView getEstadoJuegoView() {
        return juego.getEstadoJuegoView();
    }


}
