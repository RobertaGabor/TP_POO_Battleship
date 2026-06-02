package gui;
import controlador.Controlador;

import views.EstadoJuego;
import views.MovibleView;

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

                        break;
                    case KeyEvent.VK_RIGHT:
                    case KeyEvent.VK_D:
                    

                        controlador.moverDerecha();

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
        
        ImageIcon submarinoImagen =
        new ImageIcon("src/img/submarino.png");

        barcoImagen = new ImageIcon("src/img/barco.png");
    barcoImagen = new ImageIcon(
        barcoImagen.getImage().getScaledInstance(
            120,
            60,
            java.awt.Image.SCALE_SMOOTH
        )
    );

    cargaImagen = new ImageIcon("src/img/carga.png");
    cargaImagen = new ImageIcon(
        cargaImagen.getImage().getScaledInstance(
            60,
            60,
            java.awt.Image.SCALE_SMOOTH
        )
    );

    explosionImagen = new ImageIcon("src/img/explosion.png");
    explosionImagen = new ImageIcon(
        explosionImagen.getImage().getScaledInstance(100,100,java.awt.Image.SCALE_SMOOTH
        )
    );


        submarinoImagen =new ImageIcon(submarinoImagen.getImage().getScaledInstance(120,60,java.awt.Image.SCALE_SMOOTH));
        submarino = new JLabel(submarinoImagen);

        submarino.setBounds(100, 300, 120, 60);

        add(submarino);
        

       
          getContentPane().setComponentZOrder(fondoLabel,
            getContentPane().getComponentCount() - 1);




         barraVida = new JProgressBar(0, 100);
         // Configura la barra de vida para que muestre el porcentaje de vida restante del submarino
         barraVida.setBounds(20, 20, 200, 25);
         // Establece el valor inicial de la barra de vida al 100% (vida completa)
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
       MovibleView subView = controlador.getSubmarinoViews();
        submarino.setLocation((int)subView.getX(), (int)subView.getY());

        actualizarBarcos();
        actualizarCargas();
        actualizarHUD();
        verificarCambioNivel();
        verificarGameOver();
        repaint();
    }
    private void verificarGameOver() {
         EstadoJuego estado = controlador.getEstadoJuegoView();
        
        if(estado.isEstaMuerto()) {
            timer.stop();
            JOptionPane.showMessageDialog(this, "GAME OVER");
        }
    }

    private void verificarCambioNivel() {
          EstadoJuego estado = controlador.getEstadoJuegoView();
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
        for(MovibleView barcoView : controlador.getBarcosView()){

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

    for(MovibleView cargaView : controlador.getCargasView())
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
       EstadoJuego estado = controlador.getEstadoJuegoView();

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
