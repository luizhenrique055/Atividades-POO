import java.time.LocalDate;
import java.util.ArrayList;

class codigo implements Comparable{

    // Escrever um código a ser testado para o requisito de calcular o preço a pagar
    // por um cliente em um pedido;
    // Escrever um código a ser testado para o método do sistema que, a cada mês,
    // determina a categoria dos clientes;

    String dataAtual;
    Cliente tipoCliente;
    ArrayList<Cliente> listaDePedidoTotal = new ArrayList<Cliente>();
    ArrayList<Cliente> listaDePedidoMes = new ArrayList<Cliente>();
    int numPedidos30Dias = 0;
    int numPedidos60Dias = 0;
    String nome = ";";
    String CPF = ";";
    double valorBrutoUltimoPedido = 0d;
    double valorBrutoUltimoMes = 0d;
    double valorLiquidoUltimoPedido = 0d;
    double totalEconomizado = 0;

    public void calculaUltimoPedido() {

        // pega o valor total do ultimo pedido
        double precoPedido = this.valorBrutoUltimoPedido;

        // valor do desconto aplicado
        double valorDescontoAplicado = tipoCliente.calcularPorcentagemDesconto() * precoPedido;

        // aplica o desconto
        precoPedido -= valorDescontoAplicado;

        // adiciona na variavel o preco com descontos
        if (precoPedido < 0)
            this.valorLiquidoUltimoPedido = 0;

        this.valorLiquidoUltimoPedido = precoPedido;

    }

    public boolean verificaNovoMes() {

        LocalDate hj = LocalDate.now();

        int diaMes = hj.getDayOfMonth();

        if (diaMes == 1) {
            atualizarTipoCliente();
            return true;
        }

        return false;

    }

    public void atualizarTipoCliente() {

        if (valorBrutoUltimoMes >= 130 || numPedidos30Dias >= 10) {
            this.tipoCliente = new Cliente(Junior);
        } else if (valorBrutoUltimoMes >= 350 || numPedidos60Dias >= 30) {
            this.tipoCliente = new Cliente(Senior);
        } else {
            this.tipoCliente = new Cliente(Regular);
        }

    }

    // nada funciona
    // e apenas demonstracao teorica
}