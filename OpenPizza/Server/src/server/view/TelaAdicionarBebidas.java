/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server.view;

import javax.swing.JOptionPane;
import server.modelo.Autenticacao;

/**
 *
 * @author Wellington
 */
public class TelaAdicionarBebidas extends javax.swing.JFrame {

    /**
     * Creates new form TelaAdicionarBebidas
     */        
    private TelaCRUDBebidas telaCrudBebidas;
    private Autenticacao autenticacao;
    
    public TelaAdicionarBebidas() {
        initComponents();
    }
    
    public TelaAdicionarBebidas(TelaCRUDBebidas telaCrudBebidas, Autenticacao autenticacao)            
    {
        this();
        this.setTelaCrudBebidas(telaCrudBebidas);
        this.setAutenticacao(autenticacao);
        this.getTelaCrudBebidas().setEnabled(false);
    }
    
    public TelaCRUDBebidas getTelaCrudBebidas() {
        return telaCrudBebidas;
    }

    public void setTelaCrudBebidas(TelaCRUDBebidas telaCrudBebidas) {
        this.telaCrudBebidas = telaCrudBebidas;
    }

    public Autenticacao getAutenticacao() {
        return autenticacao;
    }

    public void setAutenticacao(Autenticacao autenticacao) {
        this.autenticacao = autenticacao;
    }


    /*
     Descrição: Método disparado ao fechar a janela no botão |X|.
     Parâmetros:
     Retorno:
     */
    private void formWindowClosed(java.awt.event.WindowEvent evt) {                                  
        // Habilitar tela anterior e fechar tela atual
        this.getTelaCrudBebidas().setEnabled(true);
        this.dispose();
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelMenuCadastroBebida = new javax.swing.JPanel();
        labelNomeLanche = new javax.swing.JLabel();
        textNomeBebida = new javax.swing.JTextField();
        labelImagemBebida = new javax.swing.JLabel();
        botaoProcurarImagemBebida = new javax.swing.JButton();
        labelSaborBebida = new javax.swing.JLabel();
        textSaborBebida = new javax.swing.JTextField();
        labelTamanhoBebida = new javax.swing.JLabel();
        textTamanhoBebida = new javax.swing.JTextField();
        labelPrecoBebida = new javax.swing.JLabel();
        textPrecoBebida = new javax.swing.JTextField();
        botaoCadastrarBebida = new javax.swing.JButton();
        botaoCancelarBebida = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(340, 320));
        setMinimumSize(new java.awt.Dimension(340, 320));
        setResizable(false);

        jPanelMenuCadastroBebida.setPreferredSize(new java.awt.Dimension(480, 386));

        labelNomeLanche.setText("Nome:");

        textNomeBebida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textNomeBebidaActionPerformed(evt);
            }
        });

        labelImagemBebida.setText("Imagem:");

        botaoProcurarImagemBebida.setText("Procurar");

        labelSaborBebida.setText("Sabor:");

        textSaborBebida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textSaborBebidaActionPerformed(evt);
            }
        });

        labelTamanhoBebida.setText("Tamanho(ml):");

        labelPrecoBebida.setText("R$:");

        botaoCadastrarBebida.setText("Cadastrar");
        botaoCadastrarBebida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCadastrarBebidaActionPerformed(evt);
            }
        });

        botaoCancelarBebida.setText("Cancelar");
        botaoCancelarBebida.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                botaoCancelarBebidaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelMenuCadastroBebidaLayout = new javax.swing.GroupLayout(jPanelMenuCadastroBebida);
        jPanelMenuCadastroBebida.setLayout(jPanelMenuCadastroBebidaLayout);
        jPanelMenuCadastroBebidaLayout.setHorizontalGroup(
            jPanelMenuCadastroBebidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuCadastroBebidaLayout.createSequentialGroup()
                .addGroup(jPanelMenuCadastroBebidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMenuCadastroBebidaLayout.createSequentialGroup()
                        .addGroup(jPanelMenuCadastroBebidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelMenuCadastroBebidaLayout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanelMenuCadastroBebidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(labelNomeLanche)
                                    .addComponent(labelSaborBebida, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanelMenuCadastroBebidaLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(labelTamanhoBebida)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanelMenuCadastroBebidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanelMenuCadastroBebidaLayout.createSequentialGroup()
                                .addComponent(textNomeBebida, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(labelPrecoBebida)
                                .addGap(18, 18, 18)
                                .addComponent(textPrecoBebida, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelMenuCadastroBebidaLayout.createSequentialGroup()
                                .addGap(8, 8, 8)
                                .addComponent(textTamanhoBebida, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanelMenuCadastroBebidaLayout.createSequentialGroup()
                                .addComponent(textSaborBebida, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(21, 21, 21)
                                .addComponent(labelImagemBebida)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(botaoProcurarImagemBebida)))
                        .addGap(0, 29, Short.MAX_VALUE))
                    .addGroup(jPanelMenuCadastroBebidaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(botaoCadastrarBebida, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botaoCancelarBebida, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanelMenuCadastroBebidaLayout.setVerticalGroup(
            jPanelMenuCadastroBebidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelMenuCadastroBebidaLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanelMenuCadastroBebidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanelMenuCadastroBebidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(labelNomeLanche)
                        .addComponent(textNomeBebida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(textPrecoBebida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(labelPrecoBebida))
                    .addGroup(jPanelMenuCadastroBebidaLayout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addGroup(jPanelMenuCadastroBebidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(textSaborBebida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(labelSaborBebida, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(botaoProcurarImagemBebida)
                            .addComponent(labelImagemBebida))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelMenuCadastroBebidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(textTamanhoBebida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelTamanhoBebida))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 91, Short.MAX_VALUE)
                .addGroup(jPanelMenuCadastroBebidaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(botaoCadastrarBebida, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(botaoCancelarBebida, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelMenuCadastroBebida, javax.swing.GroupLayout.DEFAULT_SIZE, 340, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanelMenuCadastroBebida, javax.swing.GroupLayout.DEFAULT_SIZE, 298, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void botaoCancelarBebidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCancelarBebidaActionPerformed
        // TODO add your handling code here:
        this.getTelaCrudBebidas().setEnabled(true);
        this.getTelaCrudBebidas().setVisible(true);
        this.dispose();
        
        
    }//GEN-LAST:event_botaoCancelarBebidaActionPerformed

    private void botaoCadastrarBebidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_botaoCadastrarBebidaActionPerformed
            // TODO add your handling code here:
        
        String nomeBebida;
        String saborBebida;
        int tamanhoBebida;
        int tamanhoBebidaFinal;
        float precoBebida;
        float precoBebidaFinal;        
        
        /*try{
            if(textNomeBebida.getText().equals(null))
                JOptionPane.showMessageDialog(null, "Preencha o campo 'Nome'");
            else if(textSaborBebida.getText().equals(null))
                    JOptionPane.showMessageDialog(null, "Preencha o campo 'Sabor'");            

            try{
                tamanhoBebida = Integer.parseInt(textTamanhoBebida.getText());        
                tamanhoBebidaFinal = Integer.parseInt(textTamanhoBebida.getText());
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Preencha o campo 'Tamanho'");
            }

            try{
                precoBebida = Float.parseFloat(textPrecoBebida.getText());
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Não temos bebidas com valores negativos!");
            }finally{
                precoBebidaFinal = Float.parseFloat(textPrecoBebida.getText());     
            }            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }finally{
            nomeBebida = textNomeBebida.getText();        
            saborBebida = textSaborBebida.getText();            
        }*/
    }//GEN-LAST:event_botaoCadastrarBebidaActionPerformed

    private void textSaborBebidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textSaborBebidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textSaborBebidaActionPerformed

    private void textNomeBebidaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textNomeBebidaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_textNomeBebidaActionPerformed

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
            java.util.logging.Logger.getLogger(TelaAdicionarBebidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAdicionarBebidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAdicionarBebidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAdicionarBebidas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAdicionarBebidas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton botaoCadastrarBebida;
    private javax.swing.JButton botaoCancelarBebida;
    private javax.swing.JButton botaoProcurarImagemBebida;
    private javax.swing.JPanel jPanelMenuCadastroBebida;
    private javax.swing.JLabel labelImagemBebida;
    private javax.swing.JLabel labelNomeLanche;
    private javax.swing.JLabel labelPrecoBebida;
    private javax.swing.JLabel labelSaborBebida;
    private javax.swing.JLabel labelTamanhoBebida;
    private javax.swing.JTextField textNomeBebida;
    private javax.swing.JTextField textPrecoBebida;
    private javax.swing.JTextField textSaborBebida;
    private javax.swing.JTextField textTamanhoBebida;
    // End of variables declaration//GEN-END:variables
}
