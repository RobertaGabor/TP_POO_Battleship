package gui;
import barco.Barco;
import carga.Carga;
import controlador.Controlador;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.List;
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


       submarino = new JLabel("");
       submarino.setBounds(100, 300, 50, 30);
       // Configura el fondo del submarino para que sea visible
       submarino.setOpaque(true);
       // Establece un color de fondo para el submarino 
         submarino.setBackground(new Color(50, 160, 140));
         add(submarino);
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
         labelVidas.setForeground(Color.WHITE);
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
        // Obtiene la posición actual del submarino desde el controlador
        int x = (int) controlador
                .getJuego()
                .getSubmarino()
                .getPosX();

        int y = (int) controlador
                .getJuego()
                .getSubmarino()
                .getPosY();
        // Actualiza la posición del submarino en la interfaz gráfica
        submarino.setLocation(x, y);
        // Aquí también podrías actualizar la posición de los barcos, las cargas, y otros elementos del juego
        // según su estado actual en el juego.
        actualizarBarcos();
        actualizarCargas();
        actualizarHUD();
        verificarCambioNivel();
        verificarGameOver();
        repaint();
    }
    private void verificarGameOver() {
         if(controlador
            .getJuego()
            .getSubmarino()
            .estaMuerto())
    {
        timer.stop();

        JOptionPane.showMessageDialog(
                this,
                "GAME OVER"
        );
    }
    }

    private void verificarCambioNivel() {
        int nivelActual = controlador
            .getJuego()
            .getNivelActual();

    if(nivelActual > nivelAnterior)
    {
        nivelAnterior = nivelActual;

        JOptionPane.showMessageDialog(
                this,
                "¡Subiste al nivel " + nivelActual + "!"
        );
    }
    }

    private void actualizarBarcos()
    {
        eliminarBarcos();
        labelsBarcos.clear();
        for(Barco barco : controlador.getJuego().getBarcosActivos()){
            JLabel label = new JLabel("Barco");
            label.setBounds((int)barco.getPosX(), (int)barco.getPosY(), 50, 30);
            label.setOpaque(true);
            label.setBackground(new Color(100, 100, 100));
            add(label);
            labelsBarcos.add(label);
        }
    }
    private void eliminarBarcos() {
        for (JLabel label : labelsBarcos) {
            remove(label);
        }
    }

    private void actualizarCargas()
    {
        eliminarCargas();
        // Limpia la lista de etiquetas de cargas antes de agregar las nuevas etiquetas
        labelsCargas.clear();
        
        for(Carga carga : controlador.getJuego().getCargasActivas()){
           
            JLabel label = new JLabel("");
            label.setBounds((int)carga.getPosX(), (int)carga.getPosY(), 20, 20);
            label.setOpaque(true);
            label.setBackground(new Color(255, 0, 0));
            add(label);
            labelsCargas.add(label);
        }
    }

    private void eliminarCargas() {
        for (JLabel label : labelsCargas) {
            remove(label);
        }
    }
     private void actualizarHUD()
    {
        barraVida.setValue(
                (int) controlador
                .getJuego()
                .getSubmarino()
                .getVida()
        );

        labelPuntos.setText(
                "Puntos: " +
                controlador
                .getJuego()
                .getSubmarino()
                .getPuntaje()
        );

        labelVidas.setText(
                "Vidas: " +
                controlador
                .getJuego()
                .getSubmarino()
                .getVidas()
        );

        labelNivel.setText(
                "Nivel: " +
                controlador
                .getJuego()
                .getNivelActual()
        );
    }



    
    
}
