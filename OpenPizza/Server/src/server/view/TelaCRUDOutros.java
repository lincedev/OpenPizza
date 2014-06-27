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
 * @author Gustavo
 */
public class TelaCRUDOutros extends javax.swing.JFrame {

    /**
     * Creates new form TelaCRUDOutros
     */
    
     // Variável para armazenamento da tela principal.
    private TelaPrincipal janelaPrincipal;

    // Variável para armazenamento dos dados de autenticação do banco de dados.
    private Autenticacao autenticacaoServer;
    
    // Objeto para realização de operações no banco de dados.
    private Banco banco = new Banco();
    
    
    
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
        this.setAutenticacaoServer(autenticacaoServer);
        this.exibirOutrosCadastrados(autenticacaoServer);
        this.getJanelaPrincipal().setEnabled(false);
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

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CRUD Outros");
        setMaximumSize(new java.awt.Dimension(800, 500));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jScrollPane1.setViewportView(tabelaOutros);

        labelDescriçãoOutros.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
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

    /*
     Descrição: Método para exibição de Outros cadastrados
     Parâmetros:
     *           autenticacao (Necessário para acesso/consulta no banco de dados)
     Retorno:      
     Data Última Alteração: 07/06/2014 
    */
    public void exibirOutrosCadastrados(Autenticacao autenticacaoServer) {
        try {
            String query = null;
            //int indiceTabela = this.tabelaCardapio.getSelectedIndex();
            JTable tabelaOutros = null;
            
            query = "SELECT p.descricao, o.preco FROM Produto AS p JOIN Outros AS o ON p.codigo = o.codProduto";
            
            // Recuperação dos produtos cadastrados de acordo com a categoria selecionada
            Connection con = DriverManager.getConnection(this.getAutenticacaoServer().getCaminhoBanco(), this.getAutenticacaoServer().getUsuarioBanco(), this.getAutenticacaoServer().getUsuarioSenha());
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            tabelaOutros = this.tabelaOutros;
            
            // Formatação do modelo da tabela de exibição
            tabelaOutros.setModel(DbUtils.resultSetToTableModel(rs));
            tabelaOutros.setRowSelectionAllowed(true);

            // Exibição centralizada dos registros
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);

            // Formatação das colunas da tabela de exibição
            tabelaOutros.getColumnModel().getColumn(0).setHeaderValue("Descrição");
            tabelaOutros.getColumnModel().getColumn(1).setHeaderValue("Preço");
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
        this.exibirOutrosCadastrados(autenticacaoServer);
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelDescriçãoOutros;
    private javax.swing.JTable tabelaOutros;
    // End of variables declaration//GEN-END:variables
}
