package util;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;
import static util.RegexTest.TestarRegex;
import util.anotacao.RegularExpressionValidator;
import util.anotacao.RequiredValidation;

/**
 *
 * @author deyvid.souza
 */
public class ValidaForm {

    /**
     * A Classe faz a validação dos dados, como por exemplo, E-mail, RG, CPF,
     * CNPJ. Para isso e necessário passar como parâmetro um objeto, fazendo uso
     * das anotações de validação na classe do objeto.
     *
     * Exemplo:
     *
     * Class Pessoa {
     *
     * @RegularExpressionValidator(ValidationExpression = RegexTest.EMAIL, Label
     * = "E-mail", RegexErrorMessage = "E-mail Inválido", EnableErrorMessage =
     * true) public String getEmail() { return email; } }
     */
    public static boolean isValid(Object obj) {
        Class<?> classe = obj.getClass();
        boolean check = true;

        for (Method m : classe.getDeclaredMethods()) {

            //Annotation @RequiredValidation
            if (m.isAnnotationPresent(RequiredValidation.class)) {
                try {

                    RequiredValidation annotation = m.getAnnotation(RequiredValidation.class);
                    if (annotation.Required() == true) {
                        Object object = m.invoke(obj);
                        if (object.toString().isEmpty()) {
                            throw new IllegalArgumentException("O campo " + annotation.label() + " é obrigatorio.");
                        } else if (m.isAnnotationPresent(RegularExpressionValidator.class) == false) {
                            if (object.toString().length() < annotation.MinimumValue()) {
                                throw new IllegalArgumentException("O valor mínimo de caracteres permitido para o campo " + annotation.label() + " é " + annotation.MinimumValue());
                            }
                            if (object.toString().length() > annotation.MaximumValue()) {
                                throw new IllegalArgumentException("O valor Maximo de caracteres permitido para o campo" + annotation.label() + " é " + annotation.MaximumValue());
                            }
                        }
                    }
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    showMessageDialog(null, e.getMessage(), null, JOptionPane.WARNING_MESSAGE);
                    return false;
                }
            }

            //Annotation @RegularExpressionValidator
            if (m.isAnnotationPresent(RegularExpressionValidator.class)) {
                try {
                    RegularExpressionValidator annotation = m.getAnnotation(RegularExpressionValidator.class);
                    if (!m.getReturnType().getName().equals("void")) {

                        if (annotation.ValidationExpression().equals(obj)) {
                            Object object1 = m.invoke(obj);
                            if (TestarRegex(annotation.ValidationExpression(), object1.toString()) == false) {
                                throw new IllegalArgumentException(annotation.RegexErrorMessage());
                            }
                        }
                    }
                } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                    showMessageDialog(null, e.getMessage(), null, JOptionPane.WARNING_MESSAGE);
                    return false;
                }
            }
        }
        return check;
    }

    public static boolean isValid(String str, boolean requerid, Regex re) {
        if (requerid == true) {
            if (!str.isEmpty()) {
                if (re != null) {
                    return TestarRegex(re, str);
                }
                return true;
            }
            return false;
        } else {
            if (re != null) {
                return TestarRegex(re, str);
            }
            return true;
        }
    }
    private static final Logger LOG = getLogger(ValidaForm.class.getName());

    private ValidaForm() {
    }
}
