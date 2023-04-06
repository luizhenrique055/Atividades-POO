package Class;

import java.util.ArrayList;

public class Proprietario {

    private final double PORCENTAGEM_ADM = 0.12;
    private int quantidadeImoveis;
    private ArrayList<Imovel> listaImoveis = new ArrayList<Imovel>();
    private int cpf;
    private String nome;
    private double valorComissaoAdm;
    private double valorBrutoAlugueis;
    private double valorLiquidoAlugueis;

    // #region construtor

    public Proprietario(int cpf, String nome) {

        if (cpf > 0) {
            this.cpf = cpf;
        } else {
            this.cpf = 0;
        }

        this.nome = nome;
        this.valorComissaoAdm = 0;
        this.valorBrutoAlugueis = 0;
        this.valorLiquidoAlugueis = 0;

    }

    // #endregion

    // #region metodos

    public void adicionarApartamento(double valorDeVenda, String enderecoImovel, int anoConstrucao,
            double taxaMensalCondominio, ArrayList<String> listaDeExtras) {

        this.listaImoveis.add(this.quantidadeImoveis,
                new Apartamento(valorDeVenda, enderecoImovel, anoConstrucao, taxaMensalCondominio, listaDeExtras));

        this.quantidadeImoveis++;

        atualizarDados();

    }

    private void calcularValorBrutoAlugueis() {

        double total = 0;

        for (Imovel imovel : listaImoveis) {
            total += imovel.getValorTotalAluguel();
        }

        this.valorBrutoAlugueis = total;

    }

    private void calcularValorLiquidoAlugueis() {
        this.valorLiquidoAlugueis = this.valorBrutoAlugueis - this.valorComissaoAdm;
    }

    private void calcularComissaoAdiministradora() {
        this.valorComissaoAdm = this.valorBrutoAlugueis * PORCENTAGEM_ADM;
    }

    private void atualizarDados() {
        // atualizacao de dados deve ser chamada nessa ordem
        calcularValorBrutoAlugueis(); // valor de todos alugueis
        calcularComissaoAdiministradora(); // valor da comissao de todos alugueis
        calcularValorLiquidoAlugueis(); // todos alugueis menos comissao

    }

    // #endregion

    // #region getters e setters

    public double getValorBrutoAlugueis() {
        return valorBrutoAlugueis;
    }

    public double getValorLiquidoAlugueis() {
        return valorLiquidoAlugueis;
    }

    public double getValorComissaoAdm() {
        return valorComissaoAdm;
    }

    public int getQuantidadeImoveis() {
        return quantidadeImoveis;
    }

    public int getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    // #endregion
}
