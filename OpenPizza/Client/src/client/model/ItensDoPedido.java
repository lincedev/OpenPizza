/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package client.model;

/**
 *
 * @author lince
 */
public class ItensDoPedido {
    private int pedidoNumero;
    private int codigoProduto;
    private int qtdadeProdutos;
    private String tamanho;
    private float preco;

    public int getPedidoNumero() {
        return pedidoNumero;
    }

    public void setPedidoNumero(int pedidoNumero) {
        this.pedidoNumero = pedidoNumero;
    }

    public int getCodigoProduto() {
        return codigoProduto;
    }

    public void setCodigoProduto(int codigoProduto) {
        this.codigoProduto = codigoProduto;
    }

    public int getQtdadeProdutos() {
        return qtdadeProdutos;
    }

    public void setQtdadeProdutos(int qtdadeProdutos) {
        this.qtdadeProdutos = qtdadeProdutos;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}
