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

    public Controlador()
    {
        juego= new Juego();
    };

    public void iniciarPartida()
    {
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
