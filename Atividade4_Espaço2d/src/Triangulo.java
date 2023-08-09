public class Triangulo extends Forma {
    
    private Ponto2D[] pontos;
    
    public Triangulo(Ponto2D[] pontos) {
        super(pontos);
        this.pontos = pontos;
    }

    public String tipoTriangulo() {
        double lado1 = pontos[0].calculaDistancia(pontos[1]);
        double lado2 = pontos[1].calculaDistancia(pontos[2]);
        double lado3 = pontos[2].calculaDistancia(pontos[0]);
        
        if (lado1 == lado2 && lado2 == lado3) {
            return "Equilátero";
        } else if (lado1 == lado2 || lado2 == lado3 || lado1 == lado3) {
            return "Isósceles";
        } else {
            return "Escaleno";
        }
    }

    @Override
    public double calculaArea() {
        double lado1 = pontos[0].calculaDistancia(pontos[1]);
        double lado2 = pontos[1].calculaDistancia(pontos[2]);
        double lado3 = pontos[2].calculaDistancia(pontos[0]);
        double sp = (lado1 + lado2 + lado3) / 2;
        double area = Math.sqrt(sp * (sp - lado1) * (sp - lado2) * (sp - lado3));
        return area;
    }

    @Override
    public double calculaPerimetro() {
        double lado1 = pontos[0].calculaDistancia(pontos[1]);
        double lado2 = pontos[1].calculaDistancia(pontos[2]);
        double lado3 = pontos[2].calculaDistancia(pontos[0]);
        double perimetro = lado1 + lado2 + lado3;
        return perimetro;
    }
}
