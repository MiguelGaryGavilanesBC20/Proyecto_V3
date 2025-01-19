package Menu_P;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

class Partido {
    private String equipoLocal;
    private String equipoVisitante;
    private String marcador;

    public Partido(String equipoLocal, String equipoVisitante, String marcador) {
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.marcador = marcador;
    }

    public String getEquipoLocal() {
        return equipoLocal;
    }

    public void setEquipoLocal(String equipoLocal) {
        this.equipoLocal = equipoLocal;
    }

    public String getEquipoVisitante() {
        return equipoVisitante;
    }

    public void setEquipoVisitante(String equipoVisitante) {
        this.equipoVisitante = equipoVisitante;
    }

    public String getMarcador() {
        return marcador;
    }

    public void setMarcador(String marcador) {
        this.marcador = marcador;
    }
}



public class Panel_Partidos extends JPanel implements ActionListener {
    private List<Partido> listaPartidos;
    private JComboBox<String> comboLocal, comboVisitante;
    private JTextField textoMarcadorLocal, textoMarcadorVisitante;
    private JButton botonRegistrarPartido;
    private DefaultTableModel modeloTabla5;
    private JTable tablaPartidos,tablaOculta;
    private List<Equipo> listaEquipos;
    private JScrollPane scrollPane,scrollPaneOculta;
    private DefaultTableModel modeloTablaOculta;
    private MenuFrame menuFrame;
    

    public Panel_Partidos(DefaultTableModel modeloTabla5,MenuFrame menuFrame) {
        
        this.listaPartidos = new ArrayList<>();
        listaEquipos = new ArrayList<>();
        this.menuFrame = menuFrame;
        this.tablaOculta = menuFrame.getTablaOculta();
        
        setLayout(null);


        this.scrollPaneOculta = new JScrollPane(menuFrame.getTablaOculta());
        scrollPaneOculta.setBounds(20, 420, 1100, 150);
        add(scrollPaneOculta);


        JLabel labelLocal = new JLabel("Equipo Local:");
        labelLocal.setBounds(50, 20, 100, 20);
        add(labelLocal);

        
        JLabel labelVisitante = new JLabel("Equipo Visitante:");
        labelVisitante.setBounds(350, 20, 120, 20);
        add(labelVisitante);

        comboLocal = new JComboBox<>();
        comboLocal.setBounds(150, 20, 150, 20);
        add(comboLocal);

        comboVisitante = new JComboBox<>();
        comboVisitante.setBounds(470, 20, 150, 20);
        add(comboVisitante);

        JLabel labelMarcador = new JLabel("Marcador (Local - Visitante):");
        labelMarcador.setBounds(50, 60, 200, 20);
        add(labelMarcador);

        textoMarcadorLocal = new JTextField();
        textoMarcadorLocal.setBounds(250, 60, 50, 20);
        add(textoMarcadorLocal);

        textoMarcadorVisitante = new JTextField();
        textoMarcadorVisitante.setBounds(310, 60, 50, 20);
        add(textoMarcadorVisitante);

        botonRegistrarPartido = new JButton("Registrar Partido");
        botonRegistrarPartido.setBounds(400, 60, 150, 30);
        add(botonRegistrarPartido);
        botonRegistrarPartido.addActionListener(this);

        

        modeloTabla5 = new DefaultTableModel();
        modeloTabla5.addColumn("Local");
        modeloTabla5.addColumn("Visitante");
        modeloTabla5.addColumn("Marcador");

        // Tabla de árbitros
        this.modeloTabla5 = modeloTabla5;
        tablaPartidos = new JTable(modeloTabla5) {
            @Override
            protected void processMouseEvent(java.awt.event.MouseEvent e) {
                // Deshabilitar cualquier interacción con clics
            }
        };
        tablaPartidos.getTableHeader().setReorderingAllowed(false);
        scrollPane = new JScrollPane(tablaPartidos);
        scrollPane.setBounds(150, 100, 750, 320);
        add(scrollPane);

        cargarPartidos();
        actualizarComboEquipos();
        
    }

    public static List<String> cargarNombresEquipos() {
        List<String> nombresEquipos = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader("tabla_equipos.txt"))) {
            String line;
        while ((line = reader.readLine()) != null) {
            String[] data = line.split(",");
            if (data.length > 0) {
                nombresEquipos.add(data[0]); // Solo agregar el nombre del equipo
            }
        }
    } catch(IOException e) {
        e.printStackTrace();
    }
    return nombresEquipos;
    }

    // Método para actualizar el ComboBox con los nombres de los equipos
    public void actualizarComboEquipos() {
        if (comboLocal == null) {
            comboLocal = new JComboBox<>();
            comboLocal.setBounds(150, 20, 150, 20);
            add(comboLocal);
        }

        if (comboVisitante == null) {
            comboVisitante = new JComboBox<>();
            comboVisitante.setBounds(350, 20, 120, 20);
            add(comboVisitante);
        }
       comboLocal.removeAllItems();
       comboVisitante.removeAllItems();
        // Cargar datos desde el archivo de nombres de equipos
        List<String> nombresEquipos = cargarNombresEquipos();
            for (String nombre : nombresEquipos) {
                comboLocal.addItem(nombre.trim());
            }
            for (String nombre : nombresEquipos) {
                comboVisitante.addItem(nombre.trim());
            }
    }
    public void agregarEquipoEnComboBox(String nombre) {
        System.out.println("Agregando equipo al ComboBox: " + nombre);

        // Mensaje de depuración
        comboLocal.addItem(nombre); // Agregar el nombre del equipo al ComboBox
        comboVisitante.addItem(nombre);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == botonRegistrarPartido) {
            String nombreLocal = (String) comboLocal.getSelectedItem();
            String nombreVisitante = (String) comboVisitante.getSelectedItem();
            String marcadorLocal = textoMarcadorLocal.getText().trim();
            String marcadorVisitante = textoMarcadorVisitante.getText().trim();

            if (nombreLocal == null || nombreVisitante == null || marcadorLocal.isEmpty() || marcadorVisitante.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Complete todos los campos.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (nombreLocal.equals(nombreVisitante)) {
                JOptionPane.showMessageDialog(this, "El equipo local y visitante no pueden ser iguales.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            
            String marcador = marcadorLocal + " - " + marcadorVisitante;

            listaPartidos.add(new Partido(nombreLocal, nombreVisitante, marcador));
            modeloTabla5.addRow(new Object[]{nombreLocal, nombreVisitante, marcador});
            guardarPartidos();

            textoMarcadorLocal.setText("");
            textoMarcadorVisitante.setText("");
        }
    }

    private void guardarPartidos() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("tabla_partidos.txt"))) {
            for (int i = 0; i < modeloTabla5.getRowCount(); i++) {
                writer.write(
                        modeloTabla5.getValueAt(i, 0) + "," +
                        modeloTabla5.getValueAt(i, 1) + "," +
                        modeloTabla5.getValueAt(i, 2));
                writer.newLine();
            }
            JOptionPane.showMessageDialog(this, "Partidos guardados correctamente.");
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(this, "Error al guardar los partidos: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void cargarPartidos() {
        try (BufferedReader reader = new BufferedReader(new FileReader("tabla_partidos.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] datos = line.split(",");
                if (datos.length == 3) {
                    modeloTabla5.addRow(datos);
                }
            }
        } catch (IOException ex) {
            // El archivo puede no existir inicialmente, lo ignoramos
        }
    }
    
    
    
    
    
}
