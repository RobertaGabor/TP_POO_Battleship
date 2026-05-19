/*
********************
RESPONSABLE: COTY
********************
⚠️ AVISO⚠️

Estimado equipo, las estructuras base del proyecto ya están definidas en código.

Se pueden agregar nuevos atributos y funciones según se requiera, bajo las siguientes condiciones obligatorias:



Comunicación inmediata: Todo cambio o incorporación debe notificarse al equipo por este canal sin excepción.

Responsabilidad: Cada integrante es responsable de su código y del impacto que este genere en el trabajo de los demás.

Mantengamos una comunicación fluida para evitar conflictos en la integración del sistema.

************************************RECUERDEN USAR SUS BRANCHES PARA LUEGO MERGEAR*********************

*/

package carga;

public class Carga {
    
    private float posX;
    private float posY;
    private float profundidadDetonacion;
    private float velocidadCaida;
    
    public Carga(float velocidad)
    {
    	this.velocidadCaida=velocidad;
    }

    public void caer()
    {

    };
    public boolean verificarDetonacion()
    {
    	return true;
    };
    public float getPosX()
    {
    	return this.posX;
    };
    public float getPosY()
    {
    	return this.posY;
    };

}
