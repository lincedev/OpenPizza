package server.view;

import java.io.Serializable;
import javax.swing.*;
import server.modelo.Autenticacao;
import server.persistencia.Arquivos;


/*
 Descrição: Classe de autenticação com o banco de dados
 */
public class TelaAutenticacao extends javax.swing.JFrame implements Serializable {

    // Variável de referência à tela principal
    private TelaPrincipal telaPrincipal;

    // Variável de armazenamento da autenticação do banco de dados
    private Autenticacao autenticacaoServer;
    
    // Variável de armazenamento do Jmenu Exibir
    private JMenu barraExibir;
    
    // Variável de armazenamento do Jmenu Produtos
    private JMenu barraProdutos;

    
    // Variável de armazenamento do Jmenu Mesas
    private JMenu barraMesas;
    
    
    /*
     Descrição: Método get do componente JMenu Produtos da janela principal
     Parâmetros: 
     Retorno: JMenu barraProdutos
     */
    public JMenu getBarraProdutos() {
        return barraProdutos;
    }
    
    /*
     Descrição: Método get do componente JMenu Produtos da janela principal
     Parâmetros: JMenu Produtos da janela principal 
     Retorno: 
     */
    public void setBarraProdutos(JMenu barraProdutos) {
        this.barraProdutos = barraProdutos;
    }
    
    
    /*
     Descrição: Método get do componente JMenu Mesas da janela principal
     Parâmetros: 
     Retorno: JMenu barraMesas
     */
    public JMenu getBarraMesas() {
        return barraMesas;
    }

    
    /*
     Descrição: Método get do componente JMenu Mesas da janela principal
     Parâmetros: JMenu Mesas da janela principal
     Retorno: 
     */
    public void setBarraMesas(JMenu barraMesas) {
        this.barraMesas = barraMesas;
    }
    
    /*
     Descrição: Método get do componente JMenu Exibir da janela principal
     Parâmetros: 
     Retorno: JMenu barraExibir
     */
    public JMenu getBarraExibir() {
        return barraExibir;
    }

    
    /*
     Descrição: Método set do componente JMenu exibir da janela principal
     Parâmetros: JMenu Exibir da janela principal
     Retorno:
     * 
     */
    public void setBarraExibir(JMenu barraExibir) {
        this.barraExibir = barraExibir;
    }
    

    /*
     Descrição: Método get do atributo da janela principal
     Parâmetros: 
     Retorno:
     *           telaPrincipal (Necessário para controle dos métodos da janela anterior)
     */
    public TelaPrincipal getTelaPrincipal() {
        return telaPrincipal;
    }

    /*
     Descrição: Método set do atributo da janela principal
     Parâmetros: 
     *           telaPrincipal (Janela anterior)
     Retorno:
     */
    public void setTelaPrincipal(TelaPrincipal telaPrincipal) {
        this.telaPrincipal = telaPrincipal;
    }

    /*
     Descrição: Método get do atributo de autenticação
     Parâmetros: 
     Retorno:
     *           autenticacao (Informações de autenticação no banco de dados)
     */
    public Autenticacao getAutenticacaoServer() {
        return autenticacaoServer;
    }

    /*
     Descrição: Método set do atributo de autenticação
     Parâmetros: 
     *           autenticacao (Necessário para acesso ao banco de dados)
     Retorno:
     */
    public void setAutenticacaoServer(Autenticacao autenticacaoServer) {
        this.autenticacaoServer = autenticacaoServer;
    }

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
     Parâmetros: 
     *           telaPrincipal (Janela anterior)
     *           autenticacao (Necessário para acesso ao banco de dados)
     Retorno:
     */
    public TelaAutenticacao(TelaPrincipal telaPrincipal, Autenticacao autenticacaoServer, JMenu barraExibir, JMenu barraProdutos, JMenu barraMesas) {
        this();
        this.setIconImage(new ImageIcon("../Imagens/pedaco_pizza.png").getImage());
        this.setTelaPrincipal(telaPrincipal);
        this.setAutenticacaoServer(autenticacaoServer);
        this.setBarraExibir(barraExibir);
        this.setBarraProdutos(barraProdutos);
        this.setBarraMesas(barraMesas);
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
        labelBancoDeDados = new javax.swing.JLabel();
        labelUsuario = new javax.swing.JLabel();
        labelSenha = new javax.swing.JLabel();
        caminhoBanco = new javax.swing.JTextField();
        usuarioBanco = new javax.swing.JTextField();
        autenticarBanco = new javax.swing.JButton();
        senhaBanco = new javax.swing.JTextField();
        cancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("OpenPizza - Autenticação");
        setMaximumSize(new java.awt.Dimension(350, 250));
        setMinimumSize(new java.awt.Dimension(350, 250));
        setResizable(false);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        painel.setMaximumSize(new java.awt.Dimension(350, 250));
        painel.setMinimumSize(new java.awt.Dimension(350, 250));
        painel.setPreferredSize(new java.awt.Dimension(350, 250));

        labelBancoDeDados.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        labelBancoDeDados.setText("Banco de Dados: *");

        labelUsuario.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        labelUsuario.setText("Usuário: *");

        labelSenha.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        labelSenha.setText("Senha: *");

        caminhoBanco.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        caminhoBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                caminhoBancoActionPerformed(evt);
            }
        });

        usuarioBanco.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        usuarioBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usuarioBancoActionPerformed(evt);
            }
        });

        autenticarBanco.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        autenticarBanco.setText("Autenticar");
        autenticarBanco.setMaximumSize(new java.awt.Dimension(120, 40));
        autenticarBanco.setMinimumSize(new java.awt.Dimension(120, 40));
        autenticarBanco.setPreferredSize(new java.awt.Dimension(120, 40));
        autenticarBanco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                autenticarBancoActionPerformed(evt);
            }
        });

        senhaBanco.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N

        cancelar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        cancelar.setText("Cancelar");
        cancelar.setMaximumSize(new java.awt.Dimension(120, 40));
        cancelar.setMinimumSize(new java.awt.Dimension(120, 40));
        cancelar.setPreferredSize(new java.awt.Dimension(120, 40));
        cancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(autenticarBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(36, Short.MAX_VALUE))
            .addGroup(painelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addComponent(labelUsuario)
                        .addGap(85, 85, 85)
                        .addComponent(usuarioBanco))
                    .addGroup(painelLayout.createSequentialGroup()
                        .addComponent(labelSenha)
                        .addGap(97, 97, 97)
                        .addComponent(senhaBanco)))
                .addContainerGap())
            .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(painelLayout.createSequentialGroup()
                            .addGap(163, 163, 163)
                            .addComponent(caminhoBanco))
                        .addGroup(painelLayout.createSequentialGroup()
                            .addComponent(labelBancoDeDados)
                            .addGap(0, 0, Short.MAX_VALUE)))
                    .addContainerGap()))
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addGap(62, 62, 62)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelUsuario)
                    .addComponent(usuarioBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(senhaBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelSenha))
                .addGap(26, 26, 26)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(autenticarBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(42, Short.MAX_VALUE))
            .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(painelLayout.createSequentialGroup()
                    .addContainerGap()
                    .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelBancoDeDados)
                        .addComponent(caminhoBanco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addContainerGap(207, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
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
                autenticacaoServer.setCaminhoBanco(this.caminhoBanco.getText());
                autenticacaoServer.setUsuarioBanco(this.usuarioBanco.getText());
                autenticacaoServer.setUsuarioSenha(this.senhaBanco.getText());
                arquivo.salvarArquivo(this.caminhoBanco.getText(), this.usuarioBanco.getText(), this.senhaBanco.getText());
                JOptionPane.showMessageDialog(null, "Autenticação salva com sucesso!", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                this.barraExibir.setEnabled(true);
                this.barraProdutos.setEnabled(true);
                this.barraMesas.setEnabled(true);
                this.dispose();
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

    /*
     Descrição: Método do botão Fechar (X).
     Parâmetros: 
     Retorno:
     */
    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        // Retorna à janela anterior
        this.dispose();
    }//GEN-LAST:event_formWindowClosed

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
    private javax.swing.JPanel painel;
    private javax.swing.JTextField senhaBanco;
    private javax.swing.JTextField usuarioBanco;
    // End of variables declaration//GEN-END:variables
}
