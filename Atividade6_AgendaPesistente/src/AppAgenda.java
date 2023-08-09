package agenda;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppAgenda {
    private static final String ARQUIVO_CONTATOS = "agendaPessoal.txt";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Agenda agenda = new Agenda();
        ManipulaArquivoTexto manipulador = new ManipulaArquivoTexto(ARQUIVO_CONTATOS);

        try {
            List<String> linhas = manipulador.lerLinhas();
            for (String linha : linhas) {
                String[] campos = linha.split(",");
                if (campos.length == 4) {
                    Contato contato = new Contato(campos[0], campos[1], campos[2], campos[3]);
                    agenda.incluirContato(contato);
                }
            }
        } catch (IOException e) {
            System.out.println("Erro ao ler arquivo: " + e.getMessage());
        }

        int opcao = 0;
        while (opcao != 5) {
            System.out.println("Selecione uma opção:");
            System.out.println("1 - Incluir contato");
            System.out.println("2 - Alterar contato");
            System.out.println("3 - Pesquisar contato");
            System.out.println("4 - Listar contatos");
            System.out.println("5 - Sair");

            opcao = scanner.nextInt();
            scanner.nextLine(); 

            switch (opcao) {
                case 1:
                    Contato novoContato = obterContatoDoUsuario(scanner);
                    agenda.incluirContato(novoContato);
                    System.out.println("Contato adicionado com sucesso.");
                    break;
                case 2:
                    String nomeAntigo = obterNomeDoUsuario(scanner, "Digite o nome do contato que deseja alterar:");
                    Contato contatoNovo = obterContatoDoUsuario(scanner);
                    try {
                        agenda.alterarContato(nomeAntigo, contatoNovo);
                        System.out.println("Contato alterado com sucesso.");
                    } catch (ContatoInexistenteException e) {
                        System.out.println("Contato não encontrado na agenda.");
                    }
                    break;
                case 3:
                    String nome = obterNomeDoUsuario(scanner, "Digite o nome do contato que deseja pesquisar:");
                    try {
                        Contato contato = agenda.pesquisarContato(nome);
                        System.out.println("Contato encontrado:\n" + contato.toString());
                    } catch (ContatoInexistenteException e) {
                        System.out.println("Contato não encontrado na agenda.");
                    }
                    break;
                case 4:
                    agenda.listarContatos();
                    break;
                case 5:
                    try {
                        List<String> linhas = new ArrayList<>();
                        for (Contato contato : agenda.getContatos().values()) {
                            String linha = contato.getNome() + "," + contato.getEndereco() + ","
                                    + contato.getTelefone() + "," + contato.getEmail();
                            linhas.add(linha);
                        }
                        manipulador.escreverLinhas(linhas);
                        System.out.println("Contatos salvos no arquivo.");
                    } catch (IOException e) {
                        System.out.println("Erro ao escrever arquivo: " + e.getMessage());
                    }
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        }

        scanner.close();
    }

    private static Contato obterContatoDoUsuario(Scanner scanner) {
    System.out.println("Digite o nome do contato:");
    String nome = scanner.nextLine();
    System.out.println("Digite o endereço do contato:");
    String endereco = scanner.nextLine();

    System.out.println("Digite o telefone do contato:");
    String telefone = scanner.nextLine();

    System.out.println("Digite o email do contato:");
    String email = scanner.nextLine();

    return new Contato(nome, endereco, telefone, email);
}

private static String obterNomeDoUsuario(Scanner scanner, String mensagem) {
    System.out.println(mensagem);
    return scanner.nextLine();
}
}

    
    
