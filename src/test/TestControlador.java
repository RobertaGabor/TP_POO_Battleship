package test;
import controlador.Controlador;
import views.BarcoView;
import views.CargaView;
import views.EstadoJuegoView;
import views.SubmarinoView;

public class TestControlador {
    public static void main(String[] args) {
    
        Controlador.getInstance().iniciarPartida();

        
        System.out.println("    Juego en consola       ");
        

        for (int turno = 1; turno <= 12; turno++) {

            System.out.println("\n========== TURNO " + turno + " ==========");

            moverSubmarinoAutomaticamente(turno);

            Controlador.getInstance().actualizarJuego();

            mostrarSubmarino();
            mostrarBarcos();
            mostrarCargas();
            mostrarEstado();

            EstadoJuegoView estado = Controlador.getInstance().getEstadoJuegoView();

            if (estado.isEstaMuerto()) {
                System.out.println("\nGAME OVER");
                break;
            }

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {

            }
        }

        System.out.println("\nFIN DE LA SIMULACION");
    }

    private static void moverSubmarinoAutomaticamente(int turno) {

        if (turno % 4 == 0) {
            Controlador.getInstance().moverDerecha();
            System.out.println("Accion: el submarino se mueve a la derecha");
        } else if (turno % 6 == 0) {
            Controlador.getInstance().moverIzquierda();
            System.out.println("Accion: el submarino se mueve a la izquierda");
        } else if (turno % 5 == 0) {
            Controlador.getInstance().moverArriba();
            System.out.println("Accion: el submarino sube");
        } else if (turno % 7 == 0) {
            Controlador.getInstance().moverAbajo();
            System.out.println("Accion: el submarino baja");
        } else {
            System.out.println("Accion: el submarino queda quieto");
        }
    }

    private static void mostrarSubmarino() {
        SubmarinoView sub = Controlador.getInstance().getSubmarinoView();

        System.out.println("\nSubmarino");
        System.out.println("X: " + sub.getX());
        System.out.println("Y: " + sub.getY());
    }

    private static void mostrarBarcos() {
        System.out.println("\nBarcos activos: " + Controlador.getInstance().getBarcosView().size());

        int numero = 1;

        for (BarcoView barco : Controlador.getInstance().getBarcosView()) {
            System.out.println(
                "Barco " + numero +
                " | X: " + barco.getX() +
                " | Y: " + barco.getY() +
                " | Tamaño: " + barco.getAncho() + "x" + barco.getAlto()
            );
            numero++;
        }
    }

    private static void mostrarCargas() {
        System.out.println("\nCargas activas: " + Controlador.getInstance().getCargasView().size());

        int numero = 1;

        for (CargaView carga : Controlador.getInstance().getCargasView()) 
            {

                String estadoCarga;

                if (carga.isExplotando()) 
                    {
                        estadoCarga = "EXPLOTANDO";
                    } 
                else 
                    {
                        estadoCarga = "CAYENDO";
                    }

                System.out.println("Carga " + numero +" | X: " + carga.getX() +" | Y: " + carga.getY() +" | Estado: " + estadoCarga);
                numero++;
            }
    }

    private static void mostrarEstado() {
        EstadoJuegoView estado = Controlador.getInstance().getEstadoJuegoView();

        System.out.println("\nEstado del juego");
        System.out.println("Vida: " + estado.getVida());
        System.out.println("Vidas restantes: " + estado.getVidasRestantes());
        System.out.println("Puntos: " + estado.getPuntaje());
        System.out.println("Nivel: " + estado.getNivelActual());
        System.out.println("Muerto: " + estado.isEstaMuerto());
    }
    
}
