public class Comissionado extends Empregado {
    private double taxaComissao;
    private double totalVendas;

    public Comissionado(String nome, String sobrenome, String cpf, double taxaComissao) {
        super(nome, sobrenome, cpf);
        this.taxaComissao = taxaComissao;
        this.totalVendas = 0.0;
    }

    public double getTaxaComissao() {
        return taxaComissao;
    }

    public void setTaxaComissao(double taxaComissao) {
        this.taxaComissao = taxaComissao;
    }

    public void adicionarVenda(double valor) {
        this.totalVendas += valor;
    }

    public double getVendas() {
        return totalVendas;
    }

    @Override
    public double calcularSalario() {
        return this.taxaComissao * this.totalVendas;
    }
}
