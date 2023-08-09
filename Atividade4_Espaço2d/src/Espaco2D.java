import java.util.ArrayList;

public class Espaco2D {
    private ArrayList<Forma> formas;
    
    public Espaco2D() {
        this.formas = new ArrayList<Forma>();
    }
    
    public void adicionarForma(Forma forma) {
        this.formas.add(forma);
    }
    
    public String mostraTriangulos() {
        String retorno = "";
        for(Forma forma: formas) {
            if (forma instanceof Triangulo) {
                retorno += "Triângulo " + ((Triangulo)forma).tipoTriangulo() + "\n";
            }
        }
        return retorno;
    }
    
    public String mostraQuadrados() {
        String retorno = "";
        for(Forma forma: formas) {
            if (forma instanceof Quadrado) {
                retorno += "Quadrado\n";
            }
        }
        return retorno;
    }
    
    public String mostraCirculos() {
        String retorno = "";
        for(Forma forma: formas) {
            if (forma instanceof Circulo) {
                retorno += "Círculo\n";
            }
        }
        return retorno;
    }
    
    public double calculaAreaTotal() {
        double areaTotal = 0;
        for(Forma forma: formas) {
            areaTotal += forma.calculaArea();
        }
        return areaTotal;
    }
    
    public double calculaPerimetroTotal() {
        double perimetroTotal = 0;
        for(Forma forma: formas) {
            perimetroTotal += forma.calculaPerimetro();
        }
        return perimetroTotal;
    }
}
