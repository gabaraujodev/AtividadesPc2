public class TesteLeilao {
    public static void main(String[] args) {
        
        Pessoa pessoa1 = new Pessoa("João", "joao@email.com");
        Pessoa pessoa2 = new Pessoa("Maria", "maria@email.com");
      
        Produto produto1 = new Produto("Notebook Dell");
        Produto produto2 = new Produto("Smartphone Samsung");
        
        Lote lote1 = new Lote(produto1);
        Lote lote2 = new Lote(produto2);

        Leilao leilao = new Leilao();
        leilao.adicionarLote(lote1);
        leilao.adicionarLote(lote2);

        

        
        Lance lance1 = new Lance(pessoa1, 1500.00);
        leilao.fazerLance(lote1, lance1);

        Lance lance2 = new Lance(pessoa2, 1200.00);
        leilao.fazerLance(lote1, lance2);

        Lance lance3 = new Lance(pessoa2, 1501.00);
        leilao.fazerLance(lote1, lance3);

        Lance lance4 = new Lance(pessoa1, 800.00);
        leilao.fazerLance(lote2, lance4);

        leilao.listarProdutos();

        
        leilao.encerrarLeilao();
    }   
}
