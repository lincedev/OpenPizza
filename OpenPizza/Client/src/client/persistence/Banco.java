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

    /*
     Descrição: Método para realização de consulta de um pedido no banco de dados
     Parâmetros:
     *           autenticacao (Necessário para acesso ao banco de dados)
     *           query (String SQL)
     Retorno:
     *           infoPedido (Objeto do tipo Pedido contendo os dados caso sejam encontrados, ou null caso contrário)
     */
    public Pedido consultarPedido(Autenticacao autenticacao, String query) throws Exception {

        Pedido infoPedido = new Pedido();
        Connection cn = null;
        // Tentativa de conexão com o banco de dados
        try {
            cn = abrirConexao(autenticacao);
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                infoPedido.setNumeroPedido(rs.getInt("numeroPedido"));
                infoPedido.setData(rs.getString("data"));
                infoPedido.setHora(rs.getString("hora"));
                infoPedido.setValor(rs.getFloat("value"));
                infoPedido.setFormaPagamento(rs.getString("formaPagamento"));
                infoPedido.setPedidoFinalizado(rs.getBoolean("pedidoFinalizado"));
            } else {
                infoPedido.setNumeroPedido(0);
            }
        } catch (Exception e) {
            throw new Exception();
        } finally {
            fecharConexao(cn);
            return infoPedido;
        }
    }

    
    /*
     Descrição: Método para consulta do valor total de um pedido
     Parâmetros:
     *           autenticacao (Necessário para acesso ao banco de dados)
     *           query (String SQL)
     Retorno:
     *           valor (Valor total dos itens referentes ao pedido)
     */
    /*
    public float consultarValorDoPedido(Autenticacao autenticacao, String query) throws Exception {
        float valor = 0;
        Connection cn = null;
        try {
            cn = abrirConexao(autenticacao);
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                valor += rs.getInt("qtdadeProdutos") * rs.getFloat("preco");
            }
            
        } catch (Exception e) {
            throw new Exception();
        } finally {
            fecharConexao(cn);
        }
        return valor;
    }
    */
    
    /*
     Descrição: Método para consulta das informações das pizzas
     Parâmetros:
     *           autenticacao (Necessário para acesso ao banco de dados)
     Retorno:
     *           pizzas (ArrayList com todas as pizzas cadastradas)
     */
    public ArrayList consultarInfoPizzas(Autenticacao autenticacao) throws Exception {
        ArrayList<Pizza> pizzas = new ArrayList();
        Connection cn = null;
        try {
            cn = abrirConexao(autenticacao);
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM Produto AS P JOIN Pizza as PZ ON P.codigo = PZ.codProduto GROUP BY P.descricao");
            while (rs.next()) {
                Pizza pizza = new Pizza();
                pizza.setCodigo(rs.getInt("codigo"));
                pizza.setDescricao(rs.getString("descricao"));
                pizza.setPreco(rs.getFloat("preco"));
                pizza.setTamanho(rs.getString("tamanho"));
                pizza.setFatias(rs.getInt("fatias"));
                pizza.setIngredientesPizza(rs.getString("ingredientes"));
                pizzas.add(pizza);
            }
        } catch (Exception e) {
            throw new Exception();
        } finally {
            fecharConexao(cn);
        }
        return pizzas;
    }

    /*
     Descrição: Método para cancelar de um pedido.
     Parâmetros:
     *           autenticacao (Necessário para acesso ao banco de dados)
     *           infoPedido (Objeto contendo o pedido a ser cancelado)
     Retorno:
     */
    public void cancelarPedido(Autenticacao autenticacao, Pedido infoPedido) throws Exception {
        Connection cn = null;
        try {
            cn = abrirConexao(autenticacao);
            Statement st = cn.createStatement();
            st.executeUpdate("UPDATE Pedido SET pedidoFinalizado = TRUE, horaFim = current_time WHERE numeroPedido = " + infoPedido.getNumeroPedido() + " AND pedidoFinalizado = FALSE");
        } catch (Exception e) {
            throw new Exception();
        } finally {
            fecharConexao(cn);
        }
    }

    /*
     Descrição: Método para finalização de um pedido.
     Parâmetros:
     *           autenticacao (Necessário para acesso ao banco de dados)
     *           infoPedido (Objeto contendo o pedido a ser finalizado)
     Retorno:
     
    public void finalizarPedido(Autenticacao autenticacao, Pedido infoPedido) throws Exception {
        Connection cn = null;
        try {
            cn = abrirConexao(autenticacao);
            Statement st = cn.createStatement();
            st.executeUpdate("UPDATE Pedido SET pedidoFinalizado = TRUE, horaFim = current_time, formaPagamento = '" + infoPedido.getFormaPagamento() + "' WHERE numeroPedido = " + infoPedido.getNumeroPedido() + " AND pedidoFinalizado = FALSE");
        } catch (Exception e) {
            throw new Exception();
        } finally {
            fecharConexao(cn);
        }
    }
    */

    /*
     Descrição: Método para realização de operações genéricas no banco de dados
     Parâmetros:
     *           autenticacao (Necessário para acesso ao banco de dados)
     *           query (String SQL)
     Retorno:
     */
    public void executarSQL(Autenticacao autenticacao, String query) throws Exception {

        // Tentativa de conexão com o banco de dados
        Connection cn = null;
        try {
            cn = abrirConexao(autenticacao);
            Statement st = cn.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            throw new Exception();
        } finally {
            fecharConexao(cn);
        }
    }

    /*
     Descrição: Método de atualização da quantidade de determinado produto que já estava no pedido.
     *           Esse método realiza o UPDATE na tabela ItensDoPedido caso o mesmo produto seja selecionado
     *           em tempos diferentes.
     Parâmetros:
     *           autenticacao (Necessário para acesso ao banco de dados)
     *           query (String SQL do update no banco de dados)
     Retorno:
     */
    public void atualizarProdutoNoPedido(Autenticacao autenticacao, String query) throws Exception {
        Connection cn = null;
        try {
            cn = abrirConexao(autenticacao);
            PreparedStatement pst = cn.prepareStatement(query);
            pst.executeUpdate();
        } catch (Exception e) {
            throw new Exception();
        } finally {
            fecharConexao(cn);
        }
    }

    /*
     Descrição: Método para verificação de um mesmo produto no pedido.
     *           Esse método procura por repetições do mesmo produto nos itens do pedido.
     *           É necessário caso o mesmo produto seja incluso no mesmo pedido em tempos diferentes.
     Parâmetros:
     *           autenticacao (Necessário para acesso ao banco de dados)
     *           codigoPedido (Código do pedido atual)
     *           codigoProduto (Código do produto a ser pesquisado)
     Retorno:
     *           resultado (verdadeiro caso o item seja encontrado, falso caso contrário)
     */
    public boolean verificarProdutoNoPedido(Autenticacao autenticacao, int codigoPedido, int codigoProduto) throws Exception {

        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        boolean resultado = false;
        try {
            cn = abrirConexao(autenticacao);
            pst = cn.prepareStatement("SELECT IDP.qtdadeProdutos FROM ItemDoPedido AS IDP JOIN Pedido AS P ON IDP.pedidoNumero = P.numeroPedido WHERE IDP.pedidoNumero = ? AND IDP.codigoProduto = ? AND P.pedidoFinalizado = false");
            pst.setInt(1, codigoPedido);
            pst.setInt(2, codigoProduto);
            rs = pst.executeQuery();
            resultado = rs.next();
        } catch (Exception e) {
            throw new Exception();
        } finally {
            fecharConexao(cn);
        }
        return resultado;
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
