/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server.view;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import net.proteanit.sql.DbUtils;
import server.controle.Controle;
import server.modelo.Autenticacao;
import server.persistencia.Banco;

/**
 *
 * @author Gustavo
 */
public class TelaCRUDMesas extends javax.swing.JFrame {

    /**
     * Creates new form TelaCRUDMesas
     */
    
    private Controle controle;
    
    // Variável para armazenar a tela CRUDOutros
    private TelaPrincipal janelaPrincipal;
    
    // Variável para armazenar a autenticação do banco de dados
    private Autenticacao autenticacaoServer;
    
    
    /*
     Descrição: Construtor padrão da Tela CRUD Mesas.
     Parâmetros:
     Retorno:
     Data Última Alteração: 03/07/2014 
     */
    private TelaCRUDMesas() {
        initComponents();
    }

    public TelaCRUDMesas(TelaPrincipal janelaPrincipal, Autenticacao autenticacaoServer, Controle controle) {
        this();
        this.setAutenticacaoServer(autenticacaoServer);
        this.setJanelaPrincipal(janelaPrincipal);
        this.setControle(controle);
        this.getControle().exibirProdutos(this.getAutenticacaoServer(), this.tabelaCRUDMesas, "Mesa");
    }

    
    /*
     Descrição: Método para exibição de Outros cadastrados
     Parâmetros:
     *           autenticacao (Necessário para acesso/consulta no banco de dados)
     Retorno:      
     Data Última Alteração: 03/07/2014 
    */
    public void exibirMesas(Autenticacao autenticacaoServer) {
        Controle controle = new Controle();
        controle.verificarAutenticacao();
        try {
            String query = null;
            JTable tabelaMesas = null;
            
            query = "SELECT m.numero FROM Mesa AS m";
            
            // Recuperação dos produtos cadastrados de acordo com a categoria selecionada
            Connection con = DriverManager.getConnection(this.getAutenticacaoServer().getCaminhoBanco(), this.getAutenticacaoServer().getUsuarioBanco(), this.getAutenticacaoServer().getUsuarioSenha());
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(query);

            tabelaMesas = this.tabelaCRUDMesas;
            
            // Formatação do modelo da tabela de exibição
            tabelaMesas.setModel(DbUtils.resultSetToTableModel(rs));
            tabelaMesas.setRowSelectionAllowed(true);

            // Exibição centralizada dos registros
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);

            // Formatação das colunas da tabela de exibição
            tabelaMesas.getColumnModel().getColumn(0).setHeaderValue("Numero");

            // Centralizar
            tabelaMesas.getColumnModel().getColumn(0).setCellRenderer(centerRenderer);

            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            //JOptionPane.showMessageDialog(null, "Não foi possível exibir as pizzas cadastrados.", "Erro", JOptionPane.ERROR_MESSAGE);
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
        tabelaCRUDMesas = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        botaoVoltarTelaCRUDMesas = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("OpenPizza - Mesas");
        setMaximumSize(new java.awt.Dimension(340, 320));
        setMinimumSize(new java.awt.Dimension(340, 320));
        setPreferredSize(new java.awt.Dimension(340, 320));
        setResizable(false);

        tabelaCRUDMesas.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        tabelaCRUDMesas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        tabelaCRUDMesas.setRowHeight(25);
        tabelaCRUDMesas.setRowMargin(5);
        jScrollPane1.setViewportView(tabelaCRUDMesas);

        botaoVoltarTelaCRUDMesas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/server/view/icones_CRUD/voltar.png"))); // NOI18N
        botaoVoltarTelaCRUDMesas.setBorderPainted(false);
        botaoVoltarTelaCRUDMesas.setContentAreaFilled(false);
        botaoVoltarTelaCRUDMesas.setFocusable(false);
        botaoVoltarTelaCRUDMesas.setMaximumSize(new java.awt.Dimension(63, 63));
        botaoVoltarTelaCRUDMesas.setMinimumSize(new java.awt.Dimension(63, 63));
        botaoVoltarTelaCRUDMesas.setPreferredSize(new java.awt.Dimension(63, 63));
        botaoVoltarTelaCRUDMesas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoVoltarTelaCRUDMesasActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/server/view/icones_CRUD/AdicionarPizza.png"))); // NOI18N
        jButton2.setBorderPainted(false);
        jButton2.setContentAreaFilled(false);
        jButton2.setMaximumSize(new java.awt.Dimension(63, 63));
        jButton2.setMinimumSize(new java.awt.Dimension(63, 63));
        jButton2.setPreferredSize(new java.awt.Dimension(63, 63));

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/server/view/icones_CRUD/DeleterPizza.png"))); // NOI18N
        jButton5.setBorderPainted(false);
        jButton5.setContentAreaFilled(false);
        jButton5.setMaximumSize(new java.awt.Dimension(63, 63));
        jButton5.setMinimumSize(new java.awt.Dimension(63, 63));
        jButton5.setPreferredSize(new java.awt.Dimension(63, 63));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/server/view/icones_CRUD/AtualizaPizza.png"))); // NOI18N
        jButton4.setBorderPainted(false);
        jButton4.setContentAreaFilled(false);
        jButton4.setMaximumSize(new java.awt.Dimension(63, 63));
        jButton4.setMinimumSize(new java.awt.Dimension(63, 63));
        jButton4.setPreferredSize(new java.awt.Dimension(63, 63));

        jLabel1.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        jLabel1.setText("Voltar");

        jLabel2.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        jLabel2.setText("Adicionar");

        jLabel3.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        jLabel3.setText("Excluir");

        jLabel4.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        jLabel4.setText("Atualizar");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoVoltarTelaCRUDMesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(jLabel3)))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 1, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoVoltarTelaCRUDMesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void botaoVoltarTelaCRUDMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarTelaCRUDMesasActionPerformed
            // TODO add your handling code here:
        this.dispose();
        
        
    }//GEN-LAST:event_botaoVoltarTelaCRUDMesasActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCRUDMesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCRUDMesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCRUDMesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCRUDMesas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCRUDMesas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoVoltarTelaCRUDMesas;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabelaCRUDMesas;
    // End of variables declaration//GEN-END:variables

    public Controle getControle() {
        return controle;
    }

    public void setControle(Controle controle) {
        this.controle = controle;
    }

    public TelaPrincipal getJanelaPrincipal() {
        return janelaPrincipal;
    }

    public void setJanelaPrincipal(TelaPrincipal janelaPrincipal) {
        this.janelaPrincipal = janelaPrincipal;
    }

    public Autenticacao getAutenticacaoServer() {
        return autenticacaoServer;
    }

    public void setAutenticacaoServer(Autenticacao autenticacaoServer) {
        this.autenticacaoServer = autenticacaoServer;
    }
}
