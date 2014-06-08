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
import server.modelo.Autenticacao;
import server.persistencia.Banco;

/**
 *
 * @author Gustavo(buzaLOCO)
 */
public class TelaCRUDLanches extends javax.swing.JFrame {

    /**
     * Creates new form TelaCRUDLanches
     */
    
    // Variável para armazenamento da tela principal.
    private TelaPrincipal janelaPrincipal;

    
    // Variável para armazenamento dos dados de autenticação do banco de dados.
    private Autenticacao autenticacaoServer;
    
    // Objeto para realização de operações no banco de dados.
    private Banco banco = new Banco();
    
   /*
     Descrição: Construtor padrão da janela de CRUD Lanches.
     Parâmetros:
     Retorno:
     Data Última Alteração: 22/05/2014
     */
    public TelaCRUDLanches() {
        initComponents();
    }
    
    /*
     Descrição: Construtor completo da janela de CRUD de Lanches.
     Parâmetros: janelaPrincipal (Necessário para controle dos métodos da janela anterior)
     *          autenticacao (Necessário para realizar operações no banco de dados)
     Retorno:
     Data Última Alteração: 22/05/2014 
    */
    public TelaCRUDLanches(TelaPrincipal janelaPrincipal, Autenticacao autenticacaoServer) {
        this();
        this.setJanelaPrincipal(janelaPrincipal);
        this.setAutenticacaoServer(autenticacaoServer);
        this.getJanelaPrincipal().setEnabled(false);
        this.exibirLanchesCadastrados(autenticacaoServer);
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
    
    /*
     Descrição: Método set para a variável autenticação.
     Parâmetros: 
     *           autenticacao (Caminho para o banco de dados)
     Retorno:
     Data Última Alteração: 22/05/2014 
    */
    public void setAutenticacaoServer(Autenticacao autenticacaoServer) {
        this.autenticacaoServer = autenticacaoServer;
    }
    
    /*
     Descrição: Método get para a variável autenticação
     Parâmetros:
     Retorno: 
     *           autenticacao (Objeto do tipo Autenticação com os dados de acesso ao banco de dados)
    Data Última Alteração: 22/05/2014 
    */
    public Autenticacao getAutenticacaoServer() {
        return autenticacaoServer;
    }

    /*
     Descrição: Método para exibição dos Lanches cadastrados
     Parâmetros:
     *           autenticacao (Necessário para acesso/consulta no banco de dados)
     Retorno:
     Data Última Alteração: 07/06/2014
     */
    public void exibirLanchesCadastrados(Autenticacao autenticacaoServer) {
        try {
            String query = null;
            //int indiceTabela = this.tabelaCardapio.getSelectedIndex();
            JTable tabelaLanches = null;
            
            query = "SELECT p.descricao, l.preco FROM Produto AS p JOIN Lanche AS l ON p.codigo = l.codProduto";
            
            // Recuperação dos produtos cadastrados de acordo com a categoria selecionada
            Connection con = DriverManager.getConnection(this.getAutenticacaoServer().getCaminhoBanco(), this.getAutenticacaoServer().getUsuarioBanco(), this.getAutenticacaoServer().getUsuarioSenha());
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            tabelaLanches = this.tabelaCRUDLanches;
            
            System.out.print(" HAHAHA LEPO LEPO ");
            
            // Formatação do modelo da tabela de exibição
            tabelaLanches.setModel(DbUtils.resultSetToTableModel(rs));
            tabelaLanches.setRowSelectionAllowed(true);

            // Exibição centralizada dos registros
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);

            // Formatação das colunas da tabela de exibição
            tabelaLanches.getColumnModel().getColumn(0).setHeaderValue("Descrição");
            tabelaLanches.getColumnModel().getColumn(1).setHeaderValue("Preço");
            //tabelaOutros.getColumnModel().getColumn(2).setHeaderValue("Tamanho");
            //tabelaOutros.getColumnModel().getColumn(3).setHeaderValue("Fatias");
            //tabelaPizzas.getColumnModel().getColumn(4).setHeaderValue("Ingredientes");

            // Formatação das demais tabelas de produtos (Lanches, Bebidas, Outros)
            //if (indiceTabela != 0) {
            //    tabela.getColumnModel().getColumn(1).setHeaderValue("Preço");
            //    tabela.getColumnModel().getColumn(1).setMaxWidth(70);
            //    tabela.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
            //}

            con.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível exibir as pizzas cadastrados.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    /*
     Descrição: Método disparado ao fechar a janela no botão |X|.
     Parâmetros:
     Retorno:
     */
    private void formWindowClosed(java.awt.event.WindowEvent evt) {                                  
        // Habilitar tela anterior e fechar tela atual
        this.getJanelaPrincipal().setEnabled(true);
        this.dispose();
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
        tabelaCRUDLanches = new javax.swing.JTable();
        labelDescriçãoLanches = new javax.swing.JLabel();
        jPanelMenuCRUDLanches = new javax.swing.JPanel();
        botaoAdicionarCRUDLanches = new javax.swing.JButton();
        botaoExcluirCRUDLanches = new javax.swing.JButton();
        botaoEditarCRUDLanches = new javax.swing.JButton();
        botaoVoltarCRUDLanches = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CRUD Lanches");
        setMaximumSize(new java.awt.Dimension(800, 500));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setResizable(false);

        jScrollPane1.setViewportView(tabelaCRUDLanches);

        labelDescriçãoLanches.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelDescriçãoLanches.setText("Descrição:");

        jPanelMenuCRUDLanches.setPreferredSize(new java.awt.Dimension(353, 85));

        botaoAdicionarCRUDLanches.setIcon(new javax.swing.ImageIcon(getClass().getResource("/server/view/icones_CRUD/AdicionarPizza.png"))); // NOI18N
        botaoAdicionarCRUDLanches.setBorderPainted(false);
        botaoAdicionarCRUDLanches.setContentAreaFilled(false);
        botaoAdicionarCRUDLanches.setMaximumSize(new java.awt.Dimension(63, 63));
        botaoAdicionarCRUDLanches.setMinimumSize(new java.awt.Dimension(63, 63));
        botaoAdicionarCRUDLanches.setPreferredSize(new java.awt.Dimension(63, 63));
        botaoAdicionarCRUDLanches.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAdicionarCRUDLanchesActionPerformed(evt);
            }
        });

        botaoExcluirCRUDLanches.setIcon(new javax.swing.ImageIcon(getClass().getResource("/server/view/icones_CRUD/DeleterPizza.png"))); // NOI18N
        botaoExcluirCRUDLanches.setBorderPainted(false);
        botaoExcluirCRUDLanches.setContentAreaFilled(false);
        botaoExcluirCRUDLanches.setMaximumSize(new java.awt.Dimension(63, 63));
        botaoExcluirCRUDLanches.setMinimumSize(new java.awt.Dimension(63, 63));
        botaoExcluirCRUDLanches.setPreferredSize(new java.awt.Dimension(63, 63));

        botaoEditarCRUDLanches.setIcon(new javax.swing.ImageIcon(getClass().getResource("/server/view/icones_CRUD/AtualizaPizza.png"))); // NOI18N
        botaoEditarCRUDLanches.setContentAreaFilled(false);
        botaoEditarCRUDLanches.setMaximumSize(new java.awt.Dimension(63, 63));
        botaoEditarCRUDLanches.setMinimumSize(new java.awt.Dimension(63, 63));
        botaoEditarCRUDLanches.setPreferredSize(new java.awt.Dimension(63, 63));
        botaoEditarCRUDLanches.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEditarCRUDLanchesActionPerformed(evt);
            }
        });

        botaoVoltarCRUDLanches.setIcon(new javax.swing.ImageIcon(getClass().getResource("/server/view/icones_CRUD/voltar.png"))); // NOI18N
        botaoVoltarCRUDLanches.setBorderPainted(false);
        botaoVoltarCRUDLanches.setContentAreaFilled(false);
        botaoVoltarCRUDLanches.setMaximumSize(new java.awt.Dimension(63, 63));
        botaoVoltarCRUDLanches.setMinimumSize(new java.awt.Dimension(63, 63));
        botaoVoltarCRUDLanches.setPreferredSize(new java.awt.Dimension(63, 63));
        botaoVoltarCRUDLanches.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarCRUDLanchesActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMenuCRUDLanchesLayout = new javax.swing.GroupLayout(jPanelMenuCRUDLanches);
        jPanelMenuCRUDLanches.setLayout(jPanelMenuCRUDLanchesLayout);
        jPanelMenuCRUDLanchesLayout.setHorizontalGroup(
            jPanelMenuCRUDLanchesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuCRUDLanchesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoVoltarCRUDLanches, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoAdicionarCRUDLanches, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoExcluirCRUDLanches, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoEditarCRUDLanches, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelMenuCRUDLanchesLayout.setVerticalGroup(
            jPanelMenuCRUDLanchesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuCRUDLanchesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMenuCRUDLanchesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoEditarCRUDLanches, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoVoltarCRUDLanches, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoAdicionarCRUDLanches, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoExcluirCRUDLanches, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addComponent(jPanelMenuCRUDLanches, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(89, 89, 89))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(labelDescriçãoLanches, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelDescriçãoLanches, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelMenuCRUDLanches, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoVoltarCRUDLanchesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarCRUDLanchesActionPerformed
        // TODO add your handling code here:
        this.getJanelaPrincipal().setVisible(true);
        this.getJanelaPrincipal().setEnabled(true);
        this.dispose();
    }//GEN-LAST:event_botaoVoltarCRUDLanchesActionPerformed

    private void botaoAdicionarCRUDLanchesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdicionarCRUDLanchesActionPerformed
        // TODO add your handling code here:
        TelaAdicionarLanches addLanche = new TelaAdicionarLanches(this,this.autenticacaoServer);
        addLanche.setVisible(true);
        this.setEnabled(false);
        addLanche.setLocationRelativeTo(null);
    }//GEN-LAST:event_botaoAdicionarCRUDLanchesActionPerformed

    private void botaoEditarCRUDLanchesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarCRUDLanchesActionPerformed
        // TODO add your handling code here:
        this.exibirLanchesCadastrados(autenticacaoServer);
    }//GEN-LAST:event_botaoEditarCRUDLanchesActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCRUDLanches.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCRUDLanches.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCRUDLanches.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCRUDLanches.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCRUDLanches().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAdicionarCRUDLanches;
    private javax.swing.JButton botaoEditarCRUDLanches;
    private javax.swing.JButton botaoExcluirCRUDLanches;
    private javax.swing.JButton botaoVoltarCRUDLanches;
    private javax.swing.JPanel jPanelMenuCRUDLanches;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelDescriçãoLanches;
    private javax.swing.JTable tabelaCRUDLanches;
    // End of variables declaration//GEN-END:variables
}
