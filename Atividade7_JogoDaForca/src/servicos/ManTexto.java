package servicos;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;

public class ManTexto {
	
	public static ArrayList<String> lerArquivo(String nomeArquivo){
		ArrayList<String> retorno = new ArrayList<>();
		
		try{
			Scanner leitor = new Scanner(Paths.get(nomeArquivo));
			while(leitor.hasNext()) {
				retorno.add(leitor.next());
			}
			leitor.close();
		}catch(IOException e) {	
			e.printStackTrace();
		}
		return retorno;
	}

}
