package pi.controller.seguranca;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import pi.dao.DaoModuloAcesso;
import pi.model.ModelModuloAcesso;
import pi.views.system.Menu;

public class ModuloAcesso {

    public void addModuloAcesso(int idUser, List menu) {
        List<ModelModuloAcesso> list;
        list = new ArrayList<>();

        ModelModuloAcesso moduloAcesso = new ModelModuloAcesso();
        moduloAcesso.setFlag(1);
        moduloAcesso.setModulo(menu);
        moduloAcesso.setIdUser(idUser);
        list.add(moduloAcesso);

        DaoModuloAcesso dao = new DaoModuloAcesso();
        dao.createXml(list);
    }

    protected List getModuloAcesso(int idUser) {
        DaoModuloAcesso dao = new DaoModuloAcesso();
        List<ModelModuloAcesso> menus;
        menus = (List<ModelModuloAcesso>) dao.readXml();

        for (ModelModuloAcesso moduloAcesso : menus) {
            if (moduloAcesso.getIdUser() == idUser) {
                return moduloAcesso.getModulo();
            }
        }
        return getModuloAcessoDefault();
    }

    protected List getModuloAcessoDefault() {
        List menus = new ArrayList<>();
        menus.add(Menu.SISTEMA);
        return menus;
    }
    private static final Logger LOG = getLogger(ModuloAcesso.class.getName());
}
