import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Arrays;

public class ImageProcessorPilha {
    private BufferedImage img;
    private JPanel panel;
    private boolean[][] visited;
    private Pilha<Point> pilha;
    private Color replacementColor = Color.YELLOW;

    public ImageProcessorPilha(BufferedImage img, JPanel panel) {
        this.img = img;
        this.panel = panel;
        this.visited = new boolean[img.getWidth()][img.getHeight()];
        this.pilha = new Pilha<>();
    }

    public void iniciarFloodFill(int startX, int startY) {
        if (!isBranco(img.getRGB(startX, startY))) {
            return;
        }

        resetVisited();
        pilha = new Pilha<>();

        pilha.empilhar(new Point(startX, startY));
        visited[startX][startY] = true;

        new Thread(this::processarFloodFill).start();
    }

    private void processarFloodFill() {
        while (!pilha.estaVazia()) {
            Point p = pilha.desempilhar();
            img.setRGB(p.x, p.y, replacementColor.getRGB());

            SwingUtilities.invokeLater(panel::repaint);

            adicionarVizinhos(p.x, p.y);

            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                return;
            }
        }
    }

    private void adicionarVizinhos(int x, int y) {
        int[] dx = {-1, 1, 0, 0};  // Esquerda, Direita
        int[] dy = {0, 0, -1, 1};  // Cima, Baixo

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && nx < img.getWidth() &&
                    ny >= 0 && ny < img.getHeight() &&
                    !visited[nx][ny] &&
                    isBranco(img.getRGB(nx, ny))) {

                visited[nx][ny] = true;
                pilha.empilhar(new Point(nx, ny));
            }
        }
    }

    private boolean isBranco(int rgb) {
        Color c = new Color(rgb);
        return c.getRed() == 255 && c.getGreen() == 255 && c.getBlue() == 255;
    }

    private void resetVisited() {
        for (boolean[] row : visited) {
            Arrays.fill(row, false);
        }
    }
}