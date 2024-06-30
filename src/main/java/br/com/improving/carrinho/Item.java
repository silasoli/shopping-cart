package br.com.improving.carrinho;

import java.math.BigDecimal;

/**
 * Classe que representa um item no carrinho de compras.
 */
public class Item {

    private Produto produto;
    private BigDecimal valorUnitario;
    private int quantidade;

    /**
     * Construtor da classe Item.
     *
     * @param produto       o produto associado ao item
     * @param valorUnitario o valor unitário do item
     * @param quantidade    a quantidade do item
     */
    public Item(Produto produto, BigDecimal valorUnitario, int quantidade) {
        this.produto = produto;
        this.valorUnitario = valorUnitario;
        this.quantidade = quantidade;
    }

    /**
     * Retorna o produto associado ao item.
     *
     * @return Produto o produto associado ao item
     */
    public Produto getProduto() {
        return produto;
    }

    /**
     * Retorna o valor unitário do item.
     *
     * @return BigDecimal o valor unitário do item
     */
    public BigDecimal getValorUnitario() {
        return valorUnitario;
    }

	public void setValorUnitario(BigDecimal valorUnitario) {
        this.valorUnitario = valorUnitario;
    }
    /**
     * Retorna a quantidade do item.
     *
     * @return int a quantidade do item
     */
    public int getQuantidade() {
        return quantidade;
    }
	
	 public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    /**
     * Retorna o valor total do item.
     *
     * @return BigDecimal o valor total do item (valor unitário * quantidade)
     */
    public BigDecimal getValorTotal() {
        return valorUnitario.multiply(BigDecimal.valueOf(quantidade));
    }
}