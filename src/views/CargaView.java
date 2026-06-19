package views;

public class CargaView {
    private int x;
    private int y;
    private int ancho;
    private int alto;
    private boolean explotando;
    
    public CargaView() {

    }
    
    public CargaView(int x, int y, int ancho, int alto, boolean explotando) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.explotando = explotando;
    }
    
    public CargaView( int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
    }
   
    public int getX() { return x; }
    public int getY() { return y; }
    public int getAncho() { return ancho; }
    public int getAlto() { return alto; }
    public boolean isExplotando() { return explotando; }
    

    
}
