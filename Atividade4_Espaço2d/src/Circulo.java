public class Circulo extends Forma {
    
    private double raio;
    
    public Circulo(Ponto2D centro, double raio) {
        super(new Ponto2D[]{centro});
        this.raio = raio;
    }
    
    public Circulo(Ponto2D[] pontos) {
    }

    public double getRaio() {
        return raio;
    }
    
    @Override
    public double calculaArea() {
        
        return Math.PI * Math.pow(raio, 2);
    }

    @Override
    public double calculaPerimetro() {
       
        return 2 * Math.PI * raio;
    }
}
