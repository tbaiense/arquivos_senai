/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package cadastro;

/**
 *
 * @author t.baiense
 */
public class CadastroLivro extends javax.swing.JFrame {

    /**
     * Creates new form CadastroLivro
     */
    public CadastroLivro() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jlbl_NovoLivro = new javax.swing.JLabel();
        jlbl_isbn = new javax.swing.JLabel();
        jlbl_codBarras = new javax.swing.JLabel();
        jlbl_exemplares = new javax.swing.JLabel();
        jlbl_titulo = new javax.swing.JLabel();
        jlbl_subtitulo = new javax.swing.JLabel();
        jlbl_assuntos = new javax.swing.JLabel();
        jlbl_editora = new javax.swing.JLabel();
        jlbl_anoPub = new javax.swing.JLabel();
        jtxtf_subtitulo = new javax.swing.JTextField();
        jtxtf_codBarras = new javax.swing.JTextField();
        jtxtf_isbn = new javax.swing.JTextField();
        jtxtf_titulo = new javax.swing.JTextField();
        js_exemplares = new javax.swing.JSpinner();
        jcb_editora = new javax.swing.JComboBox<>();
        jtxtf_anoPub = new javax.swing.JTextField();
        jtxtf_assuntos = new javax.swing.JTextField();
        jchb_subtitulo = new javax.swing.JCheckBox();
        jlbl_autores = new javax.swing.JLabel();
        jtxtf_autores = new javax.swing.JTextField();
        jbtn_cadastrar = new javax.swing.JButton();
        jbtn_cancelar = new javax.swing.JButton();
        jlbl_genero = new javax.swing.JLabel();
        jcb_genero = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setSize(new java.awt.Dimension(800, 600));

        jlbl_NovoLivro.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlbl_NovoLivro.setText("Novo Livro");

        jlbl_isbn.setText("Número de ISBN");

        jlbl_codBarras.setText("Código de barras");

        jlbl_exemplares.setText("Qtd. exemplares");

        jlbl_titulo.setText("Título");

        jlbl_subtitulo.setText("Subtítulo");
        jlbl_subtitulo.setEnabled(false);

        jlbl_assuntos.setText("Assuntos");

        jlbl_editora.setText("Editora");

        jlbl_anoPub.setText("Ano de publicação");

        jtxtf_subtitulo.setEnabled(false);

        jtxtf_titulo.setText("Alice no País das Maravilhas");
        jtxtf_titulo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtxtf_tituloActionPerformed(evt);
            }
        });

        jcb_editora.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Cia das letras", "Record", "Gazeta", "Globo", "Belas Artes", " " }));

        jtxtf_anoPub.setText("2024");

        jtxtf_assuntos.setText("Ação, Comédia, Suspence");

        jlbl_autores.setText("Autores");

        jbtn_cadastrar.setText("Cadastrar");

        jbtn_cancelar.setText("Cancelar");

        jlbl_genero.setText("Gênero Literário");

        jcb_genero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Romance", "Epopeia", "Técnico" }));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(19, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jlbl_titulo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jtxtf_titulo)
                            .addGap(331, 331, 331))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jlbl_isbn)
                            .addGap(14, 14, 14)
                            .addComponent(jtxtf_isbn, javax.swing.GroupLayout.PREFERRED_SIZE, 138, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jlbl_codBarras)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(jtxtf_codBarras, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jlbl_exemplares)
                            .addGap(14, 14, 14)
                            .addComponent(js_exemplares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(27, 27, 27))
                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jchb_subtitulo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jlbl_subtitulo)
                            .addGap(18, 18, 18)
                            .addComponent(jtxtf_subtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 563, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jlbl_NovoLivro)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(219, 219, 219)
                                .addComponent(jbtn_cadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(34, 34, 34)
                                .addComponent(jbtn_cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jlbl_editora)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jcb_editora, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jlbl_anoPub)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jtxtf_anoPub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jlbl_genero)
                                    .addGap(18, 18, 18)
                                    .addComponent(jcb_genero, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jlbl_autores)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(jtxtf_autores, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jlbl_assuntos)
                                    .addGap(18, 18, 18)
                                    .addComponent(jtxtf_assuntos, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jlbl_NovoLivro)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbl_isbn)
                    .addComponent(jtxtf_isbn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbl_codBarras)
                    .addComponent(jtxtf_codBarras, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbl_exemplares)
                    .addComponent(js_exemplares, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbl_titulo)
                    .addComponent(jtxtf_titulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbl_subtitulo)
                    .addComponent(jtxtf_subtitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jchb_subtitulo))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbl_autores)
                    .addComponent(jtxtf_autores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbl_assuntos)
                    .addComponent(jtxtf_assuntos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbl_editora)
                    .addComponent(jcb_editora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbl_anoPub)
                    .addComponent(jtxtf_anoPub, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbl_genero)
                    .addComponent(jcb_genero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtn_cancelar)
                    .addComponent(jbtn_cadastrar))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtxtf_tituloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtxtf_tituloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtxtf_tituloActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroLivro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroLivro().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton jbtn_cadastrar;
    private javax.swing.JButton jbtn_cancelar;
    private javax.swing.JComboBox<String> jcb_editora;
    private javax.swing.JComboBox<String> jcb_genero;
    private javax.swing.JCheckBox jchb_subtitulo;
    private javax.swing.JLabel jlbl_NovoLivro;
    private javax.swing.JLabel jlbl_anoPub;
    private javax.swing.JLabel jlbl_assuntos;
    private javax.swing.JLabel jlbl_autores;
    private javax.swing.JLabel jlbl_codBarras;
    private javax.swing.JLabel jlbl_editora;
    private javax.swing.JLabel jlbl_exemplares;
    private javax.swing.JLabel jlbl_genero;
    private javax.swing.JLabel jlbl_isbn;
    private javax.swing.JLabel jlbl_subtitulo;
    private javax.swing.JLabel jlbl_titulo;
    private javax.swing.JSpinner js_exemplares;
    private javax.swing.JTextField jtxtf_anoPub;
    private javax.swing.JTextField jtxtf_assuntos;
    private javax.swing.JTextField jtxtf_autores;
    private javax.swing.JTextField jtxtf_codBarras;
    private javax.swing.JTextField jtxtf_isbn;
    private javax.swing.JTextField jtxtf_subtitulo;
    private javax.swing.JTextField jtxtf_titulo;
    // End of variables declaration//GEN-END:variables
}