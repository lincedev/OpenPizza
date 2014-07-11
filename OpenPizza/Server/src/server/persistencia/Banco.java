
package server.persistencia;

import javax.swing.*;
import java.io.*;
import java.sql.*;
import java.util.*;
import net.proteanit.sql.DbUtils;
import server.modelo.*;
import server.modelo.*;

/*
 Descrição: Classe de persistência com o banco de dados
 */
public class Banco {
    
    public void exibirPedidosEmAberto(Autenticacao autenticacao, JTable tabelaPedidosEmAberto){
        Connection conexao = null;
        try{
            
            String query = "SELECT * FROM Pedido WHERE pedidoFinalizado = false";
            conexao = this.abrirConexao(autenticacao);
            Statement homologacao = conexao.createStatement();
            ResultSet resultado = homologacao.executeQuery(query);
            tabelaPedidosEmAberto.setModel(DbUtils.resultSetToTableModel(resultado));
        }
        catch(Exception e){
            e.printStackTrace();
        }
        finally{
            try{
                this.fecharConexao(conexao);
            }
            catch(Exception e){
                
            }
            
        }
    }
    
    /*
     Descrição: Método para tentativa de consulta dos produtos disponíveis no banco de dados (cardápio)
     Parâmetros:
     tabelaProdutos (JTable que será preenchida com os produtos disponíveis)
     autenticacao (Objeto do tipo Autenticacao contendo as informações para acesso ao banco de dados)
     categoriaDoProduto (String contendo a categoria do produto (Pizza, Lanche, Bebida, Outro)
     Retorno:
     */
    public void consultarCardapio(JTable tabelaProdutos, Autenticacao autenticacao, String categoriaDoProduto) {
        Connection conexao = null;
        try {
            String query;
            if (categoriaDoProduto.equals("Pizza")) {
                query = "SELECT P.descricao FROM Produto AS P JOIN Pizza AS PZ ON P.codigo = PZ.codProduto WHERE P.ativo = true GROUP BY P.descricao ORDER BY P.descricao";
            } else if (categoriaDoProduto.equals("Lanche")) {
                query = "SELECT P.descricao FROM Produto AS P JOIN Lanche AS L ON P.codigo = L.codProduto WHERE P.ativo = true GROUP BY P.descricao ORDER BY P.descricao";
            } else if (categoriaDoProduto.equals("Bebida")) {
                query = "SELECT P.descricao FROM Produto AS P JOIN Bebidas AS B ON P.codigo = B.codProduto WHERE P.ativo = true GROUP BY P.descricao ORDER BY P.descricao";
            } else {
                query = "SELECT P.descricao FROM Produto AS P JOIN Outros AS O ON P.codigo = O.codProduto WHERE P.ativo = true GROUP BY P.descricao ORDER BY P.descricao";
            }
            conexao = this.abrirConexao(autenticacao);
            Statement homologacao = conexao.createStatement();
            ResultSet resultado = homologacao.executeQuery(query);
            tabelaProdutos.setModel(DbUtils.resultSetToTableModel(resultado));
        } catch (Exception e) {

        } finally {
            try {
                this.fecharConexao(conexao);
            } catch (Exception e) {

            }
        }
    }
    
    public void exibirProdutos(Autenticacao autenticacao, JTable tabelaProdutos, String categoriaDoProduto){
        Connection conexao = null;
        try{
            String query;
            if(categoriaDoProduto.equals("Pizza")){
                query = "SELECT p.descricao AS 'Descrição', pp.preco AS 'Preço', pp.tamanho AS 'Tamanho' , pp.fatias AS 'Fatias' FROM Produto AS p JOIN Pizza AS pp ON p.codigo = pp.codProduto";
            }
            else if(categoriaDoProduto.equals("Lanche")){
                query = "SELECT p.descricao AS 'Descrição', l.preco AS 'Preço' FROM Produto AS p JOIN Lanche AS l ON p.codigo = l.codProduto";
            }
            else if(categoriaDoProduto.equals("Bebida")){
                query = "SELECT p.codigo, p.descricao AS 'Descrição', b.preco AS 'Preço' FROM Produto AS p JOIN Bebidas AS b ON p.codigo = b.codProduto";
            }
            else if(categoriaDoProduto.equals("Outro")){
                query = "SELECT p.descricao AS 'Descrição', o.preco AS 'Preço' FROM Produto AS p JOIN Outros AS o ON p.codigo = o.codProduto";
            }
            else{
                query = "SELECT numero AS 'Número', ativo AS 'Ativo' FROM Mesa";
            }
            conexao = this.abrirConexao(autenticacao);
            Statement homologacao = conexao.createStatement();
            ResultSet resultado = homologacao.executeQuery(query);
            tabelaProdutos.setModel(DbUtils.resultSetToTableModel(resultado));
        }
        catch(Exception e){
            
        }
        finally{
            try{
                this.fecharConexao(conexao);
            }
            catch(Exception e){
                
            }
        }
    }
    
    /*
     Descrição: Método para consulta dos ingredientes referentes à um determinado produto
     Parâmetros:
     textoIngredientes (JTextArea que será preenchida com os ingredientes do produto)
     autenticacao (Objeto do tipo Autenticacao contendo as informações para acesso ao banco de dados)
     categoriaDoProduto (String contendo a categoria do produto (Pizza, Lanche, Bebida, Outro)
     codigoDoProduto (Inteiro contendo o código do produto selecionado na Tela de Inclusão de Produtos)
     Retorno:
     */
    public void consultarIngredientes(JTextArea textoIngredientes, Autenticacao autenticacao, String categoriaDoProduto, String nomeDoProduto) {
        Connection conexao = null;
        try {
            String query;
            if (categoriaDoProduto.equals("Pizza")) {
                query = "SELECT PZ.ingredientes FROM Pizza AS PZ JOIN Produto AS P ON PZ.codProduto = P.codigo WHERE P.descricao LIKE '" + nomeDoProduto + "'";
            } else {
                query = "SELECT L.ingredientesLanche FROM Lanche AS L JOIN Produto AS P ON L.codProduto = P.codigo WHERE P.descricao LIKE '" + nomeDoProduto + "'";
            }
            conexao = this.abrirConexao(autenticacao);
            Statement homologacao = conexao.createStatement();
            ResultSet resultado = homologacao.executeQuery(query);
            if (resultado.next()) {
                if (categoriaDoProduto.equals("Pizza")) {
                    textoIngredientes.setText(resultado.getString("ingredientes"));
                } else {
                    textoIngredientes.setText(resultado.getString("ingredientesLanches"));
                }
            }
        } catch (Exception e) {

        }
    }
    
    
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
    
    public Connection abrirConexao(Autenticacao autenticacaoServer){
        Connection conexao = null;
        try{
            conexao = DriverManager.getConnection(autenticacaoServer.getCaminhoBanco(), autenticacaoServer.getUsuarioBanco(), autenticacaoServer.getUsuarioSenha());
            return conexao;
        }catch(Exception e){
            return conexao;
        }
    } 
    
    public void fecharConexao(Connection conexao){
        try{
            conexao.close();
        } catch(Exception e){
            JOptionPane.showMessageDialog(null, "Não foi possível encerrar a conexão");
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
            this.fecharConexao(connection);            
            return(true);
        } catch (Exception e) {
            e.printStackTrace();
            return(false);
        } finally {
            this.fecharConexao(connection);                        
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
            this.fecharConexao(connection);            
            return(true);
        } catch (Exception e) {
            e.printStackTrace();
            return(false);
        } finally {
            this.fecharConexao(connection);                        
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
            this.fecharConexao(connection);            
            return(true);
        } catch (Exception e) {
            e.printStackTrace();
            return(false);
        } finally {
            this.fecharConexao(connection);                        
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
            this.fecharConexao(connection);            
            return(true);
        } catch (Exception e) {
            e.printStackTrace();
            return(false);
        } finally {
            this.fecharConexao(connection);                        
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