import java.util.Scanner;
import java.util.StringTokenizer;

public class ex3 {
    public static void main(String[] args) {
        // entrada de dados
        Scanner entrada = new Scanner(System.in);
        System.out.println("Entre uma data valida no formato DD/MM/AAAA");
        String dataInserida = entrada.nextLine();

        verificacaoData(dataInserida);

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

}
