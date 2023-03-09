public class Produto {

    private int quantidade = 1;
    private double valorUltimaCompra = 0;
    private double valorMaximoDesejado = 0;

    public boolean setUltimoValor(double ultimoValorCompra) {
        if (ultimoValorCompra >= 0) {
            this.valorUltimaCompra = ultimoValorCompra;
            return true;
        } else {
            this.valorUltimaCompra = 0;
            return false;
        }
    }

    public boolean setValorMaximoParaPagar(double valorMaximoDesejado) {
        if (valorMaximoDesejado >= 0) {
            this.valorMaximoDesejado = valorMaximoDesejado;
            return true;
        } else {
            this.valorMaximoDesejado = 0;
            return false;
        }
    }

    public boolean setQuantidade(int quantidadeProdutos) {
        if (quantidadeProdutos > 0) {
            this.quantidade = quantidadeProdutos;
            return true;
        } else {
            this.quantidade = 1;
            return false;
        }
    }

    public double getUltimoValor() {
        return this.valorUltimaCompra;
    }

    public double getValorMaximoParaPagar() {
        return this.valorMaximoDesejado;
    }

    public int getQuantidade() {
        return this.quantidade;
    }

}
