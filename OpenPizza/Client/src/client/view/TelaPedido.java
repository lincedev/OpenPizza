package client.view;

import client.modelo.*;
import client.persistencia.*;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import net.proteanit.sql.DbUtils;

/*
 Descrição: Tela de pedido
 */
public class TelaPedido extends javax.swing.JFrame {

    // Variável para armazenamento da tela principal.
    private TelaPrincipal janelaPrincipal;

    // Variável para armazenamento dos dados de autenticação do banco de dados.
    private Autenticacao autenticacao;

    // Objeto para realização de operações no banco de dados.
    private Banco banco = new Banco();

    // Objeto para armazenamento das informações de determinado pedido.
    private Pedido infoPedido;

    /*
     Descrição: Construtor padrão da janela de pedidos.
     Parâmetros:
     Retorno:
     */
    private TelaPedido() {
        initComponents();
    }

    /*
     Descrição: Construtor completo da janela de pedidos.
     Parâmetros: janelaPrincipal (Necessário para controle dos métodos da janela anterior)
     *          autenticacao (Necessário para realizar operações no banco de dados)
     Retorno:
     */
    public TelaPedido(TelaPrincipal janelaPrincipal, Autenticacao autenticacao) {
        this();
        this.setIconImage(new ImageIcon("../Imagens/pedaco_pizza.png").getImage());
        this.setJanelaPrincipal(janelaPrincipal);
        this.setAutenticacao(autenticacao);
        this.botaoExibirCardapio.setEnabled(false);
        this.botaoFinalizarPedido.setEnabled(false);
        preencherComboBoxMesas();
    }

    /*
     Descrição: Método set para a variável janelaPrincipal.
     Parâmetros: 
     *           janelaPrincipal (Necessário para controle dos métodos da janela principal)
     Retorno:
     */
    public void setJanelaPrincipal(TelaPrincipal janelaPrincipal) {
        this.janelaPrincipal = janelaPrincipal;
    }

    /*
     Descrição: Método get para a variável janelaPrincipal
     Parâmetros:
     Retorno:
     *           janelaPrincipal (Necessário para controle dos métodos da janela anterior)
     */
    public TelaPrincipal getJanelaPrincipal() {
        return janelaPrincipal;
    }

    /*
     Descrição: Método set para a variável autenticação.
     Parâmetros: 
     *           autenticacao (Caminho para o banco de dados)
     Retorno:
     */
    public void setAutenticacao(Autenticacao autenticacao) {
        this.autenticacao = autenticacao;
    }

    /*
     Descrição: Método get para a variável autenticação
     Parâmetros:
     Retorno: 
     *           autenticacao (Objeto do tipo Autenticação com os dados de acesso ao banco de dados)
     */
    public Autenticacao getAutenticacao() {
        return this.autenticacao;
    }

    /*
     Descrição: Método set para o objeto infoPedido.
     Parâmetros: 
     *           infoPedido (Objeto que recebe as informações de determinado pedido)
     Retorno:
     */
    public void setInfoPedido(Pedido infoPedido) {
        this.infoPedido = infoPedido;
    }

    /*
     Descrição: Método get para o objeto infoPedido.
     Parâmetros:
     Retorno: 
     *           infoPedido (Objeto contendo as informações de um determinado pedido)
     */
    public Pedido getInfoPedido() {
        return infoPedido;
    }

    /*
     Descrição: Método para preenchimento da ComboBox com o número das mesas existentes no banco de dados.
     Parâmetros:
     Retorno:
     */
    public void preencherComboBoxMesas() {
        Connection conexao = null;
        try {
            conexao = banco.abrirConexao(this.getAutenticacao());
            PreparedStatement pst = conexao.prepareStatement("SELECT * FROM Mesa");
            ResultSet resultado = pst.executeQuery();
            while (resultado.next()) {
                String numeroMesa = resultado.getString("numero");
                this.comboboxMesas.addItem(numeroMesa);
            }
        } catch (Exception e) {
            
        } finally {
            try {
                banco.fecharConexao(conexao);
            } catch (Exception e) {
                
            }
        }
    }

    /*
     Descrição: Método para exibição dos itens do pedido e atualização das labels de número do pedido e valor total.
     Parâmetros:
     *           infoPedido (Objeto contendo informações do pedido atual)
     Retorno:
     */
    public void formatarTabelaItensDoPedido(Pedido infoPedido) {
        
        try {
            // Atualização da label de número do pedido
            this.labelNumeroDoPedido.setText(String.valueOf(infoPedido.getNumeroPedido()));

            // Recuperação dos dados referentes ao pedido
            String query = "SELECT P.descricao, IDP.tamanho, IDP.qtdadeProdutos, IDP.preco FROM ItemDoPedido AS IDP JOIN Produto AS P ON codigoProduto = codigo WHERE pedidoNumero = " + infoPedido.getNumeroPedido();
            Connection con = banco.abrirConexao(this.getAutenticacao());
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            // Formatação da tabela de exibição dos dados
            this.tabelaItensDoPedido.setModel(DbUtils.resultSetToTableModel(rs));

            // Exibição centralizada dos registros
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

            // Tentativa de recuperação e atualização da label do valor total
            try {
                query = "SELECT qtdadeProdutos, preco FROM ItemDoPedido WHERE pedidoNumero = " + infoPedido.getNumeroPedido();
                float valorTotal = banco.consultarValorDoPedido(autenticacao, query);
                this.labelValorTotal.setText(String.valueOf(valorTotal));
                con.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao recuperar o valor total do pedido.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
            
            banco.fecharConexao(con);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível recuperar os itens do pedido.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    /*
     Descrição: Esse método exibe uma tabela contendo os itens referentes à mesa 
     *           escolhida e o número do pedido atual.
     Parâmetros:
     Retorno:
     */
    public void exibirPedidoDaMesa() {

        // Ignorar o primeiro elemento da combobox
        if (this.comboboxMesas.getSelectedIndex() != 0) {

            this.tabelaItensDoPedido.setVisible(true);
            this.botaoFechar.setEnabled(false);
            this.botaoExibirCardapio.setEnabled(true);
            this.botaoFinalizarPedido.setEnabled(true);
            // Tentativa de recuperação de pedido em aberto
            try {
                String query = "SELECT * FROM Pedido WHERE numeroMesa = " + String.valueOf(this.comboboxMesas.getSelectedItem()) + " AND pedidoFinalizado = false";
                infoPedido = banco.consultarPedido(this.getAutenticacao(), query);
                
                // Pedido em aberto não encontrado -> Inserção do novo pedido
                if (infoPedido.getNumeroPedido() == 0) {

                    // Tentativa de inserção do novo pedido
                    try {
                        query = "INSERT INTO Pedido(data, horaInicio, valor, formaPagamento, numeroMesa, pedidoFinalizado) VALUES(current_date, current_time, 0.0, null," + String.valueOf(this.comboboxMesas.getSelectedItem()) + ", false)";
                        banco.executarSQL(this.getAutenticacao(), query);

                        // Tentativa de acesso aos dados do pedido inserido e atualização das labels numero do pedido e valor total
                        try {
                            query = "SELECT * FROM Pedido WHERE numeroMesa = " + String.valueOf(this.comboboxMesas.getSelectedItem()) + " AND pedidoFinalizado = false";
                            infoPedido = banco.consultarPedido(this.getAutenticacao(), query);
                            if (infoPedido.getNumeroPedido() != 0) {

                                // Tentativa de exibição dos itens referentes à mesa e número de pedido
                                formatarTabelaItensDoPedido(infoPedido);
                            }
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Erro ao recuperar o pedido relacionado à mesa.", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Não foi possível abrir um novo pedido.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } // Pedido em aberto encontrado -> Exibição dos itens referentes à mesa e pedido
                else {

                    // Tentativa de exibição dos itens referentes à mesa e número de pedido
                    formatarTabelaItensDoPedido(infoPedido);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Não foi possível acessar as informações do pedido.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } else {
            this.labelNumeroDoPedido.setText("---");
            this.labelValorTotal.setText("---");
            this.tabelaItensDoPedido.setVisible(false);
            this.botaoFechar.setEnabled(true);
            this.botaoExibirCardapio.setEnabled(false);
            this.botaoFinalizarPedido.setEnabled(false);
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

        botaoExibirCardapio = new javax.swing.JButton();
        botaoFinalizarPedido = new javax.swing.JButton();
        labelMesa = new javax.swing.JLabel();
        labelPedido = new javax.swing.JLabel();
        labelTotal = new javax.swing.JLabel();
        comboboxMesas = new javax.swing.JComboBox();
        labelNumeroDoPedido = new javax.swing.JLabel();
        labelValorTotal = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaItensDoPedido = new javax.swing.JTable();
        botaoFechar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("OpenPizza");
        setMaximumSize(new java.awt.Dimension(350, 600));
        setMinimumSize(new java.awt.Dimension(350, 600));
        setPreferredSize(new java.awt.Dimension(350, 600));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        botaoExibirCardapio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoExibirCardapio.setText("Cardápio");
        botaoExibirCardapio.setMaximumSize(new java.awt.Dimension(100, 30));
        botaoExibirCardapio.setMinimumSize(new java.awt.Dimension(100, 30));
        botaoExibirCardapio.setPreferredSize(new java.awt.Dimension(100, 30));
        botaoExibirCardapio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExibirCardapioActionPerformed(evt);
            }
        });

        botaoFinalizarPedido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoFinalizarPedido.setText("Finalizar");
        botaoFinalizarPedido.setMaximumSize(new java.awt.Dimension(100, 30));
        botaoFinalizarPedido.setMinimumSize(new java.awt.Dimension(100, 30));
        botaoFinalizarPedido.setPreferredSize(new java.awt.Dimension(100, 30));
        botaoFinalizarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoFinalizarPedidoActionPerformed(evt);
            }
        });

        labelMesa.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        labelMesa.setText("Mesa: ");

        labelPedido.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        labelPedido.setText("Pedido: ");

        labelTotal.setFont(new java.awt.Font("Cantarell", 0, 14)); // NOI18N
        labelTotal.setText("Total:");

        comboboxMesas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboboxMesas.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione a mesa" }));
        comboboxMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboboxMesasActionPerformed(evt);
            }
        });

        labelNumeroDoPedido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelNumeroDoPedido.setText("---");

        labelValorTotal.setFont(new java.awt.Font("Cantarell", 1, 14)); // NOI18N
        labelValorTotal.setText("---");

        tabelaItensDoPedido.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabelaItensDoPedido.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabelaItensDoPedido);

        botaoFechar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        botaoFechar.setText("Fechar");
        botaoFechar.setMaximumSize(new java.awt.Dimension(100, 30));
        botaoFechar.setMinimumSize(new java.awt.Dimension(100, 30));
        botaoFechar.setPreferredSize(new java.awt.Dimension(100, 30));
        botaoFechar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                botaoFecharMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(labelMesa)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(comboboxMesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelPedido)
                        .addGap(18, 18, 18)
                        .addComponent(labelNumeroDoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(labelTotal)
                        .addGap(27, 27, 27)
                        .addComponent(labelValorTotal)))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(botaoFechar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoExibirCardapio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(botaoFinalizarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelNumeroDoPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelMesa)
                        .addComponent(comboboxMesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelPedido)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelTotal)
                    .addComponent(labelValorTotal))
                .addGap(39, 39, 39)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addComponent(botaoFechar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoExibirCardapio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoFinalizarPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /*
     Descrição: Método para finalizar o pedido contendo os produtos selecionados ou cancelar um pedido que não contém itens.
     Parâmetros:
     Retorno:
     */
    private void botaoFinalizarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoFinalizarPedidoActionPerformed
      
        // Recebimento da resposta ao finalizar o pedido
        int finalizar = JOptionPane.showConfirmDialog(null, "Deseja realmente finalizar o pedido atual?", "Finalizar Pedido", JOptionPane.OK_CANCEL_OPTION);
        // Verificação da opção escolhida
        if (finalizar == JOptionPane.OK_OPTION) {

            // Tentativa de fechamento de pedido
            try {
                
                // Recuperação das informações do pedido atual
                String query = "SELECT * FROM Pedido WHERE numeroMesa = " + String.valueOf(this.comboboxMesas.getSelectedItem()) + " AND pedidoFinalizado = false";
                Connection cn = banco.abrirConexao(this.getAutenticacao());
                Statement st = cn.createStatement();
                ResultSet rs = st.executeQuery(query);
                if(rs.next()){
                    this.infoPedido.setNumeroPedido(rs.getInt("numeroPedido"));
                    this.infoPedido.setData(rs.getString("data"));
                    this.infoPedido.setHora(rs.getString("horaInicio"));
                    this.infoPedido.setValor(rs.getFloat("valor"));
                    this.infoPedido.setFormaPagamento(rs.getString("formaPagamento"));
                    this.infoPedido.setPedidoFinalizado(rs.getBoolean("pedidoFinalizado"));
                }
                banco.fecharConexao(cn);
                
                // Verificação de pedido sem itens
                if (this.infoPedido.getValor() == 0.0) {

                    // Recebimento da opção caso o usuário deseje cancelar o pedido
                    int confirmar = JOptionPane.showConfirmDialog(null, "Não há itens no pedido atual.\nDeseja cancelar o pedido?", "Finalizar Pedido", JOptionPane.OK_CANCEL_OPTION);

                    // Verificação da opção escolhida
                    if (confirmar == JOptionPane.OK_OPTION) {

                        // Tentativa de cancelamento do pedido
                        try {
                            banco.cancelarPedido(this.getAutenticacao(), this.infoPedido);
                            JOptionPane.showMessageDialog(null, "Pedido cancelado.", "Finalizar Pedido", JOptionPane.INFORMATION_MESSAGE);
                            this.comboboxMesas.setSelectedIndex(0);
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar cancelar o pedido atual.", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    }
                } // Verificação de pedido com itens 
                else {

                    // Tentativa de finalização de pedido
                    try {
                        
                        // Obtenção da forma de pagamento
                        boolean continuar = false;
                        while(!continuar){
                            try{
                                Object[] opcoesPagamento = {"Dinheiro", "Cartão"};
                                int opcaoEscolhida = JOptionPane.showOptionDialog(null, "Escolha a forma de pagamento:", "Forma de Pagamento", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, opcoesPagamento, null);
                                this.infoPedido.setFormaPagamento((String) opcoesPagamento[opcaoEscolhida]);
                                continuar = true;
                            }
                            catch(Exception e){
                                JOptionPane.showMessageDialog(null, "Opção inválida!", "Aviso", JOptionPane.WARNING_MESSAGE);
                            }
                        }
                        
                        // Finalização do pedido
                        banco.finalizarPedido(this.getAutenticacao(), this.infoPedido);
                        JOptionPane.showMessageDialog(null, "Pedido finalizado com sucesso.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                        
                        this.comboboxMesas.setSelectedIndex(0);
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar finalizar o pedido atual.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Não foi possível recuperar as informações do pedido atual.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_botaoFinalizarPedidoActionPerformed

    /*
     Descrição: Método para tornar visível a janela principal ao clicar no ícone fechar.
     Parâmetros:
     Retorno:
     */
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // Tornar a janela principal visível
        janelaPrincipal.setVisible(true);
    }//GEN-LAST:event_formWindowClosed

    /*
     Descrição: Método para criação da janela de cardápio e exibição dos produtos cadastrados.
     Parâmetros:
     Retorno:
     */
    private void botaoExibirCardapioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExibirCardapioActionPerformed
        // Criação da janela cardápio
        TelaCardapio janelaCardapio = new TelaCardapio(this, this.getAutenticacao(), infoPedido);
        this.setEnabled(false);
        janelaCardapio.setResizable(false);
        janelaCardapio.setVisible(true);
    }//GEN-LAST:event_botaoExibirCardapioActionPerformed

    /*
     Descrição: Método disparado ao selecionar uma mesa na ComboBox.  
     Parâmetros:
     Retorno:
     */
    private void comboboxMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboboxMesasActionPerformed
        // Exibição do pedido referente à mesa
        this.exibirPedidoDaMesa();
    }//GEN-LAST:event_comboboxMesasActionPerformed

    /*
     Descrição: Método do botão Fechar.
     Parâmetros:
     Retorno:
     */
    private void botaoFecharMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_botaoFecharMouseClicked
        // Caso o botão esteja habilitado
        if (this.botaoFechar.isEnabled()) {
            // Voltar à janela principal
            this.dispose();
        }
    }//GEN-LAST:event_botaoFecharMouseClicked

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
            java.util.logging.Logger.getLogger(TelaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPedido.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPedido().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoExibirCardapio;
    private javax.swing.JButton botaoFechar;
    private javax.swing.JButton botaoFinalizarPedido;
    private javax.swing.JComboBox comboboxMesas;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelMesa;
    private javax.swing.JLabel labelNumeroDoPedido;
    private javax.swing.JLabel labelPedido;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JLabel labelValorTotal;
    private javax.swing.JTable tabelaItensDoPedido;
    // End of variables declaration//GEN-END:variables

}
