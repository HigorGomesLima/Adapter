package adapterimagem;
import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

public class Processador3 {
    private int[][][] imagem;
    private int[] dimensao;
    private String nomeArquivo;
    
    public Processador3(String nome) throws IOException{
        nomeArquivo = nome;
        dimensao = new int[2];
        BufferedImage img = ImageIO.read(new File(nome));
        int linha = img.getWidth();
        int coluna = img.getHeight();
        dimensao[0] = linha;
        dimensao[1] = coluna;
        int matrizDaImagem[][][] = new int[linha][coluna][3];
        for(int i=0;i<linha;i++){
            for(int j=0;j<coluna;j++){
                matrizDaImagem[i][j][0] = (new Color(img.getRGB(i, j)).getRed());
                matrizDaImagem[i][j][1] = (new Color(img.getRGB(i, j)).getGreen());
                matrizDaImagem[i][j][2] = (new Color(img.getRGB(i, j)).getBlue());              
            }
        }
        this.imagem = matrizDaImagem;   
    }
    
    public int[][][] filtroB(int[][][] nImg,int[] s){
        int w = s[0];
        int h = s[1];
        int[][][] retorno = new int[w][h][3];
        for(int i = 0;i < w;i++){
            for(int j = 0; j < h;j++){
                retorno[i][j][0] = nImg[i][j][0]/128;
                retorno[i][j][1] = nImg[i][j][1]/128;
                retorno[i][j][2] = nImg[i][j][2]/128;
            }
        }
        return retorno;
    }
    
    public int[][][] media(int[][][] nImg,int[] s){
        int w = s[0];
        int h = s[1];
        int[][][] retorno = new int[w][h][3];
        for(int i = 1;i < w-1;i++){
            for(int j = 1; j < h-1;j++){
                int soma = 0;
                for(int k = 0;k < 3;k++){
                    soma += nImg[i-1][j-1][k] + nImg[i][j-1][k] + nImg[i][j][k] + nImg[i][j+1][k]
                            + nImg[i-1][j+1][k] + nImg[i+1][j-1][k] + nImg[i+1][j][k] + nImg[i+1][j+1][k] + nImg[i-1][j][k] ;
                    soma = soma/9;
                    retorno[i][j][k] = soma;
                }
            }
        }
        return retorno;
    }
    
    public int getSize(int pos){
        int retorno = dimensao[pos];
        return retorno;
    }
    
    public int[][][] getImagem(){
        return imagem;
    }
    
    public String getNomeArquivo(){
        return nomeArquivo;
    }
}
