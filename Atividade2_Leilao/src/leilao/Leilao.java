import java.util.ArrayList;

public class Leilao {
    private ArrayList<Lote> lotes = new ArrayList<>();

    public void adicionarLote(Lote lote) {
        lotes.add(lote);
    }

    public void listarProdutos() {
        for (Lote lote : lotes) {
            Produto produto = lote.getProduto();
            Lance maiorLance = lote.getMaiorLance();
            String descricao = produto.getDescricao();
            String valor = "Sem lances";
            if (maiorLance != null) {
                valor = Double.toString(maiorLance.getValor());
            }
            System.out.println(descricao + " - Maior lance eh : " + valor);
        }
    }

    public void fazerLance(Lote lote, Lance lance) {
        if (lote.getMaiorLance() == null || lance.getValor() > lote.getMaiorLance().getValor()) {
            lote.setMaiorLance(lance);
        }
    }

    public void encerrarLeilao() {
        System.out.println("Vendas realizadas:");
        for (Lote lote : lotes) {
            Produto produto = lote.getProduto();
            Lance maiorLance = lote.getMaiorLance();
            if (maiorLance != null) {
                Pessoa pessoa = maiorLance.getPessoa();
                double valor = maiorLance.getValor();
                System.out.println(produto.getDescricao() + " - " + pessoa.getNome() + " - R$" + valor);
            }
        }
    }
}
