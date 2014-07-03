/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client.view;

import client.control.Controle;
import client.model.Autenticacao;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author lince
 */
public class New_TelaIncluirProduto extends javax.swing.JFrame {

    private New_TelaCardapio telaCardapio;
    
    private Autenticacao autenticacao;
    
    private Controle controle;
    
    private String categoriaDoProduto;
    
    private String nomeDoProduto;
    
    private int numeroDoPedido;
    
    /**
     * Creates new form New_TelaIncluirPizza
     */
    private New_TelaIncluirProduto() {
        initComponents();
    }

    public New_TelaIncluirProduto(New_TelaCardapio telaCardapio, Controle controle, Autenticacao autenticacao, String categoriaDoProduto, String nomeDoProduto, int numeroDoPedido){
        this();
        this.setTelaCardapio(telaCardapio);
        this.setControle(controle);
        this.setAutenticacao(autenticacao);
        this.setCategoriaDoProduto(categoriaDoProduto);
        this.setNomeDoProduto(nomeDoProduto);
        this.setNumeroDoPedido(numeroDoPedido);
        this.labelNomeProduto.setText(this.getNomeDoProduto());
        this.getControle().consultarOpcoesDoProduto(this.tabelaOpcoesDisponiveis, this.getAutenticacao(), this.getCategoriaDoProduto(), this.getNomeDoProduto());
        this.formatarTabelaDeOpcoesDisponiveis();
    }
    
    public void formatarTabelaDeOpcoesDisponiveis(){
        // Exibição centralizada dos registros
        DefaultTableCellRenderer centralizarLabel = new DefaultTableCellRenderer();
        centralizarLabel.setHorizontalAlignment(JLabel.CENTER);

        // Formatação dos campos da tabela
        // Campo de código do produto (Invisível ao usuário, mas necessário para inserção do produto no pedido)
        this.tabelaOpcoesDisponiveis.getColumnModel().getColumn(0).setMaxWidth(0);
        this.tabelaOpcoesDisponiveis.getColumnModel().getColumn(0).setMinWidth(0);
        this.tabelaOpcoesDisponiveis.getColumnModel().getColumn(0).setPreferredWidth(0);
        if(this.getCategoriaDoProduto().equals("Pizza")){
            
            // Campo de tamanho da pizza
            this.tabelaOpcoesDisponiveis.getColumnModel().getColumn(1).setHeaderValue("Tamanho");

            // Campo de número de fatias da pizza
            this.tabelaOpcoesDisponiveis.getColumnModel().getColumn(2).setHeaderValue("Fatias");
            this.tabelaOpcoesDisponiveis.getColumnModel().getColumn(2).setCellRenderer(centralizarLabel);

            // Campo de preço da pizza
            this.tabelaOpcoesDisponiveis.getColumnModel().getColumn(3).setHeaderValue("Preço");
            this.tabelaOpcoesDisponiveis.getColumnModel().getColumn(3).setCellRenderer(centralizarLabel);
        }
        else{
            this.tabelaOpcoesDisponiveis.getColumnModel().getColumn(1).setHeaderValue("Descrição");
            
            this.tabelaOpcoesDisponiveis.getColumnModel().getColumn(2).setHeaderValue("Preço");
            this.tabelaOpcoesDisponiveis.getColumnModel().getColumn(2).setCellRenderer(centralizarLabel);
        }
        
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
        labelProduto = new javax.swing.JLabel();
        labelOpcoesDisponiveis = new javax.swing.JLabel();
        labelQuantidade = new javax.swing.JLabel();
        labelIngredientes = new javax.swing.JLabel();
        labelFoto = new javax.swing.JLabel();
        labelNomeProduto = new javax.swing.JLabel();
        textFieldQuantidade = new javax.swing.JTextField();
        botaoIncluir = new javax.swing.JButton();
        botaoFechar = new javax.swing.JButton();
        painelOpcoesDisponiveis = new javax.swing.JScrollPane();
        tabelaOpcoesDisponiveis = new javax.swing.JTable();
        painelIngredientes = new javax.swing.JScrollPane();
        textoIngredientes = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("OpenPizza - Incluir Produto");
        setMaximumSize(new java.awt.Dimension(400, 700));
        setMinimumSize(new java.awt.Dimension(400, 700));
        setPreferredSize(new java.awt.Dimension(400, 700));
        setResizable(false);

        labelProduto.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        labelProduto.setText("Produto:");

        labelOpcoesDisponiveis.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        labelOpcoesDisponiveis.setText("Opções Disponíveis:");

        labelQuantidade.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        labelQuantidade.setText("Quantidade:");

        labelIngredientes.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        labelIngredientes.setText("Ingredientes:");

        labelFoto.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        labelFoto.setText("Foto:");

        labelNomeProduto.setFont(new java.awt.Font("Cantarell", 1, 16)); // NOI18N
        labelNomeProduto.setText("---");

        textFieldQuantidade.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        textFieldQuantidade.setEnabled(false);
        textFieldQuantidade.setMaximumSize(new java.awt.Dimension(120, 40));
        textFieldQuantidade.setMinimumSize(new java.awt.Dimension(120, 40));
        textFieldQuantidade.setName(""); // NOI18N
        textFieldQuantidade.setPreferredSize(new java.awt.Dimension(120, 40));
        textFieldQuantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                textFieldQuantidadeKeyReleased(evt);
            }
        });

        botaoIncluir.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        botaoIncluir.setText("Incluir");
        botaoIncluir.setEnabled(false);
        botaoIncluir.setMaximumSize(new java.awt.Dimension(120, 40));
        botaoIncluir.setMinimumSize(new java.awt.Dimension(120, 40));
        botaoIncluir.setPreferredSize(new java.awt.Dimension(120, 40));
        botaoIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoIncluirActionPerformed(evt);
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

        tabelaOpcoesDisponiveis.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        tabelaOpcoesDisponiveis.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabelaOpcoesDisponiveis.setRowHeight(25);
        tabelaOpcoesDisponiveis.setRowMargin(5);
        tabelaOpcoesDisponiveis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaOpcoesDisponiveisMouseClicked(evt);
            }
        });
        painelOpcoesDisponiveis.setViewportView(tabelaOpcoesDisponiveis);

        textoIngredientes.setColumns(20);
        textoIngredientes.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        textoIngredientes.setLineWrap(true);
        textoIngredientes.setRows(10);
        textoIngredientes.setTabSize(1);
        painelIngredientes.setViewportView(textoIngredientes);

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLayout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(botaoIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                        .addComponent(botaoFechar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(46, 46, 46))
                    .addGroup(painelLayout.createSequentialGroup()
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelLayout.createSequentialGroup()
                                .addComponent(labelProduto)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(labelNomeProduto))
                            .addComponent(labelOpcoesDisponiveis))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(painelLayout.createSequentialGroup()
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(painelIngredientes, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(painelLayout.createSequentialGroup()
                                .addComponent(labelQuantidade)
                                .addGap(11, 11, 11)
                                .addComponent(textFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(labelIngredientes)
                            .addComponent(painelOpcoesDisponiveis, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelFoto))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelProduto)
                    .addComponent(labelNomeProduto))
                .addGap(32, 32, 32)
                .addComponent(labelOpcoesDisponiveis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelOpcoesDisponiveis, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelQuantidade))
                .addGap(18, 18, 18)
                .addComponent(labelIngredientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelIngredientes, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(labelFoto)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 130, Short.MAX_VALUE)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoFechar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(45, 45, 45))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoFecharActionPerformed
        // TODO add your handling code here:
        this.getTelaCardapio().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botaoFecharActionPerformed

    private void botaoIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoIncluirActionPerformed
        // TODO add your handling code here:
        String quantidade = this.textFieldQuantidade.getText();
        int codigoDoProduto = (Integer) this.tabelaOpcoesDisponiveis.getValueAt(this.tabelaOpcoesDisponiveis.getSelectedRow(), 0);
        if((quantidade.length() > 0) && (Integer.parseInt(quantidade) > 0)){
            
            int confirmarInclusao = JOptionPane.showConfirmDialog(null, "Deseja incluir o item na quantidade selecionada?\nEssa operação não poderá ser desfeita.", "Aviso", JOptionPane.OK_CANCEL_OPTION);
            if(confirmarInclusao == JOptionPane.OK_OPTION){
                boolean consultarProdutoNoPedido = this.getControle().consultarProdutoNoPedido(this.getAutenticacao(), this.getNumeroDoPedido(), codigoDoProduto);
                if(consultarProdutoNoPedido){
                    boolean atualizarQuantidadeDoProdutoNoPedido = this.getControle().atualizarQuantidadeDoProdutoNoPedido(this.getAutenticacao(), this.getNumeroDoPedido(), this.getCategoriaDoProduto(),  codigoDoProduto, Integer.parseInt(quantidade));
                    if(atualizarQuantidadeDoProdutoNoPedido){
                        JOptionPane.showMessageDialog(null, "Produto inserido com sucesso.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Não foi possível atualizar a quantidade do produto selecionado.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
                else{
                    boolean inserirProduto = false;
                    if(this.getCategoriaDoProduto().equals("Pizza")){
                        String tamanho = (String) this.tabelaOpcoesDisponiveis.getValueAt(this.tabelaOpcoesDisponiveis.getSelectedRow(), 1);
                        float preco = (Float) this.tabelaOpcoesDisponiveis.getValueAt(this.tabelaOpcoesDisponiveis.getSelectedRow(), 3);
                        inserirProduto = this.getControle().inserirProduto(this.getAutenticacao(), this.getNumeroDoPedido(), codigoDoProduto, Integer.parseInt(quantidade), tamanho, preco);
                    }
                    else{
                        float preco = (Float) this.tabelaOpcoesDisponiveis.getValueAt(this.tabelaOpcoesDisponiveis.getSelectedRow(), 2);
                        inserirProduto = this.getControle().inserirProduto(this.getAutenticacao(), this.getNumeroDoPedido(), codigoDoProduto, Integer.parseInt(quantidade), "-", preco);
                    }

                    if(inserirProduto){
                        JOptionPane.showMessageDialog(null, "Produto inserido com sucesso.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "Não foi possível inserir o produto selecionado.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
                this.getTelaCardapio().setVisible(true);
                this.dispose();
            }
        }
    }//GEN-LAST:event_botaoIncluirActionPerformed

    private void tabelaOpcoesDisponiveisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaOpcoesDisponiveisMouseClicked
        // TODO add your handling code here:
        this.textFieldQuantidade.setEnabled(true);
        int codigoDoProduto = (Integer) this.tabelaOpcoesDisponiveis.getValueAt(this.tabelaOpcoesDisponiveis.getSelectedRow(), 0);
        if(this.getCategoriaDoProduto().equals("Pizza")){
            this.getControle().consultarIngredientes(this.textoIngredientes, this.getAutenticacao(), this.getCategoriaDoProduto(), codigoDoProduto);
        }
        if(this.getCategoriaDoProduto().equals("Lanche")){
            this.getControle().consultarIngredientes(this.textoIngredientes, this.getAutenticacao(), this.getCategoriaDoProduto(), codigoDoProduto);
        }
    }//GEN-LAST:event_tabelaOpcoesDisponiveisMouseClicked

    private void textFieldQuantidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldQuantidadeKeyReleased
        // TODO add your handling code here:
        try{
            int quantidade = Integer.parseInt(this.textFieldQuantidade.getText());
            if(quantidade > 0){
            this.botaoIncluir.setEnabled(true);
            }
        }
        catch(Exception e){
            this.botaoIncluir.setEnabled(false);
            this.textFieldQuantidade.setText(null);
        }
    }//GEN-LAST:event_textFieldQuantidadeKeyReleased

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
            java.util.logging.Logger.getLogger(New_TelaIncluirProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(New_TelaIncluirProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(New_TelaIncluirProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(New_TelaIncluirProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new New_TelaIncluirProduto().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoFechar;
    private javax.swing.JButton botaoIncluir;
    private javax.swing.JLabel labelFoto;
    private javax.swing.JLabel labelIngredientes;
    private javax.swing.JLabel labelNomeProduto;
    private javax.swing.JLabel labelOpcoesDisponiveis;
    private javax.swing.JLabel labelProduto;
    private javax.swing.JLabel labelQuantidade;
    private javax.swing.JPanel painel;
    private javax.swing.JScrollPane painelIngredientes;
    private javax.swing.JScrollPane painelOpcoesDisponiveis;
    private javax.swing.JTable tabelaOpcoesDisponiveis;
    private javax.swing.JTextField textFieldQuantidade;
    private javax.swing.JTextArea textoIngredientes;
    // End of variables declaration//GEN-END:variables

    public New_TelaCardapio getTelaCardapio() {
        return telaCardapio;
    }

    public void setTelaCardapio(New_TelaCardapio telaCardapio) {
        this.telaCardapio = telaCardapio;
    }

    public String getNomeDoProduto() {
        return nomeDoProduto;
    }

    public void setNomeDoProduto(String nomeDoProduto) {
        this.nomeDoProduto = nomeDoProduto;
    }

    public Controle getControle() {
        return controle;
    }

    public void setControle(Controle controle) {
        this.controle = controle;
    }

    public Autenticacao getAutenticacao() {
        return autenticacao;
    }

    public void setAutenticacao(Autenticacao autenticacao) {
        this.autenticacao = autenticacao;
    }

    public int getNumeroDoPedido() {
        return numeroDoPedido;
    }

    public void setNumeroDoPedido(int numeroDoPedido) {
        this.numeroDoPedido = numeroDoPedido;
    }

    public String getCategoriaDoProduto() {
        return categoriaDoProduto;
    }

    public void setCategoriaDoProduto(String categoriaDoProduto) {
        this.categoriaDoProduto = categoriaDoProduto;
    }
}
