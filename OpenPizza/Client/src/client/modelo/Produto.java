package client.modelo;

/*
 Descrição: Classe Produto
 */
public class Produto {

    // Atributos encapsulados
    private int codigo;
    private String descricao;

    /*
     Descrição: Construtor padrão do objeto produto
     Parâmetros:
     Retorno:
     */
    public Produto() {
    }

    /*
     Descrição: Construtor completo do objeto produto
     Parâmetros:
     *           descricao (Nome do produto)
     Retorno:
     */
    public Produto(String descricao) {
        this.setDescricao(descricao);
    }

    /*
     Descrição: Método get do código do produto
     Parâmetros:
     Retorno:
     *           código (Código do produto)
     */
    public int getCodigo() {
        return codigo;
    }

    /*
     Descrição: Método set do código do produto
     Parâmetros:
     *          código (Código do produto)
     Retorno:
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /*
     Descrição: Método get da descrição do produto
     Parâmetros:
     Retorno:
     *           descricao (Nome do produto)
     */
    public String getDescricao() {
        return descricao;
    }

    /*
     Descrição: Método set da descrição do produto
     Parâmetros:
     *           descricao (Nome do produto)
     Retorno:
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

}
