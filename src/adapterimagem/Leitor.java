package adapterimagem;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Leitor {
    
    public Leitor() throws IOException{
        String nomeArquivo = "foto.png";
        Interface pdi = new Adapter();
        int[][] imageAtual = pdi.carregarImagem(nomeArquivo);
        BufferedImage img = new BufferedImage(pdi.getWidth(),pdi.getHeight(),1);
        WritableRaster raster = img.getRaster();
        for(int i = 0;i < pdi.getWidth();i++){
            for(int j = 0;j < pdi.getHeight(); j++){
                int aux = imageAtual[i][j];
                int[] cor = {aux,aux,aux};
                raster.setPixel(i, j, cor);
            }
        }
        ImageIO.write(img, "PNG", new File("teste.png"));
    }
}
