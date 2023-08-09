package agenda;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ManipulaArquivoTexto {

    private String nomeArquivo;

    public ManipulaArquivoTexto(String nomeArquivo) {
        this.nomeArquivo = nomeArquivo;
    }

    public void escreverLinhas(List<String> linhas) throws IOException {
        File arquivo = new File(nomeArquivo);

        if (!arquivo.exists()) {
            arquivo.createNewFile();
        }

        FileWriter fw = new FileWriter(arquivo, true);
        BufferedWriter bw = new BufferedWriter(fw);

        for (String linha : linhas) {
            bw.write(linha);
            bw.newLine();
        }

        bw.close();
        fw.close();
    }

    public List<String> lerLinhas() throws IOException {
        List<String> linhas = new ArrayList<String>();

        File arquivo = new File(nomeArquivo);

        if (!arquivo.exists()) {
            throw new FileNotFoundException("O arquivo " + nomeArquivo + " nao existe.");
        }

        FileReader fr = new FileReader(arquivo);
        BufferedReader br = new BufferedReader(fr);

        String linha;
        while ((linha = br.readLine()) != null) {
            linhas.add(linha);
        }

        br.close();
        fr.close();

        return linhas;
    }
}
