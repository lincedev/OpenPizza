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

/**
 *
 * @author Gustavo
 */
public class TelaCRUDPizzas extends javax.swing.JFrame {

    // Variável para armazenamento da tela principal.
    private TelaPrincipal janelaPrincipal;

    private Controle controle;
    
    // Variável para armazenamento dos dados de autenticação do banco de dados.
    private Autenticacao autenticacaoServer;
      
    /*
     Descrição: Construtor padrão da janela de CRUD Pizza.
     Parâmetros:
     Retorno:
     
     */
    public TelaCRUDPizzas() {
        initComponents();                                
    }
    
    
    /*
     Descrição: Construtor completo da janela de CRUD de pizzas.
     Parâmetros: janelaPrincipal (Necessário para controle dos métodos da janela anterior)
     *          autenticacao (Necessário para realizar operações no banco de dados)
     Retorno:
     Data Última Alteração: 22/05/2014 
    */
    public TelaCRUDPizzas(TelaPrincipal telaPrincipal, Autenticacao autenticacaoServer, Controle controle) {                
        this();                        
        this.setJanelaPrincipal(telaPrincipal);
        this.setAutenticacaoServer(autenticacaoServer);
        this.setControle(controle);
        this.botaoAtualizarActionPerformed(null);
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

        jTabbedPane1 = new javax.swing.JTabbedPane();
        painel = new javax.swing.JPanel();
        painelPizzas = new javax.swing.JScrollPane();
        tabelaCRUDPizza = new javax.swing.JTable();
        descricaoPizza = new javax.swing.JLabel();
        jPanelMenuCRUDPizzas = new javax.swing.JPanel();
        botaoExcluir = new javax.swing.JButton();
        botaoAdicionar = new javax.swing.JButton();
        botaoVoltar = new javax.swing.JButton();
        botaoAtualizar = new javax.swing.JButton();
        labelAtualizar = new javax.swing.JLabel();
        labelExcluir = new javax.swing.JLabel();
        labelVoltar = new javax.swing.JLabel();
        labelAdicionar = new javax.swing.JLabel();
        textoIngredientes = new javax.swing.JScrollPane();
        textAreaIngredientes = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("CRUD Pizza");
        setMaximumSize(new java.awt.Dimension(540, 400));
        setMinimumSize(new java.awt.Dimension(540, 400));
        setPreferredSize(new java.awt.Dimension(540, 400));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        tabelaCRUDPizza.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        tabelaCRUDPizza.setRowHeight(25);
        tabelaCRUDPizza.setRowMargin(5);
        tabelaCRUDPizza.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaCRUDPizzaMouseClicked(evt);
            }
        });
        painelPizzas.setViewportView(tabelaCRUDPizza);

        descricaoPizza.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        descricaoPizza.setText("Ingredientes:");

        botaoExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/server/view/icones_CRUD/DeleterPizza.png"))); // NOI18N
        botaoExcluir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        botaoExcluir.setBorderPainted(false);
        botaoExcluir.setContentAreaFilled(false);
        botaoExcluir.setMaximumSize(new java.awt.Dimension(63, 63));
        botaoExcluir.setMinimumSize(new java.awt.Dimension(63, 63));
        botaoExcluir.setPreferredSize(new java.awt.Dimension(63, 63));
        botaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirActionPerformed(evt);
            }
        });

        botaoAdicionar.setForeground(new java.awt.Color(240, 240, 240));
        botaoAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/server/view/icones_CRUD/AdicionarPizza.png"))); // NOI18N
        botaoAdicionar.setBorderPainted(false);
        botaoAdicionar.setContentAreaFilled(false);
        botaoAdicionar.setMaximumSize(new java.awt.Dimension(63, 63));
        botaoAdicionar.setMinimumSize(new java.awt.Dimension(63, 63));
        botaoAdicionar.setPreferredSize(new java.awt.Dimension(63, 63));
        botaoAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAdicionarActionPerformed(evt);
            }
        });

        botaoVoltar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/server/view/icones_CRUD/voltar.png"))); // NOI18N
        botaoVoltar.setBorderPainted(false);
        botaoVoltar.setContentAreaFilled(false);
        botaoVoltar.setMaximumSize(new java.awt.Dimension(63, 63));
        botaoVoltar.setMinimumSize(new java.awt.Dimension(63, 63));
        botaoVoltar.setPreferredSize(new java.awt.Dimension(63, 63));
        botaoVoltar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarActionPerformed(evt);
            }
        });

        botaoAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/server/view/icones_CRUD/AtualizaPizza.png"))); // NOI18N
        botaoAtualizar.setBorderPainted(false);
        botaoAtualizar.setContentAreaFilled(false);
        botaoAtualizar.setDefaultCapable(false);
        botaoAtualizar.setMaximumSize(new java.awt.Dimension(63, 63));
        botaoAtualizar.setMinimumSize(new java.awt.Dimension(63, 63));
        botaoAtualizar.setPreferredSize(new java.awt.Dimension(63, 63));
        botaoAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAtualizarActionPerformed(evt);
            }
        });

        labelAtualizar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        labelAtualizar.setText("Atualizar");

        labelExcluir.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        labelExcluir.setText("Excluir");

        labelVoltar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        labelVoltar.setText("Voltar");

        labelAdicionar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        labelAdicionar.setText("Adicionar");

        javax.swing.GroupLayout jPanelMenuCRUDPizzasLayout = new javax.swing.GroupLayout(jPanelMenuCRUDPizzas);
        jPanelMenuCRUDPizzas.setLayout(jPanelMenuCRUDPizzasLayout);
        jPanelMenuCRUDPizzasLayout.setHorizontalGroup(
            jPanelMenuCRUDPizzasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuCRUDPizzasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMenuCRUDPizzasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMenuCRUDPizzasLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(labelVoltar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(labelAdicionar))
                    .addGroup(jPanelMenuCRUDPizzasLayout.createSequentialGroup()
                        .addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMenuCRUDPizzasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanelMenuCRUDPizzasLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(labelExcluir)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelMenuCRUDPizzasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(botaoAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelAtualizar)))
        );
        jPanelMenuCRUDPizzasLayout.setVerticalGroup(
            jPanelMenuCRUDPizzasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuCRUDPizzasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelMenuCRUDPizzasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoVoltar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelMenuCRUDPizzasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelVoltar)
                    .addComponent(labelAdicionar)
                    .addComponent(labelExcluir)
                    .addComponent(labelAtualizar))
                .addContainerGap())
        );

        textAreaIngredientes.setColumns(20);
        textAreaIngredientes.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        textAreaIngredientes.setLineWrap(true);
        textAreaIngredientes.setRows(5);
        textoIngredientes.setViewportView(textAreaIngredientes);

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(textoIngredientes))
                    .addGroup(painelLayout.createSequentialGroup()
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelLayout.createSequentialGroup()
                                .addGap(97, 97, 97)
                                .addComponent(jPanelMenuCRUDPizzas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painelLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(descricaoPizza, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 125, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(painelPizzas, javax.swing.GroupLayout.PREFERRED_SIZE, 517, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addContainerGap(191, Short.MAX_VALUE)
                .addComponent(descricaoPizza, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textoIngredientes, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(8, 8, 8)
                .addComponent(jPanelMenuCRUDPizzas, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(painelPizzas, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(253, Short.MAX_VALUE)))
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
            .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents
   
       
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        this.dispose();
        this.getJanelaPrincipal().setEnabled(true);
    }//GEN-LAST:event_formWindowClosed

    private void botaoAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAtualizarActionPerformed
        // Talves seja necessário colocar o método de testarAutenticação
        //controle.exibirPizzasCadastradas(this.autenticacaoServer, this.tabelaCRUDPizza);
        this.getControle().exibirProdutos(this.getAutenticacaoServer(), tabelaCRUDPizza, "Pizza");
        
        DefaultTableCellRenderer centralizarLabel = new DefaultTableCellRenderer();
        centralizarLabel.setHorizontalAlignment(JLabel.CENTER);
        
        this.tabelaCRUDPizza.getColumnModel().getColumn(0).setHeaderValue("Produto");
        this.tabelaCRUDPizza.getColumnModel().getColumn(0).setCellRenderer(centralizarLabel);
        this.tabelaCRUDPizza.getColumnModel().getColumn(0).setMinWidth(120);
        
        this.tabelaCRUDPizza.getColumnModel().getColumn(1).setHeaderValue("Preço");
        this.tabelaCRUDPizza.getColumnModel().getColumn(1).setCellRenderer(centralizarLabel);
        
        this.tabelaCRUDPizza.getColumnModel().getColumn(2).setHeaderValue("Tamanho");
        this.tabelaCRUDPizza.getColumnModel().getColumn(2).setCellRenderer(centralizarLabel);
        
        this.tabelaCRUDPizza.getColumnModel().getColumn(3).setHeaderValue("Fatias");
        this.tabelaCRUDPizza.getColumnModel().getColumn(3).setCellRenderer(centralizarLabel);
    }//GEN-LAST:event_botaoAtualizarActionPerformed

    /*
     Descrição: Método para voltar a janela anterior.
     Parâmetros: 
     *           Evento de botão
     Retorno:
    
     Data Última Alteração: 22/05/2014 
    */
    private void botaoVoltarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_botaoVoltarActionPerformed

    private void botaoAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdicionarActionPerformed
        TelaAdicionarPizzas addPizza = new TelaAdicionarPizzas(this, this.getAutenticacaoServer());
        addPizza.setVisible(true);
    }//GEN-LAST:event_botaoAdicionarActionPerformed

    private void botaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirActionPerformed
        //
    }//GEN-LAST:event_botaoExcluirActionPerformed

    private void tabelaCRUDPizzaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaCRUDPizzaMouseClicked
        // TODO add your handling code here:
        String nomeDoProduto = String.valueOf(this.tabelaCRUDPizza.getValueAt(this.tabelaCRUDPizza.getSelectedRow(), 0));
        this.getControle().consultarIngredientes(this.textAreaIngredientes, this.getAutenticacaoServer(), "Pizza", nomeDoProduto);
    }//GEN-LAST:event_tabelaCRUDPizzaMouseClicked

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
            java.util.logging.Logger.getLogger(TelaCRUDPizzas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCRUDPizzas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCRUDPizzas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCRUDPizzas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCRUDPizzas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAdicionar;
    private javax.swing.JButton botaoAtualizar;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoVoltar;
    private javax.swing.JLabel descricaoPizza;
    private javax.swing.JPanel jPanelMenuCRUDPizzas;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JLabel labelAdicionar;
    private javax.swing.JLabel labelAtualizar;
    private javax.swing.JLabel labelExcluir;
    private javax.swing.JLabel labelVoltar;
    private javax.swing.JPanel painel;
    private javax.swing.JScrollPane painelPizzas;
    private javax.swing.JTable tabelaCRUDPizza;
    private javax.swing.JTextArea textAreaIngredientes;
    private javax.swing.JScrollPane textoIngredientes;
    // End of variables declaration//GEN-END:variables

    public Controle getControle() {
        return controle;
    }

    public void setControle(Controle controle) {
        this.controle = controle;
    }

    public Autenticacao getAutenticacaoServer() {
        return autenticacaoServer;
    }

    public void setAutenticacaoServer(Autenticacao autenticacaoServer) {
        this.autenticacaoServer = autenticacaoServer;
    }
}
