package pi.controller;

import java.io.UnsupportedEncodingException;
import java.lang.reflect.InvocationTargetException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import util.ValidaForm;
import pi.model.ModelLogin;
import pi.views.system.FrmMDI;
import pi.views.system.Menu;

/**
 *
 * @author deyvid.souza
 */
public class Login {

    public boolean LoginAuthentication(String username, String pass) {
        ModelLogin login = new ModelLogin();
        login.setUsername(username);
        try {
            login.setPass(pass);
        } catch (GeneralSecurityException | UnsupportedEncodingException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (ValidaForm.isValid(login)) {
            try {
                List menus = new ArrayList<Menu>();
                menus.add(Menu.CADASTRO_GERAL);
                menus.add(Menu.RELATORIO_GERAL);
                menus.add(Menu.SISTEMA);
                FrmMDI fMdi = new FrmMDI((ArrayList) menus);
            } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | IllegalArgumentException | InvocationTargetException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }
            return true;
        }
        return false;
    }
}
