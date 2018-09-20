package adapterimagem;

import java.io.IOException;

public class AdapterImagem {

    public static void main(String[] args) throws IOException {
        Tela t = new Tela("foto.png");
        t.setVisible(true);
    }
    
}
