// Pacote Modelo
package client.model;

/*
 Descrição: Classe Pedido
 */
public class Pedido {

    // Atributos encapsulados
    private int numeroPedido;
    private String data;
    private String hora;
    private float valor;
    private String formaPagamento;
    private boolean pedidoFinalizado;

    /*
     Descrição: Construtor padrão do objeto Pedido
     Parâmetros:
     Retorno:
     */
    public Pedido() {
    }

    /*
     Descrição: Construtor completo do objeto Pedido
     Parâmetros:
     numeroPedido (Inteiro contendo o número do pedido)
     data (String contendo a data do pedido)
     hora (String contendo a hora do pedido)
     valor (Valor do pedido)
     formaPagamento (String com a forma de pagamento do pedido)
     pedidoFinalizado (Booleano contendo o status do pedido)
     Retorno:
     */
    public Pedido(int numeroPedido, String data, String hora, float valor, String formaPagamento, boolean pedidoFinalizado) {
        this.setNumeroPedido(numeroPedido);
        this.setData(data);
        this.setHora(hora);
        this.setValor(valor);
        this.setFormaPagamento(formaPagamento);
        this.setPedidoFinalizado(pedidoFinalizado);
    }

    /*
     Descrição: Método get do número do pedido
     Parâmetros:
     Retorno:
     numeroDoPedido (Inteiro contendo o número do pedido)
     */
    public int getNumeroPedido() {
        return numeroPedido;
    }

    /*
     Descrição: Método set do número do pedido
     Parâmetros:
     numeroPedido (Inteiro contendo o número do pedido)
     Retorno:
     */
    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    /*
     Descrição: Método get da data
     Parâmetros:
     Retorno:
     data (String contendo a data do pedido)
     */
    public String getData() {
        return data;
    }

    /*
     Descrição: Método set da data do pedido
     Parâmetros:
     data (String contendo a data do pedido)
     Retorno:
     */
    public void setData(String data) {
        this.data = data;
    }

    /*
     Descrição: Método get da hora do pedido
     Parâmetros:
     Retorno:
     hora (String contendo a hora do pedido)
     */
    public String getHora() {
        return hora;
    }

    /*
     Descrição: Método set da hora do pedido
     Parâmetros:
     hora (String contendo a hora do pedido)
     Retorno:
     */
    public void setHora(String hora) {
        this.hora = hora;
    }

    /*
     Descrição: Método get do valor do pedido
     Parâmetros:
     Retorno:
     valor (Float contendo o valor do pedido)
     */
    public float getValor() {
        return valor;
    }

    /*
     Descrição: Método set do valor do pedido
     Parâmetros:
     valor (Float contendo o valor do pedido)
     Retorno:
     */
    public void setValor(float valor) {
        this.valor = valor;
    }

    /*
     Descrição: Método get da forma de pagamento do pedido
     Parâmetros:
     Retorno:
     formaPagamento (String contendo a forma de pagamento do pedido)
     */
    public String getFormaPagamento() {
        return formaPagamento;
    }

    /*
     Descrição: Método set da forma de pagamento do pedido
     Parâmetros:
     formaPagamento (String contendo a forma de pagamento do pedido)
     Retorno:
     */
    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    /*
     Descrição: Método get do status do pedido
     Parâmetros:
     Retorno:
     true, caso o pedido esteja finalizado; false, caso contrário
     */
    public boolean isPedidoFinalizado() {
        return pedidoFinalizado;
    }

    /*
     Descrição: Método set do status do pedido
     Parâmetros:
     pedidoFinalizado (Booleano contendo o status do pedido)
     Retorno:
     */
    public void setPedidoFinalizado(boolean pedidoFinalizado) {
        this.pedidoFinalizado = pedidoFinalizado;
    }
}
