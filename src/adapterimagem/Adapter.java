package adapterimagem;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

public class Adapter extends Interface {
    Processador3 filtro;
    @Override
    public int[][] carregarImagem(String nome) {
        if(filtro == null || nome != filtro.getNomeArquivo()){
            try {
                filtro = new Processador3(nome);
            } catch (IOException ex) { System.out.println("Erro na leitura do arquivo");}
        }
        int[][] retorno = new int[filtro.getSize(0)][filtro.getSize(1)];
        for(int i = 0;i < filtro.getSize(0);i++){
            for(int j = 0;j < filtro.getSize(1);j++){
                retorno[i][j] = (filtro.getImagem()[i][j][0] + filtro.getImagem()[i][j][1] + filtro.getImagem()[i][j][2])/3;
            }
        }
        return retorno;
    }

    @Override
    public int[][] media3(int[][] matriz) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int[][] binaria(int[][] matriz) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getWidth() {
        return filtro.getSize(0);
    }

    @Override
    public int getHeight() {
        return filtro.getSize(1);
    }
    
}
