package adapterimagem;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Adapter extends Interface {

    @Override
    public int[][] carregarImagem(String nome) {
        BufferedImage img;
        int saida[][] = null;
        try {
            img = ImageIO.read(new File(nome));
            int linha = img.getWidth();
            int coluna = img.getHeight();
            saida = new int[linha][coluna];
            int entrada[][][] = Processador3.loadImage(nome);                
            for(int i = 0;i<linha;i++){
                for(int j=0;j<coluna;j++)
                    saida[i][j] = (entrada[i][j][0] + entrada[i][j][1] + entrada[i][j][2])/3;
            }
        } catch (IOException ex) {
            System.out.println("Erro");
        }
        return saida;
    }

    @Override
    public int[][] media3(int[][] matriz) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int[][] binaria(int[][] matriz) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
