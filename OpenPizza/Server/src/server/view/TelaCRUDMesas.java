// Pacote View
package server.view;

// Importação dos pacotes e bibliotecas necessárias
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableCellRenderer;
import server.controle.Controle;
import server.modelo.Autenticacao;

/*
 Descrição: Tela de CRUD das Mesas
 */
public class TelaCRUDMesas extends javax.swing.JFrame {

    // Variáveis encapsuladas
    private Controle controle;
    private TelaPrincipal janelaPrincipal;
    private Autenticacao autenticacao;

    /*
     Descrição: Construtor padrão da Tela CRUD Mesas.
     Parâmetros:
     Retorno:
     */
    private TelaCRUDMesas() {
        initComponents();
    }

    /*
     Descrição: Construtor completo da Tela CRUD Mesas
     Parâmetros:
     janelaPrincipal (Referência à TelaPrincipal)
     autenticacao (Objeto do tipo Autenticacao contendo as informações para acesso ao banco de dados)
     controle (Objeto do tipo Controle)
     Retorno:
     */
    public TelaCRUDMesas(TelaPrincipal janelaPrincipal, Autenticacao autenticacao, Controle controle) {
        this();
        this.setAutenticacao(autenticacao);
        this.setJanelaPrincipal(janelaPrincipal);
        this.setControle(controle);
        this.getControle().exibirProdutos(this.getAutenticacao(), this.tabelaCRUDMesas, "Mesa");
        this.formatarTabelaDeMesas();
    }

    /*
     Descrição: Método para formatação da tabela de mesas
     Parâmetros:
     Retorno:
     */
    public void formatarTabelaDeMesas(){

        DefaultTableCellRenderer centralizarLabel = new DefaultTableCellRenderer();
        centralizarLabel.setHorizontalAlignment(JLabel.CENTER);

        this.tabelaCRUDMesas.getColumnModel().getColumn(0).setCellRenderer(centralizarLabel);

        this.tabelaCRUDMesas.getColumnModel().getColumn(1).setCellRenderer(centralizarLabel);
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
        painelMesas = new javax.swing.JScrollPane();
        tabelaCRUDMesas = new javax.swing.JTable();
        painelCRUDMesas = new javax.swing.JPanel();
        botaoVoltarTelaCRUDMesas = new javax.swing.JButton();
        botaoAdicionar = new javax.swing.JButton();
        botaoExcluir = new javax.swing.JButton();
        botaoAtualizar = new javax.swing.JButton();
        labelVoltar = new javax.swing.JLabel();
        labelAdicionar = new javax.swing.JLabel();
        labelExcluir = new javax.swing.JLabel();
        labelAtualizar = new javax.swing.JLabel();

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
        painelMesas.setViewportView(tabelaCRUDMesas);

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

        botaoAdicionar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/server/view/icones_CRUD/AdicionarPizza.png"))); // NOI18N
        botaoAdicionar.setBorderPainted(false);
        botaoAdicionar.setContentAreaFilled(false);
        botaoAdicionar.setMaximumSize(new java.awt.Dimension(63, 63));
        botaoAdicionar.setMinimumSize(new java.awt.Dimension(63, 63));
        botaoAdicionar.setPreferredSize(new java.awt.Dimension(63, 63));
        botaoAdicionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAdicionarActionPerformed(evt);
            }
        });

        botaoExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/server/view/icones_CRUD/DeleterPizza.png"))); // NOI18N
        botaoExcluir.setBorderPainted(false);
        botaoExcluir.setContentAreaFilled(false);
        botaoExcluir.setMaximumSize(new java.awt.Dimension(63, 63));
        botaoExcluir.setMinimumSize(new java.awt.Dimension(63, 63));
        botaoExcluir.setPreferredSize(new java.awt.Dimension(63, 63));
        botaoExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoExcluirActionPerformed(evt);
            }
        });

        botaoAtualizar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/server/view/icones_CRUD/AtualizaPizza.png"))); // NOI18N
        botaoAtualizar.setBorderPainted(false);
        botaoAtualizar.setContentAreaFilled(false);
        botaoAtualizar.setMaximumSize(new java.awt.Dimension(63, 63));
        botaoAtualizar.setMinimumSize(new java.awt.Dimension(63, 63));
        botaoAtualizar.setPreferredSize(new java.awt.Dimension(63, 63));
        botaoAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoAtualizarActionPerformed(evt);
            }
        });

        labelVoltar.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        labelVoltar.setText("Voltar");

        labelAdicionar.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        labelAdicionar.setText("Adicionar");

        labelExcluir.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        labelExcluir.setText("Excluir");

        labelAtualizar.setFont(new java.awt.Font("Cantarell", 0, 16)); // NOI18N
        labelAtualizar.setText("Atualizar");

        javax.swing.GroupLayout painelCRUDMesasLayout = new javax.swing.GroupLayout(painelCRUDMesas);
        painelCRUDMesas.setLayout(painelCRUDMesasLayout);
        painelCRUDMesasLayout.setHorizontalGroup(
            painelCRUDMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCRUDMesasLayout.createSequentialGroup()
                .addGroup(painelCRUDMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoVoltarTelaCRUDMesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelCRUDMesasLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(labelVoltar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(painelCRUDMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelAdicionar))
                .addGap(18, 18, 18)
                .addGroup(painelCRUDMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(painelCRUDMesasLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(labelExcluir)))
                .addGap(18, 18, 18)
                .addGroup(painelCRUDMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(labelAtualizar)
                    .addComponent(botaoAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 10, Short.MAX_VALUE))
        );
        painelCRUDMesasLayout.setVerticalGroup(
            painelCRUDMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCRUDMesasLayout.createSequentialGroup()
                .addGroup(painelCRUDMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(botaoVoltarTelaCRUDMesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoAdicionar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(painelCRUDMesasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelVoltar)
                    .addComponent(labelAdicionar)
                    .addComponent(labelExcluir)
                    .addComponent(labelAtualizar))
                .addGap(0, 15, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout painelLayout = new javax.swing.GroupLayout(painel);
        painel.setLayout(painelLayout);
        painelLayout.setHorizontalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelMesas, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(painelCRUDMesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        painelLayout.setVerticalGroup(
            painelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(painelMesas, javax.swing.GroupLayout.PREFERRED_SIZE, 131, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(painelCRUDMesas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(24, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    /*
     Descrição: Evento ao clicar no botão Voltar
     Parâmetros:
     Retorno:
     */
    private void botaoVoltarTelaCRUDMesasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoVoltarTelaCRUDMesasActionPerformed
        // Fechar janela atual
        this.dispose();
    }//GEN-LAST:event_botaoVoltarTelaCRUDMesasActionPerformed

    /*
     Descrição: Evento ao clicar no botão Adicionar
     Parâmetros:
     Retorno:
     */
    private void botaoAdicionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAdicionarActionPerformed
        // Tentativa de inserção e exibição da nova mesa
        boolean inserirMesa = this.getControle().inserirMesa(this.getAutenticacao());
        if (inserirMesa) {
            JOptionPane.showMessageDialog(null, "Mesa inserida com sucesso.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
            this.getControle().exibirProdutos(this.getAutenticacao(), this.tabelaCRUDMesas, "Mesa");
            this.formatarTabelaDeMesas();
        } else {
            JOptionPane.showMessageDialog(null, "Não foi possível inserir uma nova mesa.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_botaoAdicionarActionPerformed

    /*
     Descrição: Evento ao clicar no botão Excluir
     Parâmetros:
     Retorno:
     */
    private void botaoExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoExcluirActionPerformed
        // Recuperar item selecionado
        int indice = this.tabelaCRUDMesas.getSelectedRow();
        if (indice >= 0) {

            // Confirmação de exclusão
            int confirmacao = JOptionPane.showConfirmDialog(null, "Deseja excluir o item selecionado?\nEssa operação não poderá ser desfeita.", "Aviso", JOptionPane.OK_CANCEL_OPTION);

            // Confirmação válida -> Recuperação e exclusão da mesa
            if (confirmacao == JOptionPane.OK_OPTION) {
                int numeroDaMesa = Integer.parseInt(String.valueOf(this.tabelaCRUDMesas.getValueAt(this.tabelaCRUDMesas.getSelectedRow(), 0)));
                if (numeroDaMesa >= 0) {

                    boolean desativarMesa = this.getControle().desativarMesa(this.getAutenticacao(), numeroDaMesa);

                    // Exclusão válida -> Mensagem de aviso
                    if (desativarMesa) {
                        JOptionPane.showMessageDialog(null, "Mesa excluída com sucesso.", "Aviso", JOptionPane.INFORMATION_MESSAGE);
                        this.getControle().exibirProdutos(this.getAutenticacao(), tabelaCRUDMesas, "Mesa");
                    } // Exclusão inválida -> Mensagem de erro
                    else {
                        JOptionPane.showMessageDialog(null, "Não foi possível excluir a mesa selecionadas.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                }
            }
        }
    }//GEN-LAST:event_botaoExcluirActionPerformed

    /*
     Descrição: Evento ao clicar no botão Atualizar
     Parâmetros:
     Retorno:
     */
    private void botaoAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoAtualizarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_botaoAtualizarActionPerformed

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
    private javax.swing.JButton botaoAdicionar;
    private javax.swing.JButton botaoAtualizar;
    private javax.swing.JButton botaoExcluir;
    private javax.swing.JButton botaoVoltarTelaCRUDMesas;
    private javax.swing.JLabel labelAdicionar;
    private javax.swing.JLabel labelAtualizar;
    private javax.swing.JLabel labelExcluir;
    private javax.swing.JLabel labelVoltar;
    private javax.swing.JPanel painel;
    private javax.swing.JPanel painelCRUDMesas;
    private javax.swing.JScrollPane painelMesas;
    private javax.swing.JTable tabelaCRUDMesas;
    // End of variables declaration//GEN-END:variables

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

    /*
     Descrição: Método get da janelaPrincipal
     Parâmetros:
     Retorno:
     janelaPrincipal (Referência à Tela Principal)
     */
    public TelaPrincipal getJanelaPrincipal() {
        return janelaPrincipal;
    }

    /*
     Descrição: Método set da janelaPrincipal
     Parâmetros:
     janelaPrincipal (Referência à Tela Principal)
     Retorno:
     */
    public void setJanelaPrincipal(TelaPrincipal janelaPrincipal) {
        this.janelaPrincipal = janelaPrincipal;
    }

    /*
     Descrição: Método get da autenticacao
     Parâmetros:
     Retorno:
     autenticacao (Objeto do tipo Autenticação contendo as informações para acesso ao banco de dados)
     */
    public Autenticacao getAutenticacao() {
        return autenticacao;
    }

    /*
     Descrição: Método set da autenticacao
     Parâmetros:
     autenticacao (Objeto do tipo Autenticação contendo as informações para acesso ao banco de dados)
     Retorno:
     */
    public void setAutenticacao(Autenticacao autenticacao) {
        this.autenticacao = autenticacao;
    }
}
