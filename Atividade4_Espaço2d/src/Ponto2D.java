public class Ponto2D {
    private double x;
    private double y;

    public Ponto2D() {
        this(0, 0);
    }

    public Ponto2D(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public Ponto2D(Ponto2D ponto) {
        this(ponto.x, ponto.y);
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double calculaDistancia(Ponto2D outroPonto) {
        double deltaX = this.x - outroPonto.x;
        double deltaY = this.y - outroPonto.y;
        return Math.sqrt(deltaX * deltaX + deltaY * deltaY);
    }
}
