// Pacote Persistência
package server.persistencia;

// Importação dos pacotes e bibliotecas necessárias
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;
import server.modelo.Autenticacao;
import server.modelo.Bebidas;
import server.modelo.Lanche;
import server.modelo.Outros;
import server.modelo.Pizza;

/*
 Descrição: Classe de persistência com o banco de dados
 */
public class Banco {

    /*
     Descrição: Método para verificação do status da conexão.
     Parâmetros:
     autenticacao (Objeto com as informações para acesso ao banco de dados)
     Retorno:
     true, caso a conexão seja efetuada com sucesso; false, caso contrário;
     */
    public boolean verificarConexao(Autenticacao autenticacao) {
        Connection conexao = null;
        boolean verificarConexao = false;
        try {
            conexao = this.abrirConexao(autenticacao);
            if(conexao.isValid(1)){
                verificarConexao = true;
            }
        } catch (Exception e) {
           
        }
        finally{
            try{
                this.fecharConexao(conexao);
            }
            catch(Exception e){
                
            }
        }
        return verificarConexao;
    }
    
    /*
     Descrição: Método para tentativa de consulta dos pedidos em aberto no banco de dados
     Parâmetros:
     autenticacao (Objeto do tipo Autenticacao contendo as informações para acesso ao banco de dados)
     tabelaPedidosEmAberto (JTable que será preenchida com os pedidos)
     Retorno:
     */
    public void exibirPedidosEmAberto(Autenticacao autenticacao, JTable tabelaPedidosEmAberto) {
        Connection conexao = null;
        try {

            String query = "SELECT * FROM Pedido WHERE pedidoFinalizado = false";
            conexao = this.abrirConexao(autenticacao);
            Statement homologacao = conexao.createStatement();
            ResultSet resultado = homologacao.executeQuery(query);
            tabelaPedidosEmAberto.setModel(DbUtils.resultSetToTableModel(resultado));
        } catch (Exception e) {
            
        } finally {
            try {
                this.fecharConexao(conexao);
            } catch (Exception e) {

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
                query = "SELECT P.descricao AS 'Descrição' FROM Produto AS P JOIN Pizza AS PZ ON P.codigo = PZ.codProduto WHERE P.ativo = true GROUP BY P.descricao ORDER BY P.descricao";
            } else if (categoriaDoProduto.equals("Lanche")) {
                query = "SELECT P.descricao AS 'Descrição' FROM Produto AS P JOIN Lanche AS L ON P.codigo = L.codProduto WHERE P.ativo = true GROUP BY P.descricao ORDER BY P.descricao";
            } else if (categoriaDoProduto.equals("Bebida")) {
                query = "SELECT P.descricao AS 'Descrição' FROM Produto AS P JOIN Bebidas AS B ON P.codigo = B.codProduto WHERE P.ativo = true GROUP BY P.descricao ORDER BY P.descricao";
            } else {
                query = "SELECT P.descricao AS 'Descrição' FROM Produto AS P JOIN Outros AS O ON P.codigo = O.codProduto WHERE P.ativo = true GROUP BY P.descricao ORDER BY P.descricao";
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

    /*
     Descrição: Método para exibição dos produtos nas telas de CRUD
     Parâmetros:
     autenticacao (Objeto do tipo Autenticacao contendo as informações para acesso ao banco de dados)
    tabelaProdutos (JTable que será preenchida com os produtos disponíveis)
     categoriaDoProduto (String contendo a categoria do produto (Pizza, Lanche, Bebida, Outro)
     Retorno:
     */
    public void exibirProdutos(Autenticacao autenticacao, JTable tabelaProdutos, String categoriaDoProduto) {
        Connection conexao = null;
        try {
            String query;
            if (categoriaDoProduto.equals("Pizza")) {
                query = "SELECT p.codigo AS 'Código', p.descricao AS 'Descrição', pp.preco AS 'Preço', pp.tamanho AS 'Tamanho' , pp.fatias AS 'Fatias' FROM Produto AS p JOIN Pizza AS pp ON p.codigo = pp.codProduto WHERE p.ativo = true";
            } else if (categoriaDoProduto.equals("Lanche")) {
                query = "SELECT p.codigo AS 'Código', p.descricao AS 'Descrição', l.preco AS 'Preço' FROM Produto AS p JOIN Lanche AS l ON p.codigo = l.codProduto WHERE p.ativo = true";
            } else if (categoriaDoProduto.equals("Bebida")) {
                query = "SELECT p.codigo AS 'Código', p.descricao AS 'Descrição', b.preco AS 'Preço' FROM Produto AS p JOIN Bebidas AS b ON p.codigo = b.codProduto WHERE p.ativo = true";
            } else if (categoriaDoProduto.equals("Outro")) {
                query = "SELECT p.codigo AS 'Código', p.descricao AS 'Descrição', o.preco AS 'Preço' FROM Produto AS p JOIN Outros AS o ON p.codigo = o.codProduto WHERE p.ativo = true";
            } else {
                query = "SELECT numero AS 'Número', ativo AS 'Ativo' FROM Mesa WHERE ativo = true";
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
                    textoIngredientes.setText(resultado.getString("ingredientesLanche"));
                }
            }
        } catch (Exception e) {

        }
    }

    /*
     Descrição: Método para tentativa de inserção de produto no banco de dados
     Parâmetros:
     autenticacao (Objeto do tipo Autenticacao contendo as informações para acesso ao banco de dados)
     produto (Objeto a ser inserido no banco de dados)
     Retorno:
     true, caso o produto seja inserido; false, caso contrário
     */
    public boolean inserirProduto(Autenticacao autenticacao, Object produto) {
        Connection conexao = null;
        boolean inserirProduto = false;
        try {
            String query;
            int codigoDoProduto;
            if (produto instanceof Pizza) {
                Pizza novaPizza = (Pizza) produto;
                query = "INSERT INTO Produto(descricao, ativo) VALUES('" + novaPizza.getDescricao() + "', true)";
            } else if (produto instanceof Lanche) {
                Lanche novoLanche = (Lanche) produto;
                query = "INSERT INTO Produto(descricao, ativo) VALUES('" + novoLanche.getDescricao() + "', true)";
            } else if (produto instanceof Bebidas) {
                Bebidas novaBebida = (Bebidas) produto;
                query = "INSERT INTO Produto(descricao, ativo) VALUES('" + novaBebida.getDescricao() + "', true)";
            } else {
                Outros novoOutro = (Outros) produto;
                query = "INSERT INTO Produto(descricao, ativo) VALUES('" + novoOutro.getDescricao() + "', true)";
            }
            conexao = this.abrirConexao(autenticacao);
            Statement homologacao = conexao.createStatement();
            homologacao.executeUpdate(query);
            codigoDoProduto = this.consultarCodigoDoProduto(autenticacao);
            this.inserirProdutoEspecifico(autenticacao, produto, codigoDoProduto);
            inserirProduto = true;
        } catch (Exception e) {

        } finally {
            try {
                this.fecharConexao(conexao);
            } catch (Exception e) {

            }
        }
        return inserirProduto;
    }

    /*
     Descrição: Método para tentativa de consulta do último registro de produto inserido.
     Necessário para a inserção de chave estrangeira.
     Parâmetros:
     autenticacao (Objeto do tipo Autenticacao contendo as informações para acesso ao banco de dados)
     Retorno:
     codigoDoProduto (Inteiro contendo o valor do último código de produto do banco de dados)
     */
    public int consultarCodigoDoProduto(Autenticacao autenticacao) {
        Connection conexao = null;
        int codigoDoProduto = -1;
        try {
            String query = "SELECT codigo FROM Produto ORDER BY codigo DESC LIMIT 1";
            conexao = this.abrirConexao(autenticacao);
            Statement homologacao = conexao.createStatement();
            ResultSet resultado = homologacao.executeQuery(query);
            if (resultado.next()) {
                codigoDoProduto = resultado.getInt("codigo");
            }
        } catch (Exception e) {

        } finally {
            try {
                this.fecharConexao(conexao);
            } catch (Exception e) {

            }
        }
        return codigoDoProduto;

    }

    /*
     Descrição: Método para tentativa de inserção de informações específicas de um produto
     Parâmetros:
     autenticacao (Objeto do tipo Autenticacao contendo as informações para acesso ao banco de dados)
     produto (Objeto a ser inserido no banco de dados)
     codigoDoProduto (Inteiro contendo o código do último produto cadastrado)
     Retorno:
     */
    public void inserirProdutoEspecifico(Autenticacao autenticacao, Object produto, int codigoDoProduto) {
        Connection conexao = null;
        try {
            String query;
            if (produto instanceof Pizza) {
                Pizza novaPizza = (Pizza) produto;
                query = "INSERT INTO Pizza(codProduto, preco, tamanho, fatias, ingredientes, imagem) VALUES(?, ?, ?, ?, ?, ?)";
                conexao = this.abrirConexao(autenticacao);
                PreparedStatement homologacao = conexao.prepareStatement(query);
                homologacao.setInt(1, codigoDoProduto);
                homologacao.setFloat(2, novaPizza.getPreco());
                homologacao.setString(3, novaPizza.getTamanho());
                homologacao.setInt(4, novaPizza.getFatias());
                homologacao.setString(5, novaPizza.getIngredientesPizza());
                homologacao.setBlob(6, novaPizza.getImagemPizza());
                homologacao.executeUpdate();
            } else {
                if (produto instanceof Lanche) {
                    Lanche novoLanche = (Lanche) produto;
                    query = "INSERT INTO Lanche(codProduto, preco, ingredientesLanche) VALUES(" + codigoDoProduto + ", " + novoLanche.getPreco() + ", '" + novoLanche.getIngredientesLanche() + "')";
                } else if (produto instanceof Bebidas) {
                    Bebidas novaBebida = (Bebidas) produto;
                    query = "INSERT INTO Bebidas(codProduto, preco, quantidade) VALUES(" + codigoDoProduto + ", " + novaBebida.getPreco() + ", " + novaBebida.getQuantidade() + ")";
                } else {
                    Outros novoOutro = (Outros) produto;
                    query = "INSERT INTO Outros(codProduto, preco, quantidade) VALUES(" + codigoDoProduto + ", " + novoOutro.getPreco() + ", " + novoOutro.getQuantidade() + ")";
                }
                conexao = this.abrirConexao(autenticacao);
                Statement homologacao = conexao.createStatement();
                homologacao.executeUpdate(query);
            }
        } catch (Exception e) {

        } finally {
            try {
                this.fecharConexao(conexao);
            } catch (Exception e) {

            }
        }
    }

    /*
     Descrição: Método para abertura de conexão com o banco de dados
     Parâmetros:
     *           autenticacao (Necessário para acesso ao banco de dados)
     Retorno:
     *           conexao (Conexão com o banco de dados)
     */
    public Connection abrirConexao(Autenticacao autenticacao) {
        Connection conexao = null;
        try {
            conexao = DriverManager.getConnection(autenticacao.getCaminhoBanco(), autenticacao.getUsuarioBanco(), autenticacao.getUsuarioSenha());
            return conexao;
        } catch (Exception e) {
            return conexao;
        }
    }

    /*
     Descrição: Método para finalização de conexão com o banco de dados.
     Parâmetros:
     conexao (Conexão que será fechada)
     Retorno:
     */
    public void fecharConexao(Connection conexao) {
        try {
            conexao.close();
        } catch (Exception e) {

        }
    }

    /*
     Descrição: Método para exclusão (desativação) de um produto no banco de dados
     Parâmetros:
     autenticacao (Objeto do tipo Autenticação contendo informações para acesso ao banco de dados)
     codigoDoProduto (Inteiro contendo o código do produto que será desativado)
     Retorno:
     desativarProduto (true, caso os valores sejam válidos; false, caso contrário)
     */
    public boolean desativarProduto(Autenticacao autenticacao, int codigoDoProduto) {
        Connection conexao = null;
        boolean desativarProduto = false;
        try {
            String query = "UPDATE Produto SET ativo = 0 WHERE codigo = " + codigoDoProduto;
            conexao = this.abrirConexao(autenticacao);
            Statement homologacao = conexao.createStatement();
            homologacao.executeUpdate(query);
            desativarProduto = true;
        } catch (Exception e) {

        } finally {
            try {
                this.fecharConexao(conexao);
            } catch (Exception e) {

            }
        }
        return desativarProduto;
    }

    /*
     Descrição: Método para inserção de uma nova Mesa
     Parâmetros:
     autenticacao (Objeto do tipo Autenticação contendo informações para acesso ao banco de dados)
     Retorno:
     inserirMesa (true, caso os valores sejam válidos; false, caso contrário)
     */
    public boolean inserirMesa(Autenticacao autenticacao) {
        Connection conexao = null;
        boolean inserirMesa = false;
        try {
            String query = "INSERT INTO Mesa(ativo) VALUES(1)";
            conexao = this.abrirConexao(autenticacao);
            Statement homologacao = conexao.createStatement();
            homologacao.executeUpdate(query);
            inserirMesa = true;
        } catch (Exception e) {

        } finally {
            try {
                this.fecharConexao(conexao);
            } catch (Exception e) {

            }
        }
        return inserirMesa;
    }

    /*
     Descrição: Método para excluir (desativar) uma Mesa
     Parâmetros:
     autenticacao (Objeto do tipo Autenticação contendo informações para acesso ao banco de dados)
     numeroDaMesa (Inteiro contendo o número da mesa que será desativada)
     Retorno:
     desativarMesa (true, caso os valores sejam válidos; false, caso contrário)
     */
    public boolean desativarMesa(Autenticacao autenticacao, int numeroDaMesa) {
        Connection conexao = null;
        boolean desativarMesa = false;
        try {
            String query = "UPDATE Mesa SET ativo = false WHERE numero = " + numeroDaMesa;
            conexao = this.abrirConexao(autenticacao);
            Statement homologacao = conexao.createStatement();
            homologacao.executeUpdate(query);
            desativarMesa = true;
        } catch (Exception e) {

        } finally {
            try {
                this.fecharConexao(conexao);
            } catch (Exception e) {

            }
        }
        return desativarMesa;
    }

    /*
     Descrição: Método para geração de relatórios dos itens em estoque
     Parâmetros:
     autenticacao (Objeto do tipo Autenticação contendo informações para acesso ao banco de dados)
     tipoProduto (String contendo o tipo de relatório que será gerado)
     Retorno:
     */
    public void gerarRelatorio(Autenticacao autenticacao, String tipoProduto) {
        String query;
        String caminho;
        ResultSet rs = null;
        Connection conexao = null;

        if (tipoProduto.equals("Bebida")) {
            try {
                query = "SELECT p.descricao AS DESCRICAO, bbd.quantidade AS QUANTIDADE FROM Produto AS p INNER JOIN Bebidas AS bbd ON (p.codigo = bbd.codProduto) GROUP BY p.descricao;";
                caminho = "src/server/view/RelatorioBebidaServer.jasper";
                conexao = this.abrirConexao(autenticacao);
                Statement homologacao = conexao.createStatement();
                rs = homologacao.executeQuery(query);
                JRResultSetDataSource relatResult = new JRResultSetDataSource(rs);
                JasperPrint jpPrint = JasperFillManager.fillReport(caminho, new HashMap(), relatResult);
                JasperViewer jv = new JasperViewer(jpPrint, false);
                jv.setTitle("OpenPizza - Relatório");
                jv.setVisible(true);
                jv.toFront();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Não foi possível exibir relatório.");
            } finally {
                try {
                    this.fecharConexao(conexao);
                } catch (Exception e) {

                }
            }
        } else {
            try {
                query = "SELECT p.descricao AS DESCRICAO, ots.quantidade AS QUANTIDADE FROM  Produto AS p INNER JOIN Outros AS ots ON (p.codigo = ots.codProduto) GROUP BY p.descricao;";
                caminho = "src/server/view/RelatorioOutrosServer.jasper";
                conexao = this.abrirConexao(autenticacao);
                Statement homologacao = conexao.createStatement();
                rs = homologacao.executeQuery(query);
                JRResultSetDataSource relatResult = new JRResultSetDataSource(rs);
                JasperPrint jpPrint = JasperFillManager.fillReport(caminho, new HashMap(), relatResult);
                JasperViewer jv = new JasperViewer(jpPrint, false);
                jv.setTitle("OpenPizza - Relatório");
                jv.setVisible(true);
                jv.toFront();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Não foi possível exibir relatório.");
            } finally {
                try {
                    this.fecharConexao(conexao);
                } catch (Exception e) {

                }
            }
        }
    }
}
