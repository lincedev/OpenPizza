// Pacote Controle
package server.controle;

// Importação dos pacotes e bibliotecas necessárias
import java.io.Serializable;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import server.modelo.Autenticacao;
import server.persistencia.Arquivos;
import server.persistencia.Banco;

/*
 Descrição: Classe Controle
 */
public class Controle implements Serializable {

    // Objetos de persistência
    private final Banco banco = new Banco();
    private final Arquivos arquivo = new Arquivos();

    /*
     Descrição: Método para tentativa de salvar os dados de autenticação informados diretamente no respectivo arquivo (Client ou Server)
     Parâmetros:
     autenticacao (Objeto do tipo Autenticação contendo as informações de acesso ao banco de dados)
     Retorno:
     true, caso o arquivo seja salvo; false, caso contrário;
     */
    public boolean salvarAutenticacao(Autenticacao autenticacao) {
        boolean salvarAutenticacao = false;
        try {
            salvarAutenticacao = this.arquivo.salvarAutenticacao(autenticacao.getCaminhoBanco(), autenticacao.getUsuarioBanco(), autenticacao.getUsuarioSenha());
            return salvarAutenticacao;
        } catch (Exception e) {
            return salvarAutenticacao;
        }
    }
    
    /*
     Descrição: Método para tentativa de verificação da conexão com o banco de dados.
     Parâmetros:
     autenticacao (Objeto do tipo autenticacao contendo as informações para acesso ao banco de dados)
     Retorno:
     true, caso a conexão seja válida; false, caso contrário;
     */
    public boolean verificarConexao(Autenticacao autenticacao) {
        boolean verificarAutenticacao = this.banco.verificarConexao(autenticacao);
        return verificarAutenticacao;
    }
    
    /*
     Descrição: Método para verificação da existência dos arquivos de autenticação.
     Parâmetros:
     Retorno:
     true, caso encontre os arquivos, false caso contrário.
     */
    public boolean verificarArquivos() {
        try {
            this.arquivo.checarArquivos();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    /*
     Descrição: Método para exibição dos pedidos em aberto no banco de dados
     Parâmetros:
     autenticacao (Objeto com as informações para acesso ao banco de dados)
     tabelaPedidosEmAberto (JTable a ser preenchida com os dados)
     Retorno:
     */
    public void exibirPedidosEmAberto(Autenticacao autenticacao, JTable tabelaPedidosEmAberto) {
        this.banco.exibirPedidosEmAberto(autenticacao, tabelaPedidosEmAberto);
    }

    /*
     Descrição: Método para tentativa de recuperação dos dados salvos no arquivo de autenticação.
     Parâmetros:
     autenticacao (Objeto do tipo autenticacao que será portador das informações lidas do arquivo de autenticação)
     Retorno:
     */
    public void recuperarDadosAutenticacao(Autenticacao autenticacao) {
        try {
            this.arquivo.recuperarDadosDeAutenticacao(autenticacao);
        } catch (Exception e) {

        }
    }

    /*
     Descrição: Método para exibição dos produtos de acordo com a sua categoria
     Parâmetros:
     autenticacao (Objeto com as informações para acesso ao banco de dados)
     tabelaProduto (JTable que será preenchida com os produtos)
     categoriaDoProduto (String contendo a categoria do produto selecionado)
     Retorno:
     */
    public void consultarCardapio(Autenticacao autenticacao, JTable tabelaProduto, String categoriaDoProduto) {
        this.banco.consultarCardapio(tabelaProduto, autenticacao, categoriaDoProduto);
    }

    /*
     Descrição: Método exibição dos produtos nas telas de CRUD
     Parâmetros:
     autenticacao (Objeto com as informações para acesso ao banco de dados)
     tabelaProduto (JTable que será preenchida com os produtos)
     categoriaDoProduto (String contendo a categoria do produto selecionado)
     Retorno:
     */
    public void exibirProdutos(Autenticacao autenticacao, JTable tabelaProduto, String categoriaDoProduto) {
        this.banco.exibirProdutos(autenticacao, tabelaProduto, categoriaDoProduto);
    }

    /*
     Descrição: Método para consulta dos ingredientes das pizzas e lanches
     Parâmetros:
     textoIngredientes (JTextArea que será preenchida com os ingredientes)
     autenticacao (Objeto com as informações para acesso ao banco de dados)
     categoriaDoProduto (String contendo a categoria do produto selecionado)
     nomeDoProduto (String contendo o nome do produto selecionado)
     Retorno:
     */
    public void consultarIngredientes(JTextArea textoIngredientes, Autenticacao autenticacao, String categoriaDoProduto, String nomeDoProduto) {
        this.banco.consultarIngredientes(textoIngredientes, autenticacao, categoriaDoProduto, nomeDoProduto);
    }

    /*
     Descrição: Método para inserção de um produto no banco de dados
     Parâmetros:
     autenticacao (Objeto com as informações para acesso ao banco de dados)
     produto (Objeto contendo as informações do produto, utilizado para downcast na classe de persistência)
     Retorno:
     inserirProduto (true, caso o produto seja inserido; false, caso contrário)
     */
    public boolean inserirProduto(Autenticacao autenticacao, Object produto) {
        boolean inserirProduto = this.banco.inserirProduto(autenticacao, produto);
        return inserirProduto;
    }

    /*
     Descrição: Método para tentativa de autenticação dos dados salvos no arquivo de autenticação com o banco de dados.
     Parâmetros:
     botaoAutenticar (Botão Autenticar da interface TelaPrincipal)
     botaoAbrirPedido (Botão Abrir Pedido da interface TelaPrincipal)
     autenticacao (Objeto com as informações para acesso ao banco de dados)
     Retorno:
     true, caso a conexão seja válida, false caso contrário.
     */
    public boolean verificarAutenticacao(Autenticacao autenticacao) {
        // Se a conexão foi efetuada, o botão de autenticação é desabilitado e o botão para abrir pedido é habilitado.
        boolean verificarConexao = this.banco.verificarConexao(autenticacao);
        if (verificarConexao) {
            return true;
        } else {
            return false;
        }
    }

    /*
     Descrição: Método para validação dos campos informados pelo usuário ao tentar cadastrar uma Bebida ou Outro
     Parâmetros:
     descricao (JTextField contendo o nome do produto)
     preco (JTextField contendo o preço do produto)
     estoque (JTextField contendo a quantidade em estoque do produto)
     Retorno:
     true, caso os valores sejam válidos; false, caso contrário
     */
    public boolean verificarCamposBebidasOutros(JTextField descricao, JTextField preco, JTextField estoque) {
        if ((descricao.getText().isEmpty()) || (preco.getText().isEmpty()) || (estoque.getText().isEmpty())) {
            return false;
        } else {
            try {
                if ((Float.parseFloat(preco.getText()) < 0) || (Integer.parseInt(estoque.getText()) < 0)) {
                    return false;
                } else {
                    return true;
                }
            } catch (Exception e) {
                return false;
            }
        }
    }

    /*
     Descrição: Método para validação dos campos informados pelo usuário ao tentar cadastrar um Lanche
     Parâmetros:
     descrição (JTextField contendo o nome do produto)
     preco (JTextField contendo o preço do produto)
     Retorno:
     true, caso os valores sejam válidos; false, caso contrário
     */
    public boolean verificarCamposLanche(JTextField descricao, JTextField preco) {
        if ((descricao.getText().isEmpty()) || (preco.getText().isEmpty())) {
            return false;
        } else {
            try {
                if (Float.parseFloat(preco.getText()) < 0) {
                    return false;
                } else {
                    return true;
                }
            } catch (Exception e) {
                return false;
            }
        }
    }

    /*
     Descrição: Método para validação dos campos informados pelo usuário ao tentar cadastrar uma Pizza
     Parâmetros:
     descrição (JTextField contendo o nome do produto)
     preco (JTextField contendo o preço do produto)
     comboBoxTamanhoPizzas (Combobox com o tamanho selecionado da pizza)
     Retorno:
     true, caso os valores sejam válidos; false, caso contrário
     */
    public boolean verificarCamposPizza(JTextField descricao, JTextField preco, JComboBox comboBoxTamanhoPizzas) {
        if ((descricao.getText().isEmpty()) || (preco.getText().isEmpty()) || (comboBoxTamanhoPizzas.getSelectedIndex() == 0)) {
            return false;
        } else {
            try {
                if (Float.parseFloat(preco.getText()) < 0) {
                    return false;
                } else {
                    return true;
                }
            } catch (Exception e) {
                return false;
            }
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
        boolean desativarProduto = this.banco.desativarProduto(autenticacao, codigoDoProduto);
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
        boolean inserirMesa = this.banco.inserirMesa(autenticacao);
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
        boolean desativarMesa = this.banco.desativarMesa(autenticacao, numeroDaMesa);
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
        this.banco.gerarRelatorio(autenticacao, tipoProduto);
    }
}
