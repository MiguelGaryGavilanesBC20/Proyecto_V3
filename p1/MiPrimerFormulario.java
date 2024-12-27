package p1;
import javax.swing.*;
import java.awt.event.*;

public class MiPrimerFormulario extends JFrame implements ActionListener{

	private JButton boton1, boton2, boton3;
	private JLabel label1, label2, aa;
	private JTextField texto1, texto2;
	private JTextArea area1;

		
	public MiPrimerFormulario(){
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

		label2 = new JLabel("Descripcion");
		label2.setBounds(50,80,50,30);
		add(label2);

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


    

	}

	public void actionPerformed(ActionEvent e){
		if ( e.getSource() == boton1 ){
			String usuario = texto1.getText() + texto2.getText();
			setTitle(usuario);
			
		}

		if ( e.getSource() == boton3 ){
		//this.setVisible(false);
		MiSegundoFormulario formulario3 = new MiSegundoFormulario(this);
		  formulario3.setBounds(300, 100, 450, 350); 
	      formulario3.setVisible(true);
          formulario3.setResizable(false);
		  formulario3.setLocation(300,100);

		formulario3.setVisible(true);

		}
		if ( e.getSource() == boton2 ){
			System.exit(0);
		

		}

		



	}





}