package p1;

public class mainFormulario{

	public static void main(String args[]){

		try{
		MiPrimerFormulario formulario1 = new MiPrimerFormulario();
		formulario1.setBounds(0,0,450,350);
		formulario1.setVisible(true);
		formulario1.setResizable(false);

		formulario1.setLocationRelativeTo(null);
		} catch (Exception e){
			e.printStackTrace();
		}



	}





}