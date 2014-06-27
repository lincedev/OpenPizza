package client.persistencia;

import java.sql.*;
import client.modelo.*;
import java.util.*;

/*
 Descrição: Classe de persistência com o banco de dados
 */
public class Banco {

    /*
     Descrição: Método para abertura de conexão com o banco de dados
     Parâmetros:
     *           autenticacao (Necessário para acesso ao banco de dados)
     Retorno:
     *           cn (Conexão com o banco de dados)
     */
    public Connection abrirConexao(Autenticacao autenticacao) throws Exception {
        try {
            Connection cn = DriverManager.getConnection(autenticacao.getCaminhoBanco(), autenticacao.getUsuarioBanco(), autenticacao.getUsuarioSenha());
            return cn;
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
            fecharConexao(cn);
            return valor;
        } catch (Exception e) {
            throw new Exception();
        } finally {
            fecharConexao(cn);
        }
    }

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
            return pizzas;
        }
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
     */
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
}
