package Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Class.Proprietario;

public class ProprietarioTest {

    private Proprietario proprietario;

    @Before
    public void setUp() {
        proprietario = new Proprietario(155, "jose");
    }

    @Test
    public void testAdicionarApartamento() {
        ArrayList<String> listaDeExtras = new ArrayList<String>();
        listaDeExtras.add("piscina");
        listaDeExtras.add("garagem");
        proprietario.adicionarApartamento(500000, "Rua Teste, 123", 2020, 500, listaDeExtras);
        assertEquals(1, proprietario.getQuantidadeImoveis());
    }

    @Test
    public void testCalcularValorBrutoAlugueis() {
        ArrayList<String> listaDeExtras1 = new ArrayList<String>();
        proprietario.adicionarApartamento(500000, "Rua Teste, 123", 2023, 500, listaDeExtras1); // 2500
        ArrayList<String> listaDeExtras2 = new ArrayList<String>();
        proprietario.adicionarApartamento(600000, "Avenida Teste, 456", 2023, 600, listaDeExtras2);
        assertEquals(5500, proprietario.getValorBrutoAlugueis(), 0.01);
    }

    @Test
    public void testCalcularValorBrutoAlugueisComEXTRAS() {
        ArrayList<String> listaDeExtras1 = new ArrayList<String>();
        listaDeExtras1.add("PiSCina");
        listaDeExtras1.add("Garagem");
        proprietario.adicionarApartamento(500000, "Rua Teste, 123", 2023, 500, listaDeExtras1); // 3100
        ArrayList<String> listaDeExtras2 = new ArrayList<String>();
        proprietario.adicionarApartamento(600000, "Avenida Teste, 456", 2023, 600, listaDeExtras2);// 3000
        assertEquals(6100, proprietario.getValorBrutoAlugueis(), 0.01);
    }

    @Test
    public void testCalcularValorComissaoAdiministradora() {
        ArrayList<String> listaDeExtras1 = new ArrayList<String>();
        proprietario.adicionarApartamento(500000, "Rua Teste, 123", 2023, 500, listaDeExtras1); // 2500
        ArrayList<String> listaDeExtras2 = new ArrayList<String>();
        proprietario.adicionarApartamento(600000, "Avenida Teste, 456", 2023, 600, listaDeExtras2); // 3000
        assertEquals(660, proprietario.getValorComissaoAdm(), 0.01);
    }

    @Test
    public void testCalcularValorComissaoAdiministradoraComValoresExtrasNoAp() {
        ArrayList<String> listaDeExtras1 = new ArrayList<String>(); // 0.3
        listaDeExtras1.add("PiSCina");
        listaDeExtras1.add("Garagem");
        proprietario.adicionarApartamento(500000, "Rua Teste, 123", 2023, 500, listaDeExtras1); // 3100
        ArrayList<String> listaDeExtras2 = new ArrayList<String>();
        proprietario.adicionarApartamento(600000, "Avenida Teste, 456", 2023, 600, listaDeExtras2); // 3000
        assertEquals(732, proprietario.getValorComissaoAdm(), 0.01);
    }

    @Test
    public void testCalcularValorComissaoAdiministradoraComValoresExtrasNoApEmDuasListas() {
        ArrayList<String> listaDeExtras1 = new ArrayList<String>(); // 0.3
        listaDeExtras1.add("PiSCina");
        listaDeExtras1.add("Garagem");
        proprietario.adicionarApartamento(500000, "Rua Teste, 123", 2023, 500, listaDeExtras1); // 3100
        ArrayList<String> listaDeExtras2 = new ArrayList<String>();
        listaDeExtras2.add("PiSCina");
        listaDeExtras2.add("Garagem");
        proprietario.adicionarApartamento(600000, "Avenida Teste, 456", 2023, 600, listaDeExtras2); // 3000
        assertEquals(818.4, proprietario.getValorComissaoAdm(), 0.01);
    }

    @Test
    public void testCalcularValorLiquidoAlugueisComEXTRAS() {
        ArrayList<String> listaDeExtras1 = new ArrayList<String>();
        listaDeExtras1.add("PiSCina");
        listaDeExtras1.add("Garagem");
        proprietario.adicionarApartamento(500000, "Rua Teste, 123", 2023, 500, listaDeExtras1); // 3100
        ArrayList<String> listaDeExtras2 = new ArrayList<String>();
        proprietario.adicionarApartamento(600000, "Avenida Teste, 456", 2023, 600, listaDeExtras2);// 3000
        assertEquals(5368, proprietario.getValorLiquidoAlugueis(), 0.01);
    }

}
