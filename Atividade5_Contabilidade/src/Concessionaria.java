public class Concessionaria extends Conta {
    public Concessionaria(int numero, String descricao, double valor, boolean vencida) {
        super(numero, descricao, valor, vencida);
    }

    public double calcularValorTotal() {
        return getValor();
    }
}
