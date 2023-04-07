package Class;

import java.util.LinkedList;

public class Administradora {

    private int quantidadePropietarios;
    private LinkedList<Proprietario> listaProprietarios = new LinkedList<Proprietario>();

    public Administradora() {
        this.quantidadePropietarios = 0;
    }

    public void adicionarProprietario(int cpf, String nome) {
        listaProprietarios.add(quantidadePropietarios, new Proprietario(cpf, nome));
        this.quantidadePropietarios++;
    }

    public void adicionarProprietario(Proprietario x) {
        listaProprietarios.add(quantidadePropietarios, x);
        this.quantidadePropietarios++;
    }

    public double valorTotalProprietarios() {
        double valorTotal = 0;
        for (Proprietario proprietario : listaProprietarios) {
            valorTotal += proprietario.getValorComissaoAdm();
        }
        return valorTotal;
    }

    public int getQuantidadePropietarios() {
        return quantidadePropietarios;
    }

}
