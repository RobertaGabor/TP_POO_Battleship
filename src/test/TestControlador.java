package test;
import controlador.Controlador;

public class TestControlador {
    public static void main(String[] args) {
        System.out.println("Iniciando prueba del Controlador...");
        Controlador controlador = new Controlador();
        System.out.println("Ancho de pantalla: " + controlador.obtenerAnchoPantalla());
        System.out.println("Iniciando partida...");
        controlador.iniciarPartida();
        System.out.println("Actualizando juego...");
        controlador.actualizarJuego();
        System.out.println("Pausando juego...");
        controlador.pausarJuego();
        System.out.println("Reanudando juego...");
        controlador.reanudarJuego();
        System.out.println("Prueba del Controlador finalizada.");
    }
    
}
