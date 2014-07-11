// Pacote Controle
package client.control;

// Importações de pacotes e bibliotecas utillizadas
import client.model.*;
import client.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextArea;


/*
 Descrição: Classe Controle
 */
public class Controle implements Serializable {

    // Objeto para acesso aos métodos de persistência relativos aos arquivos
    private final Arquivos arquivo = new Arquivos();

    // Objeto para acesso aos métodos de persistência relativos ao banco de dados
    private final Banco banco = new Banco();

    /*
     Descrição: Método para verificação da existência dos arquivos de autenticação.
     Parâmetros:
     Retorno:
     true, caso encontre os arquivos, false caso contrário.
     */
    public boolean verificarArquivos() {
        Arquivos arquivo = new Arquivos();
        try {
            arquivo.checarArquivos();
            return true;
        } catch (Exception e) {
            return false;
        }
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
     Descrição: Método para tentativa de autenticação dos dados salvos no arquivo de autenticação com o banco de dados.
     Parâmetros:
     botaoAutenticar (Botão Autenticar da interface TelaPrincipal)
     botaoAbrirPedido (Botão Abrir Pedido da interface TelaPrincipal)
     autenticacao (Objeto com as informações para acesso ao banco de dados)
     Retorno:
     true, caso a conexão seja válida, false caso contrário.
     */
    public boolean verificarAutenticacao(JButton botaoAutenticar, JButton botaoPedido, Autenticacao autenticacao) {
        // Se a conexão foi efetuada, o botão de autenticação é desabilitado e o botão para abrir pedido é habilitado.
        boolean verificarConexao = this.banco.verificarConexao(autenticacao);
        if (verificarConexao) {
            botaoAutenticar.setEnabled(false);
            botaoPedido.setEnabled(true);
            return true;
        } else {
            return false;
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
     Descrição: Método para preenchimento da combobox da Tela de Pedido com os números das mesas disponíveis no banco de dados.
     Parâmetros:
     comboBoxDasMesas (Componente da Tela de Pedido que será preenchido)
     autenticacao (Objeto do tipo Autenticação com as informações para acesso ao banco de dados)
     Retorno:
     true, caso a combobox seja preenchida com as mesas disponíveis; false, caso contrário
     */
    public boolean preencherComboboxDasMesas(JComboBox comboBoxDasMesas, Autenticacao autenticacao) {

        // Tentativa de recuperação dos números das mesas e armazenamento em um ArrayList, para a posterior inserção dos itens no componente combobox
        try {
            ArrayList<Integer> mesas = this.banco.consultarMesas(autenticacao);
            for (int i = 1; i <= mesas.size(); i++) {
                comboBoxDasMesas.addItem(i);
            }
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    /*
     Descrição: Método para consulta do número do pedido referente à mesa selecionada na Tela de Pedido
     Parâmetros:
     numeroDaMesa (Inteiro contendo o número da mesa selecionado na Tela de Pedido)
     autenticacao (Objeto do tipo Autenticação contendo as informações para acesso ao banco de dados)
     Retorno:
     numeroDoPedido (Inteiro contendo o número do pedido referente à mesa escolhida)
     */
    public int consultarNumeroDoPedido(int numeroDaMesa, Autenticacao autenticacao) {
        int numeroDoPedido = this.banco.consultarNumeroDoPedido(numeroDaMesa, autenticacao);
        return numeroDoPedido;
    }

    /*
     Descrição: Método para consulta e exibição dos itens relacionados à um determinado pedido
     Parâmetros:
     tabelaItensDoPedido (JTable que será preenchida com os dados consultados)
     numeroDoPedido (Inteiro contendo o número do pedido selecionado)
     autenticacao (Objeto do tipo Autenticacao contendo as informações para acesso ao banco de dados)
     Retorno:
     */
    public void consultarItensDoPedido(JTable tabelaItensDoPedido, int numeroDoPedido, Autenticacao autenticacao) {
        this.banco.consultarItensDoPedido(tabelaItensDoPedido, numeroDoPedido, autenticacao);
    }

    /*
     Descrição: Método para consulta do valor total de um determinado pedido
     Parâmetros:
     numeroDoPedido (Inteiro contendo o número do pedido selecionado)
     autenticacao (Objeto do tipo Autenticacao contendo as informações para acesso ao banco de dados)
     Retorno:
     valorDoPedido (Valor total do pedido)
     */
    public float consultarValorDoPedido(int numeroDoPedido, Autenticacao autenticacao) {
        float valorDoPedido = this.banco.consultarValorDoPedido(numeroDoPedido, autenticacao);
        return valorDoPedido;
    }

    /*
     Descrição: Método para consulta dos produtos disponíveis no banco de dados (cardápio)
     Parâmetros:
     tabelaProdutos (JTable que será preenchida com os produtos disponíveis)
     autenticacao (Objeto do tipo Autenticacao contendo as informações para acesso ao banco de dados)
     categoriaDoProduto (String contendo o nome da categoria do produto (Pizza, Lanche, Bebida, Outro))
     Retorno:
     */
    public void consultarCardapio(JTable tabelaProdutos, Autenticacao autenticacao, String categoriaDoProduto) {
        this.banco.consultarCardapio(tabelaProdutos, autenticacao, categoriaDoProduto);
    }

    /*
     Descrição: Método para inserir um novo registro de pedido
     Parâmetros:
     numeroDaMesa (Inteiro contendo o número da mesa selecionada na Tela de Pedido)
     autenticacao (Objeto do tipo Autenticacao contendo as informações para acesso ao banco de dados)
     Retorno:
     true, caso o pedido seja inserido com sucesso; false, caso contrário;
     */
    public boolean inserirPedido(int numeroDaMesa, Autenticacao autenticacao) {
        boolean inserirPedido = this.banco.inserirPedido(numeroDaMesa, autenticacao);
        return inserirPedido;
    }

    /*
     Descrição: Método para consultar as opções específicas de um determinado produto (Tamanho, Fatias, etc)
     Parâmetros:
     tabelaOpcoesDisponiveis (JTable que será preenchida com as opções do produto)
     autenticacao (Objeto do tipo Autenticacao contendo as informações para acesso ao banco de dados)
     categoriaDoProduto (String contendo o nome da categoria do produto (Pizza, Lanche, Bebida, Outro)
     nomeDoProduto (String com o nome do produto selecionado na Tela de Cardápio)
     Retorno:
     */
    public void consultarOpcoesDoProduto(JTable tabelaOpcoesDisponiveis, Autenticacao autenticacao, String categoriaDoProduto, String nomeDoProduto) {
        this.banco.consultarOpcoesDoProduto(tabelaOpcoesDisponiveis, autenticacao, categoriaDoProduto, nomeDoProduto);
    }

    /*
     Descrição: Método para consulta de um determinado produto em um determinado pedido.
     Necessário para a inserção ou atualização de um produto em um pedido.
     Parâmetros:
     autenticacao (Objeto do tipo Autenticacao contendo as informações para acesso ao banco de dados)
     numeroDoPedido (Inteiro contendo o número do pedido selecionado na Tela de Pedido)
     codigoDoProduto (Inteiro contendo o código do produto selecionado na Tela de Cardápio)
     Retorno:
     true, caso o produto já exista no pedido; false, caso contrário
     */
    public boolean consultarProdutoNoPedido(Autenticacao autenticacao, int numeroDoPedido, int codigoDoProduto) {
        boolean consultarProdutoNoPedido = this.banco.consultarProdutoNoPedido(autenticacao, numeroDoPedido, codigoDoProduto);
        return consultarProdutoNoPedido;
    }

    /*
     Descrição: Método para inserir um produto em um pedido.
     Parâmetros:
     autenticacao (Objeto do tipo Autenticacao contendo as informações para acesso ao banco de dados)
     numeroDoPedido (Inteiro contendo o número do pedido selecionado na Tela de Pedido)
     codigoDoProduto (Inteiro contendo o código do produto selecionado na Tela de Cardápio)
     quantidade (Inteiro contendo a quantidade desejada)
     tamanho (String contendo o tamanho do produto, no caso das Pizzas)
     preco (Valor do produto)
     Retorno:
     true, caso o produto seja inserido no pedido; false, caso contrário
     */
    public boolean inserirProduto(Autenticacao autenticacao, int numeroDoPedido, int codigoDoProduto, int quantidade, String tamanho, float preco) {
        boolean inserirPizza = this.banco.inserirProduto(autenticacao, numeroDoPedido, codigoDoProduto, quantidade, tamanho, preco);
        return inserirPizza;
    }

    /*
     Descrição: Método para atualização da quantidade de um produto em um determinado pedido
     Parâmetros:
     autenticacao (Objeto do tipo Autenticacao contendo as informações para acesso ao banco de dados)
     numeroDoPedido (Inteiro contendo o número do pedido selecionado na Tela de Pedido)
     categoriaDoProduto (String contendo a categoria do produto (Pizza, Lanche, Bebida, Outro)
     codigoDoProduto (Inteiro contendo o código do produto selecionado na Tela de Cardápio)
     quantidade (Inteiro contendo a quantidade desejada)
     Retorno:
     true, caso a atualização seja efetuada com sucesso; false, caso contrário
     */
    public boolean atualizarQuantidadeDoProdutoNoPedido(Autenticacao autenticacao, int numeroDoPedido, String categoriaDoProduto, int codigoDoProduto, int quantidade) {
        boolean atualizarPizza = this.banco.atualizarQuantidadeDoProdutoNoPedido(autenticacao, numeroDoPedido, categoriaDoProduto, codigoDoProduto, quantidade);
        return atualizarPizza;
    }

    /*
     Descrição: Método para cancelamento de um pedido. Um pedido pode ser cancelado quando o mesmo não tem itens inseridos.
     Parâmetros:
     autenticacao (Objeto do tipo Autenticacao contendo as informações para acesso ao banco de dados)
     numeroDoPedido (Inteiro contendo o número do pedido selecionado na Tela de Pedido)
     Retorno:
     true, caso o pedido seja cancelado com sucesso; false, caso contrário
     */
    public boolean cancelarPedido(Autenticacao autenticacao, int numeroDoPedido) {
        boolean cancelarPedido = this.banco.cancelarPedido(autenticacao, numeroDoPedido);
        return cancelarPedido;
    }

    /*
     Descrição: Método para finalização de um pedido. Um pedido pode ser finalizado quando o mesmo contém, pelo menos, um item
     Parâmetros:
     autenticacao (Objeto do tipo autenticacao contendo as informações para acesso ao bando de dados)
     numeroDoPedido (Inteiro contendo o número do pedido selecionado na Tela de Pedido)
     formaDePagamento (String contendo a forma de pagamento selecionada)
     valor (valor total do pedido)
     Retorno:
     true, caso o pedido seja finalizado com sucesso; false, caso contrário
     */
    public boolean finalizarPedido(Autenticacao autenticacao, int numeroDoPedido, String formaDePagamento, float valor) {
        boolean finalizarPedido = this.banco.finalizarPedido(autenticacao, numeroDoPedido, formaDePagamento, valor);
        return finalizarPedido;
    }

    /*
     Descrição: Método para consulta dos ingredientes de um determinado produto
     Parâmetros:
     textoIngredientes (JTextArea que será preenchida com os ingredientes do produto)
     autenticacao (Objeto do tipo Autenticacao contendo as informações para acesso ao banco de dados)
     categoriaDoProduto (String contendo a categoria do produto (Pizza, Lanche, Bebida, Outro)
     codigoDoProduto (Inteiro contendo o código do produto selecionado na Tela de Cardápio)
     Retorno:
     */
    public void consultarIngredientes(JTextArea textoIngredientes, Autenticacao autenticacao, String categoriaDoProduto, int codigoDoProduto) {
        this.banco.consultarIngredientes(textoIngredientes, autenticacao, categoriaDoProduto, codigoDoProduto);
    }

    /*
     Descrição: Método para consulta da imagem da pizza no banco de dados
     Parâmetros:
     foto (JLabel que será preenchida com a imagem da pizza)
     autenticacao (Objeto do tipo Autenticacao contendo as informações para acesso ao banco de dados)
     codigoDoProduto (Inteiro contendo o código do produto selecionado na Tela de Inclusão de produtos)
     Retorno:
     */
    public void consultarImagemDaPizza(JLabel foto, Autenticacao autenticacao, int codigoDoProduto) {
        this.banco.consultarImagemDaPizza(foto, autenticacao, codigoDoProduto);
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
        boolean consultarEstoque = this.banco.consultarEstoque(autenticacao, codigoDoProduto, quantidade, categoriaDoProduto);
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
        boolean atualizarEstoque = this.banco.atualizarEstoque(autenticacao, codigoDoProduto, quantidade, categoriaDoProduto);
        return atualizarEstoque;
    }
}
