public class ListaCompras {

    private static int ID_PRODUTO = 0;
    private Produto[] produtos;
    private double valorMaximoCompra = 0;
    private double valorTotalCompra = 0;
    private double valorTetoMaximo = 0;
    private boolean limitarTetoMaxio = false;

    public int incluirProduto(double ultimoValorProduto, double valorMaximoProduto, int quantidadeProdutos) {

        if (this.limitarTetoMaxio) {
            if (verificarTetoMaximo()) {
                // COD REPETIDO
                this.produtos[ID_PRODUTO] = new Produto();

                this.produtos[ID_PRODUTO].setQuantidade(quantidadeProdutos);
                this.produtos[ID_PRODUTO].setUltimoValor(ultimoValorProduto);
                this.produtos[ID_PRODUTO].setValorMaximoParaPagar(valorMaximoProduto);

                calcularValorMaximoCompra();
                calcularValorTotalCompra();

                ID_PRODUTO++;

                return 2;
            } else {

                return 3;

            }

        } else {

            this.produtos[ID_PRODUTO] = new Produto();

            this.produtos[ID_PRODUTO].setQuantidade(quantidadeProdutos);
            this.produtos[ID_PRODUTO].setUltimoValor(ultimoValorProduto);
            this.produtos[ID_PRODUTO].setValorMaximoParaPagar(valorMaximoProduto);

            calcularValorMaximoCompra();
            calcularValorTotalCompra();

            ID_PRODUTO++;

            return 1;
        }
    }

    private void calcularValorMaximoCompra() {
        for (int i = 0; i < produtos.length; i++) {
            this.valorMaximoCompra += produtos[i].getValorMaximoParaPagar();
        }
    }

    private void calcularValorTotalCompra() {
        for (int i = 0; i < produtos.length; i++) {
            this.valorTotalCompra += produtos[i].getUltimoValor();
        }
    }

    private boolean verificarTetoMaximo() {
        if (valorTetoMaximo <= this.valorTotalCompra) {
            return true;
        } else {
            return false;
        }
    }

    // private void vaiLimitarTetoMaximo(boolean limitacao) {
    //     this.limitarTetoMaxio = limitacao;
    // }

    public double getValorMaximoCompra() {
        return this.valorMaximoCompra;
    }

    public double getValorTotalCompra() {
        return this.valorTotalCompra;
    }
}
