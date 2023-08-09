public class Assalariado extends Empregado {
    private double salarioBase;

    public Assalariado(String nome, String sobrenome, String cpf) {
        super(nome, sobrenome, cpf);
        this.salarioBase = 1320.00; // salário base fixo
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    @Override
    public double calcularSalario() {
        return salarioBase; // salário fixo
    }
}
