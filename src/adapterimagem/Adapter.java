package adapterimagem;

import java.io.IOException;

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
    public int[][] media3(int[][] matriz,int w,int h) {
        int[][] retorno = new int[w][h];
        int[] aux = {w,h};
        int[][][] arquivoProcessa = new int[w][h][3];
        for(int i = 0;i < w;i++){
            for(int j = 0; j < h;j++){
                arquivoProcessa[i][j][0] = matriz[i][j];
                arquivoProcessa[i][j][1] = matriz[i][j];
                arquivoProcessa[i][j][2] = matriz[i][j];
            }
        }
        arquivoProcessa = filtro.media(arquivoProcessa, aux);
        for(int i = 0;i < w;i++){
            for(int j = 0; j < h;j++){
                retorno[i][j] = (arquivoProcessa[i][j][0] + arquivoProcessa[i][j][1] + arquivoProcessa[i][j][2])/3;
            }
        }
        return retorno;
    }

    @Override
    public int[][] binaria(int[][] matriz,int w,int h) {
        int[][] retorno = new int[w][h];
        int[] aux = {w,h};
        int[][][] arquivoProcessa = new int[w][h][3];
        for(int i = 0;i < w;i++){
            for(int j = 0; j < h;j++){
                arquivoProcessa[i][j][0] = matriz[i][j];
                arquivoProcessa[i][j][1] = matriz[i][j];
                arquivoProcessa[i][j][2] = matriz[i][j];
            }
        }
        arquivoProcessa = filtro.filtroB(arquivoProcessa, aux);
        for(int i = 0;i < w;i++){
            for(int j = 0; j < h;j++){
                retorno[i][j] = arquivoProcessa[i][j][0] * 255;
            }
        }
        return retorno;
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
