package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Class.Casa;

public class ImovelCasaTest {

    @Test
    void testValorInicialAluguel() {
        ArrayList<String> listinha = new ArrayList<String>();
        listinha.add("PiSCina");
        listinha.add("Garagem");

        Casa casa = new Casa(200000, "Rua Teste 1", 1000, 120, listinha);
        assertEquals(casa.getValorInicialAluguel(), 1300, 0.001);

    }

    @Test
    void testValorTotalAluguel() {
        ArrayList<String> listinha = new ArrayList<String>();
        listinha.add("PiSCina");
        listinha.add("Garagem");

        Casa casa = new Casa(200000, "Rua Teste 1", 3, 120, listinha);
        assertEquals(casa.getValorTotalAluguel(), 920, 0.001);
    }

}
