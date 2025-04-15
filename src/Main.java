import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        File file = new File("src/teste.png");
        if (!file.exists()) {
            System.out.println("Arquivo não encontrado!");
            return;
        }

        try {
            BufferedImage img = ImageIO.read(file);
            ImageManipulation panel = new ImageManipulation(img);

            JFrame frame = new JFrame("Clique na área para preencher");
            frame.add(panel);
            frame.setSize(img.getWidth(), img.getHeight());
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

            ImageProcessorFila processor = new ImageProcessorFila(img, panel);
//              ImageProcessorPilha processor = new ImageProcessorPilha(img, panel);

            panel.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    processor.iniciarFloodFill(e.getX(), e.getY());
                }
            });

            frame.setVisible(true);
        } catch (IOException e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }
}