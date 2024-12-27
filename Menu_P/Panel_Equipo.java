package Menu_P;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.util.ArrayList;
import java.util.List;


public class Panel_Equipo extends JPanel implements ActionListener {

    private JButton boton1,boton2;
    private JLabel label1, label2;
    private JTextField texto1;
    private DefaultTableModel modeloTabla;
    private JTable tabla;
    private JScrollPane scrollPane;
    private JComboBox<String> comboDirigente;
    private List<Dirigente> listaDirigentes;
    



    public Panel_Equipo(DefaultTableModel modeloTabla, List<Dirigente> listaDirigentes ) {

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
        actualizarComboDirigente(listaDirigentes);

        boton1 = new JButton("Registrar");
        boton1.setBounds(300, 20, 100, 30);
        add(boton1);
        boton1.addActionListener(this);
        
        boton2 = new JButton("Actualizar");
        boton2.setBounds(300, 50, 100, 30);
        add(boton2);
        boton2.addActionListener(this);


        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Fecha de inscripcion");


        this.modeloTabla = modeloTabla;
        tabla = new JTable(modeloTabla);
        scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(40, 130, 420, 200);
        add(scrollPane);
        

    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton2) {
            actualizarComboDirigente(listaDirigentes);
        }
        if (e.getSource() == boton1) { //guardar

            String nombre = primeraletra(texto1.getText());
            String dirigente = comboDirigente.getSelectedItem() != null ? comboDirigente.getSelectedItem().toString() : "";



            if (nombre.isEmpty()|| dirigente.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor, complete todos los campos.", "Error al agregar los datos", JOptionPane.ERROR_MESSAGE);
            } else {
                modeloTabla.addRow(new Object[]{nombre,dirigente });
                //limpiar campos de texto
                texto1.setText("");
            }
        }

    }
    
    public DefaultTableModel getModeloTabla() {
        return modeloTabla;
    }


    private String primeraletra(String palabra) {
        if (palabra == null || palabra.isEmpty()) {
            return palabra;
        }
        return palabra.substring(0, 1).toUpperCase() + palabra.substring(1).toLowerCase();
    }
    

    public void actualizarComboDirigente(List<Dirigente> listaDirigentes) {
        comboDirigente.removeAllItems(); // Limpiar el combo
        for (Dirigente dirigente : listaDirigentes) {
            comboDirigente.addItem(dirigente.getNombre());
        }
    }

}



