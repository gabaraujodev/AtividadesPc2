package Aplicacao;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleButton;


public class Aplicacao {
  
    //Atributos da classe                           
    private HashMap<ToggleButton, Integer> numerosBotoes;  
    private ArrayList<Integer> numeros = new ArrayList<>();
    private int pontos;                                     
   
    private ToggleButton 
        btn00, btn01, btn02, btn03, btn04, btn05,
        btn10, btn11, btn12, btn13, btn14, btn15,
        btn20, btn21, btn22, btn23, btn24, btn25,
        btn30, btn31, btn32, btn33, btn34, btn35,
        btn40, btn41, btn42, btn43, btn44, btn45,
        btn50, btn51, btn52, btn53, btn54, btn55,
        btn60, btn61, btn62, btn63, btn64, btn65,
        btn70, btn71, btn72, btn73, btn74, btn75,
        btn80, btn81, btn82, btn83, btn84, btn85,
        btn90, btn91, btn92, btn93, btn94, btn95;

    
    

    //Construtor 
    public Aplicacao(){
        //Inicializa as variáveis
        pontos = 0;
        numerosBotoes = new HashMap<ToggleButton,Integer>();
    }

    
    public void iniciarJogo(ToggleButton[][] botoes, Label lblPontos) {
        numerosBotoes = new HashMap<>();

        for (int k = 1; k <= 30; k++)
            numeros.add(k);
        for (int k = 1; k <= 30; k++)
            numeros.add(k);
        Collections.shuffle(numeros);

        for (int i = 0; i < 10; i++)
            for (int j = 0; j < 6; j++) {
                numerosBotoes.put(botoes[i][j], numeros.get(0));
                numeros.remove(0);
            }
         for (int j = 0; j < 10; j++) {
            for (int k = 0; k < 6; k++) {
               botoes[j][k].setDisable(false);
               botoes[j][k].setSelected(false);
               botoes[j][k].setText("?");
            }
        }
        pontos = 0;
        lblPontos.setText("Pontos " +Integer.toString(pontos));
    }
   
    
     public void reiniciarJogo(ToggleButton[][] tabuleiro, Label lblPontos) {
        for (int j = 0; j < 10; j++) {
            for (int k = 0; k < 6; k++) {
                tabuleiro[j][k].setDisable(false); // Habilita todos os botões do tabuleiro
                tabuleiro[j][k].setSelected(false); // Deseleciona todos os botões do tabuleiro
                tabuleiro[j][k].setText("?"); // Define o texto de todos os botões como "?"
            }
        }
        pontos = 0; // Reseta os pontos
        iniciarJogo(tabuleiro, lblPontos); // Inicia um novo jogo
        lblPontos.setText("Pontos " + String.valueOf(pontos)); // Atualiza a label de pontos   
    }
  
    //Indica o acerto de uma tentativa realizada
    public void somaPonto(){
        pontos++;
    }

    //Retorna a quantidade de pontos feitos pelo jogador na partida
    public int getPontos(){
        return pontos;
    }

   
   

public HashMap<ToggleButton, Integer> getNumerosBotoes() {
        return numerosBotoes;
    }

    public void setNumerosBotoes(HashMap<ToggleButton, Integer> numerosBotoes) {
        this.numerosBotoes = numerosBotoes;
    }

    public ArrayList<Integer> getNumeros() {
        return numeros;
    }

    public void setNumeros(ArrayList<Integer> numeros) {
        this.numeros = numeros;
    }
    


}

    
    

