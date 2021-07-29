package br.ufpa.sugestao;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import java.util.stream.Stream;

public abstract class AbsIFiguraGeometrica implements IFiguraGeometrica {

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);
        ((DecimalFormat) numberFormat).applyPattern("#.##");
        stringBuilder
                .append(this.getNomeFigura())
                .append("\n");

        appendGenericFieldsToStringBuilder(stringBuilder);

        stringBuilder.append("Area = ")
                .append(numberFormat.format(this.getArea()))
                .append("\n")
                .append("Perimetro = ")
                .append(numberFormat.format(this.getPerimetro()))
                .append("\n");

        return stringBuilder.toString();
    }

    private void appendGenericFieldsToStringBuilder(StringBuilder stringBuilder) {
        Stream.of(this.getClass().getDeclaredFields()).forEach(field -> {
            field.setAccessible(true);
            try {
                String fieldName = field.getName();
                var valor = field.get(this);
                validaInicializacao(fieldName, valor);
                valor = formataSeDouble(valor);
                stringBuilder.append(fieldName.substring(0, 1).toUpperCase()).append(fieldName.substring(1))
                        .append(" = ").append(valor).append("\n");
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });
    }

    private Object formataSeDouble(Object valor) {
        if (valor.getClass().isAssignableFrom(Double.class)) {
            NumberFormat numberFormat = NumberFormat.getCurrencyInstance(Locale.US);
            ((DecimalFormat) numberFormat).applyPattern("#.##");
            valor = numberFormat.format(valor);
        }
        return valor;
    }

    private void validaInicializacao(String fieldName, Object valor) {
        if (
                (valor.getClass().isAssignableFrom(Integer.class) ||
                        valor.getClass().isAssignableFrom(Double.class)) &&
                        (double) valor == 0
        )
            throw new ExceptionInInitializerError(fieldName + " deve ser inicializado!");
    }
}
