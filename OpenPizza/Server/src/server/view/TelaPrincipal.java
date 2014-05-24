package server.view;

import java.sql.*;
import javax.swing.*;
import server.modelo.Autenticacao;
import server.persistencia.Arquivos;
import java.io.*;

/*
 Descrição: Tela principal do servidor
 */
public class TelaPrincipal extends javax.swing.JFrame implements Serializable {

    // Variável para armazenamento dos dados de autenticação do banco de dados
    public Autenticacao autenticacao;

    /*
     Descrição: Criação da tela principal do servidor.
     Parâmetros: 
     Retorno:
     */
    public TelaPrincipal() {
        initComponents();
        this.setIconImage(new ImageIcon("../Imagens/pedaco_pizza.png").getImage());
        verificarAutenticacao();
    }

    /*
     Descrição: Método para tentativa de autenticação dos dados do banco de dados.
     Parâmetros:
     Retorno:
     */
    public void verificarAutenticacao() {
        Arquivos arquivo = new Arquivos();
        try {
            autenticacao = arquivo.lerArquivo();
            try {
                // Se a conexão foi efetuada, o botão de autenticação é desabilitado e o botão para abrir pedido é habilitado.
                Connection conexao = DriverManager.getConnection(autenticacao.getCaminhoBanco(), autenticacao.getUsuarioBanco(), autenticacao.getUsuarioSenha());
                conexao.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Não foi possível autenticar a conexão.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível estabelecer conexão automática com o banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
            this.menuExibir.setEnabled(false);
            this.menuProdutos.setEnabled(false);
            this.menuMesas.setEnabled(false);
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

        jMenuItem1 = new javax.swing.JMenuItem();
        jFrame1 = new javax.swing.JFrame();
        jLabel1 = new javax.swing.JLabel();
        barraMenus = new javax.swing.JMenuBar();
        menuArquivo = new javax.swing.JMenu();
        itemMenuAutenticarBanco = new javax.swing.JMenuItem();
        itemMenuImprimir = new javax.swing.JMenuItem();
        itemMenuSair = new javax.swing.JMenuItem();
        menuExibir = new javax.swing.JMenu();
        itemMenuExibirPedidosEmAberto = new javax.swing.JMenuItem();
        itemMenuExibirProdutosCadastrados = new javax.swing.JMenuItem();
        menuItemExibirRelatorios = new javax.swing.JMenuItem();
        menuProdutos = new javax.swing.JMenu();
        itemMenuProdutosPizzas = new javax.swing.JMenuItem();
        itemMenuProdutosLanches = new javax.swing.JMenuItem();
        itemMenuProdutosBebidas = new javax.swing.JMenuItem();
        itemMenuProdutosOutros = new javax.swing.JMenuItem();
        menuMesas = new javax.swing.JMenu();

        jMenuItem1.setText("jMenuItem1");

        javax.swing.GroupLayout jFrame1Layout = new javax.swing.GroupLayout(jFrame1.getContentPane());
        jFrame1.getContentPane().setLayout(jFrame1Layout);
        jFrame1Layout.setHorizontalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jFrame1Layout.setVerticalGroup(
            jFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("OpenPizza - Server");
        setMinimumSize(new java.awt.Dimension(900, 600));
        setName("FramePrincipal"); // NOI18N
        setResizable(false);
        getContentPane().setLayout(null);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/server/view/logo.png"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(310, 150, 300, 240);

        menuArquivo.setText("Arquivo");
        menuArquivo.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        itemMenuAutenticarBanco.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_B, java.awt.event.InputEvent.CTRL_MASK));
        itemMenuAutenticarBanco.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemMenuAutenticarBanco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/server/view/icones/Database.png"))); // NOI18N
        itemMenuAutenticarBanco.setText("Autenticar Banco de Dados");
        itemMenuAutenticarBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuAutenticarBancoActionPerformed(evt);
            }
        });
        menuArquivo.add(itemMenuAutenticarBanco);

        itemMenuImprimir.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_P, java.awt.event.InputEvent.CTRL_MASK));
        itemMenuImprimir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemMenuImprimir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/server/view/icones/Print.png"))); // NOI18N
        itemMenuImprimir.setText("Imprimir");
        menuArquivo.add(itemMenuImprimir);

        itemMenuSair.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemMenuSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/server/view/icones/Log_Out.png"))); // NOI18N
        itemMenuSair.setText("Sair");
        itemMenuSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuSairActionPerformed(evt);
            }
        });
        menuArquivo.add(itemMenuSair);

        barraMenus.add(menuArquivo);

        menuExibir.setText("Exibir");
        menuExibir.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        itemMenuExibirPedidosEmAberto.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A, java.awt.event.InputEvent.CTRL_MASK));
        itemMenuExibirPedidosEmAberto.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemMenuExibirPedidosEmAberto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/server/view/icones/Note.png"))); // NOI18N
        itemMenuExibirPedidosEmAberto.setText("Pedidos em Aberto");
        menuExibir.add(itemMenuExibirPedidosEmAberto);

        itemMenuExibirProdutosCadastrados.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemMenuExibirProdutosCadastrados.setIcon(new javax.swing.ImageIcon(getClass().getResource("/server/view/icones/product.png"))); // NOI18N
        itemMenuExibirProdutosCadastrados.setText("Produtos Cadastrados");
        menuExibir.add(itemMenuExibirProdutosCadastrados);

        menuItemExibirRelatorios.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R, java.awt.event.InputEvent.CTRL_MASK));
        menuItemExibirRelatorios.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        menuItemExibirRelatorios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/server/view/icones/Stats.png"))); // NOI18N
        menuItemExibirRelatorios.setText("Relatórios");
        menuExibir.add(menuItemExibirRelatorios);

        barraMenus.add(menuExibir);

        menuProdutos.setText("Produtos");
        menuProdutos.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N

        itemMenuProdutosPizzas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemMenuProdutosPizzas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/server/view/icones/pizza.png"))); // NOI18N
        itemMenuProdutosPizzas.setText("Pizzas");
        itemMenuProdutosPizzas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuProdutosPizzasActionPerformed(evt);
            }
        });
        menuProdutos.add(itemMenuProdutosPizzas);

        itemMenuProdutosLanches.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemMenuProdutosLanches.setIcon(new javax.swing.ImageIcon(getClass().getResource("/server/view/icones/burger.png"))); // NOI18N
        itemMenuProdutosLanches.setText("Lanches");
        itemMenuProdutosLanches.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuProdutosLanchesActionPerformed(evt);
            }
        });
        menuProdutos.add(itemMenuProdutosLanches);

        itemMenuProdutosBebidas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemMenuProdutosBebidas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/server/view/icones/bebidas.png"))); // NOI18N
        itemMenuProdutosBebidas.setText("Bebidas");
        itemMenuProdutosBebidas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuProdutosBebidasActionPerformed(evt);
            }
        });
        menuProdutos.add(itemMenuProdutosBebidas);

        itemMenuProdutosOutros.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        itemMenuProdutosOutros.setIcon(new javax.swing.ImageIcon("C:\\Users\\Gustavo\\Documents\\GitHub\\OpenPizza\\OpenPizza\\OpenPizza\\Icones\\chocolate.png")); // NOI18N
        itemMenuProdutosOutros.setText("Outros");
        itemMenuProdutosOutros.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemMenuProdutosOutrosActionPerformed(evt);
            }
        });
        menuProdutos.add(itemMenuProdutosOutros);

        barraMenus.add(menuProdutos);

        menuMesas.setText("Mesas");
        menuMesas.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        barraMenus.add(menuMesas);

        setJMenuBar(barraMenus);

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /*
     Descrição: Método para sair da aplicação pelo menu Arquivo > Sair
     Parâmetros: 
     Retorno:
     */
    private void itemMenuSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuSairActionPerformed
        // Fechar aplicação
        System.exit(0);
    }//GEN-LAST:event_itemMenuSairActionPerformed

    /*
     Descrição: Método para criação da janela de autenticação do banco de dados.
     Parâmetros: 
     Retorno:
     */
    private void itemMenuAutenticarBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuAutenticarBancoActionPerformed
        // Criação da janela de autenticação do banco de dados
        TelaAutenticacao telaAutenticacao = new TelaAutenticacao(this, this.autenticacao,this.menuExibir,this.menuProdutos,this.menuMesas);
        telaAutenticacao.setResizable(false);
        telaAutenticacao.setVisible(true);
    }//GEN-LAST:event_itemMenuAutenticarBancoActionPerformed

    private void itemMenuProdutosPizzasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuProdutosPizzasActionPerformed
        // TODO add your handling code here:
        TelaCRUDPizza tpizza = new TelaCRUDPizza();
        tpizza.setVisible(true);
    }//GEN-LAST:event_itemMenuProdutosPizzasActionPerformed

    private void itemMenuProdutosOutrosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuProdutosOutrosActionPerformed
        // TODO add your handling code here:
        TelaCRUDOutros tOutros = new TelaCRUDOutros();
        tOutros.setVisible(true);
    }//GEN-LAST:event_itemMenuProdutosOutrosActionPerformed

    private void itemMenuProdutosLanchesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuProdutosLanchesActionPerformed
        // TODO add your handling code here:
        TelaCRUDLanches tLanches =new TelaCRUDLanches();
        tLanches.setVisible(true);
    }//GEN-LAST:event_itemMenuProdutosLanchesActionPerformed

    private void itemMenuProdutosBebidasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_itemMenuProdutosBebidasActionPerformed
        // TODO add your handling code here:
        TelaCRUDBebidas tBebidas =new TelaCRUDBebidas();
        tBebidas.setVisible(true);
    }//GEN-LAST:event_itemMenuProdutosBebidasActionPerformed

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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenuBar barraMenus;
    private javax.swing.JMenuItem itemMenuAutenticarBanco;
    private javax.swing.JMenuItem itemMenuExibirPedidosEmAberto;
    private javax.swing.JMenuItem itemMenuExibirProdutosCadastrados;
    private javax.swing.JMenuItem itemMenuImprimir;
    private javax.swing.JMenuItem itemMenuProdutosBebidas;
    private javax.swing.JMenuItem itemMenuProdutosLanches;
    private javax.swing.JMenuItem itemMenuProdutosOutros;
    private javax.swing.JMenuItem itemMenuProdutosPizzas;
    private javax.swing.JMenuItem itemMenuSair;
    private javax.swing.JFrame jFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenu menuArquivo;
    private javax.swing.JMenu menuExibir;
    private javax.swing.JMenuItem menuItemExibirRelatorios;
    private javax.swing.JMenu menuMesas;
    private javax.swing.JMenu menuProdutos;
    // End of variables declaration//GEN-END:variables
}
