package Menu_P;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Panel_Equipo extends JPanel implements ActionListener {

    private JButton boton1, boton2;
    private JLabel label1, label2;
    private JTextField texto1;
    private DefaultTableModel modeloTabla;
    private JTable tabla;
    private JScrollPane scrollPane;
    private JComboBox<String> comboDirigente;

    public Panel_Equipo(DefaultTableModel modeloTabla) {
        setLayout(null);

        label1 = new JLabel("Nombre");
        label1.setBounds(50, 20, 50, 20);
        add(label1);

        texto1 = new JTextField();
        texto1.setBounds(110, 20, 110, 20);
        add(texto1);

        label2 = new JLabel("Dirigente");
        label2.setBounds(50, 50, 50, 20);
        add(label2);

        comboDirigente = new JComboBox<>();
        comboDirigente.setBounds(110, 80, 110, 20);
        add(comboDirigente);
        actualizarComboDirigente();  // Cargar dirigentes del archivo

        boton1 = new JButton("Registrar");
        boton1.setBounds(300, 20, 100, 30);
        add(boton1);
        boton1.addActionListener(this);

        boton2 = new JButton("Actualizar");
        boton2.setBounds(300, 50, 100, 30);
        add(boton2);
        boton2.addActionListener(this);

        this.modeloTabla = modeloTabla;
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Dirigente");

        tabla = new JTable(modeloTabla);
        scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(40, 130, 420, 200);
        add(scrollPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton2) {
            actualizarComboDirigente();  // Actualizar la lista de dirigentes
        } else if (e.getSource() == boton1) {
            String nombre = primeraletra(texto1.getText());
            String dirigente = obtenerSeleccionComboBox();

            if (nombre.isEmpty() || dirigente.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error al agregar los datos", JOptionPane.ERROR_MESSAGE);
            } else {
                modeloTabla.addRow(new Object[]{nombre, dirigente});
                texto1.setText("");
            }
        }
    }

    private String primeraletra(String palabra) {
        if (palabra == null || palabra.isEmpty()) {
            return palabra;
        }
        return palabra.substring(0, 1).toUpperCase() + palabra.substring(1).toLowerCase();
    }

    private String obtenerSeleccionComboBox() {
        Object seleccionado = comboDirigente.getSelectedItem();
        return seleccionado != null ? seleccionado.toString() : "";
    }

    public void actualizarComboDirigente() {
        comboDirigente.removeAllItems();
        ArrayList<String> listaDirigentes = cargarNombresDesdeArchivo("nombres_dirigentes.txt");

        if (listaDirigentes.isEmpty()) {
            JOptionPane.showMessageDialog(this, "La lista de dirigentes está vacía.", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return;
        }

        for (String nombre : listaDirigentes) {
            if (nombre != null && !nombre.isEmpty()) {
                comboDirigente.addItem(nombre);
            }
        }
    }

    private ArrayList<String> cargarNombresDesdeArchivo(String archivo) {
        ArrayList<String> listaNombres = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
            String nombre;
            while ((nombre = reader.readLine()) != null) {
                if (!nombre.trim().isEmpty()) {
                    listaNombres.add(nombre);
                }
            }
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "Error al leer el archivo: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        return listaNombres;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }
}
