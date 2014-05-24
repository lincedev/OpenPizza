package client.view;

import client.modelo.*;
import client.persistencia.*;
import javax.swing.*;
import java.io.*;

/*
 Descrição: Tela de autenticação do banco de dados
 */
public class TelaAutenticacao extends javax.swing.JFrame implements Serializable {

    // Variável para armazenamento da tela principal
    private TelaPrincipal janelaPrincipal;

    // Variável utilizada para referenciar o botão "Abrir Pedido" da janela principal.
    private JButton habilitarPedido;

    // Variável utilizada para referenciar o botão "Autenticar" da janela principal.
    private JButton autenticar;

    /*
     Descrição: Construtor padrão da janela de autenticação.
     Parâmetros: 
     Retorno:
     */
    private TelaAutenticacao() {
        initComponents();
    }

    /*
     Descrição: Construtor completo da janela de autenticação.
     Parâmetros: janelaPrincipal (Necessário para acesso aos métodos da janela principal)
     habilitarPedido (Necessário para acesso aos métodos do botão Abrir Pedido)
     autenticar (Necessário para acesso aos métodos do botão Autenticar)
     Retorno:
     */
    public TelaAutenticacao(TelaPrincipal janelaPrincipal, JButton habilitarPedido, JButton autenticar) {
        this();
        this.setIconImage(new ImageIcon("../Imagens/pedaco_pizza.png").getImage());
        this.setJanelaPrincipal(janelaPrincipal);
        this.setHabilitarPedido(habilitarPedido);
        this.setAutenticar(autenticar);
    }

    /*
     Descrição: Método set do botão autenticar.
     Parâmetros: autenticar (Necessário para acesso aos métodos do botão Autenticar)
     Retorno:
     */
    public void setAutenticar(JButton autenticar) {
        this.autenticar = autenticar;
    }

    /*
     Descrição: Método set do botão Abrir Pedido.
     Parâmetros: habilitarPedido (Necessário para acesso aos métodos do botão Abrir Pedido)
     Retorno:
     */
    public void setHabilitarPedido(JButton habilitarPedido) {
        this.habilitarPedido = habilitarPedido;
    }

    /*
     Descrição: Método set da janela principal.
     Parâmetros: janelaPrincipal (Necessário para acesso aos métodos da janela principal)
     Retorno:
     */
    public void setJanelaPrincipal(TelaPrincipal janelaPrincipal) {
        this.janelaPrincipal = janelaPrincipal;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        labelBancoDeDados = new javax.swing.JLabel();
        labelUsuario = new javax.swing.JLabel();
        labelSenha = new javax.swing.JLabel();
        caminhoBanco = new javax.swing.JTextField();
        usuarioBanco = new javax.swing.JTextField();
        autenticarBanco = new javax.swing.JButton();
        senhaBanco = new javax.swing.JTextField();
        cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Autenticação");

        labelBancoDeDados.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelBancoDeDados.setText("Banco de Dados:");

        labelUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelUsuario.setText("Usuário:");

        labelSenha.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        labelSenha.setText("Senha:");

        caminhoBanco.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        caminhoBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caminhoBancoActionPerformed(evt);
            }
        });

        usuarioBanco.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        usuarioBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioBancoActionPerformed(evt);
            }
        });

        autenticarBanco.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        autenticarBanco.setText("Autenticar");
        autenticarBanco.setPreferredSize(new java.awt.Dimension(110, 30));
        autenticarBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autenticarBancoActionPerformed(evt);
            }
        });

        senhaBanco.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        cancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cancelar.setText("Cancelar");
        cancelar.setPreferredSize(new java.awt.Dimension(110, 30));
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelUsuario)
                            .addComponent(labelSenha))
                        .addGap(85, 85, 85)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                            .addComponent(usuarioBanco)
                            .addComponent(caminhoBanco, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                            .addComponent(senhaBanco)
                            .addComponent(autenticarBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelBancoDeDados)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelBancoDeDados)
                            .addComponent(caminhoBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(labelUsuario)
                            .addComponent(usuarioBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(37, 37, 37)
                        .addComponent(senhaBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(labelSenha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(autenticarBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /*
     Descrição: Campo de texto para receber o caminho do banco de dados.
     Parâmetros:
     Retorno:
     */
    private void caminhoBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_caminhoBancoActionPerformed
        // Campo de texto para receber o caminho do banco de dados.
    }//GEN-LAST:event_caminhoBancoActionPerformed

    /*
     Descrição: Método de autenticação ao iniciar a aplicação, utilizando os parâmetros salvos no arquivo Autenticacao.txt
     Parâmetros: 
     Retorno:
     */
    private void autenticarBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_autenticarBancoActionPerformed
        // Criação de objeto para recuperação de parâmetros do arquivo Autenticacao.txt
        Arquivos arquivo = new Arquivos();
        Autenticacao autenticar = new Autenticacao();

        // Tentativa de autenticação utilizando os parâmetros do arquivo de autenticação
        try {
            autenticar.testarAutenticacao(this.caminhoBanco.getText(), this.usuarioBanco.getText(), this.senhaBanco.getText());

            // Tentativa de arquivar os parâmetros de acesso ao banco no arquivo Autenticacao.txt
            try {
                arquivo.salvarArquivo(this.caminhoBanco.getText(), this.usuarioBanco.getText(), this.senhaBanco.getText());
                JOptionPane.showMessageDialog(null, "Autenticação salva com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                this.dispose();
                this.autenticar.setVisible(false);
                this.habilitarPedido.setEnabled(true);
                janelaPrincipal.setEnabled(true);
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Não foi possível salvar a autenticação.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível autenticar a conexão.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_autenticarBancoActionPerformed

    /*
     Descrição: Campo de texto para receber o usuário de acesso ao banco de dados.
     Parâmetros:
     Retorno:
     */
    private void usuarioBancoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usuarioBancoActionPerformed
        // Campo de texto para receber usuário de acesso ao banco de dados.
    }//GEN-LAST:event_usuarioBancoActionPerformed

    /*
     Descrição: Método do botão Cancelar.
     Parâmetros: 
     Retorno:
     */
    private void cancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelarActionPerformed
        // Retorna à janela anterior
        this.dispose();
    }//GEN-LAST:event_cancelarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaAutenticacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAutenticacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAutenticacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAutenticacao.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAutenticacao().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton autenticarBanco;
    private javax.swing.JTextField caminhoBanco;
    private javax.swing.JButton cancelar;
    private javax.swing.JLabel labelBancoDeDados;
    private javax.swing.JLabel labelSenha;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JTextField senhaBanco;
    private javax.swing.JTextField usuarioBanco;
    // End of variables declaration//GEN-END:variables
}