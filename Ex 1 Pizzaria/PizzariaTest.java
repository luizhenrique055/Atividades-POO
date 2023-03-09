import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class PizzariaTest {

    @Test
    void testeCalcularPrecoPedido() {
        Pizzaria pizzaria = new Pizzaria(1);
        assertEquals(29, pizzaria.calcularPrecoPedido());
    }

}
