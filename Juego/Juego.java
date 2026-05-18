/*
********************
RESPONSABLE: ROBY
********************
⚠️ AVISO⚠️

Estimado equipo, las estructuras base del proyecto ya están definidas en código.

Se pueden agregar nuevos atributos y funciones según se requiera, bajo las siguientes condiciones obligatorias:



Comunicación inmediata: Todo cambio o incorporación debe notificarse al equipo por este canal sin excepción.

Responsabilidad: Cada integrante es responsable de su código y del impacto que este genere en el trabajo de los demás.

Mantengamos una comunicación fluida para evitar conflictos en la integración del sistema.

************************************RECUERDEN USAR SUS BRANCHES PARA LUEGO MERGEAR*********************

*/

package juego;

public interface Juego {
    
    private Submarino submarino;
    private List<Barco> barcosActivos;
    private List<Carga> cargasActivas;
    private int barcosPendientes;
    private int nivelActual;
    private float velocidadBarcos;
    private float velocidadCargas;

    public void iniciarPartida()
    {

    };
    public void actualizarJuego(int anchoPantalla)
    {

    };
    public void verificarGeneracionBarco()
    {

    };
    public void agregarBarco(Barco barco)
    {

    };
    public void eliminarBarco(Barco barco)
    {

    };
    public void agregarCarga(Carga carga)
    {

    };
    public void eliminarCarga(Carga carga)
    {

    };
    public void procesarExplosion(Carga carga)
    {

    };
    public void verificarFinNivel()
    {

    };
    public void incrementarNivel()
    {
        
    };

}
