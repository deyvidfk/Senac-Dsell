package pi.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.annotation.Resource;
import static javax.swing.JOptionPane.showMessageDialog;
import pi.dao.DaoLogin;
import pi.model.ModelLogin;
import static util.ValidaForm.isValid;

public class CadastrarLogin extends DaoLogin {

    public boolean creat(ModelLogin login) {
        try {
            if (isValid(login)) {
                List list = new ArrayList<>();
                list.add(login);
                DaoLogin dao = new DaoLogin();
                dao.createXml(list);
                return true;
            }
        } catch (Exception e) {
            showMessageDialog(null, e.getMessage());
            getLogger(Resource.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }

    public ModelLogin autenticaLogin(String username, String pass) {
        try {
            for (int i = 0; i < getLogin().size(); i++) {
                if (getLogin().get(i).getUsername().equals(username) && getLogin().get(i).getPass().equals(pass)) {
                    return getLogin().get(i);
                }
            }
        } catch (IOException | GeneralSecurityException e) {
        }
        return null;
    }
    private static final Logger LOG = getLogger(CadastrarLogin.class.getName());
}
