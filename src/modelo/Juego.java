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

package modelo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Juego {
    
    private Submarino submarino;
    private List<Barco> barcosActivos;
    private List<Carga> cargasActivas;
    private int barcosPendientes;
    private int nivelActual;
    private float velocidadMovimiento;
    private boolean enPartida;
    private boolean pausado;

    public Juego() {
        this.submarino = new Submarino(100.0f, 300.0f); 
        this.barcosActivos = new ArrayList<>();
        this.cargasActivas = new ArrayList<>();
        this.velocidadMovimiento = (float) 10.0; // Velocidad base inicial
        this.nivelActual = 1;
        this.barcosPendientes = 12; // Los barcos están organizados en series de 12 por nivel
        this.enPartida = false;
        this.pausado = false;
    }
    
    public void iniciarPartida() {
        this.barcosActivos.clear();
        this.cargasActivas.clear();
        this.enPartida = true;
        
    }

    public void actualizarJuego(int anchoPantalla)
    {
        if (!enPartida) {
            return;
        }
        if (pausado) {
            System.out.println("El juego esta pausado.");
            return;
        }
        verificarGeneracionBarco(anchoPantalla);
        
        // SECCION BARCO: reviso barcos que hayan entrado a la pantalla
        Iterator<Barco> itBarcos = barcosActivos.iterator();
        while (itBarcos.hasNext()) {
            Barco barcoActual = itBarcos.next();
            
            // Avanza el barco
            barcoActual.avanzar();
        
            // Si el barco ya se fue de pantalla, lo eliminamos usando el ITERADOR
            if (!barcoActual.verificarLimites(anchoPantalla)) {
                itBarcos.remove(); 
                System.out.println("EL BARCO SE PASO YA SE FUE");
            } else {
                // Solo revisamos si lanza carga si el barco sigue existiendo
                if(barcoActual.verificarLanzamientoCarga(anchoPantalla)) {
                    Carga soltada = barcoActual.soltarCarga();
                    agregarCarga(soltada); 
                    System.out.println("EL BARCO SOLTO LA CARGA");
                }
            }
        }
        
        // SECCION CARGAS: reviso cargas que esten cayendo
        Iterator<Carga> itCargas = cargasActivas.iterator();
        while (itCargas.hasNext()) {
           Carga cargaActual = itCargas.next();

    if (!cargaActual.isExplotando()) {

        cargaActual.caer();

        if (cargaActual.verificarDetonacion()) {
            procesarExplosion(cargaActual);
            System.out.println("LA CARGA YA EXPLOTO");
        }

    } else {

        System.out.println("LA CARGA SIGUE EXPLOTANDO");

        cargaActual.incrementarTiempoExplosion();

        if (cargaActual.getTiempoExplosion() >= 4) {
            System.out.println("SE ELIMINO LA CARGA EXPLOTADA");
            itCargas.remove();
        }
    }
          
        }       
        
        // Check si quedan barcos etc para ver si subir y reiniciar
        verificarFinNivel(); 
    }
    
    
    public void verificarGeneracionBarco(int anchoPantalla)
    {
    	if (barcosActivos.size() < 3 && barcosPendientes > 0 && hayEspacioLibre(anchoPantalla)) {
            Barco nuevoBarco = new Barco(velocidadMovimiento, anchoPantalla);
            agregarBarco(nuevoBarco);
        }
    };
    
    public boolean hayEspacioLibre(int anchoPantalla) {        
        if (barcosActivos.isEmpty()) {
            return true; //si no se envio nada que mande
        }
        
        // Tomamos el último barco que se generó para sacar distancia de donde esta
        Barco ultimoBarco = barcosActivos.get(barcosActivos.size() - 1);
        
        float margenSeguridad = (float)200.0; //margen de seguridad a los costados
        
        //chequeamos que ese barco haya salido de esa zona de pegote

        if (ultimoBarco.getPosX() < margenSeguridad || 
            ultimoBarco.getPosX() > (anchoPantalla - margenSeguridad)) {
            return false; //esta muyy cerca, se van a pegar los barcos visualmente
        }
        
        return true; // Ya avanzó lo suficiente, el espacio está libre para el siguiente
    }
    
    public void agregarBarco(Barco barco)
    {
    	this.barcosActivos.add(barco);
        this.barcosPendientes--;
    };
    
    public void agregarCarga(Carga carga)
    {
    	this.cargasActivas.add(carga);
    };

    public void procesarExplosion(Carga carga)
    {
    	// Calculamos la distancia usando el teorema de Pitágoras
        float diferenciaX = carga.getPosX() - submarino.getPosX(); 
        float diferenciaY = carga.getPosY() - submarino.getPosY(); 
        double distancia = Math.sqrt((diferenciaX * diferenciaX) + (diferenciaY * diferenciaY)); //calculamos la diagonal de explosion con pitagoras
        System.out.println("EL DAÑO FUE DE "+distancia);
        // TIPO DE SAÑO SEGUN DISTANCIA
        if (distancia > 100) {
            submarino.sumarPuntos(30); // Explota a más de 100 metros de distancia: El jugador obtiene 30 puntos y 0% daño.
        } else if (distancia >= 50 && distancia <= 100) {
            submarino.sumarPuntos(10);
            submarino.recibirDanio(30); // Explota entre 50 y 100 metros de distancia: El jugador obtiene 10 puntos y recibe un daño de 30% de una de sus vidas.
        } else if (distancia >= 10 && distancia < 50) {
            submarino.recibirDanio(50); // Explota entre 10 y 50 metros de distancia: El jugador no obtiene puntos y recibe un daño de 50% de una de sus vidas.
        } else {
            submarino.perderVida(); // Explota a menos de 10 metros de distancia: El jugador no obtiene puntos y pierde 1 vida.
        }
    };
    public void verificarFinNivel()
    {
    	if (barcosPendientes == 0 && barcosActivos.isEmpty() && cargasActivas.isEmpty()) {
            incrementarNivel();
            System.out.println("nivel "+nivelActual);
            System.out.println("velocidad "+velocidadMovimiento);

        }
    };
    public void incrementarNivel()
    {
    	this.nivelActual++;
        this.submarino.sumarPuntos(200); // 200 puntos POR NVIEL
        
        // Aumentamos dific.
        this.velocidadMovimiento *= (float)1.20; // 20% extra
        
        // Reseteamos los barcos para la nueva ola
        this.barcosPendientes = 12;
        System.out.println("¡Subiste de Nivel a " + nivelActual + "!");
    };
    
    public boolean isEnPartida() 
    {
        return this.enPartida;
    }
    // utilizo este getSubmarino para poder acceder al submarino desde el controlador y mostrar su estado en pantalla
    public Submarino getSubmarino()
    {
    return submarino;
    }
    public void pausarJuego()
    {
    pausado = true;
    System.out.println("Juego pausado.");
    }
    public void reanudarJuego()
    {
        pausado = false;
        System.out.println("Juego reanudado.");
    }
    //
    public List<Barco> getBarcosActivos()
    {
    return barcosActivos;
    }
    public List<Carga> getCargasActivas()
    {
    return cargasActivas;
    }
    public boolean isPausado()
    {
    return pausado;
    }
    public int getNivelActual()
    {
        return nivelActual;
    }



}
