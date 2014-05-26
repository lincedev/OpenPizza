package client.view;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.sql.*;
import client.persistencia.*;
import client.modelo.*;
import net.proteanit.sql.DbUtils;
import java.util.*;

/*
 Descrição: Tela de exibição do cardápio
 */
public class TelaCardapio extends javax.swing.JFrame {

    // Variável de referência da tela anterior
    private TelaPedido janelaPedido;

    // Variável para autenticação com o banco de dados
    private Autenticacao autenticacao;

    private Pedido infoPedido;

    // Objeto para interação com o banco de dados
    private final Banco banco = new Banco();

    ArrayList<Pizza> pizzas = new ArrayList();

    ArrayList<Lanche> lanches = new ArrayList();

    ArrayList<Bebidas> bebidas = new ArrayList();

    ArrayList<Outros> outros = new ArrayList();

    /*
     Descrição: Construtor padrão do objeto TelaCardapio
     Parâmetros:
     Retorno:
     */
    private TelaCardapio() {
        initComponents();
    }

    /*
     Descrição: Construtor completo do objeto TelaCardapio
     Parâmetros:
     *           janelaPedido (Necessário para controle dos métodos da janela anterior)
     Retorno:
     */
    public TelaCardapio(TelaPedido janelaPedido, Autenticacao autenticacao, Pedido infoPedido) {
        this();
        this.setJanelaPedido(janelaPedido);
        this.setAutenticacao(autenticacao);
        this.setInfoPedido(infoPedido);
        this.setIconImage(new ImageIcon("../Imagens/pedaco_pizza.png").getImage());
        exibirCardapio(this.getAutenticacao());
    }

    /*
     Descrição: Método get da janela de pedido
     Parâmetros:
     Retorno:
     *           janelaPedido (Necessário para controle dos métodos da janela anterior)
     */
    public TelaPedido getJanelaPedido() {
        return janelaPedido;
    }

    /*
     Descrição: Método set da janela de pedido
     Parâmetros:
     *           janelaPedido (Necessário para controle dos métodos da janela anterior)
     Retorno:
     */
    public void setJanelaPedido(TelaPedido janelaPedido) {
        this.janelaPedido = janelaPedido;
    }

    /*
     Descrição: Método get da autenticação
     Parâmetros:
     Retorno:
     *           autenticacao (Necessário para autenticação no banco de dados)
     */
    public Autenticacao getAutenticacao() {
        return autenticacao;
    }

    /*
     Descrição: Método set da autenticação
     Parâmetros:
     *           autenticacao (Necessário para autenticação no banco de dados)
     Retorno:
     */
    public void setAutenticacao(Autenticacao autenticacao) {
        this.autenticacao = autenticacao;
    }

    public Pedido getInfoPedido() {
        return infoPedido;
    }

    public void setInfoPedido(Pedido infoPedido) {
        this.infoPedido = infoPedido;
    }

    /*
     Descrição: Método para exibição dos produtos cadastrados por categoria
     Parâmetros:
     *           autenticacao (Necessário para autenticação no banco de dados)
     Retorno:
     */
    public void exibirCardapio(Autenticacao autenticacao) {
        try {
            String query = null;
            int indiceTabela = this.tabelaCardapio.getSelectedIndex();
            JTable tabela = null;

            // Seleção da categoria Pizza
            if (indiceTabela == 0) {
                query = "SELECT P.descricao FROM Produto AS P JOIN Pizza as PZ ON P.codigo = PZ.codProduto GROUP BY P.descricao ORDER BY P.descricao";
                tabela = this.tabela;
            } // Seleção da categoria Lanche
            else if (indiceTabela == 1) {
                query = "SELECT P.descricao, L.preco FROM Produto AS P JOIN Lanche AS L ON P.codigo = L.codProduto GROUP BY P.descricao ORDER BY P.descricao";
                tabela = this.tabelaLanches;
            } // Seleção da categoria Bebidas
            else if (indiceTabela == 2) {
                query = "SELECT P.descricao, B.preco FROM Produto AS P JOIN Bebidas AS B ON P.codigo = B.codProduto GROUP BY P.descricao ORDER BY P.descricao";
                tabela = this.tabelaBebidas;
            } // Seleção da categoria Outros
            else {
                query = "SELECT P.descricao, O.preco FROM Produto AS P JOIN Outros AS O ON P.codigo = O.codProduto GROUP BY P.descricao ORDER BY P.descricao";
                tabela = this.tabelaOutros;
            }

            // Recuperação dos produtos cadastrados de acordo com a categoria selecionada
            Connection con = DriverManager.getConnection(this.getAutenticacao().getCaminhoBanco(), this.getAutenticacao().getUsuarioBanco(), this.getAutenticacao().getUsuarioSenha());
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            // Formatação do modelo da tabela de exibição
            tabela.setModel(DbUtils.resultSetToTableModel(rs));
            tabela.setRowSelectionAllowed(true);

            // Exibição centralizada dos registros
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);

            // Formatação das colunas da tabela de exibição
            tabela.getColumnModel().getColumn(0).setHeaderValue("Produto");

            // // Formatação das demais tabelas de produtos (Lanches, Bebidas, Outros)
            if (indiceTabela != 0) {
                tabela.getColumnModel().getColumn(1).setHeaderValue("Preço");
                tabela.getColumnModel().getColumn(1).setMaxWidth(70);
                tabela.getColumnModel().getColumn(1).setCellRenderer(centerRenderer);
            }

            con.close();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível exibir os produtos cadastrados.", "Erro", JOptionPane.ERROR_MESSAGE);
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

        tabelaCardapio = new javax.swing.JTabbedPane();
        abaPizzas = new javax.swing.JScrollPane();
        tabela = new javax.swing.JTable();
        abaLanches = new javax.swing.JScrollPane();
        tabelaLanches = new javax.swing.JTable();
        abaBebidas = new javax.swing.JScrollPane();
        tabelaBebidas = new javax.swing.JTable();
        abaOutros = new javax.swing.JScrollPane();
        tabelaOutros = new javax.swing.JTable();
        fecharCardapio = new javax.swing.JButton();

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

        tabelaCardapio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabelaCardapio.setMinimumSize(new java.awt.Dimension(100, 100));
        tabelaCardapio.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaCardapioMouseClicked(evt);
            }
        });

        tabela.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabela.setSelectionBackground(new java.awt.Color(255, 255, 255));
        tabela.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaMouseClicked(evt);
            }
        });
        abaPizzas.setViewportView(tabela);

        tabelaCardapio.addTab("Pizzas", abaPizzas);

        tabelaLanches.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        abaLanches.setViewportView(tabelaLanches);

        tabelaCardapio.addTab("Lanches", abaLanches);

        tabelaBebidas.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        abaBebidas.setViewportView(tabelaBebidas);

        tabelaCardapio.addTab("Bebidas", abaBebidas);

        tabelaOutros.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        abaOutros.setViewportView(tabelaOutros);

        tabelaCardapio.addTab("Outros", abaOutros);

        fecharCardapio.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        fecharCardapio.setText("Fechar");
        fecharCardapio.setPreferredSize(new java.awt.Dimension(75, 30));
        fecharCardapio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fecharCardapioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabelaCardapio, javax.swing.GroupLayout.DEFAULT_SIZE, 330, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addGap(122, 122, 122)
                .addComponent(fecharCardapio, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(tabelaCardapio, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(fecharCardapio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /*
     Descrição: Método do botão Fechar (X)
     Parâmetros:
     Retorno:
     */
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // Retorno à tela anterior
        this.getJanelaPedido().setEnabled(true);
    }//GEN-LAST:event_formWindowClosed

    /*
     Descrição: Método do botão Fechar Cardápio
     Parâmetros:
     Retorno:
     */
    private void fecharCardapioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fecharCardapioActionPerformed
        // Retorno à tela anterior
        this.dispose();
    }//GEN-LAST:event_fecharCardapioActionPerformed

    /*
     Descrição: Método do botão Exibir Cardápio. Exibe os produtos cadastrados por categoria.
     Parâmetros:
     Retorno:
     */
    private void tabelaCardapioMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaCardapioMouseClicked
        // Exibição do cardápio por categoria
        exibirCardapio(this.getAutenticacao());
    }//GEN-LAST:event_tabelaCardapioMouseClicked

    /*
     Descrição: Método para exibição das informações do produto selecionado
     Parâmetros:
     Retorno:
     */
    private void tabelaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaMouseClicked
        // TODO add your handling code here:
        if (this.tabelaCardapio.getSelectedIndex() == 0) {
            TelaInformacoesPizza infoPizza = new TelaInformacoesPizza(this, this.getAutenticacao(), this.tabelaCardapio.getSelectedIndex(), this.tabela.getSelectedRow(), this.getInfoPedido());
            infoPizza.setSize(350, 600);
            infoPizza.setVisible(true);
        }
    }//GEN-LAST:event_tabelaMouseClicked

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
    private javax.swing.JScrollPane abaBebidas;
    private javax.swing.JScrollPane abaLanches;
    private javax.swing.JScrollPane abaOutros;
    private javax.swing.JScrollPane abaPizzas;
    private javax.swing.JButton fecharCardapio;
    private javax.swing.JTable tabela;
    private javax.swing.JTable tabelaBebidas;
    private javax.swing.JTabbedPane tabelaCardapio;
    private javax.swing.JTable tabelaLanches;
    private javax.swing.JTable tabelaOutros;
    // End of variables declaration//GEN-END:variables

}
