public class ListaCompras {

    private static int ID_PRODUTO = 0;
    private static double VALOR_TOTAL_DESEJADO = 0;
    private static double VALOR_TOTAL_ATUAL = 0;
    private static double VALOR_TETO_MAXIMO_LISTA = 0;

    private Produto[] produtos = new Produto[50];
    private boolean limitarTetoMaximo = false;

    /**
     * Inclui novos produtos no Array de objetos Produto[] com capacidade de ate 50
     * produtos.
     * 
     * @param ultimoValorProduto valor do produto na ultima compra.
     * @param valorMaximoProduto valor maximo que ira pagar no produto nessa compra.
     * @param quantidadeProdutos quantidade de produtos.
     * @return
     *         Retorna int 1 se a lista nao tenha teto maximo definido.
     *         Retorna int 2 se a lista tenha teto maximo definido e preco do valor
     *         total atual ainda não ultrapassou o teto mais de uma vez.
     *         Retorna int 3 se a lista tenha teto maximo definido e preco do valor
     *         total atual ja ultrassou o teto mais de uma vez.
     */
    public int incluirProduto(double ultimoValorProduto, double valorMaximoProduto, int quantidadeProdutos) {

        if (this.limitarTetoMaximo) {

            if (VALOR_TOTAL_ATUAL <= VALOR_TETO_MAXIMO_LISTA) {

                criarProdutos(ultimoValorProduto, valorMaximoProduto, quantidadeProdutos);

                return 2;

            } else {

                return 3;

            }

        } else {

            criarProdutos(ultimoValorProduto, valorMaximoProduto, quantidadeProdutos);

            return 1;

        }

    }

    public void criarProdutos(double ultimoValorProduto, double valorMaximoProduto, int quantidadeProdutos) {
        produtos[ID_PRODUTO] = new Produto();

        this.produtos[ID_PRODUTO].setQuantidade(quantidadeProdutos);
        this.produtos[ID_PRODUTO].setUltimoValor(ultimoValorProduto);
        this.produtos[ID_PRODUTO].setValorMaximoParaPagar(valorMaximoProduto);

        calcularValorMaximoEstimado();
        calcularValorTotalCompra();

        ID_PRODUTO++;
    }

    private void calcularValorMaximoEstimado() {

        VALOR_TOTAL_DESEJADO += (this.produtos[ID_PRODUTO].getValorMaximoParaPagar()
                * this.produtos[ID_PRODUTO].getQuantidade());

    }

    private void calcularValorTotalCompra() {

        VALOR_TOTAL_ATUAL += (this.produtos[ID_PRODUTO].getUltimoValor()
                * this.produtos[ID_PRODUTO].getQuantidade());

    }

    /**
     * Adiciona valor a constante VALOR_TETO_MAXIMO_LISTA.
     * Retorna true caso o valor seja valido (valorMaximoTeto >= 0)
     * e false caso seja invalido.
     * 
     * @param valorMaximoTeto valor maximo que ira ser definido como teto.
     * @return boolean
     * 
     */
    public boolean setVALOR_TETO_MAXIMO_LISTA(double valorMaximoTeto) {

        if (valorMaximoTeto >= 0) {
            VALOR_TETO_MAXIMO_LISTA = valorMaximoTeto;
            return true;
        } else {
            VALOR_TETO_MAXIMO_LISTA = 0;
            return false;
        }

    }

    public void setLimitarTetoMaximo(boolean limitacao) {
        this.limitarTetoMaximo = limitacao;
    }

    /**
     * Retorna a constante VALOR_TOTAL_DESEJADO.
     * 
     * @return double
     */
    public double getVALOR_TOTAL_DESEJADO() {
        return VALOR_TOTAL_DESEJADO;
    }

    /**
     * Retorna a constante VALOR_TOTAL_ATUAL.
     * 
     * @return double
     */
    public double getVALOR_TOTAL_ATUAL() {
        return VALOR_TOTAL_ATUAL;
    }
}