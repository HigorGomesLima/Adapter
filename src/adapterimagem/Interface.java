package adapterimagem;

import java.awt.image.BufferedImage;

public abstract class Interface {
    public abstract int[][] carregarImagem(String nome);
    public abstract int getWidth();
    public abstract int getHeight();
    public abstract int[][] media3(int[][] matriz,int w,int h);
    public abstract int[][] binaria(int[][] matriz,int w,int h);
}
