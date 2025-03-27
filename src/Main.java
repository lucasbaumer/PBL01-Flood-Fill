import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InterruptedIOException;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/pixelArt.png");
        if(!file.exists()){
            System.out.println("Arquivo de imagem não foi encontrado!");
        }
        else{
            try{
                BufferedImage img = ImageIO.read(file);

                ImageManipulation panel = new ImageManipulation(img);
                JFrame frame = new JFrame("Processando imagem...");
                frame.add(panel);
                frame.setSize(img.getWidth(), img.getHeight());
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);

            }
            catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}