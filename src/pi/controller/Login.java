package pi.controller;

import util.ValidaForm;
import pi.model.ModelLogin;
import pi.views.system.FrmMDI;

/**
 *
 * @author deyvid.souza
 */
public class Login {

    public boolean LoginAuthentication(String username, String pass) {
        ModelLogin login = new ModelLogin();
        login.setUsername(username);
        login.setPass(pass);
        if (ValidaForm.isValid(login)) {
            FrmMDI mdi = new FrmMDI();
            return true;
        }
        return false;
    }
}
