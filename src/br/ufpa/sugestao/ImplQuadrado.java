package br.ufpa.sugestao;

/**
 * Classe que implementa a interface FiguraGeometrica herdando o toString dinamico de AbsIFiguraGeometrica
 */
public class ImplQuadrado extends AbsIFiguraGeometrica {
    private double lado;

    /**
     * Construtor padrao
     */
    public ImplQuadrado() {
    }

    /**
     * Construtor para o poligono Quadrado
     *
     * @param lado Inteiro que representa os lados do quadrado
     * @throws IllegalArgumentException caso o lado nao assuma valor positivo
     */
    public ImplQuadrado(double lado) {
        if (lado <= 0) {
            throw new IllegalArgumentException("Lado deve ter valor positivo!");
        }
        this.lado = lado;
    }

    public double getLado() {
        return lado;
    }

    /**
     * Metodo setter
     *
     * @param lado medida que representa os lados do quadrado
     * @throws IllegalArgumentException caso o lado nao assuma valor positivo
     */
    public void setLado(int lado) {
        if (lado <= 0) {
            throw new IllegalArgumentException("Lado deve ter valor positivo!");
        }
        this.lado = lado;
    }

    @Override
    public String getNomeFigura() {
        return "Quadrado (Sugestao)";
    }

    /**
     * Calcula a area do quadrado
     *
     * @return area
     * @throws ExceptionInInitializerError caso o lado nao seja inicializado (assume 0 por padrao) a
     *                                     exception e lancada
     */
    @Override
    public Double getArea() {
        if (this.lado == 0) {
            throw new ExceptionInInitializerError("Os lados devem ser inicializados!");
        }
        return Math.pow(this.lado, 2);
    }

    /**
     * Calcula o perimetro do quadrado
     *
     * @return area
     * @throws ExceptionInInitializerError caso o lado nao seja inicializado (assume 0 por padrao) a
     *                                     exception e lancada
     */
    @Override
    public Double getPerimetro() {
        if (this.lado == 0) {
            throw new ExceptionInInitializerError("Os lados devem ser inicializados!");
        }
        return this.lado * 4;
    }

}
