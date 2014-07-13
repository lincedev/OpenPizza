// Pacote View
package client.view;

// Importação dos pacotes e bibliotecas necessárias
import client.control.Controle;
import client.model.Autenticacao;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;

/*
 Descrição: Tela de Inclusão de Produtos
 */
public class TelaIncluirProduto extends javax.swing.JFrame {

    // Atributos encapsulados
    private TelaCardapio telaCardapio;
    private Autenticacao autenticacao;
    private Controle controle;
    private String categoriaDoProduto;
    private String nomeDoProduto;
    private int numeroDoPedido;

    /*
     Descrição: Construtor padrão da Tela de Inclusão de Produtos
     Parâmetros:
     Retorno:
     */
    private TelaIncluirProduto() {
        initComponents();
    }

    /*
     Descrição: Construtor completo da Tela de Cardápio
     Parâmetros:
     telaCardapio (Referência à Tabela Cardápio)
     controle (Objeto do tipo Controle)
     autenticacao (Objeto do tipo Autenticacao contendo as informações para acesso ao banco de dados)
     categoriaDoProduto (String contendo a categoria do produto (Pizza, Lanche, Bebida, Outro)
     nomeDoProduto (String contendo o nome do produto selecionado na Tela Cardápio)
     numeroDoPedido (Inteiro contendo o número do pedido selecionado na Tela Pedido)
     Retorno:
     */
    public TelaIncluirProduto(TelaCardapio telaCardapio, Controle controle, Autenticacao autenticacao, String categoriaDoProduto, String nomeDoProduto, int numeroDoPedido) {
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

    /*
     Descrição: Método para formatação dos dados referentes à tabela de opções disponíveis do produto
     Parâmetros:
     Retorno:
     */
    public void formatarTabelaDeOpcoesDisponiveis() {
        // Exibição centralizada dos registros
        DefaultTableCellRenderer centralizarLabel = new DefaultTableCellRenderer();
        centralizarLabel.setHorizontalAlignment(JLabel.CENTER);

        // Formatação dos campos da tabela
        // Campo de código do produto (Invisível ao usuário, mas necessário para inserção do produto no pedido)
        this.tabelaOpcoesDisponiveis.getColumnModel().getColumn(0).setMaxWidth(0);
        this.tabelaOpcoesDisponiveis.getColumnModel().getColumn(0).setMinWidth(0);
        this.tabelaOpcoesDisponiveis.getColumnModel().getColumn(0).setPreferredWidth(0);
        if (this.getCategoriaDoProduto().equals("Pizza")) {

            // Campo de tamanho da pizza
            this.tabelaOpcoesDisponiveis.getColumnModel().getColumn(1).setHeaderValue("Tamanho");

            // Campo de número de fatias da pizza
            this.tabelaOpcoesDisponiveis.getColumnModel().getColumn(2).setHeaderValue("Fatias");
            this.tabelaOpcoesDisponiveis.getColumnModel().getColumn(2).setCellRenderer(centralizarLabel);

            // Campo de preço da pizza
            this.tabelaOpcoesDisponiveis.getColumnModel().getColumn(3).setHeaderValue("Preço");
            this.tabelaOpcoesDisponiveis.getColumnModel().getColumn(3).setCellRenderer(centralizarLabel);
        } // Formatação dos campos da tabela Lanches
        else if(this.getCategoriaDoProduto().equals("Lanche")){
            
            // Campo do nome do lanche
            this.tabelaOpcoesDisponiveis.getColumnModel().getColumn(1).setHeaderValue("Descrição");

            // Campo do preço do lanche
            this.tabelaOpcoesDisponiveis.getColumnModel().getColumn(2).setHeaderValue("Preço");
            this.tabelaOpcoesDisponiveis.getColumnModel().getColumn(2).setCellRenderer(centralizarLabel);
            
        } // Formatação dos campos das Bebidas e Outros
        else {
            
            // Campo do nome das Bebidas e Outros
            this.tabelaOpcoesDisponiveis.getColumnModel().getColumn(1).setHeaderValue("Descrição");

            // Campo do preço das Bebidas e Outros
            this.tabelaOpcoesDisponiveis.getColumnModel().getColumn(2).setHeaderValue("Preço");
            this.tabelaOpcoesDisponiveis.getColumnModel().getColumn(2).setMinWidth(70);
            this.tabelaOpcoesDisponiveis.getColumnModel().getColumn(2).setMaxWidth(70);
            this.tabelaOpcoesDisponiveis.getColumnModel().getColumn(2).setPreferredWidth(70);
            this.tabelaOpcoesDisponiveis.getColumnModel().getColumn(2).setCellRenderer(centralizarLabel);
            
            // Campo do estoque disponível das Bebidas e Outros
            this.tabelaOpcoesDisponiveis.getColumnModel().getColumn(3).setHeaderValue("Estoque");
            this.tabelaOpcoesDisponiveis.getColumnModel().getColumn(3).setMinWidth(70);
            this.tabelaOpcoesDisponiveis.getColumnModel().getColumn(3).setMaxWidth(70);
            this.tabelaOpcoesDisponiveis.getColumnModel().getColumn(3).setPreferredWidth(70);
            this.tabelaOpcoesDisponiveis.getColumnModel().getColumn(3).setCellRenderer(centralizarLabel);
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
        labelNomeProduto = new javax.swing.JLabel();
        textFieldQuantidade = new javax.swing.JTextField();
        botaoIncluir = new javax.swing.JButton();
        botaoFechar = new javax.swing.JButton();
        painelOpcoesDisponiveis = new javax.swing.JScrollPane();
        tabelaOpcoesDisponiveis = new javax.swing.JTable();
        painelIngredientes = new javax.swing.JScrollPane();
        textoIngredientes = new javax.swing.JTextArea();
        labelFoto = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("OpenPizza - Incluir Produto");
        setMinimumSize(new java.awt.Dimension(400, 700));
        setResizable(false);

        labelProduto.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        labelProduto.setText("Produto:");

        labelOpcoesDisponiveis.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        labelOpcoesDisponiveis.setText("Opções Disponíveis:");

        labelQuantidade.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        labelQuantidade.setText("Quantidade:");

        labelIngredientes.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        labelIngredientes.setText("Ingredientes:");

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
                            .addComponent(labelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(painelIngredientes, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(painelLayout.createSequentialGroup()
                                .addComponent(labelQuantidade)
                                .addGap(11, 11, 11)
                                .addComponent(textFieldQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 78, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(labelIngredientes)
                            .addComponent(painelOpcoesDisponiveis, javax.swing.GroupLayout.PREFERRED_SIZE, 374, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addGap(18, 18, 18)
                .addComponent(labelFoto, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
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

    /*
     Descrição: Evento ao clicar no botão Fechar
     Parâmetros:
     Retorno:
     */
    private void botaoFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoFecharActionPerformed
        // Habilitar a visualização da Tela de Cardápio e fechar a janela atual
        this.getTelaCardapio().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botaoFecharActionPerformed

    /*
     Descrição: Evento ao clicar no botão Incluir
     Parâmetros:
     Retorno:
     */
    private void botaoIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoIncluirActionPerformed
        // Recuperação da quantidade informada pelo usuário
        String quantidade = this.textFieldQuantidade.getText();

        // Recuperação do código do produto selecionado na tabela de opções disponíveis
        int codigoDoProduto = (Integer) this.tabelaOpcoesDisponiveis.getValueAt(this.tabelaOpcoesDisponiveis.getSelectedRow(), 0);

        // Quantidade informada é válida -> Confirmação de inclusão do produto no pedido
        if ((quantidade.length() > 0) && (Integer.parseInt(quantidade) > 0)) {

            // Mensagem de confirmação de inclusão
            int confirmarInclusao = JOptionPane.showConfirmDialog(null, "Deseja incluir o item na quantidade selecionada?\nEssa operação não poderá ser desfeita.", "Aviso", JOptionPane.OK_CANCEL_OPTION);

            // Confirmação válida -> Tentativa de inclusão do produto no pedido
            if (confirmarInclusao == JOptionPane.OK_OPTION) {

                // Parada para verificação do estoque
                boolean continuar = true;
                
                // Verificação da quantidade disponível em estoque, no caso de Bebidas e Outros
                if ((this.getCategoriaDoProduto().equals("Bebida")) || (this.getCategoriaDoProduto().equals("Outro"))) {
                    
                    // Verificação da quantidade disponível em estoque
                    boolean consultarEstoque = this.getControle().consultarEstoque(this.getAutenticacao(), codigoDoProduto, Integer.parseInt(quantidade), this.getCategoriaDoProduto());
                    
                    // Quantidade em estoque é menor do que a desejada -> Mensagem de erro
                    if (consultarEstoque) {
                        continuar = false;
                        JOptionPane.showMessageDialog(null, "A quantidade informada é maior do que a disponível em estoque.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
                // Continuação, caso o estoque esteja disponível ou não seja requisitado
                if (continuar) {
                    
                    // Verificação de instância do produto no pedido
                    boolean consultarProdutoNoPedido = this.getControle().consultarProdutoNoPedido(this.getAutenticacao(), this.getNumeroDoPedido(), codigoDoProduto);

                    // Produto encontrado -> Tentativa de atualização da quantidade do produto
                    if (consultarProdutoNoPedido) {

                        // Tentativa de atualização da quantidade do produto
                        boolean atualizarQuantidadeDoProdutoNoPedido = this.getControle().atualizarQuantidadeDoProdutoNoPedido(this.getAutenticacao(), this.getNumeroDoPedido(), this.getCategoriaDoProduto(), codigoDoProduto, Integer.parseInt(quantidade));

                        // Quantidade atualizada -> Mensagem de aviso
                        if (atualizarQuantidadeDoProdutoNoPedido) {
                            
                            // Verificação de categoria do produto (Atualização da quantidade em caso de Bebidas ou Outros)
                            if ((this.getCategoriaDoProduto().equals("Bebida")) || (this.getCategoriaDoProduto().equals("Outro"))){
                                
                                // Tentativa de atualização do estoque, no caso de Bebidas e Outros
                                boolean atualizarEstoque = this.getControle().atualizarEstoque(this.getAutenticacao(), codigoDoProduto, Integer.parseInt(quantidade), this.getCategoriaDoProduto());
                                
                                // Estoque não atualizado -> Mensagem de erro
                                if(!atualizarEstoque){
                                    JOptionPane.showMessageDialog(null, "Ocorreu um erro ao atualizar a quantidade em estoque.", "Erro", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                            
                            JOptionPane.showMessageDialog(null, "Produto inserido com sucesso.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                        } // Quantidade não atualizada -> Mensagem de erro
                        else {
                            JOptionPane.showMessageDialog(null, "Não foi possível atualizar a quantidade do produto selecionado.", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    } // Produto não encontrado -> Tentativa de inserção do produto
                    else {
                        boolean inserirProduto = false;

                    // Verificação da categoria do produto
                        // Categoria Pizza
                        if (this.getCategoriaDoProduto().equals("Pizza")) {

                            // Recuperação dos atributos da tabela de opções e tentativa de inserção do produto no pedido
                            String tamanho = (String) this.tabelaOpcoesDisponiveis.getValueAt(this.tabelaOpcoesDisponiveis.getSelectedRow(), 1);
                            float preco = (Float) this.tabelaOpcoesDisponiveis.getValueAt(this.tabelaOpcoesDisponiveis.getSelectedRow(), 3);
                            inserirProduto = this.getControle().inserirProduto(this.getAutenticacao(), this.getNumeroDoPedido(), codigoDoProduto, Integer.parseInt(quantidade), tamanho, preco);
                        } // Demais Categorias (Lanches, Bebida, Outros)
                        else {

                            // Recuperação dos atributos da tabela de opções e tentativa de inserção do produto no pedido
                            float preco = (Float) this.tabelaOpcoesDisponiveis.getValueAt(this.tabelaOpcoesDisponiveis.getSelectedRow(), 2);
                            inserirProduto = this.getControle().inserirProduto(this.getAutenticacao(), this.getNumeroDoPedido(), codigoDoProduto, Integer.parseInt(quantidade), "-", preco);
                        }

                    // Verificação de inserção do produto no pedido
                        // Produto inserido -> Mensagem de aviso
                        if (inserirProduto) {
                            
                            // Verificação de categoria do produto (Atualização da quantidade em caso de Bebidas ou Outros)
                            if ((this.getCategoriaDoProduto().equals("Bebida")) || (this.getCategoriaDoProduto().equals("Outro"))){
                                
                                // Tentativa de atualização do estoque, no caso de Bebidas e Outros
                                boolean atualizarEstoque = this.getControle().atualizarEstoque(this.getAutenticacao(), codigoDoProduto, Integer.parseInt(quantidade), this.getCategoriaDoProduto());
                                
                                // Estoque não atualizado -> Mensagem de erro
                                if(!atualizarEstoque){
                                    JOptionPane.showMessageDialog(null, "Ocorreu um erro ao atualizar a quantidade em estoque.", "Erro", JOptionPane.ERROR_MESSAGE);
                                }
                            }
                            
                            JOptionPane.showMessageDialog(null, "Produto inserido com sucesso.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                        } // Produto não inserido -> Mensagem de erro
                        else {
                            JOptionPane.showMessageDialog(null, "Não foi possível inserir o produto selecionado.", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    }

                    // Habilitar visualização da Tela de Cardápio e fechar tela atual
                    this.getTelaCardapio().setVisible(true);
                    this.dispose();
                }
            }
        }
    }//GEN-LAST:event_botaoIncluirActionPerformed

    /*
     Descrição: Evento ao clicar na tabela de opções disponíveis
     Parâmetros:
     Retorno:
     */
    private void tabelaOpcoesDisponiveisMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaOpcoesDisponiveisMouseClicked
        // Habilitar campo para inserção da quantidade
        this.textFieldQuantidade.setEnabled(true);

        // Recuperação do código do produto
        int codigoDoProduto = (Integer) this.tabelaOpcoesDisponiveis.getValueAt(this.tabelaOpcoesDisponiveis.getSelectedRow(), 0);

        // Verificação da categoria do produto
        // Categoria Pizza -> Tentativa de exibição dos ingredientes
        if (this.getCategoriaDoProduto().equals("Pizza")) {
            this.getControle().consultarIngredientes(this.textoIngredientes, this.getAutenticacao(), this.getCategoriaDoProduto(), codigoDoProduto);
            this.getControle().consultarImagemDaPizza(this.labelFoto, this.getAutenticacao(), codigoDoProduto);
        }
        // Categoria Lanche -> Tentativa de exibição dos ingredientes
        if (this.getCategoriaDoProduto().equals("Lanche")) {
            this.getControle().consultarIngredientes(this.textoIngredientes, this.getAutenticacao(), this.getCategoriaDoProduto(), codigoDoProduto);
        }
    }//GEN-LAST:event_tabelaOpcoesDisponiveisMouseClicked

    /*
     Descrição: Evento ao digitar um caractere no campo de quantidade
     Parâmetros:
     Retorno:
     */
    private void textFieldQuantidadeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_textFieldQuantidadeKeyReleased
        // Verificação do caractere digitado
        try {
            // Recuperação do caractere digitado
            int quantidade = Integer.parseInt(this.textFieldQuantidade.getText());

            // Caractere válido -> Habilitar botão Incluir
            if (quantidade > 0) {
                this.botaoIncluir.setEnabled(true);
            }
        } // Caractere inválido
        catch (Exception e) {

            // Desabilitar botão Incluir e apagar caractere digitado no campo quantidade
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
            java.util.logging.Logger.getLogger(TelaIncluirProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaIncluirProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaIncluirProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaIncluirProduto.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaIncluirProduto().setVisible(true);
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

    /*
     Descrição: Método get da telaCardapio
     Parâmetros:
     Retorno:
     telaCardapio (Referência à Tela de Cardápio)
     */
    public TelaCardapio getTelaCardapio() {
        return telaCardapio;
    }

    /*
     Descrição: Método set da telaCardapio
     Parâmetros:
     telaCardapio (Referência à Tela de Cardápio)
     Retorno:
     */
    public void setTelaCardapio(TelaCardapio telaCardapio) {
        this.telaCardapio = telaCardapio;
    }

    /*
     Descrição: Método get do nomeDoProduto
     Parâmetros:
     Retorno:
     nomeDoProduto (String contendo o nome do produto selecionado na Tela de Cardápio)
     */
    public String getNomeDoProduto() {
        return nomeDoProduto;
    }

    /*
     Descrição: Método set do nomeDoProduto
     Parâmetros:
     nomeDoProduto (String contendo o nome do produto selecionado na Tela de Cardápio)
     Retorno:
     */
    public void setNomeDoProduto(String nomeDoProduto) {
        this.nomeDoProduto = nomeDoProduto;
    }

    /*
     Descrição: Método get do objeto Controle
     Parâmetros:
     Retorno:
     controle (Objeto do tipo Controle)
     */
    public Controle getControle() {
        return controle;
    }

    /*
     Descrição: Método set do objeto de Controle
     Parâmetros:
     controle (Objeto do tipo Controle)
     Retorno:
     */
    public void setControle(Controle controle) {
        this.controle = controle;
    }

    /*
     Descrição: Método get do objeto Autenticacao
     Parâmetros:
     Retorno:
     autenticacao (Objeto do tipo Autenticacao contendo as informações para acesso ao banco de dados)
     */
    public Autenticacao getAutenticacao() {
        return autenticacao;
    }

    /*
     Descrição: Método set do objeto de Autenticacao
     Parâmetros:
     autenticacao (Objeto do tipo Autenticacao contendo as informações para acesso ao banco de dados)
     Retorno:
     */
    public void setAutenticacao(Autenticacao autenticacao) {
        this.autenticacao = autenticacao;
    }

    /*
     Descrição: Método get do numeroDoPedido
     Parâmetros:
     Retorno:
     numeroDoPedido (Inteiro contendo o número do pedido selecionado na Tela de Pedido)
     */
    public int getNumeroDoPedido() {
        return numeroDoPedido;
    }

    /*
     Descrição: Método set do numeroDoPedido
     Parâmetros:
     numeroDoPedido (Inteiro contendo o número do pedido selecionado na Tela de Pedido)
     Retorno:
     */
    public void setNumeroDoPedido(int numeroDoPedido) {
        this.numeroDoPedido = numeroDoPedido;
    }

    /*
     Descrição: Método get da categoriaDoPedido
     Parâmetros:
     Retorno:
     categoriaDoPedido (String contendo a categoria do produto (Pizza, Lanche, Bebida, Outro))
     */
    public String getCategoriaDoProduto() {
        return categoriaDoProduto;
    }

    /*
     Descrição: Método set da categoriaDoProduto
     Parâmetros:
     categoriaDoProduto (String contendo a categoria do produto (Pizza, Lanche, Bebida, Outro))
     Retorno:
     */
    public void setCategoriaDoProduto(String categoriaDoProduto) {
        this.categoriaDoProduto = categoriaDoProduto;
    }
}
