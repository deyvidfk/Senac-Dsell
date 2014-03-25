package util;

import java.util.logging.Level;
import java.util.logging.Logger;
import static java.util.logging.Logger.getLogger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import static java.util.regex.Pattern.compile;
import javax.annotation.Resource;
import javax.swing.JOptionPane;
import static javax.swing.JOptionPane.showMessageDialog;

/**
 *
 * @author deyvid.souza
 */
public class RegexTest {

    public static boolean TestarRegex(Regex expressao, String str) {
        try {
            boolean isValid = false;
            if (str != null && str.length() > 0) {
                Pattern pattern = compile(expressao.getExpressao(), Pattern.CASE_INSENSITIVE);
                Matcher matcher = pattern.matcher(str);
                if (matcher.matches()) {
                    isValid = true;
                }
            }
            return isValid;
        } catch (Exception e) {
            showMessageDialog(null, e.getMessage(), null, JOptionPane.ERROR_MESSAGE);
            getLogger(Resource.class.getName()).log(Level.SEVERE, null, e);
        }
        return false;
    }
    private static final Logger LOG = getLogger(RegexTest.class.getName());

    private RegexTest() {
    }
}
