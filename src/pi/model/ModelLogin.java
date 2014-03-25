/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package pi.model;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import static java.util.Collections.unmodifiableList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.annotation.Resource;
import static javax.swing.JOptionPane.showMessageDialog;
import static util.EncriptString.decrypt;
import static util.EncriptString.encrypt;
import util.Regex;
import util.anotacao.RegularExpressionValidator;
import util.anotacao.RequiredValidation;

/**
 *
 * @author deyvid.souza
 */
public class ModelLogin {

    private int id;
    private String username;
    private String pass;
    private String email;
    private List<ModelModuloAcesso> modulo;

    /**
     * @return the username
     * @throws java.security.GeneralSecurityException
     * @throws java.io.UnsupportedEncodingException
     */
    @RequiredValidation(Required = true, label = "Login", MinimumValue = 1, MaximumValue = 20)
    @RegularExpressionValidator(ValidationExpression = Regex.LOGIN_ADM, Label = "Login", RegexErrorMessage = "Login Inválido", EnableErrorMessage = true)
    public String getUsername() throws GeneralSecurityException, UnsupportedEncodingException, IOException {
        return decrypt(this.username);
    }

    /**
     * @param username the username to set
     */
    public void setUsername(String username) {
        try {
            if (username.length() < 20) {

                this.username = encrypt(username);
            } else {
                throw new IllegalArgumentException("Nome de usuário invalido.");
            }
        } catch (GeneralSecurityException | UnsupportedEncodingException | IllegalArgumentException e) {
            showMessageDialog(null, e.getMessage());
            getLogger(Resource.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    /**
     * @return the pass
     * @throws java.security.GeneralSecurityException
     * @throws java.io.UnsupportedEncodingException
     */
    @RequiredValidation(Required = true, label = "Senha", MinimumValue = 1, MaximumValue = 20)
    @RegularExpressionValidator(ValidationExpression = Regex.LOGIN_ADM, Label = "Senha", RegexErrorMessage = "Senha Inválido", EnableErrorMessage = true)
    public String getPass() throws GeneralSecurityException, UnsupportedEncodingException, IOException {
        return decrypt(this.pass);
    }

    /**
     * @param pass the pass to set
     * @throws java.security.GeneralSecurityException
     * @throws java.io.UnsupportedEncodingException
     */
    public void setPass(String pass) throws GeneralSecurityException, UnsupportedEncodingException {
        this.pass = encrypt(pass);
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

    /**
     * @return the modulo
     */
    public List<ModelModuloAcesso> getModulo() {
        return unmodifiableList(modulo);
    }

    /**
     * @param modulo the modulo to set
     */
    public void setModulo(List<ModelModuloAcesso> modulo) {
        this.modulo = modulo;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    private static final Logger LOG = getLogger(ModelLogin.class.getName());

}
