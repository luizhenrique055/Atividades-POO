package Test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import Class.Apartamento;
import Class.Casa;
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
    public void testCalcularValorBrutoAlugueisComApartamento() {
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

    @Test
    public void testAdicionarCasa() {
        ArrayList<String> listaDeExtras = new ArrayList<String>();
        listaDeExtras.add("piscina");
        listaDeExtras.add("garagem");
        proprietario.adicionarCasa(200000, "Rua Teste, 123", 2020, 120, listaDeExtras);
        assertEquals(1, proprietario.getQuantidadeImoveis());
    }

    @Test
    public void testCalcularValorBrutoAlugueisComCasa() {
        ArrayList<String> listinha = new ArrayList<String>();
        listinha.add("PiSCina");
        listinha.add("Garagem");

        Casa casa1 = new Casa(200000, "Rua Teste 1", 3, 120, listinha); // 920
        Casa casa2 = new Casa(200000, "Rua Teste 2", 3, 120, listinha);// 920

        Proprietario proprietario = new Proprietario(21321, "Luiz H.");
        proprietario.adicionarCasa(casa1);
        proprietario.adicionarCasa(casa2);

        assertEquals(proprietario.getValorBrutoAlugueis(), 1840, 0.001);

    }

    @Test
    public void testCalcularValorLiquidoAlugueisComCasa() {
        ArrayList<String> listinha = new ArrayList<String>();
        listinha.add("PiSCina");
        listinha.add("Garagem");

        Casa casa1 = new Casa(200000, "Rua Teste 1", 3, 120, listinha); // 920
        Casa casa2 = new Casa(200000, "Rua Teste 2", 3, 120, listinha);// 920

        Proprietario proprietario = new Proprietario(21321, "Luiz H.");
        proprietario.adicionarCasa(casa1);
        proprietario.adicionarCasa(casa2);

        assertEquals(proprietario.getValorLiquidoAlugueis(), 1619.2, 0.001);

    }

    @Test
    public void testCalcularValorBruto_Casa_Apartamento() {
        ArrayList<String> listinha = new ArrayList<String>();
        listinha.add("PiSCina");
        listinha.add("Garagem");

        Casa casa1 = new Casa(200000, "Rua Teste 1", 3, 120, listinha); // 920

        Apartamento ap = new Apartamento(200000, null, 2000, 1000, listinha); // 1832

        Proprietario proprietario = new Proprietario(21321, "Luiz H.");

        proprietario.adicionarCasa(casa1);
        proprietario.adicionarApartamento(ap);

        assertEquals(proprietario.getValorBrutoAlugueis(), 2752, 0.001);

    }

    @Test
    public void testCalcularValorLiquido_Casa_Apartamento() {
        ArrayList<String> listinha = new ArrayList<String>();
        listinha.add("PiSCina");
        listinha.add("Garagem");

        Casa casa1 = new Casa(200000, "Rua Teste 1", 3, 120, listinha); // 920

        Apartamento ap = new Apartamento(200000, null, 2000, 1000, listinha); // 1832

        Proprietario proprietario = new Proprietario(21321, "Luiz H.");

        proprietario.adicionarCasa(casa1);
        proprietario.adicionarApartamento(ap);

        assertEquals(proprietario.getValorLiquidoAlugueis(), 2421.76, 0.001);

    }

}
