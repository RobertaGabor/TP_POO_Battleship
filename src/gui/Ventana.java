package gui;
import controlador.Controlador;

import views.EstadoJuegoView;
import views.SubmarinoView;
import views.BarcoView;
import views.CargaView;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import javax.swing.Timer;
import java.awt.Image;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;


public class Ventana extends JFrame{
    private Controlador controlador;
    private JLabel label;
    private JLabel submarino;
    private Timer timer;
    private List<JLabel> labelsBarcos;
    private List<JLabel> labelsCargas;
    private JProgressBar barraVida;
    private JLabel labelPuntos;
    private JLabel labelVidas;
    private JLabel labelNivel;
    private int nivelAnterior;
    private JLabel fondoLabel;
    private List<JLabel> labelsExplosiones;
    private ImageIcon barcoImagen;
    private ImageIcon cargaImagen;
    private ImageIcon explosionImagen;
    private ImageIcon submarinoImagen;
    private ImageIcon fondoImagen;
    private List<String> explosionesMostradas;
    private ImageIcon submarinoIzquierdo;
    private ImageIcon submarinoDerecha;
    private boolean mirandoDerecha = false;

    public Ventana()
    {
        controlador = Controlador.getInstance();
        configurar();

        inicializar();

        eventos();

        setVisible(true);
        requestFocus();
        controlador.iniciarPartida();
    }

    private void eventos() {
        //SetDefaultCloseOperation lo utilizo para especificar la acción que se debe realizar 
        // cuando el usuario cierra la ventana. 
        // En este caso, EXIT_ON_CLOSE indica que la aplicación debe finalizar completamente cuando 
        // se cierre la ventana.
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Agrego un KeyListener para detectar las teclas presionadas por el usuario
        addKeyListener(new KeyListener()
        {

            @Override
            // El método keyTyped se llama cuando el usuario presiona una tecla que genera un carácter 
            public void keyTyped(KeyEvent e)
            {

            }

            @Override
            // El método keyPressed se llama cuando el usuario presiona una tecla, 
            // independientemente de si genera un carácter o no.
            public void keyPressed(KeyEvent e)
            {
                // Aquí se detectan las teclas presionadas y se llama a los métodos 
                // correspondientes del controlador
                switch(e.getKeyCode())
                {
                    // Se utilizan para mover el submarino en las cuatro direcciones
                    case KeyEvent.VK_A:
                    case KeyEvent.VK_LEFT:

                        controlador.moverIzquierda();
                        if (mirandoDerecha) 
                            {
                                submarino.setIcon(submarinoIzquierdo);
                                mirandoDerecha = false;
                            }
                        

                        break;
                    case KeyEvent.VK_RIGHT:
                    case KeyEvent.VK_D:
                    

                        controlador.moverDerecha();
                        if (!mirandoDerecha) 
                            {
                                //setIcon es un método de JLabel que se utiliza para establecer la imagen que se 
                                // mostrará en el JLabel.
                                submarino.setIcon(submarinoDerecha);
                                mirandoDerecha = true;
                            }


                        break;

                    case KeyEvent.VK_W:
                    case KeyEvent.VK_UP:

                        controlador.moverArriba();

                        break;

                    case KeyEvent.VK_S:
                    case KeyEvent.VK_DOWN:

                        controlador.moverAbajo();

                        break;

                    case KeyEvent.VK_P:

                        controlador.pausarJuego();

                        break;
                    case KeyEvent.VK_R:

                        controlador.reanudarJuego();

                        break;
                }
            }

            @Override
            // El método keyReleased se llama cuando el usuario suelta una tecla,
            // pero en este caso no se necesita realizar ninguna acción específica al soltar las teclas,
            //  por lo que se deja vacío.
            public void keyReleased(KeyEvent e)
            {

            }
        });
    }

    private void inicializar() {
        nivelAnterior = 1;
        labelsBarcos = new ArrayList<>();
        labelsCargas = new ArrayList<>();
        labelsExplosiones = new ArrayList<>();
        explosionesMostradas = new ArrayList<>();

        fondoImagen =
        new ImageIcon("src/img/fondo_del_juego.png");

        fondoImagen =new ImageIcon(fondoImagen.getImage().getScaledInstance(1024,768,java.awt.Image.SCALE_SMOOTH));

        fondoLabel = new JLabel(fondoImagen);

        fondoLabel.setBounds(0, 0, 1024, 768);

        add(fondoLabel);
        
        submarinoIzquierdo =new ImageIcon("src/img/submarino.png");
        //la diferencia entre ImagenIcon y Icon es que ImageIcon es una clase que implementa la interfaz Icon, 
        // lo que significa que puedes usar un ImageIcon en cualquier lugar donde se espere un Icon.
        // ImageIcon es una clase concreta que proporciona una implementación específica de la interfaz Icon, mientras
        barcoImagen = new ImageIcon("src/img/barco.png");
        barcoImagen = new ImageIcon(
        barcoImagen.getImage().getScaledInstance(120,60,java.awt.Image.SCALE_SMOOTH));

        cargaImagen = new ImageIcon("src/img/carga.png");
        cargaImagen = new ImageIcon(cargaImagen.getImage().getScaledInstance(60,60,java.awt.Image.SCALE_SMOOTH));

        explosionImagen = new ImageIcon("src/img/explosion.png");
        explosionImagen = new ImageIcon(explosionImagen.getImage().getScaledInstance(100,100,java.awt.Image.SCALE_SMOOTH));


        submarinoIzquierdo =new ImageIcon(submarinoIzquierdo.getImage().getScaledInstance(120,60,java.awt.Image.SCALE_SMOOTH));
        
        submarinoDerecha=invertirImagen(submarinoIzquierdo);
        //submarinoDerecha = new ImageIcon(submarinoIzquierdo.getImage().getScaledInstance(120, 60, java.awt.Image.SCALE_SMOOTH));
        submarino = new JLabel(submarinoIzquierdo);

        submarino.setBounds(100, 300, 120, 60);

        add(submarino);
        

       // El método getContentPane().setComponentZOrder se utiliza para establecer el
       //  orden de apilamiento de los componentes en el contenedor de la ventana.
       //el fondoLabel se coloca en la posición más baja (más atrás) para que los demás componentes se muestren por encima de él.
        getContentPane().setComponentZOrder(fondoLabel,getContentPane().getComponentCount() - 1);

         barraVida = new JProgressBar(0, 100);
         // Configura la barra de vida para que muestre el porcentaje de vida restante del submarino
         barraVida.setBounds(20, 20, 200, 25);
         // Establece el valor inicial de la barra de vida al 100% (vida completa)
         barraVida.setForeground(new Color(163,41,3));
         barraVida.setValue(100);
        
         add(barraVida);

         labelPuntos = new JLabel("Puntos: 0");
         labelPuntos.setBounds(20, 60, 200, 30);
         labelPuntos.setForeground(Color.WHITE);
         add(labelPuntos);

         labelVidas = new JLabel("Vidas: 5");
         labelVidas.setBounds(20, 90, 200, 30);
         labelVidas.setForeground(new Color(230, 110, 50));
         add(labelVidas);

         labelNivel = new JLabel("Nivel: 1");
         labelNivel.setBounds(20, 120, 200, 30);
         labelNivel.setForeground(Color.WHITE);
         add(labelNivel);

         timer= new Timer(150, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                controlador.actualizarJuego();
                actualizarPantalla();
            }
            
        });
        timer.start();
    }

    private ImageIcon invertirImagen(ImageIcon icono) {
        // el icono.getImage hace referencia a la imagen real que se muestra en el JLabel.
        Image img = icono.getImage();
        // el bufferedImage es una clase que representa una imagen en memoria, y se utiliza para manipular la imagen de manera más eficiente.
        //esto haciendo que la imagen tenga el mismo tamaño que el icono original y un tipo de imagen compatible con la transparencia (ARGB).

        BufferedImage imagenInvertida = new BufferedImage(icono.getIconWidth(),icono.getIconHeight(),BufferedImage.TYPE_INT_ARGB);
        // aca hace que el Graphics2D se utilice para dibujar la imagen original en el nuevo BufferedImage, pero con las coordenadas invertidas para lograr el efecto de espejo horizontal.
        Graphics2D g = imagenInvertida.createGraphics();
        g.drawImage(img,icono.getIconWidth(), 0,0, icono.getIconHeight(),0, 0,icono.getIconWidth(), icono.getIconHeight(),null);
        //el dispone se utiliza para liberar los recursos del Graphics2D después de haber terminado de dibujar la imagen invertida.
        g.dispose();

        return new ImageIcon(imagenInvertida);
    }

    private void configurar() {
        setTitle("Juego Submarino");
        // Establece el tamaño de la ventana
        setSize(1024, 768);
        // Configuración de la ventana
        setLayout(null);
        // Configura el cierre de la ventana para salir de la aplicación
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // Establece el fondo de la ventana a un color azul claro
        getContentPane().setBackground(new Color(5, 40, 45));
        // Centra la ventana en la pantalla
        setLocationRelativeTo(null);
        // Evita que la ventana sea redimensionable
        setResizable(false);
    }
    // Este método se encarga de actualizar la posición del submarino en la pantalla 
    // según su estado actual en el juego.
    private void actualizarPantalla()
    {
       SubmarinoView subView = controlador.getSubmarinoView();
        submarino.setLocation((int)subView.getX(), (int)subView.getY());

        actualizarBarcos();
        actualizarCargas();
        actualizarHUD();
        verificarCambioNivel();
        verificarGameOver();
        repaint();
    }
    private void verificarGameOver() {
         EstadoJuegoView estado = controlador.getEstadoJuegoView();
        
        if(estado.isEstaMuerto()) {
            timer.stop();
            JOptionPane.showMessageDialog(this, "GAME OVER");
        }
    }

    private void verificarCambioNivel() {
          EstadoJuegoView estado = controlador.getEstadoJuegoView();
        int nivelActual = estado.getNivelActual();

        if(nivelActual > nivelAnterior) {
            nivelAnterior = nivelActual;
            JOptionPane.showMessageDialog(this, "¡Subiste al nivel " + nivelActual + "!");
        }
    }

    private void actualizarBarcos()
    {
        eliminarBarcos();
        labelsBarcos.clear();
        
        // Recorremos las Vistas, no los objetos de negocio
        for(BarcoView barcoView : controlador.getBarcosView()){

            JLabel label = new JLabel(barcoImagen);

            label.setBounds((int)barcoView.getX(), (int)barcoView.getY(), (int)barcoView.getAncho(), (int)barcoView.getAlto());
            add(label);
            labelsBarcos.add(label);
        }
        getContentPane().setComponentZOrder(fondoLabel, getContentPane().getComponentCount() - 1);
   
    }
    private void eliminarBarcos() {
        for (JLabel label : labelsBarcos) {
            remove(label);
        }
    }

    private void actualizarCargas()
    {
        eliminarCargas();
    labelsCargas.clear();

    for(CargaView cargaView : controlador.getCargasView())
    {
        if(!cargaView.isExplotando())
        {
        JLabel label = new JLabel(cargaImagen);

        label.setBounds((int)cargaView.getX(),(int)cargaView.getY(),(int)cargaView.getAncho(),(int)cargaView.getAlto());

        add(label);
        labelsCargas.add(label);
    }
        else
        {
           mostrarExplosion((int)cargaView.getX(),(int)cargaView.getY());
        }
        
    }

    getContentPane().setComponentZOrder(fondoLabel,getContentPane().getComponentCount() - 1);
    }
    

    private void eliminarCargas() {
        for (JLabel label : labelsCargas) {
            remove(label);
        }
    }
     private void actualizarHUD()
    {
       EstadoJuegoView estado = controlador.getEstadoJuegoView();

        barraVida.setValue((int) estado.getVida());
        labelPuntos.setText("Puntos: " + estado.getPuntaje());
        labelVidas.setText("Vidas: " + estado.getVidasRestantes());
        labelNivel.setText("Nivel: " + estado.getNivelActual());
    }

    private void mostrarExplosion(int x, int y)
{
    JLabel explosion = new JLabel(explosionImagen);

    explosion.setBounds(x, y, 100, 100);

    add(explosion);

    labelsExplosiones.add(explosion);

    getContentPane().setComponentZOrder(fondoLabel,getContentPane().getComponentCount() - 1);

    getContentPane().setComponentZOrder(explosion, 0);

    revalidate();
    repaint();

    Timer explosionTimer = new Timer(200, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            remove(explosion);
            labelsExplosiones.remove(explosion);
            revalidate();
            repaint();
        }
    });

    explosionTimer.setRepeats(false);
    explosionTimer.start();
}



}
