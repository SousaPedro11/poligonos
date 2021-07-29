package br.ufpa.sugestao;

/**
 * Classe que implementa a interface FiguraGeometrica herdando o toString dinamico de AbsIFiguraGeometrica
 */
public class ImplTrianguloHeron extends AbsIFiguraGeometrica {

    private double ladoA;
    private double ladoB;
    private double ladoC;

    /**
     * Construtor padrao, geralmente usado em conjunto com setters
     */
    public ImplTrianguloHeron() {
    }

    /**
     * Construtor para o poligono triangulo
     *
     * @param ladoA float que representa um lado do triangulo, sugestivamente a hipotenusa
     * @param ladoB float que representa um lado do triangulo, sugestivamente algum cateto
     * @param ladoC float que representa um lado do triangulo, sugestivamente algum cateto
     * @throws IllegalArgumentException Caso algum dos lados nao assuma valor positivo ou nao formem um triangulo
     */
    public ImplTrianguloHeron(double ladoA, double ladoB, double ladoC) {
        if (ladoA <= 0 || ladoB <= 0 || ladoC <= 0) {
            throw new IllegalArgumentException("Todos os lados devem ser positivos");
        }

        verificaTriangulo(ladoA, ladoB, ladoC);

        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoC;
    }

    private void verificaTriangulo(double ladoA, double ladoB, double ladoC) {
        if (!((ladoA < (ladoB + ladoC)) && (ladoB < (ladoA + ladoC)) && (ladoC < (ladoA + ladoB)))) {
            throw new IllegalArgumentException("Estes valores não formam um triângulo!");
        }
    }

    public double getLadoA() {
        return ladoA;
    }

    public void setLadoA(double ladoA) {
        if (ladoA <= 0) {
            throw new IllegalArgumentException("LadoA deve ter valor positivo!");
        }
        this.ladoA = ladoA;
    }

    public double getLadoB() {
        return ladoB;
    }

    public void setLadoB(double ladoB) {
        if (ladoB <= 0) {
            throw new IllegalArgumentException("LadoB deve ter valor positivo!");
        }
        this.ladoB = ladoB;
    }

    public double getLadoC() {
        return ladoC;
    }

    public void setLadoC(double ladoC) {
        if (ladoC <= 0) {
            throw new IllegalArgumentException("LadoC deve ter valor positivo!");
        }
        this.ladoC = ladoC;
    }

    @Override
    public String getNomeFigura() {
        return "Triangulo (Sugestao Heron)";
    }

    /**
     * Calcula a area do triangulo
     *
     * @return area
     * @throws IllegalArgumentException caso os lados nao correspondam a um triangulo
     */
    @Override
    public Double getArea() {
        verificaTriangulo(this.ladoA, this.ladoB, this.ladoC);

        double semiperimetro = this.getPerimetro() / 2;
        double radical = semiperimetro * (semiperimetro - this.ladoA) * (semiperimetro - this.ladoB) * (semiperimetro - this.ladoC);
        return Math.sqrt(radical);
    }

    /**
     * Calcula o perimetro do triangulo
     *
     * @return soma dos lados
     * @throws IllegalArgumentException caso os lados nao correspondam a um triangulo
     */
    @Override
    public Double getPerimetro() {
        verificaTriangulo(this.ladoA, this.ladoB, this.ladoC);

        return this.ladoA + this.ladoB + this.ladoC;
    }
}
