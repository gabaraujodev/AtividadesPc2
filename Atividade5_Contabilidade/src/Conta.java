public abstract class Conta {
    private int numero;
    private String descricao;
    private double valor;
    private boolean vencida;

    public Conta(int numero, String descricao, double valor, boolean vencida) {
        this.numero = numero;
        this.descricao = descricao;
        this.valor = valor;
        this.vencida = vencida;
    }

    public abstract double calcularValorTotal();

    public int getNumero() {
        return numero;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getValor() {
        return valor;
    }

    public boolean isVencida() {
        return vencida;
    }
}
