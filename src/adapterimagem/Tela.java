package adapterimagem;

import java.awt.image.BufferedImage;
import java.awt.image.WritableRaster;
import javax.swing.ImageIcon;

public class Tela extends javax.swing.JFrame {
    
    Interface pdi;
    String nomeArquivo;

    public Tela(String nome) {
        initComponents();
        nomeArquivo = nome;
        //Adapter
        pdi = new Adapter();
        int[][] imageAtual = pdi.carregarImagem(nomeArquivo);
        BufferedImage img = new BufferedImage(pdi.getWidth(),pdi.getHeight(),1);
        WritableRaster raster = img.getRaster();
        for(int i = 0;i < pdi.getWidth();i++){
            for(int j = 0;j < pdi.getHeight(); j++){
                raster.setPixel(i, j, newColor(imageAtual[i][j]));
            }
        }
        
        ImageIcon icon = new ImageIcon(img);
        this.local.setIcon(icon);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        local = new javax.swing.JLabel();
        tecla_media = new javax.swing.JToggleButton();
        tecla_binario = new javax.swing.JToggleButton();
        tecla_normal = new javax.swing.JToggleButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        tecla_media.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        tecla_media.setText("Media");
        tecla_media.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tecla_mediaActionPerformed(evt);
            }
        });

        tecla_binario.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        tecla_binario.setText("Binario");
        tecla_binario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tecla_binarioActionPerformed(evt);
            }
        });

        tecla_normal.setFont(new java.awt.Font("Tahoma", 0, 9)); // NOI18N
        tecla_normal.setText("Normal");
        tecla_normal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tecla_normalActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(local, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tecla_media, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tecla_binario, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tecla_normal, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 16, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(local, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(tecla_normal)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tecla_media)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(tecla_binario)
                .addContainerGap(128, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tecla_mediaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tecla_mediaActionPerformed
        int[][] imageAtual = pdi.getImagem();
        imageAtual = pdi.media3(imageAtual, pdi.getWidth(), pdi.getHeight());
        BufferedImage img = new BufferedImage(pdi.getWidth(),pdi.getHeight(),1);
        WritableRaster raster = img.getRaster();
        for(int i = 0;i < pdi.getWidth();i++){
            for(int j = 0;j < pdi.getHeight(); j++){
                raster.setPixel(i, j, newColor(imageAtual[i][j]));
            }
        }
        this.tecla_media.setSelected(false);
        ImageIcon icon = new ImageIcon(img);
        this.local.setIcon(icon);
    }//GEN-LAST:event_tecla_mediaActionPerformed

    private void tecla_binarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tecla_binarioActionPerformed
        int[][] imageAtual = pdi.getImagem();
        imageAtual = pdi.binaria(imageAtual, pdi.getWidth(), pdi.getHeight());
        BufferedImage img = new BufferedImage(pdi.getWidth(),pdi.getHeight(),1);
        WritableRaster raster = img.getRaster();
        for(int i = 0;i < pdi.getWidth();i++){
            for(int j = 0;j < pdi.getHeight(); j++){
                raster.setPixel(i, j, newColor(imageAtual[i][j]));
            }
        }
        this.tecla_binario.setSelected(false);
        ImageIcon icon = new ImageIcon(img);
        this.local.setIcon(icon);
    }//GEN-LAST:event_tecla_binarioActionPerformed

    private void tecla_normalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tecla_normalActionPerformed
        int[][] imageAtual = pdi.getImagem();
        BufferedImage img = new BufferedImage(pdi.getWidth(),pdi.getHeight(),1);
        WritableRaster raster = img.getRaster();
        for(int i = 0;i < pdi.getWidth();i++){
            for(int j = 0;j < pdi.getHeight(); j++){
                raster.setPixel(i, j, newColor(imageAtual[i][j]));
            }
        }
        this.tecla_normal.setSelected(false);
        ImageIcon icon = new ImageIcon(img);
        this.local.setIcon(icon);
    }//GEN-LAST:event_tecla_normalActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tela(null).setVisible(true);
            }
        });
    }
    
    public static int[] newColor(int pixel){
        int[] r = {pixel,pixel,pixel};
        return r;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel local;
    private javax.swing.JToggleButton tecla_binario;
    private javax.swing.JToggleButton tecla_media;
    private javax.swing.JToggleButton tecla_normal;
    // End of variables declaration//GEN-END:variables
}
