package views;

public class BarcoView {
    private int x;
    private int y;
    private int ancho;
    private int alto;
    private boolean explotando;
    
    public BarcoView(int x, int y, int ancho, int alto, boolean explotando) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.explotando = explotando;
    }
   



    public int getX() { return x; }
    public int getY() { return y; }
    public int getAncho() { return ancho; }
    public int getAlto() { return alto; }
    public boolean isExplotando() { return explotando; }
    
    
}
