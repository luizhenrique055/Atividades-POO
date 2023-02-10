import java.util.Scanner;

public class ex1 {
    public static void main(String[] args) {
        // istanciando vetor
        int[] vetorInteiros = new int[6];
        // metodo static
        preencheVetor(vetorInteiros);
        inveterVetor(vetorInteiros);

    }

    private static void preencheVetor(int[] vetorInteiros) {
        // entrada scanner 
        Scanner entrada = new Scanner(System.in);

        for (int i = 0; i < vetorInteiros.length; i++) {

            System.out.println("Digite o valor da posicao " + (i + 1) + ":");
            int entradaInteiros = entrada.nextInt();

            vetorInteiros[i] = entradaInteiros;
        }

        // fechando entrada pq o vscode reclama
        entrada.close();
    }

    private static void inveterVetor(int[] vetorInteiros){
        // for decrescente 
        for(int i = vetorInteiros.length - 1; i >= 0; i--){
            System.out.println(vetorInteiros[i]);
        }
    }

}
