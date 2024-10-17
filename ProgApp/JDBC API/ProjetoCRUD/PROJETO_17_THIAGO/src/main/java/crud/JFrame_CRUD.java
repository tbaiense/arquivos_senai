package crud;


public class JFrame_CRUD extends javax.swing.JFrame {

    public JFrame_CRUD() {
        initComponents();
        jPanel_Table_Caderno2.getTableModel().fillRows(BD.Caderno.selectAll());
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnl_contentPane = new javax.swing.JPanel();
        jPanel_Table_Caderno2 = new crud.JPanel_Table_Caderno();
        jTextField2 = new javax.swing.JTextField();
        jSpinner1 = new javax.swing.JSpinner();
        jComboBox1 = new javax.swing.JComboBox<>();
        jCheckBox1 = new javax.swing.JCheckBox();
        jTextField1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpnl_contentPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jpnl_contentPane.add(jPanel_Table_Caderno2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jTextField2.setText("jTextField2");
        jpnl_contentPane.add(jTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 410, 190, -1));
        jpnl_contentPane.add(jSpinner1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 410, 110, -1));

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        jpnl_contentPane.add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 410, 200, -1));

        jCheckBox1.setText("Ativo");
        jpnl_contentPane.add(jCheckBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 350, -1, 30));

        jTextField1.setText("jTextField1");
        jTextField1.setEnabled(false);
        jpnl_contentPane.add(jTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 350, 110, -1));

        jButton1.setText("Excluir");
        jpnl_contentPane.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 500, 140, -1));

        jButton2.setText("Cadastrar");
        jpnl_contentPane.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 500, 140, -1));

        jButton3.setText("Alterar");
        jpnl_contentPane.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 500, 130, -1));
        jpnl_contentPane.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 480, 560, 10));

        jLabel1.setText("Id:");
        jpnl_contentPane.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 350, -1, 30));

        jLabel2.setText("Modelo");
        jpnl_contentPane.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 390, -1, -1));

        jLabel3.setText("Páginas");
        jpnl_contentPane.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 390, -1, -1));

        jLabel4.setText("Gramatura");
        jpnl_contentPane.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 390, -1, -1));

        jLabel5.setForeground(new java.awt.Color(255, 51, 51));
        jLabel5.setText("Valor inválido!");
        jLabel5.setFocusable(false);
        jpnl_contentPane.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 440, -1, -1));

        jLabel6.setForeground(new java.awt.Color(255, 51, 51));
        jLabel6.setText("Gramatura não disponível!");
        jLabel6.setFocusable(false);
        jpnl_contentPane.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 440, -1, -1));

        jLabel7.setForeground(new java.awt.Color(255, 51, 51));
        jLabel7.setText("Valor inválido para modelo!");
        jLabel7.setFocusable(false);
        jpnl_contentPane.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 440, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnl_contentPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jpnl_contentPane, javax.swing.GroupLayout.PREFERRED_SIZE, 548, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(JFrame_CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(JFrame_CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(JFrame_CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(JFrame_CRUD.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrame_CRUD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private crud.JPanel_Table_Caderno jPanel_Table_Caderno2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSpinner jSpinner1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JPanel jpnl_contentPane;
    // End of variables declaration//GEN-END:variables
}
