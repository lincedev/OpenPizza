// Pacote Persistência
package client.persistence;

// Importação dos pacotes e bibliotecas necessárias
import client.model.Autenticacao;
import java.awt.Image;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
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
                autenticacao (Necessário para acesso ao banco de dados)
     Retorno:
                conexao (Conexão com o banco de dados)
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
                conexao (Conexão que será fechada)
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
    public boolean verificarConexao(Autenticacao autenticacao) {
        try {
            Connection conexao = this.abrirConexao(autenticacao);
            this.fecharConexao(conexao);
            return true;
        } catch (Exception e) {
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
    public ArrayList consultarMesas(Autenticacao autenticacao) {
        Connection conexao = null;
        ArrayList<Integer> mesas = new ArrayList<>();
        try {
            conexao = this.abrirConexao(autenticacao);
            String query = "SELECT * FROM Mesa";
            PreparedStatement statement = conexao.prepareStatement(query);
            ResultSet resultado = statement.executeQuery();
            while (resultado.next()) {
                mesas.add(resultado.getInt("numero"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                this.fecharConexao(conexao);
            } catch (Exception e) {

            }
            return mesas;
        }
    }

    /*
     Descrição: Método para consulta do número do pedido
     Parâmetros:
     numeroDaMesa (Inteiro contendo o número da mesa selecionado na Tela de Pedido)
     autenticacao (Objeto do tipo Autenticacao contendo as informações para acesso ao banco de dados)
     Retorno:
     numeroDoPedido (Inteiro contendo o número do pedido; -1 caso o pedido não exista)
     */
    public int consultarNumeroDoPedido(int numeroDaMesa, Autenticacao autenticacao) {
        int numeroDoPedido = -1;
        Connection conexao = null;
        try {
            String query = "SELECT numeroPedido FROM Pedido AS P JOIN Mesa AS M ON P.numeroMesa = M.numero WHERE M.numero = " + numeroDaMesa + " AND P.pedidoFinalizado = false";
            conexao = this.abrirConexao(autenticacao);
            Statement homologacao = conexao.createStatement();
            ResultSet resultado = homologacao.executeQuery(query);
            if (resultado.next()) {
                numeroDoPedido = resultado.getInt("numeroPedido");
            }
        } catch (Exception e) {

        } finally {
            try {
                this.fecharConexao(conexao);
            } catch (Exception e) {

            }
        }
        return numeroDoPedido;
    }

    /*
     Descrição: Método para consulta dos itens referentes à um determinado pedido
     Parâmetros:
     tabelaItensDoPedido (JTable que será preenchida com os itens relacionados à um pedido)
     numeroDoPedido (Inteiro contendo o número do pedido selecionado na Tela de Pedido)
     autenticacao (Objeto do tipo Autenticacao contendo as informações para acesso ao banco de dados)
     Retorno:
     */
    public void consultarItensDoPedido(JTable tabelaItensDoPedido, int numeroDoPedido, Autenticacao autenticacao) {
        Connection conexao = null;
        try {
            String query = "SELECT P.descricao, IDP.tamanho, IDP.qtdadeProdutos, IDP.preco FROM Produto AS P JOIN ItemDoPedido AS IDP ON P.codigo = IDP.codigoProduto WHERE IDP.pedidoNumero = " + numeroDoPedido;
            conexao = this.abrirConexao(autenticacao);
            Statement homologacao = conexao.createStatement();
            ResultSet resultado = homologacao.executeQuery(query);
            tabelaItensDoPedido.setModel(DbUtils.resultSetToTableModel(resultado));
            this.fecharConexao(conexao);
        } catch (Exception e) {

        } finally {
            try {
                this.fecharConexao(conexao);
            } catch (Exception e) {

            }
        }
    }

    /*
     Descrição: Método para consulta do valor de um determinado pedido
     Parâmetros:
     numeroDoPedido (Inteiro contendo o número do pedido selecionado na Tela de Pedido)
     autenticacao (Objeto do tipo Autenticacao contendo as informações para acesso ao banco de dados)
     Retorno:
     valorDoPedido (Float contendo o valor do pedido; -1 caso o pedido não exista)
     */
    public float consultarValorDoPedido(int numeroDoPedido, Autenticacao autenticacao) {
        float valorDoPedido = -1;
        Connection conexao = null;
        try {
            String query = "SELECT SUM(qtdadeProdutos * preco) FROM ItemDoPedido WHERE pedidoNumero = " + numeroDoPedido;
            conexao = this.abrirConexao(autenticacao);
            Statement homologacao = conexao.createStatement();
            ResultSet resultado = homologacao.executeQuery(query);
            if (resultado.next()) {
                valorDoPedido = resultado.getFloat("SUM(qtdadeProdutos * preco)");
            }
        } catch (Exception e) {
            valorDoPedido = -1;
        } finally {
            try {
                this.fecharConexao(conexao);
            } catch (Exception e) {

            }
        }
        return valorDoPedido;
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

    /*
     Descrição: Método para inserção de um novo registro de pedido
     Parâmetros:
     numeroDaMesa (Inteiro contendo o número da mesa selecionada na Tela de Pedido)
     autenticacao (Objeto do tipo Autenticacao contendo as informações para acesso ao banco de dados)
     Retorno:
     true, caso o pedido seja inserido com sucesso; false, caso contrário
     */
    public boolean inserirPedido(int numeroDaMesa, Autenticacao autenticacao) {
        Connection conexao = null;
        try {
            String query = "INSERT INTO Pedido(data, horaInicio, valor, formaPagamento, numeroMesa, pedidoFinalizado) VALUES(current_date, current_time, 0.0, null," + numeroDaMesa + ", false)";
            conexao = this.abrirConexao(autenticacao);
            Statement homologacao = conexao.createStatement();
            homologacao.executeUpdate(query);
            this.fecharConexao(conexao);
            return true;
        } catch (Exception e) {
            try {
                this.fecharConexao(conexao);
            } catch (Exception e2) {

            }
            return false;
        }
    }

    /*
     Descrição: Método para consulta das opções específicas de um determinado produto (Tamanho, Fatias, etc)
     Parâmetros:
     tabelaOpcoesDisponíveis (JTable que será preenchida com as opções específicas de um produto)
     autenticacao (Objeto do tipo Autenticacao contendo as informações para acesso ao banco de dados)
     categoriaDoProduto (String contendo a categoria do produto (Pizza, Lanche, Bebida, Outro)
     nomeDoProduto (String contendo o nome do produto selecionado na Tela de Cardápio)
     Retorno:
     */
    public void consultarOpcoesDoProduto(JTable tabelaOpcoesDisponiveis, Autenticacao autenticacao, String categoriaDoProduto, String nomeDoProduto) {
        Connection conexao = null;
        try {
            String query;
            if (categoriaDoProduto.equals("Pizza")) {
                query = "SELECT P.codigo, PZ.tamanho, PZ.fatias, PZ.preco FROM Pizza AS PZ JOIN Produto AS P ON PZ.codProduto = P.codigo WHERE P.ativo = true AND P.descricao LIKE '" + nomeDoProduto + "' ORDER BY P.descricao";

            } else if (categoriaDoProduto.equals("Lanche")) {
                query = "SELECT P.codigo, P.descricao, L.preco FROM Produto AS P JOIN Lanche AS L ON P.codigo = L.codProduto WHERE P.ativo = true AND P.descricao LIKE '" + nomeDoProduto + "' ORDER BY P.descricao";
            } else if (categoriaDoProduto.equals("Bebida")) {
                query = "SELECT P.codigo, P.descricao, B.preco, B.quantidade FROM Produto AS P JOIN Bebidas AS B ON P.codigo = B.codProduto WHERE P.ativo = true AND P.descricao LIKE '" + nomeDoProduto + "' ORDER BY P.descricao";
            } else {
                query = "SELECT P.codigo, P.descricao, O.preco, O.quantidade FROM Produto AS P JOIN Outros AS O ON P.codigo = O.codProduto WHERE P.ativo = true AND P.descricao LIKE '" + nomeDoProduto + "' ORDER BY P.descricao";
            }
            conexao = this.abrirConexao(autenticacao);
            Statement homologacao = conexao.createStatement();
            ResultSet resultado = homologacao.executeQuery(query);
            tabelaOpcoesDisponiveis.setModel(DbUtils.resultSetToTableModel(resultado));
            this.fecharConexao(conexao);
        } catch (Exception e) {

        } finally {
            try {
                this.fecharConexao(conexao);
            } catch (Exception e) {

            }
        }
    }

    /*
     Descrição: Método para consulta de um determinado produto em um determinado pedido
     Parâmetros:
     autenticacao (Objeto do tipo Autenticacao contendo as informações para acesso ao banco de dados)
     numeroDoPedido (Inteiro contendo o número do pedido selecionado na Tela de Pedido)
     codigoDoProduto (Inteiro contendo o número do código do produto selecionado na Tela de Cardápio)
     Retorno:
     produtoEncontrado (true, caso o produto seja encontrado; false, caso contrário)
     */
    public boolean consultarProdutoNoPedido(Autenticacao autenticacao, int numeroDoPedido, int codigoDoProduto) {
        boolean produtoEncontrado = false;
        Connection conexao = null;
        try {
            String query = "SELECT IDP.qtdadeProdutos FROM ItemDoPedido AS IDP JOIN Pedido AS P ON IDP.pedidoNumero = P.numeroPedido WHERE IDP.pedidoNumero = " + numeroDoPedido + " AND IDP.codigoProduto = " + codigoDoProduto + " AND P.pedidoFinalizado = false";
            conexao = this.abrirConexao(autenticacao);
            Statement homologacao = conexao.createStatement();
            ResultSet resultado = homologacao.executeQuery(query);
            if (resultado.next()) {
                this.fecharConexao(conexao);
                produtoEncontrado = true;
            } else {
                this.fecharConexao(conexao);
                produtoEncontrado = false;
            }
        } catch (Exception e) {

        } finally {
            try {
                this.fecharConexao(conexao);
            } catch (Exception e) {

            }
        }
        return produtoEncontrado;
    }

    /*
     Descrição: Método para inserção de um produto em um determinado pedido
     Parâmetros:
     autenticacao (Objeto do tipo Autenticacao contendo as informações para acesso ao banco de dados)
     numeroDoPedido (Inteiro contendo o número do pedido selecionado na Tela de Pedido)
     codigoDoProduto (Inteiro contendo o código do produto selecionado na Tela de Inclusão de Produtos)
     quantidade (Inteiro contendo a quantidade desejada)
     tamanho (String contendo o tamanho do produto, no caso das pizzas)
     preco (Float contendo o valor do produto selecionado)
     Retorno:
     */
    public boolean inserirProduto(Autenticacao autenticacao, int numeroDoPedido, int codigoDoProduto, int quantidade, String tamanho, float preco) {
        Connection conexao = null;
        try {
            String query = "INSERT INTO ItemDoPedido(pedidoNumero, codigoProduto, qtdadeProdutos, tamanho, preco) VALUES(" + numeroDoPedido + "," + codigoDoProduto + "," + quantidade + ",'" + tamanho + "'," + preco + ")";
            conexao = this.abrirConexao(autenticacao);
            Statement homologacao = conexao.createStatement();
            homologacao.executeUpdate(query);
            this.fecharConexao(conexao);
            return true;
        } catch (Exception e) {
            try {
                this.fecharConexao(conexao);
            } catch (Exception e2) {

            }
            return false;
        }
    }

    /*
     Descrição: Método para atualização da quantidade de um produto em um determinado pedido
     Parâmetros:
     autenticacao (Objeto do tipo Autenticacao contendo as informações para acesso ao banco de dados)
     numeroDoPedido (Inteiro contendo o número do pedido selecionado na Tela de Pedido)
     categoriaDoProduto (String contendo a categoria do produto (Pizza, Lanche, Bebida, Outro)
     codigoDoProduto (Inteiro contendo o código do produto selecionado na Tela de Inclusão de Produtos)
     quantidade (Inteiro contendo a quantidade desejada)
     Retorno:
     true, caso a quantidade do produto seja alterada; false, caso contrário
     */
    public boolean atualizarQuantidadeDoProdutoNoPedido(Autenticacao autenticacao, int numeroDoPedido, String categoriaDoProduto, int codigoDoProduto, int quantidade) {
        Connection conexao = null;
        try {
            String query = "UPDATE ItemDoPedido SET qtdadeProdutos = qtdadeProdutos + " + quantidade + " WHERE pedidoNumero = " + numeroDoPedido + " AND codigoProduto = " + codigoDoProduto;
            conexao = this.abrirConexao(autenticacao);
            Statement homologacao = conexao.createStatement();
            homologacao.executeUpdate(query);
            this.fecharConexao(conexao);
            return true;
        } catch (Exception e) {
            try {
                this.fecharConexao(conexao);
            } catch (Exception e2) {

            }
            return false;
        }
    }

    /*
     Descrição: Método para cancelamento de um pedido. Um pedido pode ser cancelado quando não há itens inclusos no mesmo
     Parâmetros:
     autenticacao (Objeto do tipo Autenticacao contendo as informações para acesso ao banco de dados)
     numeroDoPedido (Inteiro contendo o número do pedido selecionado na Tela de Pedido)
     Retorno:
     true, caso o pedido seja cancelado; false, caso contrário
     */
    public boolean cancelarPedido(Autenticacao autenticacao, int numeroDoPedido) {
        Connection conexao = null;
        try {
            String query = "UPDATE Pedido SET pedidoFinalizado = TRUE, horaFim = current_time WHERE numeroPedido = " + numeroDoPedido + " AND pedidoFinalizado = FALSE";
            conexao = this.abrirConexao(autenticacao);
            Statement homologacao = conexao.createStatement();
            homologacao.executeUpdate(query);
            this.fecharConexao(conexao);
            return true;
        } catch (Exception e) {
            try {
                this.fecharConexao(conexao);
            } catch (Exception e2) {

            }
            return false;
        }
    }

    /*
     Descrição: Método para finalização de um pedido. Um pedido pode ser finalizado quando o mesmo contém, no mínimo, um item
     Parâmetros:
     autenticacao (Objeto do tipo Autenticacao contendo as informações para acesso ao banco de dados)
     numeroDoPedido (Inteiro contendo o número do pedido selecionado na Tela de Pedido)
     formaDePagamento (String contendo a forma de pagamento selecionada na Tela de Pedido)
     valor (Float contendo o valor total do pedido)
     Retorno:
     true, caso o pedido seja finalizado; false, caso contrário
     */
    public boolean finalizarPedido(Autenticacao autenticacao, int numeroDoPedido, String formaDePagamento, float valor) {
        Connection conexao = null;
        try {
            String query = "UPDATE Pedido SET valor = " + valor + ", pedidoFinalizado = TRUE, horaFim = current_time, formaPagamento = '" + formaDePagamento + "' WHERE numeroPedido = " + numeroDoPedido + " AND pedidoFinalizado = FALSE";
            conexao = this.abrirConexao(autenticacao);
            Statement homologacao = conexao.createStatement();
            homologacao.executeUpdate(query);
            this.fecharConexao(conexao);
            return true;
        } catch (Exception e) {
            try {
                this.fecharConexao(conexao);
            } catch (Exception e2) {

            }
            return false;
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
    public void consultarIngredientes(JTextArea textoIngredientes, Autenticacao autenticacao, String categoriaDoProduto, int codigoDoProduto) {
        Connection conexao = null;
        try {
            String query;
            if (categoriaDoProduto.equals("Pizza")) {
                query = "SELECT PZ.ingredientes FROM Pizza AS PZ JOIN Produto AS P ON PZ.codProduto = P.codigo WHERE P.codigo = " + codigoDoProduto;
            } else {
                query = "SELECT L.ingredientesLanche FROM Lanche AS L JOIN Produto AS P ON L.codProduto = P.codigo WHERE P.codigo = " + codigoDoProduto;
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

    /*
     Descrição: Método para consulta da imagem da pizza
     Parâmetros:
     foto (JLabel que será preenchida com a imagem da pizza)
     autenticacao (Objeto do tipo Autenticacao contendo as informações para acesso ao banco de dados)
     codigoDoProduto (Inteiro contendo o código do produto selecionado na Tela de Inclusão de Produtos)
     Retorno:
     */
    public void consultarImagemDaPizza(JLabel foto, Autenticacao autenticacao, int codigoDoProduto) {
        Connection conexao = null;
        try {
            String query = "SELECT imagem FROM Pizza WHERE codProduto = " + codigoDoProduto;
            conexao = this.abrirConexao(autenticacao);
            Statement homologacao = conexao.createStatement();
            ResultSet resultado = homologacao.executeQuery(query);
            if (resultado.next()) {
                String local = resultado.getString("imagem");
                ImageIcon icone = new ImageIcon(local);
                Image imagem = icone.getImage();
                foto.setIcon(new ImageIcon(imagem));
            }
            this.fecharConexao(conexao);

        } catch (Exception e) {
            e.printStackTrace();
            try {
                this.fecharConexao(conexao);
            } catch (Exception e2) {

            }
        }
    }
    
    /*
     Descrição: Método para consulta da quantidade de Bebidas ou Outros em estoque
     Parâmetros:
     autenticacao (Objeto do tipo Autenticacao contendo as informações para acesso ao banco de dados)
     codigoDoProduto (Inteiro contendo o código do produto selecionado na Tela de Inclusão de Produtos)
     quantidade (Inteiro contendo a quantidade escolhida pelo usuário na Tela de Inclusão de Produtos)
     categoriaDoProduto (String contendo a categoria do produto escolhida na Tela de Cardápio)
     Retorno:
     true, caso a quantidade em estoque seja menor do que a informada pelo usuário; false, caso contrário
     */
    public boolean consultarEstoque(Autenticacao autenticacao, int codigoDoProduto, int quantidade, String categoriaDoProduto) {
        Connection conexao = null;
        boolean consultarEstoque = false;
        try {
            String query;
            if (categoriaDoProduto.equals("Bebida")) {
                query = "SELECT quantidade FROM Bebidas WHERE codProduto = " + codigoDoProduto;
            } else {
                query = "SELECT quantidade FROM Outros WHERE codProduto = " + codigoDoProduto;
            }
            conexao = this.abrirConexao(autenticacao);
            Statement homologacao = conexao.createStatement();
            ResultSet resultado = homologacao.executeQuery(query);
            if (resultado.next()) {;
                if (resultado.getInt("quantidade") < quantidade) {
                    consultarEstoque = true;
                }
            }
        } catch (Exception e) {

        } finally {
            try {
                this.fecharConexao(conexao);
            } catch (Exception e) {

            }
        }
        return consultarEstoque;
    }
    
    /*
     Descrição: Método para consulta da quantidade de Bebidas ou Outros em estoque
     Parâmetros:
     autenticacao (Objeto do tipo Autenticacao contendo as informações para acesso ao banco de dados)
     codigoDoProduto (Inteiro contendo o código do produto selecionado na Tela de Inclusão de Produtos)
     quantidade (Inteiro contendo a quantidade escolhida pelo usuário na Tela de Inclusão de Produtos)
     categoriaDoProduto (String contendo a categoria do produto escolhida na Tela de Cardápio)
     Retorno:
     true, caso o estoque seja atualizado; false, caso contrário
     */
    public boolean atualizarEstoque(Autenticacao autenticacao, int codigoDoProduto, int quantidade, String categoriaDoProduto){
        Connection conexao = null;
        boolean atualizarEstoque = false;
        try{
            String query;
            if(categoriaDoProduto.equals("Bebida")){
                query = "UPDATE Bebidas SET quantidade = quantidade - " + quantidade + " WHERE codProduto = " + codigoDoProduto;
            }
            else{
                query = "UPDATE Outros SET quantidade = quantidade - " + quantidade + " WHERE codProduto = " + codigoDoProduto;
            }
            conexao = this.abrirConexao(autenticacao);
            Statement homologacao = conexao.createStatement();
            homologacao.executeUpdate(query);
            atualizarEstoque = true;
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
        return atualizarEstoque;
    }
}
