package pi.model;

import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;

public class ModelGrafico {

    /**
     * QUANDO EXISTE UM GRAFICO COM MAIS DE 1 ELEMENTO NAO PODE HAVER TITULOS
     * IGUAIS.
     */
    private String title;
    private String label;
    private double value;
    private int value2;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (!title.isEmpty()) {
            this.title = title;
        } else {
            throw new IllegalArgumentException("O gráfico não tem um titulo valido.");
        }
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        if (!label.isEmpty()) {
            this.label = label;
        } else {
            throw new IllegalArgumentException("O gráfico não tem um Label valido.");
        }
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public int getValue2() {
        return value2;
    }

    public void setValue2(int value2) {
        this.value2 = value2;
    }
    private static final Logger LOG = getLogger(ModelGrafico.class.getName());
}
