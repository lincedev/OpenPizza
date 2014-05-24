package client.modelo;

/*
 Descrição: Classe Bebidas (Subclasse de Produto)
 */
public class Bebidas extends Produto {

    // Atributos encapsulados
    private float preco;

    /*
     Descrição: Construtor padrão do objeto bebida
     Parâmetros:
     Retorno:
     */
    private Bebidas() {
    }

    /*
     Descrição: Construtor completo do objeto bebida
     Parâmetros:
     *           descricao (Nome da bebida)
     *           preco (Preço da bebida)
     Retorno:
     */
    public Bebidas(String descricao, float preco) {
        super(descricao);
        this.setPreco(preco);
    }

    /*
     Descrição: Método get do preço da bebida
     Parâmetros:
     Retorno:
     *           preco (Preço da bebida)
     */
    public float getPreco() {
        return preco;
    }

    /*
     Descrição: Método set do preço da bebida
     Parâmetros:
     *           preco (Preço da bebida)
     Retorno:
     */
    public void setPreco(float preco) {
        this.preco = preco;
    }
}
