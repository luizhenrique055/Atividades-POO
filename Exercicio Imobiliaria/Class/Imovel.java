package Class;

import java.util.Calendar;

public abstract class Imovel {

    private static final double DESCONTO_MAXIMO = 0.3;
    private double valorTotalAluguel = 0;
    private double valorInicialAluguel = 0;
    // private double valorAcrescimos = 0;
    private double valorDeVenda;
    private String enderecoImovel;
    private int anoConstrucao;
    private int anoAtual;

    /**
     * Construtor de imovel. Caso valorDeVenda seja menor que 0 ira ser definido
     * automaticamente para 0.
     * 
     * @param valorDeVenda   double
     * @param enderecoImovel String
     * @param anoConstrucao  int (yyyy)
     */
    Imovel(double valorDeVenda, String enderecoImovel, int anoConstrucao) {

        if (valorDeVenda >= 0) {
            this.valorDeVenda = valorDeVenda;
        } else {
            this.valorDeVenda = 0d;
        }

        this.enderecoImovel = enderecoImovel;

        this.anoConstrucao = anoConstrucao;

        Calendar cal = Calendar.getInstance();
        this.anoAtual = cal.get(Calendar.YEAR);

    }

//#region metodos virtuais

    protected abstract void valorTotalAluguel();

    protected abstract void valorInicialAluguel();

    /**
     * Ira retornar o valor preco do desconto.
     * 
     * @return double
     */
    protected abstract double precoDescontoDeIdade();

//#endregion

//#region getters and setters 

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

    // public double getValorAcrescimos() {
    //     return valorAcrescimos;
    // }

    // public void setValorAcrescimos(double valorAcrescimos) {
    //     this.valorAcrescimos = valorAcrescimos;
    // }

    public void setValorTotalAluguel(double valorTotalAluguel) {
        this.valorTotalAluguel = valorTotalAluguel;
    }

    public void setValorInicialAluguel(double valorInicialAluguel) {
        this.valorInicialAluguel = valorInicialAluguel;
    }
//#endregion
}