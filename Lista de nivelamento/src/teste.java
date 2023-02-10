

import java.util.Scanner;

public class teste {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Informe o tamanho do vetor: ");
        int size = sc.nextInt();
        int[] original = readVector(size, sc);
        int[] sum = sumVector(original);
        printVector(sum);
    }

    private static int[] readVector(int size, Scanner sc) {
        int[] vector = new int[size];
        for (int i = 0; i < size; i++) {
            System.out.print("Informe o elemento " + (i + 1) + ": ");
            vector[i] = sc.nextInt();
        }
        return vector;
    }

    private static int[] sumVector(int[] original) {
        int size = original.length;
        int[] sum = new int[(size + 1) / 2];
        for (int i = 0; i < size / 2; i++) {
            sum[i] = original[2 * i] + original[2 * i + 1];
        }
        if (size % 2 != 0) {
            sum[sum.length - 1] = original[size - 1] + original[size - 1];
        }
        return sum;
    }

    private static void printVector(int[] vector) {
        System.out.print("Resultado: [ ");
        for (int i = 0; i < vector.length; i++) {
            System.out.print(vector[i] + " ");
        }
        System.out.println("]");
    }
}
