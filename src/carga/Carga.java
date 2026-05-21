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
import java.util.Random;

public class Carga {
    
    private float posX;
    private float posY;
    private float profundidadDetonacion;
    private float velocidadCaida;
    private static final float LIMITE_SUPERIOR_Y = 300.0f;
    private static final float LIMITE_INFERIOR_Y = 800.0f;
    private boolean exploto = false;
    
    public Carga(float velocidad, float posX, float posY)
    {
        this.posX = posX;
        this.posY = posY;
    	this.velocidadCaida=velocidad;
    }

    public void caer()
    {
        Random rand = new Random();
       if(posY < LIMITE_INFERIOR_Y && posY >= LIMITE_SUPERIOR_Y ){
           posY += velocidadCaida;
       }
       else
       {
           posY = LIMITE_INFERIOR_Y + rand.nextFloat() * (LIMITE_SUPERIOR_Y - LIMITE_INFERIOR_Y);
           exploto = true;
       }

    };
    public boolean verificarDetonacion(){
        return exploto;
    };
    //Getters
    public float getPosX()
    {
    	return this.posX;
    };
    public float getPosY()
    {
    	return this.posY;
    };




}
