public class Lote {
    private Produto produto;
    private Lance maiorLance;

    public Lote(Produto produto) {
        this.produto = produto;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setMaiorLance(Lance maiorLance) {
        this.maiorLance = maiorLance;
    }

    public Lance getMaiorLance() {
        return maiorLance;
    }
}
