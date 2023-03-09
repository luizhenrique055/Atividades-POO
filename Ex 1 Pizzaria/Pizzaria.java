public class Pizzaria {

    private static final int NUM_INGREDIENTES_MAX = 8;
    private static final double PIZZA_BASICA = 25.00;
    private static final double VALOR_INGREDIENTE_ADICIONAL = 4.00;
    private int numIngredientesAdicionais = 0;

    /***
     * Caso o numero de ingredientes for < que 0 ou > que NUM_INGREDIENTES_MAX
     * numero de ingredientes sera inicializado com 0.
     * @param numIngredientes quantidade de ingredientes adicionais
     */
    Pizzaria(int numIngredientesAdicionais) {
        inicializador(numIngredientesAdicionais);
    }

    private void inicializador(int numIngredientesAdicionais) {
        if (numIngredientesAdicionais <= NUM_INGREDIENTES_MAX && numIngredientesAdicionais >= 0) {
            this.numIngredientesAdicionais = numIngredientesAdicionais;
        } else {
            this.numIngredientesAdicionais = 0;
        }
    }

    public double calcularPrecoPedido() {
        return PIZZA_BASICA + (numIngredientesAdicionais * VALOR_INGREDIENTE_ADICIONAL);
    }

    public void gerarNotaFiscal() {
        System.out.println("Nota fiscal \n");
        System.out.println("Pizza basica \n");
        System.out.println("Quantidade de adicionais: " + this.numIngredientesAdicionais + "\n");
        System.out.println("Preço final: " + calcularPrecoPedido());
    }

  

}
