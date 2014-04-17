package com.senac.pi.model;

import static java.util.Collections.unmodifiableList;
import java.util.List;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import com.senac.pi.views.system.Menu;

public class ModelModuloAcesso {

    private String idUser;
    private int flag;
    private List<Menu> modulo;

    /**
     * @return the flag
     */
    public int getFlag() {
        return flag;
    }

    /**
     * @param flag the flag to set
     */
    public void setFlag(int flag) {
        this.flag = flag;
    }

    /**
     * @return the idUser
     */
    public String getIdUser() {
        return idUser;
    }

    /**
     * @param idUser the idUser to set
     */
    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    /**
     * @return the modulo
     */
    public List<Menu> getModulo() {
        return unmodifiableList(modulo);
    }

    /**
     * @param modulo the modulo to set
     */
    public void setModulo(List<Menu> modulo) {
        this.modulo = modulo;
    }
    private static final Logger LOG = getLogger(ModelModuloAcesso.class.getName());

}
