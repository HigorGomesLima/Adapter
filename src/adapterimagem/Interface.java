package adapterimagem;

import java.awt.image.BufferedImage;

public abstract class Interface {
    public abstract int[][] carregarImagem(String nome);
    public abstract int[][] media3(int[][] matriz);
    public abstract int[][] binaria(int[][] matriz);
}
