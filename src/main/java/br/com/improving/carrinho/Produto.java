package br.com.improving.carrinho;

/**
 * Classe que representa um produto que pode ser adicionado
 * como item ao carrinho de compras.
 *
 * Importante: Dois produtos são considerados iguais quando ambos possuem o
 * mesmo código.
 */
public class Produto {

    private Long codigo;
    private String descricao;

    /**
     * Construtor da classe Produto.
     *
     * @param codigo    o código do produto
     * @param descricao a descrição do produto
     */
    public Produto(Long codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    /**
     * Retorna o código do produto.
     *
     * @return Long o código do produto
     */
    public Long getCodigo() {
        return codigo;
    }

    /**
     * Retorna a descrição do produto.
     *
     * @return String a descrição do produto
     */
    public String getDescricao() {
        return descricao;
    }
}