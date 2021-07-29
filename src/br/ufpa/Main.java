package br.ufpa;

import br.ufpa.questao.FiguraGeometrica;
import br.ufpa.questao.Quadrado;
import br.ufpa.questao.Triangulo;
import br.ufpa.sugestao.IFiguraGeometrica;
import br.ufpa.sugestao.ImplQuadrado;
import br.ufpa.sugestao.ImplTrianguloHeron;

public class Main {

    public static void main(String[] args) {
        IFiguraGeometrica quadrado1 = new ImplQuadrado(4);

//        IFiguraGeometrica triangulo1 = new ImplTrianguloHeron(3, 4, 5);
        IFiguraGeometrica triangulo1 = new ImplTrianguloHeron();
        ((ImplTrianguloHeron) triangulo1).setLadoA(3);
        ((ImplTrianguloHeron) triangulo1).setLadoB(4);
        ((ImplTrianguloHeron) triangulo1).setLadoC(5);

        FiguraGeometrica quadrado2 = new Quadrado(4);

        FiguraGeometrica triangulo2 = new Triangulo(4, 3, 5, 4, 3);

        System.out.println(quadrado1);
        System.out.println(quadrado2);
        System.out.println(triangulo1);
        System.out.println(triangulo2);
    }
}
