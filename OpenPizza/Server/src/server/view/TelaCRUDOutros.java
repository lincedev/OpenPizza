/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import net.proteanit.sql.DbUtils;
import server.controle.Controle;
import server.modelo.Autenticacao;
import server.persistencia.Banco;

/**
 *
 * @author Gustavo
 */
public class TelaCRUDOutros extends javax.swing.JFrame {

    /**
     * Creates new form TelaCRUDOutros
     */
    
    private Controle controle;
     // Variável para armazenamento da tela principal.
    private TelaPrincipal janelaPrincipal;

    // Variável para armazenamento dos dados de autenticação do banco de dados.
    private Autenticacao autenticacaoServer;    
    
    /*
     Descrição: Construtor padrão da janela de CRUD Outros.
     Parâmetros:
     Retorno:
     Data Última Alteração: 22/05/2014
     */
    public TelaCRUDOutros() {
        initComponents();
    }
    
    /*
     Descrição: Construtor completo da janela de CRUD de pizzas.
     Parâmetros: janelaPrincipal (Necessário para controle dos métodos da janela anterior)
     *          autenticacao (Necessário para realizar operações no banco de dados)
     Retorno:
     Data Última Alteração: 22/05/2014 
    */
    public TelaCRUDOutros(TelaPrincipal janelaPrincipal, Autenticacao autenticacaoServer) {
        this();
        this.setJanelaPrincipal(janelaPrincipal);        
        this.getJanelaPrincipal().setEnabled(false);
        controle = new Controle();
        controle.exibirOutrosCadastrados(this.autenticacaoServer, this.tabelaCRUDOutros);
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /*
     Descrição: Método set para a variável janelaPrincipal.
     Parâmetros: 
     *           janelaPrincipal (Necessário para controle dos métodos da janela principal)
     Retorno:
     Data Última Alteração: 22/05/2014
    */
    public void setJanelaPrincipal(TelaPrincipal janelaPrincipal) {
        this.janelaPrincipal = janelaPrincipal;
    }
    
    /*
     Descrição: Método get para a variável janelaPrincipal
     Parâmetros:
     Retorno:
     *           janelaPrincipal (Necessário para controle dos métodos da janela anterior)
     Data Última Alteração: 22/05/2014 
    */
    public TelaPrincipal getJanelaPrincipal() {
        return janelaPrincipal;
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
        tabelaCRUDOutros = new javax.swing.JTable();
        labelDescriçãoOutros = new javax.swing.JLabel();
        JPanelMenuCRUDOutros = new javax.swing.JPanel();
        botaoAdicionarCRUDOutros = new javax.swing.JButton();
        botaoExcluirCRUDOutros = new javax.swing.JButton();
        botaoVoltarCRUDOutros = new javax.swing.JButton();
        botaoEditarCRUDOutros = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CRUD Outros");
        setMaximumSize(new java.awt.Dimension(540, 400));
        setMinimumSize(new java.awt.Dimension(540, 400));
        setPreferredSize(new java.awt.Dimension(540, 400));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        tabelaCRUDOutros.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jScrollPane1.setViewportView(tabelaCRUDOutros);

        labelDescriçãoOutros.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelDescriçãoOutros.setText("Descrição: ");

        botaoAdicionarCRUDOutros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/server/view/icones_CRUD/AdicionarPizza.png"))); // NOI18N
        botaoAdicionarCRUDOutros.setBorderPainted(false);
        botaoAdicionarCRUDOutros.setContentAreaFilled(false);
        botaoAdicionarCRUDOutros.setMaximumSize(new java.awt.Dimension(63, 63));
        botaoAdicionarCRUDOutros.setMinimumSize(new java.awt.Dimension(63, 63));
        botaoAdicionarCRUDOutros.setPreferredSize(new java.awt.Dimension(63, 63));
        botaoAdicionarCRUDOutros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAdicionarCRUDOutrosActionPerformed(evt);
            }
        });

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
        botaoVoltarCRUDOutros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarCRUDOutrosActionPerformed(evt);
            }
        });

        botaoEditarCRUDOutros.setIcon(new javax.swing.ImageIcon(getClass().getResource("/server/view/icones_CRUD/AtualizaPizza.png"))); // NOI18N
        botaoEditarCRUDOutros.setBorderPainted(false);
        botaoEditarCRUDOutros.setContentAreaFilled(false);
        botaoEditarCRUDOutros.setMaximumSize(new java.awt.Dimension(63, 63));
        botaoEditarCRUDOutros.setMinimumSize(new java.awt.Dimension(63, 63));
        botaoEditarCRUDOutros.setPreferredSize(new java.awt.Dimension(63, 63));
        botaoEditarCRUDOutros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEditarCRUDOutrosActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Voltar");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Adicionar");

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Excluir");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Atualizar");

        javax.swing.GroupLayout JPanelMenuCRUDOutrosLayout = new javax.swing.GroupLayout(JPanelMenuCRUDOutros);
        JPanelMenuCRUDOutros.setLayout(JPanelMenuCRUDOutrosLayout);
        JPanelMenuCRUDOutrosLayout.setHorizontalGroup(
            JPanelMenuCRUDOutrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelMenuCRUDOutrosLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(JPanelMenuCRUDOutrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoVoltarCRUDOutros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JPanelMenuCRUDOutrosLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPanelMenuCRUDOutrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoAdicionarCRUDOutros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JPanelMenuCRUDOutrosLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPanelMenuCRUDOutrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoExcluirCRUDOutros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(JPanelMenuCRUDOutrosLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPanelMenuCRUDOutrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(JPanelMenuCRUDOutrosLayout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel4))
                    .addComponent(botaoEditarCRUDOutros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        JPanelMenuCRUDOutrosLayout.setVerticalGroup(
            JPanelMenuCRUDOutrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(JPanelMenuCRUDOutrosLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(JPanelMenuCRUDOutrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botaoEditarCRUDOutros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoAdicionarCRUDOutros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoVoltarCRUDOutros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoExcluirCRUDOutros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(JPanelMenuCRUDOutrosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(labelDescriçãoOutros, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(119, 119, 119)
                        .addComponent(JPanelMenuCRUDOutros, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(123, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelDescriçãoOutros, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(JPanelMenuCRUDOutros, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
             
    private void botaoVoltarCRUDOutrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarCRUDOutrosActionPerformed
        // TODO add your handling code here:
        this.getJanelaPrincipal().setVisible(true);
        this.getJanelaPrincipal().setEnabled(true);
        this.dispose();
    }//GEN-LAST:event_botaoVoltarCRUDOutrosActionPerformed

    private void botaoAdicionarCRUDOutrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdicionarCRUDOutrosActionPerformed
        // TODO add your handling code here:
        TelaAdicionarOutros addOutros = new TelaAdicionarOutros(this, this.autenticacaoServer);
        addOutros.setVisible(true);
        addOutros.setEnabled(true);
        this.setEnabled(false);
        addOutros.setLocationRelativeTo(null);
    }//GEN-LAST:event_botaoAdicionarCRUDOutrosActionPerformed

    private void botaoEditarCRUDOutrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarCRUDOutrosActionPerformed
        controle.exibirOutrosCadastrados(this.autenticacaoServer, this.tabelaCRUDOutros);
    }//GEN-LAST:event_botaoEditarCRUDOutrosActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        this.dispose();
        this.getJanelaPrincipal().setEnabled(true);
    }//GEN-LAST:event_formWindowClosed

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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelDescriçãoOutros;
    private javax.swing.JTable tabelaCRUDOutros;
    // End of variables declaration//GEN-END:variables
}
