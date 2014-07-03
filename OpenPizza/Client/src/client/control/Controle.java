package client.control;

import client.model.*;
import client.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextArea;


/**
 *
 * @author lince
 */
public class Controle implements Serializable {
    
    private final Arquivos arquivo = new Arquivos();
    
    private final Banco banco = new Banco();
    
    /*
     Descrição: Método para verificação da existência dos arquivos de autenticação.
     Parâmetros:
     Retorno:
                true, caso encontre os arquivos, false caso contrário.
     */
    public boolean verificarArquivos(){
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
     Retorno:
                autenticacao (Objeto do tipo Autenticação com as informações para acesso ao banco de dados), caso
                a tentativa obtenha sucesso; null caso contrário.
     */
    public Autenticacao recuperarDadosAutenticacao(){
        Arquivos arquivo = new Arquivos();
        try{
            Autenticacao autenticacao = this.arquivo.recuperarDadosDeAutenticacao();
            return autenticacao;
        }
        catch(Exception e){
            return null;
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
        if(verificarConexao){
            botaoAutenticar.setEnabled(false);
            botaoPedido.setEnabled(true);
            return true;
        }
        else{
            return false;
        }
    }

    
    public boolean verificarConexao(Autenticacao autenticacao){
        boolean verificarAutenticacao = this.banco.verificarConexao(autenticacao);
        return verificarAutenticacao;
    }
    
    public boolean salvarAutenticacao(Autenticacao autenticacao){
        boolean salvarAutenticacao = false;
        try{
            salvarAutenticacao = this.arquivo.salvarAutenticacao(autenticacao.getCaminhoBanco(), autenticacao.getUsuarioBanco(), autenticacao.getUsuarioSenha());
            return salvarAutenticacao;
        }
        catch(Exception e){
            return salvarAutenticacao;
        }
    }
    
    public boolean preencherComboboxDasMesas(JComboBox comboBoxDasMesas, Autenticacao autenticacao){
        
        try{
            ArrayList<Integer> mesas = this.banco.consultarMesas(autenticacao);
            for(int i = 1; i <= mesas.size(); i++){
                comboBoxDasMesas.addItem(i);
            }
            return true;
        }
        catch(Exception e){
            return false;
        }
    }
    
    public int consultarNumeroDoPedido(int numeroDaMesa, Autenticacao autenticacao){
        int numeroDoPedido = this.banco.consultarNumeroDoPedido(numeroDaMesa, autenticacao);
        return numeroDoPedido;
    }
    
    public void consultarItensDoPedido(JTable tabelaItensDoPedido, int numeroDoPedido, Autenticacao autenticacao){
        this.banco.consultarItensDoPedido(tabelaItensDoPedido, numeroDoPedido, autenticacao);
    }
    
    public float consultarValorDoPedido(int numeroDoPedido, Autenticacao autenticacao){
        float valorDoPedido = this.banco.consultarValorDoPedido(numeroDoPedido, autenticacao);
        return valorDoPedido;   
    }
    
    public void consultarCardapio(JTable tabelaPizzas, Autenticacao autenticacao, String categoriaDoProduto){
        this.banco.consultarCardapio(tabelaPizzas, autenticacao, categoriaDoProduto);
    }
    
    public boolean inserirPedido(int numeroDaMesa, Autenticacao autenticacao){
        boolean inserirPedido = this.banco.inserirPedido(numeroDaMesa, autenticacao);
        return inserirPedido;
    }
    
    public void consultarOpcoesDoProduto(JTable tabelaOpcoesDisponiveis, Autenticacao autenticacao, String categoriaDoProduto, String nomeDaPizza){
        this.banco.consultarOpcoesDoProduto(tabelaOpcoesDisponiveis, autenticacao, categoriaDoProduto, nomeDaPizza);
    }
    
    public boolean consultarProdutoNoPedido(Autenticacao autenticacao, int numeroDoPedido, int codigoDoProduto){
        boolean consultarProdutoNoPedido = this.banco.consultarProdutoNoPedido(autenticacao, numeroDoPedido, codigoDoProduto);
        return consultarProdutoNoPedido;
    }
    
    public boolean inserirProduto(Autenticacao autenticacao, int numeroDoPedido, int codigoDaPizza, int quantidade, String tamanho, float preco){
        boolean inserirPizza = this.banco.inserirProduto(autenticacao, numeroDoPedido, codigoDaPizza, quantidade, tamanho, preco);
        return inserirPizza;
    }
    
    public boolean atualizarQuantidadeDoProdutoNoPedido(Autenticacao autenticacao, int numeroDoPedido, String categoriaDoProduto, int codigoDoProduto, int quantidade){
        boolean atualizarPizza = this.banco.atualizarQuantidadeDoProdutoNoPedido(autenticacao, numeroDoPedido, categoriaDoProduto, codigoDoProduto, quantidade);
        return atualizarPizza;
    }
    
    public boolean cancelarPedido(Autenticacao autenticacao, int numeroDoPedido){
        boolean cancelarPedido = this.banco.cancelarPedido(autenticacao, numeroDoPedido);
        return cancelarPedido;
    }
    
    public boolean finalizarPedido(Autenticacao autenticacao, int numeroDoPedido, String formaDePagamento, float valor){
        boolean finalizarPedido = this.banco.finalizarPedido(autenticacao, numeroDoPedido, formaDePagamento, valor);
        return finalizarPedido;
    }
    
    public void consultarIngredientes(JTextArea textoIngredientes, Autenticacao autenticacao, String categoriaDoProduto, int codigoDoProduto){
        this.banco.consultarIngredientes(textoIngredientes, autenticacao, categoriaDoProduto, codigoDoProduto);
    }
}
