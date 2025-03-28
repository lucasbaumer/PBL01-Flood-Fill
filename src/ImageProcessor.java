import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

public class ImageProcessor {
    private BufferedImage img;
    private Fila<Pixel> filaPixel;
    private Pilha<Pixel> pilhaPixel;
    private JPanel panel;

    public ImageProcessor(BufferedImage img, JPanel panel){
        this.img = img;
        this.panel = panel;
        this.filaPixel = new Fila<>(100);
        this.pilhaPixel = new Pilha<>(100);
    }

    public void processarImagem() throws InterruptedException{
        for(int x = 0; x < img.getWidth() -1 ; x++){
            for (int y = 0; y < img.getHeight(); y++){
                int pixelAtual = img.getRGB(x,y);
                int r = (pixelAtual >> 16) & 0xFF;
                int g = (pixelAtual >> 8) & 0xFF;
                int b = pixelAtual  & 0xFF;

                if(r == 255 && g == 255 && b == 255){
                    int novoPixel = Color.yellow.getRGB();

                    img.setRGB(x, y, novoPixel);

                    Pixel pixel = new Pixel(x , y, novoPixel);
                    filaPixel.enfileirar(pixel);
                    pilhaPixel.empilhar(pixel);

                    System.out.println("Pixels em fila: " + pixel.toString());
                    System.out.println("pixel em pilha: " + pixel.toString());
                    System.out.flush();

                    panel.repaint();
                    Thread.sleep(1);
                }
            }
        }
    }
}
