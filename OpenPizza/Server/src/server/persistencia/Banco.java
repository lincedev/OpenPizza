
package server.persistencia;

import javax.swing.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import server.modelo.*;
import server.modelo.*;

/*
 Descrição: Classe de persistência com o banco de dados
 */
public class Banco {
    
    private String queryProduto;
    private Statement statement;
    private Connection connection;
    private Autenticacao autenticacaoServer;    
    
    public Banco(){};
    
    public Banco(Autenticacao autenticacaoServer){
        this.setAutenticacaoServer(autenticacaoServer);
    }
    
    public String getQueryProduto() {
        return queryProduto;
    }

    public void setQueryProduto(String queryProduto) {
        this.queryProduto = queryProduto;
    }                   

    public Autenticacao getAutenticacaoServer() {
        return autenticacaoServer;
    }

    public void setAutenticacaoServer(Autenticacao autenticacaoServer) {
        this.autenticacaoServer = autenticacaoServer;
    }        
    
    public void abrirConexao(Autenticacao autenticacaoServer){
        Connection cn = null;
        try{
            //cn = DriverManager.getConnection(autenticacaoServer.getCaminhoBanco(), autenticacaoServer.getUsuarioBanco(), autenticacaoServer.getUsuarioSenha());
            cn = DriverManager.getConnection(this.getAutenticacaoServer().getCaminhoBanco(), this.getAutenticacaoServer().getUsuarioBanco(), this.getAutenticacaoServer().getUsuarioSenha());
            //return cn;
        }catch(Exception e){
            //return cn;
        }
    } 
    
    public void fecharConexao(){
        try{
            connection.close();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Não foi possível encerrar a conexão");
            e.printStackTrace();
        }                       
    }
    
    public boolean inserirPizzaSemImagem(Autenticacao autenticacaoServer, String descricaoPizza, 
            String tamanhoPizza, int quantidadeFatiasPizza, String ingredientesPizza, 
            float precoPizza) throws Exception {                
        String queryPizza;
        try{
            statement = null;                        
            JOptionPane.showMessageDialog(null, "Abrindo Conexao");        
            this.abrirConexao(autenticacaoServer);                
            JOptionPane.showMessageDialog(null, "Stabelecendo Conexao");        
            this.statement = connection.createStatement();            
            this.queryProduto = ("INSERT INTO produto(descricao) VALUES('" + descricaoPizza + "')");                        
            this.statement.executeUpdate(this.queryProduto);            
            queryPizza = "insert into pizza (codProduto, preco, tamanho, fatias, ingredientes) values ((select codigo from produto where produto.codigo = (select max(codigo) from produto)), '" + precoPizza + "', '" + tamanhoPizza + "', '" + quantidadeFatiasPizza + "', '" + ingredientesPizza + "')";
            this.statement.executeUpdate(queryPizza);
            this.fecharConexao();            
            return(true);
        } catch (Exception e) {
            e.printStackTrace();
            return(false);
        } finally {
            this.fecharConexao();                        
        }
    }                               
        
    public boolean inserirLanche(Autenticacao autenticacaoServer, String descricaoLanche, float precoLanche, String ingredientesLanche) throws Exception {        
        String queryLanche;      
        try{
            statement = null;                        
            this.abrirConexao(autenticacaoServer);                
            this.statement = connection.createStatement();            
            this.queryProduto = ("INSERT INTO Produto(descricao) VALUES('" + descricaoLanche + "')");                        
            this.statement.executeUpdate(this.queryProduto);                       
            queryLanche = "insert into lanche (codProduto, preco, ingredientesLanche) values ((select codigo from produto where produto.codigo = (select max(codigo) from produto)), '" + precoLanche + "', '" + ingredientesLanche + "')";
            this.statement.executeUpdate(queryLanche);
            this.fecharConexao();            
            return(true);
        } catch (Exception e) {
            e.printStackTrace();
            return(false);
        } finally {
            this.fecharConexao();                        
        }
    }                         

    public boolean inserirBebida(Autenticacao autenticacaoServer, String descricaoBebida, float precoBebida) throws Exception {        
        String queryBebida;
        try{
            statement = null;                        
            this.abrirConexao(autenticacaoServer);                
            this.statement = connection.createStatement();            
            this.queryProduto = ("INSERT INTO Produto(descricao) VALUES('" + descricaoBebida + "')");                        
            this.statement.executeUpdate(this.queryProduto);            
            queryBebida = "insert into bebidas (codProduto, preco) values ((select codigo from produto where produto.codigo = (select max(codigo) from produto)), '" + precoBebida + "')";
            this.statement.executeUpdate(queryBebida);
            this.fecharConexao();            
            return(true);
        } catch (Exception e) {
            e.printStackTrace();
            return(false);
        } finally {
            this.fecharConexao();                        
        }
    }
    
    public boolean inserirOutros(Autenticacao autenticacaoServer, String descricaoOutros, float precoOutros) throws Exception {        
        String queryOutros;
        try{
            statement = null;                        
            this.abrirConexao(autenticacaoServer);                
            this.statement = connection.createStatement();            
            this.queryProduto = ("INSERT INTO Produto(descricao) VALUES('" + descricaoOutros + "')");                        
            this.statement.executeUpdate(this.queryProduto);                                    
            queryOutros = "insert into outros (codProduto, preco) values ((select codigo from produto where produto.codigo = (select max(codigo) from produto)), '" + precoOutros + "')";
            this.statement.executeUpdate(queryOutros);
            this.fecharConexao();            
            return(true);
        } catch (Exception e) {
            e.printStackTrace();
            return(false);
        } finally {
            this.fecharConexao();                        
        }
    }
    
    /*
    public boolean excluirProduto(Autenticacao autenticacao, int codigoProduto){
        
        
        String query = "DELETE FROM Produto WHERE codigo = " + codigoProduto;
        try{
            Connection cn = this.abrirConexao(this.getAutenticacaoServer());
            Statement st = cn.createStatement();
            st.executeUpdate(query);
            cn.close();
            return true;
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
        finally{
        }
    }
    */
}