package br.com.improving.carrinho;

import java.math.BigDecimal;
import java.util.*;

/**
 * Classe que representa o carrinho de compras de um cliente.
 */
public class CarrinhoCompras {

    private List<Item> itens;

    public CarrinhoCompras() {
        itens = new ArrayList<>();
    }

    /**
     * Permite a adição de um novo item no carrinho de compras.
     * Caso o item já exista no carrinho para este mesmo produto, as seguintes regras deverão ser seguidas:
     * - A quantidade do item deverá ser a soma da quantidade atual com a quantidade passada como parâmetro.
     * - Se o valor unitário informado for diferente do valor unitário atual do item, o novo valor unitário do item deverá ser
     * o passado como parâmetro.
     *
     * Devem ser lançadas subclasses de RuntimeException caso não seja possível adicionar o item ao carrinho de compras.
     *
     * @param produto       o produto a ser adicionado
     * @param valorUnitario o valor unitário do item
     * @param quantidade    a quantidade do item
     */
    public void adicionarItem(Produto produto, BigDecimal valorUnitario, int quantidade) {
        for (Item item : itens) {
            if (item.getProduto().equals(produto)) {
                BigDecimal novoValorUnitario = valorUnitario.setScale(2, BigDecimal.ROUND_HALF_UP);
                item.setValorUnitario(novoValorUnitario);
                item.setQuantidade(item.getQuantidade() + quantidade);
                return;
            }
        }

        Item novoItem = new Item(produto, valorUnitario, quantidade);
        itens.add(novoItem);
    }

    /**
     * Permite a remoção do item que representa este produto do carrinho de compras.
     *
     * @param produto o produto a ser removido
     * @return boolean true se o produto for removido com sucesso, false caso contrário
     */
    public boolean removerItem(Produto produto) {
        Iterator<Item> iterator = itens.iterator();
        while (iterator.hasNext()) {
            Item item = iterator.next();
            if (item.getProduto().equals(produto)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }

    /**
     * Permite a remoção do item de acordo com a posição.
     * Essa posição deve ser determinada pela ordem de inclusão do produto na coleção,
     * em que zero representa o primeiro item.
     *
     * @param posicaoItem a posição do item a ser removido
     * @return boolean true se o produto for removido com sucesso, false caso contrário
     */
    public boolean removerItem(int posicaoItem) {
        if (posicaoItem >= 0 && posicaoItem < itens.size()) {
            itens.remove(posicaoItem);
            return true;
        }
        return false;
    }

    /**
     * Retorna o valor total do carrinho de compras, que deve ser a soma dos valores totais
     * de todos os itens que compõem o carrinho.
     *
     * @return BigDecimal o valor total do carrinho de compras
     */
    public BigDecimal getValorTotal() {
        BigDecimal total = BigDecimal.ZERO;
        for (Item item : itens) {
            total = total.add(item.getValorTotal());
        }
        return total.setScale(2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * Retorna a lista de itens do carrinho de compras.
     *
     * @return Collection<Item> a lista de itens do carrinho de compras
     */
    public Collection<Item> getItens() {
        return Collections.unmodifiableCollection(itens);
    }
}