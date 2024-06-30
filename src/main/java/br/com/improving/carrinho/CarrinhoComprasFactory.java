package br.com.improving.carrinho;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

/**
 * Classe responsável pela criação e recuperação dos carrinhos de compras.
 */
public class CarrinhoComprasFactory {

    private Map<String, CarrinhoCompras> carrinhos;

    public CarrinhoComprasFactory() {
        carrinhos = new HashMap<>();
    }

    /**
     * Cria e retorna um novo carrinho de compras para o cliente passado como parâmetro.
     * Caso já exista um carrinho de compras para o cliente passado como parâmetro, este carrinho deverá ser retornado.
     *
     * @param identificacaoCliente identificação do cliente
     * @return CarrinhoCompras o carrinho de compras
     */
    public CarrinhoCompras criar(String identificacaoCliente) {
        if (carrinhos.containsKey(identificacaoCliente)) {
            return carrinhos.get(identificacaoCliente);
        } else {
            CarrinhoCompras carrinho = new CarrinhoCompras();
            carrinhos.put(identificacaoCliente, carrinho);
            return carrinho;
        }
    }

    /**
     * Retorna o valor do ticket médio no momento da chamada ao método.
     * O valor do ticket médio é a soma do valor total de todos os carrinhos de compra dividido
     * pela quantidade de carrinhos de compra.
     * O valor retornado deverá ser arredondado com duas casas decimais, seguindo a regra:
     * 0-4 deve ser arredondado para baixo e 5-9 deve ser arredondado para cima.
     *
     * @return BigDecimal o valor do ticket médio
     */
    public BigDecimal getValorTicketMedio() {
        if (carrinhos.isEmpty()) {
            return BigDecimal.ZERO;
        }

        BigDecimal total = BigDecimal.ZERO;
        for (CarrinhoCompras carrinho : carrinhos.values()) {
            total = total.add(carrinho.getValorTotal());
        }

        BigDecimal quantidade = BigDecimal.valueOf(carrinhos.size());
        return total.divide(quantidade, 2, BigDecimal.ROUND_HALF_UP);
    }

    /**
     * Invalida um carrinho de compras quando o cliente faz um checkout ou sua sessão expirar.
     * Deve ser efetuada a remoção do carrinho do cliente passado como parâmetro da listagem de carrinhos de compras.
     *
     * @param identificacaoCliente identificação do cliente
     * @return boolean true se o carrinho do cliente for removido com sucesso, false caso contrário
     */
    public boolean invalidar(String identificacaoCliente) {
        if (carrinhos.containsKey(identificacaoCliente)) {
            carrinhos.remove(identificacaoCliente);
            return true;
        } else {
            return false;
        }
    }
}