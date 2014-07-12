// Pacote Modelo
package client.model;

/*
 Descrição: Classe Outros (Subclasse de Produto)
 */
public class Outros extends Produto {

    // Atributos encapsulados
    private float preco;
    private int quantidade;

    /*
     Descrição: Construtor padrão do objeto outros
     Parâmetros:
     Retorno:
     */
    private Outros() {
    }

    /*
     Descrição: Construtor completo do objeto outros
     Parâmetros:
     descricao (Nome do produto)
     preco (Preço do produto)
     Retorno:
     */
    public Outros(String descricao, float preco) {
        super(descricao);
        this.setPreco(preco);
    }

    /*
     Descrição: Método get do preço do produto
     Parâmetros:
     Retorno:
     preco (Preço do produto)
     */
    public float getPreco() {
        return preco;
    }

    /*
     Descrição: Método set do preço do produto
     Parâmetros:
     preco (Preço do produto)
     Retorno:
     */
    public void setPreco(float preco) {
        this.preco = preco;
    }

    /*
     Descrição: Método get da quantidade
     Parâmetros:
     Retorno:
     quantidade (Quantidade do produto)
     */
    public int getQuantidade() {
        return quantidade;
    }

    /*
     Descrição: Método set da quantidade do produto
     Parâmetros:
     quantidade (Quantidade do produto)
     Retorno:
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
