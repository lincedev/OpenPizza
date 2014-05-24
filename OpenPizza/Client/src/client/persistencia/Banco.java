package client.persistencia;

import java.sql.*;
import client.modelo.*;
import java.util.*;

/*
 Descrição: Classe de persistência com o banco de dados
 */
public class Banco {

    /*
     Descrição: Método para realização de consulta no banco de dados
     Parâmetros:
     *           autenticacao (Necessário para acesso ao banco de dados)
     *           query (String SQL)
     Retorno:
     *           infoPedido (Objeto do tipo Pedido contendo os dados caso sejam encontrados, ou null caso contrário)
     */
    public Pedido consultarPedidos(Autenticacao autenticacao, String query) throws Exception {

        Pedido infoPedido = new Pedido();
        Connection cn = null;
        // Tentativa de conexão com o banco de dados
        try {
            cn = DriverManager.getConnection(autenticacao.getCaminhoBanco(), autenticacao.getUsuarioBanco(), autenticacao.getUsuarioSenha());
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            if (rs.next()) {
                infoPedido.setNumeroPedido(rs.getInt("numeroPedido"));
                infoPedido.setData(rs.getString("data"));
                infoPedido.setHora(rs.getString("hora"));
                infoPedido.setValor(rs.getFloat("valor"));
                infoPedido.setFormaPagamento(rs.getString("formaPagamento"));
                infoPedido.setPedidoFinalizado(rs.getBoolean("pedidoFinalizado"));
            } else {
                infoPedido.setNumeroPedido(0);
            }
        } catch (Exception e) {
            throw new Exception();
        } finally {
            cn.close();
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
            cn = DriverManager.getConnection(autenticacao.getCaminhoBanco(), autenticacao.getUsuarioBanco(), autenticacao.getUsuarioSenha());
            Statement st = cn.createStatement();
            ResultSet rs = st.executeQuery(query);
            while (rs.next()) {
                valor += rs.getInt("qtdadeProdutos") * rs.getFloat("preco");
            }
            return valor;
        } catch (Exception e) {
            throw new Exception();
        } finally {
            cn.close();
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
            cn = DriverManager.getConnection(autenticacao.getCaminhoBanco(), autenticacao.getUsuarioBanco(), autenticacao.getUsuarioSenha());
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
            cn.close();
            return pizzas;
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
            cn = DriverManager.getConnection(autenticacao.getCaminhoBanco(), autenticacao.getUsuarioBanco(), autenticacao.getUsuarioSenha());
            Statement st = cn.createStatement();
            st.executeUpdate("UPDATE Pedido SET pedidoFinalizado = TRUE, horaFim = current_time WHERE numeroPedido = " + infoPedido.getNumeroPedido());
        } catch (Exception e) {
            throw new Exception();
        } finally {
            cn.close();
        }
    }

    /*
     Descrição: Método para realização de inserção no banco de dados
     Parâmetros:
     *           autenticacao (Necessário para acesso ao banco de dados)
     *           query (String SQL)
     Retorno:
     */
    public void efetuarInsercao(Autenticacao autenticacao, String query) throws Exception {

        Connection cn = null;
        try {
            cn = DriverManager.getConnection(autenticacao.getCaminhoBanco(), autenticacao.getUsuarioBanco(), autenticacao.getUsuarioSenha());
            Statement st = cn.createStatement();
            st.executeUpdate(query);
        } catch (Exception e) {
            throw new Exception();
        } finally {
            cn.close();
        }
    }
}
