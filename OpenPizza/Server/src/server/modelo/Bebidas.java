// Pacote Modelo
package server.modelo;

/*
 Descrição: Classe Bebidas (Subclasse de Produto)
 */
public class Bebidas extends Produto {

    // Atributos encapsulados
    private float preco;
    private int quantidade;

    /*
     Descrição: Construtor padrão do objeto bebida
     Parâmetros:
     Retorno:
     */
    public Bebidas() {
    }

    /*
     Descrição: Construtor completo do objeto bebida
     Parâmetros:
               descricao (Nome da bebida)
                preco (Preço da bebida)
     Retorno:
     */
    public Bebidas(String descricao, float preco, int quantidade) {
        super(descricao);
        this.setPreco(preco);
        this.setQuantidade(quantidade);
    }

    /*
     Descrição: Método get do preço da bebida
     Parâmetros:
     Retorno:
     preco (Preço da bebida)
     */
    public float getPreco() {
        return preco;
    }

    /*
     Descrição: Método set do preço da bebida
     Parâmetros:
     preco (Preço da bebida)
     Retorno:
     */
    public void setPreco(float preco) {
        this.preco = preco;
    }

    /*
     Descrição: Método get da quantidade
     Parâmetros:
     Retorno:
     quantidade (Quantidade da bebida)
     */
    public int getQuantidade() {
        return quantidade;
    }

    /*
     Descrição: Método set da quantidade
     Parâmetros:
     quantidade (Quantidade da bebida)
     Retorno:
     */
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
}
