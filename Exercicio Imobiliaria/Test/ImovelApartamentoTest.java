package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Class.Apartamento;

public class ImovelApartamentoTest {

    @Test
    void testValorInicialAluguelSemNadaNaLista() {

        ArrayList<String> listinha = new ArrayList<String>(); // o valor da listinha e 0
        Apartamento ap = new Apartamento(200000, null, 0, 0, listinha);

        assertEquals(ap.getValorInicialAluguel(), 800);
    }

    @Test
    void testValorTotalAluguelSemNadaNaLista() {

        ArrayList<String> x = new ArrayList<String>(); // o valor da listinha e 0.3

        Apartamento ap = new Apartamento(200000, null, 2000, 1000, x);
        assertEquals(ap.getValorTotalAluguel(), 1640);

    }

    @Test
    void testValorInicialAluguelComValorNaLista() {

        ArrayList<String> listinha = new ArrayList<String>(); // o valor da listinha e 0.3
        listinha.add("PiSCina");
        listinha.add("Garagem");

        Apartamento ap = new Apartamento(200000, null, 0, 0, listinha);

        assertEquals(ap.getValorInicialAluguel(), 1040);
    }

    @Test
    void testValorTotalAluguelComValorNaLista() {

        ArrayList<String> listinha = new ArrayList<String>(); // o valor da listinha e 0.3
        listinha.add("PiSCina");
        listinha.add("Garagem");

        Apartamento ap = new Apartamento(200000, null, 2000, 1000, listinha);
        assertEquals(ap.getValorTotalAluguel(), 1832);

    }

}
