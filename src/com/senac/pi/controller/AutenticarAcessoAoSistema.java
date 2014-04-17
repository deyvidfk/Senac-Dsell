package com.senac.pi.controller;

import java.io.IOException;
import java.security.GeneralSecurityException;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.annotation.Resource;
import static javax.swing.JOptionPane.showMessageDialog;
import com.senac.pi.model.ModelLogin;

public class AutenticarAcessoAoSistema {

    private final CadastrarLogin login;

    public AutenticarAcessoAoSistema() {
        this.login = new CadastrarLogin();
    }

    public ModelLogin autenticaLogin(String username, String pass) {

        try {
            for (int i = 0; i < login.getLogin().size(); i++) {
                if (login.getLogin().get(i).getUsername().equals(username) && login.getLogin().get(i).getPass().equals(pass)) {
                    return login.getLogin().get(i);
                }
            }
        } catch (IOException | GeneralSecurityException e) {
            showMessageDialog(null, e.getMessage());
            getLogger(Resource.class.getName()).log(Level.SEVERE, null, e);
        }
        return null;
    }
    private static final Logger LOG = getLogger(CadastrarLogin.class.getName());
}
