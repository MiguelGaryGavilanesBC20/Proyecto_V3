import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PantallaControl {
    public static void main(String[] args) {
        // Crear la ventana principal
        JFrame ventana = new JFrame("Control de Ventana");
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ventana.setSize(400, 300); // Tamaño inicial
        ventana.setLayout(new BorderLayout());

        // Panel para mostrar la información de posición y tamaño
        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new GridLayout(4, 2, 10, 10));

        JLabel labelX = new JLabel("Posición X:");
        JTextField fieldX = new JTextField("0");
        JLabel labelY = new JLabel("Posición Y:");
        JTextField fieldY = new JTextField("0");
        JLabel labelAncho = new JLabel("Ancho:");
        JTextField fieldAncho = new JTextField("400");
        JLabel labelAlto = new JLabel("Alto:");
        JTextField fieldAlto = new JTextField("300");

        infoPanel.add(labelX);
        infoPanel.add(fieldX);
        infoPanel.add(labelY);
        infoPanel.add(fieldY);
        infoPanel.add(labelAncho);
        infoPanel.add(fieldAncho);
        infoPanel.add(labelAlto);
        infoPanel.add(fieldAlto);

        // Botón para actualizar la posición y tamaño
        JButton botonActualizar = new JButton("Actualizar");
        botonActualizar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Obtener valores de los campos
                    int x = Integer.parseInt(fieldX.getText());
                    int y = Integer.parseInt(fieldY.getText());
                    int ancho = Integer.parseInt(fieldAncho.getText());
                    int alto = Integer.parseInt(fieldAlto.getText());

                    // Actualizar posición y tamaño de la ventana
                    ventana.setBounds(x, y, ancho, alto);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(ventana, "Por favor ingrese valores válidos.", 
                                                  "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        // Agregar un listener para actualizar los campos al mover o redimensionar la ventana
        ventana.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentMoved(java.awt.event.ComponentEvent evt) {
                Point posicion = ventana.getLocation();
                fieldX.setText(String.valueOf(posicion.x));
                fieldY.setText(String.valueOf(posicion.y));
            }

            public void componentResized(java.awt.event.ComponentEvent evt) {
                Dimension dimension = ventana.getSize();
                fieldAncho.setText(String.valueOf(dimension.width));
                fieldAlto.setText(String.valueOf(dimension.height));
            }
        });

        // Agregar los paneles a la ventana
        ventana.add(infoPanel, BorderLayout.CENTER);
        ventana.add(botonActualizar, BorderLayout.SOUTH);

        // Mostrar la ventana
        ventana.setVisible(true);
    }
}
