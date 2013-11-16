/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.model;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.swing.JOptionPane;
import util.ExpressaoRegular;
import util.anotacao.RegularExpressionValidator;
import util.anotacao.*;

/**
 *
 * @author deyvid.souza
 */
public class ModelLogin {

    private String username;
    private String pass;
    private String email;

    /**
     * @return the username
     */
    @RequiredValidation(Required = true, label = "Login", MinimumValue = 1, MaximumValue = 20)
    @RegularExpressionValidator(ValidationExpression = ExpressaoRegular.LOGIN_ADM, Label = "Login", RegexErrorMessage = "Login Inválido", EnableErrorMessage = true)
    public String getUsername() {
        return username;
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        try {
            if (username.length() < 20) {
                this.username = username.toString();
            } else {
                throw new IllegalArgumentException("Nome de usuário invalido.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            Logger.getLogger(Resource.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * @return the pass
     */
    @RequiredValidation(Required = true, label = "Senha", MinimumValue = 1, MaximumValue = 20)
    @RegularExpressionValidator(ValidationExpression = ExpressaoRegular.LOGIN_ADM, Label = "Senha", RegexErrorMessage = "Senha Inválido", EnableErrorMessage = true)
    public String getPass() {
        return pass;
    }

    /**
     * @param pass the pass to set
     */
    public void setPass(String pass) {
        this.pass = pass;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }
}
