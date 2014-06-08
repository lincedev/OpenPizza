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
public class TelaCRUDBebidas extends javax.swing.JFrame {

    /**
     * Creates new form TelaCRUDBebidas
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
    public TelaCRUDBebidas() {
        initComponents();
    }
    
    /*
     Descrição: Construtor completo da janela de CRUD de Lanches.
     Parâmetros: janelaPrincipal (Necessário para controle dos métodos da janela anterior)
     *          autenticacao (Necessário para realizar operações no banco de dados)
     Retorno:
     Data Última Alteração: 22/05/2014 
    */
    TelaCRUDBebidas(TelaPrincipal janelaPrincipal, Autenticacao autenticacaoServer) {
        this();
        this.setJanelaPrincipal(janelaPrincipal);
        this.setAutenticacaoServer(autenticacaoServer);
        this.getJanelaPrincipal().setEnabled(false);
        this.exibirBebidasCadastrados(autenticacaoServer);
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
     Descrição: Método para exibição das Bebidas cadastradas
     Parâmetros:
     *           autenticacao (Necessário para acesso/consulta no banco de dados)
     Retorno:
     Data Última Alteração: 07/06/2014
     */
    public void exibirBebidasCadastrados(Autenticacao autenticacaoServer) {
        try {
            String query = null;
            //int indiceTabela = this.tabelaCardapio.getSelectedIndex();
            JTable tabelaBebidas = null;
            
            query = "SELECT p.descricao, b.preco FROM Produto AS p JOIN Bebidas AS b ON p.codigo = b.codProduto";
            
            // Recuperação dos produtos cadastrados de acordo com a categoria selecionada
            Connection con = DriverManager.getConnection(this.getAutenticacaoServer().getCaminhoBanco(), this.getAutenticacaoServer().getUsuarioBanco(), this.getAutenticacaoServer().getUsuarioSenha());
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            tabelaBebidas = this.tabelaCRUDBebidas;
            System.out.print(" HAHAHA LEPO LEPO ");
            
            // Formatação do modelo da tabela de exibição
            tabelaBebidas.setModel(DbUtils.resultSetToTableModel(rs));
            tabelaBebidas.setRowSelectionAllowed(true);

            // Exibição centralizada dos registros
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);

            // Formatação das colunas da tabela de exibição
            tabelaBebidas.getColumnModel().getColumn(0).setHeaderValue("Descrição");
            tabelaBebidas.getColumnModel().getColumn(1).setHeaderValue("Preço");
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
        tabelaCRUDBebidas = new javax.swing.JTable();
        labelDescriçãoBebidas = new javax.swing.JLabel();
        jPanelMenuCRUDBebidas = new javax.swing.JPanel();
        botaoAdicionarCRUDBebidas = new javax.swing.JButton();
        botaoExcluirCRUDBebidas = new javax.swing.JButton();
        botaoVoltarCRUDBebidas = new javax.swing.JButton();
        botatoEditarCRUDBebidas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CRUD Bebidas");
        setMaximumSize(new java.awt.Dimension(800, 500));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setPreferredSize(new java.awt.Dimension(800, 500));
        setResizable(false);

        jScrollPane1.setViewportView(tabelaCRUDBebidas);

        labelDescriçãoBebidas.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        labelDescriçãoBebidas.setText("Descrição:");

        jPanelMenuCRUDBebidas.setPreferredSize(new java.awt.Dimension(353, 85));

        botaoAdicionarCRUDBebidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/server/view/icones_CRUD/AdicionarPizza.png"))); // NOI18N
        botaoAdicionarCRUDBebidas.setContentAreaFilled(false);
        botaoAdicionarCRUDBebidas.setDefaultCapable(false);
        botaoAdicionarCRUDBebidas.setMaximumSize(new java.awt.Dimension(63, 63));
        botaoAdicionarCRUDBebidas.setMinimumSize(new java.awt.Dimension(63, 63));
        botaoAdicionarCRUDBebidas.setPreferredSize(new java.awt.Dimension(63, 63));
        botaoAdicionarCRUDBebidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAdicionarCRUDBebidasActionPerformed(evt);
            }
        });

        botaoExcluirCRUDBebidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/server/view/icones_CRUD/DeleterPizza.png"))); // NOI18N
        botaoExcluirCRUDBebidas.setBorderPainted(false);
        botaoExcluirCRUDBebidas.setContentAreaFilled(false);
        botaoExcluirCRUDBebidas.setMaximumSize(new java.awt.Dimension(63, 63));
        botaoExcluirCRUDBebidas.setMinimumSize(new java.awt.Dimension(63, 63));
        botaoExcluirCRUDBebidas.setPreferredSize(new java.awt.Dimension(63, 63));
        botaoExcluirCRUDBebidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirCRUDBebidasActionPerformed(evt);
            }
        });

        botaoVoltarCRUDBebidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/server/view/icones_CRUD/voltar.png"))); // NOI18N
        botaoVoltarCRUDBebidas.setBorderPainted(false);
        botaoVoltarCRUDBebidas.setContentAreaFilled(false);
        botaoVoltarCRUDBebidas.setMaximumSize(new java.awt.Dimension(63, 63));
        botaoVoltarCRUDBebidas.setMinimumSize(new java.awt.Dimension(63, 63));
        botaoVoltarCRUDBebidas.setPreferredSize(new java.awt.Dimension(63, 63));
        botaoVoltarCRUDBebidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarCRUDBebidasActionPerformed(evt);
            }
        });

        botatoEditarCRUDBebidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/server/view/icones_CRUD/AtualizaPizza.png"))); // NOI18N
        botatoEditarCRUDBebidas.setBorderPainted(false);
        botatoEditarCRUDBebidas.setContentAreaFilled(false);
        botatoEditarCRUDBebidas.setMaximumSize(new java.awt.Dimension(63, 63));
        botatoEditarCRUDBebidas.setMinimumSize(new java.awt.Dimension(63, 63));
        botatoEditarCRUDBebidas.setPreferredSize(new java.awt.Dimension(63, 63));
        botatoEditarCRUDBebidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botatoEditarCRUDBebidasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMenuCRUDBebidasLayout = new javax.swing.GroupLayout(jPanelMenuCRUDBebidas);
        jPanelMenuCRUDBebidas.setLayout(jPanelMenuCRUDBebidasLayout);
        jPanelMenuCRUDBebidasLayout.setHorizontalGroup(
            jPanelMenuCRUDBebidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuCRUDBebidasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoVoltarCRUDBebidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoAdicionarCRUDBebidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoExcluirCRUDBebidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botatoEditarCRUDBebidas, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(57, 57, 57))
        );
        jPanelMenuCRUDBebidasLayout.setVerticalGroup(
            jPanelMenuCRUDBebidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanelMenuCRUDBebidasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMenuCRUDBebidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMenuCRUDBebidasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(botaoAdicionarCRUDBebidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botaoVoltarCRUDBebidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(botatoEditarCRUDBebidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(botaoExcluirCRUDBebidas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addGap(30, 30, 30)
                        .addComponent(labelDescriçãoBebidas, javax.swing.GroupLayout.PREFERRED_SIZE, 142, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 97, Short.MAX_VALUE)
                        .addComponent(jPanelMenuCRUDBebidas, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(83, 83, 83))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 467, Short.MAX_VALUE)
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelDescriçãoBebidas, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanelMenuCRUDBebidas, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoVoltarCRUDBebidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarCRUDBebidasActionPerformed
        // TODO add your handling code here:
        this.getJanelaPrincipal().setVisible(true);
        this.getJanelaPrincipal().setEnabled(true);
        this.dispose();
    }//GEN-LAST:event_botaoVoltarCRUDBebidasActionPerformed

    private void botaoExcluirCRUDBebidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirCRUDBebidasActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoExcluirCRUDBebidasActionPerformed

    private void botaoAdicionarCRUDBebidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdicionarCRUDBebidasActionPerformed
        // TODO add your handling code here:
        TelaAdicionarBebidas addBebida = new TelaAdicionarBebidas(this,this.autenticacaoServer);
        addBebida.setVisible(true);
        this.setEnabled(false);
        addBebida.setLocationRelativeTo(null);
    }//GEN-LAST:event_botaoAdicionarCRUDBebidasActionPerformed

    private void botatoEditarCRUDBebidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botatoEditarCRUDBebidasActionPerformed
        // TODO add your handling code here:
        this.exibirBebidasCadastrados(autenticacaoServer);
    }//GEN-LAST:event_botatoEditarCRUDBebidasActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCRUDBebidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCRUDBebidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCRUDBebidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCRUDBebidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCRUDBebidas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAdicionarCRUDBebidas;
    private javax.swing.JButton botaoExcluirCRUDBebidas;
    private javax.swing.JButton botaoVoltarCRUDBebidas;
    private javax.swing.JButton botatoEditarCRUDBebidas;
    private javax.swing.JPanel jPanelMenuCRUDBebidas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelDescriçãoBebidas;
    private javax.swing.JTable tabelaCRUDBebidas;
    // End of variables declaration//GEN-END:variables
}
