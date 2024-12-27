package p1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MiSegundoFormulario extends JFrame implements ActionListener {

    private JButton botonAceptar, botonRegresar;
    private JLabel labelNombre, labelDescripcion;
    private MiPrimerFormulario Regreso;
    private JTextArea areaDescripcion;

    public MiSegundoFormulario(MiPrimerFormulario Regreso) {
        this.Regreso=Regreso;
        setLayout(null);
        setTitle("Pantalla siguiente");
        getContentPane().setBackground(new Color(60, 63, 65));

       
        
        labelNombre = new JLabel("José Hernández", SwingConstants.CENTER);
        labelNombre.setBounds(50, 30, 350, 50);
        labelNombre.setForeground(Color.WHITE);
        labelNombre.setFont(new Font("Arial", Font.BOLD, 20));
        add(labelNombre);

        
        labelDescripcion = new JLabel("Descripción:");
        labelDescripcion.setBounds(50, 100, 100, 30);
        labelDescripcion.setForeground(Color.WHITE);
        labelDescripcion.setFont(new Font("Arial", Font.BOLD, 14));
        add(labelDescripcion);

        
        areaDescripcion = new JTextArea();
        areaDescripcion.setBounds(150, 100, 250, 60);
        areaDescripcion.setBackground(new Color(40, 40, 40));
        areaDescripcion.setForeground(Color.WHITE);
        areaDescripcion.setBorder(BorderFactory.createLineBorder(Color.GRAY));
        areaDescripcion.setFont(new Font("Arial", Font.PLAIN, 14));
        areaDescripcion.setLineWrap(true);
        areaDescripcion.setWrapStyleWord(true);
        add(areaDescripcion);

        
        botonAceptar = new JButton("Aceptar");
        botonAceptar.setBounds(100, 200, 100, 30);
        botonAceptar.setBackground(new Color(70, 130, 180));
        botonAceptar.setForeground(Color.WHITE);
        botonAceptar.setFocusPainted(false);
        botonAceptar.setFont(new Font("Arial", Font.BOLD, 12));
        botonAceptar.addActionListener(this);
        add(botonAceptar);

        
        botonRegresar = new JButton("Regresar");
        botonRegresar.setBounds(250, 200, 100, 30);
        botonRegresar.setBackground(new Color(220, 20, 60));
        botonRegresar.setForeground(Color.WHITE);
        botonRegresar.setFocusPainted(false);
        botonRegresar.setFont(new Font("Arial", Font.BOLD, 12));
        botonRegresar.addActionListener(this);
        add(botonRegresar);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        

        if (e.getSource() == botonRegresar) {
            this.dispose(); 
            Regreso.setVisible(true);
        }
    }
}