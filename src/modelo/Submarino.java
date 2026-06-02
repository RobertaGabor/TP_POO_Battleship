 /*
********************
RESPONSABLE: SHARON
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

public class Submarino {

    private float posX;
    private float posY;
    private float vida;
    private int vidas;
    private int puntaje;
    // Constantes para el submarino
    private static final float VIDA_MAXIMA = 100.0f;
    private static final int VIDAS_INICIALES = 2;
    private static final int PUNTAJE_INICIAL = 0;
    private int puntosParaSiguienteVidaExtra;
    // Límites de movimiento del submarino
    private static final float LIMITE_SUPERIOR_Y = 300.0f;
    private static final float LIMITE_INFERIOR_Y = 800.0f;
    // Objetivo de puntos para ganar una vida extra
    private static final int OBJETIVO_PUNTOS_VIDA_EXTRA = 500;


    public Submarino(float posX, float posY) {
        //Hago esto por que el submarino tiene un rango de movimiento limitado
        if (posY >= LIMITE_SUPERIOR_Y && posY <= LIMITE_INFERIOR_Y) {
            this.posY = posY;
        } else {
            this.posY = LIMITE_SUPERIOR_Y; // Valor por defecto seguro
        }
        this.posX = posX;
        this.vida = VIDA_MAXIMA;
        this.vidas = VIDAS_INICIALES;
        this.puntaje = PUNTAJE_INICIAL;
        this.puntosParaSiguienteVidaExtra = OBJETIVO_PUNTOS_VIDA_EXTRA;
    }
    public void moverX(float dx) {
        posX += dx;
    }

    public void moverY(float dy) {

        float nuevaPosY = posY + dy;
        //verifico que se cumpla los limites
        if (nuevaPosY >= LIMITE_SUPERIOR_Y && nuevaPosY <= LIMITE_INFERIOR_Y) {
            posY = nuevaPosY;
        }
    }




    public void recibirDanio(float cantidad)
    {
        vida -= cantidad;
        if (vida <= 0) {
            vida = 0; 
            perderVida();
        }

    };

    public void perderVida()
    {
        vidas--;
        if (vidas > 0) {
            vida = VIDA_MAXIMA; // Reinicio la vida al perder una de las vidas
            System.out.println("¡Has perdido una vida! Vidas restantes: " + vidas);
        } else {
            vida = 0;
            vidas = 0;
            System.out.println("GAME OVER");
        }
    };


    public void sumarPuntos(int puntos)
    {
        puntaje+=puntos;
        if (puntaje >= puntosParaSiguienteVidaExtra) {
            evaluarVidaExtra();
        }
        System.out.println("puntos "+puntos);
    };
    public void evaluarVidaExtra()
    {
        if (puntaje >= puntosParaSiguienteVidaExtra) {
            vidas++;
            //Guardo el nuevo valor de los puntos necesarios para la próxima vida extra
            puntosParaSiguienteVidaExtra += OBJETIVO_PUNTOS_VIDA_EXTRA; // Incremento el objetivo para la próxima vida extra
            System.out.println("¡Vida extra obtenida! "+vida);

        }

    };
    public float getPosX()
    {
    	return this.posX;
    };
    public float getPosY()
    {
    	return this.posY;
    }
    public float getVida()
    {
    	return this.vida;
    };
    public int getVidas()
    {
    	return this.vidas;
    };
    public int getPuntaje()
    {
    	return this.puntaje;
    }; 
    public boolean estaMuerto()
    {
        return vidas <= 0;
    };
    
    

}
