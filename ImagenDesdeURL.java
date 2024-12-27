import javax.swing.*;
import java.net.URL;

public class ImagenDesdeURL {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://i.pinimg.com/736x/2e/af/3c/2eaf3c356a365d2868047b9d2e0403ec.jpg");
            ImageIcon imagenIcono = new ImageIcon(url);
            JFrame ventana = new JFrame("Imagen desde URL");
            ventana.setSize(750, 420);
            ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            JLabel etiqueta = new JLabel(imagenIcono);
            ventana.add(etiqueta);
            ventana.setVisible(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

