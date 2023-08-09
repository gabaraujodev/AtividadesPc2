package suportetecnico;


import java.util.HashSet;

import java.util.StringTokenizer;
class Interpretadora {
    private HashSet<String> palavraChave;

    public Interpretadora() {
        palavraChave = new HashSet<String>();
    }

    public void interpretar(String problema) {
        StringTokenizer tokenizer = new StringTokenizer(problema.toLowerCase(), " .,;:-_!\"?(){}[]/");
        while (tokenizer.hasMoreTokens()) {
            palavraChave.add(tokenizer.nextToken());
        }
    }

    public HashSet<String> getPalavraChave() {
        return palavraChave;
    }
}