package pi.controller.seguranca;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import static pi.dao.DaoLogin.getLogin;
import pi.model.ModelLogin;

public class AutenticaLogin {

    public AutenticaLogin() {
    }

    public ModelLogin validaDadosDeAcesso(String username, String pass) throws GeneralSecurityException, UnsupportedEncodingException {
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
    private static final Logger LOG = getLogger(AutenticaLogin.class.getName());
}
