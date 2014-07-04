package client.persistence;

import client.model.Autenticacao;
import client.model.Pedido;
import client.model.Pizza;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
import javax.swing.JTable;
import javax.swing.JTextArea;
import net.proteanit.sql.DbUtils;

/*
 Descrição: Classe de persistência com o banco de dados
 */
public class Banco {
    
    /*
     Descrição: Método para abertura de conexão com o banco de dados
     Parâmetros:
     *           autenticacao (Necessário para acesso ao banco de dados)
     Retorno:
     *           conexao (Conexão com o banco de dados)
     */
    public Connection abrirConexao(Autenticacao autenticacao) throws Exception {
        try {
            Connection conexao = DriverManager.getConnection(autenticacao.getCaminhoBanco(), autenticacao.getUsuarioBanco(), autenticacao.getUsuarioSenha());
            return conexao;
        } catch (Exception e) {
            throw new Exception();
        }
    }

    /*
     Descrição: Método para finalização de conexão com o banco de dados.
     Parâmetros:
     *           conexao (Conexão que será fechada)
     Retorno:
     */
    public void fecharConexao(Connection conexao) throws Exception {
        try {
            conexao.close();
        } catch (Exception e) {
            throw new Exception();
        }
    }
    
    /*
     Descrição: Método para verificação do status da conexão.
     Parâmetros:
                autenticacao (Objeto com as informações para acesso ao banco de dados)
     Retorno:
                true, caso a conexão seja efetuada com sucesso; false, caso contrário;
     */
    public boolean verificarConexao(Autenticacao autenticacao){
        try{
            Connection conexao = this.abrirConexao(autenticacao);
            this.fecharConexao(conexao);
            return true;
        }
        catch(Exception e){
            return false;
        }
        
    }
    
    /*
     Descrição: Método para recuperação do número das mesas cadastradas no banco de dados.
     Parâmetros:
                autenticacao (Objeto com as informações para acesso ao banco de dados)
     Retorno:
                mesas (ArrayList contendo todas as mesas cadastradas)
     */
    public ArrayList consultarMesas(Autenticacao autenticacao){
        Connection conexao = null;
        ArrayList<Integer> mesas = new ArrayList<>();
        try{
            conexao = this.abrirConexao(autenticacao);
            String query = "SELECT * FROM Mesa";
            PreparedStatement statement = conexao.prepareStatement(query);
            ResultSet resultado = statement.executeQuery();
            while(resultado.next()){
                mesas.add(resultado.getInt("numero"));
            }
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
            return mesas;
        }
    }
    
    public int consultarNumeroDoPedido(int numeroDaMesa, Autenticacao autenticacao){
        int numeroDoPedido = -1;
        Connection conexao = null;
        try{
           String query = "SELECT numeroPedido FROM Pedido AS P JOIN Mesa AS M ON P.numeroMesa = M.numero WHERE M.numero = " + numeroDaMesa + " AND P.pedidoFinalizado = false";
           conexao = this.abrirConexao(autenticacao);
           Statement homologacao = conexao.createStatement();
           ResultSet resultado = homologacao.executeQuery(query);
           if(resultado.next()){
               numeroDoPedido = resultado.getInt("numeroPedido");
           }
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
        return numeroDoPedido;
    }
    
    public void consultarItensDoPedido(JTable tabelaItensDoPedido, int numeroDoPedido, Autenticacao autenticacao){
        Connection conexao = null;
        try{
            String query = "SELECT P.descricao, IDP.tamanho, IDP.qtdadeProdutos, IDP.preco FROM Produto AS P JOIN ItemDoPedido AS IDP ON P.codigo = IDP.codigoProduto WHERE IDP.pedidoNumero = " + numeroDoPedido;
            conexao = this.abrirConexao(autenticacao);
            Statement homologacao = conexao.createStatement();
            ResultSet resultado = homologacao.executeQuery(query);
            tabelaItensDoPedido.setModel(DbUtils.resultSetToTableModel(resultado));
            this.fecharConexao(conexao);
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
    
    public float consultarValorDoPedido(int numeroDoPedido, Autenticacao autenticacao){
        float valorDoPedido = -1;
        Connection conexao = null;
        try{
            String query = "SELECT SUM(qtdadeProdutos * preco) FROM ItemDoPedido WHERE pedidoNumero = " + numeroDoPedido;
            conexao = this.abrirConexao(autenticacao);
            Statement homologacao = conexao.createStatement();
            ResultSet resultado = homologacao.executeQuery(query);
            if(resultado.next()){
                valorDoPedido = resultado.getFloat("SUM(qtdadeProdutos * preco)");
            }
        }
        catch(Exception e){
            valorDoPedido = -1;
        }
        finally{
            try{
                this.fecharConexao(conexao);
            }
            catch(Exception e){
                
            }
        }
        return valorDoPedido;
    }
    
    public void consultarCardapio(JTable tabelaPizzas, Autenticacao autenticacao, String categoriaDoProduto){
        Connection conexao = null;
        try{
            String query;
            if(categoriaDoProduto.equals("Pizza")){
                query = "SELECT P.descricao FROM Produto AS P JOIN Pizza AS PZ ON P.codigo = PZ.codProduto GROUP BY P.descricao ORDER BY P.descricao";
            }
            else if(categoriaDoProduto.equals("Lanche")){
                query = "SELECT P.descricao FROM Produto AS P JOIN Lanche AS L ON P.codigo = L.codProduto GROUP BY P.descricao ORDER BY P.descricao";
            }
            else if(categoriaDoProduto.equals("Bebida")){
                query = "SELECT P.descricao FROM Produto AS P JOIN Bebidas AS B ON P.codigo = B.codProduto GROUP BY P.descricao ORDER BY P.descricao";
            }
            else{
                query = "SELECT P.descricao FROM Produto AS P JOIN Outros AS O ON P.codigo = O.codProduto GROUP BY P.descricao ORDER BY P.descricao";
            }
            conexao = this.abrirConexao(autenticacao);
            Statement homologacao = conexao.createStatement();
            ResultSet resultado = homologacao.executeQuery(query);
            tabelaPizzas.setModel(DbUtils.resultSetToTableModel(resultado));
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
    
    public boolean inserirPedido(int numeroDaMesa, Autenticacao autenticacao){
        Connection conexao = null;
        try{
            String query = "INSERT INTO Pedido(data, horaInicio, valor, formaPagamento, numeroMesa, pedidoFinalizado) VALUES(current_date, current_time, 0.0, null," + numeroDaMesa + ", false)";
            conexao = this.abrirConexao(autenticacao);
            Statement homologacao = conexao.createStatement();
            homologacao.executeUpdate(query);
            this.fecharConexao(conexao);
            return true;
        }
        catch(Exception e){
            try{
                this.fecharConexao(conexao);
            }
            catch(Exception e2){
                
            }
            return false;
        }
    }
    
    public void consultarOpcoesDoProduto(JTable tabelaOpcoesDisponiveis, Autenticacao autenticacao, String categoriaDoProduto, String nomeDoProduto){
        Connection conexao = null;
        try{
            String query;
            if(categoriaDoProduto.equals("Pizza")){
                query = "SELECT P.codigo, PZ.tamanho, PZ.fatias, PZ.preco FROM Pizza AS PZ JOIN Produto AS P ON PZ.codProduto = P.codigo WHERE P.descricao LIKE '" + nomeDoProduto + "'";
                
            }
            else if(categoriaDoProduto.equals("Lanche")){
                query = "SELECT P.codigo, P.descricao, L.preco FROM Produto AS P JOIN Lanche AS L ON P.codigo = L.codProduto WHERE P.descricao LIKE '" + nomeDoProduto + "'";
            }
            else if(categoriaDoProduto.equals("Bebida")){
                query = "SELECT P.codigo, P.descricao, B.preco FROM Produto AS P JOIN Bebidas AS B ON P.codigo = B.codProduto WHERE P.descricao LIKE '" + nomeDoProduto + "'";
            }
            else{
                query = "SELECT P.codigo, P.descricao, O.preco FROM Produto AS P JOIN Outros AS O ON P.codigo = O.codProduto WHERE P.descricao LIKE '" + nomeDoProduto + "'";
            }
            conexao = this.abrirConexao(autenticacao);
            Statement homologacao = conexao.createStatement();
            ResultSet resultado = homologacao.executeQuery(query);
            tabelaOpcoesDisponiveis.setModel(DbUtils.resultSetToTableModel(resultado));
            this.fecharConexao(conexao);
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
    
    public boolean consultarProdutoNoPedido(Autenticacao autenticacao, int numeroDoPedido, int codigoDoProduto){
        boolean produtoEncontrado = false;
        Connection conexao = null;
        try{
            String query = "SELECT IDP.qtdadeProdutos FROM ItemDoPedido AS IDP JOIN Pedido AS P ON IDP.pedidoNumero = P.numeroPedido WHERE IDP.pedidoNumero = " + numeroDoPedido + " AND IDP.codigoProduto = " + codigoDoProduto + " AND P.pedidoFinalizado = false";
            conexao = this.abrirConexao(autenticacao);
            Statement homologacao = conexao.createStatement();
            ResultSet resultado = homologacao.executeQuery(query);
            if(resultado.next()){
                this.fecharConexao(conexao);
                produtoEncontrado = true;
            }
            else{
                this.fecharConexao(conexao);
                produtoEncontrado = false;
            }
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
        return produtoEncontrado;
    }
    
    public boolean inserirProduto(Autenticacao autenticacao, int numeroDoPedido, int codigoDoProduto, int quantidade, String tamanho, float preco){
        Connection conexao = null;
        try{
            String query = "INSERT INTO ItemDoPedido(pedidoNumero, codigoProduto, qtdadeProdutos, tamanho, preco) VALUES(" + numeroDoPedido + "," + codigoDoProduto + "," + quantidade + ",'" + tamanho + "'," + preco + ")";
            conexao = this.abrirConexao(autenticacao);
            Statement homologacao = conexao.createStatement();
            homologacao.executeUpdate(query);
            this.fecharConexao(conexao);
            return true;
        }
        catch(Exception e){
            try{
                this.fecharConexao(conexao);
            }
            catch(Exception e2){
                
            }
            return false;
        }
    }
    
    public boolean atualizarQuantidadeDoProdutoNoPedido(Autenticacao autenticacao, int numeroDoPedido, String categoriaDoProduto, int codigoDoProduto, int quantidade){
        Connection conexao = null;
        try{
            String query = "UPDATE ItemDoPedido SET qtdadeProdutos = qtdadeProdutos + " + quantidade + " WHERE pedidoNumero = " + numeroDoPedido + " AND codigoProduto = " + codigoDoProduto;
            conexao = this.abrirConexao(autenticacao);
            Statement homologacao = conexao.createStatement();
            homologacao.executeUpdate(query);
            this.fecharConexao(conexao);
            return true;
        }
        catch(Exception e){
            try{
                this.fecharConexao(conexao);
            }
            catch(Exception e2){
                
            }
            return false;
        }
    }
    
    public boolean cancelarPedido(Autenticacao autenticacao, int numeroDoPedido){
        Connection conexao = null;
        try{
            String query = "UPDATE Pedido SET pedidoFinalizado = TRUE, horaFim = current_time WHERE numeroPedido = " + numeroDoPedido + " AND pedidoFinalizado = FALSE";
            conexao = this.abrirConexao(autenticacao);
            Statement homologacao = conexao.createStatement();
            homologacao.executeUpdate(query);
            this.fecharConexao(conexao);
            return true;
        }
        catch(Exception e){
            try{
                this.fecharConexao(conexao);
            }
            catch(Exception e2){
                
            }
            return false;
        }
    }
    
    public boolean finalizarPedido(Autenticacao autenticacao, int numeroDoPedido, String formaDePagamento, float valor){
        Connection conexao = null;
        try{
            String query = "UPDATE Pedido SET valor = " + valor + ", pedidoFinalizado = TRUE, horaFim = current_time, formaPagamento = '" + formaDePagamento + "' WHERE numeroPedido = " + numeroDoPedido + " AND pedidoFinalizado = FALSE";
            conexao = this.abrirConexao(autenticacao);
            Statement homologacao = conexao.createStatement();
            homologacao.executeUpdate(query);
            this.fecharConexao(conexao);
            return true;
        }
        catch(Exception e){
            try{
                this.fecharConexao(conexao);
            }
            catch(Exception e2){
                
            }
            return false;
        }
    }
    
    public void consultarIngredientes(JTextArea textoIngredientes, Autenticacao autenticacao, String categoriaDoProduto, int codigoDoProduto){
        Connection conexao = null;
        try{
            String query;
            if(categoriaDoProduto.equals("Pizza")){
                query = "SELECT PZ.ingredientes FROM Pizza AS PZ JOIN Produto AS P ON PZ.codProduto = P.codigo WHERE P.codigo = " + codigoDoProduto;
            }
            else{
                query = "SELECT L.ingredientesLanche FROM Lanche AS L JOIN Produto AS P ON L.codProduto = P.codigo WHERE P.codigo = " + codigoDoProduto;
            }
            conexao = this.abrirConexao(autenticacao);
            Statement homologacao = conexao.createStatement();
            ResultSet resultado = homologacao.executeQuery(query);
            if(resultado.next()){
                if(categoriaDoProduto.equals("Pizza")){
                    textoIngredientes.setText(resultado.getString("ingredientes"));
                }
                else{
                    textoIngredientes.setText(resultado.getString("ingredientesLanches"));
                }
            }
        }
        catch(Exception e){
            
        }
    }
}
