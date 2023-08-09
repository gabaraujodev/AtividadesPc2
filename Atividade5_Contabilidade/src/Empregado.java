public abstract class Empregado {
    private String nome;
    private String sobrenome;
    private String cpf;
    private double salarioBase=1320.00;

    public Empregado(String nome, String sobrenome, String cpf ) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        
    }

    public abstract double calcularSalario();

    public String getNome() {
        return nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public double getSalarioBase() {
        return salarioBase;
    }
}
