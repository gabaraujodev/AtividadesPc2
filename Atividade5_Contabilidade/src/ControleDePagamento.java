import java.util.ArrayList;

public class ControleDePagamento {
    private ArrayList<Empregado> empregados;
    private ArrayList<Conta> contas;

    public ControleDePagamento() {
        this.empregados = new ArrayList<>();
        this.contas = new ArrayList<>();
    }

    public void adicionarEmpregado(Empregado empregado) {
        this.empregados.add(empregado);
    }

    public void adicionarConta(Conta conta) {
        this.contas.add(conta);
    }

    public double calcularTotalPagamentos() {
        double total = 0.0;
        for (Empregado empregado : empregados) {
            total += empregado.calcularSalario();
        }
        for (Conta conta : contas) {
            total += conta.calcularValorTotal();
        }
        return total;
    }

    public ArrayList<Empregado> getEmpregados() {
        return empregados;
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }
}
