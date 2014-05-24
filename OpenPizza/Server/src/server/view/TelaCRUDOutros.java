/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server.view;

/**
 *
 * @author Gustavo
 */
public class TelaCRUDOutros extends javax.swing.JFrame {

    /**
     * Creates new form TelaCRUDOutros
     */
    public TelaCRUDOutros() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaOutros = new javax.swing.JTable();
        labelDescriçãoOutros = new javax.swing.JLabel();
        JPanelMenuCRUDOutros = new javax.swing.JPanel();
        botaoAdicionarCRUDOutros = new javax.swing.JButton();
        botaoExcluirCRUDOutros = new javax.swing.JButton();
        botaoVoltarCRUDOutros = new javax.swing.JButton();
        botaoEditarCRUDOutros = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CRUD Outros");
        setMaximumSize(new java.awt.Dimension(800, 500));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setPreferredSize(new java.awt.Dimension(800, 500));
        setResizable(false);

        jScrollPane1.setViewportView(tabelaOutros);

        labelDescriçãoOutros.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelDescriçãoOutros.setText("Descrição: ");

        botaoAdicionarCRUDOutros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/server/view/icones_CRUD/AdicionarPizza.png"))); // NOI18N
        botaoAdicionarCRUDOutros.setBorderPainted(false);
        botaoAdicionarCRUDOutros.setContentAreaFilled(false);
        botaoAdicionarCRUDOutros.setMaximumSize(new java.awt.Dimension(63, 63));
        botaoAdicionarCRUDOutros.setMinimumSize(new java.awt.Dimension(63, 63));
        botaoAdicionarCRUDOutros.setPreferredSize(new java.awt.Dimension(63, 63));

        botaoExcluirCRUDOutros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/server/view/icones_CRUD/DeleterPizza.png"))); // NOI18N
        botaoExcluirCRUDOutros.setBorderPainted(false);
        botaoExcluirCRUDOutros.setContentAreaFilled(false);
        botaoExcluirCRUDOutros.setMaximumSize(new java.awt.Dimension(63, 63));
        botaoExcluirCRUDOutros.setMinimumSize(new java.awt.Dimension(63, 63));
        botaoExcluirCRUDOutros.setPreferredSize(new java.awt.Dimension(63, 63));

        botaoVoltarCRUDOutros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/server/view/icones_CRUD/voltar.png"))); // NOI18N
        botaoVoltarCRUDOutros.setBorderPainted(false);
        botaoVoltarCRUDOutros.setContentAreaFilled(false);
        botaoVoltarCRUDOutros.setMaximumSize(new java.awt.Dimension(63, 63));
        botaoVoltarCRUDOutros.setMinimumSize(new java.awt.Dimension(63, 63));
        botaoVoltarCRUDOutros.setPreferredSize(new java.awt.Dimension(63, 63));

        botaoEditarCRUDOutros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/server/view/icones_CRUD/AtualizaPizza.png"))); // NOI18N
        botaoEditarCRUDOutros.setBorderPainted(false);
        botaoEditarCRUDOutros.setContentAreaFilled(false);
        botaoEditarCRUDOutros.setMaximumSize(new java.awt.Dimension(63, 63));
        botaoEditarCRUDOutros.setMinimumSize(new java.awt.Dimension(63, 63));
        botaoEditarCRUDOutros.setPreferredSize(new java.awt.Dimension(63, 63));

        javax.swing.GroupLayout JPanelMenuCRUDOutrosLayout = new javax.swing.GroupLayout(JPanelMenuCRUDOutros);
        JPanelMenuCRUDOutros.setLayout(JPanelMenuCRUDOutrosLayout);
        JPanelMenuCRUDOutrosLayout.setHorizontalGroup(
            JPanelMenuCRUDOutrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelMenuCRUDOutrosLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoVoltarCRUDOutros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoAdicionarCRUDOutros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoExcluirCRUDOutros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoEditarCRUDOutros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JPanelMenuCRUDOutrosLayout.setVerticalGroup(
            JPanelMenuCRUDOutrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelMenuCRUDOutrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPanelMenuCRUDOutrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botaoEditarCRUDOutros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoAdicionarCRUDOutros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoVoltarCRUDOutros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoExcluirCRUDOutros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                        .addComponent(JPanelMenuCRUDOutros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(labelDescriçãoOutros, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelDescriçãoOutros, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(JPanelMenuCRUDOutros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(TelaCRUDOutros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCRUDOutros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCRUDOutros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCRUDOutros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCRUDOutros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel JPanelMenuCRUDOutros;
    private javax.swing.JButton botaoAdicionarCRUDOutros;
    private javax.swing.JButton botaoEditarCRUDOutros;
    private javax.swing.JButton botaoExcluirCRUDOutros;
    private javax.swing.JButton botaoVoltarCRUDOutros;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelDescriçãoOutros;
    private javax.swing.JTable tabelaOutros;
    // End of variables declaration//GEN-END:variables
}