// Pacote View
package client.view;

// Importação dos pacotes e bibliotecas necessárias
import client.control.Controle;
import client.model.Autenticacao;
import java.io.Serializable;
import javax.swing.JButton;
import javax.swing.JOptionPane;

/*
 Descrição: Tela de Autenticação
 */
public class TelaAutenticacao extends javax.swing.JFrame implements Serializable {

    // Atributos encapsulados
    private Autenticacao autenticacao;
    private Controle controle;
    private JButton botaoPedido;

    /*
     Descrição: Construtor padrão da Tela de Autenticação
     Parâmetros:
     Retorno:
     */
    private TelaAutenticacao() {
        initComponents();
    }

    /*
     Descrição: Construtor completo da Tela de Autenticação
     Parâmetros:
     autenticacao (Objeto do tipo Autenticacao contendo as informações para acesso ao banco de dados)
     controle (Objeto do tipo Controle)
     botaoPedido (JButton da Tela Principal)
     Retorno:
     */
    public TelaAutenticacao(Autenticacao autenticacao, Controle controle, JButton botaoPedido) {
        this();
        this.setAutenticacao(autenticacao);
        this.setControle(controle);
        this.setBotaoPedido(botaoPedido);
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
        botaoFechar = new javax.swing.JButton();
        botaoAutenticar = new javax.swing.JButton();
        textFieldBancoDeDados = new javax.swing.JTextField();
        textFieldUsuario = new javax.swing.JTextField();
        textFieldSenha = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("OpenPizza - Autenticação");
        setMinimumSize(new java.awt.Dimension(400, 500));
        setResizable(false);

        labelBancoDeDados.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        labelBancoDeDados.setText("Banco de Dados: *");

        labelUsuario.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        labelUsuario.setText("Usuário: *");

        labelSenha.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        labelSenha.setText("Senha: *");

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

        botaoAutenticar.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        botaoAutenticar.setText("Autenticar");
        botaoAutenticar.setMaximumSize(new java.awt.Dimension(120, 40));
        botaoAutenticar.setMinimumSize(new java.awt.Dimension(120, 40));
        botaoAutenticar.setPreferredSize(new java.awt.Dimension(120, 40));
        botaoAutenticar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAutenticarActionPerformed(evt);
            }
        });

        textFieldBancoDeDados.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        textFieldBancoDeDados.setMaximumSize(new java.awt.Dimension(120, 40));
        textFieldBancoDeDados.setMinimumSize(new java.awt.Dimension(120, 40));
        textFieldBancoDeDados.setPreferredSize(new java.awt.Dimension(120, 40));

        textFieldUsuario.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        textFieldUsuario.setMaximumSize(new java.awt.Dimension(120, 40));
        textFieldUsuario.setMinimumSize(new java.awt.Dimension(120, 40));
        textFieldUsuario.setPreferredSize(new java.awt.Dimension(120, 40));

        textFieldSenha.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        textFieldSenha.setMaximumSize(new java.awt.Dimension(120, 40));
        textFieldSenha.setMinimumSize(new java.awt.Dimension(120, 40));
        textFieldSenha.setPreferredSize(new java.awt.Dimension(120, 40));

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(labelBancoDeDados)
                            .addComponent(labelUsuario)
                            .addComponent(labelSenha))
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(painelLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(textFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(textFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(painelLayout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(textFieldBancoDeDados, javax.swing.GroupLayout.PREFERRED_SIZE, 226, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(painelLayout.createSequentialGroup()
                        .addGap(55, 55, 55)
                        .addComponent(botaoAutenticar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54)
                        .addComponent(botaoFechar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(34, Short.MAX_VALUE))
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addContainerGap(103, Short.MAX_VALUE)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldBancoDeDados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelBancoDeDados))
                .addGap(66, 66, 66)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelUsuario))
                .addGap(52, 52, 52)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textFieldSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelSenha))
                .addGap(61, 61, 61)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoFechar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoAutenticar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(58, 58, 58))
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
     Descrição: Evento disparado ao clicar no Botão Fechar
     Parâmetros:
     Retorno:
     */
    private void botaoFecharActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoFecharActionPerformed
        // Fechar janela atual
        this.dispose();
    }//GEN-LAST:event_botaoFecharActionPerformed

    /*
     Descrição: Evento disparado ao clicar no botão Autenticar
     Parâmetros:
     Retorno:
     */
    private void botaoAutenticarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAutenticarActionPerformed

        // Verificação dos dados informados pelo usuário
        boolean bancoVazio = this.textFieldBancoDeDados.getText().isEmpty();
        boolean usuarioVazio = this.textFieldUsuario.getText().isEmpty();
        boolean senhaVazia = this.textFieldSenha.getText().isEmpty();

        // Campo(s) vazio(s) -> Mensagem de alerta
        if (bancoVazio || usuarioVazio || senhaVazia) {
            JOptionPane.showMessageDialog(null, "Por favor preencha todos os campos.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        } // Campos preenchidos -> Tentativa de autenticação dos dados informados
        else {

            // Recuperação dos dados informados pelo usuário
            Autenticacao tentativaDeAutenticacao = new Autenticacao();
            tentativaDeAutenticacao.setCaminhoBanco(this.textFieldBancoDeDados.getText());
            tentativaDeAutenticacao.setUsuarioBanco(this.textFieldUsuario.getText());
            tentativaDeAutenticacao.setUsuarioSenha(this.textFieldSenha.getText());

            // Tentativa de verificação da conexão
            boolean verificarConexao = this.getControle().verificarConexao(tentativaDeAutenticacao);

            // Conexão válida -> Tentativa de salvamento dos dados
            if (verificarConexao) {

                // Tentativa de salvamento dos dados
                boolean salvarAutenticacao = this.getControle().salvarAutenticacao(tentativaDeAutenticacao);

                // Dados salvos -> Atualização do objeto de autenticação em tempo de execução, habilitação do botão de Pedido na Tela de Pedido e mensagem de aviso
                if (salvarAutenticacao) {
                    this.getAutenticacao().setCaminhoBanco(tentativaDeAutenticacao.getCaminhoBanco());
                    this.getAutenticacao().setUsuarioBanco(tentativaDeAutenticacao.getUsuarioBanco());
                    this.getAutenticacao().setUsuarioSenha(tentativaDeAutenticacao.getUsuarioSenha());
                    this.getBotaoPedido().setEnabled(true);
                    JOptionPane.showMessageDialog(null, "Autenticação efetuada com sucesso.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                    this.dispose();
                } // Dados não salvos -> Mensagem de erro
                else {
                    JOptionPane.showMessageDialog(null, "Não foi possível salvar a autenticação.", "Erro", JOptionPane.ERROR_MESSAGE);
                }
            } // Conexão inválida -> Reiniciar valores dos campos de texto e mensagem de erro
            else {
                this.textFieldBancoDeDados.setText(null);
                this.textFieldUsuario.setText(null);
                this.textFieldSenha.setText(null);
                JOptionPane.showMessageDialog(null, "Não foi possível autenticar a conexão com o banco de dados.\nUm ou mais dados estão incorretos.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_botaoAutenticarActionPerformed

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
    private javax.swing.JButton botaoAutenticar;
    private javax.swing.JButton botaoFechar;
    private javax.swing.JLabel labelBancoDeDados;
    private javax.swing.JLabel labelSenha;
    private javax.swing.JLabel labelUsuario;
    private javax.swing.JPanel painel;
    private javax.swing.JTextField textFieldBancoDeDados;
    private javax.swing.JTextField textFieldSenha;
    private javax.swing.JTextField textFieldUsuario;
    // End of variables declaration//GEN-END:variables

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
     Descrição: Método get do botão Pedido
     Parâmetros:
     Retorno:
     botaoPedido (Botão Pedido da Tela Principal)
     */
    public JButton getBotaoPedido() {
        return botaoPedido;
    }

    /*
     Descrição: Método set do botaoPedido
     Parâmetros:
     botaoPedido (Botão Pedido da Tela Principal)
     Retorno:
     */
    public void setBotaoPedido(JButton botaoPedido) {
        this.botaoPedido = botaoPedido;
    }
}
