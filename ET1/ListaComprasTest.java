
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ListaComprasTest {
    ListaCompras lista = new ListaCompras();

    @Test
    void testIncluirProduto() {

        assertEquals(1, lista.incluirProduto(20, 25, 1));

        lista.setVALOR_TETO_MAXIMO_LISTA(100);
        lista.setLimitarTetoMaximo(true);

        assertEquals(2, lista.incluirProduto(30, 40, 1));
        assertEquals(2, lista.incluirProduto(105, 40, 1)); // Ira aceitar ate um  valor acima do teto
        assertEquals(3, lista.incluirProduto(105, 40, 1));

    }

    @Test
    void setVALOR_TETO_MAXIMO_LISTA(){
        assertTrue(lista.setVALOR_TETO_MAXIMO_LISTA(0));
        assertFalse(lista.setVALOR_TETO_MAXIMO_LISTA(-1));
    }



}
