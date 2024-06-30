/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package br.com.improving.carrinho;

/**
 *
 * @author silas
 */
package br.com.improving.carrinho;

import java.math.BigDecimal;

public class Main {

    public static void main(String[] args) {
        CarrinhoCompras carrinho = new CarrinhoCompras();

        Produto produto1 = new Produto(1L, "Camiseta");
        Produto produto2 = new Produto(2L, "Calça");

        carrinho.adicionarItem(produto1, new BigDecimal("29.99"), 2);
        carrinho.adicionarItem(produto2, new BigDecimal("59.99"), 1);

        System.out.println("Valor total do carrinho: " + carrinho.getValorTotal());
    }

}