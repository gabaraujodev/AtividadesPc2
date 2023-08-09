import java.util.ArrayList;

public class Passivo {
    private ArrayList<Conta> contas;
    private ArrayList<Empregado> empregados;

    public Passivo() {
        this.contas = new ArrayList<>();
        this.empregados = new ArrayList<>();
    }

    public void adicionarConta(Conta conta) {
        this.contas.add(conta);
    }

    public void adicionarEmpregado(Empregado empregado) {
        this.empregados.add(empregado);
    }

    public double calcularTotalContas() {
        double total = 0.0;
        for (Conta conta : contas) {
            total += conta.calcularValorTotal();
        }
        return total;
    }

    public double calcularTotalSalarios() {
        double total = 0.0;
        for (Empregado empregado : empregados) {
            total += empregado.calcularSalario();
        }
        return total;
    }

    public double calcularTotalAPagar() {
        return calcularTotalContas() + calcularTotalSalarios();
    }

    public ArrayList<Conta> getContas() {
        return contas;
    }

    public ArrayList<Empregado> getEmpregados() {
        return empregados;
    }
}
