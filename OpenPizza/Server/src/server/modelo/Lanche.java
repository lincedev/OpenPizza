package server.modelo;

/*
 Descrição: Classe Lanche (Subclasse de Produto)
 */
public class Lanche extends Produto {

    // Atributos encapsulados
    private float preco;
    private String ingredientesLanche;

    /*
     Descrição: Construtor padrão do objeto lanche
     Parâmetros:
     Retorno:
     */
    private Lanche() {
    }

    /*
     Descrição: Construtor completo do objeto lanche
     Parâmetros:
     *           descricao (Nome do lanche)
     *           preco (Preço do lanche)
     *           ingredientesLanche (Ingredientes do lanche)
     Retorno:
     */
    public Lanche(String descricao, float preco, String ingredientesLanche) {
        super(descricao);
        this.setPreco(preco);
        this.setIngredientesLanche(ingredientesLanche);
    }

    /*
     Descrição: Método get do preço do lanche
     Parâmetros:
     Retorno:
     *           preco (Preço do lanche)
     */
    public float getPreco() {
        return preco;
    }

    /*
     Descrição: Método set do preço do lanche
     Parâmetros:
     *           preco (Preço do lanche)
     Retorno:
     */
    public void setPreco(float preco) {
        this.preco = preco;
    }

    /*
     Descrição: Método get dos ingredientes do lanche
     Parâmetros:
     Retorno:
     *           ingredientesLanche (Ingredientes do lanche)
     */
    public String getIngredientesLanche() {
        return ingredientesLanche;
    }

    /*
     Descrição: Método set dos ingredientes do lanche
     Parâmetros:
     *           ingredientesLanche (Ingredientes do lanche)
     Retorno:
     */
    public void setIngredientesLanche(String ingredientesLanche) {
        this.ingredientesLanche = ingredientesLanche;
    }
}
