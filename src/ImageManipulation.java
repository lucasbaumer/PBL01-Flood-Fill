import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageManipulation extends JPanel {
    private BufferedImage img;

    public ImageManipulation(BufferedImage img){
        this.img = img;
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        g.drawImage(img, 0,0,this);
    }
}
