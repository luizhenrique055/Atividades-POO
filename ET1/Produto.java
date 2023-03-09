public class Produto {

    private int quantidade = 1;
    private double valorUltimaCompra = 0;
    private double valorMaximoDesejado = 0;

    /**
     * Atribui valor a variavel valorUltimaCompra
     * Se o valor for valido (ultimoValorCompra >= 0)
     * retorna true, caso invalido retorna false
     * 
     * @param ultimoValorCompra ultimo valor do produto comprado.
     * @return boolean
     */
    public boolean setUltimoValor(double ultimoValorCompra) {
        if (ultimoValorCompra >= 0) {
            this.valorUltimaCompra = ultimoValorCompra;
            return true;
        } else {
            this.valorUltimaCompra = 0;
            return false;
        }
    }

    /**
     * Atribui valor a variavel valorMaximoDesejado
     * Se o valor for valido (valorMaximoDesejado >= 0)
     * retorna true, caso invalido retorna false
     * 
     * @param valorMaximoDesejado valor maximo que ira pagar no produto.
     * @return boolean
     */
    public boolean setValorMaximoParaPagar(double valorMaximoDesejado) {
        if (valorMaximoDesejado >= 0) {
            this.valorMaximoDesejado = valorMaximoDesejado;
            return true;
        } else {
            this.valorMaximoDesejado = 0;
            return false;
        }
    }

    /**
     * Atribui valor a variavel quantidadeProdutos
     * Se o valor for valido (quantidadeProdutos > 0)
     * retorna true, caso invalido retorna false
     * 
     * @param quantidadeProdutos quantidade de produtos.
     * @return boolean
     */
    public boolean setQuantidade(int quantidadeProdutos) {
        if (quantidadeProdutos > 0) {
            this.quantidade = quantidadeProdutos;
            return true;
        } else {
            this.quantidade = 1;
            return false;
        }
    }

    /**
     * Retorna o valor de valorUltimaCompra
     */
    public double getUltimoValor() {
        return this.valorUltimaCompra;
    }

    /**
     * Retorna o valor de valorMaximoDesejado
     *
     */
    public double getValorMaximoParaPagar() {
        return this.valorMaximoDesejado;
    }

    /**
     * Retorna o valor de quantidade
     *
     */
    public int getQuantidade() {
        return this.quantidade;
    }

}
