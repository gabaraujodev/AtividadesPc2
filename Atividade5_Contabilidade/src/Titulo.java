public class Titulo extends Conta {
    private int diasEmAtraso;

    public Titulo(int numero, String descricao, double valor, boolean vencida, int diasEmAtraso) {
        super(numero, descricao, valor, vencida);
        this.diasEmAtraso = diasEmAtraso;
    }

    public double calcularValorTotal() {
        double valorTotal = getValor();
        if (isVencida()) {
            valorTotal += (valorTotal * 0.1); // Acrescenta 10% de multa se estiver vencida
            valorTotal += (valorTotal * 0.01 * diasEmAtraso); // Acrescenta 1% de juros por dia de atraso
        }
        return valorTotal;
    }

    public int getDiasEmAtraso() {
        return diasEmAtraso;
    }
}
