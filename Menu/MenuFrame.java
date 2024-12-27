package Menu;

//import java.awt.Container;
import java.awt.event.*;


import javax.swing.*;
//import javax.swing.JMenu;
//import javax.swing.JMenuBar;
//import javax.swing.JMenuItem;
//import javax.swing.JPanel;

//import javax.swing.JFrame;


class MenuFrame extends JFrame implements ActionListener{
    private JMenuItem salir,acercaDeItem;
    private JMenuBar mibarra;
    private JMenuItem crear;
    private JMenu acercaDe;

    public MenuFrame() {
        setLayout(null);

        setBounds(0, 0, 550, 400);

// MenuLamina milamina = new MenuLamina();

// add(milamina);
        mibarra = new JMenuBar();

        JMenu registro = new JMenu("Registro");
        JMenu juegos = new JMenu("Juegos");
        acercaDe = new JMenu("Acerca de...");
        acercaDe.addActionListener(this);

        crear = new JMenuItem("Crear Usuario");

        crear.addActionListener(this);

        salir = new JMenuItem("Salir");

        salir.addActionListener(this);


        JMenuItem generales = new JMenuItem("Generales");

        JMenu unJugador = new JMenu("Un solo jugador");
        JMenuItem solitario = new JMenuItem("Solitario");
        JMenuItem parejas = new JMenuItem("Parejas");


        JMenu multiplesJugadores = new JMenu("Múltiples jugadores");
        JMenu dosJugadores = new JMenu("Dos Jugadores");
        JMenuItem guerra = new JMenuItem("Guerra Naval");
        JMenuItem tresRaya = new JMenuItem("Tres en Raya");

        JMenu multiples = new JMenu("Múltiples");
        JMenuItem monopolio = new JMenuItem("Monopolio");
         //Acerca dee
        acercaDeItem = new JMenuItem("Información");
        acercaDeItem.addActionListener(this);


        mibarra.add(registro);
        mibarra.add(juegos);
        mibarra.add(acercaDe);

        registro.add(crear);
        registro.add(salir);

        juegos.add(unJugador);
        unJugador.add(solitario);
        unJugador.add(parejas);

        juegos.addSeparator();

        juegos.add(multiplesJugadores);
        multiplesJugadores.add(dosJugadores);
        dosJugadores.add(guerra);
        dosJugadores.add(tresRaya);
        multiplesJugadores.add(multiples);
        multiples.add(monopolio);

        acercaDe.add(acercaDeItem);



//mibarra.add(opciones );

        add(mibarra);

//Indicamos que es el menu por defecto
        setJMenuBar(mibarra);

    }

    public void actionPerformed(ActionEvent e){
// Container C=this.getContentPane();
        if(e.getSource()==acercaDeItem){
            Formulario3 ventanaInfo = new Formulario3();
            ventanaInfo.setBounds(0,0,450,350);
            ventanaInfo.setVisible(true);
            ventanaInfo.setResizable(false);

            ventanaInfo.setLocationRelativeTo(null);
        }
        if(e.getSource()==crear){
            Formulario2 ventanaabrir = new Formulario2();
            ventanaabrir.setBounds(0,0,450,350);
            ventanaabrir.setVisible(true);
            ventanaabrir.setResizable(false);

            ventanaabrir.setLocationRelativeTo(null);


        }
        if(e.getSource()==salir){
            System.exit(0);
        }



    }


}