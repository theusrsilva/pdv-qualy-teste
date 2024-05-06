package net.originmobi.pdv;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import javax.validation.constraints.AssertTrue;

import org.junit.jupiter.api.Test;

import net.originmobi.pdv.model.Pessoa;
import net.originmobi.pdv.model.Produto;
import net.originmobi.pdv.model.ProdutoEstoque;

public class ProdutoTest {

    @org.junit.Test
    public void testCreateProduto() {
        Produto produto = new Produto();
        produto.setDescricao("Produto Teste");

        Boolean varAux = produto instanceof Produto;

        assertTrue(varAux);
    }

    @org.junit.Test
    public void testTemProdutoEmEstoque() {
        Produto produto = new Produto();
        ProdutoEstoque produtoEstoque = new ProdutoEstoque();
        produto.setDescricao("Produto Teste");
        produtoEstoque.setProduto(produto);
        produtoEstoque.setQtd(10);
        assertTrue(produtoEstoque.getQtd() > 0);
    }

    @org.junit.Test
    public void testMudarValorProduto() {
        Produto produto = new Produto();
        
        produto.setDescricao("Produto Teste");
        produto.setvalorVenda(12.33);
        produto.setvalorVenda(15.00);
        
        assertTrue(produto.getvalorVenda() == 15.00);
    }

}
