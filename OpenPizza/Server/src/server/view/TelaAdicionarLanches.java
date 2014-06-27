/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server.view;

import java.sql.*;
import javax.swing.JOptionPane;
import server.modelo.Autenticacao;
import server.persistencia.Banco;

/**
 *
 * @author Wellington
 */
public class TelaAdicionarLanches extends javax.swing.JFrame {

    private TelaCRUDLanches telaCrudLanches;
    private Banco bancoDados = new Banco();
    private Connection connection;
    private Autenticacao autenticacaoServer;
    private String descricaoLanche;
    private String ingredientesLanche;
    private String precoLanche;
    private float precoLancheFinal;
        
    public TelaAdicionarLanches() {
        initComponents();
    }

    public TelaAdicionarLanches(TelaCRUDLanches telaCrudLanches, Autenticacao autenticacaoServer)            
    {
        this();        
        this.setAutenticacaoServer(autenticacaoServer);
        this.setTelaCrudLanches(telaCrudLanches);
    }
    
    public TelaCRUDLanches getTelaCrudLanches() {
        return telaCrudLanches;
    }

    public void setTelaCrudLanches(TelaCRUDLanches telaCrudLanches) {
        this.telaCrudLanches = telaCrudLanches;
    }

    public Banco getBancoDados() {
        return bancoDados;
    }

    public void setBancoDados(Banco bancoDados) {
        this.bancoDados = bancoDados;
    }

    public Autenticacao getAutenticacaoServer() {
        return autenticacaoServer;
    }

    public void setAutenticacaoServer(Autenticacao autenticacaoServer) {
        this.autenticacaoServer = autenticacaoServer;
    }

    public String getDescricaoLanche() {
        return descricaoLanche;
    }

    public void setDescricaoLanche(String descricaoLanche) {
        this.descricaoLanche = descricaoLanche;
    }

    public String getIngredientesLanche() {
        return ingredientesLanche;
    }

    public void setIngredientesLanche(String ingredientesLanche) {
        this.ingredientesLanche = ingredientesLanche;
    }

    public String getPrecoLanche() {
        return precoLanche;
    }

    public void setPrecoLanche(String precoLanche) {
        this.precoLanche = precoLanche;
    }

    public float getPrecoLancheFinal() {
        return precoLancheFinal;
    }

    public void setPrecoLancheFinal(float precoLancheFinal) {
        this.precoLancheFinal = precoLancheFinal;
    }
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelCadastroLanches = new javax.swing.JPanel();
        labelDescricaoLanche = new javax.swing.JLabel();
        textDescricaoLanche = new javax.swing.JTextField();
        labelPrecoLanche = new javax.swing.JLabel();
        textPrecoLanche = new javax.swing.JTextField();
        labelIngredientesLanche = new javax.swing.JLabel();
        textIngredientesLanche = new javax.swing.JTextField();
        buttonCadastrarLanche = new javax.swing.JToggleButton();
        buttonCancelarCadastroLanche = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        painelCadastroLanches.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Cadastro de Lanches", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION));

        labelDescricaoLanche.setText("Descrição:");

        textDescricaoLanche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textDescricaoLancheActionPerformed(evt);
            }
        });

        labelPrecoLanche.setText("Preço:");

        textPrecoLanche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textPrecoLancheActionPerformed(evt);
            }
        });

        labelIngredientesLanche.setText("Ingredientes:");

        textIngredientesLanche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                textIngredientesLancheActionPerformed(evt);
            }
        });

        buttonCadastrarLanche.setText("Cadastrar");
        buttonCadastrarLanche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCadastrarLancheActionPerformed(evt);
            }
        });

        buttonCancelarCadastroLanche.setText("Cancelar");
        buttonCancelarCadastroLanche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonCancelarCadastroLancheActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelCadastroLanchesLayout = new javax.swing.GroupLayout(painelCadastroLanches);
        painelCadastroLanches.setLayout(painelCadastroLanchesLayout);
        painelCadastroLanchesLayout.setHorizontalGroup(
            painelCadastroLanchesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCadastroLanchesLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(painelCadastroLanchesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelCadastroLanchesLayout.createSequentialGroup()
                        .addComponent(labelPrecoLanche)
                        .addGap(18, 18, 18)
                        .addComponent(textPrecoLanche, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelCadastroLanchesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(painelCadastroLanchesLayout.createSequentialGroup()
                            .addComponent(buttonCadastrarLanche)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(buttonCancelarCadastroLanche))
                        .addComponent(textIngredientesLanche)
                        .addComponent(labelIngredientesLanche)
                        .addGroup(painelCadastroLanchesLayout.createSequentialGroup()
                            .addComponent(labelDescricaoLanche)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(textDescricaoLanche, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(31, Short.MAX_VALUE))
        );
        painelCadastroLanchesLayout.setVerticalGroup(
            painelCadastroLanchesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelCadastroLanchesLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelCadastroLanchesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelDescricaoLanche)
                    .addComponent(textDescricaoLanche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(labelIngredientesLanche)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(textIngredientesLanche, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(painelCadastroLanchesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPrecoLanche)
                    .addComponent(textPrecoLanche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(painelCadastroLanchesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buttonCadastrarLanche)
                    .addComponent(buttonCancelarCadastroLanche))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(painelCadastroLanches, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(35, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(24, Short.MAX_VALUE)
                .addComponent(painelCadastroLanches, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(31, 31, 31))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void textDescricaoLancheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textDescricaoLancheActionPerformed
        this.setDescricaoLanche(textDescricaoLanche.getText());
    }//GEN-LAST:event_textDescricaoLancheActionPerformed

    private void textPrecoLancheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textPrecoLancheActionPerformed
        this.setPrecoLanche(textPrecoLanche.getText());
    }//GEN-LAST:event_textPrecoLancheActionPerformed

    private void textIngredientesLancheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_textIngredientesLancheActionPerformed
        this.setIngredientesLanche(textIngredientesLanche.getText());
    }//GEN-LAST:event_textIngredientesLancheActionPerformed

    private void buttonCadastrarLancheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCadastrarLancheActionPerformed
        this.setDescricaoLanche(textDescricaoLanche.getText());
        this.setPrecoLanche(textPrecoLanche.getText());
        this.setIngredientesLanche(textIngredientesLanche.getText());
        
        if(this.getDescricaoLanche().equals("")){
            JOptionPane.showMessageDialog(null, "Por favor preencha o campo 'Descrição'");
        } else if(this.getPrecoLanche().equals("")){
                JOptionPane.showMessageDialog(null, "Preencha o campo 'Preço'");
                } else if(this.getIngredientesLanche().equals("")){
                    JOptionPane.showMessageDialog(null, "Preencha o campo 'Ingredientes'");
                } else {
                    this.setPrecoLancheFinal(Float.parseFloat(textPrecoLanche.getText()));
                    if(this.getPrecoLancheFinal() <= 0.00){
                        JOptionPane.showMessageDialog(null, "Por favor, preencha com valores Positivos o campo 'Preço'");
                    }
                }
        
        if((!(this.getDescricaoLanche().equals(""))) && (!(this.getPrecoLanche().equals(""))) && (!(this.getIngredientesLanche().equals(""))) && (!(this.getPrecoLancheFinal() <= 0.00))){
            try{
                boolean retorno = bancoDados.inserirLanche(this.getAutenticacaoServer(), this.getDescricaoLanche(), this.getPrecoLancheFinal(), this.getIngredientesLanche());
                if(retorno == true){
                    JOptionPane.showMessageDialog(null, "Lanche cadastrado com sucesso!!!");
                }else{
                    JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o Lanche");
                }                                    
            } catch(Exception e){
                JOptionPane.showMessageDialog(null, "Não foi possível cadastrar o Lanche");
            }
        }                       
        //this.setEnabled(false);
        //this.setVisible(false);
        //this.telaCrudLanches.setEnabled(true);
        //this.telaCrudLanches.setVisible(true);
    }//GEN-LAST:event_buttonCadastrarLancheActionPerformed

    private void buttonCancelarCadastroLancheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonCancelarCadastroLancheActionPerformed
        this.setVisible(false);
        this.setEnabled(false);
        this.telaCrudLanches.setVisible(true);
        this.telaCrudLanches.setEnabled(true);
    }//GEN-LAST:event_buttonCancelarCadastroLancheActionPerformed

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
            java.util.logging.Logger.getLogger(TelaAdicionarLanches.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaAdicionarLanches.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaAdicionarLanches.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaAdicionarLanches.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaAdicionarLanches().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton buttonCadastrarLanche;
    private javax.swing.JButton buttonCancelarCadastroLanche;
    private javax.swing.JLabel labelDescricaoLanche;
    private javax.swing.JLabel labelIngredientesLanche;
    private javax.swing.JLabel labelPrecoLanche;
    private javax.swing.JPanel painelCadastroLanches;
    private javax.swing.JTextField textDescricaoLanche;
    private javax.swing.JTextField textIngredientesLanche;
    private javax.swing.JTextField textPrecoLanche;
    // End of variables declaration//GEN-END:variables
}
