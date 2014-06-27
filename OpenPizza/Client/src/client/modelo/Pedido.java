/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package client.modelo;

/**
 *
 * @author Wellington
 */
public class Pedido {

    private int numeroPedido;
    private String data;
    private String hora;
    private float valor;
    private String formaPagamento;
    private boolean pedidoFinalizado;

    public Pedido() {
    }

    public Pedido(int numeroPedido, String data, String hora, float valor, String formaPagamento, boolean pedidoFinalizado) {
        this.setNumeroPedido(numeroPedido);
        this.setData(data);
        this.setHora(hora);
        this.setValor(valor);
        this.setFormaPagamento(formaPagamento);
        this.setPedidoFinalizado(pedidoFinalizado);
    }

    public int getNumeroPedido() {
        return numeroPedido;
    }

    public void setNumeroPedido(int numeroPedido) {
        this.numeroPedido = numeroPedido;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public boolean isPedidoFinalizado() {
        return pedidoFinalizado;
    }

    public void setPedidoFinalizado(boolean pedidoFinalizado) {
        this.pedidoFinalizado = pedidoFinalizado;
    }
}
