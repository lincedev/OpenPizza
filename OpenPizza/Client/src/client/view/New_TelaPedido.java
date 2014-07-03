/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client.view;

import client.control.Controle;
import client.model.Autenticacao;
import client.persistence.Banco;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author lince
 */
public class New_TelaPedido extends javax.swing.JFrame {

    private New_TelaPrincipal telaPrincipal;

    private Autenticacao autenticacao;
    
    private Controle controle;
    
    private int numeroDoPedido;
    
    /**
     * Creates new form New_TelaPedido
     */
    private New_TelaPedido() {
        initComponents();
    }
    
    public New_TelaPedido(New_TelaPrincipal telaPrincipal, Autenticacao autenticacao, Controle controle){
        this();
        this.setTelaPrincipal(telaPrincipal);
        this.setAutenticacao(autenticacao);
        this.setControle(controle);
        boolean preencherComboboxDasMesas = controle.preencherComboboxDasMesas(this.comboboxMesas, autenticacao);
        if(!preencherComboboxDasMesas){
            JOptionPane.showMessageDialog(null, "Não foi possível recuperar as mesas cadastradas.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public void formatarTabelaItensDoPedido(){
        this.labelNumeroDoPedido.setText(String.valueOf(this.getNumeroDoPedido()));
        this.controle.consultarItensDoPedido(this.tabelaItensDoPedido, getNumeroDoPedido(), this.getAutenticacao());

        DefaultTableCellRenderer centralizarLabel = new DefaultTableCellRenderer();
        centralizarLabel.setHorizontalAlignment(JLabel.CENTER);

        this.tabelaItensDoPedido.getColumnModel().getColumn(0).setHeaderValue("Produto");

        this.tabelaItensDoPedido.getColumnModel().getColumn(1).setHeaderValue("Tamanho");
        this.tabelaItensDoPedido.getColumnModel().getColumn(1).setPreferredWidth(12);
        this.tabelaItensDoPedido.getColumnModel().getColumn(1).setCellRenderer(centralizarLabel);

        this.tabelaItensDoPedido.getColumnModel().getColumn(2).setHeaderValue("Qtde");
        this.tabelaItensDoPedido.getColumnModel().getColumn(2).setCellRenderer(centralizarLabel);
        this.tabelaItensDoPedido.getColumnModel().getColumn(2).setPreferredWidth(6);

        this.tabelaItensDoPedido.getColumnModel().getColumn(3).setHeaderValue("Preço");
        this.tabelaItensDoPedido.getColumnModel().getColumn(3).setCellRenderer(centralizarLabel);
        this.tabelaItensDoPedido.getColumnModel().getColumn(3).setPreferredWidth(10);

        float valorDoPedido = this.controle.consultarValorDoPedido(getNumeroDoPedido(), this.getAutenticacao());
        this.labelTotalDoPedido.setText(String.valueOf(valorDoPedido));
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
        botaoFinalizar = new javax.swing.JButton();
        botaoFechar = new javax.swing.JButton();
        botaoCardapio = new javax.swing.JButton();
        painelItensDoPedido = new javax.swing.JScrollPane();
        tabelaItensDoPedido = new javax.swing.JTable();
        labelMesa = new javax.swing.JLabel();
        labelPedido = new javax.swing.JLabel();
        labelNumeroDoPedido = new javax.swing.JLabel();
        comboboxMesas = new javax.swing.JComboBox();
        labelTotal = new javax.swing.JLabel();
        labelTotalDoPedido = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("OpenPizza - Pedido");
        setMaximumSize(new java.awt.Dimension(400, 700));
        setMinimumSize(new java.awt.Dimension(400, 700));
        setResizable(false);

        painel.setMaximumSize(new java.awt.Dimension(400, 700));
        painel.setMinimumSize(new java.awt.Dimension(400, 700));
        painel.setPreferredSize(new java.awt.Dimension(400, 700));

        botaoFinalizar.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        botaoFinalizar.setText("Finalizar");
        botaoFinalizar.setEnabled(false);
        botaoFinalizar.setMaximumSize(new java.awt.Dimension(120, 40));
        botaoFinalizar.setMinimumSize(new java.awt.Dimension(120, 40));
        botaoFinalizar.setPreferredSize(new java.awt.Dimension(120, 40));
        botaoFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoFinalizarActionPerformed(evt);
            }
        });

        botaoFechar.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        botaoFechar.setText("Fechar");
        botaoFechar.setMaximumSize(new java.awt.Dimension(120, 40));
        botaoFechar.setMinimumSize(new java.awt.Dimension(120, 40));
        botaoFechar.setPreferredSize(new java.awt.Dimension(120, 40));
        botaoFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoFecharActionPerformed(evt);
            }
        });

        botaoCardapio.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        botaoCardapio.setText("Cardápio");
        botaoCardapio.setEnabled(false);
        botaoCardapio.setMaximumSize(new java.awt.Dimension(120, 40));
        botaoCardapio.setMinimumSize(new java.awt.Dimension(120, 40));
        botaoCardapio.setPreferredSize(new java.awt.Dimension(120, 40));
        botaoCardapio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCardapioActionPerformed(evt);
            }
        });

        tabelaItensDoPedido.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        tabelaItensDoPedido.setRowHeight(25);
        tabelaItensDoPedido.setRowMargin(5);
        painelItensDoPedido.setViewportView(tabelaItensDoPedido);

        labelMesa.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        labelMesa.setText("Mesa:");

        labelPedido.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        labelPedido.setText("Pedido:");

        labelNumeroDoPedido.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        labelNumeroDoPedido.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelNumeroDoPedido.setText("----------");

        comboboxMesas.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        comboboxMesas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione a mesa" }));
        comboboxMesas.setMaximumSize(new java.awt.Dimension(160, 40));
        comboboxMesas.setMinimumSize(new java.awt.Dimension(160, 40));
        comboboxMesas.setPreferredSize(new java.awt.Dimension(160, 40));
        comboboxMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxMesasActionPerformed(evt);
            }
        });

        labelTotal.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        labelTotal.setText("Total:");

        labelTotalDoPedido.setFont(new java.awt.Font("Cantarell", 1, 16)); // NOI18N
        labelTotalDoPedido.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        labelTotalDoPedido.setText("0.00");

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(painelItensDoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(painelLayout.createSequentialGroup()
                                .addComponent(labelMesa)
                                .addGap(4, 4, 4)
                                .addComponent(comboboxMesas, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(labelPedido)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelNumeroDoPedido)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLayout.createSequentialGroup()
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(painelLayout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(labelTotal)
                                .addGap(18, 18, 18)
                                .addComponent(labelTotalDoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20))
                            .addGroup(painelLayout.createSequentialGroup()
                                .addComponent(botaoCardapio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botaoFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(botaoFechar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(59, 59, 59))))
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelMesa)
                    .addComponent(labelPedido)
                    .addComponent(labelNumeroDoPedido)
                    .addComponent(comboboxMesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(painelItensDoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTotal)
                    .addComponent(labelTotalDoPedido))
                .addGap(31, 31, 31)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoFinalizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoFechar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoCardapio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painel, javax.swing.GroupLayout.PREFERRED_SIZE, 645, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 55, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoFecharActionPerformed
        // TODO add your handling code here:
        this.getTelaPrincipal().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botaoFecharActionPerformed

    private void botaoCardapioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCardapioActionPerformed
        // TODO add your handling code here:
        this.setVisible(false);
        New_TelaCardapio telaCardapio = new New_TelaCardapio(this, this.getAutenticacao(), this.getControle(), this.getNumeroDoPedido());
        telaCardapio.setIconImage(new ImageIcon("../Imagens/pedaco_pizza.png").getImage());
        telaCardapio.setVisible(true);
    }//GEN-LAST:event_botaoCardapioActionPerformed

    private void botaoFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoFinalizarActionPerformed
        // TODO add your handling code here:
        float valorDoPedido = this.getControle().consultarValorDoPedido(this.getNumeroDoPedido(), this.getAutenticacao());
        if(valorDoPedido > 0){
            int confirmacaoDeFinalizacao = JOptionPane.showConfirmDialog(null, "Deseja finalizar o pedido atual?\nEssa ação não poderá ser desfeita.", "Confirmação", JOptionPane.OK_CANCEL_OPTION);
            if(confirmacaoDeFinalizacao == JOptionPane.OK_OPTION){
                Object[] formaDePagamento = {"Dinheiro", "Cartão"};
                int opcaoDePagamento = JOptionPane.showOptionDialog(null, "Escolha a forma de pagamento:", "Forma de Pagamento", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, formaDePagamento, null);
                boolean finalizarPedido = this.getControle().finalizarPedido(this.getAutenticacao(), this.getNumeroDoPedido(), String.valueOf(formaDePagamento[opcaoDePagamento]), valorDoPedido);
                if(finalizarPedido){
                    JOptionPane.showMessageDialog(null, "Pedido finalizado com sucesso", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    this.comboboxMesas.setSelectedIndex(0);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Não foi possível finalizar o pedido atual.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
        else{
            int confirmacaoDeCancelamento = JOptionPane.showConfirmDialog(null, "O pedido atual não contém itens.\nDeseja cancelar o pedido?", "Cancelar Pedido", JOptionPane.OK_CANCEL_OPTION);
            if(confirmacaoDeCancelamento == JOptionPane.OK_OPTION){
                boolean cancelarPedido = this.getControle().cancelarPedido(this.getAutenticacao(), this.getNumeroDoPedido());
                if(cancelarPedido){
                    JOptionPane.showMessageDialog(null, "Pedido cancelado com sucesso.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    this.comboboxMesas.setSelectedIndex(0);
                }
                else{
                    JOptionPane.showMessageDialog(null, "Não foi possível cancelar o pedido atual.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }//GEN-LAST:event_botaoFinalizarActionPerformed

    private void comboboxMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxMesasActionPerformed
        // TODO add your handling code here:
        if(this.comboboxMesas.getSelectedIndex() > 0){
            this.tabelaItensDoPedido.setVisible(true);
            this.botaoCardapio.setEnabled(true);
            this.botaoFinalizar.setEnabled(true);
            int consultarNumeroDoPedido = this.controle.consultarNumeroDoPedido(this.comboboxMesas.getSelectedIndex(), this.getAutenticacao());
            this.setNumeroDoPedido(consultarNumeroDoPedido);
            if(this.getNumeroDoPedido() >= 0){
                this.formatarTabelaItensDoPedido();
            }
            else{
                this.botaoCardapio.setEnabled(false);
                int confirmacaoDeNovoPedido = JOptionPane.showConfirmDialog(null, "A mesa informada não tem pedido em aberto.\nDeseja abrir um novo pedido?", "Aviso", JOptionPane.OK_CANCEL_OPTION);
                if(confirmacaoDeNovoPedido == JOptionPane.OK_OPTION){
                    boolean inserirPedido = this.getControle().inserirPedido(this.comboboxMesas.getSelectedIndex(), this.getAutenticacao());
                    if(inserirPedido){
                        consultarNumeroDoPedido = this.controle.consultarNumeroDoPedido(this.comboboxMesas.getSelectedIndex(), this.getAutenticacao());
                        this.setNumeroDoPedido(consultarNumeroDoPedido);
                        this.getControle().consultarItensDoPedido(this.tabelaItensDoPedido, getNumeroDoPedido(), this.getAutenticacao());
                        this.formatarTabelaItensDoPedido();
                        this.botaoCardapio.setEnabled(true);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Não foi possível inserir um novo pedido.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else{
                    this.comboboxMesas.setSelectedIndex(0);
                }
            }
        }
        else{
            this.labelNumeroDoPedido.setText("----------");
            this.tabelaItensDoPedido.setVisible(false);
            this.labelTotalDoPedido.setText("0.00");
            this.botaoCardapio.setEnabled(false);
            this.botaoFinalizar.setEnabled(false);
        }
    }//GEN-LAST:event_comboboxMesasActionPerformed

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
            java.util.logging.Logger.getLogger(New_TelaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(New_TelaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(New_TelaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(New_TelaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new New_TelaPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCardapio;
    private javax.swing.JButton botaoFechar;
    private javax.swing.JButton botaoFinalizar;
    private javax.swing.JComboBox comboboxMesas;
    private javax.swing.JLabel labelMesa;
    private javax.swing.JLabel labelNumeroDoPedido;
    private javax.swing.JLabel labelPedido;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JLabel labelTotalDoPedido;
    private javax.swing.JPanel painel;
    private javax.swing.JScrollPane painelItensDoPedido;
    private javax.swing.JTable tabelaItensDoPedido;
    // End of variables declaration//GEN-END:variables

    public New_TelaPrincipal getTelaPrincipal() {
        return telaPrincipal;
    }

    public void setTelaPrincipal(New_TelaPrincipal telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
    }

    public Autenticacao getAutenticacao() {
        return autenticacao;
    }

    public void setAutenticacao(Autenticacao autenticacao) {
        this.autenticacao = autenticacao;
    }

    public Controle getControle() {
        return controle;
    }

    public void setControle(Controle controle) {
        this.controle = controle;
    }

    public int getNumeroDoPedido() {
        return numeroDoPedido;
    }

    public void setNumeroDoPedido(int numeroDoPedido) {
        this.numeroDoPedido = numeroDoPedido;
    }
}