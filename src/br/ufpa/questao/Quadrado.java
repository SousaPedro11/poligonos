package br.ufpa.questao;


/**
 * Classe que implementa a interface FiguraGeometrica
 */
public class Quadrado implements FiguraGeometrica {
    private int lado;

    /**
     * Construtor padrao
     */
    public Quadrado() {
    }

    /**
     * Construtor para o poligono Quadrado
     *
     * @param lado Inteiro que representa os lados do quadrado
     * @throws IllegalArgumentException caso o lado nao assuma valor positivo
     */
    public Quadrado(int lado) {
        if (lado <= 0) {
            throw new IllegalArgumentException("Lado deve ter valor positivo!");
        }
        this.lado = lado;
    }

    public int getLado() {
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
        return "Quadrado";
    }

    /**
     * Calcula a area do quadrado
     *
     * Em teoria deveria retornar double ou float, mas para ficar de acordo com o modelo proposto ha o cast para int
     *
     * @return area
     * @throws ExceptionInInitializerError caso o lado nao seja inicializado (assume 0 por padrao) a
     *                                     exception e lancada
     */
    @Override
    public Integer getArea() {
        if (this.lado == 0) {
            throw new ExceptionInInitializerError("Os lados devem ser inicializados!");
        }
        return (int) Math.pow(this.lado, 2);
    }

    /**
     * Calcula o perimetro do quadrado
     *
     * Em teoria deveria retornar double ou float, mas para ficar de acordo com o modelo proposto ha o cast para int
     *
     * @return area
     * @throws ExceptionInInitializerError caso o lado nao seja inicializado (assume 0 por padrao) a
     *                                     exception e lancada
     */
    @Override
    public Integer getPerimetro() {
        if (this.lado == 0) {
            throw new ExceptionInInitializerError("Os lados devem ser inicializados!");
        }
        return this.lado * 4;
    }

    @Override
    public String toString() {
        return this.getNomeFigura() +
                "\nLado = " +
                this.getLado() +
                "\nArea = " +
                this.getArea() +
                "\nPerimetro = " +
                this.getPerimetro() +
                "\n";
    }
}
