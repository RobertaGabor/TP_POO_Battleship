package views;

public class EstadoJuegoView {
    private float vida;
    private float puntaje;
    private int vidasRestantes;
    private int nivelActual;
    private boolean estaMuerto;
    
    public EstadoJuegoView(float vida, float puntaje, int vidasRestantes, int nivelActual, boolean estaMuerto) {
        this.vida = vida;
        this.puntaje = puntaje;
        this.vidasRestantes = vidasRestantes;
        this.nivelActual = nivelActual;
        this.estaMuerto = estaMuerto;
    }
    public float getVida() {
        return vida;
    }
    public float getPuntaje() {
        return puntaje;
    }
    public int getVidasRestantes() {
        return vidasRestantes;
    }
    public int getNivelActual() {
        return nivelActual;
    }
    public boolean isEstaMuerto() {
        return estaMuerto;
    }
    
}
