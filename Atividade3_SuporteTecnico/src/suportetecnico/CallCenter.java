package suportetecnico;

import java.util.HashSet;
import java.util.Scanner;


public class CallCenter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SuporteTecnico suporteTecnico = new SuporteTecnico();
        Interpretadora interpretadora = new Interpretadora();

        System.out.println("Bem-vindo ao sistema de Suporte Técnico");
        System.out.println("Pressione <enter> para continuar ou digite 'sair' para sair do sistema.");

        String input = scanner.nextLine();
        while (!input.equals("sair")) {
            System.out.println("Descreva seu problema de maneira sucinta.");
            input = scanner.nextLine();

            interpretadora.interpretar(input);
            HashSet<String> palavrasChave = interpretadora.getPalavraChave();
            String problema = String.join(" ", palavrasChave);

            String solucao = suporteTecnico.buscarSolucao(problema);
            System.out.println(solucao);

            System.out.println("Pressione <enter> para continuar ou digite 'sair' para sair do sistema.");
            input = scanner.nextLine();
        }

        System.out.println("Obrigada por utilizar nossos serviços.");
        scanner.close();
    }
}
