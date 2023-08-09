import java.util.ArrayList;

public class SistemaPagamentoTeste {
    public static void main(String[] args) {
        // Criação dos objetos Empregado, Conta e Título
        Empregado empregado1 = new Assalariado("João", "Silva", "111.111.111-11");
        Empregado empregado2 = new Comissionado("Maria", "Souza", "222.222.222-22", 6.0);
        Empregado empregado3 = new Terceirizado("Pedro", "Santos", "333.333.333-33","localterceiros");

        Conta conta1 = new Concessionaria(1, "Conta de luz", 100.0,false);
        Conta conta2 = new Concessionaria(2,"Conta de água", 50.0,true);
        Conta conta3 = new Titulo(1,"Compra de mercadorias", 500.0, true,10);

        // Criação do ArrayList de Empregados e adicionando os objetos Empregado criados anteriormente
        ArrayList<Empregado> listaEmpregados = new ArrayList<>();
        listaEmpregados.add(empregado1);
        listaEmpregados.add(empregado2);
        listaEmpregados.add(empregado3);

        // Criação do ArrayList de Contas e adicionando os objetos Conta criados anteriormente
        ArrayList<Conta> listaContas = new ArrayList<>();
        listaContas.add(conta1);
        listaContas.add(conta2);
        listaContas.add(conta3);

        // Processamento dos pagamentos
        double totalPagamentos = 0.0;

        // Processamento dos pagamentos dos empregados
        for (Empregado empregado : listaEmpregados) {
            totalPagamentos += empregado.calcularSalario();
            System.out.printf("%s %s - Salário: R$ %.2f%n", empregado.getNome(), empregado.getSobrenome(), empregado.calcularSalario());
        }

        // Processamento dos pagamentos das contas
        for (Conta conta : listaContas) {
            totalPagamentos += conta.calcularValorTotal();
            System.out.printf("%s - Valor a pagar: R$ %.2f%n", conta.getDescricao(), conta.calcularValorTotal());
        }

        // Exibição do total de pagamentos
        System.out.printf("Total de pagamentos a serem realizados: R$ %.2f%n", totalPagamentos);

        

        // Exibição dos novos salários dos empregados assalariados/comissionados
        for (Empregado empregado : listaEmpregados) {
            if (empregado instanceof AssalariadoComissionado) {
                AssalariadoComissionado assalariadoComissionado = (AssalariadoComissionado) empregado;
                System.out.printf("Novo salário de %s %s: R$ %.2f%n", empregado.getNome(), empregado.getSobrenome(), assalariadoComissionado.calcularSalario());
                }
                }
                }
                }
