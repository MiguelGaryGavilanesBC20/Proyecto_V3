package Menu_P;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PanelDirigente extends JPanel implements ActionListener {
    private List<Dirigente> listaDirigentes;
    private List<ActionListener> listeners = new ArrayList<>();

    private DefaultTableModel modeloTabla;
    private JTextField txtNombre, txtCargo, txtPatrimonio, txtFechaEleccion, txtEdad, txtCedula;
    private JLabel lbNombre, lbCargo, lbPatrimonio, lbFechaEleccion, lbEdad, lbCedula;
    private JButton btnRegistrar, btnGuardarNombres;
    private JTable tablaDirigentes;
    private JScrollPane scrollPane;

    public PanelDirigente(DefaultTableModel modeloTabla) {
        this.listaDirigentes = new ArrayList<>();
        
        setLayout(null);

        // Panel de registro
        lbNombre = new JLabel("Nombre Completo");
        lbNombre.setBounds(50, 20, 100, 20);
        add(lbNombre);

        txtNombre = new JTextField();
        txtNombre.setBounds(150, 20, 110, 20);
        add(txtNombre);

        lbCargo = new JLabel("Cargo");
        lbCargo.setBounds(50, 50, 100, 20);
        add(lbCargo);

        txtCargo = new JTextField();
        txtCargo.setBounds(150, 50, 110, 20);
        add(txtCargo);

        lbEdad = new JLabel("Edad");
        lbEdad.setBounds(50, 80, 100, 20);
        add(lbEdad);

        txtEdad = new JTextField();
        txtEdad.setBounds(150, 80, 110, 20);
        add(txtEdad);

        lbCedula = new JLabel("Cédula");
        lbCedula.setBounds(50, 110, 100, 20);
        add(lbCedula);

        txtCedula = new JTextField();
        txtCedula.setBounds(150, 110, 110, 20);
        add(txtCedula);

        lbPatrimonio = new JLabel("Patrimonio ($)");
        lbPatrimonio.setBounds(50, 140, 100, 20);
        add(lbPatrimonio);

        txtPatrimonio = new JTextField();
        txtPatrimonio.setBounds(150, 140, 110, 20);
        add(txtPatrimonio);

        lbFechaEleccion = new JLabel("Fecha de Elección");
        lbFechaEleccion.setBounds(50, 170, 120, 20);
        add(lbFechaEleccion);

        txtFechaEleccion = new JTextField();
        txtFechaEleccion.setBounds(150, 170, 110, 20);
        add(txtFechaEleccion);

        btnRegistrar = new JButton("Registrar");
        btnRegistrar.setBounds(300, 20, 100, 30);
        add(btnRegistrar);
        btnRegistrar.addActionListener(this);

        btnGuardarNombres = new JButton("Guardar Nombres");
        btnGuardarNombres.setBounds(300, 60, 150, 30);
        add(btnGuardarNombres);
        btnGuardarNombres.addActionListener(this);

        // Configurar modelo de la tabla
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Cargo");
        modeloTabla.addColumn("Edad");
        modeloTabla.addColumn("Cédula");
        modeloTabla.addColumn("Patrimonio");
        modeloTabla.addColumn("Fecha de Elección");

        // Tabla de dirigentes
        this.modeloTabla = modeloTabla;
        tablaDirigentes = new JTable(modeloTabla);
        scrollPane = new JScrollPane(tablaDirigentes);
        scrollPane.setBounds(50, 220, 420, 200);
        add(scrollPane);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == btnRegistrar) {
            String nombre = txtNombre.getText();
            String cargo = txtCargo.getText();
            String edadTexto = txtEdad.getText();
            String cedulaTexto = txtCedula.getText();
            String patrimonioTexto = txtPatrimonio.getText();
            String fechaEleccion = txtFechaEleccion.getText();

            if (nombre.isEmpty() || cargo.isEmpty() || edadTexto.isEmpty() || cedulaTexto.isEmpty() || patrimonioTexto.isEmpty() || fechaEleccion.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error al agregar los datos", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                int edad = Integer.parseInt(edadTexto);
                double patrimonio = Double.parseDouble(patrimonioTexto);
                int cedula = Integer.parseInt(cedulaTexto);

                String patrimonio_2 = String.format("$ %.2f", patrimonio);
                modeloTabla.addRow(new Object[]{nombre, cargo, edad, cedula, patrimonio_2, fechaEleccion});

                Dirigente nuevoDirigente = new Dirigente(nombre);
                listaDirigentes.add(nuevoDirigente);

                txtNombre.setText("");
                txtCargo.setText("");
                txtEdad.setText("");
                txtCedula.setText("");
                txtPatrimonio.setText("");
                txtFechaEleccion.setText("");

                JOptionPane.showMessageDialog(this, "Dirigente registrado exitosamente.");
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Edad y patrimonio deben ser números válidos.", "Error al agregar los datos", JOptionPane.ERROR_MESSAGE);
            }
        }

        if (e.getSource() == btnGuardarNombres) {
            guardarNombresEnArchivo();
        }
    }

    private void guardarNombresEnArchivo() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("nombres_dirigentes.txt"))) {
            for (int i = 0; i < modeloTabla.getRowCount(); i++) {
                String nombre = (String) modeloTabla.getValueAt(i, 0);
                writer.write(nombre);
                writer.newLine();
            }
            JOptionPane.showMessageDialog(this, "Nombres guardados en el archivo 'nombres_dirigentes.txt'.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar los nombres: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public List<Dirigente> getListaDirigentes() {
        return listaDirigentes;
    }

    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }
}
