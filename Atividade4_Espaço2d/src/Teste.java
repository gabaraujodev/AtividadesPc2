public class Teste {
    public static void main(String[] args) {
        
        Ponto2D p1 = new Ponto2D(0, 0);
        Ponto2D p2 = new Ponto2D(0, 1);
        Ponto2D p3 = new Ponto2D(1, 0);
        Ponto2D p4 = new Ponto2D(1, 1);
        Ponto2D p5 = new Ponto2D(2, 2);
        Ponto2D p6 = new Ponto2D(3, 3);

        
        Triangulo t1 = new Triangulo(new Ponto2D[] {p1, p2, p3});
        Triangulo t2 = new Triangulo(new Ponto2D[] {p2, p3, p4});
        Quadrado q1 = new Quadrado(new Ponto2D[] {p1, p3, p4, p2});
        Circulo c1 = new Circulo(p5, 2.0);
        Circulo c2 = new Circulo(p6, 1.5);

        
        Espaco2D espaco = new Espaco2D();
        espaco.adicionarForma(t1);
        espaco.adicionarForma(t2);
        espaco.adicionarForma(q1);
        espaco.adicionarForma(c1);
        espaco.adicionarForma(c2);

        
        System.out.println("Formas presentes no espaço 2D:");
        System.out.println(espaco.mostraTriangulos());
        System.out.println(espaco.mostraQuadrados());
        System.out.println(espaco.mostraCirculos());
        System.out.println("Área total: " + espaco.calculaAreaTotal());
        System.out.println("Perímetro total: " + espaco.calculaPerimetroTotal());
    }
}
