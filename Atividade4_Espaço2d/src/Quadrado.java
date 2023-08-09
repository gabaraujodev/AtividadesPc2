

public class Quadrado extends Forma{
	
	public Quadrado(Ponto2D[] pontos) {
		super(pontos);
	}

	@Override
	public double calculaArea() {
		// calcula a distância entre dois pontos adjacentes do quadrado
		double lado = this.getPontos()[0].calculaDistancia(this.getPontos()[1]);
		
		// calcula a área do quadrado (lado x lado)
		return lado * lado;
	}

	@Override
	public double calculaPerimetro() {
		// calcula a distância entre dois pontos adjacentes do quadrado
		double lado = this.getPontos()[0].calculaDistancia(this.getPontos()[1]);
		
		// calcula o perímetro do quadrado (4 x lado)
		return 4 * lado;
	}

}
