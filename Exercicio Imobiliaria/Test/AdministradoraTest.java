package Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import Class.Administradora;
import Class.Apartamento;
import Class.Casa;
import Class.Proprietario;

public class AdministradoraTest {

    @Test
    void testGetQuantidadePropietarios() {

        Administradora adm = new Administradora();
        assertEquals(0, adm.getQuantidadePropietarios());

        adm.adicionarProprietario(312, "zapzap");
        assertEquals(1, adm.getQuantidadePropietarios());

    }

    @Test
    void testAdicionarProprietario() {
        Administradora adm = new Administradora();

        Proprietario p1 = new Proprietario(123456789, "João tiro quente");
        Proprietario p2 = new Proprietario(123456789, "Pedrinho fortnite");
        Proprietario p3 = new Proprietario(123456789, "Lulu da viola");

        adm.adicionarProprietario(p1);
        assertEquals(1, adm.getQuantidadePropietarios());

        adm.adicionarProprietario(p2);
        adm.adicionarProprietario(p3);
        assertEquals(3, adm.getQuantidadePropietarios());

    }

    @Test
    void testCalcularValorTotalProprietarios() {
        // lista de entrada de valores extras do imovel
        ArrayList<String> listinha = new ArrayList<String>();

        // adm 
        Administradora adm = new Administradora();
        
        // proprietarios
        Proprietario p1 = new Proprietario(123456789, "João tiro quente");
        Proprietario p2 = new Proprietario(123456789, "Matheus ser iluminado");

        // proprietarios sendo adicionados em adm
        adm.adicionarProprietario(p1);
        adm.adicionarProprietario(p2);

        // teste de valor total tem que ser 0
        assertEquals(adm.valorTotalProprietarios(), 0);

        // criando apartamentos
        
        Apartamento ap1 = new Apartamento(200000, null, 2000, 1000, listinha); // valor total disso 1640

        // adicionando imoveis em proprietario
        p1.adicionarApartamento(ap1);
        p2.adicionarApartamento(ap1);

        // cada ap adicionado vale 1640 
        // foram adicionados 2 apartamentos 
        // 1640 x 2 = 3280
        // valor dos 0.12 de comissao = 393,6

        assertEquals(adm.valorTotalProprietarios(), 393.6, 0.001); // deu certim

    } 
    
    @Test
    void testCalcularValorTotalProprietarios_CASA_APARTAMENTO() {
        // lista de entrada de valores extras do imovel
        ArrayList<String> listinha = new ArrayList<String>();

        // adm 
        Administradora adm = new Administradora();
        
        // proprietarios
        Proprietario p1 = new Proprietario(123456789, "João tiro quente");
        Proprietario p2 = new Proprietario(123456789, "Matheus ser iluminado");

        // proprietarios sendo adicionados em adm
        adm.adicionarProprietario(p1);
        adm.adicionarProprietario(p2);

        // teste de valor total tem que ser 0
        assertEquals(adm.valorTotalProprietarios(), 0);

        // criando apartamentos e casas
        
        Apartamento ap1 = new Apartamento(200000, null, 2000, 1000, listinha); // valor total disso 1640
        Casa casa1 = new Casa(200000, "Rua Teste 1", 3, 120, listinha); // valor disso 920

        // adicionando imoveis em proprietario
        p1.adicionarApartamento(ap1);
        p2.adicionarApartamento(ap1);

        p1.adicionarCasa(casa1);
        p2.adicionarCasa(casa1);


        // cada ap adicionado vale 1640  e cada casa vale 920
        // foram adicionados 2 apartamentos e 2 casas 
        // 1640 x 2 = 3280 & 710 x 2 = 1420 
        // valor total bruto foi de 4.700
        // valor dos 0.13 de comissao = 564
        adm.valorTotalProprietarios();

        assertEquals(adm.valorTotalProprietarios(), 564, 0.001); // deu certim

    }

}
