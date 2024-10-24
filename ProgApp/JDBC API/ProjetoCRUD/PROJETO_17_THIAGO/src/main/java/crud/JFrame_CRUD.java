package crud;

import javax.swing.JOptionPane;


public class JFrame_CRUD extends javax.swing.JFrame {

    public JFrame_CRUD() {
        initComponents();
        jpnl_table.getModel().fillRows(BD.Caderno.selectAll());
        jlbl_valid_modelo.setVisible(false);
        jlbl_valid_paginas.setVisible(false);
        jlbl_valid_gramatura.setVisible(false);
        jcmb_gramatura.addItem(Gramatura.OFFSET_100G);
        jcmb_gramatura.addItem(Gramatura.OFFSET_70G);
        jspn_paginas.setValue(Integer.valueOf(100));
        jpnl_table.getTable().getSelectionModel().addListSelectionListener((e) -> {
            int rowSel = jpnl_table.getTable().getSelectedRow();
            
            if (rowSel == -1) {
                jpnl_table.getTable().getSelectionModel().clearSelection();
            } else {
                setFieldsInfo((Caderno)(jpnl_table.getModel().getRow(rowSel)));
            }
        });
    }

    private void setFieldsInfo(Caderno c) {
        jlbl_valid_modelo.setVisible(false);
        jlbl_valid_paginas.setVisible(false);
        jlbl_valid_gramatura.setVisible(false);
        
        if (c == null) {
            jtxtf_id.setText("");
            jtxtf_modelo.setText("");
            jchb_ativo.setSelected(false);
            jspn_paginas.setValue(Integer.valueOf(100));
            return;
        }
        
        if (c.id != -1) {
            jtxtf_id.setText(String.valueOf(c.id));
        } else {
            jtxtf_id.setText("");
        }
        
        jtxtf_modelo.setText(c.modelo);
        jchb_ativo.setSelected(c.ativo);
        String gramaturaStr = c.gramatura;
        
        Gramatura g = null;
        if (gramaturaStr.equals(Gramatura.OFFSET_70G.valor)) {
            g = Gramatura.OFFSET_70G;
        } else if (gramaturaStr.equals(Gramatura.OFFSET_100G.valor)) {
            g = Gramatura.OFFSET_100G;
        }
        if (g != null) {
            jcmb_gramatura.setSelectedItem(g);
        }
        
        jspn_paginas.setValue(c.paginas);
    }
    
    private Caderno getFieldsInfo() {
        jlbl_valid_modelo.setVisible(false);
        jlbl_valid_paginas.setVisible(false);
        jlbl_valid_gramatura.setVisible(false);
        
        String modelo;
        int id, paginas;
        boolean ativo;
        Gramatura gramatura;
        
        modelo = jtxtf_modelo.getText();
        paginas = (Integer)jspn_paginas.getValue();
        gramatura = (Gramatura)jcmb_gramatura.getSelectedItem();
        ativo = jchb_ativo.isSelected();
        
        String idStr = jtxtf_id.getText();
        if (idStr.isBlank()) {
            id = -1;
        } else {
            try {
                id = Integer.parseInt(idStr);
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Não é permitido usar esse valor como id.");
                id = -1;
            }
        }

        
        try {
            Caderno c;
            if (id != -1) {
                c = new Caderno(id, modelo, paginas, gramatura, ativo);
            } else {
                c = new Caderno(modelo, paginas, gramatura, ativo);
            }
            
            return c;
        } catch (IllegalArgumentsException exs) {
            while(exs.hasNextCause()) {
                Throwable cause = exs.nextCause();
                if (cause instanceof Caderno.InvalidModeloException) {
                    jlbl_valid_modelo.setVisible(true);
                } else if (cause instanceof Caderno.InvalidPaginasException) {
                    jlbl_valid_paginas.setVisible(true);
                } else if (cause instanceof Caderno.InvalidGramaturaException) {
                    jlbl_valid_gramatura.setVisible(true);
                } else if (cause instanceof Caderno.InvalidIdException) {
                    JOptionPane.showMessageDialog(null, cause.getMessage());
                }
            }
            
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jpnl_contentPane = new javax.swing.JPanel();
        jpnl_table = new crud.JPanel_Table_Caderno();
        jtxtf_modelo = new javax.swing.JTextField();
        jspn_paginas = new javax.swing.JSpinner();
        jcmb_gramatura = new javax.swing.JComboBox<>();
        jchb_ativo = new javax.swing.JCheckBox();
        jtxtf_id = new javax.swing.JTextField();
        jbtn_excluir = new javax.swing.JButton();
        jbtn_cadastrar = new javax.swing.JButton();
        jbtn_alterar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jlbl_id = new javax.swing.JLabel();
        jlbl_modelo = new javax.swing.JLabel();
        jlbl_paginas = new javax.swing.JLabel();
        jlbl_gramatura = new javax.swing.JLabel();
        jlbl_valid_paginas = new javax.swing.JLabel();
        jlbl_valid_gramatura = new javax.swing.JLabel();
        jlbl_valid_modelo = new javax.swing.JLabel();
        jbtn_limparSel = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jpnl_contentPane.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jpnl_contentPane.add(jpnl_table, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 190));
        jpnl_contentPane.add(jtxtf_modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 260, 190, -1));
        jpnl_contentPane.add(jspn_paginas, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 260, 110, -1));

        jpnl_contentPane.add(jcmb_gramatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 260, 200, -1));

        jchb_ativo.setText("Ativo");
        jpnl_contentPane.add(jchb_ativo, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 200, -1, 30));

        jtxtf_id.setEnabled(false);
        jpnl_contentPane.add(jtxtf_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 200, 110, -1));

        jbtn_excluir.setText("Excluir");
        jbtn_excluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_excluirActionPerformed(evt);
            }
        });
        jpnl_contentPane.add(jbtn_excluir, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 350, 140, -1));

        jbtn_cadastrar.setText("Cadastrar");
        jbtn_cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_cadastrarActionPerformed(evt);
            }
        });
        jpnl_contentPane.add(jbtn_cadastrar, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 350, 140, -1));

        jbtn_alterar.setText("Alterar");
        jbtn_alterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_alterarActionPerformed(evt);
            }
        });
        jpnl_contentPane.add(jbtn_alterar, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 350, 130, -1));
        jpnl_contentPane.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 560, 10));

        jlbl_id.setText("Id:");
        jpnl_contentPane.add(jlbl_id, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 200, -1, 30));

        jlbl_modelo.setText("Modelo");
        jpnl_contentPane.add(jlbl_modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 240, -1, -1));

        jlbl_paginas.setText("Páginas");
        jpnl_contentPane.add(jlbl_paginas, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 240, -1, -1));

        jlbl_gramatura.setText("Gramatura");
        jpnl_contentPane.add(jlbl_gramatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 240, -1, -1));

        jlbl_valid_paginas.setForeground(new java.awt.Color(255, 51, 51));
        jlbl_valid_paginas.setText("Valor inválido!");
        jlbl_valid_paginas.setFocusable(false);
        jpnl_contentPane.add(jlbl_valid_paginas, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 290, -1, -1));

        jlbl_valid_gramatura.setForeground(new java.awt.Color(255, 51, 51));
        jlbl_valid_gramatura.setText("Gramatura não disponível!");
        jlbl_valid_gramatura.setFocusable(false);
        jpnl_contentPane.add(jlbl_valid_gramatura, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 290, -1, -1));

        jlbl_valid_modelo.setForeground(new java.awt.Color(255, 51, 51));
        jlbl_valid_modelo.setText("Valor inválido para modelo!");
        jlbl_valid_modelo.setFocusable(false);
        jpnl_contentPane.add(jlbl_valid_modelo, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, -1, -1));

        jbtn_limparSel.setText("Limpar seleção");
        jbtn_limparSel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtn_limparSelActionPerformed(evt);
            }
        });
        jpnl_contentPane.add(jbtn_limparSel, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 190, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnl_contentPane, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jpnl_contentPane, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtn_cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_cadastrarActionPerformed
        Caderno c = getFieldsInfo();  
        if (c != null) {
            BD.Caderno.insert(c);
            jpnl_table.getModel().refresh();
        }
    }//GEN-LAST:event_jbtn_cadastrarActionPerformed

    private void jbtn_alterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_alterarActionPerformed
        Caderno c = getFieldsInfo();  
        if (c != null) {
            BD.Caderno.update(c);
            jpnl_table.getModel().refresh();
        }
    }//GEN-LAST:event_jbtn_alterarActionPerformed

    private void jbtn_excluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_excluirActionPerformed
        Caderno c = getFieldsInfo();  
        if (c != null) {
            BD.Caderno.delete(c);
            jpnl_table.getModel().refresh();
        }
        jbtn_limparSel.doClick();
    }//GEN-LAST:event_jbtn_excluirActionPerformed

    private void jbtn_limparSelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtn_limparSelActionPerformed
        jpnl_table.getTable().getSelectionModel().clearSelection();
        setFieldsInfo(null);
    }//GEN-LAST:event_jbtn_limparSelActionPerformed

    public static void main(String args[]) {
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
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrame_CRUD().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JButton jbtn_alterar;
    private javax.swing.JButton jbtn_cadastrar;
    private javax.swing.JButton jbtn_excluir;
    private javax.swing.JButton jbtn_limparSel;
    private javax.swing.JCheckBox jchb_ativo;
    private javax.swing.JComboBox<Gramatura> jcmb_gramatura;
    private javax.swing.JLabel jlbl_gramatura;
    private javax.swing.JLabel jlbl_id;
    private javax.swing.JLabel jlbl_modelo;
    private javax.swing.JLabel jlbl_paginas;
    private javax.swing.JLabel jlbl_valid_gramatura;
    private javax.swing.JLabel jlbl_valid_modelo;
    private javax.swing.JLabel jlbl_valid_paginas;
    private javax.swing.JPanel jpnl_contentPane;
    private crud.JPanel_Table_Caderno jpnl_table;
    private javax.swing.JSpinner jspn_paginas;
    private javax.swing.JTextField jtxtf_id;
    private javax.swing.JTextField jtxtf_modelo;
    // End of variables declaration//GEN-END:variables
}
