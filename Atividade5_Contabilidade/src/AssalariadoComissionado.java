public class AssalariadoComissionado extends Empregado {
    private double salarioBase;
    private double comissao;
    private double vendas;

    public AssalariadoComissionado(String nome, String sobrenome, String cpf, double salarioBase, double comissao) {
        super(nome, sobrenome, cpf);
        this.salarioBase = salarioBase;
        this.comissao = comissao;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public double getComissao() {
        return comissao;
    }

    public void setComissao(double comissao) {
        this.comissao = comissao;
    }

    public double getVendas() {
        return vendas;
    }

    public void setVendas(double vendas) {
        this.vendas = vendas;
    }

    @Override
    public double calcularSalario() {
        return salarioBase + (comissao * vendas);
    }
}
