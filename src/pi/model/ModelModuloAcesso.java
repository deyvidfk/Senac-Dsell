/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.model;

import static java.util.Collections.unmodifiableList;
import java.util.List;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import pi.views.system.Menu;

/**
 *
 * @author User-001
 */
public class ModelModuloAcesso {

    private int idUser;
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
    public int getIdUser() {
        return idUser;
    }

    /**
     * @param idUser the idUser to set
     */
    public void setIdUser(int idUser) {
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
