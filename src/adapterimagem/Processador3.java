package adapterimagem;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class Processador3 {
    public static int[][][] loadImage(String nome) throws IOException{
        BufferedImage img = ImageIO.read(new File(nome));
        int linha = img.getWidth();
        int coluna = img.getHeight();
        int matrizDaImagem[][][] = new int[linha][coluna][3];
        for(int i=0;i<linha;i++){
            for(int j=0;j<coluna;j++){
                matrizDaImagem[i][j][0] = (new Color(img.getRGB(i, j)).getRed());
                matrizDaImagem[i][j][1] = (new Color(img.getRGB(i, j)).getGreen());
                matrizDaImagem[i][j][2] = (new Color(img.getRGB(i, j)).getBlue());              
            }
        }
        return matrizDaImagem;
        
    }
}
