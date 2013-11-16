package util;

import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Resource;
import javax.swing.JOptionPane;

/**
 *
 * @author deyvid.souza
 */
public class ExpressaoRegular {

    /**
     * * String qualquer caractere é aceito
     */
    public static final String QualquerCaractere = "^([^<]|<[^>]*$)*$";
    /**
     * * CPF: 223.185.357-44
     */
    public static final String CPF = "^\\d{3}\\.?\\d{3}\\.?\\d{3}\\-?\\d{2}$";
    /**
     * * RG
     */
    public static final String RG = "^\\d{1,3}.\\d{3}.\\d{3}-[a-zA-Z0-9]$";
    /**
     * * CNPJ
     */
    public static final String CNPJ = "^\\d{3}.?\\d{3}.?\\d{3}/?\\d{3}-?\\d{2}$";
    /**
     * * CEP
     */
    public static final String CEP = "^\\d{5}-\\d{3}$";
    /**
     * TELEFONE: Formato do telefone aceito: (99) 99999-9999 Outro formato
     * aceito: (99) 9999-9999
     */
    public static final String TELEFONE = "^(\\([0-9]{2}\\))\\s([9]{1})?([0-9]{4})-([0-9]{4})$";
    /**
     * * Número: 0,1,2,3,4,5,6,7,8,9,
     */
    public static final String NUMERO_DECIMAL = "^[0-9]+$";
    /**
     * * E-MAIL: EXEMPLO@EXEMPLO.COM
     */
    public static final String EMAIL = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
    /**
     * * Hora:Minuto
     */
    public static final String HORA = "([01]\\d|2[0-3]):[0-5]\\d";
    /**
     * * Hora:Minuto:Segundo
     */
    public static final String HORA_E_SEGUNDOS = "([01]\\d|2[0-3]):[0-5]\\d:[0-5]\\d";
    /**
     * * MOEDA: REAL R$
     */
    public static final String MOEDA_RS = "^\\d*[0-9](,\\d*[0-9])?$";
    /**
     * * MOEDA: DOLAR U$
     */
    public static final String MOEDA_US = "^\\d*[0-9](\\.\\d*[0-9])?$";
    /**
     * * Valida datas no formato mm/dd/yyyy ou mm-dd-yyyy
     */
    public static final String DATA = "^(((((((0?[13578])|(1[02]))[.-/]?((0?[1-9])|([12]d)|(3[01])))|(((0?[469])|(11))[.-/]?((0?[1-9])|([12]d)|(30)))|((0?2)[.-/]?((0?[1-9])|(1d)|(2[0-8]))))[.-/]?(((19)|(20))?([d][d]))))|((0?2)[.-/]?(29)[.-/]?(((19)|(20))?(([02468][048])|([13579][26])))))$";
    /**
     * * Corresponde a qualquer palavra ou frase na lista a seguir. adm admin
     */
    public static final String LOGIN_ADM = "(\\W|^)(adm|admin|)(\\W|$)";

    public static boolean TestarRegex(String expressao, String str) {
        try {
            boolean isValid = false;
            if (str != null && str.length() > 0) {
                Pattern pattern = Pattern.compile(expressao, Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(str);
                if (matcher.matches()) {
                    isValid = true;
                }
            }
            return isValid;
        } catch (Exception e) {
              JOptionPane.showMessageDialog(null, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(Resource.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
}
