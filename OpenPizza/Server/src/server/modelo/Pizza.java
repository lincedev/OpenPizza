// Pacote Modelo
package server.modelo;

/*
 Descrição: Classe Pizza (Subclasse de Produto)
 */
public class Pizza extends Produto {

    // Atributos encapsulados
    private float preco;
    private String tamanho;
    private int fatias;
    private String ingredientesPizza;
    private String imagemPizza;

    /*
     Descrição: Construtor padrão do objeto pizza
     Parâmetros:
     Retorno:
     */
    public Pizza() {
    }

    /*
     Descrição: Construtor completo do objeto pizza
     Parâmetros: 
     descricao (Nome do produto)
     preco (Preço da pizza)
     tamanho (Tamanho da pizza)
     qtdFatias (Quantidade de fatias da pizza)
     ingredientesPizza (Ingredientes da pizza)
     imagemPizza (Imagem da pizza)
     Retorno:
     */
    public Pizza(String descricao, float preco, String tamanho, int qtdFatias, String ingredientesPizza, String imagemPizza) {
        super(descricao);
        this.setPreco(preco);
        this.setTamanho(tamanho);
        this.setFatias(qtdFatias);
        this.setIngredientesPizza(ingredientesPizza);
        this.setImagemPizza(imagemPizza);
    }

    /*
     Descrição: Método get do preço da pizza mini
     Parâmetros:
     Retorno:
     preco (Preço da pizza mini)
     */
    public float getPreco() {
        return preco;
    }

    /*
     Descrição: Método set do preço da pizza mini
     Parâmetros:
     preco (Preço da pizza mini)
     Retorno:
     */
    public void setPreco(float preco) {
        this.preco = preco;
    }

    /*
     Descrição: Método get do tamanho da pizza mini
     Parâmetros:
     Retorno:
     tamanho (Tamanho da pizza)
     */
    public String getTamanho() {
        return tamanho;
    }

    /*
     Descrição: Método set do tamanho da pizza
     Parâmetros:
     tamanho (Tamanho da pizza)
     Retorno:
     */
    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    /*
     Descrição: Método get das fatias da pizza
     Parâmetros:
     Retorno:
     fatias (Fatias da pizza)
     */
    public int getFatias() {
        return fatias;
    }

    /*
     Descrição: Método set das fatias da pizza
     Parâmetros:
     fatias (Fatias da pizza)
     Retorno:
     */
    public void setFatias(int fatias) {
        this.fatias = fatias;
    }

    /*
     Descrição: Método get dos ingredientes da pizza
     Parâmetros:
     Retorno:
     ingredientesPizza (Ingredientes da pizza)
     */
    public String getIngredientesPizza() {
        return ingredientesPizza;
    }

    /*
     Descrição: Método set dos ingredientes da pizza
     Parâmetros:
     ingredientesPizza (Ingredientes da pizza)
     Retorno:
     */
    public void setIngredientesPizza(String ingredientesPizza) {
        this.ingredientesPizza = ingredientesPizza;
    }

    /*
     Descrição: Método get da imagem da pizza
     Parâmetros:
     Retorno:
     imagemPizza (URL da imagem da pizza)
     */
    public String getImagemPizza() {
        return imagemPizza;
    }

    /*
     Descrição: Método set da imagem da pizza
     Parâmetros:
     imagemPizza (URL da imagem da pizza)
     Retorno:
     */
    public void setImagemPizza(String imagemPizza) {
        this.imagemPizza = imagemPizza;
    }
}
