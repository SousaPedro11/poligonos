package br.ufpa.questao;

/**
 * Classe que implementa a interface FiguraGeometrica
 */
public class Triangulo implements FiguraGeometrica {

    private float base;
    private float altura;
    private float ladoA;
    private float ladoB;
    private float ladoC;

    /**
     * Construtor padrao, geralmente usado em conjunto com setters
     */
    public Triangulo() {
    }

    /**
     * Construtor para o poligono triangulo
     *
     * @param base   float que representa a base do triangulo.
     * @param altura float que representa a altura do triangulo
     * @param ladoA  float que representa um lado do triangulo, sugestivamente a hipotenusa
     * @param ladoB  float que representa um lado do triangulo, sugestivamente algum cateto
     * @param ladoC  float que representa um lado do triangulo, sugestivamente algum cateto
     * @throws IllegalArgumentException Caso alguma das dimensoes nao assuma valor positivo
     *                                  ou os lados nao formem um triangulo ou a base nao equivale a um dos lados
     */
    public Triangulo(float base, float altura, float ladoA, float ladoB, float ladoC) {
        if (ladoA <= 0 || ladoB <= 0 || ladoC <= 0) {
            throw new IllegalArgumentException("Todos os lados devem ser positivos");
        } else if (base <= 0 || altura <= 0) {
            throw new IllegalArgumentException("Base e altura devem ser positivos");
        }

        verificaTriangulo(ladoA, ladoB, ladoC);

        this.ladoA = ladoA;
        this.ladoB = ladoB;
        this.ladoC = ladoC;

        if ((base != ladoA) && (base != ladoB) && (base != ladoC)) {
            throw new IllegalArgumentException("Base deve ser equivalente a um dos lados");
        } else {
            this.base = base;
        }
        this.altura = altura;
    }

    private void verificaTriangulo(double ladoA, double ladoB, double ladoC) {
        if (!((ladoA < (ladoB + ladoC)) && (ladoB < (ladoA + ladoC)) && (ladoC < (ladoA + ladoB)))) {
            throw new IllegalArgumentException("Estes valores não formam um triângulo!");
        }
    }

    public float getBase() {
        return base;
    }

    public void setBase(float base) {
        if (base <= 0) {
            throw new IllegalArgumentException("Base deve ter valor positivo!");
        }
        this.base = base;
    }

    public float getAltura() {
        return altura;
    }

    public void setAltura(float altura) {
        if (altura <= 0) {
            throw new IllegalArgumentException("Altura deve ter valor positivo!");
        }
        this.altura = altura;
    }

    public float getLadoA() {
        return ladoA;
    }

    public void setLadoA(float ladoA) {
        if (ladoA <= 0) {
            throw new IllegalArgumentException("LadoA deve ter valor positivo!");
        }
        this.ladoA = ladoA;
    }

    public float getLadoB() {
        return ladoB;
    }

    public void setLadoB(float ladoB) {
        if (ladoB <= 0) {
            throw new IllegalArgumentException("LadoB deve ter valor positivo!");
        }
        this.ladoB = ladoB;
    }

    public float getLadoC() {
        return ladoC;
    }

    public void setLadoC(float ladoC) {
        if (ladoC <= 0) {
            throw new IllegalArgumentException("LadoC deve ter valor positivo!");
        }
        this.ladoC = ladoC;
    }

    @Override
    public String getNomeFigura() {
        return "Triangulo";
    }

    /**
     * Calcula a area do triangulo
     *
     * Em teoria deveria retornar double ou float, mas para ficar de acordo com o modelo proposto ha o cast para int
     *
     * @return area
     * @throws ExceptionInInitializerError caso base ou altura nao sejam inicializados (assumem 0 por padrao) a
     *                                     exception e lancada
     */
    @Override
    public Integer getArea() {
        verificaTriangulo(this.ladoA, this.ladoB, this.ladoC);

        if (this.base == 0 || this.altura == 0) {
            throw new ExceptionInInitializerError("Base e altura devem ser inicializados!");
        }
        return (int) (this.base * this.altura / 2);
    }

    /**
     * Calcula o perimetro do triangulo
     * <p>
     * Em teoria deveria retornar double ou float, mas para ficar de acordo com o modelo proposto ha o cast para int
     *
     * @return soma dos lados
     * @throws ExceptionInInitializerError caso os lados nao sejam inicializados (assumem 0 por padrao) a exception
     *                                     e lancada
     */
    @Override
    public Integer getPerimetro() {
        verificaTriangulo(this.ladoA, this.ladoB, this.ladoC);

        if (this.ladoA == 0 || this.ladoB == 0 || this.ladoC == 0) {
            throw new ExceptionInInitializerError("Os lados devem ser inicializados!");
        }
        return (int) (this.ladoA + this.ladoB + this.ladoC);
    }

    @Override
    public String toString() {
        return this.getNomeFigura() +
                "\nAltura = " +
                this.getAltura() +
                "\nBase = " +
                this.getBase() +
                "\nLadoA = " +
                this.getLadoA() +
                "\nLadoB = " +
                this.getLadoB() +
                "\nLadoC = " +
                this.getLadoC() +
                "\nArea = " +
                this.getArea() +
                "\nPerimetro = " +
                this.getPerimetro() +
                "\n";
    }
}
