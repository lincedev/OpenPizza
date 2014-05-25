
package client.view;

import client.modelo.*;
import client.persistencia.*;
import java.util.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import net.proteanit.sql.DbUtils;

public class TelaInformacoesPizza extends javax.swing.JFrame {

    private final Banco banco = new Banco();
    
    private Autenticacao autenticacao;
    
    private TelaCardapio telaCardapio;

    private int indiceCardapioEscolhido;
    
    private int indiceProdutoEscolhido;
    
    private Pedido infoPedido;

    private String tamanhoPizza;

    private int quantidade;

    
    
    ArrayList<Pizza> pizzas = new ArrayList();
    
    ArrayList<Lanche> lanches = new ArrayList();
    
    ArrayList<Bebidas> bebidas = new ArrayList();
    
    ArrayList<Outros> outros = new ArrayList();
    
    /**
     * Creates new form TelaInformacoesProduto
     */
    private TelaInformacoesPizza() {
        initComponents();
    }

    public TelaInformacoesPizza(TelaCardapio telaCardapio, Autenticacao autenticacao, int indiceCardapioEscolhido, int indiceProdutoEscolhido, Pedido infoPedido){
        this();
        this.setTelaCardapio(telaCardapio);
        this.setAutenticacao(autenticacao);
        this.setIndiceCardapioEscolhido(indiceCardapioEscolhido);
        this.setIndiceProdutoEscolhido(indiceProdutoEscolhido);
        this.setInfoPedido(infoPedido);
        this.getTelaCardapio().setEnabled(false);
        exibirInformacoes();
    }
    
    public Autenticacao getAutenticacao() {
        return autenticacao;
    }

    public void setAutenticacao(Autenticacao autenticacao) {
        this.autenticacao = autenticacao;
    }
    
    public int getIndiceCardapioEscolhido() {
        return indiceCardapioEscolhido;
    }
    
    public TelaCardapio getTelaCardapio() {
        return telaCardapio;
    }

    public void setTelaCardapio(TelaCardapio telaCardapio) {
        this.telaCardapio = telaCardapio;
    }

    public void setIndiceCardapioEscolhido(int indiceCardapioEscolhido) {
        this.indiceCardapioEscolhido = indiceCardapioEscolhido;
    }
    
    public int getIndiceProdutoEscolhido() {
        return indiceProdutoEscolhido;
    }

    public void setIndiceProdutoEscolhido(int indiceProdutoEscolhido) {
        this.indiceProdutoEscolhido = indiceProdutoEscolhido;
    }
    
    public Pedido getInfoPedido() {
        return infoPedido;
    }

    public void setInfoPedido(Pedido infoPedido) {
        this.infoPedido = infoPedido;
    }
    
    public String getTamanhoPizza() {
        return tamanhoPizza;
    }

    public void setTamanhoPizza(String tamanhoPizza) {
        this.tamanhoPizza = tamanhoPizza;
    }
    
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    public void exibirInformacoes(){
        try{
            // Recuperação de dados das pizzas
            if(this.getIndiceCardapioEscolhido() == 0){
                pizzas = banco.consultarInfoPizzas(this.getAutenticacao());
                this.labelNomePizza.setText(pizzas.get(this.getIndiceProdutoEscolhido()).getDescricao());
                this.textIngredientes.setText(pizzas.get(this.getIndiceProdutoEscolhido()).getIngredientesPizza());
                
                Connection con = DriverManager.getConnection(this.getAutenticacao().getCaminhoBanco(), this.getAutenticacao().getUsuarioBanco(), this.getAutenticacao().getUsuarioSenha());
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery("SELECT P.codigo, PZ.tamanho, PZ.fatias, PZ.preco FROM Pizza AS PZ JOIN Produto AS P ON PZ.codProduto = P.codigo WHERE P.descricao LIKE '" + pizzas.get(this.getIndiceProdutoEscolhido()).getDescricao() + "'");
                
                this.textoOpcoesDisponiveis.setModel(DbUtils.resultSetToTableModel(rs));
                
                // Exibição centralizada dos registros
                DefaultTableCellRenderer centralizarLabel = new DefaultTableCellRenderer();
                centralizarLabel.setHorizontalAlignment(JLabel.CENTER);
                
                this.textoOpcoesDisponiveis.getColumnModel().getColumn(0).setMaxWidth(0);
                this.textoOpcoesDisponiveis.getColumnModel().getColumn(0).setMinWidth(0);
                this.textoOpcoesDisponiveis.getColumnModel().getColumn(0).setPreferredWidth(0);
                
                
                this.textoOpcoesDisponiveis.getColumnModel().getColumn(1).setHeaderValue("Tamanho");
                this.textoOpcoesDisponiveis.getColumnModel().getColumn(1).setCellRenderer(centralizarLabel);
                
                this.textoOpcoesDisponiveis.getColumnModel().getColumn(2).setHeaderValue("Fatias");
                this.textoOpcoesDisponiveis.getColumnModel().getColumn(2).setCellRenderer(centralizarLabel);
                
                this.textoOpcoesDisponiveis.getColumnModel().getColumn(3).setHeaderValue("Preço");
                this.textoOpcoesDisponiveis.getColumnModel().getColumn(3).setCellRenderer(centralizarLabel);
                
                con.close();
                
            } // Recuperação de dados dos lanches
            else if(this.getIndiceCardapioEscolhido() == 1){
                
            } // Recuperação de dados das bebidas
            else if(this.getIndiceCardapioEscolhido() == 2){
                
            } // Recuperação de dados dos outros
            else{
                
            }
        }
        catch(Exception e){
            e.printStackTrace();
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

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        textoOpcoesDisponiveis = new javax.swing.JTable();
        labelOpcoesDisponiveis = new javax.swing.JLabel();
        botaoAdicionar = new javax.swing.JButton();
        botaoFechar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        textIngredientes = new javax.swing.JTextPane();
        labelIngredientes = new javax.swing.JLabel();
        labelQuantidade = new javax.swing.JLabel();
        textoQuantidade = new javax.swing.JTextField();
        labelNomePizza = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("OpenPizza");
        setMaximumSize(new java.awt.Dimension(350, 600));
        setMinimumSize(new java.awt.Dimension(350, 600));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        textoOpcoesDisponiveis.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textoOpcoesDisponiveisMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(textoOpcoesDisponiveis);

        labelOpcoesDisponiveis.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelOpcoesDisponiveis.setText("Opções disponíveis:");

        botaoAdicionar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoAdicionar.setText("Adicionar");
        botaoAdicionar.setMaximumSize(new java.awt.Dimension(77, 30));
        botaoAdicionar.setMinimumSize(new java.awt.Dimension(77, 30));
        botaoAdicionar.setPreferredSize(new java.awt.Dimension(77, 30));
        botaoAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAdicionarActionPerformed(evt);
            }
        });

        botaoFechar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoFechar.setText("Fechar");
        botaoFechar.setMaximumSize(new java.awt.Dimension(65, 30));
        botaoFechar.setMinimumSize(new java.awt.Dimension(65, 30));
        botaoFechar.setPreferredSize(new java.awt.Dimension(65, 30));
        botaoFechar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoFecharActionPerformed(evt);
            }
        });

        jScrollPane2.setViewportView(textIngredientes);

        labelIngredientes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelIngredientes.setText("Ingredientes:");

        labelQuantidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelQuantidade.setText("Quantidade:");

        textoQuantidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        textoQuantidade.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                textoQuantidadeMouseClicked(evt);
            }
        });

        labelNomePizza.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelNomePizza.setText("-");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(botaoFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(botaoAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelIngredientes)
                    .addComponent(labelOpcoesDisponiveis, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(labelQuantidade)
                        .addGap(18, 18, 18)
                        .addComponent(textoQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelNomePizza, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(labelNomePizza)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
                .addComponent(labelOpcoesDisponiveis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelQuantidade)
                    .addComponent(textoQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(labelIngredientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botaoAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botaoFechar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // TODO add your handling code here:
        this.getTelaCardapio().setEnabled(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosed

    private void botaoFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoFecharActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_botaoFecharActionPerformed

    private void botaoAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdicionarActionPerformed
        // TODO add your handling code here:
        if(this.getQuantidade() > 0){
            int confirmar = JOptionPane.showConfirmDialog(null, "Deseja inserir esse item no pedido?\nEssa ação não poderá ser desfeita!", "Aviso", JOptionPane.OK_CANCEL_OPTION);
            if(confirmar == JOptionPane.OK_OPTION){
                try{
                    int pedidoNumero = this.getInfoPedido().getNumeroPedido();
                    int codigoProduto = this.pizzas.get(this.getIndiceProdutoEscolhido()).getCodigo();
                    int quantidadeProdutos = this.getQuantidade();
                    float precoPizza = this.pizzas.get(this.getIndiceProdutoEscolhido()).getPreco();
                    System.out.println(this.getTamanhoPizza());
                    
                    String query = "INSERT INTO ItemDoPedido(pedidoNumero, codigoProduto, qtdadeProdutos, tamanho, preco) VALUES(" + pedidoNumero + "," + codigoProduto + "," + quantidadeProdutos + ",'" + this.getTamanhoPizza() + "'," + precoPizza + ")";
                    banco.efetuarInsercao(this.getAutenticacao(), query);
                    JOptionPane.showMessageDialog(null, "Produto inserido com sucesso.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    this.textoQuantidade.setText(null);
                }
                catch(Exception e){
                    e.printStackTrace();
                }
            }
        }
    }//GEN-LAST:event_botaoAdicionarActionPerformed

    private void textoOpcoesDisponiveisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textoOpcoesDisponiveisMouseClicked
        // TODO add your handling code here:
        this.setTamanhoPizza((String) this.textoOpcoesDisponiveis.getModel().getValueAt(this.textoOpcoesDisponiveis.getSelectedRow(), 1));
    }//GEN-LAST:event_textoOpcoesDisponiveisMouseClicked

    private void textoQuantidadeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textoQuantidadeMouseClicked
        // TODO add your handling code here:
        try{
            int quantidade = Integer.parseInt(JOptionPane.showInputDialog(null, "Informe a quantidade:", "Quantidade", JOptionPane.INFORMATION_MESSAGE));
            if(quantidade > 0){
                this.setQuantidade(quantidade);
                this.textoQuantidade.setText(String.valueOf(this.getQuantidade()));
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Informe um número inteiro maior que 0 (zero)", "Aviso", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_textoQuantidadeMouseClicked

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
            java.util.logging.Logger.getLogger(TelaInformacoesPizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaInformacoesPizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaInformacoesPizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaInformacoesPizza.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaInformacoesPizza().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoAdicionar;
    private javax.swing.JButton botaoFechar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel labelIngredientes;
    private javax.swing.JLabel labelNomePizza;
    private javax.swing.JLabel labelOpcoesDisponiveis;
    private javax.swing.JLabel labelQuantidade;
    private javax.swing.JTextPane textIngredientes;
    private javax.swing.JTable textoOpcoesDisponiveis;
    private javax.swing.JTextField textoQuantidade;
    // End of variables declaration//GEN-END:variables
}
