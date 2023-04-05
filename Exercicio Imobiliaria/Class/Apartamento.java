package Class;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Apartamento extends Imovel {

    // atributos apartamento
    private static final int TAXA_DESCONTO_IDADE = 5;
    private static final double TAXA_VALOR_INICIAL = 0.004;
    private double taxaMensalCondominio;

    // construtor
    public Apartamento(double valorDeVenda, String enderecoImovel, int anoConstrucao, double taxaMensalCondominio,
            ArrayList<String> stringDeExtras) {
        super(valorDeVenda, enderecoImovel, anoConstrucao, stringDeExtras);

        if (taxaMensalCondominio >= 0) {
            this.taxaMensalCondominio = taxaMensalCondominio;
        } else {
            this.taxaMensalCondominio = 0;
        }

        valorInicialAluguel();
        valorTotalAluguel();
    }

    // metodos sobrescritos
    @Override
    protected void valorInicialAluguel() {
        double total = getValorDeVenda() * TAXA_VALOR_INICIAL;
        double acrescimos = total * getValorAcrescimos();

        setValorInicialAluguel(total + acrescimos);
    }

    @Override
    protected void valorTotalAluguel() {
        setValorTotalAluguel((taxaMensalCondominio + getValorInicialAluguel()) - precoDescontoDeIdade());
    }

    @Override
    protected double precoDescontoDeIdade() {

        int quoeficienteIdadeAp = (getAnoAtual() - getAnoConstrucao()) / TAXA_DESCONTO_IDADE;

        Map<Integer, Double> mapDescontoPorIdade = new HashMap<Integer, Double>();
        mapDescontoPorIdade.put(0, 0d);
        mapDescontoPorIdade.put(1, 0.05);
        mapDescontoPorIdade.put(2, 0.1);
        mapDescontoPorIdade.put(3, 0.15);
        mapDescontoPorIdade.put(4, 0.2);
        mapDescontoPorIdade.put(5, 0.25);
        mapDescontoPorIdade.put(6, 0.3);

        if (mapDescontoPorIdade.containsKey(quoeficienteIdadeAp)) {
            return getValorInicialAluguel() * mapDescontoPorIdade.get(quoeficienteIdadeAp);
        } else {
            return getValorInicialAluguel() * 0.3;
        }

    }

}
