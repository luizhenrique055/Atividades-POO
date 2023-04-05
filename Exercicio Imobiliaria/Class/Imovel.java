package Class;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public abstract class Imovel {

    private static final double DESCONTO_MAXIMO = 0.3;
    private double valorTotalAluguel;
    private double valorInicialAluguel;
    private Map<String, Double> mapValoresExtras = new HashMap<String, Double>();
    private double valorAcrescimos;
    private double valorDeVenda;
    private String enderecoImovel;
    private int anoConstrucao;
    private int anoAtual;

    // #region construtores e inicializador

    /**
     * Construtor de imovel com lista de valores extras.
     * <p>
     * Caso valorDeVenda seja menor que 0, ira ser definido automaticamente para 0.
     * Caso a listaDeExtras seja vazia o valor de extras sera 0.
     * Caso anoConstrucao seja < 0, ira ser definido como 0.
     * </p>
     * 
     * @param valorDeVenda   double
     * @param enderecoImovel String
     * @param anoConstrucao  int (yyyy)
     * @param listaDeExtras  ArrayList<String>
     */
    Imovel(double valorDeVenda, String enderecoImovel, int anoConstrucao, ArrayList<String> listaDeExtras) {

        inicializador(valorDeVenda, enderecoImovel, anoConstrucao);

        if (!listaDeExtras.isEmpty()) {
            calcularValorExtras(listaDeExtras);
        }

    }

    /**
     * "Esse construtor foi necessario em uma versao anterior do codigo, existem
     * solucoes
     * melhores no codigo atual."
     * <p>
     * Caso valorDeVenda seja menor que 0, ira ser definido automaticamente para 0.
     * Caso anoConstrucao seja < 0, ira ser definido como 0.
     * </p>
     * 
     * @deprecated utilize a versão do construtor implementando a listaDeExtras.
     * @param valorDeVenda   double
     * @param enderecoImovel String
     * @param anoConstrucao  int (yyyy)
     */
    @Deprecated
    Imovel(double valorDeVenda, String enderecoImovel, int anoConstrucao) {

        inicializador(valorDeVenda, enderecoImovel, anoConstrucao);

    }

    private void inicializador(double valorDeVenda, String enderecoImovel, int anoConstrucao) {

        this.valorAcrescimos = 0;

        if (valorDeVenda >= 0) {
            this.valorDeVenda = valorDeVenda;
        } else {
            this.valorDeVenda = 0d;
        }

        if (anoConstrucao > 0) {
            this.anoConstrucao = anoConstrucao;
        } else {
            this.anoConstrucao = 0;
        }

        this.enderecoImovel = enderecoImovel;

        Calendar cal = Calendar.getInstance();
        this.anoAtual = cal.get(Calendar.YEAR);

        mapValoresExtras.put("piscina", 0.2);
        mapValoresExtras.put("areaLazer", 0.05);
        mapValoresExtras.put("garagem", 0.1);
        mapValoresExtras.put("elevador", 0.15);

    }
    // #endregion

    // #region metodos

    // metodos virtuais
    protected abstract void valorTotalAluguel();

    protected abstract void valorInicialAluguel();

    /**
     * Retorna o valor do preço de desconto da idade do imovel.
     * 
     * @return double (ValorTotalImovel * descontoDaIdade)
     */
    protected abstract double precoDescontoDeIdade();

    // metodos nao virtuais

    private void calcularValorExtras(ArrayList<String> listaDeExtras) {

        this.valorAcrescimos = 0;

        for (String valorStringAtual : listaDeExtras) {
            this.valorAcrescimos += mapValoresExtras.get(valorStringAtual.toLowerCase());
        }

    }

    // #endregion

    // #region getters and setters

    public double getValorDeVenda() {
        return valorDeVenda;
    }

    public String getEnderecoImovel() {
        return enderecoImovel;
    }

    public int getAnoConstrucao() {
        return anoConstrucao;
    }

    public int getAnoAtual() {
        return anoAtual;
    }

    public static double getDescontoMaximo() {
        return DESCONTO_MAXIMO;
    }

    public double getValorInicialAluguel() {
        return valorInicialAluguel;
    }

    public double getValorTotalAluguel() {
        return valorTotalAluguel;
    }

    public double getValorAcrescimos() {
        return valorAcrescimos;
    }

    public void setValorTotalAluguel(double valorTotalAluguel) {
        this.valorTotalAluguel = valorTotalAluguel;
    }

    public void setValorInicialAluguel(double valorInicialAluguel) {
        this.valorInicialAluguel = valorInicialAluguel;
    }
    // #endregion
}