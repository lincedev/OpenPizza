// Pacote View
package client.view;

// Importação dos pacotes e bibliotecas necessárias
import client.control.Controle;
import client.model.Autenticacao;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;

/*
 Descrição: Tela de Cardápio
 */
public class TelaCardapio extends javax.swing.JFrame {

    // Atributos encapsulados
    private TelaPedido telaPedido;
    private Autenticacao autenticacao;
    private Controle controle;
    private int numeroDoPedido;
    private int numeroDaMesa;

    /*
     Descrição: Construtor padrão da Tela de Cardápio
     Parâmetros:
     Retorno:
     */
    private TelaCardapio() {
        initComponents();
    }

    /*
     Descrição: Construtor completo da Tela de Cardápio
     Parâmetros:
     telaPedido (Referência da Tela de Pedido)
     autenticacao (Objeto do tipo Autenticacao contendo as informações para acesso ao banco de dados)
     controle (Objeto do tipo Controle)
     numeroDoPedido (Inteiro contendo o número do pedido selecionado na Tela de Pedido)
     Retorno:
     */
    public TelaCardapio(TelaPedido telaPedido, Autenticacao autenticacao, Controle controle, int numeroDoPedido, int numeroDaMesa) {
        this();
        this.setTelaPedido(telaPedido);
        this.setAutenticacao(autenticacao);
        this.setControle(controle);
        this.setNumeroDoPedido(numeroDoPedido);
        this.setNumeroDaMesa(numeroDaMesa);
        this.getControle().consultarCardapio(this.tabelaPizzas, this.getAutenticacao(), "Pizza");
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
        botaoFechar = new javax.swing.JButton();
        painelProdutos = new javax.swing.JTabbedPane();
        painelPizzas = new javax.swing.JScrollPane();
        tabelaPizzas = new javax.swing.JTable();
        painelLanches = new javax.swing.JScrollPane();
        tabelaLanches = new javax.swing.JTable();
        painelBebidas = new javax.swing.JScrollPane();
        tabelaBebidas = new javax.swing.JTable();
        painelOutros = new javax.swing.JScrollPane();
        tabelaOutros = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("OpenPizza - Cardápio");
        setMinimumSize(new java.awt.Dimension(400, 700));
        setResizable(false);

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

        painelProdutos.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        painelProdutos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                painelProdutosMouseClicked(evt);
            }
        });

        tabelaPizzas.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        tabelaPizzas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabelaPizzas.setRowHeight(25);
        tabelaPizzas.setRowMargin(5);
        tabelaPizzas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaPizzasMouseClicked(evt);
            }
        });
        painelPizzas.setViewportView(tabelaPizzas);

        painelProdutos.addTab("Pizzas", painelPizzas);

        tabelaLanches.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        tabelaLanches.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabelaLanches.setRowHeight(25);
        tabelaLanches.setRowMargin(5);
        tabelaLanches.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaLanchesMouseClicked(evt);
            }
        });
        painelLanches.setViewportView(tabelaLanches);

        painelProdutos.addTab("Lanches", painelLanches);

        tabelaBebidas.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        tabelaBebidas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabelaBebidas.setRowHeight(25);
        tabelaBebidas.setRowMargin(5);
        tabelaBebidas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaBebidasMouseClicked(evt);
            }
        });
        painelBebidas.setViewportView(tabelaBebidas);

        painelProdutos.addTab("Bebidas", painelBebidas);

        tabelaOutros.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        tabelaOutros.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabelaOutros.setRowHeight(25);
        tabelaOutros.setRowMargin(5);
        tabelaOutros.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaOutrosMouseClicked(evt);
            }
        });
        painelOutros.setViewportView(tabelaOutros);

        painelProdutos.addTab("Outros", painelOutros);

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(botaoFechar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(143, Short.MAX_VALUE))
            .addGroup(painelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLayout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(painelProdutos, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(botaoFechar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
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
     Descrição: Evento do botão Fechar
     Parâmetros:
     Retorno:
     */
    private void botaoFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoFecharActionPerformed
        // Atualizar a tabela de itens do pedido, habilitar visualização da Tela de Pedido e fechar a janela atual
        this.getTelaPedido().formatarTabelaItensDoPedido();
        this.getTelaPedido().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_botaoFecharActionPerformed

    /*
     Descrição: Evento ao clicar na tabela de Pizzas
     Parâmetros:
     Retorno:
     */
    private void tabelaPizzasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaPizzasMouseClicked
        // Desabilitar a janela atual, recuperar o nome da pizza selecionada e criar a Tela de Inclusão de Produto
        this.setVisible(false);
        String nomeDaPizza = String.valueOf(this.tabelaPizzas.getValueAt(this.tabelaPizzas.getSelectedRow(), 0));
        TelaIncluirProduto telaIncluirPizza = new TelaIncluirProduto(this, this.getControle(), this.getAutenticacao(), "Pizza", nomeDaPizza, this.getNumeroDoPedido(), this.getNumeroDaMesa());
        telaIncluirPizza.setIconImage(new ImageIcon("../Imagens/pedaco_pizza.png").getImage());
        telaIncluirPizza.setVisible(true);
    }//GEN-LAST:event_tabelaPizzasMouseClicked

    /*
     Descrição: Evento ao clicar em uma guia de produtos (Pizza, Lanche, Bebida, Outros)
     Parâmetros:
     Retorno:
     */
    private void painelProdutosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_painelProdutosMouseClicked
        // Recuperação da guia escolhida
        int indiceEscolhido = this.painelProdutos.getSelectedIndex();

        JTable tabela;

        // Guia Pizzas -> Exibir cardápio de Pizzas
        if (indiceEscolhido <= 0) {
            this.getControle().consultarCardapio(this.tabelaPizzas, this.getAutenticacao(), "Pizza");
            tabela = this.tabelaPizzas;
        } // Guia Lanches -> Exibir cardápio de Lanches
        else if (indiceEscolhido == 1) {
            //this.getControle().consultarCardapioLanches(this.tabelaLanches, this.getAutenticacao());
            this.getControle().consultarCardapio(this.tabelaLanches, this.getAutenticacao(), "Lanche");
            tabela = this.tabelaLanches;
        } // Guia Bebidas -> Exibir cardápio de Bebidas
        else if (indiceEscolhido == 2) {
            //this.getControle().consultarCardapioBebidas(this.tabelaBebidas, this.getAutenticacao());
            this.getControle().consultarCardapio(this.tabelaBebidas, this.getAutenticacao(), "Bebida");
            tabela = this.tabelaBebidas;
        } // Guia Outros -> Exibir cardápio de Outros
        else {
            //this.getControle().consultarCardapioOutros(this.tabelaOutros, this.getAutenticacao());
            this.getControle().consultarCardapio(this.tabelaOutros, this.getAutenticacao(), "Outro");
            tabela = this.tabelaOutros;
        }

        // Exibição centralizada dos registros
        DefaultTableCellRenderer centralizarLabel = new DefaultTableCellRenderer();
        centralizarLabel.setHorizontalAlignment(JLabel.CENTER);

        // Formatação das colunas da tabela de exibição
        tabela.getColumnModel().getColumn(0).setHeaderValue("Produto");

    }//GEN-LAST:event_painelProdutosMouseClicked

    /*
     Descrição: Evento ao clicar na tabela de Lanches
     Parâmetros:
     Retorno:
     */
    private void tabelaLanchesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaLanchesMouseClicked
        // Desabilitar a janela atual, recuperar o nome da lanche selecionado e criar a Tela de Inclusão de Produto
        this.setVisible(false);
        String nomeDoLanche = String.valueOf(this.tabelaLanches.getValueAt(this.tabelaLanches.getSelectedRow(), 0));
        TelaIncluirProduto telaIncluirLanche = new TelaIncluirProduto(this, this.getControle(), this.getAutenticacao(), "Lanche", nomeDoLanche, this.getNumeroDoPedido(), this.getNumeroDaMesa());
        telaIncluirLanche.setIconImage(new ImageIcon("../Imagens/pedaco_pizza.png").getImage());
        telaIncluirLanche.setVisible(true);
    }//GEN-LAST:event_tabelaLanchesMouseClicked

    /*
     Descrição: Evento ao clicar na tabela de Bebidas
     Parâmetros:
     Retorno:
     */
    private void tabelaBebidasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaBebidasMouseClicked
        // Desabilitar a janela atual, recuperar o nome da bebida selecionada e criar a Tela de Inclusão de Produto
        this.setVisible(false);
        String nomeDoLanche = String.valueOf(this.tabelaBebidas.getValueAt(this.tabelaBebidas.getSelectedRow(), 0));
        TelaIncluirProduto telaIncluirBebidas = new TelaIncluirProduto(this, this.getControle(), this.getAutenticacao(), "Bebida", nomeDoLanche, this.getNumeroDoPedido(), this.getNumeroDaMesa());
        telaIncluirBebidas.setIconImage(new ImageIcon("../Imagens/pedaco_pizza.png").getImage());
        telaIncluirBebidas.setVisible(true);
    }//GEN-LAST:event_tabelaBebidasMouseClicked

    /*
     Descrição: Evento ao clicar na tabela de Outros
     Parâmetros:
     Retorno:
     */
    private void tabelaOutrosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaOutrosMouseClicked
        // Desabilitar a janela atual, recuperar o nome do outro selecionado e criar a Tela de Inclusão de Produto
        this.setVisible(false);
        String nomeDoLanche = String.valueOf(this.tabelaOutros.getValueAt(this.tabelaOutros.getSelectedRow(), 0));
        TelaIncluirProduto telaIncluirOutros = new TelaIncluirProduto(this, this.getControle(), this.getAutenticacao(), "Outro", nomeDoLanche, this.getNumeroDoPedido(), this.getNumeroDaMesa());
        telaIncluirOutros.setIconImage(new ImageIcon("../Imagens/pedaco_pizza.png").getImage());
        telaIncluirOutros.setVisible(true);
    }//GEN-LAST:event_tabelaOutrosMouseClicked

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
            java.util.logging.Logger.getLogger(TelaCardapio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCardapio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCardapio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCardapio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCardapio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoFechar;
    private javax.swing.JPanel painel;
    private javax.swing.JScrollPane painelBebidas;
    private javax.swing.JScrollPane painelLanches;
    private javax.swing.JScrollPane painelOutros;
    private javax.swing.JScrollPane painelPizzas;
    private javax.swing.JTabbedPane painelProdutos;
    private javax.swing.JTable tabelaBebidas;
    private javax.swing.JTable tabelaLanches;
    private javax.swing.JTable tabelaOutros;
    private javax.swing.JTable tabelaPizzas;
    // End of variables declaration//GEN-END:variables

    /*
     Descrição: Método get da telaPedido
     Parâmetros:
     Retorno:
     telaPedido (Referência à Tela de Pedido)
     */
    public TelaPedido getTelaPedido() {
        return telaPedido;
    }

    /*
     Descrição: Método set da telaPedido
     Parâmetros:
     telaPedido (Referência à Tela de Pedido)
     Retorno:
     */
    public void setTelaPedido(TelaPedido telaPedido) {
        this.telaPedido = telaPedido;
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
     Descrição: Método get do numeroDaMesa
     Parâmetros:
     Retorno:
     numeroDaMesa (Inteiro contendo o número da mesa selecionada na Tela de Pedido)
     */
    public int getNumeroDaMesa() {
        return numeroDaMesa;
    }

    /*
     Descrição: Método set do numeroDaMesa
     Parâmetros:
     numeroDaMesa (Inteiro contendo o número da mesa selecionada na Tela de Pedido)
     Retorno:
     */
    public void setNumeroDaMesa(int numeroDaMesa) {
        this.numeroDaMesa = numeroDaMesa;
    }
}
