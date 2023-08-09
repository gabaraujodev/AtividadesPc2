public abstract class Forma {
    private Ponto2D[] pontos;

    public Forma() {
        this.pontos = new Ponto2D[0];
    }

    public Forma(Ponto2D[] pontos) {
        this.pontos = pontos;
    }
    public Ponto2D[] getPontos() {
		return pontos;
	}

    public static Forma geraForma(Ponto2D[] pontos) {
        int tamanho = pontos.length;
        Forma retorno = null;
        if (tamanho == 3 && geraTriangulo(pontos)) {
            retorno = new Triangulo(pontos);
        } else if (tamanho == 4 && geraQuadrado(pontos)) {
            retorno = new Quadrado(pontos);
        } else if (tamanho == 2 && geraCirculo(pontos)) {
            retorno = new Circulo(pontos);
        }
        return retorno;
    }

    private static boolean geraTriangulo(Ponto2D[] pontos) {
        double lado1 = pontos[0].calculaDistancia(pontos[1]);
        double lado2 = pontos[0].calculaDistancia(pontos[2]);
        double lado3 = pontos[1].calculaDistancia(pontos[2]);
        return (lado1 + lado2 > lado3) && (lado1 + lado3 > lado2) && (lado2 + lado3 > lado1);
    }

    private static boolean geraQuadrado(Ponto2D[] pontos) {
        
        return false;
    }

    private static boolean geraCirculo(Ponto2D[] pontos) {
        
        return false;
    }

    public abstract double calculaArea();

    public abstract double calculaPerimetro();
}
