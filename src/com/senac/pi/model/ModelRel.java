package com.senac.pi.model;

import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;

public class ModelRel {

    private String trimestre;
    private double rendimento;

    public String getTrimestre() {
        return trimestre;
    }

    public void setTrimestre(String trimestre) {
        this.trimestre = trimestre;
    }

    public double getRendimento() {
        return rendimento;
    }

    public void setRendimento(double rendimento) {
        this.rendimento = rendimento;
    }
    private static final Logger LOG = getLogger(ModelRel.class.getName());
}
