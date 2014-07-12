/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package server.controle;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.util.HashMap;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import server.modelo.Autenticacao;
import server.persistencia.Arquivos;
import server.persistencia.Banco;

/**
 *
 * @author Wellington
 */
public class Controle {
    
    private final Banco banco = new Banco();
    private final Arquivos arquivo = new Arquivos();
    
    public void exibirPedidosEmAberto(Autenticacao autenticacao, JTable tabelaPedidosEmAberto){
        this.banco.exibirPedidosEmAberto(autenticacao, tabelaPedidosEmAberto);
    }
    
    public Autenticacao recuperarDadosDeAutenticacao(){
        Arquivos arquivo = new Arquivos();
        Autenticacao autenticacao = null;
        try{
            autenticacao = arquivo.lerArquivo();
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return autenticacao;
    }
    
    public void consultarCardapio(Autenticacao autenticacao, JTable tabelaProduto, String categoriaDoProduto){
        this.banco.consultarCardapio(tabelaProduto, autenticacao, categoriaDoProduto);
    }
    
    public void exibirProdutos(Autenticacao autenticacao, JTable tabelaProduto, String categoriaDoProduto){
        this.banco.exibirProdutos(autenticacao, tabelaProduto, categoriaDoProduto);
    }
    
    public void consultarIngredientes(JTextArea textoIngredientes, Autenticacao autenticacao, String categoriaDoProduto, String nomeDoProduto){
        this.banco.consultarIngredientes(textoIngredientes, autenticacao, categoriaDoProduto, nomeDoProduto);
    }
    
    public boolean inserirProduto(Autenticacao autenticacao, Object produto){
        boolean inserirProduto = this.banco.inserirProduto(autenticacao, produto);
        return inserirProduto;
    }
 
    /*
     Descrição: Método para tentativa de autenticação dos dados do banco de dados.
     Parâmetros:
     Retorno:
     */
    public void verificarAutenticacao(Autenticacao autenticacao) {
        Arquivos arquivo = new Arquivos();
        try {
            autenticacao = arquivo.lerArquivo();
            try {
                Connection conexao = DriverManager.getConnection(autenticacao.getCaminhoBanco(), autenticacao.getUsuarioBanco(), autenticacao.getUsuarioSenha());
                conexao.close();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Não foi possível autenticar a conexão.", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Não foi possível estabelecer conexão automática com o banco de dados.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public boolean verificarCamposBebidasOutros(JTextField descricao, JTextField preco, JTextField estoque){
        if((descricao.getText().isEmpty()) || (preco.getText().isEmpty()) || (estoque.getText().isEmpty())){
            return false;
        }
        else{
            try{
                if((Float.parseFloat(preco.getText()) < 0) || (Integer.parseInt(estoque.getText()) < 0)){
                    return false;
                }
                else{
                    return true;
                }
            }
            catch(Exception e){
                return false;
            }
        }
    }
    
    public boolean verificarCamposLanche(JTextField descricao, JTextField preco){
        if((descricao.getText().isEmpty()) || (preco.getText().isEmpty())){
            return false;
        }
        else{
            try{
                if(Float.parseFloat(preco.getText()) < 0){
                    return false;
                }
                else{
                    return true;
                }
            }
            catch(Exception e){
                return false;
            }
        }
    }
    
    public boolean verificarCamposPizza(JTextField descricao, JTextField preco, JComboBox comboBoxTamanhoPizzas){
        if((descricao.getText().isEmpty()) || (preco.getText().isEmpty()) || (comboBoxTamanhoPizzas.getSelectedIndex() == 0)){
            return false;
        }
        else{
            try{
                if(Float.parseFloat(preco.getText()) < 0){
                    return false;
                }
                else{
                    return true;
                }
            }
            catch(Exception e){
                return false;
            }
        }
    }
    
    public boolean desativarProduto(Autenticacao autenticacao, int codigoDoProduto){
        boolean desativarProduto = this.banco.desativarProduto(autenticacao, codigoDoProduto);
        return desativarProduto;
    }
    
    public boolean inserirMesa(Autenticacao autenticacao){
        boolean inserirMesa = this.banco.inserirMesa(autenticacao);
        return inserirMesa;
    }
    
    public boolean desativarMesa(Autenticacao autenticacao, int numeroDaMesa){
        boolean desativarMesa = this.banco.desativarMesa(autenticacao, numeroDaMesa);
        return desativarMesa;
    }
    
    public void gerarRelatorio(Autenticacao autenticacao, String tipoProduto) {
        this.banco.gerarRelatorio(autenticacao, tipoProduto);
    }
}