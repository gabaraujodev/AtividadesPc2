package dominio;

import servicos.ManTexto;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class JogoDaForca {
    private String palavra;
    private List<Integer> letrasEncontradas;
    private int numTentativas;

    public JogoDaForca() {
        letrasEncontradas = new ArrayList<>();
        numTentativas = 15;
        sorteiaPalavraJogo();
    }

    public void sorteiaPalavraJogo() {
        ArrayList<String> palavras = ManTexto.lerArquivo("palavras.txt");
        if (!palavras.isEmpty()) {
            Random random = new Random();
            int indice = random.nextInt(palavras.size());
            palavra = palavras.get(indice).toUpperCase();
        } else {
            palavra = "PALAVRA"; // Palavra padrão caso o arquivo esteja vazio ou ocorra algum erro na leitura
        }
        letrasEncontradas.clear();
    }

    public ArrayList<Integer> verificaLetra(char letra) {
        ArrayList<Integer> posicoes = new ArrayList<>();
        for (int i = 0; i < palavra.length(); i++) {
            if (palavra.charAt(i) == letra) {
                posicoes.add(i);
                letrasEncontradas.add(i);
            }
        }
        return posicoes;
    }

    public boolean isLetraEncontrada(int posicao) {
        return letrasEncontradas.contains(posicao);
    }

    public boolean isVenceu() {
        for (int i = 0; i < palavra.length(); i++) {
            if (!letrasEncontradas.contains(i)) {
                return false;
            }
        }
        return true;
    }

    public String getPalavra() {
        return palavra;
    }

    public int getNumTentativas() {
        return numTentativas;
    }

    public void setNumTentativas(int numTentativas) {
        this.numTentativas = numTentativas;
    }
}
