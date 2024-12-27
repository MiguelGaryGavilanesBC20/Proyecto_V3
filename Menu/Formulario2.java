package Menu;

import javax.swing.*;
import java.awt.event.*;

public class Formulario2 extends JFrame implements ActionListener{

	private JButton boton1, boton2, boton3;
	private JLabel label1,aa;
	private JTextField texto1, texto2;
	private JTextArea area1;

	private JMenuItem abrir;
	
	public Formulario2(){
		setLayout(null);
		label1 = new JLabel("Usuario");
		label1.setBounds(50,50,50,20);
		add(label1);

		texto1 = new JTextField();
		texto1.setBounds(110,50,100,20);
		add(texto1);

		texto2 = new JTextField();
		texto2.setBounds(310,50,100,20);
		add(texto2);

		label1 = new JLabel("Descripcion");
		label1.setBounds(50,80,50,30);
		add(label1);

		aa = new JLabel("Apellido");
		aa.setBounds(250,50,50,30);
		add(aa);

		area1 = new JTextArea();
		area1.setBounds(110,80,100,100);
		add(area1);

		boton1 = new JButton("Aceptar");
		boton1.setBounds(100,200,100,30);
		add(boton1);
		boton1.addActionListener(this);

		boton2 = new JButton("Salir");
		boton2.setBounds(200,200,100,30);
		add(boton2);
		boton2.addActionListener(this);

		boton3 = new JButton("Abrir otro");
		boton3.setBounds(300,200,100,30);
		add(boton3);
		boton3.addActionListener(this);


    		//Creamos la barra de Menu
        	JMenuBar barraMenu=new JMenuBar();
 
        	//Creamos los menus
        	JMenu archivo=new JMenu("Archivo");
        	JMenu editar=new JMenu("Editar");
 
        	//Añadimos los menus a la barra de menu
 
        	barraMenu.add(archivo);
        	barraMenu.add(editar);

		abrir= new JMenuItem("Abrir");
		abrir.addActionListener(this);
		archivo.add(abrir);

        	//Indicamos que es el menu por defecto
        	setJMenuBar(barraMenu);


	

	}

	public void actionPerformed(ActionEvent e){
		if ( e.getSource() == boton1 ){
			String usuario = texto1.getText() + texto2.getText();
			setTitle(usuario);
			
		}
		if ( e.getSource() == boton2 ){
			dispose();
			//System.exit(0);

		}
		if ( e.getSource() == boton3 ){
		this.setVisible(false);
		Formulario2 formulario3 = new Formulario2();
		formulario3.setBounds(0,0,450,350);
		formulario3.setVisible(false);
		formulario3.setResizable(false);
		formulario3.setLocationRelativeTo(null);

			formulario3.setVisible(true);
		

		}

		



	}
/*
	public static void main(String args[]){

		try{
		Formulario2 formulario1 = new Formulario2();
		formulario1.setBounds(0,0,450,350);
		formulario1.setVisible(true);
		formulario1.setResizable(false);

		formulario1.setLocationRelativeTo(null);
		} catch (Exception e){
			e.printStackTrace();
		}



	}

*/



}