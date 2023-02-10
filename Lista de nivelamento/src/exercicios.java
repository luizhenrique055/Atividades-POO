import java.util.Scanner;
import java.util.StringTokenizer;

public class exercicios {

    /*
     * 
     * Algumas atividades utilizando o mesmo metodo que a atividade anterior
     * 
     */

    // atividade 1
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

    private static void inveterVetor(int[] vetorInteiros) {
        // for decrescente
        for (int i = vetorInteiros.length - 1; i >= 0; i--) {
            System.out.println(vetorInteiros[i]);
        }
    }

    // atividade 2
    private static int[] somarVetorInteiros(int[] vetorInteiros) {

        int tamanhoVetor = vetorInteiros.length / 2; // tamanho do vetor mais legivel
        int[] soma = new int[tamanhoVetor];

        for (int i = 0; i < tamanhoVetor; i++) { // cont => 0,1,2
            soma[i] = vetorInteiros[2 * i + 1] + vetorInteiros[2 * i]; // soma => 0[]1[]]2[]
        }

        if (vetorInteiros.length % 2 == 1) { // erro
            soma[soma.length - 1] = vetorInteiros[tamanhoVetor - 1] + vetorInteiros[tamanhoVetor - 1];
        }

        return soma;
    }

    public static void printVetor(int[] vetor) {

        for (int i = 0; i < vetor.length; i++) {
            System.out.println(vetor[i]);
        }

    }

    // atividade 3
    public static boolean verificaAnoBissexto(int ano) {
        // verificacao anoBisexto
        // se o ano for maior que 400
        if (ano % 400 == 0) {
            return true;
        } else if ((ano % 4 == 0) && (ano % 100 != 0)) {
            return true;
        } else {
            return false;
        }
    }

    public static void verificacaoData(String dataInserida) {
        StringTokenizer tokenizer = new StringTokenizer(dataInserida, "/");

        while (tokenizer.hasMoreTokens()) {

            int dia = Integer.parseInt(tokenizer.nextToken());
            int mes = Integer.parseInt(tokenizer.nextToken());
            int ano = Integer.parseInt(tokenizer.nextToken());

            System.out.println(dia);
            System.out.println(mes);
            System.out.println(ano);

            // verificação ano
            if (ano > 0 && ano < 2024) {
                // verificacao mes
                if (mes > 1 && mes < 12) {
                    // verificacao dia em if
                    if (mes == 2) {

                        if (verificaAnoBissexto(ano)) {

                            if (dia > 1 && dia <= 29) {
                                System.out.println("Data Valida");
                            } else {
                                System.out.println("Erro: Dia invalido!");
                            }

                        } else if (dia > 1 && dia <= 28) {
                            System.out.println("Data Valida");
                        } else {
                            System.out.println("Erro: Dia invalido!");
                        }

                    } else if (mes == 4 || mes == 6 || mes == 9 || mes == 11) {

                        if (dia > 1 && dia <= 30) {
                            System.out.println("Data valida");
                        } else {
                            System.out.println("Erro: Dia invalido");

                        }

                    } else {

                        if (dia > 1 && dia <= 30) {
                            System.out.println("Data valida");
                        } else {
                            System.out.println("Erro: Dia invalido");

                        }

                    }

                } else {
                    System.out.println("Erro: Mes invalido");
                }
            } else {
                System.out.println("Erro: Ano invalido!");
            }

        }

    }

    // atividade 4
    public static void entradaData(String dataInserida) {

        StringTokenizer tokenizer = new StringTokenizer(dataInserida, "/");

        while (tokenizer.hasMoreTokens()) {

            int totalDias = 0;
            int dia = Integer.parseInt(tokenizer.nextToken());
            int mes = Integer.parseInt(tokenizer.nextToken());
            int ano = Integer.parseInt(tokenizer.nextToken());

            totalDias = totalDeDiasAteMes(mes, ano, dia);
            System.out.println(calculaDiaDaSemana(totalDias));

        }

    }

    public static String calculaDiaDaSemana(int totalDias) {
        int diaSemana = totalDias % 7;

        String stringDiaSemana = "";

        switch (diaSemana) {
            case 0:
                stringDiaSemana = "Sábado";
                break;
            case 1:
                stringDiaSemana = "Domingo";
                break;
            case 2:
                stringDiaSemana = "Segunda-feira";
                break;
            case 3:
                stringDiaSemana = "Terça-feira";
                break;
            case 4:
                stringDiaSemana = "Quarta-feira";
                break;
            case 5:
                stringDiaSemana = "Quinta-feira";
                break;
            case 6:
                stringDiaSemana = "Sexta-feira";
                break;
        }

        return stringDiaSemana;
    }

    public static int totalDeDiasAteMes(int mes, int ano, int dia) {
        int totalDias = 0;

        for (int i = 1; i <= mes; i++) {
            totalDias += diasNoMes(i, ano);
        }

        return (totalDias - dia);

    }

    public static int diasNoMes(int mes, int ano) {
        switch (mes) {
            // case 1,3,5,7,8,10,12 = 31 dias
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            // case 4,6,9,11 = 30 dias
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if (verificaAnoBissexto(ano)) {
                    return 29;
                } else {
                    return 28;
                }
                // erro
            default:
                return -1;
        }

    }

}
