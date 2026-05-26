package gui;
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import controlador.Controlador;

public class Ventana extends JFrame{
    private Controlador controlador;
    private JLabel label;
    private JLabel submarino, barco;

    public Ventana()
    {
        configurar();

        inicializar();

        eventos();

        setVisible(true);
    }

    private void eventos() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eventos'");
    }

    private void inicializar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'inicializar'");
    }

    private void configurar() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'configurar'");
    }


    
    
}
