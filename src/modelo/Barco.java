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


package modelo;

import java.util.Random;
import views.BarcoView;


public class Barco {
    
    private float posX;
    private float posY;
    private float velocidad;
    private int direccion;
    private Random random;
    
    public Barco(float velocidad)
    {
    	this.velocidad=velocidad;
        this.posY = 60; 
        this.random = new Random();
        if (random.nextBoolean()) {
            this.posX = -120;
            this.direccion = 1; // Se mueve hacia la derecha (+)
        } else {
            this.posX = Juego.anchoPantalla() + 120;
            this.direccion = -1; // Se mueve hacia la izquierda (-)
        }
       
    
    }

    public void avanzar()
    {
        posX += velocidad * direccion;
        

    };

    public boolean verificarLimites()
    {
         int anchoBarco = 120;

        if (direccion == 1) {
            // Viene desde la izquierda y va a la derecha
            return posX <= Juego.anchoPantalla();
        } else {
            // Viene desde la derecha y va a la izquierda
            return posX + anchoBarco >= 0;
        }
    }
    public boolean verificarLanzamientoCarga()
    {
        if(verificarLimites()) {
        //Utilizo random para que haya una probabilidad del 5% de lanzar una carga.
        return random.nextInt(100) < 5;
    }
    	return  false;       
    }
   
    public Carga soltarCarga()
    {


    	return new Carga(velocidad, posX, posY);
    };
    
    public float getPosX()
    {
    	return this.posX;
    }

    // view
   

    public BarcoView getView() {
        return new BarcoView((int) posX,(int) posY,120,60);
    }
   
}
