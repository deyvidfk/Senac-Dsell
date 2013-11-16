/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.swing.JOptionPane;
import util.ValidaForm;
import pi.model.ModelLogin;

/**
 *
 * @author deyvid.souza
 */
public class CadastrarLogin {

    private boolean creat(ModelLogin login) {
        try {
            if (ValidaForm.isValid(login)) {
                return true;
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            Logger.getLogger(Resource.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
}
