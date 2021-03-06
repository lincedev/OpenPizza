// Pacote View
package server.view;

// Importação dos pacotes e bibliotecas necessárias
import javax.swing.JOptionPane;
import server.controle.Controle;
import server.modelo.Autenticacao;
import server.modelo.Outros;

/*
 Descrição: Tela Adicionar Outros
 */
public class TelaAdicionarOutros extends javax.swing.JFrame {

    // Atributos encapsulados
    private TelaCRUDOutros telaCRUDOutros;
    private Autenticacao autenticacao;
    private Controle controle;

    /*
     Descrição: Construtor padrão da Tela Adicionar Outros
     Parâmetros:
     Retorno:
     */
    public TelaAdicionarOutros() {
        initComponents();
    }

    /*
     Descrição: Construtor completo da Tela Adicionar Outros
     Parâmetros:
     telaCRUDOutros (Referência à Tela CRUD Outros)
     autenticacao (Objeto do tipo Autenticacao contendo informações para acesso ao banco de dados)
     controle (Objeto do tipo Controle)
     Retorno:
     */
    public TelaAdicionarOutros(TelaCRUDOutros telaCRUDOutros, Autenticacao autenticacao, Controle controle) {
        this();
        this.setAutenticacao(autenticacao);
        this.setTelaCRUDOutros(telaCRUDOutros);
        this.setControle(controle);
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
        labelDescricao = new javax.swing.JLabel();
        textDescricao = new javax.swing.JTextField();
        labelPreco = new javax.swing.JLabel();
        textPreco = new javax.swing.JTextField();
        botaoCadastrar = new javax.swing.JButton();
        botaoCancelar = new javax.swing.JButton();
        labelEstoque = new javax.swing.JLabel();
        textEstoque = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("OpenPizza - Novo Outro");
        setMaximumSize(new java.awt.Dimension(270, 300));
        setMinimumSize(new java.awt.Dimension(270, 300));
        setPreferredSize(new java.awt.Dimension(270, 300));
        setResizable(false);

        painel.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));

        labelDescricao.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        labelDescricao.setText("Descrição:");

        textDescricao.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N

        labelPreco.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        labelPreco.setText("Preço:");

        textPreco.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N

        botaoCadastrar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        botaoCadastrar.setText("Cadastrar");
        botaoCadastrar.setMaximumSize(new java.awt.Dimension(120, 40));
        botaoCadastrar.setMinimumSize(new java.awt.Dimension(120, 40));
        botaoCadastrar.setPreferredSize(new java.awt.Dimension(120, 40));
        botaoCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarActionPerformed(evt);
            }
        });

        botaoCancelar.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        botaoCancelar.setText("Cancelar");
        botaoCancelar.setMaximumSize(new java.awt.Dimension(120, 40));
        botaoCancelar.setMinimumSize(new java.awt.Dimension(120, 40));
        botaoCancelar.setPreferredSize(new java.awt.Dimension(120, 40));
        botaoCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarActionPerformed(evt);
            }
        });

        labelEstoque.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        labelEstoque.setText("Estoque:");

        textEstoque.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelLayout.createSequentialGroup()
                        .addComponent(labelDescricao)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(painelLayout.createSequentialGroup()
                        .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(textDescricao)
                            .addGroup(painelLayout.createSequentialGroup()
                                .addComponent(labelEstoque)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painelLayout.createSequentialGroup()
                                .addComponent(labelPreco)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(textPreco, javax.swing.GroupLayout.PREFERRED_SIZE, 101, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(painelLayout.createSequentialGroup()
                                .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(botaoCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addContainerGap())))
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(labelDescricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPreco)
                    .addComponent(textPreco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelEstoque))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(56, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /*
     Descrição: Evento ao clicar no botão Cadastrar
     Parâmetros:
     Retorno:
     */
    private void botaoCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarActionPerformed

        // Validação dos campos informados
        boolean verificarCampos = this.getControle().verificarCamposBebidasOutros(this.textDescricao, this.textPreco, this.textEstoque);

        // Campos válidos -> Tentativa de inserção
        if (verificarCampos) {

            Outros novoOutros = new Outros(this.textDescricao.getText(), Float.parseFloat(this.textPreco.getText()), Integer.parseInt(this.textEstoque.getText()));
            boolean inserirProduto = this.getControle().inserirProduto(this.getAutenticacao(), novoOutros);

            // Inserção válida -> Mensagem de aviso
            if (inserirProduto) {
                JOptionPane.showMessageDialog(null, "Produto inserido com sucesso.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                this.textDescricao.setText(null);
                this.textPreco.setText(null);
                this.textEstoque.setText(null);

            } // Inserção inválida -> Mensagem de erro
            else {
                JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar inserir o produto no banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } // Campos inválidos -> Mensagem de alerta
        else {
            JOptionPane.showMessageDialog(null, "Por favor, preencha os campos com valores válidos.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_botaoCadastrarActionPerformed

    /*
     Descrição: Evento ao clicar no botão Cancelar
     Parâmetros:
     Retorno:
     */
    private void botaoCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarActionPerformed
        // Fechar janela atual
        this.dispose();
    }//GEN-LAST:event_botaoCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(TelaAdicionarOutros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAdicionarOutros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAdicionarOutros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAdicionarOutros.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAdicionarOutros().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCadastrar;
    private javax.swing.JButton botaoCancelar;
    private javax.swing.JLabel labelDescricao;
    private javax.swing.JLabel labelEstoque;
    private javax.swing.JLabel labelPreco;
    private javax.swing.JPanel painel;
    private javax.swing.JTextField textDescricao;
    private javax.swing.JTextField textEstoque;
    private javax.swing.JTextField textPreco;
    // End of variables declaration//GEN-END:variables

    /*
     Descrição: Método get da telaCRUDOutros
     Parâmetros:
     Retorno:
     telaCRUDOutros (Referência à Tela CRUD Outros)
     */
    public TelaCRUDOutros getTelaCRUDOutros() {
        return telaCRUDOutros;
    }

    /*
     Descrição: Método set da telaCRUDOutros
     Parâmetros:
     telaCRUDOutros (Referência à Tela CRUD Outros)
     Retorno:
     */
    public void setTelaCRUDOutros(TelaCRUDOutros telaCRUDOutros) {
        this.telaCRUDOutros = telaCRUDOutros;
    }

    /*
     Descrição: Método get da autenticacao
     Parâmetros:
     Retorno:
     autenticacao (Objeto do tipo Autenticacao contendo as inforamações para acesso ao banco de dados)
     */
    public Autenticacao getAutenticacao() {
        return autenticacao;
    }

    /*
     Descrição: Método set da autenticacao
     Parâmetros:
     autenticacao (Objeto do tipo Autenticacao contendo as inforamações para acesso ao banco de dados)
     Retorno:
     */
    public void setAutenticacao(Autenticacao autenticacao) {
        this.autenticacao = autenticacao;
    }

    /*
     Descrição: Método get do controle
     Parâmetros:
     Retorno:
     controle (Objeto do tipo Controle)
     */
    public Controle getControle() {
        return controle;
    }

    /*
     Descrição: Método set do controle
     Parâmetros:
     controle (Objeto do tipo Controle)
     Retorno:
     */
    public void setControle(Controle controle) {
        this.controle = controle;
    }
}
