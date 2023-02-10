import java.util.Scanner;

public class ex2novo {

    public static void main(String[] args) {

        int[] vetorInteiros = new int[2];
        preencheVetor(vetorInteiros);
        printVetor(somarVetorInteiros(vetorInteiros));
    }

    private static void preencheVetor(int[] vetorInteiros) {
        // entrada scanner
        Scanner entrada = new Scanner(System.in);

        for (int i = 0; i < vetorInteiros.length; i++) {

            System.out.println("Digite o valor da posicao " + (i + 1) + ":");
            int entradaInteiros = entrada.nextInt();

            vetorInteiros[i] = entradaInteiros;
        }

        System.out.println("\n");
        // fechando entrada pq o vscode reclama
        entrada.close();
    }

    private static int[] somarVetorInteiros(int[] vetorInteiros) {

        int tamanhoVetor = vetorInteiros.length / 2; // tamanho do vetor mais legivel
        int[] soma = new int[tamanhoVetor];

        for (int i = 0; i < tamanhoVetor; i++) { // cont => 0,1,2
            soma[i] = vetorInteiros[2 * i + 1] + vetorInteiros[2 * i]; // soma => 0[]1[]]2[]
        }

        if(vetorInteiros.length % 2 == 1){ // erro
            soma[soma.length - 1] = vetorInteiros[tamanhoVetor - 1] + vetorInteiros[tamanhoVetor - 1];
        }

        return soma;
    }

    public static void printVetor(int[] vetor) {

        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }

    }

}
