/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server.view;

import java.sql.*;

import java.util.ArrayList;

import javax.swing.*;

import javax.swing.table.DefaultTableCellRenderer;
import net.proteanit.sql.DbUtils;
import server.modelo.Autenticacao;
import server.modelo.Pizza;
import server.persistencia.Banco;

/**
 *
 * @author Gustavo
 */
public class TelaCRUDPizza extends javax.swing.JFrame {

    // Variável para armazenamento da tela principal.
    private TelaPrincipal janelaPrincipal;

    
    // Variável para armazenamento dos dados de autenticação do banco de dados.
    private Autenticacao autenticacaoServer;
    
    // Objeto para realização de operações no banco de dados.
    private Banco banco = new Banco();
    
    ArrayList<Pizza> pizzas = new ArrayList();
    
    /*
     Descrição: Construtor padrão da janela de CRUD Pizza.
     Parâmetros:
     Retorno:
     
     */
    public TelaCRUDPizza() {
        initComponents();
    }
    
    
    /*
     Descrição: Construtor completo da janela de CRUD de pizzas.
     Parâmetros: janelaPrincipal (Necessário para controle dos métodos da janela anterior)
     *          autenticacao (Necessário para realizar operações no banco de dados)
     Retorno:
     Data Última Alteração: 22/05/2014 
    */
    public TelaCRUDPizza(TelaPrincipal telaPrincipal, Autenticacao autenticacao) {
        this();
        this.setJanelaPrincipal(telaPrincipal);
        this.setAutenticacaoServer(autenticacao);
        this.getJanelaPrincipal().setEnabled(false);
        this.exibirPizzasCadastradas(autenticacaoServer);
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
     Descrição: Método para exibição das pizzas cadastrados
     Parâmetros:
     *           autenticacao (Necessário para acesso/consulta no banco de dados)
     Retorno:
     Data Última Alteração: 07/06/2014
     */
    public void exibirPizzasCadastradas(Autenticacao autenticacaoServer) {
        try {
            String query = null;
            //int indiceTabela = this.tabelaCardapio.getSelectedIndex();
            JTable tabelaPizzas = null;
            
            query = "SELECT p.descricao, pp.preco, pp.tamanho , pp.fatias FROM Produto AS p JOIN Pizza AS pp ON p.codigo = pp.codProduto";
            
            // Recuperação dos produtos cadastrados de acordo com a categoria selecionada
            Connection con = DriverManager.getConnection(this.getAutenticacaoServer().getCaminhoBanco(), this.getAutenticacaoServer().getUsuarioBanco(), this.getAutenticacaoServer().getUsuarioSenha());
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            tabelaPizzas = this.tabelaCRUDPizza;
            System.out.print(" HAHAHA LEPO LEPO ");
            
            // Formatação do modelo da tabela de exibição
            tabelaPizzas.setModel(DbUtils.resultSetToTableModel(rs));
            tabelaPizzas.setRowSelectionAllowed(true);

            // Exibição centralizada dos registros
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);

            // Formatação das colunas da tabela de exibição
            tabelaPizzas.getColumnModel().getColumn(0).setHeaderValue("Descrição");
            tabelaPizzas.getColumnModel().getColumn(1).setHeaderValue("Preço");
            tabelaPizzas.getColumnModel().getColumn(2).setHeaderValue("Tamanho");
            tabelaPizzas.getColumnModel().getColumn(3).setHeaderValue("Fatias");
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
        tabelaCRUDPizza = new javax.swing.JTable();
        labelImagemPizza = new javax.swing.JLabel();
        descricaoPizza = new javax.swing.JLabel();
        jPanelMenuCRUDPizzas = new javax.swing.JPanel();
        botaoExcluirCRUDPizzas = new javax.swing.JButton();
        botaoAdicionarCRUDPizzas = new javax.swing.JButton();
        botaoVoltarCRUDPizzas = new javax.swing.JButton();
        botaoEditarCRUDPizzas = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CRUD Pizza");
        setMaximumSize(new java.awt.Dimension(800, 500));
        setMinimumSize(new java.awt.Dimension(800, 500));
        setResizable(false);

        jScrollPane1.setViewportView(tabelaCRUDPizza);

        labelImagemPizza.setText("Imagem:");

        descricaoPizza.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        descricaoPizza.setText("Ingredientes:");

        botaoExcluirCRUDPizzas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/server/view/icones_CRUD/DeleterPizza.png"))); // NOI18N
        botaoExcluirCRUDPizzas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botaoExcluirCRUDPizzas.setBorderPainted(false);
        botaoExcluirCRUDPizzas.setContentAreaFilled(false);
        botaoExcluirCRUDPizzas.setMaximumSize(new java.awt.Dimension(63, 63));
        botaoExcluirCRUDPizzas.setMinimumSize(new java.awt.Dimension(63, 63));
        botaoExcluirCRUDPizzas.setPreferredSize(new java.awt.Dimension(63, 63));
        botaoExcluirCRUDPizzas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirCRUDPizzasActionPerformed(evt);
            }
        });

        botaoAdicionarCRUDPizzas.setForeground(new java.awt.Color(240, 240, 240));
        botaoAdicionarCRUDPizzas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/server/view/icones_CRUD/AdicionarPizza.png"))); // NOI18N
        botaoAdicionarCRUDPizzas.setBorderPainted(false);
        botaoAdicionarCRUDPizzas.setContentAreaFilled(false);
        botaoAdicionarCRUDPizzas.setMaximumSize(new java.awt.Dimension(63, 63));
        botaoAdicionarCRUDPizzas.setMinimumSize(new java.awt.Dimension(63, 63));
        botaoAdicionarCRUDPizzas.setPreferredSize(new java.awt.Dimension(63, 63));
        botaoAdicionarCRUDPizzas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAdicionarCRUDPizzasActionPerformed(evt);
            }
        });

        botaoVoltarCRUDPizzas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/server/view/icones_CRUD/voltar.png"))); // NOI18N
        botaoVoltarCRUDPizzas.setBorderPainted(false);
        botaoVoltarCRUDPizzas.setContentAreaFilled(false);
        botaoVoltarCRUDPizzas.setMaximumSize(new java.awt.Dimension(63, 63));
        botaoVoltarCRUDPizzas.setMinimumSize(new java.awt.Dimension(63, 63));
        botaoVoltarCRUDPizzas.setPreferredSize(new java.awt.Dimension(63, 63));
        botaoVoltarCRUDPizzas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarCRUDPizzasActionPerformed(evt);
            }
        });

        botaoEditarCRUDPizzas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/server/view/icones_CRUD/AtualizaPizza.png"))); // NOI18N
        botaoEditarCRUDPizzas.setBorderPainted(false);
        botaoEditarCRUDPizzas.setContentAreaFilled(false);
        botaoEditarCRUDPizzas.setDefaultCapable(false);
        botaoEditarCRUDPizzas.setMaximumSize(new java.awt.Dimension(63, 63));
        botaoEditarCRUDPizzas.setMinimumSize(new java.awt.Dimension(63, 63));
        botaoEditarCRUDPizzas.setPreferredSize(new java.awt.Dimension(63, 63));
        botaoEditarCRUDPizzas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoEditarCRUDPizzasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMenuCRUDPizzasLayout = new javax.swing.GroupLayout(jPanelMenuCRUDPizzas);
        jPanelMenuCRUDPizzas.setLayout(jPanelMenuCRUDPizzasLayout);
        jPanelMenuCRUDPizzasLayout.setHorizontalGroup(
            jPanelMenuCRUDPizzasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuCRUDPizzasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(botaoVoltarCRUDPizzas, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoAdicionarCRUDPizzas, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(botaoExcluirCRUDPizzas, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(botaoEditarCRUDPizzas, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(138, 138, 138))
        );
        jPanelMenuCRUDPizzasLayout.setVerticalGroup(
            jPanelMenuCRUDPizzasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuCRUDPizzasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMenuCRUDPizzasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botaoExcluirCRUDPizzas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoAdicionarCRUDPizzas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoVoltarCRUDPizzas, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoEditarCRUDPizzas, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(descricaoPizza)
                            .addComponent(labelImagemPizza, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(jPanelMenuCRUDPizzas, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(83, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelImagemPizza, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(descricaoPizza)
                        .addGap(105, 105, 105)
                        .addComponent(jPanelMenuCRUDPizzas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 478, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
    /*
     Descrição: Método para voltar a janela anterior.
     Parâmetros: 
     *           Evento de botão
     Retorno:
     Data Última Alteração: 22/05/2014 
    */
    private void botaoVoltarCRUDPizzasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarCRUDPizzasActionPerformed
        // TODO add your handling code here:
        this.getJanelaPrincipal().setVisible(true);
        this.getJanelaPrincipal().setEnabled(true);
        this.dispose();
    }//GEN-LAST:event_botaoVoltarCRUDPizzasActionPerformed

    private void botaoExcluirCRUDPizzasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirCRUDPizzasActionPerformed
       //System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_botaoExcluirCRUDPizzasActionPerformed

    private void botaoEditarCRUDPizzasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoEditarCRUDPizzasActionPerformed
        // TODO add your handling code here:
        this.exibirPizzasCadastradas(autenticacaoServer);
    }//GEN-LAST:event_botaoEditarCRUDPizzasActionPerformed

    private void botaoAdicionarCRUDPizzasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdicionarCRUDPizzasActionPerformed
        // TODO add your handling code here:
        TelaAdicionarPizzas addPizza = new TelaAdicionarPizzas(this, this.autenticacaoServer);
        addPizza.setVisible(true);
        this.setEnabled(false);
        addPizza.setLocationRelativeTo(null);
    }//GEN-LAST:event_botaoAdicionarCRUDPizzasActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCRUDPizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCRUDPizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCRUDPizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCRUDPizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCRUDPizza().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAdicionarCRUDPizzas;
    private javax.swing.JButton botaoEditarCRUDPizzas;
    private javax.swing.JButton botaoExcluirCRUDPizzas;
    private javax.swing.JButton botaoVoltarCRUDPizzas;
    private javax.swing.JLabel descricaoPizza;
    private javax.swing.JPanel jPanelMenuCRUDPizzas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelImagemPizza;
    private javax.swing.JTable tabelaCRUDPizza;
    // End of variables declaration//GEN-END:variables

    private Object getAutenticacao() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
