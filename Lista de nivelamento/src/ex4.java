import java.util.Scanner;
import java.util.StringTokenizer;

public class ex4 {
    public static void main(String[] args) {

        // entrada de dados
        Scanner entrada = new Scanner(System.in);
        System.out.println("Entre uma data valida no formato DD/MM/AAAA");
        String dataInserida = entrada.nextLine();

        entradaData(dataInserida);

        entrada.close();
    }

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