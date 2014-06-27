package server.modelo;

/*
 Descrição: Classe Outros (Subclasse de Produto)
 */
public class Outros extends Produto {

    // Atributos encapsulados
    private float preco;

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
     *           descricao (Nome do produto)
     *           preco (Preço do produto)
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
     *           preco (Preço do produto)
     */
    public float getPreco() {
        return preco;
    }

    /*
     Descrição: Método set do preço do produto
     Parâmetros:
     *           preco (Preço do produto)
     Retorno:
     */
    public void setPreco(float preco) {
        this.preco = preco;
    }
}
