package Class;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Casa extends Imovel {

    private static final int NUMERO_DESCONTO_IDADE = 10;
    private static final double TAXA_VALOR_INICIAL = 0.005;
    private static final double PARCELAS_SEGURO_INCENDIO = 12;
    private double taxaSeguroIncendio;

    public Casa(double valorDeVenda, String enderecoImovel, int anoConstrucao, double taxaSeguroIncendio,
            ArrayList<String> listaDeExtras) {

        super(valorDeVenda, enderecoImovel, anoConstrucao, listaDeExtras, TAXA_VALOR_INICIAL);

        if (taxaSeguroIncendio > 0) {
            this.taxaSeguroIncendio = taxaSeguroIncendio;
        } else {
            this.taxaSeguroIncendio = 0;
        }

        valorInicialAluguel();
        valorTotalAluguel();

    }

    @Override
    protected void valorTotalAluguel() {

        double valorParcelas = this.taxaSeguroIncendio / PARCELAS_SEGURO_INCENDIO;

        setValorTotalAluguel((getValorInicialAluguel() + valorParcelas) - precoDescontoDeIdade());

    }

    @Override
    protected double precoDescontoDeIdade() {

        int quoeficienteIdadeAp = (getAnoAtual() - getAnoConstrucao()) / NUMERO_DESCONTO_IDADE;

        Map<Integer, Double> mapDescontoPorIdade = new HashMap<Integer, Double>();
        mapDescontoPorIdade.put(0, 0d);
        mapDescontoPorIdade.put(1, 0.1);
        mapDescontoPorIdade.put(2, 0.2);
        mapDescontoPorIdade.put(3, 0.3);

        if (mapDescontoPorIdade.containsKey(quoeficienteIdadeAp)) {
            return getValorInicialAluguel() * mapDescontoPorIdade.get(quoeficienteIdadeAp);
        } else {
            return getValorInicialAluguel() * 0.3;
        }

    }

}
