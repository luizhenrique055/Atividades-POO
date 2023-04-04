package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import Class.Apartamento;

public class ImovelApartamentoTest {

    @Test
    void testValorInicialAluguel() {
        Apartamento ap = new Apartamento(200000, null, 0, 0);
        assertEquals(ap.getValorInicialAluguel(), 800);
    }

    @Test
    void testValorTotalAluguel() {
        Apartamento ap = new Apartamento(200000, null, 2000, 1000);
        assertEquals(ap.getValorTotalAluguel(), 1640);
    }
}
