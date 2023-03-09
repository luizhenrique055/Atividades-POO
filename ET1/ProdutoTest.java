import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ProdutoTest {

    @Test
    void testGet_E_SetQuantidade() {

        Produto produto = new Produto();

        assertTrue(produto.setQuantidade(2));
        assertEquals(2, produto.getQuantidade());

        assertFalse(produto.setQuantidade(0));
        assertEquals(1, produto.getQuantidade());

        assertTrue(produto.setQuantidade(1));
        assertEquals(1, produto.getQuantidade());

    }

    @Test
    void testGet_E_SetUltimoValor() {
        Produto produto = new Produto();

        assertTrue(produto.setUltimoValor(12));
        assertEquals(12, produto.getUltimoValor());

        assertTrue(produto.setUltimoValor(0));
        assertEquals(0, produto.getUltimoValor());

        assertFalse(produto.setUltimoValor(-2));
        assertEquals(0, produto.getUltimoValor());



    }

    @Test
    void testGet_E_SetValorMaximoParaPagar() {
        Produto produto = new Produto();

        assertTrue(produto.setValorMaximoParaPagar(120));
        assertEquals(120, produto.getValorMaximoParaPagar());

        assertTrue(produto.setValorMaximoParaPagar(0));
        assertEquals(0, produto.getValorMaximoParaPagar());

        assertFalse(produto.setValorMaximoParaPagar(-1));
        assertEquals(0, produto.getValorMaximoParaPagar());
    }

}
