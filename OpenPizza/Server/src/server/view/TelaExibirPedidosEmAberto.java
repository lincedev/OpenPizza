/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server.view;

import javax.swing.JLabel;
import javax.swing.table.DefaultTableCellRenderer;
import server.controle.Controle;
import server.modelo.Autenticacao;
import server.persistencia.Banco;

/**
 *
 * @author Gustavo
 */
public class TelaExibirPedidosEmAberto extends javax.swing.JFrame {

    /**
     * Creates new form pedidosEmAberto
     */
    // Variável para armazenamento da tela principal.
    private TelaPrincipal janelaPrincipal;

    
    // Variável para armazenamento dos dados de autenticação do banco de dados.
    private Autenticacao autenticacaoServer;
    
    
    /*
     Descrição: Construtor padrão da janela de CRUD Pizza.
     Parâmetros:
     Retorno:
     
     */
    private TelaExibirPedidosEmAberto() {
        initComponents();
    }
    
    /*
     Descrição: Construtor completo da janela de CRUD de pizzas.
     Parâmetros: janelaPrincipal (Necessário para controle dos métodos da janela anterior)
     *          autenticacao (Necessário para realizar operações no banco de dados)
     Retorno:
     Data Última Alteração: 24/05/2014 
    */
    public TelaExibirPedidosEmAberto(TelaPrincipal janelaPrincipal, Autenticacao autenticacaoServer) {
        this();
        this.setAutenticacaoServer(autenticacaoServer);
        this.setJanelaPrincipal(janelaPrincipal);
        this.botaoAtualizarActionPerformed(null);
        this.formatarTabelaPedidosEmAberto();
    }

    /*
     Descrição: Método set para a variável janelaPrincipal.
     Parâmetros: 
     *           janelaPrincipal (Necessário para controle dos métodos da janela principal)
     Retorno:
     Data Última Alteração: 24/05/2014
    */
    public void setJanelaPrincipal(TelaPrincipal janelaPrincipal) {
        this.janelaPrincipal = janelaPrincipal;
    }
    
    /*
     Descrição: Método get para a variável janelaPrincipal
     Parâmetros:
     Retorno:
     *           janelaPrincipal (Necessário para controle dos métodos da janela anterior)
     Data Última Alteração: 24/05/2014 
    */
    public TelaPrincipal getJanelaPrincipal() {
        return janelaPrincipal;
    }
    
    /*
     Descrição: Método set para a variável autenticação.
     Parâmetros: 
     *           autenticacao (Caminho para o banco de dados)
     Retorno:
     Data Última Alteração: 24/05/2014 
    */
    public void setAutenticacaoServer(Autenticacao autenticacaoServer) {
        this.autenticacaoServer = autenticacaoServer;
    }
    
    /*
     Descrição: Método get para a variável autenticação
     Parâmetros:
     Retorno: 
     *           autenticacao (Objeto do tipo Autenticação com os dados de acesso ao banco de dados)
    Data Última Alteração: 24/05/2014 
    */
    public Autenticacao getAutenticacaoServer() {
        return autenticacaoServer;
    }
    
    public void formatarTabelaPedidosEmAberto(){
        
        DefaultTableCellRenderer centralizarLabel = new DefaultTableCellRenderer();
        centralizarLabel.setHorizontalAlignment(JLabel.CENTER);
        
        this.tabelaPedidosEmAberto.getColumnModel().getColumn(0).setHeaderValue("Nº");
        this.tabelaPedidosEmAberto.getColumnModel().getColumn(0).setCellRenderer(centralizarLabel);
        
        this.tabelaPedidosEmAberto.getColumnModel().getColumn(1).setHeaderValue("Mesa");
        this.tabelaPedidosEmAberto.getColumnModel().getColumn(1).setCellRenderer(centralizarLabel);
        
        this.tabelaPedidosEmAberto.getColumnModel().getColumn(2).setHeaderValue("Data");
        this.tabelaPedidosEmAberto.getColumnModel().getColumn(2).setCellRenderer(centralizarLabel);
        
        this.tabelaPedidosEmAberto.getColumnModel().getColumn(3).setHeaderValue("Início");
        this.tabelaPedidosEmAberto.getColumnModel().getColumn(3).setCellRenderer(centralizarLabel);
        
        this.tabelaPedidosEmAberto.getColumnModel().getColumn(4).setHeaderValue("Fim");
        this.tabelaPedidosEmAberto.getColumnModel().getColumn(4).setCellRenderer(centralizarLabel);
        
        this.tabelaPedidosEmAberto.getColumnModel().getColumn(5).setHeaderValue("Valor");
        this.tabelaPedidosEmAberto.getColumnModel().getColumn(5).setCellRenderer(centralizarLabel);
        
        this.tabelaPedidosEmAberto.getColumnModel().getColumn(6).setHeaderValue("Pagamento");
        this.tabelaPedidosEmAberto.getColumnModel().getColumn(6).setCellRenderer(centralizarLabel);
        
        this.tabelaPedidosEmAberto.getColumnModel().getColumn(7).setMaxWidth(0);
        this.tabelaPedidosEmAberto.getColumnModel().getColumn(7).setMinWidth(0);
        this.tabelaPedidosEmAberto.getColumnModel().getColumn(7).setPreferredWidth(0);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painel = new javax.swing.JPanel();
        painelTabela = new javax.swing.JScrollPane();
        tabelaPedidosEmAberto = new javax.swing.JTable();
        botãoVoltar = new javax.swing.JButton();
        botaoAtualizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("OpenPizza - Pedidos Em Aberto");
        setMinimumSize(new java.awt.Dimension(800, 500));
        setResizable(false);

        painel.setMaximumSize(new java.awt.Dimension(800, 500));
        painel.setMinimumSize(new java.awt.Dimension(800, 500));
        painel.setPreferredSize(new java.awt.Dimension(800, 500));

        tabelaPedidosEmAberto.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        tabelaPedidosEmAberto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabelaPedidosEmAberto.setRowHeight(25);
        tabelaPedidosEmAberto.setRowMargin(5);
        painelTabela.setViewportView(tabelaPedidosEmAberto);

        botãoVoltar.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        botãoVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/server/view/icones_CRUD/voltar.png"))); // NOI18N
        botãoVoltar.setText("Voltar");
        botãoVoltar.setMaximumSize(new java.awt.Dimension(130, 80));
        botãoVoltar.setMinimumSize(new java.awt.Dimension(130, 80));
        botãoVoltar.setPreferredSize(new java.awt.Dimension(130, 80));
        botãoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botãoVoltarActionPerformed(evt);
            }
        });

        botaoAtualizar.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        botaoAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/server/view/icones_CRUD/AtualizaPizza.png"))); // NOI18N
        botaoAtualizar.setText("Atualizar");
        botaoAtualizar.setMaximumSize(new java.awt.Dimension(130, 80));
        botaoAtualizar.setMinimumSize(new java.awt.Dimension(130, 80));
        botaoAtualizar.setPreferredSize(new java.awt.Dimension(130, 80));
        botaoAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAtualizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(botãoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28))
            .addGroup(painelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelTabela, javax.swing.GroupLayout.DEFAULT_SIZE, 776, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 354, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botãoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.PREFERRED_SIZE, 458, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botãoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botãoVoltarActionPerformed
        // TODO add your handling code here:
        this.getJanelaPrincipal().setEnabled(true);
        this.dispose();
    }//GEN-LAST:event_botãoVoltarActionPerformed

    private void botaoAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAtualizarActionPerformed
        // TODO add your handling code here:
        Controle controle = new Controle();
        controle.exibirPedidosEmAberto(this.getAutenticacaoServer(), this.tabelaPedidosEmAberto);
        
    }//GEN-LAST:event_botaoAtualizarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaExibirPedidosEmAberto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaExibirPedidosEmAberto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaExibirPedidosEmAberto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaExibirPedidosEmAberto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaExibirPedidosEmAberto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAtualizar;
    private javax.swing.JButton botãoVoltar;
    private javax.swing.JPanel painel;
    private javax.swing.JScrollPane painelTabela;
    private javax.swing.JTable tabelaPedidosEmAberto;
    // End of variables declaration//GEN-END:variables
}
