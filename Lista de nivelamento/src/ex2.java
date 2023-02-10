// import java.util.Scanner;

// public class ex2 {
//     public static void main(String[] args) {

//         int[] vetorInteiros = new int[6];
//         // preenche a variavel vetoresInteiros
//         preencheVetor(vetorInteiros);
//         vetorSomas(vetorInteiros);
        
//     }

//     private static void preencheVetor(int[] vetorInteiros) {
//         // entrada scanner
//         Scanner entrada = new Scanner(System.in);

//         for (int i = 0; i < vetorInteiros.length; i++) {

//             System.out.println("Digite o valor da posicao " + (i + 1) + ":");
//             int entradaInteiros = entrada.nextInt();

//             vetorInteiros[i] = entradaInteiros;
//         }

//         // fechando entrada pq o vscode reclama
//         entrada.close();
//     }

//     public static void vetorSomas(int[] vetorOriginal) {
//         int[] vetorSomas = new int[vetorOriginal.length + 1 / 2];
//         System.out.println("Valor do vetor original: " + vetorOriginal.length);
//         System.out.println("Valor do vetor pirata: " + vetorSomas.length);

//         if (vetorOriginal.length % 2 == 0) {

//             for (int i = 0; i < vetorSomas.length; i += 2) {
//                 vetorSomas[i / 2] = vetorOriginal[i] + vetorOriginal[i + 1];
//             }

//             for (int i = 0; i < vetorSomas.length; i++) {
//                 System.out.println("Valor do vetor soma posição " + (i + 1) + ": " + vetorSomas[i]);
//             }

//         }

//     }

// }
