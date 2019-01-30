package com.show.moto.motoshow.Modelos;

public class PedidoItem {
    String pedido;
    String produto;
    String servico;
    Double valor;
    Double quantidade;

    public PedidoItem() {
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public String getServico() {
        return servico;
    }

    public void setServico(String servico) {
        this.servico = servico;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(Double quantidade) {
        this.quantidade = quantidade;
    }

    public boolean isProduto() {
        return this.produto != null;
    }

    public boolean isServico() {
        return this.servico != null;
    }
}
