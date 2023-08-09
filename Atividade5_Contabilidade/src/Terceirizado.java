public class Terceirizado extends Empregado {
    private String empresa;

    public Terceirizado(String nome, String sobrenome, String cpf, String empresa) {
        super(nome, sobrenome, cpf);
        this.empresa = empresa;
    }

    public String getEmpresa() {
        return empresa;
    }

    @Override
    public double calcularSalario() {
        return 0; 
    }
}
