package Menu;

import javax.swing.*;


public class Formulario3 extends JFrame {
    private JLabel LabelMiguel;
    private JLabel LabelGary;
    private JLabel LabelJose;
    public Formulario3() {
        setTitle(null);
        setLayout(null); // Permitir coordenadas absolutas
        setSize(400, 200); // Tamaño adecuado de la ventana
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        LabelMiguel = new JLabel("Miguel Eduardo Loyola Mora");
        LabelMiguel.setBounds(50,30,300,20);
        add(LabelMiguel);

        LabelGary = new JLabel("Gary Johao Zuñiga Saltos");
        LabelGary.setBounds(50,70,300,20);
        add(LabelGary);

        LabelJose = new JLabel("Jose Agapito Hernandez Vega");
        LabelJose.setBounds(50,110,300,20);
        add(LabelJose);
    }
}
