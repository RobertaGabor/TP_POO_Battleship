/*
********************
RESPONSABLE: BRUNO
********************

⚠️ AVISO⚠️

Estimado equipo, las estructuras base del proyecto ya están definidas en código.

Se pueden agregar nuevos atributos y funciones según se requiera, bajo las siguientes condiciones obligatorias:



Comunicación inmediata: Todo cambio o incorporación debe notificarse al equipo por este canal sin excepción.

Responsabilidad: Cada integrante es responsable de su código y del impacto que este genere en el trabajo de los demás.

Mantengamos una comunicación fluida para evitar conflictos en la integración del sistema.

************************************RECUERDEN USAR SUS BRANCHES PARA LUEGO MERGEAR*********************

*/


package barco;



import carga.Carga;
import java.util.Random;


public class Barco {
    
    private float posX;
    private float posY;
    private float velocidad;
    private int direccion;
    private Random random;
    
    public Barco(float velocidad, int anchoPantalla)
    {
    	this.velocidad=velocidad;
        this.posY = 0.0f; 
        this.random = new Random();
        if (random.nextBoolean()) {
            this.posX = 0.0f;
            this.direccion = 1; // Se mueve hacia la derecha (+)
        } else {
            this.posX = anchoPantalla;
            this.direccion = -1; // Se mueve hacia la izquierda (-)
        }
       
    
    }

    public void avanzar()
    {
        posX += velocidad * direccion;


    };

    public boolean verificarLimites(int anchoPantalla)
    {
        //Verifico si la posicion esta dentro de los parametros.
        if (posX < 0 || posX > anchoPantalla) {
            return false; // El barco ha salido de los límites
        }

        return true;
    };
    public boolean verificarLanzamientoCarga(int anchoPantalla)
    {
        if(verificarLimites(anchoPantalla)) {

        //Utilizo random para que haya una probabilidad del 5% de lanzar una carga.
        return random.nextInt(100) < 5;
    }
    	return  false;       
    };
   
    public Carga soltarCarga()
    {

    	return new Carga(velocidad);
    };
    
    public float getPosX()
    {
    	return this.posX;
    }
    public float getPosY()
    {
    	return this.posY;
    }
    public float getVelocidad()
    {
    	return this.velocidad;
        
    }
    public int getDireccion()
    {
    	return this.direccion;
    }
   
}
