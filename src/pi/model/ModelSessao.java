package pi.model;

import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;

public class ModelSessao {

    private String idSessao;
    private ModelPessoaFisica user;
    private String hora;

    /**
     * @return the idSessao
     */
    public String getIdSessao() {
        return idSessao;
    }

    /**
     * @param idSessao the idSessao to set
     */
    public void setIdSessao(String idSessao) {
        this.idSessao = idSessao;
    }

    /**
     * @return the user
     */
    public ModelPessoaFisica getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(ModelPessoaFisica user) {
        this.user = user;
    }

    /**
     * @return the hora
     */
    public String getHora() {
        return hora;
    }

    /**
     * @param hora the hora to set
     */
    public void setHora(String hora) {
        this.hora = hora;
    }
    private static final Logger LOG = getLogger(ModelSessao.class.getName());
}
