package test;
import controlador.Controlador;
import views.EstadoJuegoView;
import views.SubmarinoView;

public class TestControlador {
    public static void main(String[] args) {
        System.out.println("Iniciando prueba del Controlador: ");
        Controlador controlador = Controlador.getInstance();
        controlador.iniciarPartida();
         SubmarinoView subInicial = Controlador.getInstance().getSubmarinoView();

        System.out.println("Posición inicial submarino:");
        System.out.println("X: " + subInicial.getX());
        System.out.println("Y: " + subInicial.getY());

        controlador.moverDerecha();

        SubmarinoView subDerecha = controlador.getSubmarinoView();
        System.out.println("Después de mover derecha:");
        System.out.println("X: " + subDerecha.getX());
        System.out.println("Y: " + subDerecha.getY());

        if(subDerecha.getX() > subInicial.getX()) {
            System.out.println("El submarino se movió a la derecha");
        } else {
            System.out.println("El submarino no se movió a la derecha");
        }

        controlador.moverIzquierda();

        SubmarinoView subIzquierda = controlador.getSubmarinoView();

        System.out.println("Después de mover izquierda:");
        System.out.println("X: " + subIzquierda.getX());
        System.out.println("Y: " + subIzquierda.getY());

        controlador.actualizarJuego();

        System.out.println("Cantidad de barcos: " + controlador.getBarcosView().size());
        System.out.println("Cantidad de cargas: " + controlador.getCargasView().size());

        EstadoJuegoView estado = controlador.getEstadoJuegoView();

        System.out.println("Vida: " + estado.getVida());
        System.out.println("Puntos: " + estado.getPuntaje());
        System.out.println("Vidas: " + estado.getVidasRestantes());
        System.out.println("Nivel: " + estado.getNivelActual());
        System.out.println("¿Está muerto?: " + estado.isEstaMuerto());

        System.out.println("FIN TEST CONTROLADOR");
    }
    
}
