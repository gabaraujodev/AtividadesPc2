
import com.mycompany.baralho1.Carta;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */




 public class Baralho {
        public static void main(String[] args) {
            Carta carta1 = new Carta(10, "copas");
            Carta carta2 = new Carta(5, "espadas");
            
       
        
            
            int resultadoComparacao = carta1.compara(carta2);
            switch (resultadoComparacao) {
                case 1:
                    System.out.println("Carta 1 é maior que carta 2.");
                    break;
                case 0:
                    System.out.println("Carta 1 é igual a carta 2.");
                    break;
                default: 
                    System.out.println("Carta 1 é menor que carta 2.");
                    break;
            }
            
            
            if (carta1.mesmoNaipe(carta2)) {
                System.out.println("Carta 1 e carta 2 são do mesmo naipe.");
            } else {
                System.out.println("Carta 1 e carta 2 não são do mesmo naipe.");
            }
        }
    }


