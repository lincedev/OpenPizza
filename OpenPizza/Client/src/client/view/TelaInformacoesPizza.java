package client.view;

import client.modelo.*;
import client.persistencia.*;
import java.util.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import net.proteanit.sql.DbUtils;

/*
 Descrição: Tela de exibição das informações específicas de cada produto.
 */
public class TelaInformacoesPizza extends javax.swing.JFrame {

    // Objeto para persistência com o banco de dados.
    private Banco banco = new Banco();

    // Objeto com dados de autenticação do banco de dados.
    private Autenticacao autenticacao;

    // Objeto com a referência da tela anterior.
    private TelaCardapio telaCardapio;

    // Objeto com informações do pedido atual.
    private Pedido infoPedido;

    // Variável contendo o índice da categoria de produtos escolhido na tela de cardápio.
    private int indiceCardapioEscolhido;

    // Variável contendo o índice do produto escolhido na tabela de informações das pizzas.
    private int indiceProdutoEscolhido;

    // Lista com todas as opções de pizzas.
    ArrayList<Pizza> pizzas = new ArrayList();

    /*
     Descrição: Construtor padrão da tela de informações das pizzas
     Parâmetros:
     Retorno:
     */
    private TelaInformacoesPizza() {
        initComponents();
    }

    /*
     Descrição: Construtor completo da tela de informações das pizzas
     Parâmetros:
     *           telaCardapio (Tela anterior)
     *           autenticacao (Necessário para acesso ao banco de dados)
     *           indiceCardapioEscolhido (Categoria escolhida na tela anterior: pizza, lanches, bebidas ou outros)
     *           indiceProdutoEscolhido (Indice do produto escolhido em uma categoria)
     *           infoPedido (Objeto com informações do pedido atual)
     Retorno:
     */
    public TelaInformacoesPizza(TelaCardapio telaCardapio, Autenticacao autenticacao, int indiceCardapioEscolhido, int indiceProdutoEscolhido, Pedido infoPedido) {
        this();
        this.setTelaCardapio(telaCardapio);
        this.setAutenticacao(autenticacao);
        this.setIndiceCardapioEscolhido(indiceCardapioEscolhido);
        this.setIndiceProdutoEscolhido(indiceProdutoEscolhido);
        this.setInfoPedido(infoPedido);
        this.textoQuantidade.setEnabled(false);
        this.getTelaCardapio().setEnabled(false);
        exibirInformacoes();
    }

    /*
     Descrição: Método get do objeto de autenticação.
     Parâmetros:
     Retorno:
     *           autenticacao (Necessário para acesso ao banco de dados)
     */
    public Autenticacao getAutenticacao() {
        return autenticacao;
    }

    /*
     Descrição: Método set do objeto de autenticação.
     Parâmetros:
     *           autenticacao (Necessário para acesso ao banco de dados)
     Retorno:
     */
    public void setAutenticacao(Autenticacao autenticacao) {
        this.autenticacao = autenticacao;
    }

    /*
     Descrição: Método get do índice escolhido em uma categoria de produtos.
     Parâmetros:
     Retorno:
     *           indiceCardapioEscolhido (Índice escolhido em uma categoria de produtos)
     */
    public int getIndiceCardapioEscolhido() {
        return indiceCardapioEscolhido;
    }

    /*
     Descrição: Método set do índice escolhido em uma categoria de produtos.
     Parâmetros:
     *           indiceCardapioEscolhido (Categoria selecionada na tela anterior)
     Retorno:
     */
    public void setIndiceCardapioEscolhido(int indiceCardapioEscolhido) {
        this.indiceCardapioEscolhido = indiceCardapioEscolhido;
    }

    /*
     Descrição: Método set da tela de cardápio.
     Parâmetros:
     Retorno:
     *           telaCardapio (Tela anterior)
     */
    public TelaCardapio getTelaCardapio() {
        return telaCardapio;
    }

    /*
     Descrição: Método set da tela de cardápio.
     Parâmetros:
     *           telaCardápio (Referência para a tela anterior)
     Retorno:
     */
    public void setTelaCardapio(TelaCardapio telaCardapio) {
        this.telaCardapio = telaCardapio;
    }

    /*
     Descrição: Método get do índice do produto escolhido em uma categoria.
     Parâmetros:
     Retorno:
     *           indiceProdutoEscolhido (Índice do produto escolhido em uma categoria)
     */
    public int getIndiceProdutoEscolhido() {
        return indiceProdutoEscolhido;
    }

    /*
     Descrição: Método set do índice do produto escolhido em uma categoria.
     Parâmetros:
     *           indiceProdutoEscolhido (Índice do produto escolhido em uma categoria)
     Retorno:
     */
    public void setIndiceProdutoEscolhido(int indiceProdutoEscolhido) {
        this.indiceProdutoEscolhido = indiceProdutoEscolhido;
    }

    /*
     Descrição: Método get do objeto contendo as informações do pedido atual.
     Parâmetros:
     Retorno:
     *           infoPedido (Objeto com as informações do pedido atual)
     */
    public Pedido getInfoPedido() {
        return infoPedido;
    }

    /*
     Descrição: Método set do objeto contendo as informações do pedido atual.
     Parâmetros:
     *           infoPedido (Objeto com as informações do pedido atual)
     Retorno:
     */
    public void setInfoPedido(Pedido infoPedido) {
        this.infoPedido = infoPedido;
    }

    /*
     Descrição: Método para exibição das informações específicas de cada tipo de produto.
     *          Utilizado para exibição das diferentes opções de cada produto.
     Parâmetros:
     Retorno:
     */
    public void exibirInformacoes() {

        // Tentiva de conexão com o banco de dados para recuperação das informações específicas de cada produto
        try {
            // Recuperação de dados das pizzas
            if (this.getIndiceCardapioEscolhido() == 0) {

                // Recuperação das informações específicas de cada pizza escolhida
                pizzas = banco.consultarInfoPizzas(this.getAutenticacao());

                // Atualização dos textos de índices da interface
                this.labelNomePizza.setText(pizzas.get(this.getIndiceProdutoEscolhido()).getDescricao());
                this.textIngredientes.setText(pizzas.get(this.getIndiceProdutoEscolhido()).getIngredientesPizza());

                // Conexão com o banco de dados e recuperação dos dados da pizza selecionada
                String query = "SELECT P.codigo, PZ.tamanho, PZ.fatias, PZ.preco FROM Pizza AS PZ JOIN Produto AS P ON PZ.codProduto = P.codigo WHERE P.descricao LIKE '" + pizzas.get(this.getIndiceProdutoEscolhido()).getDescricao() + "'";
                Connection con = banco.abrirConexao(this.getAutenticacao());
                Statement st = con.createStatement();
                ResultSet rs = st.executeQuery(query);

                // Declaração do modelo da tabela de exibição dos dados
                this.textoOpcoesDisponiveis.setModel(DbUtils.resultSetToTableModel(rs));

                // Exibição centralizada dos registros
                DefaultTableCellRenderer centralizarLabel = new DefaultTableCellRenderer();
                centralizarLabel.setHorizontalAlignment(JLabel.CENTER);

                // Formatação dos campos da tabela
                // Campo de código do produto (Invisível ao usuário, mas necessário para inserção do produto no pedido)
                this.textoOpcoesDisponiveis.getColumnModel().getColumn(0).setMaxWidth(0);
                this.textoOpcoesDisponiveis.getColumnModel().getColumn(0).setMinWidth(0);
                this.textoOpcoesDisponiveis.getColumnModel().getColumn(0).setPreferredWidth(0);

                // Campo de tamanho da pizza
                this.textoOpcoesDisponiveis.getColumnModel().getColumn(1).setHeaderValue("Tamanho");
                this.textoOpcoesDisponiveis.getColumnModel().getColumn(1).setCellRenderer(centralizarLabel);

                // Campo de número de fatias da pizza
                this.textoOpcoesDisponiveis.getColumnModel().getColumn(2).setHeaderValue("Fatias");
                this.textoOpcoesDisponiveis.getColumnModel().getColumn(2).setCellRenderer(centralizarLabel);

                // Campo de preço da pizza
                this.textoOpcoesDisponiveis.getColumnModel().getColumn(3).setHeaderValue("Preço");
                this.textoOpcoesDisponiveis.getColumnModel().getColumn(3).setCellRenderer(centralizarLabel);

                // Término da conexão com o banco de dados.
                banco.fecharConexao(con);
                
            } // Recuperação de dados dos lanches
            else if (this.getIndiceCardapioEscolhido() == 1) {
                
            } // Recuperação de dados das bebidas
            else if (this.getIndiceCardapioEscolhido() == 2) {
                
            } // Recuperação de dados dos outros
            else {
                
            }
        } // Falha na conexão com o banco de dados
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível recuperar as informações dos produtos.", "Erro", JOptionPane.ERROR_MESSAGE);
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

        painelTelaInformacoes = new javax.swing.JPanel();
        painelOpcoesDisponiveis = new javax.swing.JScrollPane();
        textoOpcoesDisponiveis = new javax.swing.JTable();
        labelOpcoesDisponiveis = new javax.swing.JLabel();
        botaoAdicionar = new javax.swing.JButton();
        botaoFechar = new javax.swing.JButton();
        painelIngredientes = new javax.swing.JScrollPane();
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
        painelOpcoesDisponiveis.setViewportView(textoOpcoesDisponiveis);

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

        painelIngredientes.setViewportView(textIngredientes);

        labelIngredientes.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelIngredientes.setText("Ingredientes:");

        labelQuantidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelQuantidade.setText("Quantidade:");

        textoQuantidade.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        labelNomePizza.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        labelNomePizza.setText("-");

        javax.swing.GroupLayout painelTelaInformacoesLayout = new javax.swing.GroupLayout(painelTelaInformacoes);
        painelTelaInformacoes.setLayout(painelTelaInformacoesLayout);
        painelTelaInformacoesLayout.setHorizontalGroup(
            painelTelaInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelTelaInformacoesLayout.createSequentialGroup()
                .addContainerGap(54, Short.MAX_VALUE)
                .addComponent(botaoFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(46, 46, 46)
                .addComponent(botaoAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(50, 50, 50))
            .addGroup(painelTelaInformacoesLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(painelTelaInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelIngredientes)
                    .addComponent(labelOpcoesDisponiveis, javax.swing.GroupLayout.PREFERRED_SIZE, 225, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelTelaInformacoesLayout.createSequentialGroup()
                        .addComponent(labelQuantidade)
                        .addGap(18, 18, 18)
                        .addComponent(textoQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelNomePizza, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(painelTelaInformacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelIngredientes)
                .addContainerGap())
            .addGroup(painelTelaInformacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelOpcoesDisponiveis, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelTelaInformacoesLayout.setVerticalGroup(
            painelTelaInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelTelaInformacoesLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(labelNomePizza)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 179, Short.MAX_VALUE)
                .addComponent(labelOpcoesDisponiveis)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(painelOpcoesDisponiveis, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(painelTelaInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelQuantidade)
                    .addComponent(textoQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(labelIngredientes)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelTelaInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelTelaInformacoesLayout.createSequentialGroup()
                        .addComponent(painelIngredientes, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(95, 95, 95))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelTelaInformacoesLayout.createSequentialGroup()
                        .addGroup(painelTelaInformacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(botaoAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botaoFechar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(27, 27, 27))))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelTelaInformacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelTelaInformacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /*
     Descrição: Método disparado ao fechar a janela no botão X.
     Parâmetros:
     Retorno:
     */
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // Habilitar tela anterior e fechar tela atual
        this.getTelaCardapio().setEnabled(true);
        this.dispose();
    }//GEN-LAST:event_formWindowClosed

    /*
     Descrição: Método disparado ao clicar no botão Fechar.
     Parâmetros:
     Retorno:
     */
    private void botaoFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoFecharActionPerformed
        // Fechar janela atual
        this.dispose();
    }//GEN-LAST:event_botaoFecharActionPerformed

    /*
     Descrição: Método disparado ao clicar no botão Adicionar.
     *           Este método verifica o produto selecionado e a quantidade desejada,
     *           para registro desses dados no número do pedido atual. Após o registro
     *           o método atualiza o valor total do número do pedido na tela de Pedidos.
     Parâmetros:
     Retorno:
     */
    private void botaoAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdicionarActionPerformed
        // Verificação da quantidade de produtos selecionados
        if (this.textoQuantidade.getText().length() > 0) {

            // Mensagem de confirmação para adição do produto ao pedido
            int confirmar = JOptionPane.showConfirmDialog(null, "Deseja inserir esse item no pedido?\nEssa ação não poderá ser desfeita!", "Aviso", JOptionPane.OK_CANCEL_OPTION);

            // Verificação da opção do usuário -> Adicionar produto
            if (confirmar == JOptionPane.OK_OPTION) {

                // Recuperação dos dados selecionados na interface e tentativa de inserção no banco de dados
                try {

                    // Recuperação dos dados da pizza escolhida
                    int pedidoNumero = this.getInfoPedido().getNumeroPedido();
                    int codigoProduto = (Integer) this.textoOpcoesDisponiveis.getValueAt(this.textoOpcoesDisponiveis.getSelectedRow(), 0);
                    int quantidadeProdutos = Integer.parseInt(this.textoQuantidade.getText());
                    String tamanho = (String) this.textoOpcoesDisponiveis.getValueAt(this.textoOpcoesDisponiveis.getSelectedRow(), 1);
                    float precoPizza = (Float) this.textoOpcoesDisponiveis.getValueAt(this.textoOpcoesDisponiveis.getSelectedRow(), 3);

                    // Verificação da existência do mesmo produto já presente no pedido
                    boolean produtoNoPedido = banco.verificarProdutoNoPedido(this.getAutenticacao(), pedidoNumero, codigoProduto);
                    
                    // Produto encontrado -> Atualização da quantidade no pedido
                    if (produtoNoPedido) {
                        String query = "UPDATE ItemDoPedido SET qtdadeProdutos = qtdadeProdutos + " + quantidadeProdutos + " WHERE pedidoNumero = " + pedidoNumero + " AND codigoProduto = " + codigoProduto;
                        banco.atualizarProdutoNoPedido(this.getAutenticacao(), query);
                        JOptionPane.showMessageDialog(null, "Produto inserido com sucesso.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    } // Produto não encontrado -> Registro do novo produto no pedido
                    else {
                        String query = "INSERT INTO ItemDoPedido(pedidoNumero, codigoProduto, qtdadeProdutos, tamanho, preco) VALUES(" + pedidoNumero + "," + codigoProduto + "," + quantidadeProdutos + ",'" + tamanho + "'," + precoPizza + ")";
                        banco.executarSQL(this.getAutenticacao(), query);
                        JOptionPane.showMessageDialog(null, "Produto inserido com sucesso.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    }
              
                    // Tentativa de atualização do valor total do pedido
                    try {
                        String query = "UPDATE Pedido SET valor =(SELECT SUM(qtdadeProdutos * preco) FROM ItemDoPedido WHERE pedidoNumero = " + pedidoNumero + ") WHERE numeroPedido = " + pedidoNumero + " AND pedidoFinalizado = false;";
                        banco.executarSQL(this.getAutenticacao(), query);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Não foi possível atualizar o valor total do pedido.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                    
                } // Falha na inserção do(s) produtos ao pedido atual
                catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Não foi possível adicionar o produto ao pedido atual.", "Erro", JOptionPane.ERROR_MESSAGE);
                }

                // Fechar janela atual após inserção do produto no pedido
                this.getTelaCardapio().getJanelaPedido().exibirPedidoDaMesa();
                this.dispose();
            }
        } // Mensagem de erro caso a quantidade seja nula ou menor que zero
        else {
            JOptionPane.showMessageDialog(null, "Informe a quantidade");
        }
    }//GEN-LAST:event_botaoAdicionarActionPerformed

    /*
     Descrição: Método disparado ao clicar em uma linha da tabela de produtos.
     *           Este método habilita o campo para inserção da quantidade desejada.
     Parâmetros:
     Retorno:
     */
    private void textoOpcoesDisponiveisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_textoOpcoesDisponiveisMouseClicked
        // Habilitar campo para inserção da quantidade
        this.textoQuantidade.setEnabled(true);
    }//GEN-LAST:event_textoOpcoesDisponiveisMouseClicked

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
    private javax.swing.JLabel labelIngredientes;
    private javax.swing.JLabel labelNomePizza;
    private javax.swing.JLabel labelOpcoesDisponiveis;
    private javax.swing.JLabel labelQuantidade;
    private javax.swing.JScrollPane painelIngredientes;
    private javax.swing.JScrollPane painelOpcoesDisponiveis;
    private javax.swing.JPanel painelTelaInformacoes;
    private javax.swing.JTextPane textIngredientes;
    private javax.swing.JTable textoOpcoesDisponiveis;
    private javax.swing.JTextField textoQuantidade;
    // End of variables declaration//GEN-END:variables
}
